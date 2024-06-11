package Services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Dao.dao;
import hotelaria.Servico;

public class ServicoDataDao implements dao<Servico>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\Servico.txt";
    
    public class DaoException extends Exception {
        public DaoException(String message) {
            super(message);
        }
    }
    
    private void verificarOuCriarArquivo() {
        File file = new File(CAMINHO);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new DaoException("Erro ao criar ou verificar arquivo."); //  lida com erros relacionados a operações de acesso a dados, como ler ou gravar arquivos.
            }
        }
    }
    
    public boolean cadastrar(Servico servico) {
    	verificarOuCriarArquivo();
        if (consultar(servico) != null) {
            System.out.println("Servico já cadastrado.");
            return false;
        } 
        else {
        	System.out.println("Servico cadastrado com sucesso!");
        }
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(servico.getCodigo() + ", " + servico.getDescricao() + ", " + servico.getValor());
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Servico consultar(Servico servico) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

               
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == servico.getCodigo()) {
                    if (data.length >= 2 && data[1].trim().equals(servico.getDescricao())) {
                        if (data.length >= 3 && Double.parseDouble(data[2].trim()) == servico.getValor()) {
                            return servico;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean editar(Servico servico) {
        if (consultar(servico) != null) {
            System.out.println("Serviço encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("Serviço não encontrado.");
            return false; 
        }

        // Arquivo temporário
        String tempFile = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\temp.txt";
        boolean houveEdicao = false;

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(tempFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             Scanner scanner = new Scanner(System.in)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se os dados do serviço no arquivo correspondem aos dados do serviço que está sendo editado
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == servico.getCodigo()) { 
                    if (data.length >= 3 && Double.parseDouble(data[2].trim()) == servico.getValor()) { 
                        
                        System.out.println("Novo código:");
                        int novoCodigo = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("Nova descrição:");
                        String novaDescricao = scanner.nextLine().trim();
                        System.out.println("Novo valor:");
                        double novoValor = Double.parseDouble(scanner.nextLine().trim());

                        // Edita as informações
                        bufferedWriter.write(novoCodigo + ", " + novaDescricao + ", " + novoValor);
                        bufferedWriter.newLine();
                        houveEdicao = true;
                    } else {
                        // Mantém a linha original no arquivo temporário
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                } else {
                    // Mantém a linha original no arquivo temporário
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Substitui o arquivo original pelo temporário
        File originalFile = new File(CAMINHO);
        File temp = new File(tempFile);
        if (originalFile.delete() && temp.renameTo(originalFile)) {
            System.out.println("Edição concluída com sucesso.");
        } else {
            System.out.println("Falha ao editar o serviço.");
        }

        return houveEdicao;
    }

    
    public ArrayList<Servico> listar(Servico servico) {
        ArrayList<Servico> servicos = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Serviços:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                int codigo = Integer.parseInt(data[0].trim());
                String descricao = data[1].trim();
                double valor = Double.parseDouble(data[2].trim());

                Servico novoServico = new Servico(codigo, descricao, valor);
                servicos.add(novoServico);

                // Exibir cada serviço com numeração
                System.out.println(contador + " - Código: " + novoServico.getCodigo() + ", Descrição: " + novoServico.getDescricao() + ", Valor: " + novoServico.getValor());
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return servicos;
    }
}

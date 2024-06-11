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
import hotelaria.Funcionario;

public class FuncionarioDataDao implements dao<Funcionario>{
    private static final String CAMINHO = "db\\Funcionario.txt";
    
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
    
    public boolean cadastrar(Funcionario funcionario) {
        verificarOuCriarArquivo();
        if (consultar(funcionario) != null) {
            System.out.println("Funcionário já cadastrado.");
            return false;
        } 

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(funcionario.getNome() + ", " + funcionario.getEmail() + ", " + funcionario.getCpf() + ", " + funcionario.getSetor());
            bufferedWriter.newLine();
            bufferedWriter.close();    
            System.out.println("Funcionário cadastrado com sucesso!");
            return true; 
        } catch(IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    
    public Funcionario consultar(Funcionario funcionario) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                // Verifica se o CPF do funcionário consultado está presente na linha
                if (data.length >= 3 && data[2].trim().equals(funcionario.getCpf())) { 
                    return new Funcionario(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





    public boolean editar(Funcionario funcionario) {
        if (consultar(funcionario) != null) {
            System.out.println("Funcionário encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("Funcionário não encontrado.");
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

                // Verifica se os dados do funcionário no arquivo correspondem aos dados do funcionário que está sendo editado
                if (data.length >= 3 && data[2].trim().equals(funcionario.getCpf()) && 
                    data.length >= 4 && data[3].trim().equals(funcionario.getNome())) { 
                    
                    System.out.println("Novo CPF:");
                    String novoCPF = scanner.nextLine().trim();
                    System.out.println("Novo nome:");
                    String novoNome = scanner.nextLine().trim();
                    System.out.println("Novo email:");
                    String novoEmail = scanner.nextLine().trim();
                    System.out.println("Novo setor:");
                    String novoSetor = scanner.nextLine().trim();

                    // Edita as informações
                    bufferedWriter.write(data[0] + ", " + data[1] + ", " + novoCPF + ", " + novoNome + ", " + novoEmail + ", " + novoSetor);
                    bufferedWriter.newLine();
                    houveEdicao = true;
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
            System.out.println("Falha ao editar o funcionário.");
        }

        return houveEdicao;
    }
    
    public ArrayList<Funcionario> listar(Funcionario funcionario) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Funcionarios:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                String nome = data[0].trim();
                String email = data[1].trim();
                String cpf = data[2].trim();
                String setor = data[3].trim();

                Funcionario novoFuncionario = new Funcionario(nome, email, cpf, setor);
                funcionarios.add(novoFuncionario);

                // Exibir cada funcionário com numeração
                System.out.println(contador + " - Nome: " + novoFuncionario.getNome() + ", Email: " + novoFuncionario.getEmail() + ", CPF: " + novoFuncionario.getCpf() + ", Setor: " + novoFuncionario.getSetor() + "\n");
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

}

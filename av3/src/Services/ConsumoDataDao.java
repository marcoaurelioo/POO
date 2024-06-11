package Services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import hotelaria.Item;
import hotelaria.Reserva;
import Dao.dao;
import hotelaria.CategoriaItem;
import hotelaria.Categoria;
import hotelaria.Consumo;
import hotelaria.Hospede;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConsumoDataDao implements dao<Consumo>{
    private static final String CAMINHO = "db\\Consumo.txt";
    
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
    
    public boolean cadastrar(Consumo consumo) {
        verificarOuCriarArquivo();
        
        if (consultar(consumo) != null) {
            System.out.println("Consumo já cadastrado.");
            return false;
        } else {
            System.out.println("Consumo cadastrado com sucesso!");
        }
        
        try (FileWriter fileWriter = new FileWriter(CAMINHO, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            bufferedWriter.write(consumo.getItem().getDescricao() + ", " + consumo.getReserva().getCodigo() + ", " + consumo.getQuantidadeSolicitada() + ", " + consumo.getDataConsumo());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Consumo consultar(Consumo consumo) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                // Certifique-se de que há dados suficientes para criar um objeto Consumo
                if (data.length >= 4) {
                    String descricaoItem = data[0].trim(); // Aqui é a descrição do item
                    int codigoReserva = Integer.parseInt(data[1].trim());
                    int quantidade = Integer.parseInt(data[2].trim());
                    String dataConsumo = data[3].trim();

                    // Verifica se os dados do Consumo no arquivo correspondem aos dados do Consumo que está sendo consultado
                    if (descricaoItem.equals(consumo.getItem().getDescricao()) && codigoReserva == consumo.getReserva().getCodigo()) { 
                        return consumo;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean editar(Consumo consumo) {
        if (consultar(consumo) != null) {
            System.out.println("Consumo encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("Consumo não encontrado.");
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

                // Verifica se os dados do consumo no arquivo correspondem aos dados do consumo que está sendo editado
                if (data.length >= 4 && data[0].trim().equals(Integer.toString(consumo.getItem().getCodigo())) &&
                    data.length >= 5 && data[1].trim().equals(Integer.toString(consumo.getReserva().getCodigo()))) { 

                    System.out.println("Novos dados do consumo:");

                    System.out.println("Nova quantidade:");
                    int novaQuantidade = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Nova data de consumo:");
                    String novaDataConsumo = scanner.nextLine().trim();

                    // Edita as informações
                    bufferedWriter.write(consumo.getItem().getCodigo() + ", " + consumo.getReserva().getCodigo() + ", " + novaQuantidade + ", " + novaDataConsumo);
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
            System.out.println("Falha ao editar o consumo.");
        }

        return houveEdicao;
    }

    public ArrayList<Consumo> listar(Consumo consumo) {
        ArrayList<Consumo> consumos = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Consumos:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");


                String descricaoItem = data[0].trim();
                int codigoReserva = Integer.parseInt(data[1].trim());
                int quantidade = Integer.parseInt(data[2].trim());
               

                Item item = new Item(descricaoItem); 
                Reserva reserva = new Reserva(codigoReserva); 

                Consumo novoConsumo = new Consumo(item, reserva, quantidade, null);
                consumos.add(novoConsumo);

                System.out.println(contador + " - Descrição do Item: " + descricaoItem + ", Código da Reserva: " + codigoReserva +
                        ", Quantidade: " + quantidade);

                contador++;
            }
        } catch (IOException  | NumberFormatException e) {
            e.printStackTrace();
        }

        return consumos;
    }


    
}

package Services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Dao.dao;
import hotelaria.ConsumoServico;
import hotelaria.Hospede;
import hotelaria.Reserva;
import hotelaria.Servico;


public class ConsumoServicoDataDao implements dao<ConsumoServico>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\ConsumoServico.txt";
    
    private void verificarOuCriarArquivo() {
        File file = new File(CAMINHO);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean cadastrar(ConsumoServico consumoServico) {
        verificarOuCriarArquivo();
        if (consultar(consumoServico) != null) {
            System.out.println("Consumo de Servico já cadastrado.");
            return false;
        } 
        else {
        	System.out.println("Consumo de Servico cadastrado com sucesso!");
        }
        
        try (FileWriter fileWriter = new FileWriter(CAMINHO, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            bufferedWriter.write(consumoServico.getReserva().getCodigo() + ", " +
                                 consumoServico.getServico().getCodigo() + ", " +
                                 consumoServico.getQuantidadeSolicitada() + ", " +
                                 consumoServico.getDataServico().toString());
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ConsumoServico consultar(ConsumoServico consumoServico) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == consumoServico.getReserva().getCodigo()) { 
                    return consumoServico;
                }                    
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean editar(ConsumoServico consumoServico) {
        if (consultar(consumoServico) != null) {
            System.out.println("Consumo de Serviço encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("Consumo de Serviço não encontrado.");
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

                // Verifica se os dados do consumo de serviço no arquivo correspondem aos dados do consumo de serviço que está sendo editado
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == consumoServico.getReserva().getCodigo()) { 
                    
                    System.out.println("Novo código da reserva:");
                    int novoCodigoReserva = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Novo código do serviço:");
                    int novoCodigoServico = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Nova quantidade solicitada:");
                    int novaQuantidade = Integer.parseInt(scanner.nextLine().trim());

                   
                    System.out.println("Nova data (dd/MM/yyyy):");
                    String novaDataStr = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date novaData = null;
                    try {
                        novaData = dateFormat.parse(novaDataStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // Edita as informações
                    bufferedWriter.write(novoCodigoReserva + ", " +
                                         novoCodigoServico + ", " +
                                         novaQuantidade + ", " +
                                         novaData);
                    bufferedWriter.newLine();
                    houveEdicao = true;
                } else {
                    // Mantém a linha original no arquivo temporário
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Substitui o arquivo original pelo temporário
        File originalFile = new File(CAMINHO);
        File temp = new File(tempFile);
        if (originalFile.delete() && temp.renameTo(originalFile)) {
            System.out.println("Edição do Consumo de Serviço concluída com sucesso.");
        } else {
            System.out.println("Falha ao editar o Consumo de Serviço.");
        }

        return houveEdicao;
    }
    
    public ArrayList<ConsumoServico> listar(ConsumoServico consumoServico) {
        ArrayList<ConsumoServico> consumos = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Consumo de Serviços:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                int codigoReserva = Integer.parseInt(data[0].trim());
                String descricaoServico = data[1].trim();
                int quantidadeSolicitada = Integer.parseInt(data[2].trim());

                // Criar objeto ConsumoServico com as informações lidas
                Reserva novaReserva = new Reserva(codigoReserva);
                Servico novoServico = new Servico(0, descricaoServico, 0.0); // Construtor que aceita a descrição
                ConsumoServico novoConsumo = new ConsumoServico(novoServico, novaReserva, quantidadeSolicitada, null); 

                consumos.add(novoConsumo);

                // Exibir cada consumo de serviço com numeração
                System.out.println(contador + " - Descrição do Serviço: " + descricaoServico + 
                                   ", Código da Reserva: " + codigoReserva + 
                                   ", Quantidade Solicitada: " + quantidadeSolicitada);

                contador++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return consumos;
    }




    
}

package Services;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.dao;
import hotelaria.Reserva;

import hotelaria.Hospede;

import hotelaria.Funcionario;


public class ReservaDataDao implements dao<Reserva>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\Reserva.txt";
    
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
    
    public boolean cadastrar(Reserva reserva) {
    	verificarOuCriarArquivo();
        if (consultar(reserva) != null) {
            System.out.println("Reserva já cadastrada.");
            return false;
        } 
        else {
        	System.out.println("Reserva cadastrada com sucesso!");
        }
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(reserva.getCodigo() + ", " + reserva.getHospede().getNome() + ", " + reserva.getQuarto().getCodigo() + ", " + reserva.getFuncionarioReserva().getNome() 
            		+ ", " + reserva.getFuncionarioFechamento().getNome() + ", " + reserva.getDataEntradaReserva() + ", " +  reserva.getDataSaidaReserva()
            		+ ", " + reserva.getDataCheckin() + ", " + reserva.getDataCheckout() + ", " + reserva.getValorReserva() + ", " + reserva.getValorPago() );
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Reserva consultar(Reserva reserva) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == reserva.getCodigo()) { 
                    return reserva;
                }                    
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean editar(Reserva reserva) {
        if (consultar(reserva) != null) {
            System.out.println("Reserva encontrada. Prosseguindo com a edição...");
        } else {
            System.out.println("Reserva não encontrada.");
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

                // Verifica se os dados da reserva no arquivo correspondem aos dados da reserva que está sendo editada
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == reserva.getCodigo()) {

                    System.out.println("Novo código:");
                    int novoCodigo = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.println("Novo nome do hóspede:");
                    String novoNomeHospede = scanner.nextLine().trim();

                    System.out.println("Novo código do quarto:");
                    int novoCodigoQuarto = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.println("Novo nome do funcionário de reserva:");
                    String novoNomeFuncionarioReserva = scanner.nextLine().trim();

                    System.out.println("Novo nome do funcionário de fechamento:");
                    String novoNomeFuncionarioFechamento = scanner.nextLine().trim();

                    // Entrada da nova data de entrada
                    System.out.println("Nova data de entrada (dd/MM/yyyy):");
                    String novaDataEntradaStr = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date novaDataEntrada = null;
                    try {
                        novaDataEntrada = dateFormat.parse(novaDataEntradaStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // Entrada da nova data de saída
                    System.out.println("Nova data de saída (dd/MM/yyyy):");
                    String novaDataSaidaStr = scanner.nextLine();
                    Date novaDataSaida = null;
                    try {
                        novaDataSaida = dateFormat.parse(novaDataSaidaStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // Entrada da nova data de check-in
                    System.out.println("Nova data de check-in (dd/MM/yyyy):");
                    String novaDataCheckinStr = scanner.nextLine();
                    Date novaDataCheckin = null;
                    try {
                        novaDataCheckin = dateFormat.parse(novaDataCheckinStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // Entrada da nova data de checkout
                    System.out.println("Nova data de checkout (dd/MM/yyyy):");
                    String novaDataCheckoutStr = scanner.nextLine();
                    Date novaDataCheckout = null;
                    try {
                        novaDataCheckout = dateFormat.parse(novaDataCheckoutStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Novo valor da reserva:");
                    double novoValorReserva = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.println("Novo valor pago:");
                    double novoValorPago = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer

                    // Edita as informações
                    bufferedWriter.write(novoCodigo + ", " + novoNomeHospede + ", " + novoCodigoQuarto + ", " + novoNomeFuncionarioReserva
                            + ", " + novoNomeFuncionarioFechamento + ", " + novaDataEntrada + ", " + novaDataSaida
                            + ", " + novaDataCheckin + ", " + novaDataCheckout + ", " + novoValorReserva + ", " + novoValorPago);
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
            System.out.println("Falha ao editar a reserva.");
        }

        return houveEdicao;
    }

    public ArrayList<Reserva> listar(Reserva reserva) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Reservas:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                int codigo = Integer.parseInt(data[0].trim());
                String nomeHospede = data[1].trim();
                String nomeFuncionarioReserva = data[3].trim();
                double valorReserva = Double.parseDouble(data[9].trim());

                // Verificar se o funcionário de reserva não é nulo
                String nomeFuncionarioReservaDisplay = "";
                if (nomeFuncionarioReserva != null) {
                    nomeFuncionarioReservaDisplay = nomeFuncionarioReserva;
                }

                // Criar objeto Reserva com as informações lidas
                Reserva novaReserva = new Reserva(codigo, new Hospede(nomeHospede, null, null, null), null, null, new Funcionario(nomeFuncionarioReserva, null, null, null), null, null, null, null, valorReserva, 0.0);
                reservas.add(novaReserva);

                // Exibir cada reserva com numeração
                System.out.println(contador + " - Código: " + novaReserva.getCodigo() + ", Nome do Hóspede: " + novaReserva.getHospede().getNome() + ", Nome do Funcionário de Reserva: " + nomeFuncionarioReservaDisplay +
                        ", Valor da Reserva: " + novaReserva.getValorReserva() + "\n");

                contador++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return reservas;
    }

}

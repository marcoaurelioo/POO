package Services;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

import DAO.dao;
import hotelaria.Hospede;

public class HospedeDataDAO implements dao<Hospede>{
	public boolean cadastrar(Hospede hospede) {
	    if (consultar(hospede) != null) {
	        System.out.println("Hóspede já cadastrado.");
	        return false;
	    } 
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("Hospede.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(hospede.getCpf() + ", " + hospede.getNome() + ", " + hospede.getEmail() + ", " + hospede.getEnderecoCompleto());
			bufferedWriter.newLine();
			bufferedWriter.close();	
		} catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Hospede consultar(Hospede hospede) {
	    try (FileReader fileReader = new FileReader("Hospede.txt");
	         BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] data = line.split(","); 

	            if (data.length >= 1 && data[0].trim().equals(hospede.getCpf())) { 
	                if (data.length >= 2 && data[1].trim().equals(hospede.getNome())) { 
	                    return hospede; 
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null; 
	}

	
	public boolean editar(Hospede hospede) {
	    
		if (consultar(hospede) != null) {
		    System.out.println("Hóspede encontrado. Prosseguindo com a edição...");
		    
		} else {
		    System.out.println("Hóspede não encontrado.");
		    return false; 
		}

	    // Arquivo temporário
	    String tempFile = "temp.txt";
	    String filePath = "Hospede.txt";
	    boolean houveEdicao = false;

	    try (FileReader fileReader = new FileReader(filePath);
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         FileWriter fileWriter = new FileWriter(tempFile);
	         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	         Scanner scanner = new Scanner(System.in)) {

	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] data = line.split(",");

	            // Verifica se os dados do hóspede no arquivo correspondem aos dados do hóspede que está sendo editado
	            if (data.length >= 1 && data[0].trim().equals(hospede.getCpf()) && 
	                data.length >= 2 && data[1].trim().equals(hospede.getNome())) { 
	                
	                System.out.println("Novo CPF:");
	                String novoCPF = scanner.nextLine().trim();
	                System.out.println("Novo nome:");
	                String novoNome = scanner.nextLine().trim();
	                System.out.println("Novo email:");
	                String novoEmail = scanner.nextLine().trim();
	                System.out.println("Novo endereço:");
	                String novoEndereco = scanner.nextLine().trim();

	                // Edita as informações
	                bufferedWriter.write(novoCPF + ", " + novoNome + ", " + novoEmail + ", " + novoEndereco);
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
	    File originalFile = new File(filePath);
	    File temp = new File(tempFile);
	    if (originalFile.delete() && temp.renameTo(originalFile)) {
	        System.out.println("Edição concluída com sucesso.");
	    } else {
	        System.out.println("Falha ao editar o hóspede.");
	    }

	    return houveEdicao;
	}
	
	public ArrayList<Hospede> listar(Hospede hospede) {
	    ArrayList<Hospede> hospedes = new ArrayList<>();

	    try (FileReader fileReader = new FileReader("Hospede.txt");
	         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] data = line.split(", ");

	            String cpf = data[0].trim();
	            String nome = data[1].trim();
	            String email = data[2].trim();
	            String endereco = data[3].trim();

	            Hospede novoHospede = new Hospede(cpf, nome, email, endereco);
	            hospedes.add(novoHospede);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return hospedes;
	}


}

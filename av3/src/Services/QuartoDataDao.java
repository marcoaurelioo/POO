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
import hotelaria.Quarto;
import hotelaria.Categoria;

public class QuartoDataDao implements dao<Quarto>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\Quarto.txt";
    
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
    
    public boolean cadastrar(Quarto quarto) {
    	verificarOuCriarArquivo();
        if (consultar(quarto) != null) {
            System.out.println("Quarto já cadastrado.");
            return false;
        } 
        else {
        	System.out.println("Quarto cadastrado com sucesso!");
        }
        
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(quarto.getCodigo() + ", " + quarto.getCategoria().getCodigo() + ", " + quarto.getStatus());
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Quarto consultar(Quarto quarto) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se os dados do quarto no arquivo correspondem aos dados do quarto que está sendo consultado
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == quarto.getCodigo() &&
                    data.length >= 2 && Integer.parseInt(data[1].trim()) == quarto.getCategoria().getCodigo() &&
                    data.length >= 3 && data[2].trim().equals(quarto.getStatus())) { 
                    return quarto;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



public boolean editar(Quarto quarto) {
    if (consultar(quarto) != null) {
        System.out.println("Quarto encontrado. Prosseguindo com a edição...");
    } else {
        System.out.println("Quarto não encontrado.");
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

            // Verifica se os dados do quarto no arquivo correspondem aos dados do quarto que está sendo editado
            if (data.length >= 1 && Integer.parseInt(data[0].trim()) == quarto.getCodigo() &&
                data.length >= 3 && data[2].trim().equals(quarto.getStatus())) { 

                System.out.println("Novo código:");
                int novoCodigo = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("Nova categoria:");
                int novaCategoria = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("Novo status:");
                String novoStatus = scanner.nextLine().trim();

                // Edita as informações
                bufferedWriter.write(novoCodigo + ", " + novaCategoria + ", " + novoStatus);
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
        System.out.println("Falha ao editar o quarto.");
    }

    return houveEdicao;
}

    
public ArrayList<Quarto> listar(Quarto quarto) {
    ArrayList<Quarto> quartos = new ArrayList<>();

    try (FileReader fileReader = new FileReader(CAMINHO);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

        String line;
        int contador = 1;
        System.out.println("Lista de Quartos:");
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(", ");

            int codigo = Integer.parseInt(data[0].trim());
            int codigoCategoria = Integer.parseInt(data[1].trim()); 
            String status = data[2].trim(); 

            // Aqui, você cria um objeto Categoria usando o construtor existente
            Categoria categoria = new Categoria(codigoCategoria, "Descrição", 0.0);
            Quarto novoQuarto = new Quarto(codigo, categoria, status);
            quartos.add(novoQuarto);

            // Exibir cada quarto com numeração
            System.out.println(contador + " - Código: " + novoQuarto.getCodigo() + ", Categoria: " + novoQuarto.getCategoria().getCodigo() + ", Status: " + novoQuarto.getStatus());
            contador++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return quartos;
}


}

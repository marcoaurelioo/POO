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
import hotelaria.Item;

public class ItemDataDao implements dao<Item>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\Item.txt";
    
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
    
    public boolean cadastrar(Item item) {
    	verificarOuCriarArquivo();
        if (consultar(item) != null) {
            System.out.println("Item já cadastrado.");
            return false;
        } 
        else {
        	System.out.println("Item cadastrado com sucesso!");
        }
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(item.getCodigo() + ", " + item.getDescricao() + ", " + item.getValor());
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Item consultar(Item item) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == item.getCodigo()) {
                    if (data.length >= 2 && data[1].trim().equals(item.getDescricao())) {
                        if (data.length >= 3 && Double.parseDouble(data[2].trim()) == item.getValor()) {
                            return item;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean editar(Item item) {
        if (consultar(item) != null) {
            System.out.println("Item encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("Item não encontrado.");
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

                // Verifica se os dados do item no arquivo correspondem aos dados do item que está sendo editado
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == item.getCodigo()) { 
                    if (data.length >= 3 && Double.parseDouble(data[2].trim()) == item.getValor()) { 
                        
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
            System.out.println("Falha ao editar o item.");
        }

        return houveEdicao;
    }

    
    public ArrayList<Item> listar(Item item) {
        ArrayList<Item> itens = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Itens:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                int codigo = Integer.parseInt(data[0].trim());
                String descricao = data[1].trim();
                double valor = Double.parseDouble(data[2].trim());

                Item novoItem = new Item(codigo, descricao, valor);
                itens.add(novoItem);

               
                System.out.println(contador + " - Código: " + novoItem.getCodigo() + ", Descrição: " + novoItem.getDescricao() + ", Valor: " + novoItem.getValor());
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itens;
    }
}

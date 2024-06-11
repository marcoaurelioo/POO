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
import hotelaria.Categoria;

public class CategoriaDataDao implements dao<Categoria>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\Categoria.txt";
    
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
    
    public boolean cadastrar(Categoria categoria) {
    	verificarOuCriarArquivo();
        if (consultar(categoria) != null) {
            System.out.println("Categoria já cadastrada.");
            return false;
        } 
        else {
        	System.out.println("Categoria cadastrada com sucesso!");
        }
        
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(categoria.getCodigo() + ", " + categoria.getDescricao() + ", " + categoria.getValor());
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public Categoria consultar(Categoria categoria) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se os dados da categoria no arquivo correspondem aos dados da categoria que está sendo consultada
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == categoria.getCodigo()) {
                    if (data.length >= 2 && data[1].trim().equals(categoria.getDescricao())) {
                        if (data.length >= 3 && Double.parseDouble(data[2].trim()) == categoria.getValor()) {
                            return categoria;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean editar(Categoria categoria) {
        if (consultar(categoria) != null) {
            System.out.println("Categoria encontrada. Prosseguindo com a edição...");
        } else {
            System.out.println("Categoria não encontrada.");
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

                // Verifica se os dados da categoria no arquivo correspondem aos dados da categoria que está sendo editada
                if (data.length >= 1 && Integer.parseInt(data[0].trim()) == categoria.getCodigo()) { 
                    if (data.length >= 3 && Double.parseDouble(data[2].trim()) == categoria.getValor()) { 
                        
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
            System.out.println("Falha ao editar a categoria.");
        }

        return houveEdicao;
    }

    
    public ArrayList<Categoria> listar(Categoria categoria) {
        ArrayList<Categoria> categorias = new ArrayList<>();

        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int contador = 1;
            System.out.println("Lista de Categorias:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                int codigo = Integer.parseInt(data[0].trim());
                String descricao = data[1].trim();
                double valor = Double.parseDouble(data[2].trim());

                Categoria novaCategoria = new Categoria(codigo, descricao, valor);
                categorias.add(novaCategoria);

                // Exibir cada categoria com numeração
                System.out.println(contador + " - Código: " + novaCategoria.getCodigo() + ", Descrição: " + novaCategoria.getDescricao() + ", Valor: " + novaCategoria.getValor());
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categorias;

    }
}

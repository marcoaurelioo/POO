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
import hotelaria.CategoriaItem;
import hotelaria.Categoria;
import hotelaria.Item;

public class CategoriaItemDataDao implements dao<CategoriaItem>{
    private static final String CAMINHO = "C:\\Users\\Marco Aurélio\\Desktop\\POO\\av3\\src\\db\\CategoriaItem.txt";
    
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
    
    public boolean cadastrar(CategoriaItem categoriaItem) {
    	verificarOuCriarArquivo();
        if (consultar(categoriaItem) != null) {
            System.out.println("Categoria Item já cadastrado.");
            return false;
        } 
        else {
        	System.out.println("Categoria Item cadastrado com sucesso!");
        }
        
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(CAMINHO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(categoriaItem.getItem().getDescricao() + ", " + categoriaItem.getCategoria().getDescricao() + ", " + categoriaItem.getQuantidade());
            bufferedWriter.newLine();
            bufferedWriter.close();    
        } catch(IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public CategoriaItem consultar(CategoriaItem categoriaItem) {
        try (FileReader fileReader = new FileReader(CAMINHO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");

                // Certifique-se de que há dados suficientes para criar um objeto CategoriaItem
                if (data.length >= 3) {
                    String descricaoItem = data[0].trim();
                    String descricaoCategoria = data[1].trim();
                    int quantidade = Integer.parseInt(data[2].trim());

                    // Verifica se os dados do CategoriaItem no arquivo correspondem aos dados do CategoriaItem que está sendo consultado
                    if (descricaoItem.equals(categoriaItem.getItem().getDescricao()) &&
                        descricaoCategoria.equals(categoriaItem.getCategoria().getDescricao()) &&
                        quantidade == categoriaItem.getQuantidade()) {
                        return categoriaItem;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public boolean editar(CategoriaItem categoriaItem) {
        if (consultar(categoriaItem) != null) {
            System.out.println("CategoriaItem encontrado. Prosseguindo com a edição...");
        } else {
            System.out.println("CategoriaItem não encontrado.");
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

                // Verifica se os dados do categoriaItem no arquivo correspondem aos dados do categoriaItem que está sendo editado
                if (data.length >= 3 && data[2].trim().equals(categoriaItem.getItem().getDescricao()) &&
                    data.length >= 4 && data[3].trim().equals(categoriaItem.getCategoria().getDescricao())) { 

                    System.out.println("Novo código:");
                    String novoItem = scanner.nextLine().trim();
                    System.out.println("Nova categoria:");
                    String novaCategoria = scanner.nextLine().trim();
                    System.out.println("Nova quantidade:");
                    int novaQuantidade = Integer.parseInt(scanner.nextLine().trim());

                    // Edita as informações
                    bufferedWriter.write(novoItem + ", " + novaCategoria + ", " + novaQuantidade);
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
            System.out.println("Falha ao editar o categoriaItem.");
        }

        return houveEdicao;
    }




    
public ArrayList<CategoriaItem> listar(CategoriaItem categoriaItem) {
    ArrayList<CategoriaItem> categoriaItems = new ArrayList<>();

    try (FileReader fileReader = new FileReader(CAMINHO);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {
        String line;
        int contador = 1;
        System.out.println("Lista de Categoria Itens:");
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(", ");

            // Certifique-se de que há dados suficientes para criar um objeto CategoriaItem
            if (data.length >= 3) {
                String descricaoItem = data[0].trim();
                String descricaoCategoria = data[1].trim();
                int quantidade = Integer.parseInt(data[2].trim());

                // Crie os objetos Item e Categoria usando apenas as descrições
                Item item = new Item(descricaoItem);
                Categoria categoria = new Categoria(descricaoCategoria);

                // Crie o objeto CategoriaItem
                CategoriaItem novoCategoriaItem = new CategoriaItem(item, categoria, quantidade);
                categoriaItems.add(novoCategoriaItem);

                // Exiba os itens com numeração
                System.out.println(contador + " - Item: " + descricaoItem + ", Categoria: " + descricaoCategoria + ", Quantidade: " + quantidade);
                contador++;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return categoriaItems;
}

}

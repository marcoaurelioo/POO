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
import hotelaria.ConsumoServico;
import hotelaria.Hospede;


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
            System.out.println("Hóspede já cadastrado.");
            return false;
        } else {
            System.out.println("Hóspede cadastrado com sucesso!");
        }
        
        try (FileWriter fileWriter = new FileWriter(CAMINHO, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            bufferedWriter.write(hospede.getCpf() + ", " + hospede.getNome() + ", " + hospede.getEmail() + ", " + hospede.getEnderecoCompleto());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
}

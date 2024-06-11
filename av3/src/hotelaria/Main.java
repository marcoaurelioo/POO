package hotelaria;


import java.util.ArrayList;

import Services.HospedeDataDao;
import Services.FuncionarioDataDao;
import Services.CategoriaDataDao;
import Services.ItemDataDao;
import Services.ServicoDataDao;
import Services.QuartoDataDao;
import Services.CategoriaItemDataDao;

public class Main {

    public static void main(String[] args) {
        FuncionarioDataDao dao = new FuncionarioDataDao();

        // Cadastro de funcionários
        Funcionario funcionario1 = new Funcionario("11111111111", "João", "joao@example.com", "Limpeza");
        Funcionario funcionario2 = new Funcionario("22222222222", "Maria", "maria@example.com", "Recepção");

        dao.cadastrar(funcionario1);
        dao.cadastrar(funcionario2);
        
        dao.listar(funcionario1);

    }

    
   
}

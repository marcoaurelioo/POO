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
        Funcionario funcionario1 = new Funcionario("Maria", "joao@example.com", "11111111111", "Limpeza");

        dao.cadastrar(funcionario1);
        
        
        dao.listar(funcionario1);

    }

}

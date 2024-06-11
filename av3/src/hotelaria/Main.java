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
        CategoriaItemDataDao dao = new CategoriaItemDataDao();

        // Cadastro de itens em categorias
        Categoria categoria1 = new Categoria("Eletrônicos");
        Item item1 = new Item("Smartphone");
        CategoriaItem categoriaItem1 = new CategoriaItem(item1, categoria1, 10);

        dao.cadastrar(categoriaItem1);

        dao.editar(categoriaItem1);

    }

}

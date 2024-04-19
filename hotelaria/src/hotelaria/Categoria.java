package hotelaria;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private float valorCategoria;
    private List<Item> itens;
    private List<ItemFrigobar> itensFrigobar;

    public Categoria(String nome, float valorCategoria) {
        this.nome = nome;
        this.valorCategoria = valorCategoria;
        this.itens = new ArrayList<>();
        this.itensFrigobar = new ArrayList<>();
    }
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }
    
    public void adicionarItemFrigobar(ItemFrigobar itemFrigobar) {
        itensFrigobar.add(itemFrigobar);
    }

    public void removerItemFrigobar(ItemFrigobar itemFrigobar) {
        itensFrigobar.remove(itemFrigobar);
    }

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public List<ItemFrigobar> getItensFrigobar() {
		return itensFrigobar;
	}

	public void setItensFrigobar(List<ItemFrigobar> itensFrigobar) {
		this.itensFrigobar = itensFrigobar;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorCategoria() {
		return valorCategoria;
	}

	public void setValorCategoria(float valorCategoria) {
		this.valorCategoria = valorCategoria;
	}
    
    
}

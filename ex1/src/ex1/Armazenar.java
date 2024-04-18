package ex1;
import java.util.ArrayList;
import java.util.List;


public class Armazenar {
    public List<Produto> produtos;

    public Armazenar() {
        this.produtos = new ArrayList<>();
    }
	

	public void adicionarProdutos(Produto produto) {
		produtos.add(produto);
	}
	
	
	public int contarProdutos50() {
		int cont = 0;
		for(Produto produto : produtos) {
			if(produto.getPeso()>10 && produto.getValor() < 50) {
				cont++;
			}
		}
		return cont;
	}
	
	
	public double mediaPeso() {
		double somaPeso = 0;
		for(Produto produto : produtos) {
			somaPeso += produto.getPeso();
		}
		return somaPeso/produtos.size();
	}
	
	public Produto maisLeve() {
		Produto maisLeve = produtos.get(0);
		for(Produto produto : produtos) {
			if(produto.getPeso()<maisLeve.getPeso()) {
				maisLeve = produto;
			}
		}
		 return maisLeve;
	}
	
	public Produto maiorValor() {
		Produto maiorValor = produtos.get(0);
		for(Produto produto : produtos) {
			if(produto.getValor()>maiorValor.getValor()) {
				maiorValor = produto;
			}
		}
		return maiorValor;
	}
	
	public double maior10(){
		double soma = 0;
		double quantidade10 = 0;
		for(Produto produto : produtos) {
			if(produto.getPeso()>10) {
				soma += produto.getValor();
				quantidade10++;
			}
		}
		return soma/quantidade10;
	}
	
}

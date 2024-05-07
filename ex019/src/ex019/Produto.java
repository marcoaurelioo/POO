package ex019;

public abstract class Produto {
	protected String nome;
	protected double preco;
	protected int garantia;

	
	public Produto(String nome, double preco, int garantia) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.garantia = garantia;
	}

	public abstract double calcularValor(int pagamento);	
}	

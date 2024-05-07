package ex019;

public class Celular extends Produto{
	public boolean carregador;

	public Celular(String nome, double preco, int garantia, boolean carregador) {
		super(nome, preco, garantia);
		this.carregador = carregador;
	}
	
	@Override
	public double calcularValor(int pagamento) {
		double desconto = 0;
		if(carregador && pagamento == 1) {
			desconto = preco * 0.12;
		}
		else if (carregador && pagamento == 2) {
			desconto = preco * 0.1;
		}
		else if (!carregador && pagamento == 1) {
			desconto = preco * 0.07;
		}
		else if (!carregador && pagamento == 2) {
			desconto = 0;
		}
		return desconto;
	}
}

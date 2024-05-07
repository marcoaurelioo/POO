package ex019;

public class Computador extends Produto{
	public boolean impressora;

	public Computador(String nome, double preco, int garantia, boolean impressora) {
		super(nome, preco, garantia);
		this.impressora = impressora;
	}
	
	
	@Override
	public double calcularValor(int pagamento) {
		double desconto = 0;
		if(impressora && pagamento == 1) {
			desconto = preco * 0.1;
		}
		else if (impressora && pagamento == 2) {
			desconto = preco * 0.07;
		}
		else if (!impressora && pagamento == 1) {
			desconto = preco * 0.05;
		}
		else if (!impressora && pagamento == 2) {
			desconto = 0;
		}
		return desconto;
	}
	
	
	
}

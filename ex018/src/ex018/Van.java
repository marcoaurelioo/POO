package ex018;

public class Van extends Veiculo{
	public int assentos;
	public double peso;

	public Van(boolean corMetalica, double valorFabricacao, int quantidadeDisponivel, int assentos, double peso) {
		super(corMetalica, valorFabricacao, quantidadeDisponivel);
		this.assentos = assentos;
		this.peso = peso;
	}

	@Override
	public double valorVenda() {
		double valorVenda = 0;
		if(assentos <7 && peso <1000) {
			valorVenda = valorFabricacao * 1.12;
		}
		else if(assentos <7 && peso >=1000) {
			valorVenda = valorFabricacao * 1.19;
		}
		else if(assentos >=7 && peso <1000) {
			valorVenda = valorFabricacao * 1.35;
		}
		else if(assentos >=7 && peso >=1000) {
			valorVenda = valorFabricacao * 1.47;
		}
		return valorVenda;
	}
	
}

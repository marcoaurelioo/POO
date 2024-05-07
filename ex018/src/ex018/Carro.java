package ex018;

public class Carro extends Veiculo{
	public int quantidadePortas;
	public boolean cambioAutomatico;
	
	public Carro(boolean corMetalica, double valorFabricacao, int quantidadeDisponivel, int quantidadePortas,
			boolean cambioAutomatico) {
		super(corMetalica, valorFabricacao, quantidadeDisponivel);
		this.quantidadePortas = quantidadePortas;
		this.cambioAutomatico = cambioAutomatico;
	}
	
	@Override
	public double valorVenda() {
		double valorVenda = 0;
		if(quantidadePortas == 2 && !cambioAutomatico) {
			valorVenda = valorFabricacao * 1.17;
		}
		else if(quantidadePortas == 2 && cambioAutomatico) {
			valorVenda = valorFabricacao * 1.35;
		}
		else if(quantidadePortas == 4 && !cambioAutomatico) {
			valorVenda = valorFabricacao * 1.31;
		}
		else if(quantidadePortas == 4 && cambioAutomatico) {
			valorVenda = valorFabricacao * 1.55;
		}
		return valorVenda;
	}
	
}

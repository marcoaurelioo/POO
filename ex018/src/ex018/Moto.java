package ex018;

public class Moto extends Veiculo{
	public int cilindradas;

	public Moto(boolean corMetalica, double valorFabricacao, int quantidadeDisponivel, int cilindradas) {
		super(corMetalica, valorFabricacao, quantidadeDisponivel);
		this.cilindradas = cilindradas;
	}
	
	@Override
	public double valorVenda() {
		double valorVenda = 0;
		if(cilindradas <500 && !corMetalica) {
			valorVenda = valorFabricacao * 1.05;
		}
		else if(cilindradas <500 && corMetalica) {
			valorVenda = valorFabricacao * 1.11;
		}
		else if(cilindradas >=500 && !corMetalica) {
			valorVenda = valorFabricacao * 1.25;
		}
		else if(cilindradas >=500 && corMetalica) {
			valorVenda = valorFabricacao * 1.27;
		}
		return valorVenda;
	}
}

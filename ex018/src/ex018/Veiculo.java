package ex018;

public abstract class Veiculo {
	protected boolean corMetalica;
	protected double valorFabricacao;
	protected int quantidadeDisponivel;
	
	public Veiculo(boolean corMetalica, double valorFabricacao, int quantidadeDisponivel) {
		this.corMetalica = corMetalica;
		this.valorFabricacao = valorFabricacao;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
	public abstract double valorVenda();
	
    public double valorSeguro() {
        return valorVenda() * 0.05;
    }
}

package ex016;

public abstract class Imovel {
	protected double area;
	protected int quantidadeQuartos;
	protected double precoCompra;
	
	public Imovel(double area, int quantidadeQuartos, double precoCompra) {
		super();
		this.area = area;
		this.quantidadeQuartos = quantidadeQuartos;
		this.precoCompra = precoCompra;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	public abstract double calcularPrecoVenda();
	
}

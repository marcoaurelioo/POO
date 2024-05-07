package ex016;

public class Apartamento extends Imovel{
	private boolean piscina;

	public Apartamento(double area, int quantidadeQuartos, double precoCompra, boolean piscina) {
		super(area, quantidadeQuartos, precoCompra);
		this.piscina = piscina;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	
	@Override
    public double calcularPrecoVenda() {
        double precoVenda;
        if (quantidadeQuartos > 4 && piscina == true) {
            precoVenda = precoCompra * 1.5;
        } 
        else {
            precoVenda = precoCompra * 1.1;
        }
        return precoVenda;
    }
}

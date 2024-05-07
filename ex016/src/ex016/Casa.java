package ex016;

public class Casa extends Imovel{
	private boolean quintal;

	public Casa(double area, int quantidadeQuartos, double precoCompra, boolean quintal) {
		super(area, quantidadeQuartos, precoCompra);
		this.quintal = quintal;
	}

	public boolean isQuintal() {
		return quintal;
	}

	public void setQuintal(boolean quintal) {
		this.quintal = quintal;
	}
	
	@Override
    public double calcularPrecoVenda() {
        double precoVenda;
        if (quantidadeQuartos > 4 || quintal == true) {
            precoVenda = precoCompra * 1.3;
        } 
        else {
            precoVenda = precoCompra * 1.15;
        }
        return precoVenda;
    }
}

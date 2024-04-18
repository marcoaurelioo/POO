package hotelaria;

public class Item {
    private String tipoItem;
    private double valorItem;
    private int quantidadeItem;

    public Item(String tipoItem, double valorItem, int quantidadeItem) {
        this.tipoItem = tipoItem;
        this.valorItem = valorItem;
        this.quantidadeItem = quantidadeItem;
    }

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}

	public int getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
    
    
}

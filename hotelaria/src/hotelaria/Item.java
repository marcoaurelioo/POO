package hotelaria;

public class Item {
    private String tipoItem;
    private double valorItem;

    public Item(String tipoItem, double valorItem) {
        this.tipoItem = tipoItem;
        this.valorItem = valorItem;
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

    
}

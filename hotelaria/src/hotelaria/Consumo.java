package hotelaria;
import java.util.Date;


public class Consumo {
    private Item item;
    private int quantidade;
    private Date dataConsumo;
    private Estadia estadia;

    public Consumo(Item item, int quantidade, Date dataConsumo, Estadia estadia) {
        this.item = item;
        this.quantidade = quantidade;
        this.dataConsumo = dataConsumo;
        this.estadia = estadia;
    }

    public double calcularTotal() {
        return item.getValorItem() * quantidade;
    }
    
	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
    
    
}

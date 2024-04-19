package hotelaria;
import java.util.Date;


public class Consumo {
	private ItemFrigobar itemFrigobar;
    private int quantidade;
    private Date dataConsumo;
    private Estadia estadia;

    public Consumo(ItemFrigobar itemFrigobar, int quantidade, Date dataConsumo, Estadia estadia) {
        this.itemFrigobar = itemFrigobar;
        this.quantidade = quantidade;
        this.dataConsumo = dataConsumo;
        this.estadia = estadia;
    }
    
	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public ItemFrigobar getItem() {
		return itemFrigobar;
	}

	public void setItem(ItemFrigobar itemFrigobar) {
		this.itemFrigobar = itemFrigobar;
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

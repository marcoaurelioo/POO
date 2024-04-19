package hotelaria;
import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private Categoria categoria;
    private int numero;
    private int situacaoQuarto;
    private List<Estadia> estadias;

    public Quarto(Categoria categoria, int numero, int situacaoQuarto) {
        this.categoria = categoria;
        this.numero = numero;
        this.situacaoQuarto = situacaoQuarto;
        this.estadias = new ArrayList<>();
    }

	public void adicionarEstadia(Estadia estadia) {
        estadias.add(estadia);
    }

    public void removerEstadia(Estadia estadia) {
        estadias.remove(estadia);
    }

    public List<Estadia> getEstadias() {
        return estadias;
    }

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSituacaoQuarto() {
		return situacaoQuarto;
	}

	public void setSituacaoQuarto(int situacaoQuarto) {
		this.situacaoQuarto = situacaoQuarto;
	}

	public void setEstadias(List<Estadia> estadias) {
		this.estadias = estadias;
	}

	
    
}


package hotelaria;


public class Diaria {
    private long numDias;
    private double valorDiaria;

    public Diaria(long numDias, double valorDiaria) {
        this.numDias = numDias;
        this.valorDiaria = valorDiaria;
    }

    public double consultarDiaria() {
        return valorDiaria * numDias;
    }

	public long getNumDias() {
		return numDias;
	}

	public void setNumDias(long numDias) {
		this.numDias = numDias;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
    
    
}

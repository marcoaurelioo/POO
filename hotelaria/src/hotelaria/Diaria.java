package hotelaria;
import java.util.Date;


public class Diaria {
    private Date dataDiaria;
    private double valorDiaria;

    public Diaria(Date dataDiaria, double valorDiaria) {
        this.dataDiaria = dataDiaria;
        this.valorDiaria = valorDiaria;
    }

    public double consultarDiaria() {
        return valorDiaria;
    }

	public Date getDataDiaria() {
		return dataDiaria;
	}

	public void setDataDiaria(Date dataDiaria) {
		this.dataDiaria = dataDiaria;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
    
    
}

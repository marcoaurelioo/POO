package hotelaria;
import java.util.Date;


public class Reserva {
    private Date dataReserva;
    private Date dataSaida;
    private Hospede hospede;
    private Quarto quarto;

    public Reserva(Date dataReserva, Date dataSaida, Hospede hospede, Quarto quarto) {
        this.dataReserva = dataReserva;
        this.dataSaida = dataSaida;
        this.hospede = hospede;
        this.quarto = quarto;
    }

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
    
    
}

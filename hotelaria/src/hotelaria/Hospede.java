package hotelaria;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa{
	
	private long cpfHospede;
    private String paisHospede;
    private List<Reserva> reservas;
    private List<Estadia> estadias;

    public Hospede(String nome, String email, long cpfHospede, String paisHospede) {
        super(nome, email);
        this.cpfHospede = cpfHospede;
        this.paisHospede = paisHospede;
        this.reservas = new ArrayList<>();
        this.estadias = new ArrayList<>();
    }

    public String consultarDados() {
        return "Nome: " + getNome() + ", CPF: " + cpfHospede + ", País: " + paisHospede;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void adicionarEstadia(Estadia estadia) {
        estadias.add(estadia);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Estadia> getEstadias() {
        return estadias;
    }
}

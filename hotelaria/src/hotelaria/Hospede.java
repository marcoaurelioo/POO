package hotelaria;
public class Hospede extends Pessoa{
	
    private long cpfHospede;
    private String paisHospede;

    public Hospede(String nome, String email, long cpfHospede, String paisHospede) {
        super(nome, email);
        this.cpfHospede = cpfHospede;
        this.paisHospede = paisHospede;
    }

    public String consultarDados() {
        return "Nome: " + getNome() + ", CPF: " + cpfHospede + ", País: " + paisHospede;
    }

    public long getCpfHospede() {
        return cpfHospede;
    }

    public void setCpfHospede(long cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public String getPaisHospede() {
        return paisHospede;
    }

    public void setPaisHospede(String paisHospede) {
        this.paisHospede = paisHospede;
    }
}

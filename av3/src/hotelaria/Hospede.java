package hotelaria;

public class Hospede extends Pessoa{
    private String enderecoCompleto;

    public Hospede(String nome, String email, String cpf, String enderecoCompleto) {
		super(nome, email, cpf);
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
    
    @Override
    public String toString() {
        return "Hospede{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", enderecoCompleto='" + getEnderecoCompleto() + '\'' +
                '}';
    }
}

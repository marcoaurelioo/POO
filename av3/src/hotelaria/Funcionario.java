package hotelaria;

public class Funcionario extends Pessoa {
    private String setor;

	public Funcionario(String nome, String email, String cpf, String setor) {
		super(nome, email, cpf);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

    @Override
    public String toString() {
        return "Funcionário{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", setor='" + getSetor() + '\'' +
                '}';
    }

   
}
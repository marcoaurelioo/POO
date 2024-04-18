package ex4;

public class Cliente {
	private String nome;
	private long cpf;
	private String email;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void imprimir() {
		System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Email: " + email);
	}
}

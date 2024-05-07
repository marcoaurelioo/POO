package ex009;

public class Cliente {
	private String cpf;
	private String endereco;
	
	public Cliente(String cpf, String endereco) {
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void imprimir() {
		System.out.println("CPF: " + cpf + ", endereço: " + endereco);
	}
}

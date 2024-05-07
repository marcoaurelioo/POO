package ex010;

public class Aluno {
	private String nome;
	private long anoNascimento;
	private double mediaGlobal;
	
	public Aluno(String nome, long anoNascimento, double mediaGlobal) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.mediaGlobal = mediaGlobal;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(long anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public double getMediaGlobal() {
		return mediaGlobal;
	}

	public void setMediaGlobal(double mediaGlobal) {
		this.mediaGlobal = mediaGlobal;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + getNome() + ", Ano de nascimento: " + getAnoNascimento() + ", Média: " + getMediaGlobal());
	}
}

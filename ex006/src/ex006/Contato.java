package ex006;

public class Contato {
	private String nome;
	private long telefone;
	private boolean favorito;
	
	public Contato(String nome, long telefone, boolean favorito) {
		this.nome = nome;
		this.telefone = telefone;
		this.favorito = favorito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
	
	
	
	
}

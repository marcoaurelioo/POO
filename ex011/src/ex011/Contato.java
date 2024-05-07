package ex011;

public class Contato {
	    private String nome;
	    private String telefone;
	    private boolean favorito;

	   
	    public Contato(String nome, String telefone, boolean favorito) {
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

	    public String getTelefone() {
	        return telefone;
	    }

	    public void setTelefone(String telefone) {
	        this.telefone = telefone;
	    }

	    public boolean isFavorito() {
	        return favorito;
	    }

	    public void setFavorito(boolean favorito) {
	        this.favorito = favorito;
	    }
	}


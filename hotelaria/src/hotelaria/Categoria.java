package hotelaria;

public class Categoria {
    private String nome;
    private float valorCategoria;

    public Categoria(String nome, float valorCategoria) {
        this.nome = nome;
        this.valorCategoria = valorCategoria;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorCategoria() {
		return valorCategoria;
	}

	public void setValorCategoria(float valorCategoria) {
		this.valorCategoria = valorCategoria;
	}
    
    
}

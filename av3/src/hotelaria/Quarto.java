package hotelaria;


public class Quarto {
	private int codigo;
    private Categoria categoria;
    private String status;
    
	public Quarto(int codigo, Categoria categoria, String status) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


    @Override
    public String toString() {
        return "Quarto{" +
                "codigo='" + getCodigo() + '\'' +
                ", categoria='" + categoria.getDescricao() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
	
    
}


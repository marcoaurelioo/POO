package hotelaria;

public class Categoria {
    private int codigo;
    private String descricao;
    private double valor;
    
	public Categoria(int codigo, String descricao, double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
	
    public Categoria(String descricao) {
        this.descricao = descricao;
        this.codigo = 0; 
        this.valor = 0.0; 
    }
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

    @Override
    public String toString() {
        return "Categoria{" +
                "codigo='" + getCodigo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", valor='" + getValor() + '\'' +
                '}';
    }
    
}

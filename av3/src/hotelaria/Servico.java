package hotelaria;

public class Servico {
    private int codigo;
    private String descricao;
    private double valor;
    
	public Servico(int codigo, String descricao, double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
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
        return "Servico{" +
                "codigo='" + getCodigo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", valor='" + getValor() + '\'' +
                '}';
    }
    
    
}
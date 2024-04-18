package ex001;

public class Produto {
	private long codigo;
	private double peso;
	private double valor;
	
	public Produto(long codigo, double peso, double valor) {
		this.codigo = codigo;
		this.peso = peso;
		this.valor = valor;
	}
	
	public void infos() {
		System.out.println("Codigo do produto: " + codigo);
		System.out.println("Peso do produto: " + peso);
		System.out.println("Valor do produto R$" + valor);
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}

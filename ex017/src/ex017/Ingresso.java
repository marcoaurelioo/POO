package ex017;

public abstract class Ingresso {
	protected String nome;
	protected boolean ehMeia;
	protected double valor;
	protected int lote;
	
	public Ingresso(String nome, boolean ehMeia, double valor, int lote) {
		super();
		this.nome = nome;
		this.ehMeia = ehMeia;
		this.valor = valor;
		this.lote = lote;
	}
	
	public abstract double calculaReembolso();
	
}

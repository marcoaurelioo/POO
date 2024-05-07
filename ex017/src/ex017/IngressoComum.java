package ex017;

public class IngressoComum extends Ingresso{
	
	public IngressoComum(String nome, boolean ehMeia, double valor, int lote) {
		super(nome, ehMeia, valor, lote);
	}
	
	@Override
	public double calculaReembolso() {
		double reembolso;
		if(ehMeia == false || lote == 1) {
			reembolso = valor * 0.05;	
		}
		else {
			reembolso = valor * 0.03;
		}
		return reembolso;
	}
	
	
}

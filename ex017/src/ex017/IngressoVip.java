package ex017;

public class IngressoVip extends Ingresso{
	
	public IngressoVip(String nome, boolean ehMeia, double valor, int lote) {
		super(nome, ehMeia, valor, lote);
	}
	
	@Override
	public double calculaReembolso() {
		double reembolso;
		if(ehMeia == false || lote == 1) {
			reembolso = valor * 0.1;	
		}
		else {
			reembolso = valor * 0.06;
		}
		return reembolso;
	}

}

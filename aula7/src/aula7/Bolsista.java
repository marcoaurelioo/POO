package aula7;

public class Bolsista extends Aluno{
	private boolean bolsa;
	
	public void renovarBolsa() {
		System.out.println("Renovando a bolsa");
	}
	
	@Override
	public void pagarMensalidade() {
		System.out.println(this.getNome() + " é bolsista! pagamento realizado");
	}
}

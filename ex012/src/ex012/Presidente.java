package ex012;

public class Presidente extends Funcionario{
	private double acoes;

	public Presidente(String nome, String cpf, double salario, double acoes) {
		super(nome, cpf, salario);
		this.acoes = acoes;
	}

	public double getAcoes() {
		return acoes;
	}

	public void setAcoes(double acoes) {
		this.acoes = acoes;
	}
	
	@Override
	public void bonus() {
		double count = 0;
		count = salario*0.1;
		System.out.println("Bonus: " + count);
	}
}

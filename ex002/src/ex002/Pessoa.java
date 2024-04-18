package ex002;

public class Pessoa {
	public String nome;
	public long anonascimento;
	public double peso;
	public double altura;
	
	public double imc() {
		double imc = peso/(altura*altura);
		return imc;
	}
	
	public double agua() {
		double qtd = peso*0.03;
		return qtd;
	}
	
	public long idade() {
		long idade = 2024-anonascimento;
		return idade;
	}
	
	public void mostra() {
		System.out.println("Nome: " + nome);
		System.out.println("Peso: " + peso + "kg");
		System.out.println("Altura: " + altura + "m");
		System.out.println("Idade " + idade());
		System.out.println("IMC: " + imc());
		System.out.println("Quantidade de agua: " + agua() + "l");
	}
	
	
}

package ex015;

public class Cachorro extends Animal{
	public boolean corre;

	public Cachorro(String nome, int idade, boolean corre) {
		super(nome, idade);
		this.corre = corre;
	}
	
	public void emitirSom() {
		System.out.println("Som do cachorro");
	}
}

package ex015;

public class Preguica extends Animal{
	public boolean escala;

	public Preguica(String nome, int idade, boolean escala) {
		super(nome, idade);
		this.escala = escala;
	}
	
	public void emitirSom() {
		System.out.println("Som da preguiça");
	}
}

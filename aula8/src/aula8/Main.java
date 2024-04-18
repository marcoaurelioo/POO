package aula8;

public class Main {

	public static void main(String[] args) {
		Mamifero m = new Mamifero();
		Reptil r = new Reptil();
		Peixe p = new Peixe();
		Ave a = new Ave();
		
		m.setPeso(35.5);
		m.setCorPelo("Marrom");
		m.alimentar();
		m.locomover();
		m.emitirSom();
		
		r.alimentar();
		r.locomover();
		r.emitirSom();
		
		p.alimentar();
		p.locomover();
		p.emitirSom();
		
		a.alimentar();
		a.locomover();
		a.emitirSom();
	}

}

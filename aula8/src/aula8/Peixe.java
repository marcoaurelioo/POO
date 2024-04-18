package aula8;

public class Peixe extends Animal{
	public String corEscama;
	
	
	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}

	public void fazerBolha() {
		System.out.println("Soltou uma bolha");
	}
	
	@Override
	public void locomover() {
		System.out.println("Nadando");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Comendo substancias");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Peixe nao faz som");
		
	}

}

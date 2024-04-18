package aula8;

public abstract class Animal {
	public double peso;
	public int idade;
	public int membros;
	
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getMembros() {
		return membros;
	}

	public void setMembros(int membros) {
		this.membros = membros;
	}

	public abstract void locomover();
	
	public abstract void alimentar();
	
	public abstract void emitirSom();
}

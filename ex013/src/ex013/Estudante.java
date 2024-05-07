package ex013;

public class Estudante {
	private long matricula;
	private long anoIngresso;
	private String curso;
	
	public Estudante(long matricula, long anoIngresso, String curso) {
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.curso = curso;
	}
	
	public long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public long getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(long anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public double tirarCopias(int quantidade) {
		return quantidade * 0.1;
	}
}

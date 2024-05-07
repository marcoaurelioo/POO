package ex013;

public class Bolsista extends Estudante{
	private double valorBolsa;
	
	public Bolsista(long matricula, long anoIngresso, String curso, double valorBolsa) {
		super(matricula, anoIngresso, curso);
		this.valorBolsa = valorBolsa;
	}
	
	public double getValorBolsa() {
		return valorBolsa;
	}
	
	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}
	
	@Override
	public double tirarCopias(int quantidade) {
		return quantidade * 0.07;
	}
	
    public int quantidadeCopiasComBolsa() {
        return (int)(valorBolsa / 0.07);
    }
}

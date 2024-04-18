package hotelaria;

public class Servico {
    private String tipoServico;
    private double valorServico;

    public Servico(String tipoServico, double valorServico) {
        this.tipoServico = tipoServico;
        this.valorServico = valorServico;
    }

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public double getValorServico() {
		return valorServico;
	}

	public void setValorServico(double valorServico) {
		this.valorServico = valorServico;
	}
    
    
}

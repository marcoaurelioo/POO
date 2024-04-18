package hotelaria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estadia {
    private Date dataCheckin;
    private Date dataCheckout;
    private Hospede hospede;
    private Quarto quarto;
    private Funcionario funcionarioResponsavel;
    private List<Servico> servicos;
    private List<Consumo> consumos;

    public Estadia(Date dataCheckin, Date dataCheckout, Hospede hospede, Quarto quarto, Funcionario funcionarioResponsavel) {
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.hospede = hospede;
        this.quarto = quarto;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.servicos = new ArrayList<>();
        this.consumos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void adicionarConsumo(Consumo consumo) {
        consumos.add(consumo);
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

	public Date getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public Date getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
    
    
}

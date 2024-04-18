package ambientes;
import java.time.LocalDate;

public class Funcionario {
	private String nome;
	private LocalDate dataContratacao;
	private double salario;
	
	public Funcionario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
    public void aumentarSalario(double valor) {
        double novoSalario = getSalario() + valor;
        setSalario(novoSalario);
    }
    
    public void mostrarSalario() {
        System.out.println("O salário de " + getNome() + " é R$" + getSalario());
    }
}

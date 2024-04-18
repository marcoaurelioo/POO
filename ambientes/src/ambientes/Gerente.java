package ambientes;
import java.time.LocalDate;

public class Gerente extends Funcionario {
	
	@Override
    public void aumentarSalario(double valor) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataContratacao = getDataContratacao();
        
        long anosDeServico = dataContratacao.until(dataAtual).getYears();

        double percentual = (getSalario() + valor) * anosDeServico / 100;
        double novoSalario = getSalario() + valor + percentual;
        setSalario(novoSalario);
    }
	
    @Override
    public void mostrarSalario() {
        System.out.println("O salário do gerente " + getNome() + " é R$" + getSalario());
    }
	
	
}
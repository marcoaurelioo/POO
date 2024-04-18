package ambientes;

public class Main {

	public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João");
        funcionario.setDataContratacao(java.time.LocalDate.of(2020, 1, 1));
        funcionario.setSalario(2000.0);
        System.out.println("Salário do funcionário " + funcionario.getNome() + " antes do aumento: R$" + funcionario.getSalario());
        

        Gerente gerente = new Gerente();
        gerente.setNome("Maria");
        gerente.setDataContratacao(java.time.LocalDate.of(2018, 3, 15));
        gerente.setSalario(3000.0);
        System.out.println("Salário do gerente " + gerente.getNome() + " antes do aumento: R$" + gerente.getSalario());

        funcionario.aumentarSalario(500.0);
        gerente.aumentarSalario(700.0);

        //Salário após o aumento
        funcionario.mostrarSalario();
        gerente.mostrarSalario();
        
	}

}

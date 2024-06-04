package hotelaria;
import java.util.Scanner;
public class MenuTeste {


	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int mainOption;

	        do {
	            printMainMenu();
	            mainOption = scanner.nextInt();
	            scanner.nextLine();

	            switch (mainOption) {
	                case 1: 
	                    manageHospedes();
	                    break;
	                case 2:
	                    manageFuncionarios();
	                    break;
	                case 3: // Reserva
	                    manageReservas();
	                    break;
	                case 4: // Quarto
	                    manageQuartos();
	                    break;
	                case 5: // Categoria
	                    manageCategorias();
	                    break;
	                case 6: // Item
	                    manageItens();
	                    break;
	                case 7: // Serviço
	                    manageServicos();
	                    break;
	                case 8: // Consumo
	                    manageConsumos();
	                    break;
	                case 9: // Sair
	                    System.out.println("Saindo do sistema...");
	                    break;
	                default:
	                    System.out.println("Opção inválida, tente novamente.");
	            }
	        } while (mainOption != 9);

	        scanner.close();
	    }

	    private static void printMainMenu() {
	        System.out.println("\nMenu Principal");
	        System.out.println("1. Gerenciar Hóspedes");
	        System.out.println("2. Gerenciar Funcionários");
	        System.out.println("3. Gerenciar Reservas");
	        System.out.println("4. Gerenciar Quartos");
	        System.out.println("5. Gerenciar Categorias");
	        System.out.println("6. Gerenciar Itens");
	        System.out.println("7. Gerenciar Serviços");
	        System.out.println("8. Gerenciar Consumo");
	        System.out.println("9. Sair");
	        System.out.print("Escolha uma opção: ");
	    }

	    private static void manageHospedes() {
	        int hospedeOption;
	        do {
	            printHospedeMenu();
	            hospedeOption = scanner.nextInt();
	            scanner.nextLine();

	            switch (hospedeOption) {
	                case 1: // Cadastrar Hóspede
	                    System.out.println("Cadastrar Hóspede");
	                    // Implementar cadastro de hóspede
	                    break;
	                case 2: // Consultar Hóspede
	                    System.out.println("Consultar Hóspede");
	                    // Implementar consulta de hóspede
	                    break;
	                case 3: // Editar Hóspede
	                    System.out.println("Editar Hóspede");
	                    // Implementar edição de hóspede
	                    break;
	                case 4: // Remover Hóspede
	                    System.out.println("Remover Hóspede");
	                    // Implementar remoção de hóspede
	                    break;
	                case 5: // Listar Hóspedes
	                    System.out.println("Listar Hóspedes");
	                    // Implementar listagem de hóspedes
	                    break;
	                case 6: // Voltar ao Menu Principal
	                    System.out.println("Voltando ao Menu Principal");
	                    break;
	                default:
	                    System.out.println("Opção inválida, tente novamente.");
	            }
	        } while (hospedeOption != 6);
	    }

	    private static void manageFuncionarios() {
	        int funcionarioOption;
	        do {
	            printFuncionarioMenu();
	            funcionarioOption = scanner.nextInt();
	            scanner.nextLine();

	            switch (funcionarioOption) {
	                case 1: // Cadastrar Funcionário
	                    System.out.println("Cadastrar Funcionário");
	                    // Implementar cadastro de funcionário
	                    break;
	                case 2: // Consultar Funcionário
	                    System.out.println("Consultar Funcionário");
	                    // Implementar consulta de funcionário
	                    break;
	                case 3: // Editar Funcionário
	                    System.out.println("Editar Funcionário");
	                    // Implementar edição de funcionário
	                    break;
	                case 4: // Remover Funcionário
	                    System.out.println("Remover Funcionário");
	                    // Implementar remoção de funcionário
	                    break;
	                case 5

}
	        }

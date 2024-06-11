package hotelaria;

import java.util.Scanner;
import Services.HospedeDataDao;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        HospedeDataDao hospedeDao = new HospedeDataDao();

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Editar Hóspede");
            System.out.println("3. Consultar Hóspede");
            System.out.println("4. Listar Hóspedes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) { // Verifica se há um próximo inteiro
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Consumir a nova linha
                continue; // Volta para o início do loop
            }

            switch (opcao) {
                case 1:
                    cadastrarHospede(scanner, hospedeDao);
                    break;
                case 2:
                    editarHospede(scanner, hospedeDao);
                    break;
                case 3:
                    consultarHospede(scanner, hospedeDao);
                    break;
                case 4:
                    listarHospedes(hospedeDao);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarHospede(Scanner scanner, HospedeDataDao hospedeDao) {
        System.out.println("Cadastro de Hóspede:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço Completo: ");
        String enderecoCompleto = scanner.nextLine();

        Hospede novoHospede = new Hospede(nome, email, cpf, enderecoCompleto);
        hospedeDao.cadastrar(novoHospede);
    }

    private static void editarHospede(Scanner scanner, HospedeDataDao hospedeDao) {
        System.out.println("Edição de Hóspede:");
        System.out.print("CPF do Hóspede a ser editado: ");
        String cpf = scanner.nextLine();

        Hospede hospedeConsulta = new Hospede("", "", cpf, "");
        Hospede hospedeEncontrado = hospedeDao.consultar(hospedeConsulta);

        if (hospedeEncontrado != null) {
            System.out.println("Hóspede encontrado:");
            System.out.println(hospedeEncontrado);

            System.out.println("Digite as novas informações:");

            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Email: ");
            String novoEmail = scanner.nextLine();
            System.out.print("Novo Endereço Completo: ");
            String novoEndereco = scanner.nextLine();

            hospedeEncontrado.setNome(novoNome);
            hospedeEncontrado.setEmail(novoEmail);
            hospedeEncontrado.setEnderecoCompleto(novoEndereco);

            hospedeDao.editar(hospedeEncontrado);
        } else {
            System.out.println("Hóspede não encontrado.");
        }
    }

    private static void consultarHospede(Scanner scanner, HospedeDataDao hospedeDao) {
        System.out.println("Consulta de Hóspede:");
        System.out.print("CPF do Hóspede a ser consultado: ");
        String cpf = scanner.nextLine();

        Hospede hospedeConsulta = new Hospede("", "", cpf, "");
        Hospede hospedeEncontrado = hospedeDao.consultar(hospedeConsulta);

        if (hospedeEncontrado != null) {
            System.out.println("Hóspede encontrado:");
            System.out.println(hospedeEncontrado);
        } else {
            System.out.println("Hóspede não encontrado.");
        }
    }

    private static void listarHospedes(HospedeDataDao hospedeDao) {
        System.out.println("Listagem de Hóspedes:");
        hospedeDao.listar(null); // Como a lista não depende de um hóspede específico, passamos null
    }
}

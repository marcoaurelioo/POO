package hotelaria;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
    	// Criando objetos
        Categoria categoria = new Categoria("Luxo", 500.0f);
        Quarto quarto = new Quarto(categoria, 101, 1);
        Hospede hospede = new Hospede("João", "joao@email.com", 12345678910L, "Brasil");
        Funcionario funcionario = new Funcionario("Maria", "maria@email.com", "Recepcionista");
        ItemFrigobar itemFrigobar = new ItemFrigobar("Refrigerante", 5.0);
        Servico servico = new Servico("Lavanderia", 20.0);
        Diaria diaria = new Diaria(3, 100.0);

        // Criando uma reserva
        Date dataReserva = new Date();
        Date dataSaida = new Date(dataReserva.getTime() + (1000 * 60 * 60 * 24 * 7)); // Saindo após uma semana
        Reserva reserva = new Reserva(dataReserva, dataSaida, hospede, quarto);

        // Criando uma estadia
        Estadia estadia = new Estadia(dataReserva, dataSaida, hospede, quarto, funcionario);
        estadia.adicionarDiaria(diaria);
        estadia.adicionarServico(servico);
        estadia.adicionarConsumo(new Consumo(itemFrigobar, 2, new Date(), estadia));
        
        // Calculando o total da estadia
        double totalEstadia = estadia.calcularTotal();

        // Exibindo informações da estadia e o total
        System.out.println("Informações da Estadia:");
        System.out.println("Hóspede: " + estadia.getHospede().getNome());
        System.out.println("Quarto: " + estadia.getQuarto().getNumero());
        System.out.println("Data de Check-in: " + estadia.getDataCheckin());
        System.out.println("Data de Check-out: " + estadia.getDataCheckout());
        System.out.println("Total da Estadia: R$" + totalEstadia);
    }
}

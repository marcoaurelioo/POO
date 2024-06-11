package hotelaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Services.HospedeDataDao;
import Services.FuncionarioDataDao;
import Services.CategoriaDataDao;
import Services.ItemDataDao;
import Services.ServicoDataDao;
import Services.QuartoDataDao;
import Services.CategoriaItemDataDao;
import Services.ReservaDataDao;
import Services.ConsumoDataDao;
import Services.ConsumoServicoDataDao;

public class Main {

	public static void main(String[] args) {
		ReservaDataDao dao = new ReservaDataDao();
		ConsumoServicoDataDao dao1 = new ConsumoServicoDataDao();
		
		Categoria categoria = new Categoria(1, "Luxo", 200);
		Quarto quarto = new Quarto(101, categoria, "Disponível");
		Hospede hospede = new Hospede("Maria", "maria@gmail.com", "12345678901", "Rua A, 123");
		Funcionario funcionarioReserva = new Funcionario("João", "joao@gmail.com", "98765432101", "Recepção");
        Funcionario funcionarioFechamento = new Funcionario("Pedro", "pedro@gmail.com", "98765432102", "Recepção");
        Servico servico = new Servico(1, "teste", 203);
        Calendar calendar = new GregorianCalendar(2020, 0, 10); 
        Date dataEntrada = calendar.getTime();
        calendar = new GregorianCalendar(2020, 0, 20);
        Date dataSaida = calendar.getTime();
        calendar = new GregorianCalendar(2020, 0, 10);
        Date dataCheckin = calendar.getTime();
        calendar = new GregorianCalendar(2020, 0, 20);
        Date dataCheckout = calendar.getTime();
        calendar = new GregorianCalendar(2020, 0, 14);
        Date dataConsumo = calendar.getTime();
        
        
        Reserva reserva = new Reserva(1, hospede, quarto, funcionarioReserva, funcionarioFechamento,
                dataEntrada, dataSaida, dataCheckin, dataCheckout, 150, 0);
        
        ConsumoServico consumo = new ConsumoServico(servico, reserva, 1, dataConsumo);
        
		dao.cadastrar(reserva);
		dao1.cadastrar(consumo);
		dao1.listar(consumo);
		
	}

}

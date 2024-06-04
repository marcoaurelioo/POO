	package hotelaria;
	
	public class Main {
	
		public static void main(String[] args) {
	        HospedeDataDAO dao = new HospedeDataDAO();
	
	        Hospede hospede1 = new Hospede("12345678900", "Joao Silva", "joao@email.com", "Rua das Flores, 123");
	
	        if (dao.cadastrar(hospede1)) {
	            System.out.println("Hospede cadastrado com sucesso!");
	        } else {
	            System.out.println("Erro ao cadastrar hospede.");
	        }
	        
	        if (dao.consultar(hospede1)) {
	            System.out.println("Hospede encontrado!");
	        } else {
	            System.out.println("Hospede nao encontrado."); 
	        }
	
	          // Teste do método editar
	       System.out.println("Editando hóspede 1:");
	         dao.editar(hospede1);
	
	
	    }
		
	
	}

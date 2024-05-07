package ex011;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
	 private List<Contato> contatos;

	   
	    public Agenda() {
	        this.contatos = new ArrayList<>();
	    }

	    
	    public void adicionarContato(Contato contato) {
	        contatos.add(contato);
	    }
	    
	    public int quantidadeContatosFavoritos() {
	        int count = 0;
	        for (Contato contato : contatos) {
	            if (contato.isFavorito()) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public int quantidadeContatosComLetraR() {
	        int count = 0;
	        for (Contato contato : contatos) {
	            if (contato.getNome().toLowerCase().startsWith("r")) {
	                count++;
	            }
	        }
	        return count;
	    }
}

package ex006;
import java.util.List;
import java.util.ArrayList;

public class Agenda {
	public List<Contato> contatos;

	public Agenda() {
		this.contatos = new ArrayList<>();
	}
	
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }
    

    public int quantidadeContatosFavoritos() {
        int quantidadeFavoritos = 0;
        for (Contato contato : contatos) {
            if (contato.isFavorito()) {
                quantidadeFavoritos++;
            }
        }
        return quantidadeFavoritos;
    }

    public int quantidadeContatosComLetraR() {
        int quantidadeComLetraR = 0;
        for (Contato contato : contatos) {
            if (contato.getNome().toLowerCase().startsWith("r")) {
                quantidadeComLetraR++;
            }
        }
        return quantidadeComLetraR;
    }
	
}

package ex006;

public class Main {

	public static void main(String[] args) {
        Agenda agenda = new Agenda();

        
        agenda.adicionarContato(new Contato("João", 123456789, true));
        agenda.adicionarContato(new Contato("Maria", 987654321, false));
        agenda.adicionarContato(new Contato("Roberto", 111111111, true));
        agenda.adicionarContato(new Contato("Rafaela", 222222222, false));
        agenda.adicionarContato(new Contato("Carlos", 333333333, true));

        
        int quantidadeFavoritos = agenda.quantidadeContatosFavoritos();
        System.out.println("Quantidade de contatos favoritos: " + quantidadeFavoritos);

        
        int quantidadeComLetraR = agenda.quantidadeContatosComLetraR();
        System.out.println("Quantidade de contatos com letra 'R': " + quantidadeComLetraR);
	}

}

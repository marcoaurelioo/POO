package ex002;

public class Main {

	public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        
        pessoa.nome = "João";
        pessoa.anonascimento = 1990;
        pessoa.peso = 70.5;
        pessoa.altura = 1.75;
        
        pessoa.mostra();
    }
}


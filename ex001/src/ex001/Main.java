package ex001;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(01, 15.2, 49);
        Produto produto2 = new Produto(02, 7.5, 60.0);
        Produto produto3 = new Produto(03, 24.2, 30.0);

        Armazenar armazenador = new Armazenar();
        armazenador.adicionarProdutos(produto1);
        armazenador.adicionarProdutos(produto2);
        armazenador.adicionarProdutos(produto3);

        System.out.println("Quantidade de produtos com peso maior que 10 e valor menor que R$ 50,00: " + armazenador.contarProdutos50());
        System.out.println("---------------------------------");// Linha de separação visual no console para melhor organização e legibilidade
        System.out.println("Media dos pesos: " + armazenador.mediaPeso());
        System.out.println("---------------------------------");
        System.out.println("Produto mais leve:");
        armazenador.maisLeve().infos();
        System.out.println("---------------------------------");
        System.out.println("Produto de maior valor:");
        armazenador.maiorValor().infos();
        System.out.println("---------------------------------");
        System.out.println("Media dos valores cujo peso do produto é maior que 10: " + armazenador.maior10());
    }
}
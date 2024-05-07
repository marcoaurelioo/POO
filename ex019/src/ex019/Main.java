package ex019;

public class Main {
    public static void main(String[] args) {
        // Criando a loja
        Loja loja = new Loja();

        // Adicionando alguns produtos
        loja.adicionarProduto(new Celular("iPhone 12", 5000.0, 12, true));
        loja.adicionarProduto(new Celular("Samsung Galaxy S21", 4500.0, 12, true));
        loja.adicionarProduto(new Celular("Xiaomi Redmi Note 10", 2000.0, 12, false));
        loja.adicionarProduto(new Computador("Notebook Dell", 4000.0, 12, false));
        loja.adicionarProduto(new Computador("PC Gamer", 6000.0, 12, true));
        loja.adicionarProduto(new Computador("Desktop HP", 3500.0, 12, false));

        // Chamando os métodos
        int qntComCarregador = loja.qntCelCarregador();
        Computador maisBarato = loja.computadorBarato();

        // Exibindo resultados
        System.out.println("Quantidade de celulares com carregador: " + qntComCarregador);
        if (maisBarato != null) {
            System.out.println("Computador mais barato: " + maisBarato.nome);
        } else {
            System.out.println("Nenhum computador disponível na loja.");
        }
    }
}

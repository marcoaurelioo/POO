package ex008;

public class Main {

	public static void main(String[] args) {
        Loja loja = new Loja();

        Produto produto1 = new Produto("P001", "Camiseta", 29.99, 20);
        Produto produto2 = new Produto("P002", "Calça Jeans", 59.99, 15);
        Produto produto3 = new Produto("P003", "Tênis", 99.99, 10);

        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto2);
        loja.adicionarProduto(produto3);

        System.out.println("Produtos disponíveis na loja:");
        loja.imprimirProdutos();

        System.out.println("Realizando uma venda do produto P001...");
        loja.vender("P001");

        System.out.println("\nProdutos disponíveis na loja após a venda:");
        loja.imprimirProdutos();

        System.out.println("\nAbastecendo o produto P003...");
        loja.abastecer("P003");

        System.out.println("\nProdutos disponíveis na loja após o abastecimento:");
        loja.imprimirProdutos();

        System.out.println("\nValor total do estoque da loja: R$" + loja.valorEstoque());
    

	}

}

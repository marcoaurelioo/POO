package ex008;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos;

    
    public Loja() {
        this.produtos = new ArrayList<>();
    }
    
    public void vender(String identificador) {
        for (Produto produto : produtos) {
            if (produto.getIdentificador().equals(identificador)) {
                int quantidadeAtual = produto.getQuantidadeEstoque();
                if (quantidadeAtual > 0) {
                    produto.setQuantidadeEstoque(quantidadeAtual - 1);
                    System.out.println("Venda realizada com sucesso!");
                } else {
                    System.out.println("Produto indisponível em estoque.");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    
    public void abastecer(String identificador) {
        for (Produto produto : produtos) {
            if (produto.getIdentificador().equals(identificador)) {
                int quantidadeAtual = produto.getQuantidadeEstoque();
                produto.setQuantidadeEstoque(quantidadeAtual + 1);
                System.out.println("Abastecimento realizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    
    public double valorEstoque() {
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getValor() * produto.getQuantidadeEstoque();
        }
        return valorTotal;
    }
    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void imprimirProdutos() {
        System.out.println("Produtos disponíveis na loja:");
        for (Produto produto : produtos) {
            produto.imprimir();
            System.out.println();
        }
    }
}
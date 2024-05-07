package ex019;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos;

    public Loja() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public int qntCelCarregador() {
        int qntCelularesComCarregador = 0;
        for (Produto produto : produtos) {
            if (produto instanceof Celular) {
                Celular celular = (Celular) produto;
                if (celular.carregador) {
                    qntCelularesComCarregador++;
                }
            }
        }
        return qntCelularesComCarregador;
    }

    public Computador computadorBarato() {
        Computador maisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto produto : produtos) {
            if (produto instanceof Computador) {
                Computador computador = (Computador) produto;
                if (computador.preco < menorPreco) {
                    menorPreco = computador.preco;
                    maisBarato = computador;
                }
            }
        }
        return maisBarato;
    }
}

package ex008;

public class Produto {
    private String identificador;
    private String nome;
    private double valor;
    private int quantidadeEstoque;

    public Produto(String identificador, String nome, double valor, int quantidadeEstoque) {
        this.identificador = identificador;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void imprimir() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nome: " + nome);
        System.out.println("Valor: " + valor);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }
}

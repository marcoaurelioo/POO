package ex004;

public class Banco {
    private Cliente cliente;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } 
        else {
            System.out.println("Erro: O saldo não pode ser negativo.");
        }
    }

    public void imprimir() {
        if (cliente != null) {
            cliente.imprimir();
        }
        System.out.println("Saldo: " + saldo);
    }

    public void fazOperacao(Operacao operacao) {
        if (operacao.getTipo() == 'D') { 
            this.saldo += operacao.getValor();
            System.out.println("Depósito de " + operacao.getValor() + " realizado.");
        } 
        else if (operacao.getTipo() == 'R') {
            if (operacao.getValor() <= this.saldo) {
                this.saldo -= operacao.getValor();
                System.out.println("Retirada de " + operacao.getValor() + " realizada.");
            } else {
                System.out.println("Erro: Saldo insuficiente para a retirada.");
            }
        } 
        else {
            System.out.println("Erro: Tipo de operação inválido.");
        }
    }
}

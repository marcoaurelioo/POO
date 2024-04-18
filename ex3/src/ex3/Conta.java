package ex3;

public class Conta {
    private int cpf;
    private long banco;
    private double saldo;
    private boolean especial;
    
    public Conta(int cpf, long banco, double saldo, boolean especial) {
        this.cpf = cpf;
        this.banco = banco;
        this.saldo = saldo;
        this.especial = especial;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public long getBanco() {
        return banco;
    }

    public void setBanco(long banco) { 
        this.banco = banco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    private double bonificacao() {
        if (especial) {
            return saldo * 0.1;
        } else {
            return saldo * 0.05;
        }
    }

    public double depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado.");
        } else {
            System.out.println("Valor inválido");
        }
        return saldo;
    }

    public double sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
        return saldo;
    }

    public void transferencia(Conta destino, double valor) {
        if (valor <= saldo) {
            sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de: " + valor + " para " + destino.getCpf());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrar() {
        System.out.println("CPF do Titular: " + cpf);
        System.out.println("Número do Banco: " + banco);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("Bonificação: R$" + bonificacao());
    }
}

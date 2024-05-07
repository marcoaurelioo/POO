package ex009;

public class Conta {
	Cliente cliente;
	private double saldo;
	
	public Conta(Cliente cliente, double saldo) {
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
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
		this.saldo = saldo;
	}
	
    public void imprimir() {
        System.out.println("Informações da Conta:");
        cliente.imprimir();
        System.out.println("Saldo: " + saldo);
    }
    
    public void realizarOperacao(Operacao operacao) {
        char tipo = operacao.getTipo();
        double valor = operacao.getValor();
        
        if (tipo == 'D') {
            saldo += valor; 
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        }
        else if (tipo == 'R') {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Retirada de " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar a retirada.");
            }
        } else {
            System.out.println("Tipo de operação inválido.");
        }
    }
}

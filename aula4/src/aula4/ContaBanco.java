package aula4;

public class ContaBanco {
	public long numConta;
	protected String tipo;
	private String dono;
	private float saldo;
	private boolean status;
	
	public void estadoAtual() {
		System.out.println("--------------------------");
		System.out.println("Conta: " + this.getNumConta());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Dono: " + this.getDono());
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println("Status: " + this.getStatus());
	}
	
	public void abrirConta(String t) {
		this.setTipo(t);
		this.setStatus(true);
		if(t == "CC") {
			this.setSaldo(50);
		}
		else if(tipo == "CP") {
			this.setSaldo(150);
		}
	}
	public void fecharConta() {
		if(this.getSaldo() != 0) {
			System.out.println("Nao foi possivel fechar a conta");
		}
		else {
			this.setStatus(false);
			System.out.println("Conta fechada");
		}
	}
	public void depositar(float v) {
		if(this.getStatus()) {
			this.setSaldo(this.getSaldo() + v);
		}
		else {
			System.out.println("Conta inativa, nao foi possivel depositar");
		}
		
	}
	public void sacar(float v) {
		if(this.getStatus()) {
			if(this.getSaldo() >= v) {
				this.setSaldo(this.getSaldo() - v);
			}
			else {
				System.out.println("Saldo insuficiente");
			}
		}
		else {
			System.out.println("Conta inativa, nao foi possivel sacar");
		}
	}
	public void pagarMensal() {
		int v = 0;
		if(this.getTipo() == "CC") {
			v = 12;
		}
		else if(this.getTipo() == "CP") {
			v = 20;
		}
		if(this.getStatus()) {
			this.setSaldo(this.getSaldo() - v);
		}
		else{
			System.out.println("Conta inativa");
		}
	}
	
	public ContaBanco() {
		this.setSaldo(0);
		this.setStatus(false);
	}

	public long getNumConta() {
		return numConta;
	}

	public void setNumConta(long numConta) {
		this.numConta = numConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}

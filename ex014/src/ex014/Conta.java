package ex014;

public class Conta implements Seguranca{
	private String cpf;
	private String senha;
	private double saldo;
	
	public Conta(String cpf, String senha, double saldo) {
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
    @Override
    public boolean verificaSenha(String senha) {
        
        return this.senha.equals(senha);
    }
    
    @Override
    public void mensagemSucesso() {
        System.out.println("Operação realizada com sucesso.");
    }
    
    @Override
    public void mensagemFracasso() {
        System.out.println("Operação falhou devido à senha incorreta.");
    }

    public void saca(String senha, double valor) {
        if(!verificaSenha(senha)) {
            mensagemFracasso();
            return;
        }
        
        if(valor <= 0 || valor > saldo) {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return;
        }
        
        saldo -= valor;
        mensagemSucesso();
        System.out.println("Valor sacado: " + valor);
    }
    
    public void deposita(String senha, double valor) {
        if(!verificaSenha(senha)) {
            mensagemFracasso();
            System.out.println("Senha incorreta.");
            return;
        }
        
        if(valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        
        saldo += valor;
        mensagemSucesso();
        System.out.println("Valor depositado: " + valor);
    }
}

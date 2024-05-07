package ex014;

public class Email implements Seguranca{
	private String nome;
	private String email;
	private String senha;
	
	public Email(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
}

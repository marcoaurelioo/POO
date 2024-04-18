package uec;

public class Lutador {
	private String nome;
	private String nacionalidade;
	private long idade;
	private double altura;
	private double peso;
	private String categoria;
	private int vitorias;
	private int derrotas;
	private int empates;
	
	public Lutador(String no, String na, long id, double al, double pe,
			int vi, int de, int em) {
		this.nome = no;
		this.nacionalidade = na;
		this.idade = id;
		this.altura = al;
		this.setPeso(pe);
		this.vitorias = vi;
		this.derrotas = de;
		this.empates = em;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
		setCategoria();
	}

	public String getCategoria() {
		return categoria;
	}

	private void setCategoria() {
		if(peso<52.2) {
			this.categoria = "invalido";
		} else if(peso <=70.3) {
			this.categoria = "Leve";
		} else if(peso <= 83.9) {
			this.categoria = "Medio";
		} else if(peso<=120.2) {
			this.categoria = "Pesado";
		} else {
			this.categoria = "invalido";
		}
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}
	
	
	public void ganharLuta() {
		this.setVitorias(this.getVitorias()+ 1);
	}
	
	public void perderLuta() {
		this.setDerrotas(this.getDerrotas()+ 1);
	}
	
	public void empatarLuta() {
		this.setEmpates(this.getEmpates()+ 1);
	}
	
	public void apresentar() {
		System.out.println("Nome: " + getNome());
		System.out.println("Idade: " + getIdade());
		System.out.println("Altura: " + getAltura());
		System.out.println("Peso: " + getPeso());
		System.out.println("Cartel: " + getVitorias() + " " + getEmpates() + " " + getDerrotas());
	}
	
	public void status() {
		System.out.println(getCategoria());
	}
}

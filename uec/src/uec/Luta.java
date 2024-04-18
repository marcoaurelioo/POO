package uec;

import java.util.Random;

public class Luta {
	private Lutador desafiado;
	private Lutador desafiante;
	private int rounds;
	private boolean aprovada;
	
	public Lutador getDesafiado() {
		return desafiado;
	}


	public void setDesafiado(Lutador dd) {
		this.desafiado = dd;
	}


	public Lutador getDesafiante() {
		return desafiante;
	}


	public void setDesafiante(Lutador dd) {
		this.desafiante = dd;
	}


	public int getRounds() {
		return rounds;
	}


	public void setRounds(int rounds) {
		this.rounds = rounds;
	}


	public boolean isAprovada() {
		return aprovada;
	}


	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}


	public void marcarLuta(Lutador l1, Lutador l2) {
		if(l1.getCategoria() == l2.getCategoria() && l1!= l2) {
			this.aprovada = true;
			this.desafiado = l1;
			this.desafiante = l2;
		}
		else {
			this.aprovada = false;
			this.desafiado = null;
			this.desafiante = null;
		}
	}
	
	public void lutar() {
		if(this.aprovada) {
			System.out.println("DESAFIADO");
			desafiado.apresentar();
			System.out.println("DESAFIANTE");
			desafiante.apresentar();
			Random aleatorio = new Random();
			
			int vencedor = aleatorio.nextInt(3);
			switch(vencedor) {
			case 0:
				System.out.println("EMPATE");
				desafiado.empatarLuta();
				desafiante.empatarLuta();
				break;
			case 1:
				System.out.println(desafiado.getNome() +" GANHOU");
				desafiado.ganharLuta();
				desafiante.perderLuta();
				break;
			case 2:
				System.out.println(desafiante.getNome() +" GANHOU");
				desafiado.perderLuta();
				desafiante.ganharLuta();
				break;
			}	
		}
		else {
			System.out.println("Luta nao foi aprovada");
		}
	}
	
}

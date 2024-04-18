package ex007;
import java.util.Date;

public class Voo {
    private Date dataOperacao;
    private int quantidadeAssentos;
    private int assentosOcupados;

    public Voo(Date dataOperacao, int quantidadeAssentos) {
        this.dataOperacao = dataOperacao;
        this.quantidadeAssentos = quantidadeAssentos;
        this.assentosOcupados = 0;
    }

    public boolean verifica(int numeroAssento) {
        return numeroAssento > 0 && numeroAssento <= quantidadeAssentos && assentosOcupados >= numeroAssento;
    }

    public void ocupa(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= quantidadeAssentos && !verifica(numeroAssento)) {
            assentosOcupados++;
        }
    }

    public int vagas() {
        return quantidadeAssentos - assentosOcupados;
    }

    public void imprimir() {
        System.out.println("Data do voo: " + dataOperacao);
        System.out.println("Cadeiras disponíveis:");
        for (int i = 1; i <= quantidadeAssentos; i++) {
            if (!verifica(i)) {
                System.out.println("Assento " + i);
            }
        }
    }
}
package ex018;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
    
        int tamanhoVetor = 10;

       
        Veiculo[] veiculos = new Veiculo[tamanhoVetor];

        
        Random random = new Random();
        for (int i = 0; i < tamanhoVetor; i++) {
            int tipoVeiculo = random.nextInt(3); // 0 para Carro, 1 para Moto, 2 para Van

            boolean corMetalica = random.nextBoolean();
            double valorFabricacao = random.nextDouble() * 100000; // Valor de fabricação aleatório até 100000
            int quantidadeDisponivel = random.nextInt(10) + 1; // Quantidade disponível aleatória até 10

            if (tipoVeiculo == 0) {
                int quantidadePortas = random.nextInt(2) + 2; // Carro com 2 ou 4 portas
                boolean cambioAutomatico = random.nextBoolean();
                veiculos[i] = new Carro(corMetalica, valorFabricacao, quantidadeDisponivel, quantidadePortas, cambioAutomatico);
            } else if (tipoVeiculo == 1) {
                int cilindradas = random.nextInt(1000) + 1; // Moto com cilindradas até 1000
                veiculos[i] = new Moto(corMetalica, valorFabricacao, quantidadeDisponivel, cilindradas);
            } else {
                int assentos = random.nextInt(10) + 1; // Van com até 10 assentos
                double peso = random.nextDouble() * 5000 + 1000; // Van com peso de 1000 a 6000 kg
                veiculos[i] = new Van(corMetalica, valorFabricacao, quantidadeDisponivel, assentos, peso);
            }
        }

        // Calculando o maior valor de fabricação associado a um veículo
        double maiorValorFabricacao = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.valorFabricacao > maiorValorFabricacao) {
                maiorValorFabricacao = veiculo.valorFabricacao;
            }
        }

        System.out.println("Maior valor de fabricação associado a um veículo: " + maiorValorFabricacao);
    }
}

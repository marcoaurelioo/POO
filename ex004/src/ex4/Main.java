package ex4;

public class Main {

	public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Fulano");
        cliente1.setCpf(12345678900L);
        cliente1.setEmail("fulano@example.com");
        
        Banco banco = new Banco();
        banco.setCliente(cliente1);
        banco.setSaldo(1000.0); 

        
        System.out.println("Informações da conta antes das operações:");
        banco.imprimir();

        
        Operacao operacao1 = new Operacao();
        operacao1.setTipo('D'); 
        operacao1.setValor(500.0);

        Operacao operacao2 = new Operacao();
        operacao2.setTipo('R');
        operacao2.setValor(200.0);

        Operacao operacao3 = new Operacao();
        operacao3.setTipo('R');
        operacao3.setValor(800.0);

        
        banco.fazOperacao(operacao1);
        banco.fazOperacao(operacao2);
        banco.fazOperacao(operacao3);

       
        System.out.println("\nInformações da conta após as operações:");
        banco.imprimir();
	}

}

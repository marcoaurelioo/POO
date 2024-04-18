package ex3;

public class Main {

	public static void main(String[] args) {
		 Conta minhaConta = new Conta(123456789, 1234, 1000.0, true);
	        
	        minhaConta.mostrar();
	        minhaConta.depositar(500.0);
	        minhaConta.sacar(200.0);
	        
	        Conta outraConta = new Conta(987654321, 5678, 0.0, false);
	        
	        minhaConta.transferencia(outraConta, 300.0);
	        
	        minhaConta.mostrar();
	        outraConta.mostrar();
	}

}

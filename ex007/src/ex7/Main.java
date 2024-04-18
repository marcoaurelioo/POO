package ex7;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
        
		Voo voo = new Voo(new Date(), 10);
        
        System.out.println("O assento 5 está ocupado? " + voo.verifica(5));
        
        voo.ocupa(5);
        
        System.out.println("O assento 5 está ocupado? " + voo.verifica(5));
       
        System.out.println("Número de vagas disponíveis: " + voo.vagas());

        voo.imprimir();

	}

}

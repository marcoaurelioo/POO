package poligonos;

public class Quadrado {
	private double ladoQuadrado;
	
	public Quadrado(double ladoQuadrado) {
		this.ladoQuadrado = ladoQuadrado;
	}





	public void calcularArea() {
		double Area = ladoQuadrado*ladoQuadrado;
		System.out.println("Area do quadrado: " + Area);
		System.out.println("-----------------------------");
		
	}
}

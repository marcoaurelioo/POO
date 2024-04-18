package poligonos;

public class Triangulo {
	private double baseTriangulo;
	private double alturaTriangulo;
	
	public Triangulo(double baseTriangulo, double alturaTriangulo) {
		this.baseTriangulo = baseTriangulo;
		this.alturaTriangulo = alturaTriangulo;
	}


	public void calcularArea() {
		double Area = (baseTriangulo*alturaTriangulo)/2;
		System.out.println("Area do rentagulo: " + Area);
		System.out.println("-----------------------------");
		
	}

}

package poligonos;

public class Retangulo {
	private double baseRetangulo;
	private double alturaRetangulo;
	
	public Retangulo(double baseRetangulo, double alturaRetangulo) {
		this.baseRetangulo = baseRetangulo;
		this.alturaRetangulo = alturaRetangulo;
	}


	public void calcularArea() {
		double Area = baseRetangulo*alturaRetangulo;
		System.out.println("Area do rentagulo: " + Area);
		System.out.println("-----------------------------");
		
	}

}

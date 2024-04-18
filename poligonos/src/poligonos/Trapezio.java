package poligonos;

public class Trapezio {
	private double base1Trapezio;
	private double base2Trapezio;
	private double alturaTrapezio;

	public Trapezio(double base1Trapezio, double base2Trapezio, double alturaTrapezio) {
		this.base1Trapezio = base1Trapezio;
		this.base2Trapezio = base2Trapezio;
		this.alturaTrapezio = alturaTrapezio;
	}




	public void calcularArea() {
		double Area = ((base1Trapezio+base2Trapezio)*alturaTrapezio)/2;
		System.out.println("Area do trapezio: " + Area);
		System.out.println("-----------------------------");
		
	}
}

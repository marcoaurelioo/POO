package poligonos;

public class Main {

	public static void main(String[] args) {
		Poligonos p = new Poligonos();
		p.quadrado = new Quadrado(3);
		p.quadrado.calcularArea();
		p.triangulo = new Triangulo(2.2, 3);
		p.triangulo.calcularArea();
		p.trapezio = new Trapezio(5, 3, 4);
		p.trapezio.calcularArea();
		p.retangulo = new Retangulo(3, 5);
		p.retangulo.calcularArea();
		
		
		
	}

}

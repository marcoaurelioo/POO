package ex016;

public class Imobiliaria {
    private Imovel[] imoveis;
    
    public Imobiliaria(Imovel[] imoveis) {
        this.imoveis = imoveis;
    }
    
    public double calcularMediaPrecoCompra() {
        double total = 0;
        for (Imovel imovel : imoveis) {
            total += imovel.getPrecoCompra();
        }
        return total / imoveis.length;
    }
    
    public int calcularQuantidadeCasas() {
        int quantidade = 0;
        for (Imovel imovel : imoveis) {
            if (imovel instanceof Casa) {
                quantidade++;
            }
        }
        return quantidade;
    }
    
    public int calcularQuantidadeApartamentos() {
        int quantidade = 0;
        for (Imovel imovel : imoveis) {
            if (imovel instanceof Apartamento) {
                quantidade++;
            }
        }
        return quantidade;
    }
    
    public Imovel imovelMaiorPrecoVenda() {
        Imovel maiorPreco = imoveis[0];
        for (int i = 1; i < imoveis.length; i++) {
            if (imoveis[i].calcularPrecoVenda() > maiorPreco.calcularPrecoVenda()) {
                maiorPreco = imoveis[i];
            }
        }
        return maiorPreco;
    }
}

package src.model;

public class LixoCalculator {
    public int calcularTotalLixo(int[] valores) {
        int total = 0;
        for (int valor : valores) {
            total += valor;
        }
        return total;
    }
}

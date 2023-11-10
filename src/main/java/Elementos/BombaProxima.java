package Elementos;

public class BombaProxima extends Celula{
    private int numeroBombas;
    private final boolean isBombAround = true;

    public boolean isIsBombAround() {
        return isBombAround;
    }
    public int getNumeroBombas() {
        return numeroBombas;
    }
    public BombaProxima(boolean isBomb, int row, int col, int numeroBombas) {
        super(isBomb, row, col);
        this.numeroBombas = numeroBombas;
    }


}

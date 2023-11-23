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
    public BombaProxima(int row, int col, int numeroBombas) {
        super( row, col);
        this.numeroBombas = numeroBombas;
    }

    @Override
    public Boolean getIsBomb() {
        return false;
    }
    @Override
    public Boolean getIsVazio() {
        return false;
    }


}

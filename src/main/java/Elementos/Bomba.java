package Elementos;

public class Bomba extends Celula{
    public Bomba(boolean isBomb, int row, int col) {
        super(isBomb, row, col);
        this.setIsBomb(true);
    }
}

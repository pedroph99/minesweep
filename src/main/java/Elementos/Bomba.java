package Elementos;

public class Bomba extends Celula{
    public Bomba(int row, int col) {
        super(row, col);
       
    }

    @Override
    public Boolean getIsBomb() {
        return true;
    }

    @Override
    public Boolean getIsVazio() {
        return false;
    }
}

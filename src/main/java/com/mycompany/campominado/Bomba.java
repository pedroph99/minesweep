package com.mycompany.campominado;

public class Bomba extends Celula{
    public Bomba(boolean isBomb, int row, int col) {
        super(isBomb, row, col);
        this.setIsBomb(true);
    }

    /*public void explodeBomb(){
        System.out.println("BOOOOOOOOOM");
        //Adicionar mais codigo dps.
    }*/
}

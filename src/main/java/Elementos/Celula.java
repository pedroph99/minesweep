/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author pedro
 */
public class Celula {
    private  Boolean isBomb;
    private Boolean isVazio;

    public void setIsVazio(Boolean isVazio) {
        this.isVazio = isVazio;
    }

    public Boolean getIsVazio() {
        return isVazio;
    }
    public void setIsBomb(Boolean isBomb) {
        this.isBomb = isBomb;
    }

    public Boolean getIsBomb() {
        return isBomb;
    }

    public int[] getMatrixPosition() {
        return matrixPosition;
    }

    public int getBombsAround() {
        return bombsAround;
    }
    public int[] matrixPosition;
    public int bombsAround;
    private Boolean isFlagged;
    
    public Celula(boolean isBomb, int row, int col){
        this.isBomb = isBomb;
        this.matrixPosition = new int[2];
        this.matrixPosition[0] = row;
        this.matrixPosition[1] = col;
        this.isFlagged = false;
        this.isVazio = false;
        
        
        
    }
    
    
    public void FlagSetter(){
        if(!this.isFlagged){
            this.isFlagged = true;
        }
        else{
            this.isFlagged = false;
        }
    }

    public Boolean getIsFlagged() {
        return isFlagged;
    }

}
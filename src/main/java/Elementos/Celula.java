/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author pedro
 */
public abstract class Celula {
    
    
    private Boolean isMaluca;

    public void setIsMaluca(Boolean isMaluca) {
        this.isMaluca = isMaluca;
    }

    public Boolean getIsMaluca() {
        return isMaluca;
    }
    
    

    public abstract Boolean getIsVazio();
    
    

    public abstract Boolean getIsBomb();
    
    public int[] getMatrixPosition() {
        return matrixPosition;
    }

    public int getBombsAround() {
        return bombsAround;
    }
    public int[] matrixPosition;
    public int bombsAround;
    private Boolean isFlagged;
    
    public Celula(int row, int col){
        
        this.matrixPosition = new int[2];
        this.matrixPosition[0] = row;
        this.matrixPosition[1] = col;
        this.isFlagged = false;
        
        
        
        
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
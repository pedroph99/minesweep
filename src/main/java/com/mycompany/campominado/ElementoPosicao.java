/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

/**
 *
 * @author pedro
 */
public class ElementoPosicao {
    public Boolean isBomb;
    public int[] matrixPosition;
    public int bombsAround;
    public Boolean isFlagged;
    
    public ElementoPosicao(boolean isBomb, int row, int col){
        this.isBomb = isBomb;
        this.matrixPosition = new int[2];
        this.matrixPosition[0] = row;
        this.matrixPosition[1] = col;
    }
    public void click(){
        if(this.isBomb ==true){
            System.out.println("GameOver.");
        }
    }

    public int bombAround(Field field, int row, int col){
        int bombs = 0;
        for(int i = row- 1; i < row+1; i++){
            for(int j = col- 1; j < col+1; j++){
                if (field.matrix[i][j].isBomb){
                    System.out.println(String.format("Bomba detectada em [%d, %d]", i, j));
                    bombs++;
                }
            }
        }
        return bombs;
    }
}

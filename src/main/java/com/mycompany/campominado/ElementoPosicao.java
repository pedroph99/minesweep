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
    
}

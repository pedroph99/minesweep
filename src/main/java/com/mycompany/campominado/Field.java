/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;
import java.util.Random;

/**
 *
 * @author pedro
 */
public class Field {
    int rows;
    int cols;
    int bombNumber;
    ElementoPosicao[][] matrix;
    
    public Field(int rows, int cols, int bombNumber){
        this.rows = rows;
        this.cols = cols;
        this.bombNumber = bombNumber;
        createMatrix(this.rows, this.cols);
    }
    private void createMatrix(int rows, int cols){
        this.matrix = new ElementoPosicao[rows][cols];
        for(int i=0; i<rows; i++){
            
            this.matrix[i] = new ElementoPosicao[cols];
            
        }
     
    }
    
    public void insertMatrix(ElementoPosicao newElement, int posRow, int posCol ){
        System.out.println(String.format("Feito em %d %d", posRow, posCol));
         this.matrix[posRow][posCol] = newElement;
    }

    public void fillMatrix(){
        for(int i = 0; i < this.rows; i++){
            for(int w = 0; w < this.cols; w++){
                insertMatrix(new ElementoPosicao(false, i, w), i, w);
            }
        }
    }

    public void fillBombs(){
        int bombsLeft = this.bombNumber;
        Random randomNumber = new Random();
        int currentRandom;
        int i = 0;
        int w = 0;
        while(bombsLeft > 0){
            i=0;
            w=0;
            for(i=0; i< this.rows; i++){
                for(w=0; w< this.rows; w++){
                    currentRandom = randomNumber.nextInt(9)+1;
                    if(currentRandom == 1){
                        if(this.matrix[i][w].isBomb == false){
                            insertBomb(i,w);
                            bombsLeft= bombsLeft -1;
                        }
                        else {
                            System.out.println(String.format("Tentou colocar no lugar errado [%d, %d]", i, w));
                        }
                    }
                    else{
                        System.out.println(currentRandom);
                    }
                }
            }
            System.out.println("Testee");
        }
    }

    public void insertBomb(int row, int col){
        System.out.println(String.format("BOMBA COLOCADA EM [%d, %d]", row, col));
        this.matrix[row][col].isBomb = true;
    }
}

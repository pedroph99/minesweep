/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

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
        create_matrix(this.rows, this.cols);
    }
    private void create_matrix(int rows, int cols){
        this.matrix = new ElementoPosicao[rows][cols];
        for(int i=0; i<rows; i++){
            
            this.matrix[i] = new ElementoPosicao[cols];
            
        }
     
    }
    
    public void insert_matrix(ElementoPosicao newElement, int posRow, int posCol ){
         this.matrix[posRow-1][posCol-1] = newElement;
         
     }
}

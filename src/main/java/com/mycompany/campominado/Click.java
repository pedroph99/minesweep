/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

/**
 *
 * @author Usuario
 */
public class Click {
    public  char click(Celula cell, Field field){
        if(cell.getIsBomb()){
            
                System.out.println("BOOOOOOOOOM");
                return 'b';
            }
            else{
                if(!cell.getIsFlagged()){
                    System.out.println(String.format("ROW: %d", cell.matrixPosition[0]));
                    System.out.println(String.format("COL: %d", cell.matrixPosition[1]));
                    int bombas =  this.bombAround(field, cell.matrixPosition[0], cell.matrixPosition[1]);
                    System.out.println(String.format("Bomba em posição [%d,%d] possui %d bombas ao redor", cell.matrixPosition[0], cell.matrixPosition[1], bombas));
                    return 'a';
                    }
                else{
                    
                    System.out.println("Position flagged");
                    return 'f';
                }
    }
    
    }
    
    
    private int bombAround(Field field, int row, int col){
        int bombs= 0;
        
        //Is bomb up?
        if(checkSuperior(row) == true ){
            if(field.matrix[row-1][col].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior");
                bombs++;
            }
        }
        
        //is bomb bomb_superiorleft? ;
        if(checkSuperior(row)== true && checkLeft(col)==true){
            if(field.matrix[row-1][col-1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior esquerdo");
                bombs++;
            }
        }
        
        
        //is bomb bomb_superiorright? ;
        if(checkSuperior(row)== true && checkRight(col, field.cols-1)==true){
            if(field.matrix[row-1][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior direito");
                bombs++;
            }
        }
        //check inferior right
        if(checkInferior(row, field.rows)== true && checkRight(col, field.cols-1)==true){
            if(field.matrix[row+1][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior direito");
                bombs++;
            }
        }
        //check inferior left
        if(checkInferior(row, field.rows-1)== true && checkLeft(col)==true){
            if(field.matrix[row+1][col-1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior esquerdo");
                bombs++;
            }
        }
        
        if(checkRight(col, field.cols-1) == true){
                if(field.matrix[row][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto direito");
                bombs++;
            }
        }
        
        if(checkInferior(row, field.rows-1) == true){
                if(field.matrix[row+1][col].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior");
                bombs++;
            }
        }
        
        
        
        return bombs;
        
        
    }
    
    
    public boolean checkSuperior(int row){
        if(row == 0){
            
            return false;
        }
        return true;
    }
    public boolean checkLeft(int col){
        if(col == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean checkRight(int col, int max){
        if(col == max){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean checkInferior(int row, int max){
        if(row == max){
            return false;
        }
        else{
            return true;
        }
    }
}

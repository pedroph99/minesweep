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
    public  void click(ElementoPosicao cell, Field field){
        if(cell.getIsBomb()){
                System.out.println("BOOOOOOOOOM");
            }
            else{
                if(!cell.getIsFlagged()){
                    int bombas =  this.bombAround(field, cell.matrixPosition[0], cell.matrixPosition[1]);
                    System.out.println(String.format("Bomba em posição [%d,%d] possui %d bombas ao redor", cell.matrixPosition[0], cell.matrixPosition[1], bombas));
                    }
                else{
                    System.out.println("Position flagged");
                }
    }}
    
    
    private int bombAround(Field field, int row, int col){
        int bombs= 0;
        
        //Is bomb up?
        if(check_superior(row) == true ){
            if(field.matrix[row-1][col].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior");
                bombs++;
            }
        }
        
        //is bomb bomb_superiorleft? ;
        if(check_superior(row)== true && check_left(col)==true){
            if(field.matrix[row-1][col-1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior esquerdo");
                bombs++;
            }
        }
        
        
        //is bomb bomb_superiorright? ;
        if(check_superior(row)== true && check_right(col, field.cols-1)==true){
            if(field.matrix[row-1][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto superior direito");
                bombs++;
            }
        }
        //check inferior right
        if(check_inferior(row, field.rows)== true && check_right(col, field.cols-1)==true){
            if(field.matrix[row+1][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior direito");
                bombs++;
            }
        }
        //check inferior left
        if(check_inferior(row, field.rows-1)== true && check_left(row)==true){
            if(field.matrix[row+1][col-1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior esquerdo");
                bombs++;
            }
        }
        
        if(check_right(col, field.cols-1) == true){
                if(field.matrix[row][col+1].getIsBomb() == true){
                System.out.println("Bomba detectada no canto direito");
                bombs++;
            }
        }
        
        if(check_inferior(row, field.rows-1) == true){
                if(field.matrix[row+1][col].getIsBomb() == true){
                System.out.println("Bomba detectada no canto inferior");
                bombs++;
            }
        }
        
        
        
        return bombs;
        
        
    }
    
    
    public boolean check_superior(int row){
        if(row == 0){
            
            return false;
        }
        return true;
    }
    public boolean check_left(int col){
        if(col == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean check_right(int col, int max){
        if(col == max){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean check_inferior(int row, int max){
        if(row == max){
            return false;
        }
        else{
            return true;
        }
    }
}

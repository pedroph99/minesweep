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
        this.isFlagged = false;
        
    }
    public void click(Field field){
            if(this.isBomb ==true){
                System.out.println("BOOOOOOOOOM");
            }
            else{
                if(!this.isFlagged){
                    int bombas =  this.bombAround(field, this.matrixPosition[0], this.matrixPosition[1]);
                    System.out.println(String.format("Bomba em posição [%d,%d] possui %d bombas ao redor", this.matrixPosition[0], this.matrixPosition[1], bombas));
                    }
                else{
                    System.out.println("Position flagged");
                }
                
            }
    }
    
    public void FlagSetter(){
        if(!this.isFlagged){
            this.isFlagged = true;
        }
        else{
            this.isFlagged = false;
        }
        
        
    }
    public int bombAround(Field field, int row, int col){
        int bombs= 0;
        
        //Is bomb up?
        if(check_superior(row) == true ){
            if(field.matrix[row-1][col].isBomb == true){
                System.out.println("Bomba detectada no canto superior");
                bombs++;
            }
        }
        
        //is bomb bomb_superiorleft? ;
        if(check_superior(row)== true && check_left(col)==true){
            if(field.matrix[row-1][col-1].isBomb == true){
                System.out.println("Bomba detectada no canto superior esquerdo");
                bombs++;
            }
        }
        
        
        //is bomb bomb_superiorright? ;
        if(check_superior(row)== true && check_right(col, field.cols-1)==true){
            if(field.matrix[row-1][col+1].isBomb == true){
                System.out.println("Bomba detectada no canto superior direito");
                bombs++;
            }
        }
        //check inferior right
        if(check_inferior(row, field.rows)== true && check_right(col, field.cols-1)==true){
            if(field.matrix[row+1][col+1].isBomb == true){
                System.out.println("Bomba detectada no canto inferior direito");
                bombs++;
            }
        }
        //check inferior left
        if(check_inferior(row, field.rows-1)== true && check_left(row)==true){
            if(field.matrix[row+1][col-1].isBomb == true){
                System.out.println("Bomba detectada no canto inferior esquerdo");
                bombs++;
            }
        }
        
        if(check_right(col, field.cols-1) == true){
                if(field.matrix[row][col+1].isBomb == true){
                System.out.println("Bomba detectada no canto direito");
                bombs++;
            }
        }
        
        if(check_inferior(row, field.rows-1) == true){
                if(field.matrix[row+1][col].isBomb == true){
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

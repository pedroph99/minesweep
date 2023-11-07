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
                    return 'a';
                    }
                else{
                    
                    System.out.println("Position flagged");
                    return 'f';
                }
    }
    
    }
    
    
    

}

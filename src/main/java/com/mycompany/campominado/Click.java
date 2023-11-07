/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import java.util.ArrayList;

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
                    ArrayList<ArrayList<Integer>> visitedPos = new ArrayList<ArrayList<Integer>>() ;
                    checkVazio(cell, field, visitedPos);
                    return 'a';
                    }
                else{
                    
                    System.out.println("Position flagged");
                    return 'f';
                }
    }
    
    }
    
   
    
    
    public void checkVazio(Celula cell, Field field, ArrayList<ArrayList<Integer>> visitedPos){
        
        int row = cell.matrixPosition[0];
        int col = cell.matrixPosition[1];
        if(  !(field.matrix[row][col].getIsVazio())  ){
            return;
        }
        for(int i = -1; i<2; i++){
            for(int w = -1; w<2; w++){
            try {
             ArrayList currentVisited = new ArrayList<Integer>();
             currentVisited.add(row);
             currentVisited.add(col);
             visitedPos.add(currentVisited);
             
            if(field.matrix[row+i][col+w].getIsVazio() && checkPos(visitedPos, row+i, col+w) ){
                System.out.println(String.format("posicao visitada em recursao [%d, %d]", row+i, col+w));
                checkVazio(field.matrix[row+i][col+w], field, visitedPos);
                System.out.println(String.format("Vazio detectado em [%d, %d]", row+i, col+w));
               
            
            }
               
            
        } catch (Exception e) {
            
        }               
            }
           

        }
    }
    
    public boolean checkPos(ArrayList<ArrayList<Integer>> visitedPos, int row, int col){
        for(int i = 0; i<visitedPos.size(); i++){
            if(visitedPos.get(i).get(0) == row && visitedPos.get(i).get(1) == col){
                System.out.println("Encontrei posicao");
                return false;
            }
            
            
        }
        return true;
}
    
    

}

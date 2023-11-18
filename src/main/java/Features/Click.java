/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Elementos.Celula;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Click {
    
    public char click(Celula cell, FieldMaluco field, Jogador currentJogador){
    
    if(cell.getIsBomb()){
            
                System.out.println("BOOOOOOOOOM");
                return 'b';
            }
            else{
                if(!cell.getIsFlagged()){
                    field.AddPosition(cell.getMatrixPosition()[0], cell.getMatrixPosition()[1]);
                    ArrayList<ArrayList<Integer>> visitedPos = new ArrayList<ArrayList<Integer>>() ;
                    checkVazio(cell, field, visitedPos, currentJogador);
                   
                    
                    return 'a';
                    
                    }
                else{
                    
                    System.out.println("Position flagged");
                    
                    return 'f';
                }
    }
    
    }
    public  char click(Celula cell, Field field, Jogador currentJogador){
        if(cell.getIsBomb()){
            
                System.out.println("BOOOOOOOOOM");
                return 'b';
            }
            else{
                if(!cell.getIsFlagged()){
                    field.AddPosition(cell.getMatrixPosition()[0], cell.getMatrixPosition()[1]);
                    ArrayList<ArrayList<Integer>> visitedPos = new ArrayList<ArrayList<Integer>>() ;
                    checkVazio(cell, field, visitedPos, currentJogador);
                   
                    return 'a';
                    
                    }
                else{
                    
                    System.out.println("Position flagged");
                    return 'f';
                }
    }
    
    }
    
   
    
    
    public void checkVazio(Celula cell, FieldPai field, ArrayList<ArrayList<Integer>> visitedPos, Jogador currentJogador){
        
        int row = cell.matrixPosition[0];
        int col = cell.matrixPosition[1];
        
        
        if(  !(field.matrix[row][col].getIsVazio())  ){
            System.out.println("Testando erro");
            return;
        }
        
        ArrayList currentVisited = new ArrayList<Integer>();
        System.out.println("=======================TESTE EM RECURSAO=====================");
             currentVisited.add(row);
             currentVisited.add(col);
             System.out.println(String.format("adicionei a posicao [%d,%d]", row, col));
             if(checkPos(visitedPos, row, col)){
                 visitedPos.add(currentVisited);
             }
             
             field.getClicked_positions().add(currentVisited);
             currentJogador.aumentaPontuacao();
             System.out.println(visitedPos);
        System.out.println("=======================TESTE EM RECURSAO=====================");
        for(int i = -1; i<2; i++){
            for(int w = -1; w<2; w++){
            try {
             
             
            if(field.matrix[row+i][col+w].getIsVazio() && checkPos(visitedPos, row+i, col+w) ){
                System.out.println(String.format("posicao visitada em recursao [%d, %d]", row+i, col+w));
                
                
               
                checkVazio(field.matrix[row+i][col+w], field, visitedPos, currentJogador);
                System.out.println(String.format("Vazio detectado em [%d, %d]", row+i, col+w));
               
            
            }
               
            
        } catch (IndexOutOfBoundsException  e) {
            
        }               
            }
           

        }
    }
    
    private boolean checkPos(ArrayList<ArrayList<Integer>> visitedPos, int row, int col){ // checa se posicao já foi visitada
        for(int i = 0; i<visitedPos.size(); i++){
            if(visitedPos.get(i).get(0) == row && visitedPos.get(i).get(1) == col){
                System.out.println("Encontrei posicao");
                return false;
            }
            
            
        }
        return true;
}
    
    

}

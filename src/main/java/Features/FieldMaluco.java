/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Elementos.Bomba;
import Elementos.BombaProxima;
import Elementos.Vazio;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class FieldMaluco extends FieldPai implements FieldInterface {
    int nivelMaluquisse;
    ArrayList<Integer[]> posicoesMalucas = new ArrayList<Integer[]>();
    
    public FieldMaluco(int rows, int cols,int bombNumber,  int nivelMaluquisse){
        super(rows, cols, bombNumber);
        this.nivelMaluquisse = nivelMaluquisse;
        createMatrix(this.rows, this.cols);
    }

    public void fillMaluco(){
        for(int i = 0; i<this.rows; i++){
            for(int w = 0; w<this.cols; w++){
                AdicionaMaluco(i,w);
                
                
            }
        }
    }

    private void AdicionaMaluco(int row, int col ){
        Random random = new Random();
        int currentNumero =random.nextInt(100);
        
        if (currentNumero<=this.nivelMaluquisse){
            this.matrix[row][col].setIsMaluca(true);
            Integer[] currentpos = {row, col};
            this.posicoesMalucas.add(currentpos);
            System.out.println(String.format("O status agora é : %b em [%d, %d]", this.matrix[row][col].getIsMaluca(), row, col));
            
        }
        
    }
    
    
    public void MudaMaluco(){
        Random random = new Random();
        boolean checker = true;
       int numeroMudancas = (int) Math.floor(this.nivelMaluquisse/3);
       for(int i = 0; i<numeroMudancas; i++){
           System.out.println("COUNTER ++ ");
           checker = true;
           Integer[] currentPosicao = this.posicoesMalucas.get(random.nextInt(this.posicoesMalucas.size()));
           for(int w = 0; w<this.clickedPositions.size(); w++){
               if(this.clickedPositions.get(w).get(0).equals(currentPosicao[0]) && this.clickedPositions.get(w).get(1).equals(currentPosicao[1])){
                   System.out.println(String.format("Tentou mudar em Célula clicada [%d, %d]", currentPosicao[0], currentPosicao[1]));
                   checker = false;
               }
               
               
           }
                   if(checker){
                       insertBombaMaluca(currentPosicao[0],currentPosicao[1]);
                   }
                   
               
       
       }
       
    }
    
    public void insertBombaMaluca(int row, int col){
        if(this.matrix[row][col].getIsBomb()){
            int bombasProximas =this.CheckBombAroundMaluco(row, col);
            if( bombasProximas> 0 ){
                this.matrix[row][col] = new BombaProxima(row, col, bombasProximas );
                System.out.println(String.format("Mudou para BombaProxima___TESTE__ em [%d,%d]", row,col)); //Mudar isto
            }
            
            else{
                this.matrix[row][col] = new Vazio(row, col);
                System.out.println(String.format("Mudou para vazio em [%d,%d]", row,col));
            }
        }
        else{
            System.out.println("======================TESTE BOMBA=================");
           this.matrix[row][col] = new Bomba(row, col);
           System.out.println(String.format("Mudou para bomba em [%d, %d]", row, col) );
           for(int i = -1; i<2; i++){
            for(int w = -1; w<2; w++){
            try {
          
           int bombasProximas = this.CheckBombAround(row+i, col+w);
           if (!(this.matrix[row+i][col+w].getIsBomb())){
               this.matrix[row+i][col+w] = new BombaProxima( row+i, col+w, bombasProximas);
                System.out.println(String.format("Mudou para bombaProxima em [%d, %d]", row+i, col+w) );
           }
           
               
            
        } catch (IndexOutOfBoundsException e) {
            
        }               
            }
           

        }
           System.out.println("======================TESTE BOMBA=================");
        }
    }
    
    private int  CheckBombAroundMaluco(int row, int col){
        int numBomb = 0;
    for(int i = -1; i<2; i++){
            for(int w = -1; w<2; w++){
            try {
                
            if(this.matrix[row+i][col+w].getIsBomb()){
                System.out.println(String.format("Bomba detectada em [%d, %d]", row+i, col+w));
               numBomb++;
            
            }
               
            
        } catch (IndexOutOfBoundsException e) {
            
        }               
            }
           

        }
    System.out.println(String.format("Bomba em [%d, %d] possui %d bombas ao redor", row, col, numBomb));
        return numBomb;
    
    }

    
    @Override
    public int lengthClicked() {
        return this.clickedPositions.size();
           }

    @Override
    public void setIsVazio(Boolean isVazio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int[] ClickedElement(int position) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<ArrayList<Integer>> clickedPositions = new ArrayList<ArrayList<Integer>>() ;

    public ArrayList<ArrayList<Integer>> getClickedPositions() {
        return clickedPositions;
    }
    
    public void AddPosition(int row, int col){
        ArrayList<Integer> current_position = new ArrayList<>();
        current_position.add(row);
        current_position.add(col);
        this.clickedPositions.add(current_position);
    }
    
    public void printClick(){
        System.out.println(clickedPositions);
    }

    

    

    
    
}

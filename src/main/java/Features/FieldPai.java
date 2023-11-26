/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Elementos.Bomba;
import Elementos.BombaProxima;
import Elementos.Celula;
import Elementos.Vazio;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public abstract  class FieldPai {
    int rows;
    int cols;
    int bombNumber;
    Celula[][] matrix;
    ArrayList<ArrayList<Integer>> clickedPositions;
    public FieldPai(int rows, int cols, int bombNumber){
        this.rows = rows;
        this.cols  = cols;
        this.bombNumber = bombNumber;
        this.clickedPositions = new ArrayList<ArrayList<Integer>>() ;
    }
    public Celula[][] getMatrix() {
        return matrix;
    }
    
    public void createMatrix(int rows, int cols){
        this.matrix = new Celula[rows][cols];
        for(int i=0; i<rows; i++){
            System.out.println("Teste matriz");
            this.matrix[i] = new Celula[cols];
            
        }
     
    }
    
    
    public void fillMatrix(){
        for(int i = 0; i<this.rows; i++){
            for(int w = 0; w<this.cols; w++){
                insertMatrix(new Vazio(i, w), i, w);
            }
        }
    }
    
    public void insertMatrix(Celula newElement, int posRow, int posCol ){
         System.out.println(String.format("Feito em %d %d", posRow, posCol));
         this.matrix[posRow][posCol] = newElement;
         
     }
    
    public void fillBombs(){
        
        int bombsLeft = this.bombNumber;
        Random randomNumber = new Random();
        int currentRandomRow;
        int currentRandomCol;
        
        while(bombsLeft > 0){
        currentRandomRow = randomNumber.nextInt(this.rows);
        currentRandomCol = randomNumber.nextInt(this.cols);
        
        if(this.matrix[currentRandomRow][currentRandomCol].getIsBomb() == false || this.matrix[currentRandomRow][currentRandomCol] == null){
                    insertBomb(currentRandomRow,currentRandomCol);
                    bombsLeft = bombsLeft - 1;}
        else{
                        System.out.println(String.format(" Tentou colocar no lugar errado [%d, %d]", currentRandomRow,currentRandomCol));
                    }
        
            System.out.println("Testee");
    }
    }
    
    public void insertBomb(int row, int col){
        System.out.println(String.format("BOMBA COLOCADA EM [%d, %d]", row,col));
        this.matrix[row][col] = new Bomba(row, col);
    }
    
    public int CheckBombAround(int row, int col){
        int numBomb = 0;
        if(this.matrix[row][col].getIsBomb()){
            System.out.println("Pegamos em bomba!!!");
            
            return 0;
        }
        
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
    
    public void insertBombAround(int row, int col){
        
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int numBomb = CheckBombAround(i,j);
                if(!(numBomb == 0)){
                    this.matrix[i][j] = new BombaProxima( i, j, numBomb);
                }
                else {
                    if(!(this.matrix[i][j].getIsBomb())){
                        this.matrix[i][j] = new Vazio( i, j);
                        
                    }
                    
                }
            }
        }
    }
    
    
    
    

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

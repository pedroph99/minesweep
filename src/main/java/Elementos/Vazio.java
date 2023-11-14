package Elementos;

import Elementos.Celula;

public class Vazio extends Celula{
  

   
    public Vazio(boolean isBomb, int row, int col) {
        super(isBomb, row, col);
        this.setIsVazio(true);
        
       
    }
    
    


}

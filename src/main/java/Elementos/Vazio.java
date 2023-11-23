package Elementos;

import Elementos.Celula;

public class Vazio extends Celula{
  

   
    public Vazio(int row, int col) {
        super(row, col);
        
       
    }
    
    @Override
    public Boolean getIsBomb() {
        return false;
    }
    @Override
    public Boolean getIsVazio() {
        return true;
    }
    


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;
import Elementos.Vazio;
import Elementos.BombaProxima;
import Elementos.Bomba;
import Elementos.Celula;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author pedro
 */
public class Field extends FieldPai implements FieldInterface {
    
    

    
    
    
    public Field(int rows, int cols, int bombNumber){
        super(rows, cols, bombNumber);
        createMatrix(this.rows, this.cols);
    }

    
    
    public int lengthClicked(){
        return this.clicked_positions.size();
    }
   
    public int[] ClickedElement(int position){
        int[] positions = {this.clicked_positions.get(position).get(0), this.clicked_positions.get(position).get(1)};
        return positions;
    }

    @Override
    public void setIsVazio(Boolean isVazio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
    
}

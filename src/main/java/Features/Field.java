/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

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
        return this.clickedPositions.size();
    }
   
    public int[] ClickedElement(int position){
        int[] positions = {this.clickedPositions.get(position).get(0), this.clickedPositions.get(position).get(1)};
        return positions;
    }

    @Override
    public void setIsVazio(Boolean isVazio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
    
}

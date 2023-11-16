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
    
    

    public Celula[][] getMatrix() {
        return matrix;
    }
    private ArrayList<ArrayList<Integer>> clicked_positions = new ArrayList<>() ;

    public ArrayList<ArrayList<Integer>> getClicked_positions() {
        return clicked_positions;
    }
    public void printClick(){
        System.out.println(clicked_positions);
    }
    public Field(int rows, int cols, int bombNumber){
        super(rows, cols, bombNumber);
        createMatrix(this.rows, this.cols);
    }

    public void AddPosition(int row, int col){
        ArrayList<Integer> current_position = new ArrayList<>();
        current_position.add(row);
        current_position.add(col);
        this.clicked_positions.add(current_position);
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

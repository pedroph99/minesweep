/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Elementos.Celula;

/**
 *
 * @author Usuario
 */
public class FieldMaluco extends FieldPai implements FieldInterface {
    double nivelMaluquisse;
    
    public FieldMaluco(int rows, int cols,int bombNumber,  double nivelMaluquisse){
        super(rows, cols, bombNumber);
        this.nivelMaluquisse = nivelMaluquisse;
        createMatrix(this.rows, this.cols);
    }

    

    

    @Override
    public void AddPosition(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lengthClicked() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setIsVazio(Boolean isVazio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int[] ClickedElement(int position) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    

    
    
}

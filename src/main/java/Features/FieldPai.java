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
public abstract  class FieldPai {
    int rows;
    int cols;
    int bombNumber;
    
    
    public FieldPai(int rows, int cols, int bombNumber){
        this.rows = rows;
        this.cols  = cols;
        this.bombNumber = bombNumber;
        
    }
}

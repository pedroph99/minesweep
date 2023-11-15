/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

/**
 *
 * @author Usuario
 */
public class FieldMaluco extends FieldPai {
    double nivelMaluquisse;
  
    public FieldMaluco(int rows, int cols,int bombNumber,  double nivelMaluquisse){
        super(rows, cols, bombNumber);
        this.nivelMaluquisse = nivelMaluquisse;
    }
}

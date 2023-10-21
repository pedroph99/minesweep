/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campominado;

/**
 *
 * @author pedro
 */
public class CampoMinado {

    public static void main(String[] args) {
        Field teste_field = new Field(3,3,3);
        ElementoPosicao teste_pos = new ElementoPosicao(false, 3, 3);
        
        
        teste_field.insert_matrix(teste_pos, 3, 3);
        
        System.out.println(teste_field.matrix[2][2].isBomb);
        //System.out.println(teste_pos.isBomb);
        //System.out.println(teste_field.cols);
        
    }
}

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
        
        
        teste_field.fill_matrix();
        teste_field.fill_bombs();
        
        
        System.out.println("====================================TESTE============");
        
        teste_field.matrix[0][0].click(teste_field);
        teste_field.matrix[2][2].click(teste_field);
        teste_field.matrix[1][1].click(teste_field);
        
        
    }
}

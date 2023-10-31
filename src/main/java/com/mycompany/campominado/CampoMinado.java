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
        Celula teste_pos = new Celula(false, 3, 3);
        
        
        teste_field.fill_matrix();
        teste_field.fill_bombs();
       
        
        System.out.println("====================================TESTE============");
        Click clicar = new Click();
        clicar.click( teste_field.matrix[0][0], teste_field);
        clicar.click( teste_field.matrix[2][2], teste_field);
        clicar.click( teste_field.matrix[1][1], teste_field);
        
        
        
    }
}

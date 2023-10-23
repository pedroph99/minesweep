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
        Field testeField = new Field(3,3,3);
        ElementoPosicao testePos = new ElementoPosicao(false, 3, 3);
        
        testeField.fillMatrix();
        testeField.fillBombs();

        System.out.print(testeField.matrix[0][0].bombAround(testeField, 0, 0));

        //testeField.insertMatrix(testePos, 3, 3);
        //System.out.println(testeField.matrix[2][2].isBomb);
        //System.out.println(teste_pos.isBomb);
        //System.out.println(teste_field.cols);
    }
}

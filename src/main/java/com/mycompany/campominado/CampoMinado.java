/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campominado;

import Features.Comunication;
import Features.Jogador;
import Interface.JanelaMaluca;


/**
 *
 * @author pedro
 */
public class CampoMinado {

    public static void main(String[] args) {
        int rows = 9;
        int cols = 9;
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        JanelaMaluca janela = new JanelaMaluca(800,600,rows,cols, Comunication.StartField(rows, cols, 20), jogador1, jogador2 );
        janela.CreateWin();
        
        
        
    }
}

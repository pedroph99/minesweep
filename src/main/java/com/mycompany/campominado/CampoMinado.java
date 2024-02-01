/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campominado;

import Features.Comunication;
import Features.Jogador;
import Features.Score;
import Interface.JanelaMaluca;


/**
 *
 * @author pedro
 */
public class CampoMinado {

    public static void main(String[] args) {
        Comunication.StartMenu();
        Score.createScoreFile();
        //Comunication.StartGame();//Versao do Jogo no Terminal
        
    }
}

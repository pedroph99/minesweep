/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

/**
 *
 * @author Usuario
 */
public class Jogador {
    private int jogador;

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public void aumentaPontuacao(){
        this.pontuacao = pontuacao +1;
    }

    public int getJogador() {
        return jogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    
    public void gameOverMessage(){
        System.out.println(String.format("Game over, player %d lost it", this.jogador));
    }
    public void winMessage(){
        System.out.println(String.format("Player %d wins", this.jogador));
    }
    private int pontuacao= 0;
    
}

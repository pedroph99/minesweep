/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Features.Click;
import Features.Field;
import Features.FieldMaluco;
import Features.Jogador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract  class JanelaJogos extends JanelaPai implements InterfaceJanelas {
    Jogador Jogador1;
    Jogador Jogador2;
    Jogador currentJogador;
    JButton[][] botoes;
    JLabel[] Jogadores;
    boolean flagger;
    
    public boolean isFlagger() {
        return flagger;
    }
    public JanelaJogos(int width, int height, Jogador jogador1, Jogador jogador2, int rows, int cols) {
        super(width, height);
        this.Jogador1 = jogador1;
        this.Jogador2 = jogador2;
        this.currentJogador = jogador1;
        this.botoes = new JButton[rows][cols];
        this.flagger = false;
        this.Jogadores = new JLabel[2];
    }
    
    public void comutaJogador(){ // Troca de jogador ao clicar.
       
    if (this.currentJogador == this.Jogador1){
        System.out.println(String.format("Pontuação do jogador %d agora é %d", this.currentJogador.getJogador(), this.currentJogador.getPontuacao()));
        this.currentJogador = this.Jogador2;
        System.out.println(String.format("Jogador agora é o %d", this.currentJogador.getJogador()));
        
    }
    else{
        this.currentJogador = this.Jogador1;
    }
    
    
}
    
    public void criaBotaoFlag(JPanel panel){
        JButton botaoFlag = new JButton("Flag");
        botaoFlag.setName("true");
        botaoFlag.addActionListener(new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
                ComutaFlagger();
        }
           
        });
        
        panel.add(botaoFlag);
    }
    
    public void ComutaFlagger(){
        if (this.flagger == false){
        this.flagger = true;
        
        
    }
    else{
        this.flagger = false;
    }
        System.out.println(this.flagger);
    }
    
    
    public int checkType(Field field, int row, int col, JLabel[] jogadores){
        
        Click clique = new Click(); // Cria uma instância para clique
        int TamanhoOld = field.lengthClicked();
        clique.click(field.getMatrix()[row][col], field, this.currentJogador);
        int TamanhoNew = field.lengthClicked(); // Antes e depois do clique.. o quanto mudou
        
        
        System.out.println("==========================TESTE==================");
        System.out.println(field.getClicked_positions());
        System.out.println("==========================TESTE==================");
        ArrayList<ArrayList<Integer>> ListaClicados = field.getClicked_positions();
        System.out.println(String.format("old click: %d   New_Click: %d", TamanhoOld, TamanhoNew));
        aumentaPontuacaoTexto(jogadores, -TamanhoOld+TamanhoNew);
        
        for(int i=TamanhoOld; i<TamanhoNew; i++){
            
            ArrayList<Integer> CurrentClicado = ListaClicados.get(i);
            System.out.println(this.botoes[0][0]);
            System.out.println(String.format("nova pos: [%d, %d]", CurrentClicado.get(0), CurrentClicado.get(1)));
            System.out.println(CurrentClicado.get(0));
           
            JButton  NovoVazio = this.botoes[CurrentClicado.get(0)][CurrentClicado.get(1)];
            NovoVazio.setText("");
            NovoVazio.setBackground(Color.green);
            NovoVazio.setEnabled(false);
            
            int TesteBombaProxima = field.CheckBombAround(CurrentClicado.get(0), CurrentClicado.get(1));
            System.out.println(String.format("BOMBAS PROXIMAS EM [%d,%d] é %d", CurrentClicado.get(0),CurrentClicado.get(1),  TesteBombaProxima));
            if(TesteBombaProxima>0){
                System.out.println("TESTANDO AQUI");
                NovoVazio.setText(String.valueOf(TesteBombaProxima));
                NovoVazio.setBackground(Color.yellow);
                NovoVazio.setEnabled(false);
            }
        }
        // Se bomba, red. Se vazio, green. Se BombaProxima, Yellow
        if(field.getMatrix()[row][col].getIsBomb()){ 
            
            return 10;
        }
        else if( field.getMatrix()[row][col].getIsVazio()){
            return 0;
        }
        else {
            this.currentJogador.aumentaPontuacao();
            return field.CheckBombAround(row, col);
        }
        
    }
    public void aumentaPontuacaoTexto(JLabel[] jogadores, int aumento){
        JLabel current  = jogadores[this.currentJogador.getJogador()-1];
       
           String currentText =  current.getText();
       String[] divisao =  currentText.split(" ");
       String pontuacao = divisao[divisao.length -1];
       Integer pontuacaoNumber = Integer.valueOf(pontuacao);
       pontuacaoNumber =  pontuacaoNumber + aumento;
       
       current.setText(String.valueOf(String.format("Pontuação jogador %d: ", this.currentJogador.getJogador()) +pontuacaoNumber));
        System.out.println(String.format("TESTE PONTUACAO =====%s", pontuacao));
       
       
           
       
       
    }
    public int checkType(FieldMaluco field, int row, int col, JLabel[] jogadores){
        
        Click clique = new Click(); // Cria uma instância para clique
        int TamanhoOld = field.lengthClicked();
        clique.click(field.getMatrix()[row][col], field, this.currentJogador);
        int TamanhoNew = field.lengthClicked(); // Antes e depois do clique.. o quanto mudou
        
        
        
        
        
        System.out.println("==========================TESTE==================");
        System.out.println(field.getClicked_positions());
        System.out.println("==========================TESTE==================");
        ArrayList<ArrayList<Integer>> ListaClicados = field.getClicked_positions();
        System.out.println(String.format("old click: %d   New_Click: %d", TamanhoOld, TamanhoNew));
        for(int i=TamanhoOld; i<TamanhoNew; i++){
            
            ArrayList<Integer> CurrentClicado = ListaClicados.get(i);
            System.out.println(this.botoes[0][0]);
            System.out.println(String.format("nova pos: [%d, %d]", CurrentClicado.get(0), CurrentClicado.get(1)));
            System.out.println(CurrentClicado.get(0));
            
            
            JButton  NovoVazio = this.botoes[CurrentClicado.get(0)][CurrentClicado.get(1)];
            NovoVazio.setText("");
            NovoVazio.setBackground(Color.green);
            NovoVazio.setEnabled(false);
            int TesteBombaProxima = field.CheckBombAround(CurrentClicado.get(0), CurrentClicado.get(1));
           
            if(TesteBombaProxima>0){
                System.out.println("TESTANDO AQUI");
                NovoVazio.setText(String.valueOf(TesteBombaProxima));
                NovoVazio.setBackground(Color.yellow);
                NovoVazio.setEnabled(false);
            }
            
            
        }
        // Se bomba, red. Se vazio, green. Se BombaProxima, Yellow
        if(field.getMatrix()[row][col].getIsBomb()){ 
            
            return 10;
        }
        else if( field.getMatrix()[row][col].getIsVazio()){
            return 0;
        }
        else {
            this.currentJogador.aumentaPontuacao();
            return field.CheckBombAround(row, col);
        }
        
    }
    public  void createJogadores(JPanel panel){
        JLabel jogador1 = new JLabel("Pontuação jogador 1: 0");
        JLabel jogador2 = new JLabel("Pontuação jogador 2: 0");
        this.Jogadores[0] = jogador1;
        this.Jogadores[1] = jogador2;
        panel.add(jogador1);
        panel.add(jogador2);
        
    }
    
    
    

    
}

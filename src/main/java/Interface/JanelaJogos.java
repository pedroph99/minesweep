/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Features.Click;
import Features.Comunication;
import Features.Field;
import Features.FieldMaluco;
import Features.FieldPai;
import Features.Jogador;
import java.awt.Color;
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
    public int correctPos;
    public int flagsUsed;
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
    public JanelaJogos(int width, int height, Jogador jogador1, int rows, int cols) {
        super(width, height);
        this.Jogador1 = jogador1;
        this.currentJogador = jogador1;
        this.botoes = new JButton[rows][cols];
        this.flagger = false;
        this.Jogadores = new JLabel[2];
    }
    
    public void comutaJogador(boolean multiplayer){ // Troca de jogador ao clicar.
    if(multiplayer){
        if (this.currentJogador == this.Jogador1){
        System.out.println(String.format("Pontuação do jogador %d agora é %d", this.currentJogador.getJogador(), this.currentJogador.getPontuacao()));
        this.currentJogador = this.Jogador2;
        System.out.println(String.format("Jogador agora é o %d", this.currentJogador.getJogador()));
        
    }
    else{
        this.currentJogador = this.Jogador1;
    }
    }
    
    
    
}
    
    public void criaBotaoFlag(JPanel panel, FieldPai field){
        JButton botaoFlag = new JButton("Flag");
        
        botaoFlag.setName("true");
        botaoFlag.addActionListener(new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.bombGetter());
                
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
        
        comutaFlagButtons(this.flagger);
        System.out.println(this.flagger);
    }
    private void comutaFlagButtons(boolean state){
        for(JButton[] botaoArray : this.botoes){
            for(JButton botao : botaoArray){
                if(botao.getText().equals("🚩")){
                    botao.setEnabled(state);
                }
            }
        }
    }
    
    public int checkType(FieldPai field, int row, int col, JLabel[] jogadores){
        
        Click clique = new Click(); // Cria uma instância para clique
        int TamanhoOld = field.lengthClicked();
        clique.click(field.getMatrix()[row][col], field, this.currentJogador);
        int TamanhoNew = field.lengthClicked(); // Antes e depois do clique.. o quanto mudou
        
    
        ArrayList<ArrayList<Integer>> ListaClicados = field.getClickedPositions();
      
        aumentaPontuacaoTexto(jogadores, -TamanhoOld+TamanhoNew);
        
        for(int i=TamanhoOld; i<TamanhoNew; i++){
            
            ArrayList<Integer> CurrentClicado = ListaClicados.get(i);
        
           
            JButton  NovoVazio = this.botoes[CurrentClicado.get(0)][CurrentClicado.get(1)];
            NovoVazio.setText("");
            NovoVazio.setBackground(Color.green);
            NovoVazio.setEnabled(false);
            
            int TesteBombaProxima = field.CheckBombAround(CurrentClicado.get(0), CurrentClicado.get(1));
            if(TesteBombaProxima>0){
        
                NovoVazio.setText(String.valueOf(TesteBombaProxima));
                NovoVazio.setBackground(Color.yellow);
                NovoVazio.setEnabled(false);
            }
        }
        currentJogador.aumentaPontuacao(TamanhoNew-TamanhoOld);
        // Se bomba, red. Se vazio, green. Se BombaProxima, Yellow
        if(field.getMatrix()[row][col].getIsBomb()){ 
            
            return 10;
        }
        else if( field.getMatrix()[row][col].getIsVazio()){
            return 0;
        }
        else {
           
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
    
    public  void createJogadores(JPanel panel){
        JLabel jogador1 = new JLabel("Pontuação jogador 1: 0");
        JLabel jogador2 = new JLabel("Pontuação jogador 2: 0");
        this.Jogadores[0] = jogador1;
        this.Jogadores[1] = jogador2;
        panel.add(jogador1);
        panel.add(jogador2);
        
    }
    
    public JLabel createFlag(JPanel panel, FieldPai field){
        String texto = "Flags restantes: "+ Integer.toString(field.bombGetter());
        JLabel labelFlag= new JLabel(texto);
        panel.add(labelFlag);
        return labelFlag;
    }
    
    public void gameOver(JFrame frame, FieldPai field, int rows, int cols, JLabel jogador1, JLabel jogador2, boolean multiplayer){
        activateAllBombs(field, rows, cols);
        escolheVencedor(jogador1, jogador2, multiplayer);
        
        
    }
    
    
        public void activateAllBombs(FieldPai field, int rows, int cols){
        for(int i=0; i<rows; i++){
            for(int w = 0; w<cols; w++){
               if(field.getMatrix()[i][w].getIsBomb()){
                   this.botoes[i][w].setBackground(Color.red);
                   this.botoes[i][w].setText("💣");
               }
                   this.botoes[i][w].setEnabled(false);
            }
            
            
            
        }
     
    }
        
        public void escolheVencedor(JLabel jogador1, JLabel jogador2, boolean multiplayer){
            jogador2.setText("");
            this.comutaJogador(multiplayer);
            int pontuacao = this.currentJogador.getPontuacao();
            
            jogador1.setText(String.format("Jogador %d é o vencedor com %d pontos", this.currentJogador.getJogador(), pontuacao));
            
            
            
        }
        public void escolheVencedor(JLabel jogador1, JLabel jogador2, boolean multiplayer, boolean winByEndGame){
            jogador2.setText("");
            int pontuacao = this.currentJogador.getPontuacao();
            jogador1.setText(String.format("Jogador %d é o vencedor com %d pontos", this.currentJogador.getJogador(), pontuacao));
            
            
            
        }
        
        
        public void botaoMenu(JPanel panelFlag, JFrame frame){
  
            JButton botaomenu = new JButton("Main Menu");
            botaomenu.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Comunication.StartMenu();
                }
                
            });
            panelFlag.add(botaomenu);
        }
        
        public void increaseCorrectPos(){
    this.correctPos++;
            System.out.println(this.correctPos);

    
}
    
    public void decreaseCorrectPos(){
        this.correctPos--;
        System.out.println(this.correctPos);
        System.out.println(this.correctPos);
    }
    
    public void winTheGame(JFrame frame, FieldPai field,  JLabel jogador1, JLabel jogador2, boolean multiplayer ){
        
        escolheVencedor(jogador1, jogador2, multiplayer, true);
    }
   
    
    
    }
    
    

    


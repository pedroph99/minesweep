/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Features.Comunication;
import Features.Field;
import Features.Jogador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class MainMenu extends JanelaPai implements InterfaceJanelas{
    public boolean gameStart = false;
    private int numDeJogadores = 1;

    private int tamanhoTabuleiro = 18;
    public MainMenu(int width, int height){
        super(width, height);
        
        
    }

    @Override
    public void createWin() {
        JFrame chooseGameFrame = new JFrame("Menu principal");
        chooseGameFrame.setLayout(new GridLayout(1,2));
        chooseGameFrame.setMinimumSize(new Dimension(this.width, this.height));
        chooseGameFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        chooseGameFrame.setLocationRelativeTo(null);
        criaBotaoGameTypes(chooseGameFrame, false);
        criaBotaoGameTypes(chooseGameFrame, true);
        criaBotaoDifficulty(chooseGameFrame, 1);
        //criaBotaoDifficulty(chooseGameFrame, 2);
        //criaBotaoDifficulty(chooseGameFrame, 3);
        chooseGameFrame.pack();
        chooseGameFrame.setVisible(true);


    }

    public void criaBotaoGameTypes(JFrame frame, boolean maluco){
        
        JButton currentBotao = new JButton("Campo Minado");
        if(maluco){
            currentBotao.setText("Campo minado maluco ");
        }
        currentBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(maluco){
                    
                    startMalucoGame();
                }
                else{
                    startNormalGame();
                }


               frame.dispose();
                
            }
            
        });
        frame.add(currentBotao);
    }

    public void criaBotaoDifficulty(JFrame frame, int difficulty){

        JButton currentBotao = new JButton("Facil");
        if(difficulty == 2){
            currentBotao.setText("Medio");
        } else if (difficulty == 3) {
            currentBotao.setText("Dificil");
        }
        currentBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(difficulty == 3){

                    tamanhoTabuleiro = 27;
                }
                else if (difficulty == 2){
                    tamanhoTabuleiro = 18;
                }
                else {
                    tamanhoTabuleiro = 9;
                }
                currentBotao.setBackground(Color.green);

            }

        });
        frame.add(currentBotao);
    }

    
    public void startNormalGame(){ // Substitui o StartGame(), já que bugou.
        
        Field teste_field = Comunication.StartField(tamanhoTabuleiro, tamanhoTabuleiro);
        Jogador player1 = new Jogador();
        player1.setJogador(1);

        Jogador player2 = new Jogador(); //Create objects jogador
        player2.setJogador(2); // set jogadores numero;
        MainWindow MainJanela = new MainWindow(tamanhoTabuleiro,tamanhoTabuleiro,800,600, teste_field, player1, player2);
        MainJanela.createWin();//Create mainWin to integrate with game

    }
    public  void startMalucoGame(){

        Jogador jogador1 = new Jogador();
        jogador1.setJogador(1);
        Jogador jogador2 = new Jogador();
        jogador2.setJogador(2);
        JanelaMaluca janela = new JanelaMaluca(800,600,tamanhoTabuleiro, tamanhoTabuleiro, Comunication.StartField(tamanhoTabuleiro, tamanhoTabuleiro, 20), jogador1, jogador2 );
        janela.createWin();

    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

}

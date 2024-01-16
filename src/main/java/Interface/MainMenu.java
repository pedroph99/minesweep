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
import javax.swing.*;
import javax.swing.text.FlowView;

/**
 *
 * @author Usuario
 */
public class MainMenu extends JanelaPai implements InterfaceJanelas{
    public boolean gameStart = false;
    private int numDeJogadores = 1;
    public boolean multiplayer = false;

    private static int tamanhoTabuleiro = 18;
    public MainMenu(int width, int height){
        super(width, height);


    }

    
   
    @Override
    public void createWin() {
        JFrame chooseGameFrame = new JFrame("Menu principal");
        chooseGameFrame.setLayout(new FlowLayout());
        chooseGameFrame.setMinimumSize(new Dimension(this.width, this.height));
        chooseGameFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        chooseGameFrame.setLocationRelativeTo(null);
        
        
        criaBotaoGameTypes(chooseGameFrame, false);
        criaBotaoGameTypes(chooseGameFrame, true);
        
        criaCheckBoxDifficulty(chooseGameFrame, 1);
        criaCheckBoxDifficulty(chooseGameFrame, 2);
        criaCheckBoxDifficulty(chooseGameFrame, 3);
        
        criaCheckBoxMultiplayer(chooseGameFrame);
        chooseGameFrame.pack();
        chooseGameFrame.setVisible(true);


    }
    public void criaCheckBoxMultiplayer(JFrame frame){
        JCheckBox checkBox = new JCheckBox("2 player", false);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Função a ser chamada quando o JCheckBox é clicado
                if (checkBox.isSelected()) {
                    comutaMultiPlayer();
                    
                    
                } else {
                    System.out.println("JCheckBox foi desmarcado");
                    // Chame sua função aqui
                   comutaMultiPlayer();
                }
            }
        });
        
        frame.add(checkBox);
    }
    
    public void criaBotaoGameTypes(JFrame frame, boolean maluco){
        JButton currentBotao = new JButton("Campo Minado");
        currentBotao.setPreferredSize(new Dimension(frame.getWidth()/2, frame.getHeight()/2));
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
        JPanel modesPanel = new JPanel();
        modesPanel.setLayout(new GridLayout(1, 2));
        modesPanel.add(currentBotao);
        frame.add(modesPanel);
    }

    public void criaCheckBoxDifficulty(JFrame frame, int difficulty) {
        JCheckBox currentCheckBox = new JCheckBox("Facil");

        if (difficulty == 2) {
            currentCheckBox.setText("Medio");
        } else if (difficulty == 3) {
            currentCheckBox.setText("Dificil");
        }

        currentCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCheckBox.isSelected()) {
                    // Set the selected difficulty
                    if (difficulty == 3) {
                        tamanhoTabuleiro = 27;
                    } else if (difficulty == 2) {
                        tamanhoTabuleiro = 18;
                    } else {
                        tamanhoTabuleiro = 9;
                    }

                    // Deselect other checkboxes
                    Component[] components = frame.getContentPane().getComponents();
                    for (Component component : components) {
                        if (component instanceof JPanel) {
                            JPanel panel = (JPanel) component;
                            for (Component innerComponent : panel.getComponents()) {
                                if (innerComponent instanceof JCheckBox && innerComponent != currentCheckBox) {
                                    ((JCheckBox) innerComponent).setSelected(false);
                                }
                            }
                        }
                    }
                } else {
                    // Handle deselection if needed
                }
            }
        });

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new FlowLayout());
        difficultyPanel.add(currentCheckBox);
        frame.add(difficultyPanel);
    }

    public void startNormalGame(){ // Substitui o StartGame(), já que bugou.
        boolean multiplayer = this.getValueMultiplayer();
        System.out.println("TESTANDO MUTLIPLAYER" + multiplayer );
        Field teste_field = Comunication.StartField(tamanhoTabuleiro, tamanhoTabuleiro);
        Jogador player1 = new Jogador();
        player1.setJogador(1);
        
        
        if (multiplayer){
            
            Jogador player2 = new Jogador(); //Create objects jogador
            player2.setJogador(2); // set jogadores numero;
            MainWindow MainJanela = new MainWindow(tamanhoTabuleiro,tamanhoTabuleiro,800,600, teste_field, player1, player2, this.multiplayer);
            MainJanela.createWin();//Create mainWin to integrate with game
            
        }
        else{
            
            MainWindow MainJanela = new MainWindow(tamanhoTabuleiro,tamanhoTabuleiro,800,600, teste_field, player1, null, this.multiplayer);
           
            MainJanela.createWin();//Create mainWin to integrate with game
        }
 
        
        

    }
    public  void startMalucoGame(){

        Jogador jogador1 = new Jogador();
        jogador1.setJogador(1);
        Jogador jogador2 = new Jogador();
        jogador2.setJogador(2);
        JanelaMaluca janela = new JanelaMaluca(800,600,tamanhoTabuleiro, tamanhoTabuleiro, Comunication.StartField(tamanhoTabuleiro, tamanhoTabuleiro, 20), jogador1, jogador2, this.getValueMultiplayer() );
        janela.createWin();

    }

    public static int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }
    
    public boolean getValueMultiplayer(){
        return this.multiplayer;
    }
    public void comutaMultiPlayer(){
        if(this.multiplayer){
            this.multiplayer = false;
        }
        else{
            this.multiplayer = true;
        }
    }

}

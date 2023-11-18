/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Features.Comunication;
import Features.Field;
import Features.Jogador;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class MainMenu extends JanelaPai implements InterfaceJanelas{
    public boolean gameStart = false;
    public MainMenu(int width, int height){
        super(width, height);
        
        
    }

    @Override
    public void CreateWin() {
        JFrame frame = new JFrame("Menu principal");
        frame.setMinimumSize(new Dimension(this.width, this.height));
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        CriaBotao(frame);
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    public void CriaBotao(JFrame frame){
        JButton currentBotao = new JButton("Start Minesweeper");
        currentBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Start();
                System.out.println("OK");
               frame.dispose();
                
                
            }
            
        });
        frame.add(currentBotao);
        
        
    }
    
    public void Start(){ // Substitui o StartGame(), já que bugou.
        
        Field teste_field = Comunication.StartField(9, 9);
        Jogador player1 = new Jogador();
        player1.setJogador(1);
        
        Jogador player2 = new Jogador(); //Create objects jogador
        player2.setJogador(2); // set jogadores numero;
        MainWindow MainJanela = new MainWindow(9,9,800,600, teste_field, player1, player2);
        MainJanela.CreateWin();//Create mainWin to integrate with game
        
        
        
        
        
    }

   

    

    
}

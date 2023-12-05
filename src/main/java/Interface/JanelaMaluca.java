/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Features.Comunication;
import Features.FieldMaluco;
import Features.Jogador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class JanelaMaluca extends JanelaJogos implements InterfaceJanelas {
    int rows;
    int cols;
    FieldMaluco field;
    public JanelaMaluca(int width, int height, int rows, int cols, FieldMaluco field, Jogador jogador1, Jogador jogador2){
        super(width, height, jogador1, jogador2, rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.field = field;
    }
    

   
    

    public  void createWin(){
        
        JFrame frame2 = new JFrame("Campo minado");
        JPanel PainelMatriz = new JPanel();
        JPanel PainelAux = new JPanel();
        JPanel PainelJogadores = new JPanel();
        System.out.println("PEDRO TESTES");
        
        
        
        // set frame site
        frame2.setMinimumSize(new Dimension(this.width, this.height));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the JLabel
       
        PainelMatriz.setLayout(new GridLayout(this.rows, this.cols));
        PainelJogadores.setLayout(new GridLayout(1,2));
        for(int i=0; i<rows; i++){
            for(int w=0; w<cols; w++){
                createButton(this.field, PainelMatriz, PainelAux, frame2, i, w, this.Jogadores, this.rows, this.cols );
           
            }
            
        }
        
        // add JLabel to JFrame
        criaBotaoFlag(PainelAux);
        

        // display it
        frame2.setLayout(new GridLayout(3, 1));
        frame2.add(PainelMatriz);
        frame2.add(PainelAux);     
        createJogadores(PainelJogadores);
        frame2.add(PainelJogadores);
        frame2.pack();
        frame2.setVisible(true);
    }

    
    public void createButton(FieldMaluco field, JPanel frame, JPanel panelaux, JFrame frameJanela, int row, int col, JLabel[] jogadores, int fieldrows, int fieldcols ) {
    JButton CurrentButton = new JButton();
        this.botoes[row][col] = CurrentButton;
        CurrentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFlagger()){
                    CurrentButton.setBackground(Color.pink);
                    CurrentButton.setText("🚩");
                    CurrentButton.setEnabled(false);
                }
                else{
                    
                int checker = checkType(field, row, col, Jogadores);
                if(checker == 10){
                    CurrentButton.setBackground(Color.red);

                        
                       gameOver(frameJanela, field, fieldrows, fieldcols, jogadores[0], jogadores[1]);
                       botaoMenu(panelaux, frameJanela);
                    
                }
                else if( checker == 0){
                    CurrentButton.setBackground(Color.green);
                }
                else{
                    CurrentButton.setBackground(Color.yellow);
                    CurrentButton.setText(String.format("%d", checker));
                    
                }
                System.out.println(CurrentButton.getName());
                
                CurrentButton.setEnabled(false); // Botão não pode ser mais clicado para evitar problemas.
                
                comutaJogador();// Muda de jogador após o EventClick
                mudancaMaluca();// Realiza a mudança, característica principal do CampoMinadoMaluco
                 }}
        }
                
    
        
        );
        CurrentButton.setName(String.format("%d,%d", row, col)); // Informações para o botão. Identificador.
        frame.add(CurrentButton);    
    
    }
    
    public  void StartMaluco(){
        
        FieldMaluco testeField = Comunication.StartField(4, 4, 10);
       
        Jogador player1 = new Jogador();
        player1.setJogador(1);
        
        Jogador player2 = new Jogador(); //Create objects jogador
        player2.setJogador(2); // set jogadores numero;
        JanelaMaluca MainJanela = new JanelaMaluca(9,9,800,600, testeField, player1, player2);
        MainJanela.createWin();//Create mainWin to integrate with game
        

    }
    public void mudancaMaluca(){
        this.field.MudaMaluco();
        updatePositions();
    }
    
    public void updatePositions(){
        for(int i = 0; i<this.field.getClickedPositions().size(); i++){
            
            int currentrow = this.field.getClickedPositions().get(i).get(0);
            int currentcol = this.field.getClickedPositions().get(i).get(1);
            System.out.println(String.format("Checking [%d,%d]", currentrow,currentcol));
            int bombas  = this.field.CheckBombAround(currentrow, currentcol);
            if(bombas>0){
                System.out.println(String.format("Era pra mudar em [%d,%d]", currentrow,currentcol));
                this.botoes[currentrow][currentcol].setBackground(Color.yellow);
                this.botoes[currentrow][currentcol].setText(String.valueOf(bombas));
            }
        }
    }
}

package Interface;


import Features.Click;
import Features.Field;
import Features.FieldPai;
import Features.Jogador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class MainWindow extends JanelaJogos implements InterfaceJanelas {
    
    private int rows;
    private Field field;
    private Jogador currentJogador;
    private Jogador Jogador1;
    private Jogador Jogador2;
    private boolean flagger;
    private boolean multiplayer;
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    
    private int cols;
    
    public MainWindow(int rows, int cols, int width, int height, Field field, Jogador jogador1, Jogador jogador2, boolean multiplayer){
        super(width, height, jogador1, jogador2, rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.field = field;
        this.correctPos = 0;
        this.multiplayer = multiplayer;
    }
    public MainWindow(int rows, int cols, int width, int height, Field field, Jogador jogador1){
        super(width, height, jogador1, rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.field = field;
        this.correctPos = 0;
    }
    @Override
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
        criaBotaoFlag(PainelAux, this.field);
       

        // display it
        frame2.setLayout(new GridLayout(3, 3));
        frame2.add(PainelMatriz);
        frame2.add(PainelAux);       
        createJogadores(PainelJogadores);
        frame2.add(PainelJogadores);
        frame2.pack();
        frame2.setVisible(true);
    }
    
    private void createButton(Field field, JPanel frame,JPanel panelaux, JFrame frameJanela, int row, int col, JLabel[] jogadores, int fieldrows, int fieldcols){ // Cria botões e os registra em um array de JButtons.
        System.out.println("TESTANDO BOTOES");
        
        JButton currentButton = new JButton();
        this.botoes[row][col] = currentButton;
        ActionListener acao = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFlagger()){
                    String nameButton = currentButton.getName();
                        String[] splitted = nameButton.split(","); 
                        boolean teste = field.checkPositionBomb(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]) );
                    if(currentButton.getText().equals("🚩")){
                        System.out.println("teste flagger22");
                        currentButton.setBackground(Color.lightGray);
                        currentButton.setText("");
                        currentButton.setEnabled(true);
                        if(teste){
                            decreaseCorrectPos();
                        }
                        return;
                        
                    }
                    else{
                         currentButton.setBackground(Color.pink);
                         currentButton.setText("🚩");
                         if(teste){
                             increaseCorrectPos();
                             checkVictory(frameJanela, field, jogadores[0], jogadores[1], multiplayer, panelaux);
                         }
                    }
                    
                   
                }
                else{
                    
                    
                int checker = checkType(field, row, col, Jogadores);
                if(checker == 10){
                    currentButton.setBackground(Color.red);
                    gameOver(frameJanela, field, fieldrows, fieldcols, jogadores[0], jogadores[1], multiplayer);
                    botaoMenu(panelaux, frameJanela);
                    
                }
                
                
                else if( checker == 0){
                    currentButton.setBackground(Color.green);
                }
                else{
                    currentButton.setBackground(Color.yellow);
                    currentButton.setText(String.format("%d", checker));
                    
                }
                System.out.println(currentButton.getName());
                
                currentButton.setEnabled(false); // Botão não pode ser mais clicado para evitar problemas.
                
              
                    comutaJogador(multiplayer);
             
             
                
                 }}
        };
                
        currentButton.addActionListener(acao);
                
    
        
        
        currentButton.setName(String.format("%d,%d", row, col)); // Informações para o botão. Identificador.
        frame.add(currentButton);
    }
    
    public void checkVictory(JFrame frame, FieldPai field,  JLabel jogador1, JLabel jogador2, boolean multiplayer, JPanel panelaux){
        if (this.correctPos == this.field.bombGetter()){
            System.out.println("Vitória!!!!!!!!!!!!!!!");
            winTheGame(frame, field,  jogador1, jogador2, multiplayer);
            botaoMenu(panelaux, frame);
            for(JButton[] botoesRow: this.botoes){
                for(JButton botao: botoesRow){
                    botao.setEnabled(false);
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    


    

    
}

package Interface;


import Features.Click;
import Features.Field;
import Features.Jogador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    
    private int cols;
    
    public MainWindow(int rows, int cols, int width, int height, Field field, Jogador jogador1, Jogador jogador2){
        super(width, height, jogador1, jogador2, rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.field = field;
        
    
       
        
        
    }
    @Override
    public  void CreateWin(){
        
        JFrame frame2 = new JFrame("Campo minado");
        JPanel PainelMatriz = new JPanel();
        JPanel PainelAux = new JPanel();
        System.out.println("PEDRO TESTES");
        
        
        
        // set frame site
        frame2.setMinimumSize(new Dimension(this.width, this.height));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the JLabel
       
        PainelMatriz.setLayout(new GridLayout(this.rows, this.cols));
        
        for(int i=0; i<rows; i++){
            for(int w=0; w<cols; w++){
                createButton(this.field, PainelMatriz,i, w );
            }
            
        }
        
        // add JLabel to JFrame
        criaBotaoFlag(PainelAux);
       

        // display it
        frame2.setLayout(new GridLayout(2, 1));
        frame2.add(PainelMatriz);
        frame2.add(PainelAux);        
        frame2.pack();
        frame2.setVisible(true);
    }
    
    private void createButton(Field field, JPanel frame, int row, int col){ // Cria botões e os registra em um array de JButtons.
        System.out.println("TESTANDO BOTOES");
        
        JButton CurrentButton = new JButton();
        this.botoes[row][col] = CurrentButton;
        CurrentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFlagger()){
                    CurrentButton.setBackground(Color.pink);
                    CurrentButton.setText("Flag");
                    CurrentButton.setEnabled(false);
                }
                else{
                    
                int checker = checkType(field, row, col);
                if(checker == 10){
                    CurrentButton.setBackground(Color.red);
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
                
                comutaJogador();
                 }}
        }
                
    
        
        );
        CurrentButton.setName(String.format("%d,%d", row, col)); // Informações para o botão. Identificador.
        frame.add(CurrentButton);
    }
    
    
    


    

    
}

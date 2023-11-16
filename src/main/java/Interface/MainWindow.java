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
public class MainWindow extends JanelaPai implements InterfaceJanelas {
    
    private int rows;
    private Field field;
    private Jogador currentJogador;
    private Jogador Jogador1;
    private Jogador Jogador2;
    private JButton[][] botoes;
    private boolean flagger;
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isFlagger() {
        return flagger;
    }
    private int cols;
    
    public MainWindow(int rows, int cols, int width, int height, Field field, Jogador jogador1, Jogador jogador2){
        super(width, height);
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.field = field;
        this.Jogador1 = jogador1;
        this.Jogador2 = jogador2;
        this.botoes = new JButton[rows][cols];
        this.currentJogador = jogador1;
        this.flagger = false;
        
        
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
    
    private int checkType(Field field, int row, int col){
        
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
            System.out.println(String.format("nova pos: [%d, %d]", CurrentClicado.get(0), CurrentClicado.get(1)));
            System.out.println(CurrentClicado.get(0));
            JButton  NovoVazio = this.botoes[CurrentClicado.get(0)][CurrentClicado.get(1)];
            NovoVazio.setText("");
            NovoVazio.setBackground(Color.green);
            NovoVazio.setEnabled(false);
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
    
    private void criaBotaoFlag(JPanel panel){
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
    private void ComutaFlagger(){
        if (this.flagger == false){
        this.flagger = true;
        
        
    }
    else{
        this.flagger = false;
    }
        System.out.println(this.flagger);
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

    
}

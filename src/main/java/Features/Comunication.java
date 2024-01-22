/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Exceções.PosicaoInvalida;
import static Features.TabuleiroTerminal.showTable;
import Interface.MainMenu;
import java.util.Scanner;
import Interface.MainWindow;
import com.sun.tools.javac.Main;

/**
 *
 * @author Usuario
 */



public  class Comunication {
    public static void StartGame(){
        
        
        
        Jogador player1 = new Jogador();
        player1.setJogador(1);
        
        Jogador player2 = new Jogador(); //Create objects jogador
        player2.setJogador(2); // set jogadores numero;
        Jogador currentJogador = player1;
        //MainWindow MainJanela = new MainWindow(9,9,800,600, teste_field, player1, player2, true);
        //MainJanela.createWin();//Create mainWin to integrate with game
        
        
        
       
    
        
       
        boolean game_over = false;
        Click click = new Click(); // Create the object so the player can perform the click.
        char StatusElemento;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 0 para fácil, 1 para médio e 2 para difícil");
        
        int dificuldade = scanner.nextInt();
        
        Field teste_field = GenerateFieldWithDificulty(dificuldade);
        
        
        while(!game_over){
            boolean checkerValid = false;
            int coluna = 0;
            int linha = 0;
            int currentAcao = 0;
        while(!checkerValid){
            
            
            try{
            System.out.print("Digite a acao: 1 para flag e 0 para clique ");
            int acao = scanner.nextInt();
                if (acao <0 || acao >1){
                throw new PosicaoInvalida("Acao inválida");
                
                }
                else{
                    currentAcao = acao;
                }
                
            System.out.print("Digite o número da coluna: ");
            coluna = scanner.nextInt();
            if(coluna <0 || coluna >= teste_field.cols){
            throw new PosicaoInvalida("Coluna inválida");
            
            }
            System.out.print("Digite o número da linha: ");
            linha = scanner.nextInt(); // Scan row and column that will be clicked.
            if(linha <0 || linha >= teste_field.rows){
            throw new PosicaoInvalida("Linha inválida");
            
            }
            
            
            checkerValid = true;
        }
        catch(PosicaoInvalida e){
            e.getMessage();
        }
            
            
            
        }
       
        
        
        
        boolean checker = false;
        for(int i=0; i<teste_field.lengthClicked(); i++){
            int[] current_position = teste_field.ClickedElement(i);
            if(linha == current_position[0] && coluna == current_position[1] ){
                checker = true;
        }}
            
            if (!checker){
                
                if (currentAcao == 0){
                    System.out.println(String.format("%d esta é a linha", linha));
                StatusElemento = click.click(teste_field.matrix[linha][coluna], teste_field, currentJogador);
                 if (StatusElemento == 'b'){
                    currentJogador.gameOverMessage();
                    
                    System.out.println("BOMBA CLICLADA");
                    game_over = true;
                    
                }
                else if(StatusElemento == 'f'){
                    System.out.println("Clicou em flag");
                }
                else{
                    currentJogador.aumentaPontuacao();
                    System.out.println("ok");
                    teste_field.AddPosition(linha, coluna);
                }
                }
                else{
                  teste_field.getMatrix()[linha][coluna].FlagSetter();
                }
                
                 }
            else{
                System.out.println("Teste bug ");}
            
            showTable(teste_field);
        
            
        if(currentJogador.getJogador() == 1){
            currentJogador = player2;
        }
        else{
        currentJogador = player1;}
        if(game_over ){
            currentJogador.winMessage();
        }
            teste_field.printClick();
        }
        
        
        scanner.close();
        
    }
    
   
    
    public static void StartMenu(){
        MainMenu menu = new MainMenu(800, 600);
        
        menu.createWin();
        
        
       
        
        
       
        
        
    }
    
    public static FieldMaluco StartField(int rows, int cols, int  maluquisse){

        FieldMaluco field = new FieldMaluco(rows,cols,13,maluquisse);
        field.fillMatrix();
        field.fillBombs(); // Filling the Minesweeper matrix with bombs.
        
        field.insertBombAround(field.rows, field.cols);
        field.fillMaluco();
    
        
        return field;
    }
    
    //StartField OVERLOAD!!
    public static Field StartField(int rows, int cols){

        double bombNum = Math.pow(rows, 2)*0.1;
        int bombNumRound = (int) bombNum;
        Field teste_field = new Field(rows, cols,bombNumRound);// create a 3x3 matrix field for debbuging porpuses
        teste_field.fillMatrix();
        teste_field.fillBombs(); // Filling the Minesweeper matrix with bombs.
        teste_field.insertBombAround(teste_field.rows, teste_field.cols);
        return teste_field;
    }
    
    
    public static Field GenerateFieldWithDificulty(int dificulty){
        switch (dificulty) {
            case 0:
                return StartField(4,4);
            case 1:
                return StartField(6,6);
            default:
                return StartField(9,9);
        }
    }
}

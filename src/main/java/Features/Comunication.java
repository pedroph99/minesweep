/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

import Interface.MainMenu;
import java.util.Scanner;
import Interface.MainWindow;
/**
 *
 * @author Usuario
 */
public  class Comunication {
    public static void StartGame(){
        
        
        Field teste_field = new Field(9,9,5);// create a 3x3 matrix field for debbuging porpuses
        Jogador player1 = new Jogador();
        player1.setJogador(1);
        
        Jogador player2 = new Jogador(); //Create objects jogador
        player2.setJogador(2); // set jogadores numero;
        MainWindow MainJanela = new MainWindow(9,9,800,600, teste_field, player1, player2);
        MainJanela.createWin();//Create mainWin to integrate with game
        teste_field.fillMatrix();
        teste_field.fillBombs(); // Filling the Minesweeper matrix with bombs.
        teste_field.insertBombAround(teste_field.rows, teste_field.cols);
           
       
        boolean game_over = false;
        Click click = new Click(); // Create the object so the player can perform the click.
        char StatusElemento;
        Scanner scanner = new Scanner(System.in);
        while(!game_over){
            

        System.out.print("Digite o número da coluna: ");
        int coluna = scanner.nextInt();

        System.out.print("Digite o número da linha: ");
        int linha = scanner.nextInt(); // Scan row and column that will be clicked.
        
        
        
        Jogador currentJogador = player1;
        
        boolean checker = false;
        for(int i=0; i<teste_field.lengthClicked(); i++){
            int[] current_position = teste_field.ClickedElement(i);
            if(linha == current_position[0] && coluna == current_position[1] ){
                checker = true;
        }}
            
            if (!checker){
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
                System.out.println("Teste bug ");}
            
        
            
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
        System.out.println("============================TESTE MALUCO=======================");
        FieldMaluco field = new FieldMaluco(rows,cols,13,maluquisse);
        field.fillMatrix();
        field.fillBombs(); // Filling the Minesweeper matrix with bombs.
        
        field.insertBombAround(field.rows, field.cols);
        field.fillMaluco();
        System.out.println("============================TESTE MALUCO=======================");
        
        return field;
    }
    
    //StartField OVERLOAD!!
    public static Field StartField(int rows, int cols){
        
        Field teste_field = new Field(rows,cols,10);// create a 3x3 matrix field for debbuging porpuses
        teste_field.fillMatrix();
        teste_field.fillBombs(); // Filling the Minesweeper matrix with bombs.
        teste_field.insertBombAround(teste_field.rows, teste_field.cols);
        return teste_field;
    }
    
    
    
}

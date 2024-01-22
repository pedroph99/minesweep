/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Features;

/**
 *
 * @author Usuario
 */
public class TabuleiroTerminal {
       
   
    public static void showTable(FieldPai field){
        for(int i=0; i<field.rows; i++){
            for (int w=0; w<field.cols; w++){
                boolean checker = false;
                for(int x=0; x<field.lengthClicked(); x++){
                    
                            int[] current_position = field.ClickedElement(x);
                            
                            if(i == current_position[0] && w == current_position[1] ){
                                 checker = true;
                                 
                                int bombasRedor = field.getMatrix()[i][w].getBombsAround();
                                if(w == field.cols-1){
                                            
                                            System.out.println(" " + bombasRedor + " ");
                                        }
                                        else{
                                            System.out.print("  "+ bombasRedor + " |");
                                        }
                                break;
                        }
                
                }
                            if (!checker){
                                if(w == field.cols-1){
                                            if(field.matrix[i][w].getIsFlagged()){
                                                System.out.println("🚩 ");
                                            }
                                            System.out.println("* ");
                                        }
                                        else{
                                        if(field.matrix[i][w].getIsFlagged()){
                                                System.out.print(" 🚩  |");
                                            }
                                        else{
                                            System.out.print("  * |");
                                        }
                                            
                                        }
                            }
                            
                                
                                                }
                
                
                
                
            }
        }
    
    
    }




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceções;

/**
 *
 * @author Usuario
 */
public class PosicaoInvalida extends Exception {
    public PosicaoInvalida(){
        super("A posição colocada é inválida.");
    }
    
    public PosicaoInvalida(String mensagem) {
        super(mensagem);
        System.out.println(mensagem);
    }
}

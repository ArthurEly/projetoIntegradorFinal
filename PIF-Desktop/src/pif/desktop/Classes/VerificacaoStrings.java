/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.awt.event.KeyEvent;

/**
 *
 * @author arthu
 */
public class VerificacaoStrings {
    boolean avaliacao = false;
   
    public boolean numeros (KeyEvent evt){
        String caracteres="0987654321\b";// lista de caracters que não devem ser aceitos
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean letras (String string){
        return avaliacao;
    }
    
    public boolean vazio (String string){
        return avaliacao;
    }
    
    public boolean email (String email){        
        return avaliacao;
    }
    
    public boolean tamanhoMaximo(KeyEvent evt,String texto, int max){
        if (texto.length() >= max){
            evt.consume();
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao; 
    }
    
    public boolean tamanhoMinimo(KeyEvent evt,String texto, int max){
        return avaliacao; 
    }
    
    public boolean tamanhoValido(KeyEvent evt,String texto, int tamanho){
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            avaliacao = texto.length() == tamanho;
        } else {
            avaliacao = (texto.length()+1) == tamanho;
        }
        return avaliacao;
    }
    
    public boolean tamanhoValido(KeyEvent evt,String texto, int tamanho, int tamanho2){
        if (texto.length() != tamanho || texto.length() != tamanho2){
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    
    public String cpfOuCnpj (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números!";                         
        } else {         
            if ((s.length()+1) <= 14){
                if(tamanhoValido(evt,s,14) == false){
                    avaliacao = "CPF inválido.";
                }
            } else {
                if(tamanhoValido(evt,s,18) == false){
                    avaliacao = "CNPJ inválido.";
                }
            }              
            if(tamanhoMaximo(evt,s,18) == false){
                avaliacao = "O limite de 14 dígitos foi atingido!";
            } 
        }   
        return avaliacao; 
    }
}

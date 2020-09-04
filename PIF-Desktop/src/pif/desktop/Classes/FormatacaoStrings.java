/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 *
 * @author arthu
 */
public class FormatacaoStrings {
    boolean jaCnpj = false;
    public String cpfOuCnpj(KeyEvent evt, String s){
        if ((s.length()+1) <= 14 && jaCnpj == false){    
            System.out.println(s.length()+1);
            if (s.length() == 3 || s.length() == 7){
            s = s + ".";
            } else if (s.length() == 11){
                s = s + "-";
            }
            System.out.println("cpf");
        }
        else if (s.length() == 14 && jaCnpj == true){
            s = s.replaceAll("\\.", "");
            s = s.replaceAll("\\-", "");
            s = s.replaceAll("\\/", "");
            char cnpj[] = {s.charAt(0),s.charAt(1), s.charAt(2), '.', s.charAt(3), s.charAt(4), s.charAt(5), '.', s.charAt(6), s.charAt(7), s.charAt(8), '-', s.charAt(9), s.charAt(10)};  
            s = new String(cnpj);
            jaCnpj = false;
        }
        else{
            jaCnpj = true;
            if (s.length() == 14){
                s = s.replaceAll("\\.", "");
                s = s.replaceAll("\\-", "");
                char cnpj[] = {s.charAt(0),s.charAt(1), '.', s.charAt(2), s.charAt(3), s.charAt(4), '.', s.charAt(5), s.charAt(6), s.charAt(7), '/', s.charAt(8), s.charAt(9), s.charAt(10)};  
                s = new String(cnpj);
            } else if (s.length() == 15) {
                s = s + "-";
            } 
        }          
        return s;
    }
    
    public String telefone(String telefone){
        return telefone;
    }
    
    public String cep (String cep){
        return cep;
    }
    
    public String data (String data){
        return data;
    }
    
    public String retirarCpfOuCnpj(String cpfOuCnpj){
        return cpfOuCnpj;
    }
    
    public String retirarTelefone(String telefone){
        return telefone;
    }
    
    public String retirarCep (String cep){
        return cep;
    }
    
    public String retirarData (String data){
        return data;
    }
    
    public String apagar(String s, String campo){
        if ((s.length()+1) == 4 || (s.length()+1) == 8 || (s.length()+1) == 12 || (s.length()+1) == 16){
            s = s.substring(0, (s.length()-1));
        }
        return s;
    }
}

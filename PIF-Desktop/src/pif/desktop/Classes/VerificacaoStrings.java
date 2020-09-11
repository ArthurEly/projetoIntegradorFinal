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
    boolean jaDecimal = false;
    int contadorDecimal = 0;
    /*
       COMEÇO DOS MÉTODOS COMPLEMENTARES
    */
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
    
    public boolean numeros (String s){
        String caracteres="0987654321\b";// lista de caracters que não devem ser aceitos
        if(!caracteres.contains(s)){// se o caracter que gerou o
        //não estiver na lista
            s = s.substring(0, s.length()-1);//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
      
    public boolean liberado (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî1234567890-/%#$*()+-=";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b ";
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean nomes (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b";
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean nomesComEspaco (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b ";
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean soLetras (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnm";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b";
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean placa (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnm1234567890";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b";
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean placa (String s){
        String letras ="qwertyuiopasdfghjklçzxcvbnm";
        letras = letras + letras.toUpperCase();
        String numeros="0987654321\b";
        String letraNumero = letras + numeros;
        char placa[] = s.toCharArray();
        if (letras.contains(Character.toString(s.charAt(0))) && letras.contains(Character.toString(s.charAt(1))) &&
            letras.contains(Character.toString(s.charAt(2))) && numeros.contains(Character.toString(s.charAt(3))) &&
            letraNumero.contains(Character.toString(s.charAt(4))) && numeros.contains(Character.toString(s.charAt(5)))&&
            numeros.contains(Character.toString(s.charAt(6)))){
            avaliacao = true;
        } else {
            avaliacao = false;
        }
        return avaliacao;
    }
    
    public boolean espaco(KeyEvent evt){
       String caracteres =" "; 
       if(caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
        //não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento 
            avaliacao = false;
        } else {
            avaliacao = true;
        }
        return avaliacao;
    }
    
    public boolean email (String email){     
        if (email.contains("@") && email.endsWith(".com") ||
            email.contains("@") && email.endsWith(".com.br") ){
            avaliacao = true;
        } else {
            avaliacao = false;
        }
        return avaliacao;
    }
    
    public boolean data (String data){  
        data d = new data();
        String dia = Character.toString(data.charAt(0)) + Character.toString(data.charAt(1));
        String mes = Character.toString(data.charAt(3)) + Character.toString(data.charAt(4));
        String ano = Character.toString(data.charAt(6)) + Character.toString(data.charAt(7)) + Character.toString(data.charAt(8)) + Character.toString(data.charAt(9));
        int diaInt = Integer.parseInt(dia);
        int mesInt = Integer.parseInt(mes);
        int anoInt = Integer.parseInt(ano);
         if (d.ontem(diaInt, mesInt,anoInt)) {
            avaliacao = false;
        }else{
            if (diaInt <= 28 && mesInt == 2){
                avaliacao = true;
            } else if (diaInt <= 29 && mesInt == 2 && bissexto(anoInt)){
                avaliacao = true;
            } else if (diaInt <=30 && mesInt ==  4 ||
                diaInt <=30 && mesInt ==  6 ||
                diaInt <=30 && mesInt ==  9 ||
                diaInt <=30 && mesInt ==  11){
                avaliacao = true;
            } else if (diaInt <=31 && mesInt ==  1 ||
                diaInt <=31 && mesInt ==  3 ||
                diaInt <=31 && mesInt ==  5 ||
                diaInt <=31 && mesInt ==  7 ||
                diaInt <=31 && mesInt ==  8 ||
                diaInt <=31 && mesInt ==  10 ||
                diaInt <=31 && mesInt ==  12){
                avaliacao = true;
            } else {
                avaliacao = false;
            }
        }
       return avaliacao;
    }
    
    public boolean bissexto(int ano){
        boolean bissexto = false;
        if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
            bissexto = true;
        }
        else{
            bissexto = false;
        }
        return bissexto;
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
      
    public boolean tamanhoValido(KeyEvent evt,String texto, int tamanho){
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            avaliacao = texto.length() == tamanho;
        } else {
            avaliacao = (texto.length()+1) == tamanho;
        }
        return avaliacao;
    }
    /*
        FIM DOS MÉTODOS COMPLEMENTARES
    */
    public String cpfOuCnpj (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números.";                         
        } else {         
            if ((s.length()+1) <= 14){
                if(tamanhoValido(evt,s,14) == false){
                    avaliacao = "CPF inválido.";
                } else {
                    avaliacao = "CPF válido!";
                }
            } else {
                if(tamanhoValido(evt,s,18) == false){
                    avaliacao = "CNPJ inválido.";
                } else {
                    avaliacao = "CNPJ válido!";
                }
            }              
            if(tamanhoMaximo(evt,s,18) == false){
                avaliacao = "O limite de 14 dígitos foi atingido.";
            } 
        }   
        return avaliacao; 
    }
    
    public String rgOuIe (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números.";                         
        } else {         
            if ((s.length()+1) <= 10){
                if(tamanhoValido(evt,s,9) == false){
                    avaliacao = "IE ou RG inválido.";
                } else if (tamanhoValido(evt,s,9)){
                    avaliacao = "IE válida!";
                } 
                if (tamanhoValido(evt,s,10)){
                    avaliacao = "RG válido!";
                }
            }             
            if(tamanhoMaximo(evt,s,10) == false){
                avaliacao = "O limite de 10 dígitos foi atingido.";
            } 
        }   
        return avaliacao; 
    }
    
    public String nomes30 (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,30) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String sobrenomeOuFantasia (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,50) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String email (KeyEvent evt, String s){
        String avaliacao = "";
        if (espaco(evt) == false){
            avaliacao = "Espaços não são válidos aqui."; 
        } else if (email(s) == false){
            avaliacao = "Email inválido.";
        }  else {
            avaliacao = "Email válido!";
        }             
        if (tamanhoMaximo(evt,s,100) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String telefone (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite somente números.";
        } else if (tamanhoValido(evt,s,12)){
            avaliacao = "Número válido!";
        } else if (tamanhoValido(evt,s,13)){
            avaliacao = "Número válido!";
        } else {
            avaliacao = "Número inválido.";
        }
        
        if (tamanhoMaximo(evt,s,14) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String cep (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        }  else if (tamanhoValido(evt,s,9) == false){
            avaliacao = "CEP inválido.";
        } else {
            avaliacao = "CEP válido!";
        }
        if (tamanhoMaximo(evt,s,9) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String lograd (KeyEvent evt, String s){
        String avaliacao = "";
        if (liberado(evt) == false){
            avaliacao = "Digite apenas letras ou números.";
        }       
        if (tamanhoMaximo(evt,s,60) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao;
    }
    
    public String logradNum (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números.";
        }       
        if (tamanhoMaximo(evt,s,6) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao;
    }
    
    public String veiculo25 (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,25) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String veiculoAno (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas numeros."; 
        } else if (tamanhoValido(evt,s,4) == false){
            avaliacao = "Ano inválido.";
        } else {
            avaliacao = "Ano válido!";
        }         
        if (tamanhoMaximo(evt,s,4) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String veiculo255 (KeyEvent evt, String s){
        String avaliacao = "";
        if (liberado(evt) == false && numeros(evt) == false ){
            avaliacao = "Digite apenas letras ou números."; 
        }        
        if (tamanhoMaximo(evt,s,255) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String veiculoPlaca (KeyEvent evt, String s){
        String avaliacao = "";
        if (placa(evt) == false){
            avaliacao = "Digite apenas letras ou números."; 
        } else if (tamanhoValido(evt,s,7) == false){
            avaliacao = "Placa inválida.";
        } 
        if (s.length() == 7 && placa(s) == false){
            avaliacao = "Placa inválida.";
        } else if (s.length() == 7 && placa(s)) {
            avaliacao = "Placa válida!";
        }
        else if (tamanhoMaximo(evt,s,7) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String data(KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        } else if (tamanhoValido(evt,s,11) == false){
            avaliacao = "Data inválida.";
        } else if (data(s) == false){
            avaliacao = "Data inválida.";
        } else {
            avaliacao = "Data válida!";
        }
        if (tamanhoMaximo(evt,s,11) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
    public String orcamento (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        }  
        return avaliacao; 
    }
    
    public String numeroOS (KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números.";                         
        }        
        if(tamanhoMaximo(evt,s,10) == false){
            avaliacao = "O limite de 10 dígitos foi atingido.";
        }           
        return avaliacao; 
    }
    
    public String nome30 (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,30) == false){
            avaliacao = "Tamanho máximo atingido.";
        }
        return avaliacao; 
    }
    
}

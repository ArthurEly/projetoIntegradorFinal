/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthu
 */
public class FormatacaoStrings {
    private boolean jaCnpj = false;
    private boolean jaTel1 = false;
    private boolean jaTel2 = false;
    private int contadorMilhar = 0;
    private boolean jaDecimal = true;
    
    public String cpfOuCnpj(KeyEvent evt, String s){
        if ((s.length()+1) <= 14 && jaCnpj == false){    
            if (s.length() == 3 || s.length() == 7){
            s = s + ".";
            } else if (s.length() == 11){
                s = s + "-";
            }
            jaCnpj = false;
        } else if (s.length() == 14 && jaCnpj == true){
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
    
    public String botarCpfOuCnpj(String s){
        while (s.length() < 11){
            s = "0"+s;
        }
        if (s.length() == 11){
            char[] cpf = {s.charAt(0),s.charAt(1),s.charAt(2),'.',s.charAt(3),s.charAt(4),s.charAt(5),'.',s.charAt(6),s.charAt(7),s.charAt(8),'-',s.charAt(9),s.charAt(10)};
            String cpfF = new String(cpf);
            s = cpfF;
        } else if(s.length() == 14){
            char[] cnpj = {s.charAt(0),s.charAt(1),'.',s.charAt(2),s.charAt(3),s.charAt(4),'.',s.charAt(5),s.charAt(6),s.charAt(7),'/',s.charAt(8),s.charAt(9),s.charAt(10),s.charAt(11),'-',s.charAt(12),s.charAt(13)};
            String cnpjF = new String(cnpj);
            s = cnpjF;
        }
        return s;
    }
  
    public String telefone1(KeyEvent evt, String tel){
        if ((tel.length()+1) <= 12 && jaTel1 == false){ 
            if (tel.length()+1 == 3){
            tel =  tel + " " ;
            }                     
            if (tel.length()+1 == 8){
                tel = tel + "-";
            }
            jaTel1 = false;  
        } else if ((tel.length()+1) <= 14 && jaTel1 == true){
            tel = tel.replaceAll("\\-", "");
            tel = tel.replaceAll("\\ ", "");
            System.out.println(tel);
            char cnpj[] = {tel.charAt(0),tel.charAt(1),' ', tel.charAt(2), tel.charAt(3), tel.charAt(4), tel.charAt(5), '-', tel.charAt(6), tel.charAt(7), tel.charAt(8), tel.charAt(9)};  
            tel = new String(cnpj);
            jaTel1 = false;
        } 
        else {
            jaTel1 = true;
            if (tel.length() == 12){
                tel = tel.replaceAll("\\-", "");
                System.out.println(tel);
                System.out.println(tel.length());
                char cnpj[] = {tel.charAt(0),tel.charAt(1), tel.charAt(2), tel.charAt(3),' ',tel.charAt(4), tel.charAt(5), tel.charAt(6), tel.charAt(7),'-',tel.charAt(8),tel.charAt(9),tel.charAt(10)};  
                tel = new String(cnpj);
            }                     
        }
        return tel;
    }
     
    public String telefone2(KeyEvent evt, String tel){
        if ((tel.length()+1) <= 12 && jaTel2 == false){ 
            System.out.println("if: "+(tel.length()+1));
            if (tel.length()+1 == 3){
            tel =  tel + " " ;
            }                     
            if (tel.length()+1 == 8){
                tel = tel + "-";
            }
            jaTel2 = false;  
        } else if ((tel.length()+1) <= 14 && jaTel1 == true){
            System.out.println("esle if: "+(tel.length()+1));
            tel = tel.replaceAll("\\-", "");
            tel = tel.replaceAll("\\ ", "");
            System.out.println(tel);
            char cnpj[] = {tel.charAt(0),tel.charAt(1),' ', tel.charAt(2), tel.charAt(3), tel.charAt(4), tel.charAt(5), '-', tel.charAt(6), tel.charAt(7), tel.charAt(8), tel.charAt(9)};  
            tel = new String(cnpj);
            jaTel2 = false;
        } 
        else {
            System.out.println("else: "+(tel.length()+1));
            jaTel2 = true;
            if (tel.length() == 12){
                tel = tel.replaceAll("\\-", "");
                System.out.println(tel);
                System.out.println(tel.length());
                char cnpj[] = {tel.charAt(0),tel.charAt(1), tel.charAt(2), tel.charAt(3),' ',tel.charAt(4), tel.charAt(5), tel.charAt(6), tel.charAt(7),'-',tel.charAt(8),tel.charAt(9),tel.charAt(10)};  
                tel = new String(cnpj);
            }                     
        }
        return tel;
    }
    
    public String botarTelefone(String s){
        return s;
    }
    
    public String dinheiro (KeyEvent evt, String d){
        if (d.length()+1 < 3 || d.length()+1 ==3 && !jaDecimal){
            //naadadadadadadadadada
        }else if (d.length()+1 == 3){
            char din[] = {d.charAt(0),',',d.charAt(1)}; 
            d = new String(din);
            jaDecimal = true;
            contadorMilhar = 0;
        } else if (d.length()+1 > 3 && d.length() < 6){
            contadorMilhar = 0;
            d = decimal(evt,d);       
        } else if (d.length()+1 > 6){
            d = decimal(evt,d); 
            d = milhar(evt, d);              
        }       
        return d;
    }
    
    public String decimal (KeyEvent e,String d){
        String dindin = "";
        d = d.replaceAll(",", "");
        List<String> decimal = new ArrayList<>();
        for(int i=0;i<d.length();i++){
           decimal.add(String.valueOf(d.charAt(i)));
        }
        if ("\b".equals(Character.toString(e.getKeyChar()))){
        decimal.add(d.length()-2, ","); 
        } else {
            decimal.add(d.length()-1, ","); 
        }  
        for(int i=0;i<decimal.size();i++){
            dindin = dindin + decimal.get(i);
        }                            
        return dindin;
    }
    
    public String milhar (KeyEvent e, String d){        
        String dindin = "";
        d = d.replaceAll("\\.", "");
        List<String> decimal = new ArrayList<>();
        for(int i=0;i<d.length();i++){
           decimal.add(String.valueOf(d.charAt(i)));
        }          
        if ("\b".equals(Character.toString(e.getKeyChar()))){
            contadorMilhar--;
        } else {
            contadorMilhar++;
        }    
        if (contadorMilhar != 0){
            decimal.add(contadorMilhar, ".");
        }      
        for(int i=0;i<decimal.size();i++){
            dindin = dindin + decimal.get(i);
        }
        return dindin;
    }
    
    public String botarDinheiro(String s){ 
        if (s == null){
            s = "-";
        } else if (s.length() <= 6){
            s = s.replaceAll("\\.", ",");
        } else {
            s = s.replaceAll("\\.", ",");
            while(s.length()>6 && s.length()<9){
            s = "0"+s;
            }
            char[] dindin = {s.charAt(0),s.charAt(1),s.charAt(2),'.',s.charAt(3),s.charAt(4),s.charAt(5),s.charAt(6),s.charAt(7),s.charAt(8)};
            String dindinFormatado = new String(dindin);
            while(dindinFormatado.startsWith("0")){
                dindinFormatado = dindinFormatado.substring(1);   
            }
            return dindinFormatado;
        } 
        return s;
    }
    
    public String placa(String s){
        s = s.toUpperCase();
        return s;
    }
    
    public String cep (String cep){
        if ((cep.length()+1) == 6){
            cep = cep + "-";
        }
        return cep;
    }
    
    public String botarCep(String s){
        return s;
    }
   
    public String data (String data){
        if (data.length() == 2 || data.length() == 5){
            data = data + "/";
        }
        return data;
    }
    
    public String botarData(String s){
        char[] data = {s.charAt(8),s.charAt(9),'/',s.charAt(5),s.charAt(6),'/',s.charAt(0),s.charAt(1),s.charAt(2),s.charAt(3)};
        String dataF = new String(data);
        if (s.length() > 10){
            char[] hora = {s.charAt(11),s.charAt(12),s.charAt(13),s.charAt(14),s.charAt(15),s.charAt(16),s.charAt(17),s.charAt(18)};
            String horaF = new String(hora);
            dataF = dataF + " às " + horaF;
        }  
        return dataF;
    }
    
    public String retirarFormatacao(String s){
        s = s.replaceAll("\\.", "");
        s = s.replaceAll("\\-", "");
        s = s.replaceAll("\\/", "");
        s = s.replaceAll("\\ ", "");
        return s;
    }
    
    public String retirarFormatacaoDinheiro(String s){
        s = s.replaceAll("\\.", "");
        s = s.replaceAll("\\,", ".");
        System.out.println(s);
        return s;
    }
    
    public String retirarFormatacaoData(String s){
        s = s.replaceAll("\\/", "");
        char dataFormatadaC[] = {s.charAt(4),s.charAt(5),s.charAt(6),s.charAt(7),'-',s.charAt(2),s.charAt(3),'-',s.charAt(0),s.charAt(1)};  
        String dataFormatada = new String(dataFormatadaC);
        return dataFormatada;
    }
    
    public String apagar(String s, String campo){
        if (campo.equals("cpfnj")){
            if ((s.length()+1) == 4 || (s.length()+1) == 8 || (s.length()+1) == 12 || (s.length()+1) == 16){
                s = s.substring(0, (s.length()-1));
            }
        } 
        
        if (campo.contains("tel")){
            if ((s.length()+1) == 3 || (s.length()+1) == 8){
                s = s.substring(0, (s.length()-1));
            }
        } 
        
        if (campo.equals("cep")){
            if ((s.length()+1) == 6){
                s = s.substring(0, (s.length()-1));
            }
        }
        
        if (campo.equals("data")){
            if ((s.length()+1) == 3 ||(s.length()+1) == 6){
                s = s.substring(0, (s.length()-1));
            }
        }
        
        if (campo.equals("pecas") || campo.equals("servicos")){
            if (s.length() == 3){
                s = s.replaceAll(",","");
                jaDecimal = false;
            }else if ((s.length()+1) == 8){
                s = s.replaceAll("\\.","");
            }
        }
        return s;
    }

    public String retirarCpfOuCnpj(String text) {
        while (text.startsWith("0")){
            text = text.substring(1);
        }
        return text;
    }
}

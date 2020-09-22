/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.awt.event.KeyEvent;
import java.util.InputMismatchException;

/**
 *
 * @author arthu
 */
public class VerificacaoStrings {
    boolean avaliacao = false;
    boolean jaDecimal = false;
    int contadorDecimal = 0;
    FormatacaoStrings fs = new FormatacaoStrings();
    data d = new data();
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
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî1234567890-/%$*()+-=,.:;";
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
    
    public boolean letrasENumeros (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî1234567890 /b";
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
    
    public boolean nomesERazao (KeyEvent evt){
        String caracteres ="qwertyuiopasdfghjklçzxcvbnmèéúùíìóòàáõãûâôêî";
        caracteres = caracteres + caracteres.toUpperCase();
        caracteres = caracteres + "\b &";
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
        if (d.diaMesValido(diaInt,mesInt, anoInt)){
            if (d.ontem(diaInt, mesInt,anoInt)) {
                avaliacao = false;
            } else {
                avaliacao = true;
            }
        } else {
            avaliacao = false;
        }
       return avaliacao;
    }
    
    public boolean dataCnpj (String data){  
        data d = new data();
        String dia = Character.toString(data.charAt(0)) + Character.toString(data.charAt(1));
        String mes = Character.toString(data.charAt(3)) + Character.toString(data.charAt(4));
        String ano = Character.toString(data.charAt(6)) + Character.toString(data.charAt(7)) + Character.toString(data.charAt(8)) + Character.toString(data.charAt(9));
        int diaInt = Integer.parseInt(dia);
        int mesInt = Integer.parseInt(mes);
        int anoInt = Integer.parseInt(ano);
        if (d.diaMesValido(diaInt,mesInt, anoInt)){
            if (d.ontem(diaInt, mesInt,anoInt)) {
                avaliacao = true;
            } else {
                avaliacao = false;
            }
        } else {
            avaliacao = false;
        }
       return avaliacao;
    }
    
    
    
    private boolean dataNasc(String data) {
        data d = new data();
        String dia = Character.toString(data.charAt(0)) + Character.toString(data.charAt(1));
        String mes = Character.toString(data.charAt(3)) + Character.toString(data.charAt(4));
        String ano = Character.toString(data.charAt(6)) + Character.toString(data.charAt(7)) + Character.toString(data.charAt(8)) + Character.toString(data.charAt(9));
        int diaInt = Integer.parseInt(dia);
        int mesInt = Integer.parseInt(mes);
        int anoInt = Integer.parseInt(ano);
        if (d.diaMesValido(diaInt,mesInt, anoInt)){
            if (d.menorDe18(diaInt, mesInt, anoInt)){
                avaliacao = false;
            } else {
                avaliacao = true;
            }
        } else {
            avaliacao = false;
        }
        return avaliacao;
    }
    
    public boolean isCPF(String CPF) {
		
		CPF = fs.retirarFormatacao(CPF);
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0        
				// (48 eh a posicao de '0' na tabela ASCII)        
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public boolean isCNPJ(String CNPJ) {
		
		CNPJ = fs.retirarFormatacao(CNPJ);
		
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		// "try" - protege o código para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
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
                avaliacao = "erro";
            } 
        }   
        return avaliacao; 
    }
    
    public String rgOuIe (KeyEvent evt, String s){
        String avaliacao = "";
        if (letrasENumeros(evt) == false){
            avaliacao = "Digite apenas números ou números.";                         
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
                avaliacao = "erro";
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
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String nomeERazao(KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesERazao(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,30) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String sobrenomeOuFantasia (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,50) == false){
            avaliacao = "erro";
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
            avaliacao = "erro";
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
            avaliacao = "erro";
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
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String lograd (KeyEvent evt, String s){
        String avaliacao = "";
        if (liberado(evt) == false){
            avaliacao = "Digite letras ou números.";
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
            avaliacao = "erro";
        }
        return avaliacao;
    }
    
    public String veiculo25 (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,25) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String veiculoModelo (KeyEvent evt, String s){
        String avaliacao = "";
        if (letrasENumeros(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,25) == false){
            avaliacao = "erro";
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
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String veiculo255 (KeyEvent evt, String s){
        String avaliacao = "";
        if (liberado(evt) == false){
            avaliacao = "Digite letras ou números."; 
        }        
        if (tamanhoMaximo(evt,s,255) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }
    
    public String veiculoPlaca (KeyEvent evt, String s){
        String avaliacao = "";
        if (placa(evt) == false){
            avaliacao = "Digite letras ou números."; 
        } else if (tamanhoValido(evt,s,7) == false){
            avaliacao = "Placa inválida.";
        } 
        if (s.length() == 7 && placa(s) == false){
            avaliacao = "Placa inválida.";
        } else if (s.length() == 7 && placa(s)) {
            avaliacao = "Placa válida!";
        }
        else if (tamanhoMaximo(evt,s,7) == false){
            avaliacao = "erro";
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
            avaliacao = "erro";
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
            avaliacao = "erro";
        }           
        return avaliacao; 
    }
    
    public String nome30 (KeyEvent evt, String s){
        String avaliacao = "";
        if (nomesComEspaco(evt) == false){
            avaliacao = "Digite apenas letras."; 
        }        
        if (tamanhoMaximo(evt,s,30) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }

    public String dataNasc(KeyEvent evt, String s) {
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        } else if (tamanhoValido(evt,s,11) == false){
            avaliacao = "Data inválida.";
        } else if (dataNasc(s) == false ){
            avaliacao = "Data inválida.";
        } else {
            avaliacao = "Data válida!";
        }
        if (tamanhoMaximo(evt,s,11) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    } 
    
    public String dataRelatorio(KeyEvent evt, String s){
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        } else if (tamanhoValido(evt,s,11) == false){
            avaliacao = "Data inválida.";
        } else if (data(s)){
            avaliacao = "Data válida!.";
        } else {
            avaliacao = "Data inválida.";
        }
        if (tamanhoMaximo(evt,s,11) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }
       
    public int verificarEstado(String estado){
        String[] estados = {"--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        int length = estados.length;
        int i;
        for (i=0;i<length;i++){
            if (estado.equals(estados[i])){
                break;
            }
        }
        return i;
    }
    
    public int verificarSituacao(String situacao){
        String[] situacoes = {"Na fila", "Em análise", "Aguardando peças", "Em processo de manutenção", "Aguardando devolução", "Concluído!"};
        int length = situacoes.length;
        int i;
        for (i=0;i<length;i++){
            if (situacao.equals(situacoes[i])){
                break;
            }
        }
        return i;
    }

    public String dataNascCnpj(KeyEvent evt, String text) {
        String avaliacao = "";
        if (numeros(evt) == false){
            avaliacao = "Digite apenas números."; 
        } else if (tamanhoValido(evt,text,11) == false){
            avaliacao = "Data inválida.";
        } else if (dataCnpj(text)){
            avaliacao = "Data válida!";
        } else {
            avaliacao = "Data inválida.";
        }
        if (tamanhoMaximo(evt,text,11) == false){
            avaliacao = "erro";
        }
        return avaliacao; 
    }
}
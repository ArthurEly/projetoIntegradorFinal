package pif.desktop.Classes;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthu
 */
public class data {
        Date data = new Date();
        
    public String dataFormatada (){
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataF = formatar.format(data);
        return dataF;
        /*
        y Ano
        M Mes no ano
        D Dia no ano
        d Dia no mês
        H Horas no dia
        h Horas em am/pm
        m Minutos em horas
        s Segundo em minutos
        S Milisegundos 
        */
    }
    
    public boolean ontem(int diaPrev, int mesPrev, int anoPrev){
        SimpleDateFormat formatarDia = new SimpleDateFormat("dd");
        SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
        SimpleDateFormat formatarAno = new SimpleDateFormat("yyyy");       
        String dia = formatarDia.format(data);
        String mes = formatarMes.format(data);
        String ano = formatarAno.format(data);
        int diaAtual = Integer.parseInt(dia);
        int mesAtual = Integer.parseInt(mes);
        int anoAtual = Integer.parseInt(ano);
        boolean anterior = false;
        if (anoAtual > anoPrev){
            anterior = true;
        } else if (anoAtual == anoPrev){
            if (mesAtual > mesPrev){
            anterior = true; 
            } else if (mesAtual == mesPrev && diaAtual > diaPrev){
                anterior = true; 
            }  
        } else {
            anterior = false;
        }
             
        return anterior;
    }
    
    public boolean aniver(int diaPrev, int mesPrev){
        SimpleDateFormat formatarDia = new SimpleDateFormat("dd");
        SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
        SimpleDateFormat formatarAno = new SimpleDateFormat("yyyy");       
        String dia = formatarDia.format(data);
        String mes = formatarMes.format(data);
        String ano = formatarAno.format(data);
        int diaAtual = Integer.parseInt(dia);
        int mesAtual = Integer.parseInt(mes);
        int anoAtual = Integer.parseInt(ano);
        boolean aniver = false;
        if (mesAtual > mesPrev){
            aniver = true; 
        } else if (mesAtual == mesPrev && diaAtual >= diaPrev){
            aniver = true; 
        } else {
            aniver = false;
        }             
        return aniver;
    }

    boolean menorDe18(int diaInt, int mesInt, int anoInt) {
        SimpleDateFormat formatarAno = new SimpleDateFormat("yyyy"); 
        String ano = formatarAno.format(data);
        int anoAtual = Integer.parseInt(ano);
        boolean avaliacao = false;
        if ((anoAtual-anoInt) > 18){
            avaliacao = false;
        } else if ((anoAtual-anoInt) < 18) {
            avaliacao = true;
        } else if (aniver(diaInt, mesInt)){
                avaliacao = false;
            } else {
                avaliacao = true;
            }
       return avaliacao;
    }

    boolean diaMesValido(int diaInt, int mesInt, int anoInt) {
        boolean avaliacao;
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
        return avaliacao;
    }
    
    private boolean bissexto(int ano){
        boolean bissexto = false;
        if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
            bissexto = true;
        }
        else{
            bissexto = false;
        }
        return bissexto;
    }
    
}

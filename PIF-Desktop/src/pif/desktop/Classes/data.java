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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author arthu
 */
public class Utils {
    
    public void irDePara(javax.swing.JFrame desse, javax.swing.JFrame esse){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        //abre a segunda
        esse.setVisible(true);
        //fecha a primeria tela
        new Timer().schedule(
            new TimerTask(){
                @Override
                public void run(){
                    desse.setVisible(false);
                }
            }, 100);

    }
}



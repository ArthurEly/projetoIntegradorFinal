/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS;

import java.util.*;

/**
 *
 * @author arthu
 */
public class TelaUtils {
    
    public void irDePara(javax.swing.JFrame desse, javax.swing.JFrame esse){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        esse.setBounds(desse.getX(), desse.getY(), desse.getWidth(), desse.getHeight());
        esse.setExtendedState(desse.getExtendedState());
        esse.setVisible(true);
        new Timer().schedule(
            new TimerTask(){
                @Override
                public void run(){
                    desse.setVisible(false);
                }
        }, 100);

    }
    
    public void irDeParaLogin(javax.swing.JFrame desse, javax.swing.JFrame esse, int largura, int altura){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        esse.setLocationRelativeTo(null);
        desse.dispose();
        esse.setVisible(true);
    }
    
    public void irDeParaDiferenciado(javax.swing.JFrame desse, javax.swing.JFrame esse, int largura, int altura){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        esse.setBounds(desse.getX(), desse.getY(),largura,altura);
        esse.setExtendedState(desse.getExtendedState());
        desse.setExtendedState(1);
        esse.setVisible(true);
    }
    
    public void irDeParaDiferenciadoFechando(javax.swing.JFrame desse, javax.swing.JFrame esse, int largura, int altura, boolean fecharTelaAntiga){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        esse.setBounds(desse.getX(), desse.getY(),largura,altura);
        esse.setExtendedState(desse.getExtendedState());
        desse.setExtendedState(1);
        desse.dispose();
        esse.setVisible(true);
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pif.desktop.Classes.Colab;

/**
 *
 * @author arthu
 */
public class ColabDAO {
    
    public Colab verificarColab(String cpf){
        /*
            MÉTODO PARA FAZER LOGIN
        */     
        String sql = "SELECT * FROM colab_teste WHERE colab_cpf = "+cpf;
        Conexao  c = new Conexao();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultado=  null;
        Colab cb = new Colab();
        try {
            conn = c.conectarAoBanco();
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery();
            
            if (resultado.next()){                
                cb.setColabNome(resultado.getString("colab_nome"));
                cb.setColabSobrenome(resultado.getString("colab_sobrenome"));
                cb.setColabCpf(resultado.getString("colab_cpf"));
                cb.setColabRg(resultado.getString("colab_rg"));
                cb.setColabEndEstado(resultado.getString("colab_uf"));
                cb.setColabEndCep(resultado.getString("colab_cep"));
                cb.setColabEndCidade(resultado.getString("colab_cidade"));
                cb.setColabEndBairro(resultado.getString("colab_bairro"));
                cb.setColabEndLograd(resultado.getString("colab_lograd"));
                cb.setColabEndLogradNum(resultado.getString("colab_lograd_num"));
                cb.setColabEndLogradComp(resultado.getString("colab_lograd_comp"));
                cb.setColabDataNasc(resultado.getString("colab_nascimento"));
                cb.setColabSenha(resultado.getString("colab_pass"));
                cb.setIsGerente(resultado.getBoolean("colab_gerente"));
                cb.setIsTecnico(resultado.getBoolean("colab_tecnico"));
            }       
        } catch (Exception e) {
            System.out.println("erro no colab1: "+e);
        } finally{ 
            try{
                if(pstm != null){

                      pstm.close();
                  }  

                 if(conn != null){
                      conn.close();
                 }
            }catch(Exception e){
                e.printStackTrace();
            }
       }
       return cb;
    } 
}

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
import pif.desktop.TELAS.TelaUtils;

/**
 *
 * @author arthu
 */
public class LoginDAO {
    
    public Colab login(String user, String password){
        /*
            MÉTODO PARA FAZER LOGIN
        */
        /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 
        String sql = "SELECT * FROM users WHERE user_email = ? AND user_password = ? ";
        Conexao  c = new Conexao();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultado=  null;
        TelaUtils u = new TelaUtils();
        Colab co = new Colab();
        try {
            //Cria uma conexão com o banco
            conn = c.conectarAoBanco();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, user);
           
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, password);       
            
            //Executa a sql para inserção dos dados 
            resultado = pstm.executeQuery();
            
            if (resultado.next()){
                co.setColabCpf(resultado.getString("user_cpf"));
                co.setColabNome(resultado.getString("user_name"));
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
           //Fecha as conexões 
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
       return co;
    } 
}

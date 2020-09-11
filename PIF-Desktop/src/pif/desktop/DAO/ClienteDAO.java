/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arthu
 */
public class ClienteDAO {
 
    public boolean verificarCliente(String cpfnj, String tabela){
        boolean cadastrado=false;
        String select = "SELECT * FROM "+tabela+" WHERE cliente_cpf_ou_cnpj = ?";
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        cpfnj = cpfnj.replaceAll("\\.","");
        cpfnj = cpfnj.replaceAll("\\-","");
        cpfnj = cpfnj.replaceAll("\\/","");
        while (cpfnj.startsWith("0")){
            cpfnj = cpfnj.substring(1);
        }
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            preparador.setString(1, cpfnj);
            resultado = preparador.executeQuery();
            if (resultado.next()){
                cadastrado = true;
            } else {
                cadastrado = false;
            }
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
        return cadastrado;
    }
    
    public void atualizarCliente(String cpf){
    
    }
    
    public void removerCliente(String cpf){
    
    }
}

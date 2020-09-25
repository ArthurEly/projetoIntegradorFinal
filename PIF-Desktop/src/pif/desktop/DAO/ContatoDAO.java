/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pif.desktop.Classes.Cliente;
import pif.desktop.Classes.Contato;
import pif.desktop.Classes.FormatacaoStrings;

/**
 *
 * @author arthu
 */
public class ContatoDAO {
    
    FormatacaoStrings fs = new FormatacaoStrings();
    
    public Contato consultarContato(String cpfnj) {
        Contato ctt = new Contato();
        cpfnj = fs.retirarFormatacao(cpfnj);
        cpfnj = fs.zerosAEsquerda(cpfnj);
        String select = "SELECT * FROM contato_teste WHERE cliente_colab_cpf_ou_cnpj ="+cpfnj;
        Conexao con = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;       
        try{
            conexao = con.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            if (resultado.next()){
                ctt.setClienteContatoEmail(resultado.getString("cliente_colab_email"));
                ctt.setClienteContatoNumTel1(resultado.getString("cliente_colab_telefone_1"));
                ctt.setClienteContatoNumTel2(resultado.getString("cliente_colab_telefone_2"));
                ctt.setClienteContatoCpfnj(cpfnj);
            } else {
                //nada
            }
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
        con.desconectarDoBanco();
        return ctt;
    }
    
    public Contato consultarContatoLogin(String email) {
        Contato ctt = new Contato();
        String select = "SELECT * FROM contato_teste WHERE cliente_colab_email ='"+email+"'";
        Conexao con = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;       
        try{
            conexao = con.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            if (resultado.next()){
                ctt.setClienteContatoEmail(email);
                ctt.setClienteContatoNumTel1(resultado.getString("cliente_colab_telefone_1"));
                ctt.setClienteContatoNumTel2(resultado.getString("cliente_colab_telefone_2"));
                ctt.setClienteContatoCpfnj(resultado.getString("cliente_colab_cpf_ou_cnpj"));
            } else {
                //nada
            }
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
        con.desconectarDoBanco();
        return ctt;
    }
    
    public void atualizarContato(Contato ctt){
        Conexao con = new Conexao();
        PreparedStatement preparador = null;
        String updateContato = "UPDATE `contato_teste` SET `cliente_colab_email`='"+ctt.getClienteContatoEmail()+"',`cliente_colab_telefone_1`='"+ctt.getClienteContatoNumTel1()+"',`cliente_colab_telefone_2`='"+ctt.getClienteContatoNumTel2()+"' "
                + "WHERE `cliente_colab_cpf_ou_cnpj` ="+ctt.getClienteContatoCpfnj();
        preparador = null;
        try{
            preparador = con.conectarAoBanco().prepareStatement(updateContato);         
            preparador.execute();
            preparador.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
        con.desconectarDoBanco();
    }
}

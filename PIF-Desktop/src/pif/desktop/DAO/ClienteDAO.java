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
public class ClienteDAO {
    
    FormatacaoStrings fs = new FormatacaoStrings();
 
    public boolean verificarCliente(String cpfnj, String tabela){
        boolean cadastrado=false;
        cpfnj = fs.retirarFormatacao(cpfnj);
        cpfnj = fs.zerosAEsquerda(cpfnj);
        String select = "SELECT * FROM "+tabela+" WHERE cliente_cpf_ou_cnpj ="+cpfnj;
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;       
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
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
    
    public Cliente consultarCliente(String cpfnj){
        Cliente c = new Cliente();
        cpfnj = fs.retirarFormatacao(cpfnj);
        cpfnj = fs.zerosAEsquerda(cpfnj);
        String select = "SELECT * FROM cliente_teste WHERE cliente_cpf_ou_cnpj ="+cpfnj;
        Conexao con = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;       
        try{
            conexao = con.conectarAoBanco();      
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            if (resultado.next()){
                c.setClienteCpfOuCnpj(resultado.getString("cliente_cpf_ou_cnpj"));
                c.setClienteRgOuIe(resultado.getString("cliente_rg_ou_ie"));
                c.setClienteNomeOuRazao(resultado.getString("cliente_nome_ou_razao"));
                c.setClienteSobrenomeOuFantasia(resultado.getString("cliente_sobrenome_ou_nome_fantasia"));
                c.setClientePj(resultado.getBoolean("cliente_pj"));
                c.setClienteDataNasc(resultado.getString("cliente_nascimento"));
                c.setClienteEndEstado(resultado.getString("cliente_uf"));
                c.setClienteEndCep(resultado.getString("cliente_cep"));
                c.setClienteEndCidade(resultado.getString("cliente_cidade"));
                c.setClienteEndBairro(resultado.getString("cliente_bairro"));
                c.setClienteEndLograd(resultado.getString("cliente_lograd"));
                c.setClienteEndLogradNum(resultado.getString("cliente_lograd_num")); 
                c.setClienteEndLogradComp(resultado.getString("cliente_lograd_comp"));
            } else {
                //nada
            }
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro na verificaçãsdffsdsdfo:  "+e);
        }
        return c;
    }  
    
    public void atualizarCliente(Cliente c){
        String updateCliente = "UPDATE `cliente_teste` SET `cliente_uf`='"+c.getClienteEndEstado()+"',`cliente_cep`='"+c.getClienteEndCep()+"',`cliente_cidade`='"+c.getClienteEndCidade()+"',"
                + "`cliente_bairro`='"+c.getClienteEndBairro()+"',`cliente_lograd`='"+c.getClienteEndLograd()+"',`cliente_lograd_num`='"+c.getClienteEndLogradNum()+"',"
                + "`cliente_lograd_comp`='"+c.getClienteEndLogradComp()+"' WHERE `cliente_cpf_ou_cnpj` ="+c.getClienteCpfOuCnpj();
        Conexao con = new Conexao();
        PreparedStatement preparador = null;
        try{            
            preparador = con.conectarAoBanco().prepareStatement(updateCliente);         
            preparador.execute();
            preparador.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
    } 
}

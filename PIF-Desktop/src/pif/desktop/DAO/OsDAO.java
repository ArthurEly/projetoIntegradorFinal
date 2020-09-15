/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.data;

/**
 *
 * @author arthu
 */
public class OsDAO {
    
    public String numeroOsAtual(){
        String numOs = "";
        String select = "SELECT MAX(os_numero)+1 FROM `os_teste`";
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            if(resultado != null && resultado.next()){
                numOs = resultado.getString("MAX(os_numero)+1");
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }catch(NullPointerException e){
            System.out.println("Nao tem internet fio");
        }
        return numOs;
    }

    public List<OS> consultaOs(String campo, String valor){
        List<OS> OSs = new ArrayList<OS>();
        String select = "SELECT * FROM `os_teste` WHERE "+campo+" = "+valor;
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            while(resultado != null && resultado.next()){
                OS os = new OS();
                os.setOsNumero(resultado.getString("os_numero"));
                os.setOsCpfnj(resultado.getString("cliente_cpf_ou_cnpj"));
                os.setOsVeiculoPlaca(resultado.getString("veiculo_placa"));
                os.setOsVeiculoSituacao(resultado.getString("veiculo_situacao"));
                os.setOsDataEntrada(resultado.getString("os_data_entrada"));
                os.setOsPrevisaoSaida(resultado.getString("os_previsao_saida"));
                os.setOsDataSaida(resultado.getString("os_data_saida"));
                os.setOsOrcamentoAtual(resultado.getString("os_orcamento_atual"));
                os.setOsColabNome(resultado.getString("colaborador_nome_atendimento"));  
                OSs.add(os);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        return OSs;
    }
    
    public boolean verificarOs(String os){
        boolean cadastrado=false;
        String select = "SELECT * FROM os_teste WHERE os_numero = ?";
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            preparador.setString(1, os);
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

    public void atualizarOs(String numeroOs, String previsaoSaida, String situacaoVeiculo) {
        String select = "UPDATE `os_teste` SET `veiculo_situacao`='"+situacaoVeiculo+"',`os_previsao_saida`='"+previsaoSaida+"' WHERE `os_numero` = "+numeroOs;
        Conexao c = new Conexao();
        PreparedStatement preparador = null;
        try{
            preparador = c.conectarAoBanco().prepareStatement(select);         
            preparador.execute();
            preparador.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
    }

    public void concluirOs(String osNumero) {
        String select = "UPDATE `os_teste` SET `os_data_saida`= ? WHERE `os_numero` = "+osNumero;
        Conexao c = new Conexao();
        PreparedStatement preparador = null;
        data d = new data();
        String dataHoje = d.dataFormatada();
        try{
            preparador = c.conectarAoBanco().prepareStatement(select);   
            preparador.setString(1, dataHoje);
            preparador.execute();
            preparador.close();
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
    }
}

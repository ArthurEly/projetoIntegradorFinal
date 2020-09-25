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
        c.desconectarDoBanco();
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
                os.setOsColabNome(resultado.getString("colaborador_nome_atendimento"));  
                OSs.add(os);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        c.desconectarDoBanco();
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
        c.desconectarDoBanco();
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
        c.desconectarDoBanco();
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
        c.desconectarDoBanco();
    }
    
    public void atualizarSituacaoOs(String veiculoNumOs, String situacao){
        String updateSituacao = "UPDATE `os_teste` SET `veiculo_situacao`='"+situacao+"' "
                + "WHERE os_numero = "+veiculoNumOs;
        Conexao c = new Conexao();
        PreparedStatement preparador = null;
        preparador = null;
        try{
            preparador = c.conectarAoBanco().prepareStatement(updateSituacao);         
            preparador.execute();
            preparador.close();           
        }catch(Exception e){
            System.out.println("Erro na verificação:  "+e);
        }
        c.desconectarDoBanco();
    }
    
    public List<OS> consultaOsEntradaDiaria(String dataEntrada, String dataSaida){
        List<OS> OSs = new ArrayList<OS>();
        String select = "SELECT DAY(`os_data_entrada`) as \"Dia entrada\", COUNT(`os_numero`) as \"Contador\" FROM `os_teste` "
                + "WHERE `os_data_entrada` BETWEEN (\""+dataEntrada+"\") AND (\""+dataSaida+"\") GROUP BY DAY(`os_data_entrada`)";
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
                os.setOsDataEntrada(resultado.getString("Dia entrada"));
                os.setQtdOs(resultado.getString("Contador"));
                OSs.add(os);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        c.desconectarDoBanco();
        return OSs;
    }
    
    public List<OS> consultaOsSaidaDiaria(String dataEntrada, String dataSaida){
        List<OS> OSs = new ArrayList<OS>();
        String select = "SELECT DAY(`os_data_saida`) as \"Dia saída\", COUNT(`os_numero`) as \"Contador\" FROM `os_teste` "
                + "WHERE `os_data_saida` BETWEEN (\""+dataEntrada+"\") AND (\""+dataSaida+"\") GROUP BY DAY(`os_data_saida`)";
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
                os.setOsDataSaida(resultado.getString("Dia saída"));
                os.setQtdOs(resultado.getString("Contador"));
                OSs.add(os);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        c.desconectarDoBanco();
        return OSs;
    }
    
    public OS consultaOsSaidaEEntrada(String dataEntrada, String dataSaida){
        OS os = new OS();
        String abertas = "SELECT COUNT(os_numero) as \"Concluídas\" FROM `os_teste` WHERE `os_data_saida` BETWEEN (\""+dataEntrada+"\") AND (\""+dataSaida+"\")";
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(abertas);
            resultado = preparador.executeQuery();
            while(resultado != null && resultado.next()){
                os.setQtdConcluida(resultado.getString("Concluídas"));
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        String concluídas = "SELECT COUNT(os_numero) as \"Quantidade de OS\" FROM `os_teste` "
                + "WHERE `os_data_entrada` BETWEEN (\""+dataEntrada+"\") AND (\""+dataSaida+"\")";
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(concluídas);
            resultado = preparador.executeQuery();
            while(resultado != null && resultado.next()){               
                os.setQtdOs(resultado.getString("Quantidade de OS"));
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("ajfoldsa:  "+e);
        }
        c.desconectarDoBanco();
        return os;
    }
}

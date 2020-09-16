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
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.List;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.data;

/**
 *
 * @author arthu
 */
public class OrcamentoDAO {
    
    public void cadastrarOrcamento(Orcamento orc, OS os){
        Conexao c = new Conexao();
        c.conectarAoBanco();
        try{
            String sqlOrc = "INSERT INTO `orcamento_teste`(`os_numero`, `orcamento_preco_pecas`, `orcamento_descricao_pecas`, `orcamento_preco_servicos`, `orcamento_descricao_servicos`, `orcamento_data`) VALUES (?,?,?,?,?,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOrc = c.getConexao().prepareStatement(sqlOrc);
            //bota os parametros nos lugares correspondentes
            data d = new data();
            String dataHoje = d.dataFormatada();
            consultaOrc.setString(1, os.getOsNumero());           
            if ("".equals(orc.getOrcamento_preco_pecas())){
                consultaOrc.setNull(2,NULL);
            } else {
                consultaOrc.setString(2, orc.getOrcamento_preco_pecas());
            }           
            if ("<-- Insira um valor ao lado".equals(orc.getOrcamento_descricao_pecas())){
                consultaOrc.setNull(3,NULL);
            } else {
                consultaOrc.setString(3, orc.getOrcamento_descricao_pecas());
            }          
            if ("".equals(orc.getOrcamento_preco_servicos())){
                consultaOrc.setNull(4,NULL);
            } else {
                consultaOrc.setString(4, orc.getOrcamento_preco_servicos());
            }             
            if ("<-- Insira um valor ao lado".equals(orc.getOrcamento_descricao_servicos())){
                consultaOrc.setNull(5,NULL);
            } else {
                consultaOrc.setString(5, orc.getOrcamento_descricao_servicos());
            }            
            consultaOrc.setString(6, d.dataFormatada());
            //executa a query no banco de dados
            consultaOrc.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOrc.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta no orçamento: " + ex);
        } 
    }
    
    public List<Orcamento> consultarOrcamento(String numOS){
        List<Orcamento> Orcs = new ArrayList<>();
        String select = "SELECT * FROM `orcamento_teste` WHERE os_numero LIKE '%"+numOS+"%'";
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            while(resultado != null && resultado.next()){
                Orcamento orc = new Orcamento();
                orc.setOrcamento_preco_pecas(resultado.getString("orcamento_preco_pecas"));
                orc.setOrcamento_preco_servicos(resultado.getString("orcamento_preco_servicos"));
                orc.setOrcamento_descricao_pecas(resultado.getString("orcamento_descricao_pecas"));
                orc.setOrcamento_descricao_servicos(resultado.getString("orcamento_descricao_servicos"));
                orc.setOrcamento_data(resultado.getString("orcamento_data"));
                Orcs.add(orc);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("erro na consulta do orçamento: "+e);
        }
        return Orcs;
    }

    public void excluirItemOrcamento(String data) {
        Conexao c = new Conexao();
        c.conectarAoBanco();
        try{
            String sqlOrc = "DELETE FROM `orcamento_teste` WHERE `orcamento_data` = '"+data+"';";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOrc = c.getConexao().prepareStatement(sqlOrc);           
            //executa a query no banco de dados
            consultaOrc.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOrc.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta na exclusão do negócio aqui " + ex);
        }                 
    }
}

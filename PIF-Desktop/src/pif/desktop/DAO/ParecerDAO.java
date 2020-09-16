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
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.ParecerTecnico;
import pif.desktop.Classes.data;

/**
 *
 * @author arthu
 */
public class ParecerDAO {
    
    public List<ParecerTecnico> consultarPareceres(String numOs){
        List<ParecerTecnico> prcs = new ArrayList<>();
        String select = "SELECT * FROM `parecer_tecnico_teste` WHERE os_numero = "+numOs;
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            while(resultado != null && resultado.next()){
                ParecerTecnico prc = new ParecerTecnico();
                prc.setOsNumero(resultado.getString("os_numero"));
                prc.setParecerData(resultado.getString("parecer_data"));
                prc.setColabNomeTecnico(resultado.getString("colab_nome_tecnico"));
                prc.setParecerDescricao(resultado.getString("parecer_descricao"));
                prcs.add(prc);
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("erro na consulta do parecer: "+e);
        }
        return prcs;
    }

    public void excluirParecerTecnico(String data) {
        Conexao c = new Conexao();
        c.conectarAoBanco();
        try{
            String sqlPrc = "DELETE FROM `parecer_tecnico_teste` WHERE `parecer_data` = '"+data+"';";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaPrc = c.getConexao().prepareStatement(sqlPrc);           
            //executa a query no banco de dados
            consultaPrc.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaPrc.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta na exclusão do negócio aqui " + ex);
        }     
    }
    
    public void adicionarParecerTecnico(ParecerTecnico prc){
        Conexao c = new Conexao();
        c.conectarAoBanco();
        try{
            String sqlOrc = "INSERT INTO `parecer_tecnico_teste`(`os_numero`, `parecer_data`, `colab_nome_tecnico`, `parecer_descricao`) VALUES (?,?,?,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOrc = c.getConexao().prepareStatement(sqlOrc);
            //bota os parametros nos lugares correspondentes
            data d = new data();
            String dataHoje = d.dataFormatada();
            consultaOrc.setString(1, prc.getOsNumero());           
            consultaOrc.setString(2, d.dataFormatada());       
            consultaOrc.setString(3, prc.getColabNomeTecnico());          
            consultaOrc.setString(4, prc.getParecerDescricao());
            //executa a query no banco de dados
            consultaOrc.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOrc.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta no parecer: " + ex);
        } 
    }
}

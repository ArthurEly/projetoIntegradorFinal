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
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.ParecerTecnico;

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
}

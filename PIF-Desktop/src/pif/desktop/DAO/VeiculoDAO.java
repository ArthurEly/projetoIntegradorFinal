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
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Veiculo;

/**
 *
 * @author arthu
 */
public class VeiculoDAO {
    
    public Veiculo consultarVeiculo(String placa, String numeroOs){
        Veiculo v = new Veiculo();
        String select = "SELECT * FROM `veiculo_teste` WHERE `veiculo_placa` ="+placa+" AND `os_numero` = "+numeroOs;
        System.out.println(select);
        Conexao c = new Conexao();
        Connection conexao = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        try{
            conexao = c.conectarAoBanco();           
            preparador = conexao.prepareStatement(select);
            resultado = preparador.executeQuery();
            while (resultado != null && resultado.next()){
                v.setVeiculoPlaca(resultado.getString("veiculo_placa"));
                v.setVeiculoTipo(resultado.getString("veiculo_tipo"));
                v.setVeiculoFabricante(resultado.getString("veiculo_fabricante"));
                v.setVeiculoModelo(resultado.getString("veiculo_modelo"));
                v.setVeiculoCor(resultado.getString("veiculo_cor"));
                v.setVeiculoAno(resultado.getString("veiculo_ano"));
                v.setVeiculoAcessorios(resultado.getString("veiculo_acessorios"));
                v.setVeiculoObservacoes(resultado.getString("veiculo_observacoes"));
                v.setVeiculoDefeitoCliente(resultado.getString("veiculo_defeito_cliente"));  
                v.setVeiculoSituacao(resultado.getString("veiculo_situacao"));  
                v.setVeiculoParecerTecnico(resultado.getString("parecer_tecnico")); 
                v.setVeiculoNumOs(resultado.getString("os_numero")); 
                v.setVeiculoDono(resultado.getString("veiculo_dono")); 
            }          
            conexao.close();
        }catch(SQLException e){
            System.out.println("erro ao encontrar o veículo:  "+e);
        }
        return v;
    }
}

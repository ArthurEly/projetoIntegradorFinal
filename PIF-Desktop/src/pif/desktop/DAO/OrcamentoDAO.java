/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.data;

/**
 *
 * @author arthu
 */
public class OrcamentoDAO {
    
    public void cadastrarDados(Orcamento orc){
        /*
            MÉTODO RESPONSÁVEL POR CADASTRAR (CREATE) AS INFORMAÇÕES NO BANCO DE DADOS
        */
        Conexao c = new Conexao();
        c.conectarAoBanco();
        try{
            String sqlOs = "INSERT INTO `orcamento_teste`(`os_numero`, `orcamento_preco_pecas`, `orcamento_descricao_pecas`, `orcamento_preco_servicos`, `orcamento_descricao_servicos`, `orcamento_data`) VALUES (?,?,?,?,?,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOs = c.getConexao().prepareStatement(sqlOs);
            //bota os parametros nos lugares correspondentes
            data d = new data();
            String dataHoje = d.dataFormatada();
            if ("".equals(orc.getOrcamento_descricao_pecas())){
                orc.setOrcamento_descricao_pecas("DEFAULT");
            }
            if ("".equals(orc.getOrcamento_descricao_servicos())){
                orc.setOrcamento_descricao_pecas("DEFAULT");
            }
            if ("".equals(orc.getOrcamento_preco_pecas())){
                orc.setOrcamento_descricao_pecas("DEFAULT");
            }
            if ("".equals(orc.getOrcamento_preco_servicos())){
                orc.setOrcamento_descricao_pecas("DEFAULT");
            }           
            consultaOs.setString(1, "1");
            consultaOs.setString(2, orc.getOrcamento_preco_pecas());
            consultaOs.setString(3, orc.getOrcamento_descricao_pecas());
            consultaOs.setString(4, orc.getOrcamento_preco_servicos());
            consultaOs.setString(5, orc.getOrcamento_descricao_servicos());
            consultaOs.setString(6, d.dataFormatada());
            //executa a query no banco de dados
            consultaOs.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOs.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta no orçamento: " + ex);
        } 
    }
}

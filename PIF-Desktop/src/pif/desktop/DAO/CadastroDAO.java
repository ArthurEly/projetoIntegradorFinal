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
import pif.desktop.Classes.Cliente;
import pif.desktop.Classes.Colab;
import pif.desktop.Classes.Contato;
import pif.desktop.Classes.Equipamento;
import pif.desktop.Classes.OS;

/**
 *
 * @author arthu
 */
public class CadastroDAO {
    
    public void cadastrarDados(Cliente cliente, Contato contato, Equipamento equip, OS os, Colab colab){
        /*
            MÉTODO RESPONSÁVEL POR CADASTRAR (CREATE) AS INFORMAÇÕES NO BANCO DE DADOS
        */
        Conexao c = new Conexao();
        c.conectarAoBanco();
        
        try{
            //conecta-se ao banco            
            String sqlCliente = "INSERT INTO cliente_teste (cliente_nome_ou_razao, cliente_sobrenome_ou_nome_fantasia,"
                    + "cliente_cpf_ou_cnpj, cliente_rg_ou_ie, cliente_pj, cliente_uf, cliente_cep, cliente_cidade,"
                    + "cliente_bairro, cliente_lograd, cliente_lograd_num, cliente_lograd_comp) VALUES (?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaCliente = c.getConexao().prepareStatement(sqlCliente);
            //bota os parametros nos lugares correspondentes
            consultaCliente.setString(1, cliente.getClienteNomeOuRazao());
            consultaCliente.setString(2, cliente.getClienteSobrenomeOuFantasia());
            consultaCliente.setString(3, cliente.getClienteCpfOuCnpj());
            consultaCliente.setString(4, cliente.getClienteRgOuIe());
            consultaCliente.setBoolean(5, cliente.isClientePj());
            consultaCliente.setString(6, cliente.getClienteEndEstado());
            consultaCliente.setString(7, cliente.getClienteEndCep());
            consultaCliente.setString(8, cliente.getClienteEndCidade());
            consultaCliente.setString(9, cliente.getClienteEndBairro());
            consultaCliente.setString(10, cliente.getClienteEndLograd());
            consultaCliente.setString(11, cliente.getClienteEndLogradNum());
            consultaCliente.setString(12, cliente.getClienteEndLogradComp());
            //executa a query no banco de dados           
            consultaCliente.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaCliente.close();
        }catch(SQLException ex){
            System.out.println("Deu treta no cliente: " + ex);
        } 
        
        try{
            String sqlContato = "INSERT INTO `contato_teste`(`cliente_colab_cpf_ou_cnpj`, `cliente_colab_email`, `cliente_colab_telefone_1`, `cliente_colab_telefone_2`) VALUES ("
                    + "?, ?, ?, ?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaContato = c.getConexao().prepareStatement(sqlContato);
            //bota os parametros nos lugares correspondentes
            consultaContato.setString(1, cliente.getClienteCpfOuCnpj());
            consultaContato.setString(2, contato.getClienteContatoEmail());
            consultaContato.setString(3, contato.getClienteContatoNumTel1());
            consultaContato.setString(4, contato.getClienteContatoNumTel2());
            //executa a query no banco de dados
            consultaContato.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaContato.close();
        }catch(SQLException ex){
            System.out.println("Deu treta no contato: " + ex);
        } 
        
        try{
            String sqlEquip = "INSERT INTO `equipamento_teste`(`equipamento_tipo`, `equipamento_modelo`, `equipamento_marca`, `equipamento_serie_ou_imei`, "
                    + "`equipamento_acessorios`, `equipamento_foto`, `equipamento_observacoes`, `equipamento_defeito_cliente`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaEquip = c.getConexao().prepareStatement(sqlEquip);
            //bota os parametros nos lugares correspondentes
            consultaEquip.setString(1, equip.getEquipTipo());
            consultaEquip.setString(2, equip.getEquipModelo());
            consultaEquip.setString(3, equip.getEquipMarca());
            consultaEquip.setString(4, equip.getEquipNsOuImei());
            consultaEquip.setString(5, equip.getEquipAcessorios());
            consultaEquip.setBlob(6, equip.getEquipFoto());
            consultaEquip.setString(7, equip.getEquipObservacoes());
            consultaEquip.setString(8, equip.getEquipDefeitoCliente());
            //executa a query no banco de dados
            consultaEquip.execute();
        }catch(SQLException ex){
            System.out.println("Deu treta no equip: " + ex);
        }   
        
        try{
            String sqlOs = "INSERT INTO `os_teste`(`os_numero`, `cliente_cpf_ou_cnpj`, `equipamento_serie_ou_imei`, `equipamento_situacao`, `os_data_entrada`, `os_previsao_saida`, `os_data_saida`, `os_orcamento_atual`, `colaborador_nome_atendimento`) VALUES (DEFAULT,?,?,DEFAULT,NOW(),?,DEFAULT,?,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOs = c.getConexao().prepareStatement(sqlOs);
            //bota os parametros nos lugares correspondentes
            consultaOs.setString(1, cliente.getClienteCpfOuCnpj());
            consultaOs.setString(2, equip.getEquipNsOuImei());
            consultaOs.setString(3, os.getOsPrevisaoSaida());
            consultaOs.setString(4, os.getOsOrcamentoAtual());
            consultaOs.setString(5, colab.getColabNome());
            //executa a query no banco de dados
            consultaOs.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOs.close();
            c.desconectarDoBanco();               
        }catch(SQLException ex){
            System.out.println("Deu treta na OS: " + ex);
        } 
    }
}

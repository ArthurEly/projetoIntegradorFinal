/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import pif.desktop.Classes.Cliente;
import pif.desktop.Classes.Contato;
import pif.desktop.Classes.Veiculo;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.USER_LOGADO;
import pif.desktop.Classes.data;

/**
 *
 * @author arthu
 */
public class CadastroDAO {
    
    public void cadastrarDados(Cliente cliente, Contato contato, Veiculo veiculo, OS os, Orcamento o, boolean jaCadastrado){
        /*
            MÉTODO RESPONSÁVEL POR CADASTRAR (CREATE) AS INFORMAÇÕES NO BANCO DE DADOS
        */
        Conexao c = new Conexao();
        c.conectarAoBanco();
        if (jaCadastrado == false){
            try{
            //conecta-se ao banco   
            String sqlCliente = "INSERT INTO cliente_teste (cliente_nome_ou_razao, cliente_sobrenome_ou_nome_fantasia,"
                    + "cliente_cpf_ou_cnpj, cliente_rg_ou_ie, cliente_pj, cliente_uf, cliente_cep, cliente_cidade,"
                    + "cliente_bairro, cliente_lograd, cliente_lograd_num, cliente_lograd_comp, cliente_nascimento, cliente_pass) VALUES (?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            consultaCliente.setString(13, cliente.getClienteDataNasc());
            consultaCliente.setString(14, cliente.getClienteCpfOuCnpj());
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
            if (contato.getClienteContatoNumTel2().equals("")){
                consultaContato.setInt(4, NULL);
            } else {
                consultaContato.setString(4, contato.getClienteContatoNumTel2());
            }           
            //executa a query no banco de dados
            consultaContato.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaContato.close();
            }catch(SQLException ex){
                System.out.println("Deu treta no contato: " + ex);
            } 
        }
       
        try{
            String sqlEquip = "INSERT INTO `veiculo_teste`(`veiculo_placa`, `veiculo_tipo`, `veiculo_fabricante`, `veiculo_modelo`, `veiculo_cor`, `veiculo_ano`, `veiculo_acessorios`, "
                    + "`veiculo_observacoes`, `veiculo_defeito_cliente`,`parecer_tecnico`,`os_numero`, `veiculo_dono`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaVeiculo = c.getConexao().prepareStatement(sqlEquip);
            //bota os parametros nos lugares correspondentes
            consultaVeiculo.setString(1, veiculo.getVeiculoPlaca());
            consultaVeiculo.setString(2, veiculo.getVeiculoTipo());
            consultaVeiculo.setString(3, veiculo.getVeiculoFabricante());
            consultaVeiculo.setString(4, veiculo.getVeiculoModelo());
            consultaVeiculo.setString(5, veiculo.getVeiculoCor());
            consultaVeiculo.setString(6, veiculo.getVeiculoAno());
            consultaVeiculo.setString(7, veiculo.getVeiculoAcessorios());
            consultaVeiculo.setString(8, veiculo.getVeiculoObservacoes());
            consultaVeiculo.setString(9, veiculo.getVeiculoDefeitoCliente());
            consultaVeiculo.setString(10, os.getOsNumero());
            consultaVeiculo.setString(11, os.getOsNumero());
            consultaVeiculo.setString(12, cliente.getClienteCpfOuCnpj());
            //executa a query no banco de dados
            consultaVeiculo.execute();
        }catch(SQLException ex){
            System.out.println("Deu treta no veiculo: " + ex);
        }   
        
        try{
            String sqlOs = "INSERT INTO `os_teste`(`os_numero`, `cliente_cpf_ou_cnpj`, `veiculo_placa`, `veiculo_situacao`, `os_data_entrada`, `os_previsao_saida`, `os_data_saida`, `colaborador_nome_atendimento`) VALUES (DEFAULT,?,?,DEFAULT,?,?,DEFAULT,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOs = c.getConexao().prepareStatement(sqlOs);
            //bota os parametros nos lugares correspondentes
            data d = new data();
            String dataHoje = d.dataFormatada();
            consultaOs.setString(1, cliente.getClienteCpfOuCnpj());
            consultaOs.setString(2, veiculo.getVeiculoPlaca());
            consultaOs.setString(3, dataHoje);
            consultaOs.setString(4, os.getOsPrevisaoSaida());
            consultaOs.setString(5, USER_LOGADO.getCOLAB_NOME());
            //executa a query no banco de dados
            consultaOs.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOs.close();             
        }catch(SQLException ex){
            System.out.println("Deu treta na OS: " + ex);
        } 
        
        try{
            String sqlOrc = "INSERT INTO `orcamento_teste`(`os_numero`, `orcamento_preco_pecas`,"
                    + " `orcamento_descricao_pecas`, `orcamento_preco_servicos`, `orcamento_descricao_servicos`, "
                    + "`orcamento_data`) VALUES ("
                    + "?,?,?,?,?,?)";
            //prepara a query sql acima para jogar dentro do banco de dados
            PreparedStatement consultaOrc = c.getConexao().prepareStatement(sqlOrc);
            //bota os parametros nos lugares correspondentes
            data d = new data();
            String dataHoje = d.dataFormatada();
            consultaOrc.setString(1, os.getOsNumero());
            consultaOrc.setString(2, o.getOrcamento_preco_pecas());
            consultaOrc.setString(3, o.getOrcamento_descricao_pecas());
            consultaOrc.setString(4, o.getOrcamento_preco_servicos());
            consultaOrc.setString(5, o.getOrcamento_descricao_servicos());
            consultaOrc.setString(6, dataHoje);
            //executa a query no banco de dados
            consultaOrc.execute();
            //fecha a consulta ao banco e se desconecta dele
            consultaOrc.close();
            c.desconectarDoBanco();            
        }catch(SQLException ex){
            System.out.println("Deu treta no orçamento: " + ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS.rascunhos;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pif.desktop.Classes.Cliente;
import pif.desktop.Classes.Contato;
import pif.desktop.Classes.FormatacaoStrings;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.ParecerTecnico;
import pif.desktop.Classes.Veiculo;
import pif.desktop.Classes.VerificacaoStrings;
import pif.desktop.DAO.ClienteDAO;
import pif.desktop.DAO.ContatoDAO;
import pif.desktop.DAO.OrcamentoDAO;
import pif.desktop.DAO.OsDAO;
import pif.desktop.DAO.ParecerDAO;
import pif.desktop.DAO.VeiculoDAO;
import pif.desktop.TELAS.TelaUtils;

/**
 *
 * @author arthu
 */
public class consulta_os extends javax.swing.JFrame {
    
    FormatacaoStrings fs = new FormatacaoStrings();
    VerificacaoStrings vs = new VerificacaoStrings();
    int contadorEditar = 0;
    private static OS os;
    Image icon;
    TelaUtils u;
    /**
     * Creates new form rascunho_tela
     */
    public consulta_os(OS os, List<Orcamento> orc) {
        initComponents();   
        try {
            icon = ImageIO.read(new File("src/resources/icon.png"));           
        } catch (IOException e) {
            e.printStackTrace();
        }  
        this.os = os;
        painelOs.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "OS de número " + os.getOsNumero(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        campoCpfnj.setText(fs.botarCpfOuCnpj(os.getOsCpfnj()));
        campoPlaca.setText(os.getOsVeiculoPlaca());
        campoSituacaoVeiculo.setText(os.getOsVeiculoSituacao());
        campoAtendente.setText(os.getOsColabNome());       
        campoDataEntrada.setText(fs.botarData(os.getOsDataEntrada()));
        campoPrevisaoSaida.setText(fs.botarData(os.getOsPrevisaoSaida()));
        if (os.getOsDataSaida() != null){
            campoDataSaida.setText(fs.botarData(os.getOsDataSaida()));
        } else {
            campoDataSaida.setText("");
        }
        setIconImage(icon);     
        setTitle("OS de número "+os.getOsNumero());  
        painelDeRolagemPecasEServicos.getVerticalScrollBar().setUnitIncrement(8); 
        painelOrcamentoPecasEServicos.setLayout(new GridLayout(0,1));
        JPanel jFilho;
        JLabel titlePrecoPecas,titlePrecoServico,titleDescPeca,titleDescServico,titleData, cifrao1, cifrao2;
        JTextField campoPrecoPecas, campoPrecoServico, campoDescPeca, campoDescServico, campoData;
        JButton btnExcluirItem;
        for (int i=0;i<orc.size();i++){
            //<editor-fold defaultstate="collapsed" desc="Painel">
            //<editor-fold defaultstate="collapsed" desc="Declaração de variáveis e atribuição de valores">
            Orcamento o;
            o = orc.get(i);
            jFilho = new JPanel();
            jFilho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 190, 190)));
            
            titlePrecoPecas = new JLabel(); 
            titlePrecoPecas.setText("Preço da peça:");
            titlePrecoPecas.setToolTipText("");
            
            titlePrecoServico = new JLabel();
            titlePrecoServico.setText("Preço do serviço:");
            
            titleDescPeca = new JLabel();
            titleDescPeca.setText("Descrição da peça:");
            titleDescPeca.setToolTipText("");
            
            titleDescServico = new JLabel();
            titleDescServico.setText("Descrição do serviço:");
            
            titleData = new JLabel();
            titleData.setText("Data do orçamento:");
            
            cifrao1 = new JLabel(); 
            cifrao1.setText("R$");
            
            cifrao2 = new JLabel();
            cifrao2.setText("R$");
            
            campoPrecoPecas = new JTextField();
            campoPrecoPecas.setText(fs.botarDinheiro(o.getOrcamento_preco_pecas()));
            campoPrecoPecas.setBackground(new java.awt.Color(240, 240, 240));
            campoPrecoPecas.setBorder(null);
            campoPrecoPecas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            campoPrecoPecas.setEnabled(false);
            campoPrecoPecas.setName("orcamento");
            
            campoPrecoServico = new JTextField();
            campoPrecoServico.setText(fs.botarDinheiro(o.getOrcamento_preco_servicos()));
            campoPrecoServico.setBackground(new java.awt.Color(240, 240, 240));
            campoPrecoServico.setBorder(null);
            campoPrecoServico.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            campoPrecoServico.setEnabled(false);
            campoPrecoServico.setName("orcamento"); // NOI18N
            
            campoDescPeca = new JTextField();
            campoDescPeca.setText(o.getOrcamento_descricao_pecas());
            campoDescPeca.setBackground(new java.awt.Color(240, 240, 240));
            campoDescPeca.setBorder(null);
            campoDescPeca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            campoDescPeca.setEnabled(false);
            
            campoDescServico = new JTextField(); 
            campoDescServico.setText(o.getOrcamento_descricao_servicos());
            campoDescServico.setBackground(new java.awt.Color(240, 240, 240));
            campoDescServico.setBorder(null);
            campoDescServico.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            campoDescServico.setEnabled(false);
            
            campoData = new JTextField();
            campoData.setText(fs.botarData(o.getOrcamento_data()));
            campoData.setBackground(new java.awt.Color(240, 240, 240));
            campoData.setBorder(null);
            campoData.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            campoData.setEnabled(false);
            
            
            btnExcluirItem = new JButton();
            btnExcluirItem.setBackground(new java.awt.Color(204, 0, 0));
            btnExcluirItem.setForeground(new java.awt.Color(255, 255, 255));
            btnExcluirItem.setText("Excluir");
            btnExcluirItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
            btnExcluirItem.setContentAreaFilled(false);
            btnExcluirItem.setFocusPainted(false);
            btnExcluirItem.setOpaque(true);
            btnExcluirItem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnClicado(evt);
                    excluirItemOrcamento(evt);
                }
            });
            btnExcluirItem.setName(o.getOrcamento_data());
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="Layout do painel">
            javax.swing.GroupLayout painelItemPecaEServicoLayout = new javax.swing.GroupLayout(jFilho);
            jFilho.setLayout(painelItemPecaEServicoLayout);
            painelItemPecaEServicoLayout.setHorizontalGroup(
                painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                            .addComponent(titlePrecoPecas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cifrao1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoPrecoPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                            .addComponent(titlePrecoServico)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cifrao2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoPrecoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                    .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                            .addComponent(titleDescPeca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoDescPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                            .addComponent(titleDescServico)
                            .addGap(18, 18, 18)
                            .addComponent(campoDescServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                    .addComponent(titleData)
                    .addGap(18, 18, 18)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            painelItemPecaEServicoLayout.setVerticalGroup(
                painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelItemPecaEServicoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleDescPeca)
                            .addComponent(campoDescPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titlePrecoPecas)
                            .addComponent(campoPrecoPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cifrao1)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titlePrecoServico)
                            .addComponent(cifrao2)
                            .addComponent(campoPrecoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleDescServico)
                            .addComponent(campoDescServico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(13, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelItemPecaEServicoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelItemPecaEServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleData)
                        .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21))
            );
            //</editor-fold>
            //</editor-fold>
            painelOrcamentoPecasEServicos.add(jFilho);
        }   
        if (os.getOsDataSaida() != null){
            txtConclusaoOs.setForeground(Color.black);
        } else {
            txtConclusaoOs.setForeground(new Color(240,240,240));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDeRolagem = new javax.swing.JScrollPane();
        painelOs = new javax.swing.JPanel();
        titleCpfnj = new javax.swing.JLabel();
        titlePlaca = new javax.swing.JLabel();
        titleSituacaoVeiculo = new javax.swing.JLabel();
        titleAtendente = new javax.swing.JLabel();
        campoCpfnj = new javax.swing.JTextField();
        campoPlaca = new javax.swing.JTextField();
        campoSituacaoVeiculo = new javax.swing.JTextField();
        campoAtendente = new javax.swing.JTextField();
        titleDataEntrada = new javax.swing.JLabel();
        campoDataEntrada = new javax.swing.JTextField();
        titlePrevisaoSaida = new javax.swing.JLabel();
        campoPrevisaoSaida = new javax.swing.JTextField();
        titleDataSaida = new javax.swing.JLabel();
        campoDataSaida = new javax.swing.JTextField();
        txtErroCpfnj = new javax.swing.JLabel();
        txtErroPlaca = new javax.swing.JLabel();
        txtErroSituacaoVeiculo = new javax.swing.JLabel();
        txtErroAtendente = new javax.swing.JLabel();
        txtErroDataEntrada = new javax.swing.JLabel();
        txtErroPrevisaoSaida = new javax.swing.JLabel();
        txtErroDataSaida = new javax.swing.JLabel();
        painelDeRolagemPecasEServicos = new javax.swing.JScrollPane();
        painelParaManterOScroll = new javax.swing.JPanel();
        painelAddItemOrcamento = new javax.swing.JPanel();
        btnLimparCamposOrcamento = new javax.swing.JButton();
        btnAdicionarOrcamento = new javax.swing.JButton();
        titlePrecoPecas1 = new javax.swing.JLabel();
        titlePrecoServicos1 = new javax.swing.JLabel();
        campoPrecoPecasAdd = new javax.swing.JTextField();
        campoPrecoServicosAdd = new javax.swing.JTextField();
        titleDescricaoPrecoPecas1 = new javax.swing.JLabel();
        titleDescricaoPrecoServicos1 = new javax.swing.JLabel();
        campoDescricaoServicosAdd = new javax.swing.JTextField();
        campoDescricaoPecasAdd = new javax.swing.JTextField();
        cifrao2 = new javax.swing.JLabel();
        cifrao3 = new javax.swing.JLabel();
        txtErroAddOrcamento = new javax.swing.JLabel();
        painelOrcamentoPecasEServicos = new javax.swing.JPanel();
        btnIrParaOCliente = new javax.swing.JButton();
        btnIrParaOVeiculo = new javax.swing.JButton();
        btnEditarOs = new javax.swing.JButton();
        btnConcluirOs = new javax.swing.JButton();
        txtConclusaoOs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);
        setMinimumSize(new java.awt.Dimension(1300, 700));

        painelDeRolagem.setBorder(null);
        painelDeRolagem.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelDeRolagem.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelOs.setMinimumSize(new java.awt.Dimension(1280, 660));
        painelOs.setPreferredSize(new java.awt.Dimension(1280, 700));

        titleCpfnj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleCpfnj.setText("CPF ou CNPJ do cliente:");
        titleCpfnj.setToolTipText("");

        titlePlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titlePlaca.setText("Placa do veículo:");
        titlePlaca.setToolTipText("");

        titleSituacaoVeiculo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleSituacaoVeiculo.setText("Situação do veículo:");
        titleSituacaoVeiculo.setToolTipText("");

        titleAtendente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleAtendente.setText("Nome do atendente:");
        titleAtendente.setToolTipText("");

        campoCpfnj.setBackground(new java.awt.Color(240, 240, 240));
        campoCpfnj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoCpfnj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCpfnj.setToolTipText("");
        campoCpfnj.setBorder(null);
        campoCpfnj.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoCpfnj.setEnabled(false);
        campoCpfnj.setName("cpfnj"); // NOI18N

        campoPlaca.setBackground(new java.awt.Color(240, 240, 240));
        campoPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPlaca.setBorder(null);
        campoPlaca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoPlaca.setEnabled(false);

        campoSituacaoVeiculo.setBackground(new java.awt.Color(240, 240, 240));
        campoSituacaoVeiculo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoSituacaoVeiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSituacaoVeiculo.setBorder(null);
        campoSituacaoVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoSituacaoVeiculo.setEnabled(false);
        campoSituacaoVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaSituacao(evt);
            }
        });

        campoAtendente.setBackground(new java.awt.Color(240, 240, 240));
        campoAtendente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoAtendente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoAtendente.setBorder(null);
        campoAtendente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoAtendente.setEnabled(false);

        titleDataEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDataEntrada.setText("Data de entrada:");
        titleDataEntrada.setToolTipText("");

        campoDataEntrada.setBackground(new java.awt.Color(240, 240, 240));
        campoDataEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDataEntrada.setBorder(null);
        campoDataEntrada.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoDataEntrada.setEnabled(false);
        campoDataEntrada.setName("data"); // NOI18N

        titlePrevisaoSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titlePrevisaoSaida.setText("Previsão de saída:");
        titlePrevisaoSaida.setToolTipText("");

        campoPrevisaoSaida.setBackground(new java.awt.Color(240, 240, 240));
        campoPrevisaoSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoPrevisaoSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPrevisaoSaida.setBorder(null);
        campoPrevisaoSaida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoPrevisaoSaida.setEnabled(false);
        campoPrevisaoSaida.setName("data"); // NOI18N
        campoPrevisaoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaPrevisaoSaida(evt);
            }
        });

        titleDataSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDataSaida.setText("Data de saída:");
        titleDataSaida.setToolTipText("");

        campoDataSaida.setBackground(new java.awt.Color(240, 240, 240));
        campoDataSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDataSaida.setBorder(null);
        campoDataSaida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoDataSaida.setEnabled(false);
        campoDataSaida.setName("data"); // NOI18N
        campoDataSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaDataSaida(evt);
            }
        });

        txtErroCpfnj.setForeground(new java.awt.Color(240, 240, 240));
        txtErroCpfnj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroCpfnj.setText("jLabel1");

        txtErroPlaca.setForeground(new java.awt.Color(240, 240, 240));
        txtErroPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroPlaca.setText("jLabel2");

        txtErroSituacaoVeiculo.setForeground(new java.awt.Color(240, 240, 240));
        txtErroSituacaoVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroSituacaoVeiculo.setText("jLabel3");

        txtErroAtendente.setForeground(new java.awt.Color(240, 240, 240));
        txtErroAtendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroAtendente.setText("jLabel4");

        txtErroDataEntrada.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDataEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroDataEntrada.setText("jLabel5");

        txtErroPrevisaoSaida.setForeground(new java.awt.Color(240, 240, 240));
        txtErroPrevisaoSaida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroPrevisaoSaida.setText("jLabel6");

        txtErroDataSaida.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDataSaida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroDataSaida.setText("jLabel7");

        painelDeRolagemPecasEServicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 0)), "Orçamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        painelDeRolagemPecasEServicos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        painelAddItemOrcamento.setBackground(new java.awt.Color(220, 220, 220));
        painelAddItemOrcamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Adicionar um novo item ao orçamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnLimparCamposOrcamento.setBackground(new java.awt.Color(204, 0, 0));
        btnLimparCamposOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCamposOrcamento.setText("Limpar campos");
        btnLimparCamposOrcamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnLimparCamposOrcamento.setContentAreaFilled(false);
        btnLimparCamposOrcamento.setFocusPainted(false);
        btnLimparCamposOrcamento.setOpaque(true);
        btnLimparCamposOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparCampos(evt);
            }
        });

        btnAdicionarOrcamento.setBackground(new java.awt.Color(204, 0, 0));
        btnAdicionarOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionarOrcamento.setText("Adicionar");
        btnAdicionarOrcamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnAdicionarOrcamento.setContentAreaFilled(false);
        btnAdicionarOrcamento.setFocusPainted(false);
        btnAdicionarOrcamento.setOpaque(true);
        btnAdicionarOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarOrcamento(evt);
            }
        });

        titlePrecoPecas1.setText("Preço da peça:");

        titlePrecoServicos1.setText("Preço do serviço:");

        campoPrecoPecasAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoPrecoPecasAdd.setName("pecas"); // NOI18N
        campoPrecoPecasAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                habilitarCampos(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaPrecoPeca(evt);
            }
        });

        campoPrecoServicosAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoPrecoServicosAdd.setName("servicos"); // NOI18N
        campoPrecoServicosAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                habilitarCampos(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaPrecoServico(evt);
            }
        });

        titleDescricaoPrecoPecas1.setText("Descrição da peça:");
        titleDescricaoPrecoPecas1.setToolTipText("");

        titleDescricaoPrecoServicos1.setText("Descrição do serviço:");

        campoDescricaoServicosAdd.setBackground(new java.awt.Color(240, 240, 240));
        campoDescricaoServicosAdd.setText("<-- Insira um valor ao lado");
        campoDescricaoServicosAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoDescricaoServicosAdd.setEnabled(false);
        campoDescricaoServicosAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaDescricaoServico(evt);
            }
        });

        campoDescricaoPecasAdd.setBackground(new java.awt.Color(240, 240, 240));
        campoDescricaoPecasAdd.setText("<-- Insira um valor ao lado");
        campoDescricaoPecasAdd.setToolTipText("");
        campoDescricaoPecasAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoDescricaoPecasAdd.setEnabled(false);
        campoDescricaoPecasAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaDescricaoPeca(evt);
            }
        });

        cifrao2.setText("R$");

        cifrao3.setText("R$");

        javax.swing.GroupLayout painelAddItemOrcamentoLayout = new javax.swing.GroupLayout(painelAddItemOrcamento);
        painelAddItemOrcamento.setLayout(painelAddItemOrcamentoLayout);
        painelAddItemOrcamentoLayout.setHorizontalGroup(
            painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAddItemOrcamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelAddItemOrcamentoLayout.createSequentialGroup()
                        .addComponent(titlePrecoPecas1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cifrao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecoPecasAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelAddItemOrcamentoLayout.createSequentialGroup()
                        .addComponent(titlePrecoServicos1)
                        .addGap(10, 10, 10)
                        .addComponent(cifrao3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecoServicosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleDescricaoPrecoServicos1)
                    .addComponent(titleDescricaoPrecoPecas1))
                .addGap(18, 18, 18)
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDescricaoPecasAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDescricaoServicosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCamposOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        painelAddItemOrcamentoLayout.setVerticalGroup(
            painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAddItemOrcamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePrecoPecas1)
                    .addComponent(campoPrecoPecasAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleDescricaoPrecoPecas1)
                    .addComponent(campoDescricaoPecasAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifrao2)
                    .addComponent(btnAdicionarOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(painelAddItemOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePrecoServicos1)
                    .addComponent(campoPrecoServicosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleDescricaoPrecoServicos1)
                    .addComponent(campoDescricaoServicosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifrao3)
                    .addComponent(btnLimparCamposOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtErroAddOrcamento.setForeground(new java.awt.Color(240, 240, 240));
        txtErroAddOrcamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroAddOrcamento.setText("jLabel4");

        painelOrcamentoPecasEServicos.setBackground(new java.awt.Color(220, 220, 220));
        painelOrcamentoPecasEServicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Peças e serviços", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout painelOrcamentoPecasEServicosLayout = new javax.swing.GroupLayout(painelOrcamentoPecasEServicos);
        painelOrcamentoPecasEServicos.setLayout(painelOrcamentoPecasEServicosLayout);
        painelOrcamentoPecasEServicosLayout.setHorizontalGroup(
            painelOrcamentoPecasEServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1223, Short.MAX_VALUE)
        );
        painelOrcamentoPecasEServicosLayout.setVerticalGroup(
            painelOrcamentoPecasEServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelParaManterOScrollLayout = new javax.swing.GroupLayout(painelParaManterOScroll);
        painelParaManterOScroll.setLayout(painelParaManterOScrollLayout);
        painelParaManterOScrollLayout.setHorizontalGroup(
            painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParaManterOScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtErroAddOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelOrcamentoPecasEServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAddItemOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelParaManterOScrollLayout.setVerticalGroup(
            painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParaManterOScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelOrcamentoPecasEServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAddItemOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtErroAddOrcamento)
                .addContainerGap())
        );

        painelDeRolagemPecasEServicos.setViewportView(painelParaManterOScroll);

        btnIrParaOCliente.setBackground(new java.awt.Color(204, 0, 0));
        btnIrParaOCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnIrParaOCliente.setText("Ir ao cliente");
        btnIrParaOCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrParaOCliente.setContentAreaFilled(false);
        btnIrParaOCliente.setFocusPainted(false);
        btnIrParaOCliente.setOpaque(true);
        btnIrParaOCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irAoCliente(evt);
            }
        });

        btnIrParaOVeiculo.setBackground(new java.awt.Color(204, 0, 0));
        btnIrParaOVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnIrParaOVeiculo.setText("Ir ao veículo");
        btnIrParaOVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrParaOVeiculo.setContentAreaFilled(false);
        btnIrParaOVeiculo.setFocusPainted(false);
        btnIrParaOVeiculo.setOpaque(true);
        btnIrParaOVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irAoVeiculo(evt);
            }
        });

        btnEditarOs.setBackground(new java.awt.Color(204, 0, 0));
        btnEditarOs.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarOs.setText("Editar OS");
        btnEditarOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnEditarOs.setContentAreaFilled(false);
        btnEditarOs.setFocusPainted(false);
        btnEditarOs.setOpaque(true);
        btnEditarOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarOs(evt);
            }
        });

        btnConcluirOs.setBackground(new java.awt.Color(204, 0, 0));
        btnConcluirOs.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluirOs.setText("Concluir OS");
        btnConcluirOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnConcluirOs.setContentAreaFilled(false);
        btnConcluirOs.setFocusPainted(false);
        btnConcluirOs.setOpaque(true);
        btnConcluirOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                concluirOs(evt);
            }
        });

        txtConclusaoOs.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtConclusaoOs.setForeground(new java.awt.Color(240, 240, 240));
        txtConclusaoOs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtConclusaoOs.setText("Ordem de serviço já concluída");

        javax.swing.GroupLayout painelOsLayout = new javax.swing.GroupLayout(painelOs);
        painelOs.setLayout(painelOsLayout);
        painelOsLayout.setHorizontalGroup(
            painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addComponent(titleCpfnj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCpfnj))
                    .addComponent(txtErroAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addComponent(titlePlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtErroCpfnj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErroPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleSituacaoVeiculo)
                            .addComponent(titleAtendente))
                        .addGap(25, 25, 25)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSituacaoVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(campoAtendente)))
                    .addComponent(txtErroSituacaoVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtErroDataEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelOsLayout.createSequentialGroup()
                            .addComponent(titleDataEntrada)
                            .addGap(39, 39, 39)
                            .addComponent(campoDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelOsLayout.createSequentialGroup()
                            .addComponent(titleDataSaida)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelOsLayout.createSequentialGroup()
                            .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(painelOsLayout.createSequentialGroup()
                                    .addComponent(titlePrevisaoSaida)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoPrevisaoSaida))
                                .addComponent(txtErroPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)))
                    .addComponent(txtErroDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtConclusaoOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDeRolagemPecasEServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addComponent(btnIrParaOCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIrParaOVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConcluirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelOsLayout.setVerticalGroup(
            painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOsLayout.createSequentialGroup()
                .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleCpfnj)
                            .addComponent(campoCpfnj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleDataEntrada)
                            .addComponent(campoDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtErroDataEntrada)
                        .addGap(18, 18, 18)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titlePrevisaoSaida)
                            .addComponent(campoPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtErroPrevisaoSaida)
                        .addGap(18, 18, 18)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleDataSaida)
                            .addComponent(campoDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtErroDataSaida))
                    .addGroup(painelOsLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtErroCpfnj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titlePlaca)
                            .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtErroPlaca)
                        .addGap(16, 16, 16)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleSituacaoVeiculo)
                            .addComponent(campoSituacaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErroSituacaoVeiculo)
                        .addGap(18, 18, 18)
                        .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleAtendente)
                            .addComponent(campoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErroAtendente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDeRolagemPecasEServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConclusaoOs, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConcluirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIrParaOCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIrParaOVeiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        painelDeRolagem.setViewportView(painelOs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void irAoVeiculo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irAoVeiculo
        btnClicado(evt);
        VeiculoDAO vdao = new VeiculoDAO();
        ParecerDAO pdao = new ParecerDAO();
        Veiculo v = new Veiculo();
        List<ParecerTecnico> prcs = new ArrayList<>();
        v = vdao.consultarVeiculo("'"+os.getOsVeiculoPlaca()+"'",os.getOsNumero());
        prcs = pdao.consultarPareceres(os.getOsNumero());
        consulta_veiculo consultaTela = new consulta_veiculo(v,prcs);
        consultaTela.setLocation(this.getX(), this.getY());
        consultaTela.setExtendedState(this.getExtendedState());
        consultaTela.setVisible(true);
    }//GEN-LAST:event_irAoVeiculo

    private void irAoCliente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irAoCliente
        btnClicado(evt);
        ClienteDAO cdao = new ClienteDAO();
        ContatoDAO cttdao = new ContatoDAO();
        Cliente c = new Cliente();
        Contato ctt= new Contato();
        c = cdao.consultarCliente(os.getOsCpfnj());
        ctt = cttdao.consultarContato(os.getOsCpfnj());
        consulta_cliente consultaTela = new consulta_cliente(c,ctt);
        consultaTela.setLocation(this.getX(), this.getY());
        consultaTela.setExtendedState(this.getExtendedState());
        consultaTela.setVisible(true);      
    }//GEN-LAST:event_irAoCliente

    private void editarOs(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarOs
        if (campoDataSaida.getText().equals("")){
            btnClicado(evt);
            contadorEditar++;
            if (contadorEditar == 1){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja habilitar os campos para a edição?","Aviso!",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    habilitarCampos();
                } else {
                    contadorEditar--;
                }
            }
            else if (contadorEditar == 2){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja editar os dados dessa ordem de serviço?","Aviso!",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    String numeroOs = os.getOsNumero();
                    String previsaoSaida = fs.retirarFormatacaoData(campoPrevisaoSaida.getText());
                    String situacaoVeiculo = campoSituacaoVeiculo.getText();
                    OsDAO osdao = new OsDAO();
                    osdao.atualizarOs(numeroOs,previsaoSaida,situacaoVeiculo);   
                    atualizarTela();
                } else {
                    contadorEditar--;
                }           
            } 
        }       
    }//GEN-LAST:event_editarOs

    private void concluirOs(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_concluirOs
        if (campoDataSaida.getText().equals("")){
            btnClicado(evt);
            OsDAO osdao = new OsDAO();
            osdao.concluirOs(os.getOsNumero());
            atualizarTela();
        }
    }//GEN-LAST:event_concluirOs
    
    //<editor-fold defaultstate="collapsed" desc="métodos teclados">
    private void tecladaDescricaoPeca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDescricaoPeca
        if (vs.nome30(evt, campoDescricaoPecasAdd.getText()) == ""){
            txtErroAddOrcamento.setForeground(new Color(240,240,240));
        } else {
            String txt = vs.nome30(evt, campoDescricaoPecasAdd.getText());
            txtErroAddOrcamento.setText(txt);
            if (txt.endsWith(".")){
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
            } else {
                txtErroAddOrcamento.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaDescricaoPeca

    private void tecladaDescricaoServico(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDescricaoServico
        if (vs.nome30(evt, campoDescricaoServicosAdd.getText()) == ""){
            txtErroAddOrcamento.setForeground(new Color(240,240,240));
        } else {
            String txt = vs.nome30(evt, campoDescricaoServicosAdd.getText());
            txtErroAddOrcamento.setText(txt);
            if (txt.endsWith(".")){
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
            } else {
                txtErroAddOrcamento.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaDescricaoServico

    private void tecladaPrecoServico(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrecoServico
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            campoPrecoServicosAdd.setText(fs.apagar(campoPrecoServicosAdd.getText(), evt.getComponent().getName()));
        }
        String txt = vs.orcamento(evt, campoPrecoServicosAdd.getText());
        if ("".equals(txt)){
            if (campoPrecoServicosAdd.getText().length() >= 10){
                evt.consume();
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
                txtErroAddOrcamento.setText("Tamanho máximo atingido.");
            } else {
                txtErroAddOrcamento.setForeground(new Color(240,240,240));
                String txtF = fs.dinheiro(evt,campoPrecoServicosAdd.getText());
                campoPrecoServicosAdd.setText(txtF);
            }
        }
        else{
            txtErroAddOrcamento.setText(txt);
            if (txt.endsWith("números.")){
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
            }
        }
    }//GEN-LAST:event_tecladaPrecoServico
    //</editor-fold>
    
    private void habilitarCampos(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilitarCampos
        if (evt.getComponent().getName().equals("pecas")){
            if (campoPrecoPecasAdd.getText().length() != 0){
                campoDescricaoPecasAdd.setEnabled(true);
                campoDescricaoPecasAdd.setBackground(Color.white);
                campoDescricaoPecasAdd.setText("");
            } else {
                campoDescricaoPecasAdd.setEnabled(false);
                campoDescricaoPecasAdd.setText("<-- Insira um valor ao lado");
            }
        } else {
            if (campoPrecoServicosAdd.getText().length() != 0){
                campoDescricaoServicosAdd.setEnabled(true);
                campoDescricaoServicosAdd.setBackground(Color.white);
                campoDescricaoServicosAdd.setText("");
            } else {
                campoDescricaoServicosAdd.setEnabled(false);
                campoDescricaoServicosAdd.setText("<-- Insira um valor ao lado");
            }
        }
    }//GEN-LAST:event_habilitarCampos

    private void tecladaPrecoPeca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrecoPeca
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            campoPrecoPecasAdd.setText(fs.apagar(campoPrecoPecasAdd.getText(), evt.getComponent().getName()));
        }
        String txt = vs.orcamento(evt, campoPrecoPecasAdd.getText());
        if ("".equals(txt)){
            if (campoPrecoPecasAdd.getText().length() >= 10){
                evt.consume();
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
                txtErroAddOrcamento.setText("Tamanho máximo atingido.");
            } else {
                txtErroAddOrcamento.setForeground(new Color(240,240,240));
                String txtF = fs.dinheiro(evt,campoPrecoPecasAdd.getText());
                campoPrecoPecasAdd.setText(txtF);
            }
        }
        else{
            txtErroAddOrcamento.setText(txt);
            if (txt.endsWith("números.")){
                txtErroAddOrcamento.setForeground(new Color(255,0,0));
            }
        }
    }//GEN-LAST:event_tecladaPrecoPeca

    private void adicionarOrcamento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarOrcamento
        if (campoDataSaida.getText().equals("")){
            btnClicado(evt);
            Orcamento orc = new Orcamento();
            if (campoDataSaida.getText().equals("")){
                if (camposVazios()){
                txtErroAddOrcamento.setForeground(Color.RED);
                txtErroAddOrcamento.setText("Há um campo vazio.");
                }else{
                    orc.setOrcamento_descricao_pecas(campoDescricaoPecasAdd.getText());
                    orc.setOrcamento_descricao_servicos(campoDescricaoServicosAdd.getText());
                    orc.setOrcamento_preco_pecas(fs.retirarFormatacaoDinheiro(campoPrecoPecasAdd.getText()));
                    orc.setOrcamento_preco_servicos(fs.retirarFormatacaoDinheiro(campoPrecoServicosAdd.getText()));
                    OrcamentoDAO orcdao = new OrcamentoDAO();
                    orcdao.cadastrarOrcamento(orc,os);
                    atualizarTela();
                }
            } else {
                //nadinha
            }
        }
    }//GEN-LAST:event_adicionarOrcamento

    private void limparCampos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparCampos
        btnClicado(evt);
        limparCampos();
    }//GEN-LAST:event_limparCampos
    
    //<editor-fold defaultstate="collapsed" desc="métodos teclados">
    private void tecladaDataSaida(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDataSaida
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            campoDataSaida.setText(fs.apagar(campoDataSaida.getText(), evt.getComponent().getName()));
        }
        if (vs.data(evt, campoDataSaida.getText()) == ""){
            txtErroDataSaida.setForeground(new Color(240,240,240));
        }
        else if (vs.data(evt, campoDataSaida.getText()).endsWith("números.")){
            campoDataSaida.setText(campoDataSaida.getText().substring(0, campoDataSaida.getText().length()-1));
        }
        else{
            String txt = vs.data(evt, campoDataSaida.getText());
            txtErroDataSaida.setText(txt);
            if (txt.endsWith(".")){
                txtErroDataSaida.setForeground(new Color(255,0,0));
            } else {
                txtErroDataSaida.setForeground(new Color(0, 160, 40));
            }
        }
        if (campoDataSaida.getText().length() > 10){
            int calc = campoDataSaida.getText().length() - 10;
            campoDataSaida.setText(campoDataSaida.getText().substring(0,campoDataSaida.getText().length()-calc));
        }
        String txt = fs.data(campoDataSaida.getText());
        campoDataSaida.setText(txt);
    }//GEN-LAST:event_tecladaDataSaida

    private void tecladaPrevisaoSaida(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrevisaoSaida
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            campoPrevisaoSaida.setText(fs.apagar(campoPrevisaoSaida.getText(), evt.getComponent().getName()));
        }
        if (vs.data(evt, campoPrevisaoSaida.getText()) == ""){
            txtErroPrevisaoSaida.setForeground(new Color(240,240,240));
        }
        else if (vs.data(evt, campoPrevisaoSaida.getText()).endsWith("números.")){
            campoPrevisaoSaida.setText(campoPrevisaoSaida.getText().substring(0, campoPrevisaoSaida.getText().length()-1));
        }
        else{
            String txt = vs.data(evt, campoPrevisaoSaida.getText());
            txtErroPrevisaoSaida.setText(txt);
            if (txt.endsWith(".")){
                txtErroPrevisaoSaida.setForeground(new Color(255,0,0));
            } else {
                txtErroPrevisaoSaida.setForeground(new Color(0, 160, 40));
            }
        }
        if (campoPrevisaoSaida.getText().length() > 10){
            int calc = campoPrevisaoSaida.getText().length() - 10;
            campoPrevisaoSaida.setText(campoPrevisaoSaida.getText().substring(0,campoPrevisaoSaida.getText().length()-calc));
        }
        String txt = fs.data(campoPrevisaoSaida.getText());
        campoPrevisaoSaida.setText(txt);
    }//GEN-LAST:event_tecladaPrevisaoSaida

    private void tecladaSituacao(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaSituacao
        if (vs.nome30(evt, campoSituacaoVeiculo.getText()) == ""){
            txtErroSituacaoVeiculo.setForeground(new Color(240,240,240));
        } else {
            String txt = vs.nome30(evt, campoSituacaoVeiculo.getText());
            txtErroSituacaoVeiculo.setText(txt);
            if (txt.endsWith(".")){
                txtErroSituacaoVeiculo.setForeground(new Color(255,0,0));
            } else {
                txtErroSituacaoVeiculo.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaSituacao
    //</editor-fold>
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consulta_os.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulta_os.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulta_os.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulta_os.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarOrcamento;
    private javax.swing.JButton btnConcluirOs;
    private javax.swing.JButton btnEditarOs;
    private javax.swing.JButton btnIrParaOCliente;
    private javax.swing.JButton btnIrParaOVeiculo;
    private javax.swing.JButton btnLimparCamposOrcamento;
    private javax.swing.JTextField campoAtendente;
    private javax.swing.JTextField campoCpfnj;
    private javax.swing.JTextField campoDataEntrada;
    private javax.swing.JTextField campoDataSaida;
    private javax.swing.JTextField campoDescricaoPecasAdd;
    private javax.swing.JTextField campoDescricaoServicosAdd;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JTextField campoPrecoPecasAdd;
    private javax.swing.JTextField campoPrecoServicosAdd;
    private javax.swing.JTextField campoPrevisaoSaida;
    private javax.swing.JTextField campoSituacaoVeiculo;
    private javax.swing.JLabel cifrao2;
    private javax.swing.JLabel cifrao3;
    private javax.swing.JPanel painelAddItemOrcamento;
    private javax.swing.JScrollPane painelDeRolagem;
    private javax.swing.JScrollPane painelDeRolagemPecasEServicos;
    private javax.swing.JPanel painelOrcamentoPecasEServicos;
    private javax.swing.JPanel painelOs;
    private javax.swing.JPanel painelParaManterOScroll;
    private javax.swing.JLabel titleAtendente;
    private javax.swing.JLabel titleCpfnj;
    private javax.swing.JLabel titleDataEntrada;
    private javax.swing.JLabel titleDataSaida;
    private javax.swing.JLabel titleDescricaoPrecoPecas1;
    private javax.swing.JLabel titleDescricaoPrecoServicos1;
    private javax.swing.JLabel titlePlaca;
    private javax.swing.JLabel titlePrecoPecas1;
    private javax.swing.JLabel titlePrecoServicos1;
    private javax.swing.JLabel titlePrevisaoSaida;
    private javax.swing.JLabel titleSituacaoVeiculo;
    private javax.swing.JLabel txtConclusaoOs;
    private javax.swing.JLabel txtErroAddOrcamento;
    private javax.swing.JLabel txtErroAtendente;
    private javax.swing.JLabel txtErroCpfnj;
    private javax.swing.JLabel txtErroDataEntrada;
    private javax.swing.JLabel txtErroDataSaida;
    private javax.swing.JLabel txtErroPlaca;
    private javax.swing.JLabel txtErroPrevisaoSaida;
    private javax.swing.JLabel txtErroSituacaoVeiculo;
    // End of variables declaration//GEN-END:variables

    private void btnClicado(java.awt.event.MouseEvent evt){
        /*
            MÉTODO RESPONSÁVEL POR MUDAR A COR DE FUNDO DO BOTAO QUANDO FOR CLICADO
        */
        //muda a cor de fundo
        evt.getComponent().setBackground(new Color(100,0,0));
        //apos algum tempo, retorna a cor de fundo que tava
        new Timer().schedule(
            new TimerTask(){
                @Override
                public void run(){
                    evt.getComponent().setBackground(new Color(204,0,0));
                }
        }, 50);
    }
    
    private void limparCampos(){
        campoDescricaoPecasAdd.setText("<-- Insira um valor ao lado");
        campoDescricaoPecasAdd.setEnabled(false);
        campoDescricaoServicosAdd.setText("<-- Insira um valor ao lado");
        campoDescricaoServicosAdd.setEnabled(false);
        campoPrecoPecasAdd.setText("");
        campoPrecoServicosAdd.setText("");
    }
    
    private boolean camposVazios(){
        boolean vazio = false; 
        if (campoPrecoPecasAdd.getText().equals("") && campoPrecoServicosAdd.getText().equals("")){
            vazio = true;
        } else if (campoPrecoPecasAdd.getText().equals("")){
            if (campoDescricaoServicosAdd.getText().equals("")){
                vazio = true;
            }
        } else if (campoPrecoServicosAdd.getText().equals("")){
            if (campoDescricaoPecasAdd.getText().equals("")){
                vazio = true;
            } 
        }else if (!campoPrecoPecasAdd.getText().equals("") && !campoPrecoServicosAdd.getText().equals("")
                 && !campoDescricaoServicosAdd.getText().equals("") && !campoDescricaoPecasAdd.getText().equals("")){
            vazio = false;
        } else {
            vazio = true;
        }
        return vazio;
    }
    
    private void excluirItemOrcamento(java.awt.event.MouseEvent evt) { 
        if (campoDataSaida.getText().equals("")){
            OrcamentoDAO orcdao = new OrcamentoDAO();
            orcdao.excluirItemOrcamento(evt.getComponent().getName());
            atualizarTela();
        }
    }
    
    private void habilitarCampos(){
        campoPrevisaoSaida.setEnabled(true);
        campoPrevisaoSaida.setBackground(Color.white);
        campoPrevisaoSaida.setForeground(Color.black);
        campoPrevisaoSaida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoSituacaoVeiculo.setEnabled(true);
        campoSituacaoVeiculo.setBackground(Color.white);
        campoSituacaoVeiculo.setForeground(Color.black);
        campoSituacaoVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }
    
    private void atualizarTela(){
        this.setVisible(false);
        List<Orcamento> orcs = new ArrayList<>();
        List<OS> OSs = new ArrayList<>();
        OrcamentoDAO orcDao = new OrcamentoDAO();
        OsDAO osDao = new OsDAO();                       
        OSs = osDao.consultaOs("os_numero", os.getOsNumero());
        orcs = orcDao.consultarOrcamento(os.getOsNumero());
        consulta_os novaTela = new consulta_os(OSs.get(0),orcs);
        //por algum motivo, o método de mudar de tela ta dando erro. Tentar arrumar depois
        novaTela.setBounds(this.getX(), this.getY(),this.getWidth(),this.getHeight());
        novaTela.setExtendedState(this.getExtendedState());
        this.dispose();
        novaTela.setVisible(true);
    } 
}

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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pif.desktop.Classes.ParecerTecnico;
import pif.desktop.Classes.Veiculo;

/**
 *
 * @author arthu
 */
public class consulta_veiculo extends javax.swing.JFrame {
    
    int contadorEditar;
    Image icon;
    /**
     * Creates new form consulta_veiculo
     */
    public consulta_veiculo(Veiculo v, List<ParecerTecnico> prcs) {
        initComponents();
        try {
            icon = ImageIO.read(new File("src/resources/icon.png"));           
        } catch (IOException e) {
            e.printStackTrace();
        } 
        painelVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Veículo de placa " + v.getVeiculoPlaca(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        campoAcessorios.setText(v.getVeiculoAcessorios());
        campoAno.setText(v.getVeiculoAno());
        campoCor.setText(v.getVeiculoCor());
        campoDefeito.setText(v.getVeiculoDefeitoCliente());
        campoFabricante.setText(v.getVeiculoFabricante());
        campoModelo.setText(v.getVeiculoModelo());
        campoObservacoes.setText(v.getVeiculoObservacoes());
        campoSituacao.setText(v.getVeiculoSituacao());
        campoTipo.setText(v.getVeiculoTipo());
        campoNomeTecnico.setText(prcs.get(1).getColabNomeTecnico());
        areaDescricaoParecer.setText(prcs.get(1).getParecerDescricao());
        campoDataParecer.setText(prcs.get(1).getParecerData());
        setIconImage(icon);     
        setTitle("Veículo de placa "+v.getVeiculoPlaca());  
        painelRolagemParecerTecnico.getVerticalScrollBar().setUnitIncrement(8); 
        painelPareceresTecnicos.setLayout(new GridLayout(0,1));
        JPanel jFilho;
        JLabel titleNomeColaborador, txtNomeColaborador;
        JTextArea areaDescricaoParecer;
        JButton btnExcluirParecer;
        for (int i=0;i<prcs.size();i++){
            //<editor-fold defaultstate="collapsed" desc="Painel">
            //<editor-fold defaultstate="collapsed" desc="Declaração de variáveis e atribuição de valores">
            ParecerTecnico prc;
            prc = prcs.get(i);
            jFilho = new JPanel();
            jFilho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 190, 190)));    
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
            painelPareceresTecnicos.add(jFilho);
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

        painelVeiculo = new javax.swing.JPanel();
        painelInformacoesVeiculo = new javax.swing.JPanel();
        titleTipo = new javax.swing.JLabel();
        campoTipo = new javax.swing.JTextField();
        campoFabricante = new javax.swing.JTextField();
        titleFabricante = new javax.swing.JLabel();
        titleModelo = new javax.swing.JLabel();
        campoModelo = new javax.swing.JTextField();
        titleAno = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        titleAcessorios = new javax.swing.JLabel();
        campoAcessorios = new javax.swing.JTextField();
        titleObservacoes = new javax.swing.JLabel();
        campoObservacoes = new javax.swing.JTextField();
        titleDefeito = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDefeito = new javax.swing.JTextArea();
        titleSituacao = new javax.swing.JLabel();
        campoSituacao = new javax.swing.JTextField();
        btnIrCliente = new javax.swing.JButton();
        btnIrOS = new javax.swing.JButton();
        btnEditarVeiculo = new javax.swing.JButton();
        txtErroAno = new javax.swing.JLabel();
        txtErroAcessorios = new javax.swing.JLabel();
        txtErroDefeito = new javax.swing.JLabel();
        txtErroObservacoes = new javax.swing.JLabel();
        titleCor = new javax.swing.JLabel();
        campoCor = new javax.swing.JTextField();
        txtErroSituacao = new javax.swing.JLabel();
        painelRolagemParecerTecnico = new javax.swing.JScrollPane();
        painelViewRolagem = new javax.swing.JPanel();
        painelAddParecer = new javax.swing.JPanel();
        btnLimparCampoParecer = new javax.swing.JButton();
        btnAdicionarParecer = new javax.swing.JButton();
        titleDescricaoParecerAdd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescricaoParecerAdd = new javax.swing.JTextArea();
        txtErroAddParecer = new javax.swing.JLabel();
        painelPareceresTecnicos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        titleDescricaoParecer = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescricaoParecer = new javax.swing.JTextArea();
        titleNomeTecnico = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        titleDataParecer = new javax.swing.JLabel();
        campoDataParecer = new javax.swing.JLabel();
        campoNomeTecnico = new javax.swing.JLabel();
        btnExcluirParecerTecnico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);

        titleTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleTipo.setText("Tipo do veículo:");

        campoTipo.setBackground(new java.awt.Color(240, 240, 240));
        campoTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTipo.setBorder(null);

        campoFabricante.setBackground(new java.awt.Color(240, 240, 240));
        campoFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoFabricante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoFabricante.setBorder(null);

        titleFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleFabricante.setText("Fabricante do veículo:");

        titleModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleModelo.setText("Modelo do veículo:");

        campoModelo.setBackground(new java.awt.Color(240, 240, 240));
        campoModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoModelo.setBorder(null);

        titleAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleAno.setText("Ano do veículo:");

        campoAno.setBackground(new java.awt.Color(240, 240, 240));
        campoAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoAno.setBorder(null);

        titleAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleAcessorios.setText("Acessórios do veículo:");

        campoAcessorios.setBackground(new java.awt.Color(240, 240, 240));
        campoAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoAcessorios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoAcessorios.setBorder(null);

        titleObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleObservacoes.setText("Observações do veículo:");

        campoObservacoes.setBackground(new java.awt.Color(240, 240, 240));
        campoObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoObservacoes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoObservacoes.setBorder(null);

        titleDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDefeito.setText("Defeito descrito pelo cliente");

        campoDefeito.setBackground(new java.awt.Color(240, 240, 240));
        campoDefeito.setColumns(20);
        campoDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDefeito.setRows(5);
        campoDefeito.setBorder(null);
        campoDefeito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoDefeito.setEnabled(false);
        jScrollPane1.setViewportView(campoDefeito);

        titleSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleSituacao.setText("Situação do veículo:");

        campoSituacao.setBackground(new java.awt.Color(240, 240, 240));
        campoSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSituacao.setBorder(null);

        btnIrCliente.setBackground(new java.awt.Color(204, 0, 0));
        btnIrCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnIrCliente.setText("Ir ao cliente");
        btnIrCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrCliente.setContentAreaFilled(false);
        btnIrCliente.setFocusPainted(false);
        btnIrCliente.setOpaque(true);

        btnIrOS.setBackground(new java.awt.Color(204, 0, 0));
        btnIrOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrOS.setText("Ir à ordem de serviço");
        btnIrOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrOS.setContentAreaFilled(false);
        btnIrOS.setFocusPainted(false);
        btnIrOS.setOpaque(true);

        btnEditarVeiculo.setBackground(new java.awt.Color(204, 0, 0));
        btnEditarVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarVeiculo.setText("Editar veículo");
        btnEditarVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnEditarVeiculo.setContentAreaFilled(false);
        btnEditarVeiculo.setFocusPainted(false);
        btnEditarVeiculo.setOpaque(true);
        btnEditarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarVeiculo(evt);
            }
        });

        txtErroAno.setForeground(new java.awt.Color(240, 240, 240));
        txtErroAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroAno.setText("jLabel1");

        txtErroAcessorios.setForeground(new java.awt.Color(240, 240, 240));
        txtErroAcessorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroAcessorios.setText("jLabel1");

        txtErroDefeito.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDefeito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroDefeito.setText("jLabel1");

        txtErroObservacoes.setForeground(new java.awt.Color(240, 240, 240));
        txtErroObservacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroObservacoes.setText("jLabel1");

        titleCor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleCor.setText("Cor do veículo:");

        campoCor.setBackground(new java.awt.Color(240, 240, 240));
        campoCor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoCor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCor.setBorder(null);

        txtErroSituacao.setForeground(new java.awt.Color(240, 240, 240));
        txtErroSituacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroSituacao.setText("jLabel1");

        javax.swing.GroupLayout painelInformacoesVeiculoLayout = new javax.swing.GroupLayout(painelInformacoesVeiculo);
        painelInformacoesVeiculo.setLayout(painelInformacoesVeiculoLayout);
        painelInformacoesVeiculoLayout.setHorizontalGroup(
            painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInformacoesVeiculoLayout.createSequentialGroup()
                        .addComponent(btnIrCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIrOS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelInformacoesVeiculoLayout.createSequentialGroup()
                        .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleObservacoes)
                            .addComponent(titleAcessorios)
                            .addComponent(titleAno)
                            .addComponent(titleModelo)
                            .addComponent(titleFabricante)
                            .addComponent(titleTipo)
                            .addComponent(titleDefeito)
                            .addComponent(titleSituacao)
                            .addComponent(titleCor))
                        .addGap(18, 18, 18)
                        .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErroSituacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoCor)
                            .addComponent(txtErroObservacoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtErroAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoSituacao)
                            .addComponent(jScrollPane1)
                            .addComponent(campoTipo)
                            .addComponent(campoFabricante)
                            .addComponent(campoModelo)
                            .addComponent(campoAno)
                            .addComponent(campoAcessorios)
                            .addComponent(campoObservacoes)
                            .addComponent(txtErroAcessorios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtErroDefeito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelInformacoesVeiculoLayout.setVerticalGroup(
            painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleCor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErroAno)
                .addGap(15, 15, 15)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(txtErroAcessorios)
                .addGap(15, 15, 15)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErroObservacoes)
                .addGap(18, 18, 18)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelInformacoesVeiculoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(titleDefeito)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErroDefeito)
                .addGap(15, 15, 15)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(txtErroSituacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelInformacoesVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelRolagemParecerTecnico.setBorder(null);

        painelViewRolagem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 0)), "Parecer técnico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        painelViewRolagem.setPreferredSize(new java.awt.Dimension(650, 316));

        painelAddParecer.setBackground(new java.awt.Color(220, 220, 220));
        painelAddParecer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Adicionar um novo parecer técnico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnLimparCampoParecer.setBackground(new java.awt.Color(204, 0, 0));
        btnLimparCampoParecer.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampoParecer.setText("Limpar campo");
        btnLimparCampoParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnLimparCampoParecer.setContentAreaFilled(false);
        btnLimparCampoParecer.setFocusPainted(false);
        btnLimparCampoParecer.setOpaque(true);
        btnLimparCampoParecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparCamposParecer(evt);
            }
        });

        btnAdicionarParecer.setBackground(new java.awt.Color(204, 0, 0));
        btnAdicionarParecer.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionarParecer.setText("Adicionar");
        btnAdicionarParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnAdicionarParecer.setContentAreaFilled(false);
        btnAdicionarParecer.setFocusPainted(false);
        btnAdicionarParecer.setOpaque(true);
        btnAdicionarParecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarParecer(evt);
            }
        });

        titleDescricaoParecerAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDescricaoParecerAdd.setText("Descrição do parecer:");
        titleDescricaoParecerAdd.setToolTipText("");

        areaDescricaoParecerAdd.setColumns(20);
        areaDescricaoParecerAdd.setRows(5);
        jScrollPane2.setViewportView(areaDescricaoParecerAdd);

        txtErroAddParecer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtErroAddParecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroAddParecer.setText("jLabel1");

        javax.swing.GroupLayout painelAddParecerLayout = new javax.swing.GroupLayout(painelAddParecer);
        painelAddParecer.setLayout(painelAddParecerLayout);
        painelAddParecerLayout.setHorizontalGroup(
            painelAddParecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAddParecerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDescricaoParecerAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(painelAddParecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCampoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAddParecerLayout.createSequentialGroup()
                .addComponent(txtErroAddParecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelAddParecerLayout.setVerticalGroup(
            painelAddParecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAddParecerLayout.createSequentialGroup()
                .addGroup(painelAddParecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAddParecerLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(titleDescricaoParecerAdd))
                    .addGroup(painelAddParecerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelAddParecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAddParecerLayout.createSequentialGroup()
                                .addComponent(btnAdicionarParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimparCampoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(txtErroAddParecer)
                .addContainerGap())
        );

        painelPareceresTecnicos.setBackground(new java.awt.Color(220, 220, 220));
        painelPareceresTecnicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pareceres técnicos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titleDescricaoParecer.setText("Descrição do parecer:");
        titleDescricaoParecer.setToolTipText("");

        areaDescricaoParecer.setBackground(new java.awt.Color(240, 240, 240));
        areaDescricaoParecer.setColumns(20);
        areaDescricaoParecer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaDescricaoParecer.setRows(5);
        areaDescricaoParecer.setBorder(null);
        areaDescricaoParecer.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        areaDescricaoParecer.setEnabled(false);
        jScrollPane3.setViewportView(areaDescricaoParecer);

        titleNomeTecnico.setText("Nome do técnico que deu o parecer:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        titleDataParecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDataParecer.setText("Data do parecer:");

        campoDataParecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        campoNomeTecnico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnExcluirParecerTecnico.setBackground(new java.awt.Color(204, 0, 0));
        btnExcluirParecerTecnico.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirParecerTecnico.setText("Excluir");
        btnExcluirParecerTecnico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnExcluirParecerTecnico.setContentAreaFilled(false);
        btnExcluirParecerTecnico.setFocusPainted(false);
        btnExcluirParecerTecnico.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleNomeTecnico)
                        .addGap(18, 18, 18)
                        .addComponent(campoNomeTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleDescricaoParecer)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleDataParecer, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(campoDataParecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirParecerTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleNomeTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(campoNomeTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExcluirParecerTecnico)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titleDataParecer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataParecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleDescricaoParecer)
                        .addGap(55, 55, 55))))
        );

        javax.swing.GroupLayout painelPareceresTecnicosLayout = new javax.swing.GroupLayout(painelPareceresTecnicos);
        painelPareceresTecnicos.setLayout(painelPareceresTecnicosLayout);
        painelPareceresTecnicosLayout.setHorizontalGroup(
            painelPareceresTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPareceresTecnicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelPareceresTecnicosLayout.setVerticalGroup(
            painelPareceresTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPareceresTecnicosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelViewRolagemLayout = new javax.swing.GroupLayout(painelViewRolagem);
        painelViewRolagem.setLayout(painelViewRolagemLayout);
        painelViewRolagemLayout.setHorizontalGroup(
            painelViewRolagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelViewRolagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelViewRolagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPareceresTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAddParecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelViewRolagemLayout.setVerticalGroup(
            painelViewRolagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelViewRolagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPareceresTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(painelAddParecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelRolagemParecerTecnico.setViewportView(painelViewRolagem);

        javax.swing.GroupLayout painelVeiculoLayout = new javax.swing.GroupLayout(painelVeiculo);
        painelVeiculo.setLayout(painelVeiculoLayout);
        painelVeiculoLayout.setHorizontalGroup(
            painelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelInformacoesVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(painelRolagemParecerTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        painelVeiculoLayout.setVerticalGroup(
            painelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRolagemParecerTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
            .addGroup(painelVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelInformacoesVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCamposParecer(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparCamposParecer
        btnClicado(evt);
        limparCampos();
    }//GEN-LAST:event_limparCamposParecer

    private void adicionarParecer(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarParecer
        
    }//GEN-LAST:event_adicionarParecer

    private void editarVeiculo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarVeiculo
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
            int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja editar os dados dessa ordem desse veículo?","Aviso!",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                //update veiculo
            } else {
                contadorEditar--;
            }           
        }  
    }//GEN-LAST:event_editarVeiculo

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
            java.util.logging.Logger.getLogger(consulta_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulta_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulta_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulta_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
    }
    
    //<editor-fold defaultstate="collapsed" desc="Coisas javax">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricaoParecer;
    private javax.swing.JTextArea areaDescricaoParecerAdd;
    private javax.swing.JButton btnAdicionarParecer;
    private javax.swing.JButton btnEditarVeiculo;
    private javax.swing.JButton btnExcluirParecerTecnico;
    private javax.swing.JButton btnIrCliente;
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnLimparCampoParecer;
    private javax.swing.JTextField campoAcessorios;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoCor;
    private javax.swing.JLabel campoDataParecer;
    private javax.swing.JTextArea campoDefeito;
    private javax.swing.JTextField campoFabricante;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JLabel campoNomeTecnico;
    private javax.swing.JTextField campoObservacoes;
    private javax.swing.JTextField campoSituacao;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel painelAddParecer;
    private javax.swing.JPanel painelInformacoesVeiculo;
    private javax.swing.JPanel painelPareceresTecnicos;
    private javax.swing.JScrollPane painelRolagemParecerTecnico;
    private javax.swing.JPanel painelVeiculo;
    private javax.swing.JPanel painelViewRolagem;
    private javax.swing.JLabel titleAcessorios;
    private javax.swing.JLabel titleAno;
    private javax.swing.JLabel titleCor;
    private javax.swing.JLabel titleDataParecer;
    private javax.swing.JLabel titleDefeito;
    private javax.swing.JLabel titleDescricaoParecer;
    private javax.swing.JLabel titleDescricaoParecerAdd;
    private javax.swing.JLabel titleFabricante;
    private javax.swing.JLabel titleModelo;
    private javax.swing.JLabel titleNomeTecnico;
    private javax.swing.JLabel titleObservacoes;
    private javax.swing.JLabel titleSituacao;
    private javax.swing.JLabel titleTipo;
    private javax.swing.JLabel txtErroAcessorios;
    private javax.swing.JLabel txtErroAddParecer;
    private javax.swing.JLabel txtErroAno;
    private javax.swing.JLabel txtErroDefeito;
    private javax.swing.JLabel txtErroObservacoes;
    private javax.swing.JLabel txtErroSituacao;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
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
        areaDescricaoParecerAdd.setText("");
    }
    
    private boolean vazioCampos(){
        boolean vazio = false;
        if ("".equals(areaDescricaoParecerAdd.getText())){
            vazio = true;
        }
        return vazio;
    }
    
    private void habilitarCampos(){
        campoAcessorios.setEnabled(true);
        campoAcessorios.setBackground(Color.white);
        campoAcessorios.setForeground(Color.black);
        campoAcessorios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoAno.setEnabled(true);
        campoAno.setBackground(Color.white);
        campoAno.setForeground(Color.black);
        campoAno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoDefeito.setEnabled(true);
        campoDefeito.setBackground(Color.white);
        campoDefeito.setForeground(Color.black);
        campoDefeito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        campoObservacoes.setEnabled(true);
        campoObservacoes.setBackground(Color.white);
        campoObservacoes.setForeground(Color.black);
        campoObservacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }
}

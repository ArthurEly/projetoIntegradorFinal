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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import pif.desktop.Classes.FormatacaoStrings;
import pif.desktop.Classes.ParecerTecnico;
import pif.desktop.Classes.USER_LOGADO;
import pif.desktop.Classes.Veiculo;
import pif.desktop.Classes.VerificacaoStrings;
import pif.desktop.DAO.OsDAO;
import pif.desktop.DAO.ParecerDAO;
import pif.desktop.DAO.VeiculoDAO;

/**
 *
 * @author arthu
 */
public class consulta_veiculo extends javax.swing.JFrame {
    
    int contadorEditar;
    Image icon;
    Veiculo vzao;
    FormatacaoStrings fs = new FormatacaoStrings();
    VerificacaoStrings vs = new VerificacaoStrings();
    
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
        vzao = v;
        painelInformacoesVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Veículo de placa " + v.getVeiculoPlaca(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        campoAcessorios.setText(v.getVeiculoAcessorios());
        campoAno.setText(v.getVeiculoAno());
        campoCor.setText(v.getVeiculoCor());
        campoDefeito.setText(v.getVeiculoDefeitoCliente());
        campoFabricante.setText(v.getVeiculoFabricante());
        campoModelo.setText(v.getVeiculoModelo());
        campoObservacoes.setText(v.getVeiculoObservacoes());
        campoSituacao.setText(v.getVeiculoSituacao());
        campoTipo.setText(v.getVeiculoTipo());
        setIconImage(icon);     
        setTitle("Veículo de placa "+v.getVeiculoPlaca());  
        painelDeRolagemPareceresTecnicos.getVerticalScrollBar().setUnitIncrement(8); 
        painelPareceresTecnicos.setLayout(new GridLayout(0,1));
        JPanel jFilho;
        JLabel titleNomeColaborador, txtNomeColaborador, titleDescricaoParecer, titleData, txtData, jLabel11;
        JTextArea areaDescricaoParecer;
        JScrollPane jsp, jsp2;
        JButton btnExcluirParecer;
        for (int i=0;i<prcs.size();i++){
            //<editor-fold defaultstate="collapsed" desc="Painel">
            //<editor-fold defaultstate="collapsed" desc="Declaração de variáveis e atribuição de valores">
            ParecerTecnico prc;
            prc = prcs.get(i);
            jFilho = new JPanel();
            
            titleNomeColaborador= new JLabel(); txtNomeColaborador= new JLabel(); titleDescricaoParecer= new JLabel(); titleData= new JLabel(); txtData= new JLabel(); jLabel11= new JLabel();
            areaDescricaoParecer = new JTextArea();
            btnExcluirParecer = new JButton();
            jsp = new JScrollPane(); jsp2 = new JScrollPane();  
            
            titleNomeColaborador.setText("Nome do técnico que deu o parecer:");          
            txtNomeColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            txtNomeColaborador.setText(prc.getColabNomeTecnico());
            
            titleData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleData.setText("Data do parecer:");            
            txtData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            txtData.setText(fs.botarData(prc.getParecerData()));               
            
            jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            titleDescricaoParecer.setText("Descrição do parecer:");
            titleDescricaoParecer.setToolTipText("");            
            areaDescricaoParecer.setBackground(new java.awt.Color(240, 240, 240));
            areaDescricaoParecer.setColumns(20);
            areaDescricaoParecer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            areaDescricaoParecer.setRows(5);
            areaDescricaoParecer.setBorder(null);
            areaDescricaoParecer.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            areaDescricaoParecer.setEnabled(false);   
            areaDescricaoParecer.setText(prc.getParecerDescricao());
            jsp.setViewportView(areaDescricaoParecer);
            
            btnExcluirParecer.setBackground(new java.awt.Color(204, 0, 0));
            btnExcluirParecer.setForeground(new java.awt.Color(255, 255, 255));
            btnExcluirParecer.setText("Excluir");
            btnExcluirParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
            btnExcluirParecer.setContentAreaFilled(false);
            btnExcluirParecer.setFocusPainted(false);
            btnExcluirParecer.setOpaque(true);
            btnExcluirParecer.setName(prc.getParecerData());
            btnExcluirParecer.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnClicado(evt);
                    excluirParecerTecnico(evt);
                }
            });
            
            jFilho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 190, 190)));    
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="Layout do painel">
            javax.swing.GroupLayout painelItemPecaEServicoLayout = new javax.swing.GroupLayout(jFilho);
            jFilho.setLayout(painelItemPecaEServicoLayout);           
            javax.swing.GroupLayout jFilhoLayout = new javax.swing.GroupLayout(jFilho);
            jFilho.setLayout(jFilhoLayout);
            jFilhoLayout.setHorizontalGroup(
                jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFilhoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleNomeColaborador)
                        .addComponent(titleDescricaoParecer))
                    .addGap(18, 18, 18)
                    .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jsp)
                        .addComponent(txtNomeColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFilhoLayout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(titleData, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(13, 13, 13))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFilhoLayout.createSequentialGroup()
                            .addComponent(btnExcluirParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
            );
            jFilhoLayout.setVerticalGroup(
                jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFilhoLayout.createSequentialGroup()
                    .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFilhoLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titleNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(15, 15, 15))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFilhoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnExcluirParecer)
                            .addGap(18, 18, 18)))
                    .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFilhoLayout.createSequentialGroup()
                            .addGroup(jFilhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jFilhoLayout.createSequentialGroup()
                                    .addComponent(titleData)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFilhoLayout.createSequentialGroup()
                            .addComponent(titleDescricaoParecer)
                            .addGap(55, 55, 55))))
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
        btnEditarVeiculo = new javax.swing.JButton();
        txtErroAno = new javax.swing.JLabel();
        txtErroAcessorios = new javax.swing.JLabel();
        txtErroDefeito = new javax.swing.JLabel();
        txtErroObservacoes = new javax.swing.JLabel();
        titleCor = new javax.swing.JLabel();
        campoCor = new javax.swing.JTextField();
        txtErroSituacao = new javax.swing.JLabel();
        painelDeRolagemPareceresTecnicos = new javax.swing.JScrollPane();
        painelParaManterOScroll = new javax.swing.JPanel();
        painelAddParecer = new javax.swing.JPanel();
        btnLimparCampoParecer = new javax.swing.JButton();
        btnAdicionarParecer = new javax.swing.JButton();
        titleDescricaoParecerAdd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescricaoParecerAdd = new javax.swing.JTextArea();
        txtErroAddParecer = new javax.swing.JLabel();
        painelPareceresTecnicos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);
        setMinimumSize(new java.awt.Dimension(1368, 768));
        setPreferredSize(new java.awt.Dimension(1368, 768));

        painelInformacoesVeiculo.setPreferredSize(new java.awt.Dimension(650, 683));

        titleTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleTipo.setText("Tipo do veículo:");

        campoTipo.setBackground(new java.awt.Color(240, 240, 240));
        campoTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTipo.setBorder(null);
        campoTipo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoTipo.setEnabled(false);

        campoFabricante.setBackground(new java.awt.Color(240, 240, 240));
        campoFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoFabricante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoFabricante.setBorder(null);
        campoFabricante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoFabricante.setEnabled(false);

        titleFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleFabricante.setText("Fabricante do veículo:");

        titleModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleModelo.setText("Modelo do veículo:");

        campoModelo.setBackground(new java.awt.Color(240, 240, 240));
        campoModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoModelo.setBorder(null);
        campoModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoModelo.setEnabled(false);

        titleAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleAno.setText("Ano do veículo:");

        campoAno.setBackground(new java.awt.Color(240, 240, 240));
        campoAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoAno.setBorder(null);
        campoAno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoAno.setEnabled(false);
        campoAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaAno(evt);
            }
        });

        titleAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleAcessorios.setText("Acessórios do veículo:");

        campoAcessorios.setBackground(new java.awt.Color(240, 240, 240));
        campoAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoAcessorios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoAcessorios.setBorder(null);
        campoAcessorios.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoAcessorios.setEnabled(false);
        campoAcessorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaAcessorios(evt);
            }
        });

        titleObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleObservacoes.setText("Observações do veículo:");

        campoObservacoes.setBackground(new java.awt.Color(240, 240, 240));
        campoObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoObservacoes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoObservacoes.setBorder(null);
        campoObservacoes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoObservacoes.setEnabled(false);
        campoObservacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaObservacoes(evt);
            }
        });

        titleDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDefeito.setText("Defeito descrito pelo cliente");

        campoDefeito.setBackground(new java.awt.Color(240, 240, 240));
        campoDefeito.setColumns(20);
        campoDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDefeito.setRows(5);
        campoDefeito.setBorder(null);
        campoDefeito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoDefeito.setEnabled(false);
        campoDefeito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaDefeito(evt);
            }
        });
        jScrollPane1.setViewportView(campoDefeito);

        titleSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleSituacao.setText("Situação do veículo:");

        campoSituacao.setBackground(new java.awt.Color(240, 240, 240));
        campoSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSituacao.setBorder(null);
        campoSituacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoSituacao.setEnabled(false);
        campoSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaSituacao(evt);
            }
        });

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
        campoCor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoCor.setEnabled(false);

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
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeRolagemPareceresTecnicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 0)), "Pareceres técnicos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        painelDeRolagemPareceresTecnicos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
        areaDescricaoParecerAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaDescricaoParecerAdd.setRows(5);
        areaDescricaoParecerAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaParecer(evt);
            }
        });
        jScrollPane2.setViewportView(areaDescricaoParecerAdd);

        txtErroAddParecer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtErroAddParecer.setForeground(new java.awt.Color(220, 220, 220));
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
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

        javax.swing.GroupLayout painelPareceresTecnicosLayout = new javax.swing.GroupLayout(painelPareceresTecnicos);
        painelPareceresTecnicos.setLayout(painelPareceresTecnicosLayout);
        painelPareceresTecnicosLayout.setHorizontalGroup(
            painelPareceresTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        painelPareceresTecnicosLayout.setVerticalGroup(
            painelPareceresTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelParaManterOScrollLayout = new javax.swing.GroupLayout(painelParaManterOScroll);
        painelParaManterOScroll.setLayout(painelParaManterOScrollLayout);
        painelParaManterOScrollLayout.setHorizontalGroup(
            painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParaManterOScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPareceresTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAddParecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        painelParaManterOScrollLayout.setVerticalGroup(
            painelParaManterOScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParaManterOScrollLayout.createSequentialGroup()
                .addComponent(painelPareceresTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(painelAddParecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeRolagemPareceresTecnicos.setViewportView(painelParaManterOScroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelInformacoesVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDeRolagemPareceresTecnicos)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInformacoesVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelDeRolagemPareceresTecnicos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCamposParecer(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparCamposParecer
        btnClicado(evt);
        limparCampos();
    }//GEN-LAST:event_limparCamposParecer

    private void adicionarParecer(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarParecer
        ParecerDAO pdao = new ParecerDAO();
        ParecerTecnico prc = new ParecerTecnico();
        prc.setOsNumero(vzao.getVeiculoNumOs());
        prc.setParecerDescricao(areaDescricaoParecerAdd.getText());
        //ver aqui bundao
        prc.setColabNomeTecnico(USER_LOGADO.getCOLAB_NOME());
        pdao.adicionarParecerTecnico(prc);
        atualizarTela();
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
                VeiculoDAO vdao = new VeiculoDAO();
                OsDAO osdao = new OsDAO();
                String ano = campoAno.getText();
                String acessorios = campoAcessorios.getText();
                String obs = campoObservacoes.getText();
                String defeito = campoDefeito.getText();
                String situacao = campoSituacao.getText();
                osdao.atualizarSituacaoOs(vzao.getVeiculoNumOs(), situacao, ano);
                vdao.atualizarVeiculo(vzao.getVeiculoNumOs(),ano,acessorios,obs,defeito,situacao,vzao.getVeiculoPlaca());
                atualizarTela();
            } else {
                contadorEditar--;
            }           
        }  
    }//GEN-LAST:event_editarVeiculo

    private void tecladaAno(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaAno
        if (vs.veiculoAno(evt, campoAno.getText()) == ""){
            txtErroAno.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculoAno(evt, campoAno.getText());
            txtErroAno.setText(txt);
            if (txt.endsWith(".")){
                txtErroAno.setForeground(new Color(255,0,0));
            } else {
                txtErroAno.setForeground(new Color(0, 160, 40));
            }           
        }
    }//GEN-LAST:event_tecladaAno

    private void tecladaAcessorios(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaAcessorios
        if (vs.veiculo255(evt, campoAcessorios.getText()) == ""){
            txtErroAcessorios.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculo255(evt, campoAcessorios.getText());
            txtErroAcessorios.setText(txt);
            if (txt.endsWith(".")){
                txtErroAcessorios.setForeground(new Color(255,0,0));
            } else {
                txtErroAcessorios.setForeground(new Color(0, 160, 40));
            }           
        }
    }//GEN-LAST:event_tecladaAcessorios

    private void tecladaObservacoes(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaObservacoes
        if (vs.veiculo255(evt, campoObservacoes.getText()) == ""){
            txtErroObservacoes.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculo255(evt, campoObservacoes.getText());
            txtErroObservacoes.setText(txt);
            if (txt.endsWith(".")){
                txtErroObservacoes.setForeground(new Color(255,0,0));
            } else {
                txtErroObservacoes.setForeground(new Color(0, 160, 40));
            }           
        }
    }//GEN-LAST:event_tecladaObservacoes

    private void tecladaDefeito(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDefeito
        if (vs.veiculo255(evt, campoDefeito.getText()) == ""){
            txtErroDefeito.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculo255(evt, campoDefeito.getText());
            txtErroDefeito.setText(txt);
            if (txt.endsWith(".")){
                txtErroDefeito.setForeground(new Color(255,0,0));
            } else {
                txtErroDefeito.setForeground(new Color(0, 160, 40));
            }           
        }
    }//GEN-LAST:event_tecladaDefeito

    private void tecladaSituacao(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaSituacao
        if (vs.nome30(evt, campoSituacao.getText()) == ""){
            txtErroSituacao.setForeground(new Color(240,240,240));
        } else {
            String txt = vs.nome30(evt, campoSituacao.getText());
            txtErroSituacao.setText(txt);
            if (txt.endsWith(".")){
                txtErroSituacao.setForeground(new Color(255,0,0));
            } else {
                txtErroSituacao.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaSituacao

    private void tecladaParecer(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaParecer
        if (vs.veiculo255(evt, areaDescricaoParecerAdd.getText()) == ""){
            txtErroAddParecer.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculo255(evt, areaDescricaoParecerAdd.getText());
            txtErroAddParecer.setText(txt);
            if (txt.endsWith(".")){
                txtErroAddParecer.setForeground(new Color(220,220,220));
            } else {
                txtErroAddParecer.setForeground(new Color(0, 160, 40));
            }           
        }
    }//GEN-LAST:event_tecladaParecer

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
    private javax.swing.JTextArea areaDescricaoParecerAdd;
    private javax.swing.JButton btnAdicionarParecer;
    private javax.swing.JButton btnEditarVeiculo;
    private javax.swing.JButton btnLimparCampoParecer;
    private javax.swing.JTextField campoAcessorios;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoCor;
    private javax.swing.JTextArea campoDefeito;
    private javax.swing.JTextField campoFabricante;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoObservacoes;
    private javax.swing.JTextField campoSituacao;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelAddParecer;
    private javax.swing.JScrollPane painelDeRolagemPareceresTecnicos;
    private javax.swing.JPanel painelInformacoesVeiculo;
    private javax.swing.JPanel painelParaManterOScroll;
    private javax.swing.JPanel painelPareceresTecnicos;
    private javax.swing.JLabel titleAcessorios;
    private javax.swing.JLabel titleAno;
    private javax.swing.JLabel titleCor;
    private javax.swing.JLabel titleDefeito;
    private javax.swing.JLabel titleDescricaoParecerAdd;
    private javax.swing.JLabel titleFabricante;
    private javax.swing.JLabel titleModelo;
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
        campoSituacao.setEnabled(true);
        campoSituacao.setBackground(Color.white);
        campoSituacao.setForeground(Color.black);
        campoSituacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }
    
    private void atualizarTela(){
        this.setVisible(false);
        List<ParecerTecnico> prcs = new ArrayList<>();
        Veiculo v = new Veiculo();
        ParecerDAO pdao = new ParecerDAO();
        VeiculoDAO vdao = new VeiculoDAO();                       
        v = vdao.consultarVeiculo("'"+vzao.getVeiculoPlaca()+"'", vzao.getVeiculoNumOs());
        prcs = pdao.consultarPareceres(vzao.getVeiculoNumOs());
        consulta_veiculo novaTela = new consulta_veiculo(v,prcs);
        //por algum motivo, o método de mudar de tela ta dando erro. Tentar arrumar depois
        novaTela.setBounds(this.getX(), this.getY(),this.getWidth(),this.getHeight());
        novaTela.setExtendedState(this.getExtendedState());
        this.dispose();
        novaTela.setVisible(true);
    } 
    
    private void excluirParecerTecnico(java.awt.event.MouseEvent evt) {                                       
        ParecerDAO pdao = new ParecerDAO();
        pdao.excluirParecerTecnico(evt.getComponent().getName());
        atualizarTela();
    }
}

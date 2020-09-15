/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import pif.desktop.Classes.FormatacaoStrings;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.VerificacaoStrings;
import pif.desktop.DAO.ClienteDAO;
import pif.desktop.DAO.OrcamentoDAO;
import pif.desktop.DAO.OsDAO;
import pif.desktop.TELAS.rascunhos.consulta_os;

/**
 *
 * @author arthu
 */
public class RUD_OS_TELA extends javax.swing.JFrame {

    /**
     * @return the OSs
     */
    public List<OS> getOSs() {
        return OSs;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    Image icon;
    private TelaUtils u = new TelaUtils();
    private VerificacaoStrings vs = new VerificacaoStrings();
    private FormatacaoStrings fs = new FormatacaoStrings();  
    private List<OS> OSs = new ArrayList<>();  
    private List<Orcamento> Orcs = new ArrayList<>();  
    private int i;
    
//    private static RUD_EQUIP_TELA RUD_EQUIP = new RUD_EQUIP_TELA();
//    private static C_EQUIP_TELA C_EQUIP = new C_EQUIP_TELA();

//    public static RUD_CLIENTE_TELA RUD_CLIENTE = new RUD_CLIENTE_TELA();
//    public static C_CLIENTE_TELA C_CLIENTE = new C_CLIENTE_TELA();

    /**
     * Creates new form CADASTRAR_OS
     */
    public RUD_OS_TELA() {
        try {
            icon = ImageIO.read(new File("src/resources/icon.png"));           
        } catch (IOException e) {
            e.printStackTrace();
        }      
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        painelSeções = new javax.swing.JPanel();
        btnIrOS = new javax.swing.JButton();
        btnIrVeiculo = new javax.swing.JButton();
        btnIrClientes = new javax.swing.JButton();
        painelCRUD = new javax.swing.JPanel();
        btnIrConsultaOS = new javax.swing.JButton();
        btnIrCadastroOS = new javax.swing.JButton();
        txtNomeColab = new javax.swing.JLabel();
        painelFormularioConsulta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        RcpfOuCnpj = new javax.swing.JLabel();
        campoCpfOuCnpj = new javax.swing.JTextField();
        RnumOs = new javax.swing.JLabel();
        campoNumeroOS = new javax.swing.JTextField();
        Rplaca = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JTextField();
        ou1 = new javax.swing.JLabel();
        ou2 = new javax.swing.JLabel();
        btnConsultarOS = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        txtErroConsulta = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImage(icon);
        setMinimumSize(new java.awt.Dimension(800, 600));

        painelSeções.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnIrOS.setBackground(new java.awt.Color(100, 0, 0));
        btnIrOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrOS.setText("Ordem de serviço");
        btnIrOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 0)));
        btnIrOS.setContentAreaFilled(false);
        btnIrOS.setFocusPainted(false);
        btnIrOS.setOpaque(true);
        btnIrOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroOS(evt);
            }
        });

        btnIrVeiculo.setBackground(new java.awt.Color(204, 0, 0));
        btnIrVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnIrVeiculo.setText("Veículos");
        btnIrVeiculo.setToolTipText("");
        btnIrVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrVeiculo.setContentAreaFilled(false);
        btnIrVeiculo.setFocusPainted(false);
        btnIrVeiculo.setOpaque(true);
        btnIrVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroEquip(evt);
            }
        });

        btnIrClientes.setBackground(new java.awt.Color(204, 0, 0));
        btnIrClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnIrClientes.setText("Clientes");
        btnIrClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrClientes.setContentAreaFilled(false);
        btnIrClientes.setFocusPainted(false);
        btnIrClientes.setOpaque(true);
        btnIrClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroCliente(evt);
            }
        });

        javax.swing.GroupLayout painelSeçõesLayout = new javax.swing.GroupLayout(painelSeções);
        painelSeções.setLayout(painelSeçõesLayout);
        painelSeçõesLayout.setHorizontalGroup(
            painelSeçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSeçõesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnIrVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnIrClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSeçõesLayout.setVerticalGroup(
            painelSeçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSeçõesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(painelSeçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrOS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        painelCRUD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "O que deseja fazer?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnIrConsultaOS.setBackground(new java.awt.Color(100, 0, 0));
        btnIrConsultaOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrConsultaOS.setText("Consultar uma OS");
        btnIrConsultaOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 0)));
        btnIrConsultaOS.setContentAreaFilled(false);
        btnIrConsultaOS.setFocusPainted(false);
        btnIrConsultaOS.setOpaque(true);
        btnIrConsultaOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irConsultaOS(evt);
            }
        });

        btnIrCadastroOS.setBackground(new java.awt.Color(204, 0, 0));
        btnIrCadastroOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrCadastroOS.setText("Cadastrar uma OS");
        btnIrCadastroOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrCadastroOS.setContentAreaFilled(false);
        btnIrCadastroOS.setFocusPainted(false);
        btnIrCadastroOS.setOpaque(true);
        btnIrCadastroOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroOS(evt);
            }
        });

        txtNomeColab.setText("aaaaaaaaa");

        javax.swing.GroupLayout painelCRUDLayout = new javax.swing.GroupLayout(painelCRUD);
        painelCRUD.setLayout(painelCRUDLayout);
        painelCRUDLayout.setHorizontalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDLayout.createSequentialGroup()
                .addGroup(painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCRUDLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelCRUDLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtNomeColab)))
                .addGap(10, 10, 10))
        );
        painelCRUDLayout.setVerticalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(txtNomeColab)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        painelFormularioConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 35, 35)), "Formulário de consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        RcpfOuCnpj.setText("CPF ou CPNJ:");

        campoCpfOuCnpj.setName("cpfnj"); // NOI18N
        campoCpfOuCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desabilitarCampos(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaCpf(evt);
            }
        });

        RnumOs.setText("Número de OS:");

        campoNumeroOS.setName("numOs"); // NOI18N
        campoNumeroOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desabilitarCampos(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaNumOs(evt);
            }
        });

        Rplaca.setText("Placa:");

        campoPlaca.setName(""); // NOI18N
        campoPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaPlaca(evt);
            }
        });

        ou1.setText("ou");

        ou2.setText("ou");

        btnConsultarOS.setBackground(new java.awt.Color(204, 0, 0));
        btnConsultarOS.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarOS.setText("Consultar");
        btnConsultarOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnConsultarOS.setContentAreaFilled(false);
        btnConsultarOS.setFocusPainted(false);
        btnConsultarOS.setOpaque(true);
        btnConsultarOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultarOs(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(204, 0, 0));
        btnLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setText("Limpar campos");
        btnLimparCampos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnLimparCampos.setContentAreaFilled(false);
        btnLimparCampos.setFocusPainted(false);
        btnLimparCampos.setOpaque(true);
        btnLimparCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparCampos(evt);
            }
        });

        txtErroConsulta.setForeground(new java.awt.Color(240, 240, 240));
        txtErroConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroConsulta.setText("jLabel1");
        txtErroConsulta.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RnumOs)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RcpfOuCnpj)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoCpfOuCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Rplaca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ou1)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ou2)
                                .addGap(66, 66, 66)))
                        .addComponent(txtErroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnConsultarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RcpfOuCnpj)
                            .addComponent(campoCpfOuCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ou1)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RnumOs)
                            .addComponent(campoNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ou2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rplaca)
                            .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtErroConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelFormularioConsultaLayout = new javax.swing.GroupLayout(painelFormularioConsulta);
        painelFormularioConsulta.setLayout(painelFormularioConsultaLayout);
        painelFormularioConsultaLayout.setHorizontalGroup(
            painelFormularioConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormularioConsultaLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        painelFormularioConsultaLayout.setVerticalGroup(
            painelFormularioConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSeções, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelFormularioConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(painelSeções, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelFormularioConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void irConsultaOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irConsultaOS

    }//GEN-LAST:event_irConsultaOS

    private void irCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroOS
        u.irDePara(this, C_OS_TELA.getC_OS());
    }//GEN-LAST:event_irCadastroOS

    private void irCadastroEquip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroEquip
//        u.irDePara(this, C_OS_TELA.getC_EQUIP());
    }//GEN-LAST:event_irCadastroEquip

    private void irCadastroCliente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroCliente
        // u.irDePara(this, C_OS_TELA.getC_CLIENTE());
    }//GEN-LAST:event_irCadastroCliente

    private void consultarOs(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarOs
        btnClicado(evt);
//        try {
            String campo = "";
            String valor = "";
            boolean numOS = false;
            if (vazioForm()){
                txtErroConsulta.setForeground(Color.RED);
                txtErroConsulta.setText("Preencha os campos.");   
            } else {
                if(erroForm()){
                    txtErroConsulta.setText("Há algum erro.");
                }else{
                    if (campoCpfOuCnpj.isEnabled()){
                        if (campoCpfOuCnpj.getText().length() == 14 || campoCpfOuCnpj.getText().length() == 18){ 
                            ClienteDAO cdao = new ClienteDAO();
                            if (cdao.verificarCliente(campoCpfOuCnpj.getText(),"os_teste")==false){
                                
                            } else {
                                campo = "cliente_cpf_ou_cnpj";     
                                valor = fs.retirarCpfOuCnpj(campoCpfOuCnpj.getText());
                            }
                        }                        
                    }else if(campoPlaca.isEnabled()){
                        campo = "veiculo_placa";
                        valor = "'"+campoPlaca.getText()+"'";                       
                    }else if(campoNumeroOS.isEnabled()){
                        campo = "os_numero";
                        valor = campoNumeroOS.getText();
                        numOS = true;
                    }
                    valor = fs.retirarFormatacao(valor);
                    OsDAO osDao = new OsDAO();                       
                    OSs = osDao.consultaOs(campo, valor); 
                    if (OSs.size() == 0){
                        txtErroConsulta.setForeground(Color.RED);
                        txtErroConsulta.setText("Ordem de serviço inexistente."); 
                    } else{
                        if(OSs.size() == 1){
                            OrcamentoDAO orcDao = new OrcamentoDAO();                        
                            Orcs = orcDao.consultarOrcamento(OSs.get(0).getOsNumero());    
                            System.out.println("1");
                            consulta_os CONSULTA_TELA = new consulta_os(OSs.get(0),Orcs);
                            System.out.println("2");
                            u.irDeParaDiferenciado(this, CONSULTA_TELA,1350,800);
                            System.out.println("3");
                        }
                        else{
                            //<editor-fold defaultstate="collapsed" desc="Tela">
                            consulta_os_tela consultaTelaOs = new consulta_os_tela();
                            JPanel jPai = new JPanel();
                            jPai.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 0)), "Escolha o número de OS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
                            consultaTelaOs.setLayout(new GridLayout(1,1));                                                                                
                            for(int i=0; i<=getOSs().size()-1;i++){
                                OS os;
                                os = getOSs().get(i);
                                JButton butao = new JButton();
                                butao.setForeground(new java.awt.Color(255, 255, 255));
                                butao.setBackground(new java.awt.Color(204, 0, 0));  
                                butao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));                             
                                butao.setPreferredSize(new Dimension(100, 30));
                                butao.setText(os.getOsNumero());
                                butao.setName(String.valueOf(i));
                                butao.setFocusable(false);
                                butao.setToolTipText("");                                
                                butao.setContentAreaFilled(false);
                                butao.setOpaque(true);
                                butao.addMouseListener(new java.awt.event.MouseAdapter() {
                                            @Override
                                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                                btnClicado(evt);
                                                mudarTela(evt);
                                            }
                                        });
                                jPai.add(butao);
                            } 
                            consultaTelaOs.add(jPai);
                            consultaTelaOs.setLocationRelativeTo(null);
                            consultaTelaOs.setIconImage(icon);
                            consultaTelaOs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                            consultaTelaOs.setVisible(true);
                            //</editor-fold>
                        }
                    }
                }  
            }                        
//        }catch(Exception e){
//            System.out.println("Erro aca: "+e);
//        }   
    }//GEN-LAST:event_consultarOs

    private void limparCampos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparCampos
        btnClicado(evt);
        limparCampos();
        campoCpfOuCnpj.setEnabled(true);
        campoPlaca.setEnabled(true);
        campoNumeroOS.setEnabled(true);
    }//GEN-LAST:event_limparCampos
    
    //<editor-fold defaultstate="collapsed" desc="métodos teclados">
    private void tecladaNumOs(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaNumOs
        if (vs.numeroOS(evt, campoNumeroOS.getText()) == ""){
            txtErroConsulta.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.numeroOS(evt, campoNumeroOS.getText());
            txtErroConsulta.setText(txt);
            if (txt.endsWith(".")){
                txtErroConsulta.setForeground(new Color(255,0,0));
            } else {
                txtErroConsulta.setForeground(new Color(0, 160, 40));
            }           
        }   
    }//GEN-LAST:event_tecladaNumOs

    private void tecladaPlaca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPlaca
        if (vs.veiculoPlaca(evt, campoPlaca.getText()) == ""){
            txtErroConsulta.setForeground(new Color(240,240,240));           
        } else {
            String txt = vs.veiculoPlaca(evt, campoPlaca.getText());
            txtErroConsulta.setText(txt);
            if (txt.endsWith(".")){
                txtErroConsulta.setForeground(new Color(255,0,0));
            } else {
                txtErroConsulta.setForeground(new Color(0, 160, 40));
            }           
        }
        if (campoPlaca.getText().length() > 7){
            int calc = campoPlaca.getText().length() - 7;
            campoPlaca.setText(campoPlaca.getText().substring(0,campoPlaca.getText().length()-calc));
        }  
        if ((campoPlaca.getText().length()+1) >=1 && !"".equals(campoPlaca.getText())){
            campoNumeroOS.setEnabled(false);
            campoCpfOuCnpj.setEnabled(false);
        } else {
            campoNumeroOS.setEnabled(true);
            campoCpfOuCnpj.setEnabled(true);
        }
        
        String txt = fs.placa(campoPlaca.getText());
        campoPlaca.setText(txt);
    }//GEN-LAST:event_tecladaPlaca

    private void tecladaCpf(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaCpf
        if ("\b".equals(Character.toString(evt.getKeyChar()))){
            campoCpfOuCnpj.setText(fs.apagar(campoCpfOuCnpj.getText(), evt.getComponent().getName()));
        }
        if (vs.cpfOuCnpj(evt, campoCpfOuCnpj.getText()) == ""){
            txtErroConsulta.setForeground(new Color(240,240,240));
        } else {
            String txt = vs.cpfOuCnpj(evt, campoCpfOuCnpj.getText());
            txtErroConsulta.setText(txt);
            if (txt.endsWith(".")){
                txtErroConsulta.setForeground(new Color(255,0,0));
            } else {
                txtErroConsulta.setForeground(new Color(0, 160, 40));
            }
        }
        String txt = fs.cpfOuCnpj(evt, campoCpfOuCnpj.getText());
        campoCpfOuCnpj.setText(txt);       
    }//GEN-LAST:event_tecladaCpf
    //</editor-fold>
    
    private void desabilitarCampos(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desabilitarCampos
        if (evt.getComponent().getName().equals("cpfnj")){
            if (campoCpfOuCnpj.getText().length() >=1 && !"".equals(campoCpfOuCnpj.getText())){
            campoNumeroOS.setEnabled(false);
            campoPlaca.setEnabled(false);
            } else {
                campoNumeroOS.setEnabled(true);
                campoPlaca.setEnabled(true);
            } 
        }else if(evt.getComponent().getName().equals("numOs")){
            if (campoNumeroOS.getText().length() >=1 && !"".equals(campoNumeroOS.getText())){
                campoPlaca.setEnabled(false);
                campoCpfOuCnpj.setEnabled(false);
            } else {
                campoPlaca.setEnabled(true);
                campoCpfOuCnpj.setEnabled(true);
            }            
        }     
    }//GEN-LAST:event_desabilitarCampos

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
            java.util.logging.Logger.getLogger(RUD_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUD_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUD_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUD_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RUD_OS_TELA ss = new RUD_OS_TELA();
                ss.setVisible(true);                            
            }
        });       
    }
    
    //<editor-fold defaultstate="collapsed" desc="Coisas do javax">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RcpfOuCnpj;
    private javax.swing.JLabel RnumOs;
    private javax.swing.JLabel Rplaca;
    private javax.swing.JButton btnConsultarOS;
    private javax.swing.JButton btnIrCadastroOS;
    private javax.swing.JButton btnIrClientes;
    private javax.swing.JButton btnIrConsultaOS;
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnIrVeiculo;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JTextField campoCpfOuCnpj;
    private javax.swing.JTextField campoNumeroOS;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel ou1;
    private javax.swing.JLabel ou2;
    private javax.swing.JPanel painelCRUD;
    private javax.swing.JPanel painelFormularioConsulta;
    private javax.swing.JPanel painelSeções;
    private javax.swing.JLabel txtErroConsulta;
    private javax.swing.JLabel txtNomeColab;
    // End of variables declaration//GEN-END:variables
   //</editor-fold>

    private void btnClicado(java.awt.event.MouseEvent evt){
        /*
            MÉTODO RESPONSÁVEL POR MUDAR A COR DE FUNDO DO BOTAO QUANDO FOR CLICADO
        */
        evt.getComponent().setBackground(new Color(100,0,0));
        new Timer().schedule(
            new TimerTask(){
                @Override
                public void run(){
                    evt.getComponent().setBackground(new Color(204,0,0));
                }
        }, 50);
    }
    
    private void mudarTela(java.awt.event.MouseEvent evt){         
        i = Integer.parseInt(evt.getComponent().getName());  
        OrcamentoDAO orcDao = new OrcamentoDAO();                          
        Orcs = orcDao.consultarOrcamento(OSs.get(i).getOsNumero());                          
        consulta_os CONSULTA_TELA = new consulta_os(OSs.get(i),Orcs);
        u.irDeParaDiferenciado(this, CONSULTA_TELA,1350,800);
    }
 
    private void limparCampos(){
        campoCpfOuCnpj.setText("");
        campoNumeroOS.setText("");
        campoPlaca.setText("");
        txtErroConsulta.setForeground(new Color(240,240,240));
    }
    
    private boolean vazioForm(){
        boolean vazio;
        if (
            campoCpfOuCnpj.isEnabled() && campoCpfOuCnpj.getText().equals("") ||
            campoNumeroOS.isEnabled() && campoNumeroOS.getText().equals("") ||
            campoPlaca.isEnabled() && campoPlaca.getText().equals("")
            ){
            vazio = true;
        }else{
            vazio = false;
        }
        return vazio;
    }
    
    private boolean erroForm(){
        boolean erro=false;     
        if (txtErroConsulta.getForeground().getRed() == 255){
            erro = true;
        }
        return erro;
    }
}
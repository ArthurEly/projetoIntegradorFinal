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
import pif.desktop.Classes.USER_LOGADO;
import pif.desktop.Classes.VerificacaoStrings;
import pif.desktop.DAO.ClienteDAO;
import pif.desktop.DAO.OrcamentoDAO;
import pif.desktop.DAO.OsDAO;
import static pif.desktop.TELAS.C_OS_TELA.getRELATORIO;
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
        setTitle("Consultar uma ordem de serviço");
        initComponents();
        painelSecoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "Seja bem-vindo(a) "+USER_LOGADO.getCOLAB_NOME()+"! Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
       
        //<editor-fold defaultstate="collapsed" desc="Tela">
        JPanel jFilho = new JPanel();
        JButton btnIrConsultaOS = new JButton();
        JButton btnIrCadastroOS = new JButton();
        btnIrConsultaOS.setBackground(new java.awt.Color(100, 0, 0));
        btnIrConsultaOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrConsultaOS.setText("Consultar uma OS");     
        btnIrConsultaOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 0)));
        btnIrConsultaOS.setContentAreaFilled(false);
        btnIrConsultaOS.setFocusPainted(false);
        btnIrConsultaOS.setOpaque(true);

        btnIrCadastroOS.setBackground(new java.awt.Color(204, 0, 0));
        btnIrCadastroOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrCadastroOS.setText("Cadastrar uma OS");
        btnIrCadastroOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));               
        btnIrCadastroOS.setBorderPainted(true);
        btnIrCadastroOS.setContentAreaFilled(false);
        btnIrCadastroOS.setFocusPainted(false);
        btnIrCadastroOS.setOpaque(true);
        btnIrCadastroOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroOS(evt);
            }
        });
        System.out.println(USER_LOGADO.isCOLAB_GERENTE());
        if (USER_LOGADO.isCOLAB_GERENTE()){
            //<editor-fold defaultstate="collapsed" desc="se for gerente">
            JButton btnIrRelatorios = new JButton();
            btnIrRelatorios.setBackground(new java.awt.Color(204, 0, 0));
            btnIrRelatorios.setForeground(new java.awt.Color(255, 255, 255));
            btnIrRelatorios.setText("Consultar relatórios");
            btnIrRelatorios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
            btnIrRelatorios.setContentAreaFilled(false);
            btnIrRelatorios.setFocusPainted(false);
            btnIrRelatorios.setOpaque(true);
            btnIrRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    irRelatorios(evt);
                }
            });
            javax.swing.GroupLayout painelOpcoesCRUDLayout = new javax.swing.GroupLayout(jFilho);
            jFilho.setLayout(painelOpcoesCRUDLayout);
            painelOpcoesCRUDLayout.setHorizontalGroup(
                painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelOpcoesCRUDLayout.createSequentialGroup()
                    .addGroup(painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelOpcoesCRUDLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOpcoesCRUDLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnIrRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            painelOpcoesCRUDLayout.setVerticalGroup(
                painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOpcoesCRUDLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnIrRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            //</editor-fold>
        } else {
            //<editor-fold defaultstate="collapsed" desc="se nao for">
            javax.swing.GroupLayout painelOpcoesCRUDLayout = new javax.swing.GroupLayout(jFilho);
            jFilho.setLayout(painelOpcoesCRUDLayout);
            painelOpcoesCRUDLayout.setHorizontalGroup(
                painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelOpcoesCRUDLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            painelOpcoesCRUDLayout.setVerticalGroup(
                painelOpcoesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOpcoesCRUDLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnIrConsultaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addContainerGap())
            );
            //</editor-fold>
        }
        painelCRUD.add(jFilho);
        painelCRUD.setLayout(new GridLayout(1,1));
        //</editor-fold>      
        this.setMinimumSize(new Dimension(1368,768));
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
        painelSecoes = new javax.swing.JPanel();
        btnIrOS = new javax.swing.JButton();
        btnIrUsuario = new javax.swing.JButton();
        painelCRUD = new javax.swing.JPanel();
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
        setMinimumSize(new java.awt.Dimension(1368, 768));
        setPreferredSize(new java.awt.Dimension(1368, 768));

        painelSecoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        btnIrUsuario.setBackground(new java.awt.Color(204, 0, 0));
        btnIrUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnIrUsuario.setText("Suas informações");
        btnIrUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrUsuario.setContentAreaFilled(false);
        btnIrUsuario.setFocusPainted(false);
        btnIrUsuario.setOpaque(true);
        btnIrUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irInfoUser(evt);
            }
        });

        javax.swing.GroupLayout painelSecoesLayout = new javax.swing.GroupLayout(painelSecoes);
        painelSecoes.setLayout(painelSecoesLayout);
        painelSecoesLayout.setHorizontalGroup(
            painelSecoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSecoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnIrUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSecoesLayout.setVerticalGroup(
            painelSecoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSecoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(painelSecoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrOS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        painelCRUD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "O que deseja fazer?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout painelCRUDLayout = new javax.swing.GroupLayout(painelCRUD);
        painelCRUD.setLayout(painelCRUDLayout);
        painelCRUDLayout.setHorizontalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        painelCRUDLayout.setVerticalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
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
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSecoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(painelSecoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelFormularioConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void irRelatorios(java.awt.event.MouseEvent evt) {                                             
        u.irDePara(this, getRELATORIO());
    }
    
    private void irCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroOS
        u.irDePara(this, C_OS_TELA.getC_OS());
    }//GEN-LAST:event_irCadastroOS

    private void irInfoUser(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irInfoUser
        u.irDePara(this, C_OS_TELA.getUSER_TELA());
    }//GEN-LAST:event_irInfoUser

    private void consultarOs(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarOs
        btnClicado(evt);
//        try {
            String campo = "";
            String valor = "";
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
                                valor = fs.zerosAEsquerda(campoCpfOuCnpj.getText());
                            }
                        }                        
                    }else if(campoPlaca.isEnabled()){
                        campo = "veiculo_placa";
                        valor = "'"+campoPlaca.getText()+"'";                       
                    }else if(campoNumeroOS.isEnabled()){
                        campo = "os_numero";
                        valor = campoNumeroOS.getText();
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
                            consulta_os consultaTela = new consulta_os(OSs.get(0),Orcs);
                            u.irDeParaDiferenciado(this, consultaTela,1368,768);
                        }
                        else{
                            //<editor-fold defaultstate="collapsed" desc="Tela">
                            consulta_tela consultaTelaOs = new consulta_tela();
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
                            consultaTelaOs.setTitle("Escolha uma ordem de serviço");
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
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnIrUsuario;
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
    private javax.swing.JPanel painelSecoes;
    private javax.swing.JLabel txtErroConsulta;
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
        consulta_os consultaTela = new consulta_os(OSs.get(i),Orcs);
        u.irDeParaDiferenciado(this, consultaTela,1368,768);
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
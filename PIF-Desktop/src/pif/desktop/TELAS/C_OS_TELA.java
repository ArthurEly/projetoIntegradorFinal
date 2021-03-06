/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS;

import pif.desktop.Classes.USER_LOGADO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import pif.desktop.Classes.Cliente;
import pif.desktop.Classes.Colab;
import pif.desktop.Classes.Contato;
import pif.desktop.Classes.Veiculo;
import pif.desktop.Classes.FormatacaoStrings;
import pif.desktop.Classes.OS;
import pif.desktop.Classes.Orcamento;
import pif.desktop.Classes.VerificacaoStrings;
import pif.desktop.DAO.CadastroDAO;
import pif.desktop.DAO.ClienteDAO;
import pif.desktop.DAO.ContatoDAO;
import pif.desktop.DAO.OsDAO;

/**
 *
 * @author arthu
 */
public class C_OS_TELA extends javax.swing.JFrame {

    /**
     * @return the RELATORIO
     */
    public static RELATORIO_TELA getRELATORIO() {
        return RELATORIO;
    }

    /**
     * @param aRELATORIO the RELATORIO to set
     */
    public static void setRELATORIO(RELATORIO_TELA aRELATORIO) {
        RELATORIO = aRELATORIO;
    }

    /**
     * @return the USER_TELA
     */
    public static USER_TELA getUSER_TELA() {
        return USER_TELA;
    }

    /**
     * @param USER_TELA the USER_TELA to set
     */
    public static void setUSER_TELA(USER_TELA USER_TELA) {
        C_OS_TELA.USER_TELA = USER_TELA;
    }

    /**
     * @param aRUD_OS the RUD_OS to set
     */
    public static void setRUD_OS(RUD_OS_TELA aRUD_OS) {
        RUD_OS = aRUD_OS;
    }

    /**
     * @param aC_OS the C_OS to set
     */
    public static void setC_OS(C_OS_TELA aC_OS) {
        C_OS = aC_OS;
    }

    /**
     * @return the RUD_OS
     */
    public static RUD_OS_TELA getRUD_OS() {
        return RUD_OS;
    }

    /**
     * @return the C_OS
     */
    public static C_OS_TELA getC_OS() {
        return C_OS;
    }

    Image icon;
    private TelaUtils u = new TelaUtils();
    private boolean rudAberto;
    private boolean userAberto;
    private static RUD_OS_TELA RUD_OS;
    private static C_OS_TELA C_OS;
    private static USER_TELA USER_TELA;
    private static RELATORIO_TELA RELATORIO;
    private FormatacaoStrings fs = new FormatacaoStrings();
    private VerificacaoStrings vs = new VerificacaoStrings();

    /**
     * Creates new form CADASTRAR_OS
     */
    public C_OS_TELA(Colab cb, Contato ctt) {
        try {
            icon = ImageIO.read(getClass().getResource("/resources/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setLocationRelativeTo(null);
        setC_OS(this);
        initComponents();
        painelDeRolagem.getVerticalScrollBar().setUnitIncrement(8);
        USER_LOGADO.setCOLAB_NOME(cb.getColabNome());
        USER_LOGADO.setCOLAB_SOBRENOME(cb.getColabSobrenome());
        USER_LOGADO.setCOLAB_CPF(cb.getColabCpf());
        USER_LOGADO.setCOLAB_RG(cb.getColabRg());
        USER_LOGADO.setCOLAB_ESTADO(cb.getColabEndEstado());
        USER_LOGADO.setCOLAB_CEP(cb.getColabEndCep());
        USER_LOGADO.setCOLAB_CIDADE(cb.getColabEndCidade());
        USER_LOGADO.setCOLAB_BAIRRO(cb.getColabEndBairro());
        USER_LOGADO.setCOLAB_LOGRAD(cb.getColabEndLograd());
        USER_LOGADO.setCOLAB_LOGRAD_NUM(cb.getColabEndLogradNum());
        USER_LOGADO.setCOLAB_LOGRAD_COMP(cb.getColabEndLogradComp());
        USER_LOGADO.setCOLAB_DATA_NASCIMENTO(cb.getColabDataNasc());
        USER_LOGADO.setCOLAB_CONTATO_EMAIL(ctt.getClienteContatoEmail());
        USER_LOGADO.setCOLAB_CONTATO_NUM_TEL1(ctt.getClienteContatoNumTel1());
        USER_LOGADO.setCOLAB_CONTATO_NUM_TEL2(ctt.getClienteContatoNumTel2());
        USER_LOGADO.setCOLAB_TEC(cb.isIsTecnico());
        USER_LOGADO.setCOLAB_GERENTE(cb.isIsGerente());
        OsDAO os = new OsDAO();
        txtNumeroOS.setText(os.numeroOsAtual());
        painelSecoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "Seja bem-vindo(a) " + USER_LOGADO.getCOLAB_NOME() + "! Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
        RUD_OS = new RUD_OS_TELA();
        USER_TELA = new USER_TELA();
        RELATORIO = new RELATORIO_TELA();
        C_OS_TELA.setRUD_OS(RUD_OS);
        C_OS_TELA.setUSER_TELA(USER_TELA);
        C_OS_TELA.setRELATORIO(RELATORIO);
        //<editor-fold defaultstate="collapsed" desc="Tela">
        JPanel jFilho = new JPanel();
        JButton btnIrConsultaOS = new JButton();
        JButton btnIrCadastroOS = new JButton();
        btnIrConsultaOS.setBackground(new java.awt.Color(204, 0, 0));
        btnIrConsultaOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrConsultaOS.setText("Consultar uma OS");
        btnIrConsultaOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnIrConsultaOS.setContentAreaFilled(false);
        btnIrConsultaOS.setFocusPainted(false);
        btnIrConsultaOS.setOpaque(true);
        btnIrConsultaOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irConsultaOS(evt);
            }
        });

        btnIrCadastroOS.setBackground(new java.awt.Color(100, 0, 0));
        btnIrCadastroOS.setForeground(new java.awt.Color(255, 255, 255));
        btnIrCadastroOS.setText("Cadastrar uma OS");
        btnIrCadastroOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 0)));
        btnIrCadastroOS.setBorderPainted(false);
        btnIrCadastroOS.setContentAreaFilled(false);
        btnIrCadastroOS.setFocusPainted(false);
        btnIrCadastroOS.setOpaque(true);
        if (USER_LOGADO.isCOLAB_GERENTE()) {
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
        painelCRUD.setLayout(new GridLayout(1, 1));
        this.setMinimumSize(new Dimension(1368, 768));
        //</editor-fold>
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
        painelDeRolagem = new javax.swing.JScrollPane();
        painelDoScroll = new javax.swing.JPanel();
        painelDoFormulario = new javax.swing.JPanel();
        titleNumeroOS = new javax.swing.JLabel();
        txtNumeroOS = new javax.swing.JLabel();
        titleCpfOuCnpj = new javax.swing.JLabel();
        titleNomeOuRazao = new javax.swing.JLabel();
        campoCpfOuCnpj = new javax.swing.JTextField();
        campoNomeOuRazao = new javax.swing.JTextField();
        titleSobrenomeOuFantasia = new javax.swing.JLabel();
        titleRgOuIe = new javax.swing.JLabel();
        campoRgOuIe = new javax.swing.JTextField();
        campoSobrenomeOuFantasia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        titleEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        titleNumTel1 = new javax.swing.JLabel();
        campoNumTel1 = new javax.swing.JTextField();
        titleNumTel2 = new javax.swing.JLabel();
        campoNumTel2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        titleEstado = new javax.swing.JLabel();
        titleCep = new javax.swing.JLabel();
        campoCep = new javax.swing.JTextField();
        titleCidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        caixaCombinacaoEstado = new javax.swing.JComboBox<>();
        titleBairro = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        titleLograd = new javax.swing.JLabel();
        campoLograd = new javax.swing.JTextField();
        titleLogradNum = new javax.swing.JLabel();
        campoLogradNum = new javax.swing.JTextField();
        titleLogradComp = new javax.swing.JLabel();
        campoLogradComp = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        titleVeiculoTipo = new javax.swing.JLabel();
        campoVeiculoTipo = new javax.swing.JTextField();
        titleVeiculoFabricante = new javax.swing.JLabel();
        campoVeiculoFabricante = new javax.swing.JTextField();
        titleVeiculoModelo = new javax.swing.JLabel();
        campoVeiculoModelo = new javax.swing.JTextField();
        titleVeiculoPlaca = new javax.swing.JLabel();
        campoVeiculoPlaca = new javax.swing.JTextField();
        titleVeiculoAcessorios = new javax.swing.JLabel();
        titleVeiculoDefeitoCliente = new javax.swing.JLabel();
        campoVeiculoAcessorios = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        campoVeiculoDefeitoCliente = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        campoVeiculoObservacoes = new javax.swing.JTextArea();
        titleVeiculoObservacoes = new javax.swing.JLabel();
        titleVeiculoCor = new javax.swing.JLabel();
        campoVeiculoCor = new javax.swing.JTextField();
        titleVeiculoAno = new javax.swing.JLabel();
        campoVeiculoAno = new javax.swing.JTextField();
        titlePrevisaoSaida = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        campoPrevisaoSaida = new javax.swing.JTextField();
        painelOrcamento = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        titlePrecoPeca = new javax.swing.JLabel();
        campoPrecoPeca = new javax.swing.JTextField();
        cifrao = new javax.swing.JLabel();
        titleDescricaoPeca = new javax.swing.JLabel();
        campoDescricaoPeca = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        titlePrecoServico = new javax.swing.JLabel();
        campoPrecoServico = new javax.swing.JTextField();
        cifrao2 = new javax.swing.JLabel();
        titleDescricaoServico = new javax.swing.JLabel();
        campoDescricaoServico = new javax.swing.JTextField();
        titleDataNascimento = new javax.swing.JLabel();
        campoDataNascimento = new javax.swing.JTextField();
        txtErroDataNascimento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtErroPrevisaoSaida = new javax.swing.JLabel();
        txtErroLogradNum = new javax.swing.JLabel();
        txtErroEstado = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtErroCpfOuCnpj = new javax.swing.JLabel();
        txtErroRgOuIe = new javax.swing.JLabel();
        txtErroNomeOuRazao = new javax.swing.JLabel();
        txtErroSobrenomeOuFantasia = new javax.swing.JLabel();
        txtErroEmail = new javax.swing.JLabel();
        txtErroNumTel1 = new javax.swing.JLabel();
        txtErroNumTel2 = new javax.swing.JLabel();
        txtErroCep = new javax.swing.JLabel();
        txtErroCidade = new javax.swing.JLabel();
        txtErroBairro = new javax.swing.JLabel();
        txtErroLogradComp = new javax.swing.JLabel();
        txtErroLograd = new javax.swing.JLabel();
        txtErroVeiculoTipo = new javax.swing.JLabel();
        txtErroVeiculoFabricante = new javax.swing.JLabel();
        txtErroVeiculoModelo = new javax.swing.JLabel();
        txtErroVeiculoPlaca = new javax.swing.JLabel();
        txtErroVeiculoCor = new javax.swing.JLabel();
        txtErroVeiculoAcessorios = new javax.swing.JLabel();
        txtErroVeiculoAno = new javax.swing.JLabel();
        txtErroVeiculoObservacoes = new javax.swing.JLabel();
        txtErroVeiculoDefeitoCliente = new javax.swing.JLabel();
        txtErroDescricaoPeca = new javax.swing.JLabel();
        txtErroPrecoPeca = new javax.swing.JLabel();
        txtErroPrecoServico = new javax.swing.JLabel();
        txtErroDescricaoServico = new javax.swing.JLabel();
        txtErroCadastrar = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setIconImage(icon);
        setMinimumSize(new java.awt.Dimension(1368, 768));
        setPreferredSize(new java.awt.Dimension(1368, 768));

        painelSecoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 40, 40)), "Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

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
        btnIrUsuario.setToolTipText("");
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painelDeRolagem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)), "Formulário de cadastro de OS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        painelDeRolagem.setToolTipText("");

        titleNumeroOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleNumeroOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNumeroOS.setText("Número da OS: ");
        titleNumeroOS.setToolTipText("");

        txtNumeroOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNumeroOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNumeroOS.setText("...");

        titleCpfOuCnpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleCpfOuCnpj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCpfOuCnpj.setText("CPF ou CNPJ do cliente:");

        titleNomeOuRazao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleNomeOuRazao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNomeOuRazao.setText("Nome ou razão social:");

        campoCpfOuCnpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoCpfOuCnpj.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoCpfOuCnpj.setToolTipText("");
        campoCpfOuCnpj.setName("cpfnj"); // NOI18N
        campoCpfOuCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                verificarCliente(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaCpf(evt);
            }
        });

        campoNomeOuRazao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoNomeOuRazao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoNomeOuRazao.setName("campoNomeOuRazao"); // NOI18N
        campoNomeOuRazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaNomeOuRazao(evt);
            }
        });

        titleSobrenomeOuFantasia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleSobrenomeOuFantasia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSobrenomeOuFantasia.setText("Sobronome ou nome fantasia:");

        titleRgOuIe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleRgOuIe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleRgOuIe.setText("RG ou IE:");

        campoRgOuIe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoRgOuIe.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoRgOuIe.setName("campoRgOuIe"); // NOI18N
        campoRgOuIe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaRg(evt);
            }
        });

        campoSobrenomeOuFantasia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoSobrenomeOuFantasia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoSobrenomeOuFantasia.setName("campoSobrenomeOuFantasia"); // NOI18N
        campoSobrenomeOuFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaSobrenomeOuFantasia(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)), "Contato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titleEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleEmail.setText("Email do cliente:");

        campoEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaEmail(evt);
            }
        });

        titleNumTel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleNumTel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNumTel1.setText("Número de telefone principal:");

        campoNumTel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoNumTel1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoNumTel1.setName("tel1"); // NOI18N
        campoNumTel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaTel(evt);
            }
        });

        titleNumTel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleNumTel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleNumTel2.setText("Número de telefone alternativo:");

        campoNumTel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoNumTel2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoNumTel2.setName("tel2"); // NOI18N
        campoNumTel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaTel(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(titleEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleNumTel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleNumTel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoNumTel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNumTel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleEmail)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNumTel1)
                    .addComponent(campoNumTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNumTel2)
                    .addComponent(campoNumTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)), "Endereço", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titleEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleEstado.setText("Estado:");

        titleCep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleCep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCep.setText("CEP:");

        campoCep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoCep.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoCep.setName("cep"); // NOI18N
        campoCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaCep(evt);
            }
        });

        titleCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleCidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCidade.setText("Cidade:");

        campoCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoCidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladoCidade(evt);
            }
        });

        caixaCombinacaoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        caixaCombinacaoEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)));
        caixaCombinacaoEstado.setFocusable(false);

        titleBairro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleBairro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleBairro.setText("Bairro:");

        campoBairro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoBairro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaBairro(evt);
            }
        });

        titleLograd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLograd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLograd.setText("Logradouro:");

        campoLograd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoLograd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoLograd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaLograd(evt);
            }
        });

        titleLogradNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLogradNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogradNum.setText("N°:");

        campoLogradNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoLogradNum.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoLogradNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaLogradNum(evt);
            }
        });

        titleLogradComp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLogradComp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogradComp.setText("Complemento:");

        campoLogradComp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoLogradComp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoLogradComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaLogradComp(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(titleLograd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoLograd))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(titleEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caixaCombinacaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(titleCep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(titleCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(titleBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(titleLogradNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoLogradNum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleLogradComp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoLogradComp, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleEstado)
                    .addComponent(caixaCombinacaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleCep)
                    .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleCidade)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleBairro)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLograd)
                    .addComponent(campoLograd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLogradComp)
                        .addComponent(campoLogradComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLogradNum)
                        .addComponent(campoLogradNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)), "Veículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titleVeiculoTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoTipo.setText("Tipo:");

        campoVeiculoTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoTipo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoTipo(evt);
            }
        });

        titleVeiculoFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoFabricante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoFabricante.setText("Fabricante:");

        campoVeiculoFabricante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoFabricante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoFabricante(evt);
            }
        });

        titleVeiculoModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoModelo.setText("Modelo:");

        campoVeiculoModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoModelo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoModelo(evt);
            }
        });

        titleVeiculoPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoPlaca.setText("Placa:");

        campoVeiculoPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoPlaca.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaVeiculoPlaca(evt);
            }
        });

        titleVeiculoAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoAcessorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoAcessorios.setText("Acessórios:");

        titleVeiculoDefeitoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoDefeitoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoDefeitoCliente.setText("Defeito reclamado pelo cliente:");
        titleVeiculoDefeitoCliente.setToolTipText("");

        campoVeiculoAcessorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoAcessorios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoAcessorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoAcessorios(evt);
            }
        });

        campoVeiculoDefeitoCliente.setColumns(20);
        campoVeiculoDefeitoCliente.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        campoVeiculoDefeitoCliente.setRows(5);
        campoVeiculoDefeitoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoDefeitoCliente(evt);
            }
        });
        jScrollPane5.setViewportView(campoVeiculoDefeitoCliente);

        campoVeiculoObservacoes.setColumns(20);
        campoVeiculoObservacoes.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        campoVeiculoObservacoes.setRows(5);
        campoVeiculoObservacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoObservacoes(evt);
            }
        });
        jScrollPane6.setViewportView(campoVeiculoObservacoes);

        titleVeiculoObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoObservacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoObservacoes.setText("Observações:");
        titleVeiculoObservacoes.setToolTipText("");

        titleVeiculoCor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoCor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoCor.setText("Cor:");

        campoVeiculoCor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoCor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoCor(evt);
            }
        });

        titleVeiculoAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleVeiculoAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleVeiculoAno.setText("Ano:");

        campoVeiculoAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoVeiculoAno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoVeiculoAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaVeiculoAno(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(titleVeiculoModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleVeiculoPlaca)
                            .addComponent(titleVeiculoAcessorios)
                            .addComponent(titleVeiculoCor)
                            .addComponent(titleVeiculoAno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoVeiculoAcessorios)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoVeiculoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoVeiculoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleVeiculoObservacoes)
                            .addComponent(titleVeiculoDefeitoCliente))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(titleVeiculoFabricante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoVeiculoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(titleVeiculoTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoVeiculoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(212, 212, 212)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoTipo)
                    .addComponent(campoVeiculoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoFabricante)
                    .addComponent(campoVeiculoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoModelo)
                    .addComponent(campoVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoPlaca)
                    .addComponent(campoVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoCor)
                    .addComponent(campoVeiculoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoAno)
                    .addComponent(campoVeiculoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleVeiculoAcessorios)
                    .addComponent(campoVeiculoAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(titleVeiculoDefeitoCliente)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(titleVeiculoObservacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        titlePrevisaoSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titlePrevisaoSaida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePrevisaoSaida.setText("Previsão de saída:");

        btnCadastrar.setBackground(new java.awt.Color(204, 0, 0));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setName("btnCadastrar"); // NOI18N
        btnCadastrar.setOpaque(true);
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarDados(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPressionado(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSolto(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(204, 0, 0));
        btnLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setText("Limpar campos");
        btnLimparCampos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(130, 0, 0), new java.awt.Color(130, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        btnLimparCampos.setContentAreaFilled(false);
        btnLimparCampos.setFocusPainted(false);
        btnLimparCampos.setName("btnLimparCampos"); // NOI18N
        btnLimparCampos.setOpaque(true);
        btnLimparCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparDados(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPressionado(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSolto(evt);
            }
        });

        campoPrevisaoSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoPrevisaoSaida.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoPrevisaoSaida.setName("data"); // NOI18N
        campoPrevisaoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaPrevisaoSaida(evt);
            }
        });

        painelOrcamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 40, 40)), "Orçamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel6.setBackground(new java.awt.Color(220, 220, 220));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Peças", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titlePrecoPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titlePrecoPeca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePrecoPeca.setText("Preço da peça:");

        campoPrecoPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoPrecoPeca.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoPrecoPeca.setName("pecas"); // NOI18N
        campoPrecoPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaPrecoPeca(evt);
            }
        });

        cifrao.setText("R$");

        titleDescricaoPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDescricaoPeca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDescricaoPeca.setText("Descrição da peça:");

        campoDescricaoPeca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDescricaoPeca.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoDescricaoPeca.setName("orcamento"); // NOI18N
        campoDescricaoPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaDescricaoPecas(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(titlePrecoPeca)
                        .addGap(32, 32, 32)
                        .addComponent(cifrao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(titleDescricaoPeca)
                        .addGap(29, 29, 29)
                        .addComponent(campoDescricaoPeca)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePrecoPeca)
                    .addComponent(campoPrecoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleDescricaoPeca)
                    .addComponent(campoDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(220, 220, 220));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Serviços", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        titlePrecoServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titlePrecoServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePrecoServico.setText("Preço do serviço:");

        campoPrecoServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoPrecoServico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoPrecoServico.setName("servicos"); // NOI18N
        campoPrecoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaPrecoServico(evt);
            }
        });

        cifrao2.setText("R$");

        titleDescricaoServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDescricaoServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDescricaoServico.setText("Descrição da serviço:");

        campoDescricaoServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDescricaoServico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoDescricaoServico.setName("orcamento"); // NOI18N
        campoDescricaoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecladaDescricaoServico(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePrecoServico)
                    .addComponent(titleDescricaoServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cifrao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(campoDescricaoServico)))
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePrecoServico)
                    .addComponent(campoPrecoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifrao2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleDescricaoServico)
                    .addComponent(campoDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelOrcamentoLayout = new javax.swing.GroupLayout(painelOrcamento);
        painelOrcamento.setLayout(painelOrcamentoLayout);
        painelOrcamentoLayout.setHorizontalGroup(
            painelOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrcamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelOrcamentoLayout.setVerticalGroup(
            painelOrcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrcamentoLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDataNascimento.setText("Data de nascimento:");

        campoDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        campoDataNascimento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoDataNascimento.setName("data"); // NOI18N
        campoDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tecladaDataNascimento(evt);
            }
        });

        txtErroDataNascimento.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroDataNascimento.setText("jLabel1");

        javax.swing.GroupLayout painelDoFormularioLayout = new javax.swing.GroupLayout(painelDoFormulario);
        painelDoFormulario.setLayout(painelDoFormularioLayout);
        painelDoFormularioLayout.setHorizontalGroup(
            painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoFormularioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDoFormularioLayout.createSequentialGroup()
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDoFormularioLayout.createSequentialGroup()
                            .addComponent(titlePrevisaoSaida)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(painelOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(painelDoFormularioLayout.createSequentialGroup()
                            .addComponent(titleSobrenomeOuFantasia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoSobrenomeOuFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDoFormularioLayout.createSequentialGroup()
                            .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(titleNomeOuRazao)
                                .addComponent(titleRgOuIe)
                                .addComponent(titleCpfOuCnpj))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoNomeOuRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoCpfOuCnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(campoRgOuIe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                        .addGroup(painelDoFormularioLayout.createSequentialGroup()
                            .addComponent(titleNumeroOS)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(128, 128, 128)))
                    .addGroup(painelDoFormularioLayout.createSequentialGroup()
                        .addComponent(titleDataNascimento)
                        .addGap(43, 43, 43)
                        .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErroDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        painelDoFormularioLayout.setVerticalGroup(
            painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoFormularioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNumeroOS)
                    .addComponent(txtNumeroOS))
                .addGap(27, 27, 27)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleCpfOuCnpj)
                    .addComponent(campoCpfOuCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleRgOuIe)
                    .addComponent(campoRgOuIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNomeOuRazao)
                    .addComponent(campoNomeOuRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleSobrenomeOuFantasia)
                    .addComponent(campoSobrenomeOuFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleDataNascimento)
                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtErroDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePrevisaoSaida)
                    .addComponent(campoPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(painelDoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setMaximumSize(new java.awt.Dimension(302, 827));
        jPanel1.setMinimumSize(new java.awt.Dimension(302, 827));

        txtErroPrevisaoSaida.setForeground(new java.awt.Color(240, 240, 240));
        txtErroPrevisaoSaida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroPrevisaoSaida.setText("Jbalekkk");

        txtErroLogradNum.setForeground(new java.awt.Color(240, 240, 240));
        txtErroLogradNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroLogradNum.setText("jLabel1");

        txtErroEstado.setForeground(new java.awt.Color(240, 240, 240));
        txtErroEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtErroEstado.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtErroPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtErroLogradNum, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtErroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtErroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(txtErroLogradNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(534, 534, 534)
                .addComponent(txtErroPrevisaoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );

        txtErroCpfOuCnpj.setForeground(new java.awt.Color(240, 240, 240));
        txtErroCpfOuCnpj.setText("Digite letras ou números.");

        txtErroRgOuIe.setForeground(new java.awt.Color(240, 240, 240));
        txtErroRgOuIe.setText("Digite letras ou números.");

        txtErroNomeOuRazao.setForeground(new java.awt.Color(240, 240, 240));
        txtErroNomeOuRazao.setText("Digite letras ou números.");

        txtErroSobrenomeOuFantasia.setForeground(new java.awt.Color(240, 240, 240));
        txtErroSobrenomeOuFantasia.setText("Digite letras ou números.");

        txtErroEmail.setForeground(new java.awt.Color(240, 240, 240));
        txtErroEmail.setText("Digite letras ou números.");

        txtErroNumTel1.setForeground(new java.awt.Color(240, 240, 240));
        txtErroNumTel1.setText("Digite letras ou números.");

        txtErroNumTel2.setForeground(new java.awt.Color(240, 240, 240));
        txtErroNumTel2.setText("Digite letras ou números.");

        txtErroCep.setForeground(new java.awt.Color(240, 240, 240));
        txtErroCep.setText("Digite letras ou números.");

        txtErroCidade.setForeground(new java.awt.Color(240, 240, 240));
        txtErroCidade.setText("Digite letras ou números.");

        txtErroBairro.setForeground(new java.awt.Color(240, 240, 240));
        txtErroBairro.setText("Digite letras ou números.");

        txtErroLogradComp.setForeground(new java.awt.Color(240, 240, 240));
        txtErroLogradComp.setText("Digite letras ou números.");

        txtErroLograd.setForeground(new java.awt.Color(240, 240, 240));
        txtErroLograd.setText("Digite letras ou números.");

        txtErroVeiculoTipo.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoTipo.setText("Digite letras ou números.");

        txtErroVeiculoFabricante.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoFabricante.setText("Digite letras ou números.");

        txtErroVeiculoModelo.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoModelo.setText("Digite letras ou números.");

        txtErroVeiculoPlaca.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoPlaca.setText("Digite letras ou números.");

        txtErroVeiculoCor.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoCor.setText("Digite letras ou números.");

        txtErroVeiculoAcessorios.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoAcessorios.setText("Digite letras ou números.");

        txtErroVeiculoAno.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoAno.setText("Digite letras ou números.");

        txtErroVeiculoObservacoes.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoObservacoes.setText("Digite letras ou números.");

        txtErroVeiculoDefeitoCliente.setForeground(new java.awt.Color(240, 240, 240));
        txtErroVeiculoDefeitoCliente.setText("Digite letras ou números.");

        txtErroDescricaoPeca.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDescricaoPeca.setText("Digite letras ou números.");

        txtErroPrecoPeca.setForeground(new java.awt.Color(240, 240, 240));
        txtErroPrecoPeca.setText("Digite letras ou números.");

        txtErroPrecoServico.setForeground(new java.awt.Color(240, 240, 240));
        txtErroPrecoServico.setText("Digite letras ou números.");

        txtErroDescricaoServico.setForeground(new java.awt.Color(240, 240, 240));
        txtErroDescricaoServico.setText("Digite letras ou números.");

        txtErroCadastrar.setForeground(new java.awt.Color(240, 240, 240));
        txtErroCadastrar.setText("Digite letras ou números.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtErroRgOuIe)
                                    .addComponent(txtErroCpfOuCnpj)
                                    .addComponent(txtErroNomeOuRazao)
                                    .addComponent(txtErroSobrenomeOuFantasia)
                                    .addComponent(txtErroEmail)
                                    .addComponent(txtErroNumTel1)
                                    .addComponent(txtErroNumTel2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtErroCep)
                                        .addComponent(txtErroCidade)
                                        .addComponent(txtErroBairro)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtErroLograd)
                                    .addComponent(txtErroLogradComp)))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtErroVeiculoTipo)
                                .addComponent(txtErroVeiculoFabricante)
                                .addComponent(txtErroVeiculoModelo)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtErroVeiculoPlaca)
                                    .addComponent(txtErroVeiculoCor)))
                            .addComponent(txtErroVeiculoAno)
                            .addComponent(txtErroVeiculoAcessorios)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtErroVeiculoDefeitoCliente)
                                .addComponent(txtErroVeiculoObservacoes)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErroPrecoPeca)
                            .addComponent(txtErroDescricaoPeca)))
                    .addComponent(txtErroPrecoServico)
                    .addComponent(txtErroDescricaoServico)
                    .addComponent(txtErroCadastrar))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtErroCpfOuCnpj)
                .addGap(27, 27, 27)
                .addComponent(txtErroRgOuIe)
                .addGap(25, 25, 25)
                .addComponent(txtErroNomeOuRazao)
                .addGap(23, 23, 23)
                .addComponent(txtErroSobrenomeOuFantasia)
                .addGap(74, 74, 74)
                .addComponent(txtErroEmail)
                .addGap(18, 18, 18)
                .addComponent(txtErroNumTel1)
                .addGap(18, 18, 18)
                .addComponent(txtErroNumTel2)
                .addGap(43, 43, 43)
                .addComponent(txtErroCep)
                .addGap(18, 18, 18)
                .addComponent(txtErroCidade)
                .addGap(18, 18, 18)
                .addComponent(txtErroBairro)
                .addGap(18, 18, 18)
                .addComponent(txtErroLograd)
                .addGap(21, 21, 21)
                .addComponent(txtErroLogradComp)
                .addGap(46, 46, 46)
                .addComponent(txtErroVeiculoTipo)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoFabricante)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoModelo)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoPlaca)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoCor)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoAno)
                .addGap(18, 18, 18)
                .addComponent(txtErroVeiculoAcessorios)
                .addGap(70, 70, 70)
                .addComponent(txtErroVeiculoDefeitoCliente)
                .addGap(88, 88, 88)
                .addComponent(txtErroVeiculoObservacoes)
                .addGap(161, 161, 161)
                .addComponent(txtErroPrecoPeca)
                .addGap(18, 18, 18)
                .addComponent(txtErroDescricaoPeca)
                .addGap(65, 65, 65)
                .addComponent(txtErroPrecoServico)
                .addGap(18, 18, 18)
                .addComponent(txtErroDescricaoServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(txtErroCadastrar)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout painelDoScrollLayout = new javax.swing.GroupLayout(painelDoScroll);
        painelDoScroll.setLayout(painelDoScrollLayout);
        painelDoScrollLayout.setHorizontalGroup(
            painelDoScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoScrollLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDoFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        painelDoScrollLayout.setVerticalGroup(
            painelDoScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoScrollLayout.createSequentialGroup()
                .addGroup(painelDoScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelDoFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 246, Short.MAX_VALUE))
            .addGroup(painelDoScrollLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDeRolagem.setViewportView(painelDoScroll);

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
                        .addGap(6, 6, 6)
                        .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSecoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 1666, Short.MAX_VALUE)
                    .addComponent(painelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void irConsultaOS(java.awt.event.MouseEvent evt) {
        u.irDePara(this, getRUD_OS());
    }

    private void irRelatorios(java.awt.event.MouseEvent evt) {
        u.irDePara(this, getRELATORIO());
    }

    private void cadastrarDados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarDados
        /*
            MÉTODO RESPONSÁVEL POR CADASTRAR OS DADOS DO CLIENTE
         */
        btnClicado(evt);
        if (vazioForm() == true) {
            txtErroCadastrar.setText("Algum campo do formulário está vazio.");
            txtErroCadastrar.setForeground(new Color(255, 0, 0));
        } else if (erroForm()) {
            txtErroCadastrar.setText("Algum campo do formulário apresenta um erro.");
            txtErroCadastrar.setForeground(new Color(255, 0, 0));
        } else {
            Cliente cliente = new Cliente();
            cliente.setClienteCpfOuCnpj(fs.retirarFormatacao(campoCpfOuCnpj.getText()));
            cliente.setClienteRgOuIe(campoRgOuIe.getText());
            cliente.setClienteNomeOuRazao(campoNomeOuRazao.getText());
            cliente.setClienteSobrenomeOuFantasia(campoSobrenomeOuFantasia.getText());
            if (campoCpfOuCnpj.getText().length() > 14) {
                cliente.setClientePj(true);
            } else {
                cliente.setClientePj(false);
            }
            cliente.setClienteEndEstado(caixaCombinacaoEstado.getSelectedItem().toString());
            cliente.setClienteEndCep(fs.retirarFormatacao(campoCep.getText()));
            cliente.setClienteEndCidade(campoCidade.getText());
            cliente.setClienteEndBairro(campoBairro.getText());
            cliente.setClienteEndLograd(campoLograd.getText());
            cliente.setClienteEndLogradNum(campoLogradNum.getText());
            cliente.setClienteEndLogradComp(campoLogradComp.getText());
            if (campoDataNascimento.isEnabled()) {
                cliente.setClienteDataNasc(fs.retirarFormatacaoData(campoDataNascimento.getText()));
            } else {

            }

            Contato contato = new Contato();
            contato.setClienteContatoEmail(campoEmail.getText());
            contato.setClienteContatoNumTel1(fs.retirarFormatacao(campoNumTel1.getText()));
            contato.setClienteContatoNumTel2(fs.retirarFormatacao(campoNumTel2.getText()));

            OS os = new OS();
            os.setOsPrevisaoSaida(fs.retirarFormatacaoData(campoPrevisaoSaida.getText()));
            os.setOsNumero(txtNumeroOS.getText());

            Veiculo veiculo = new Veiculo();
            veiculo.setVeiculoTipo(campoVeiculoTipo.getText());
            veiculo.setVeiculoFabricante(campoVeiculoFabricante.getText());
            veiculo.setVeiculoModelo(campoVeiculoModelo.getText());
            veiculo.setVeiculoPlaca(campoVeiculoPlaca.getText());
            veiculo.setVeiculoCor(campoVeiculoCor.getText());
            veiculo.setVeiculoAno(campoVeiculoAno.getText());
            veiculo.setVeiculoAcessorios(campoVeiculoAcessorios.getText());
            veiculo.setVeiculoDefeitoCliente(campoVeiculoDefeitoCliente.getText());
            veiculo.setVeiculoObservacoes(campoVeiculoObservacoes.getText());

            Orcamento o = new Orcamento();
            o.setOrcamento_preco_pecas(fs.retirarFormatacaoDinheiro(campoPrecoPeca.getText()));
            o.setOrcamento_preco_servicos(fs.retirarFormatacaoDinheiro(campoPrecoServico.getText()));
            o.setOrcamento_descricao_pecas(fs.retirarFormatacaoDinheiro(campoDescricaoPeca.getText()));
            o.setOrcamento_descricao_servicos(fs.retirarFormatacaoDinheiro(campoDescricaoServico.getText()));

            CadastroDAO cadastrar = new CadastroDAO();
            if (campoRgOuIe.isEnabled()) {
                cadastrar.cadastrarDados(cliente, contato, veiculo, os, o, false);
            } else {
                cadastrar.cadastrarDados(cliente, contato, veiculo, os, o, true);
            }
            txtErroCadastrar.setForeground(new Color(0, 160, 40));
            txtErroCadastrar.setText("Usuário cadastrado com sucesso!");
            OsDAO osdao = new OsDAO();
            txtNumeroOS.setText(osdao.numeroOsAtual());
            limparCampos();
        }
    }//GEN-LAST:event_cadastrarDados

    private void btnPressionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPressionado
        evt.getComponent().setBackground(new Color(100, 0, 0));
    }//GEN-LAST:event_btnPressionado

    private void btnSolto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolto
        evt.getComponent().setBackground(new Color(204, 0, 0));
    }//GEN-LAST:event_btnSolto

    private void limparDados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparDados
        btnClicado(evt);
        limparCampos();
    }//GEN-LAST:event_limparDados

    //<editor-fold defaultstate="collapsed" desc="métodos teclados">
    private void tecladaRg(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaRg
        String txtV = vs.rgOuIe(evt, campoRgOuIe.getText());
        if (txtV == "") {
            txtErroRgOuIe.setForeground(new Color(240, 240, 240));
        } else {
            txtErroRgOuIe.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroRgOuIe.setForeground(new Color(255, 0, 0));
            } else {
                txtErroRgOuIe.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaRg

    private void tecladaNomeOuRazao(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaNomeOuRazao
        String txtV = vs.nomes30(evt, campoNomeOuRazao.getText());
        if (txtV == "") {
            txtErroNomeOuRazao.setForeground(new Color(240, 240, 240));
        } else {
            txtErroNomeOuRazao.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroNomeOuRazao.setForeground(new Color(255, 0, 0));
            } else {
                txtErroNomeOuRazao.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaNomeOuRazao

    private void tecladaSobrenomeOuFantasia(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaSobrenomeOuFantasia
        String txtV = vs.sobrenomeOuFantasia(evt, campoSobrenomeOuFantasia.getText());
        if (txtV == "") {
            txtErroSobrenomeOuFantasia.setForeground(new Color(240, 240, 240));
        } else {
            txtErroSobrenomeOuFantasia.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroSobrenomeOuFantasia.setForeground(new Color(255, 0, 0));
            } else {
                txtErroSobrenomeOuFantasia.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaSobrenomeOuFantasia

    private void tecladaEmail(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaEmail
        String txtV = vs.email(evt, campoEmail.getText());
        if (txtV == "") {
            txtErroEmail.setForeground(new Color(240, 240, 240));
        } else {
            txtErroEmail.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroEmail.setForeground(new Color(255, 0, 0));
            } else {
                txtErroEmail.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaEmail

    private void tecladaCpf(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaCpf
        /*
        SERVE PARA AS VERIFICAÇÕES E FORMATAÇÕES DE STRINGS
         */
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoCpfOuCnpj.setText(fs.apagar(campoCpfOuCnpj.getText(), evt.getComponent().getName()));
        }
        String txtV = vs.cpfOuCnpj(evt, campoCpfOuCnpj.getText());
        if (txtV == "") {
            txtErroCpfOuCnpj.setForeground(new Color(240, 240, 240));
        } else {
            txtErroCpfOuCnpj.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroCpfOuCnpj.setForeground(new Color(255, 0, 0));
            } else {
                txtErroCpfOuCnpj.setForeground(new Color(0, 160, 40));
            }
        }
        String txtF = fs.cpfOuCnpj(evt, campoCpfOuCnpj.getText());
        campoCpfOuCnpj.setText(txtF);
    }//GEN-LAST:event_tecladaCpf

    private void tecladaTel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaTel
        if ("tel1".equals(evt.getComponent().getName())) {
            if ("\b".equals(Character.toString(evt.getKeyChar()))) {
                campoNumTel1.setText(fs.apagar(campoNumTel1.getText(), evt.getComponent().getName()));
            }
            String txtV = vs.telefone(evt, campoNumTel1.getText());
            if (txtV == "") {
                txtErroNumTel1.setForeground(new Color(240, 240, 240));
            } else {
                txtErroNumTel1.setText(txtV);
                if (txtV.endsWith(".")) {
                    txtErroNumTel1.setForeground(new Color(255, 0, 0));
                } else {
                    txtErroNumTel1.setForeground(new Color(0, 160, 40));
                }
            }
            String txtF = fs.telefone1(evt, campoNumTel1.getText());
            campoNumTel1.setText(txtF);
        } else {
            if ("\b".equals(Character.toString(evt.getKeyChar()))) {
                campoNumTel2.setText(fs.apagar(campoNumTel2.getText(), evt.getComponent().getName()));
            }
            String txtV = vs.telefone(evt, campoNumTel2.getText());
            if (txtV == "") {
                txtErroNumTel2.setForeground(new Color(240, 240, 240));
            } else {
                txtErroNumTel2.setText(txtV);
                if (txtV.endsWith(".")) {
                    txtErroNumTel2.setForeground(new Color(255, 0, 0));
                } else {
                    txtErroNumTel2.setForeground(new Color(0, 160, 40));
                }
            }
            if (campoNumTel2.getText().length() == 0) {
                txtErroNumTel2.setForeground(new Color(240, 240, 240));
            }
            String txtF = fs.telefone2(evt, campoNumTel2.getText());
            campoNumTel2.setText(txtF);
        }
    }//GEN-LAST:event_tecladaTel

    private void tecladaCep(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaCep
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoCep.setText(fs.apagar(campoCep.getText(), evt.getComponent().getName()));
        }
        String txtV = vs.cep(evt, campoCep.getText());
        if (txtV == "") {
            txtErroCep.setForeground(new Color(240, 240, 240));
        } else {
            txtErroCep.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroCep.setForeground(new Color(255, 0, 0));
            } else {
                txtErroCep.setForeground(new Color(0, 160, 40));
            }
        }
        String txtF = fs.cep(campoCep.getText());
        campoCep.setText(txtF);
    }//GEN-LAST:event_tecladaCep

    private void tecladoCidade(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladoCidade
        String txtV = vs.nomes30(evt, campoCidade.getText());
        if (txtV == "") {
            txtErroCidade.setForeground(new Color(240, 240, 240));
        } else {
            txtErroCidade.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroCidade.setForeground(new Color(255, 0, 0));
            } else {
                txtErroCidade.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladoCidade

    private void tecladaBairro(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaBairro
        String txtV = vs.nomes30(evt, campoBairro.getText());
        if (txtV == "") {
            txtErroBairro.setForeground(new Color(240, 240, 240));
        } else {
            txtErroBairro.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroBairro.setForeground(new Color(255, 0, 0));
            } else {
                txtErroBairro.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaBairro

    private void tecladaLograd(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaLograd
        String txtV = vs.lograd(evt, campoLograd.getText());
        if (txtV == "") {
            txtErroLograd.setForeground(new Color(240, 240, 240));
        } else {
            txtErroLograd.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroLograd.setForeground(new Color(255, 0, 0));
            } else {
                txtErroLograd.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaLograd

    private void tecladaLogradNum(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaLogradNum
        String txtV = vs.logradNum(evt, campoLogradNum.getText());
        if (txtV == "") {
            txtErroLogradNum.setForeground(new Color(240, 240, 240));
        } else {
            txtErroLogradNum.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroLogradNum.setForeground(new Color(255, 0, 0));
            } else {
                txtErroLogradNum.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaLogradNum

    private void tecladaLogradComp(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaLogradComp
        String txtV = vs.nomes30(evt, campoLogradComp.getText());
        if (txtV == "") {
            txtErroLogradComp.setForeground(new Color(240, 240, 240));
        } else {
            txtErroLogradComp.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroLogradComp.setForeground(new Color(255, 0, 0));
            } else {
                txtErroLogradComp.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaLogradComp

    private void tecladaVeiculoTipo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoTipo
        String txtV = vs.veiculo25(evt, campoVeiculoTipo.getText());
        if (txtV == "") {
            txtErroVeiculoTipo.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoTipo.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoTipo.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoTipo.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoTipo

    private void tecladaVeiculoFabricante(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoFabricante
        String txtV = vs.veiculo25(evt, campoVeiculoFabricante.getText());
        if (txtV == "") {
            txtErroVeiculoFabricante.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoFabricante.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoFabricante.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoFabricante.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoFabricante

    private void tecladaVeiculoModelo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoModelo
        String txtV = vs.veiculoModelo(evt, campoVeiculoModelo.getText());
        if (txtV == "") {
            txtErroVeiculoModelo.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoModelo.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoModelo.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoModelo.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoModelo

    private void tecladaVeiculoPlaca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoPlaca
        String txtV = vs.veiculoPlaca(evt, campoVeiculoPlaca.getText());
        if (txtV == "") {
            txtErroVeiculoPlaca.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoPlaca.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoPlaca.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoPlaca.setForeground(new Color(0, 160, 40));
            }
        }
        if (campoVeiculoPlaca.getText().length() > 7) {
            int calc = campoVeiculoPlaca.getText().length() - 7;
            campoVeiculoPlaca.setText(campoVeiculoPlaca.getText().substring(0, campoVeiculoPlaca.getText().length() - calc));
        }
        String txtF = fs.placa(campoVeiculoPlaca.getText());
        campoVeiculoPlaca.setText(txtF);
    }//GEN-LAST:event_tecladaVeiculoPlaca

    private void tecladaVeiculoCor(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoCor
        String txtV = vs.veiculo25(evt, campoVeiculoCor.getText());
        if (txtV == "") {
            txtErroVeiculoCor.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoCor.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoCor.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoCor.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoCor

    private void tecladaVeiculoAno(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoAno
        String txtV = vs.veiculoAno(evt, campoVeiculoAno.getText());
        if (vs.veiculoAno(evt, campoVeiculoAno.getText()) == "") {
            txtErroVeiculoAno.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoAno.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoAno.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoAno.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoAno

    private void tecladaVeiculoAcessorios(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoAcessorios
        String txtV = vs.veiculo255(evt, campoVeiculoAcessorios.getText());
        if (vs.veiculo255(evt, campoVeiculoAcessorios.getText()) == "") {
            txtErroVeiculoAcessorios.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoAcessorios.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoAcessorios.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoAcessorios.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoAcessorios

    private void tecladaVeiculoObservacoes(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoObservacoes
        String txtV = vs.veiculo255(evt, campoVeiculoObservacoes.getText());
        if (vs.veiculo255(evt, campoVeiculoObservacoes.getText()) == "") {
            txtErroVeiculoObservacoes.setForeground(new Color(240, 240, 240));
        } else {
            txtErroVeiculoObservacoes.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroVeiculoObservacoes.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoObservacoes.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoObservacoes

    private void tecladaPrecoPeca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrecoPeca
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoPrecoPeca.setText(fs.apagar(campoPrecoPeca.getText(), evt.getComponent().getName()));
        }
        String txt = vs.orcamento(evt, campoPrecoPeca.getText());
        if ("".equals(txt)) {
            if (campoPrecoPeca.getText().length() >= 10) {
                evt.consume();
                txtErroPrecoPeca.setForeground(new Color(255, 0, 0));
                txtErroPrecoPeca.setText("Tamanho máximo atingido.");
            } else {
                txtErroPrecoPeca.setForeground(new Color(240, 240, 240));
                String txtF = fs.dinheiro(evt, campoPrecoPeca.getText());
                campoPrecoPeca.setText(txtF);
            }
        } else {
            txtErroPrecoPeca.setText(txt);
            if (txt.endsWith("números.")) {
                txtErroPrecoPeca.setForeground(new Color(255, 0, 0));
            }
        }
    }//GEN-LAST:event_tecladaPrecoPeca

    private void tecladaPrevisaoSaida(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrevisaoSaida
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoPrevisaoSaida.setText(fs.apagar(campoPrevisaoSaida.getText(), evt.getComponent().getName()));
        }
        String txtV = vs.data(evt, campoPrevisaoSaida.getText());
        if (txtV == "") {
            txtErroPrevisaoSaida.setForeground(new Color(240, 240, 240));
        } else if (txtV.endsWith("números.")) {
            campoPrevisaoSaida.setText(campoPrevisaoSaida.getText().substring(0, campoPrevisaoSaida.getText().length() - 1));
        } else {
            txtErroPrevisaoSaida.setText(txtV);
            if (txtV.endsWith(".")) {
                txtErroPrevisaoSaida.setForeground(new Color(255, 0, 0));
            } else {
                txtErroPrevisaoSaida.setForeground(new Color(0, 160, 40));
            }
        }
        if (campoPrevisaoSaida.getText().length() > 10) {
            int calc = campoPrevisaoSaida.getText().length() - 10;
            campoPrevisaoSaida.setText(campoPrevisaoSaida.getText().substring(0, campoPrevisaoSaida.getText().length() - calc));
        }
        String txtF = fs.data(campoPrevisaoSaida.getText());
        campoPrevisaoSaida.setText(txtF);
    }//GEN-LAST:event_tecladaPrevisaoSaida

    private void tecladaVeiculoDefeitoCliente(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaVeiculoDefeitoCliente
        if (vs.veiculo255(evt, campoVeiculoDefeitoCliente.getText()) == "") {
            txtErroVeiculoDefeitoCliente.setForeground(new Color(240, 240, 240));
        } else {
            String txt = vs.veiculo255(evt, campoVeiculoDefeitoCliente.getText());
            txtErroVeiculoDefeitoCliente.setText(txt);
            if (txt.endsWith(".")) {
                txtErroVeiculoDefeitoCliente.setForeground(new Color(255, 0, 0));
            } else {
                txtErroVeiculoDefeitoCliente.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaVeiculoDefeitoCliente
    //</editor-fold>

    private void verificarCliente(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificarCliente
        if (campoCpfOuCnpj.getText().length() == 14 || campoCpfOuCnpj.getText().length() == 18) {
            if (vs.isCPF(campoCpfOuCnpj.getText()) || vs.isCNPJ(campoCpfOuCnpj.getText())){
                ClienteDAO cdao = new ClienteDAO();
                Cliente c = new Cliente();
                c = cdao.consultarCliente(campoCpfOuCnpj.getText());
                if (c.getClienteEndEstado() != null) {
                    ContatoDAO cttdao = new ContatoDAO();
                    Contato ctt = new Contato();
                    ctt = cttdao.consultarContato(c.getClienteCpfOuCnpj());
                    campoDataNascimento.setEnabled(false);
                    campoDataNascimento.setText(fs.botarData(c.getClienteDataNasc()));
                    campoRgOuIe.setEnabled(false);
                    campoRgOuIe.setText(c.getClienteRgOuIe());
                    campoNomeOuRazao.setEnabled(false);
                    campoNomeOuRazao.setText(c.getClienteNomeOuRazao());
                    campoSobrenomeOuFantasia.setEnabled(false);
                    campoSobrenomeOuFantasia.setText(c.getClienteSobrenomeOuFantasia());
                    campoEmail.setEnabled(false);
                    campoEmail.setText(ctt.getClienteContatoEmail());
                    campoNumTel1.setEnabled(false);
                    campoNumTel1.setText(fs.botarTelefone(ctt.getClienteContatoNumTel1()));
                    campoNumTel2.setEnabled(false);
                    if (ctt.getClienteContatoNumTel2() == null) {
                        campoNumTel2.setText("-");
                    } else {
                        campoNumTel2.setText(fs.botarTelefone(ctt.getClienteContatoNumTel2()));
                    }
                    caixaCombinacaoEstado.setEnabled(false);
                    caixaCombinacaoEstado.setSelectedIndex(vs.verificarEstado(c.getClienteEndEstado()));
                    campoCep.setEnabled(false);
                    campoCep.setText(fs.botarCep(c.getClienteEndCep()));
                    campoCidade.setEnabled(false);
                    campoCidade.setText(c.getClienteEndCidade());
                    campoBairro.setEnabled(false);
                    campoBairro.setText(c.getClienteEndBairro());
                    campoLograd.setEnabled(false);
                    campoLograd.setText(c.getClienteEndLograd());
                    campoLogradNum.setEnabled(false);
                    campoLogradNum.setText(c.getClienteEndLogradNum());
                    campoLogradComp.setEnabled(false);
                    campoLogradComp.setText(c.getClienteEndLogradComp());
                    txtErroCpfOuCnpj.setForeground(new Color(0, 160, 40));
                    txtErroCpfOuCnpj.setText("Cliente já cadastrado!");
                } else {
                    //nada
                }
            } else{
                txtErroCpfOuCnpj.setText("Dígito verificador não condiz.");
                txtErroCpfOuCnpj.setForeground(Color.RED);
            }
        } else {
            campoDataNascimento.setEnabled(true);
            campoDataNascimento.setText("");
            campoRgOuIe.setEnabled(true);
            campoRgOuIe.setText("");
            campoNomeOuRazao.setEnabled(true);
            campoNomeOuRazao.setText("");
            campoSobrenomeOuFantasia.setEnabled(true);
            campoSobrenomeOuFantasia.setText("");
            campoEmail.setEnabled(true);
            campoEmail.setText("");
            campoNumTel1.setEnabled(true);
            campoNumTel1.setText("");
            campoNumTel2.setEnabled(true);
            campoNumTel2.setText("");
            caixaCombinacaoEstado.setEnabled(true);
            caixaCombinacaoEstado.setSelectedIndex(0);
            campoCep.setEnabled(true);
            campoCep.setText("");
            campoCidade.setEnabled(true);
            campoCidade.setText("");
            campoBairro.setEnabled(true);
            campoBairro.setText("");
            campoLograd.setEnabled(true);
            campoLograd.setText("");
            campoLogradNum.setEnabled(true);
            campoLogradNum.setText("");
            campoLogradComp.setEnabled(true);
            campoLogradComp.setText("");
        }
    }//GEN-LAST:event_verificarCliente

    //<editor-fold defaultstate="collapsed" desc="métodos teclados">
    private void tecladaDescricaoPecas(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDescricaoPecas
        if (vs.nome30(evt, campoDescricaoPeca.getText()) == "") {
            txtErroPrecoPeca.setForeground(new Color(240, 240, 240));
        } else {
            String txt = vs.nome30(evt, campoDescricaoPeca.getText());
            txtErroPrecoPeca.setText(txt);
            if (txt.endsWith(".")) {
                txtErroPrecoPeca.setForeground(new Color(255, 0, 0));
            } else {
                txtErroPrecoPeca.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaDescricaoPecas

    private void tecladaPrecoServico(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaPrecoServico
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoPrecoServico.setText(fs.apagar(campoPrecoServico.getText(), evt.getComponent().getName()));
        }
        String txt = vs.orcamento(evt, campoPrecoServico.getText());
        if ("".equals(txt)) {
            if (campoPrecoServico.getText().length() >= 10) {
                evt.consume();
                txtErroPrecoServico.setForeground(new Color(255, 0, 0));
                txtErroPrecoServico.setText("Tamanho máximo atingido.");
            } else {
                txtErroPrecoServico.setForeground(new Color(240, 240, 240));
                String txtF = fs.dinheiro(evt, campoPrecoServico.getText());
                campoPrecoServico.setText(txtF);
            }
        } else {
            txtErroPrecoServico.setText(txt);
            if (txt.endsWith("números.")) {
                txtErroPrecoServico.setForeground(new Color(255, 0, 0));
            }
        }
    }//GEN-LAST:event_tecladaPrecoServico

    private void tecladaDescricaoServico(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDescricaoServico
        if (vs.nome30(evt, campoDescricaoServico.getText()) == "") {
            txtErroPrecoServico.setForeground(new Color(240, 240, 240));
        } else {
            String txt = vs.nome30(evt, campoDescricaoServico.getText());
            txtErroPrecoServico.setText(txt);
            if (txt.endsWith(".")) {
                txtErroPrecoServico.setForeground(new Color(255, 0, 0));
            } else {
                txtErroPrecoServico.setForeground(new Color(0, 160, 40));
            }
        }
    }//GEN-LAST:event_tecladaDescricaoServico

    private void tecladaDataNascimento(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladaDataNascimento
        if ("\b".equals(Character.toString(evt.getKeyChar()))) {
            campoDataNascimento.setText(fs.apagar(campoDataNascimento.getText(), evt.getComponent().getName()));
        }
        if (campoCpfOuCnpj.getText().length() == 14) {
            String txtV = vs.dataNasc(evt, campoDataNascimento.getText());
            if (txtV == "") {
                txtErroDataNascimento.setForeground(new Color(240, 240, 240));
            } else if (txtV.endsWith("números.")) {
                campoDataNascimento.setText(campoDataNascimento.getText().substring(0, campoDataNascimento.getText().length() - 1));
            } else {
                txtErroDataNascimento.setText(txtV);
                if (txtV.endsWith(".")) {
                    txtErroDataNascimento.setForeground(new Color(255, 0, 0));
                } else {
                    txtErroDataNascimento.setForeground(new Color(0, 160, 40));
                }
            }
            if (campoDataNascimento.getText().length() > 10) {
                int calc = campoDataNascimento.getText().length() - 10;
                campoDataNascimento.setText(campoDataNascimento.getText().substring(0, campoDataNascimento.getText().length() - calc));
            }
        } else if (campoCpfOuCnpj.getText().length() == 18) {
            String txtV = vs.dataNascCnpj(evt, campoDataNascimento.getText());
            if (txtV == "") {
                txtErroDataNascimento.setForeground(new Color(240, 240, 240));
            } else if (txtV.endsWith("números.")) {
                campoDataNascimento.setText(campoDataNascimento.getText().substring(0, campoDataNascimento.getText().length() - 1));
            } else {
                txtErroDataNascimento.setText(txtV);
                if (txtV.endsWith(".")) {
                    txtErroDataNascimento.setForeground(new Color(255, 0, 0));
                } else {
                    txtErroDataNascimento.setForeground(new Color(0, 160, 40));
                }
            }
            if (campoDataNascimento.getText().length() > 10) {
                int calc = campoDataNascimento.getText().length() - 10;
                campoDataNascimento.setText(campoDataNascimento.getText().substring(0, campoDataNascimento.getText().length() - calc));
            }
        }
        String txt = fs.data(campoDataNascimento.getText());
        campoDataNascimento.setText(txt);
    }//GEN-LAST:event_tecladaDataNascimento

    private void irInfoUser(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irInfoUser
        if (!userAberto) {
            USER_TELA = new USER_TELA();
            u.irDePara(this, USER_TELA);
            C_OS_TELA.setUSER_TELA(USER_TELA);
            userAberto = true;
        } else {
            u.irDePara(this, getUSER_TELA());
        }
    }//GEN-LAST:event_irInfoUser

    private void irCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroOS
        //        u.irDePara(this, C_OS_TELA.getC_OS());
    }//GEN-LAST:event_irCadastroOS
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
            java.util.logging.Logger.getLogger(C_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_OS_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
    }

    //<editor-fold defaultstate="collapsed" desc="Coisas do javax">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnIrUsuario;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JComboBox<String> caixaCombinacaoEstado;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCep;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoCpfOuCnpj;
    private javax.swing.JTextField campoDataNascimento;
    private javax.swing.JTextField campoDescricaoPeca;
    private javax.swing.JTextField campoDescricaoServico;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoLograd;
    private javax.swing.JTextField campoLogradComp;
    private javax.swing.JTextField campoLogradNum;
    private javax.swing.JTextField campoNomeOuRazao;
    private javax.swing.JTextField campoNumTel1;
    private javax.swing.JTextField campoNumTel2;
    private javax.swing.JTextField campoPrecoPeca;
    private javax.swing.JTextField campoPrecoServico;
    private javax.swing.JTextField campoPrevisaoSaida;
    private javax.swing.JTextField campoRgOuIe;
    private javax.swing.JTextField campoSobrenomeOuFantasia;
    private javax.swing.JTextField campoVeiculoAcessorios;
    private javax.swing.JTextField campoVeiculoAno;
    private javax.swing.JTextField campoVeiculoCor;
    private javax.swing.JTextArea campoVeiculoDefeitoCliente;
    private javax.swing.JTextField campoVeiculoFabricante;
    private javax.swing.JTextField campoVeiculoModelo;
    private javax.swing.JTextArea campoVeiculoObservacoes;
    private javax.swing.JTextField campoVeiculoPlaca;
    private javax.swing.JTextField campoVeiculoTipo;
    private javax.swing.JLabel cifrao;
    private javax.swing.JLabel cifrao2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel painelCRUD;
    private javax.swing.JScrollPane painelDeRolagem;
    private javax.swing.JPanel painelDoFormulario;
    private javax.swing.JPanel painelDoScroll;
    private javax.swing.JPanel painelOrcamento;
    private javax.swing.JPanel painelSecoes;
    private javax.swing.JLabel titleBairro;
    private javax.swing.JLabel titleCep;
    private javax.swing.JLabel titleCidade;
    private javax.swing.JLabel titleCpfOuCnpj;
    private javax.swing.JLabel titleDataNascimento;
    private javax.swing.JLabel titleDescricaoPeca;
    private javax.swing.JLabel titleDescricaoServico;
    private javax.swing.JLabel titleEmail;
    private javax.swing.JLabel titleEstado;
    private javax.swing.JLabel titleLograd;
    private javax.swing.JLabel titleLogradComp;
    private javax.swing.JLabel titleLogradNum;
    private javax.swing.JLabel titleNomeOuRazao;
    private javax.swing.JLabel titleNumTel1;
    private javax.swing.JLabel titleNumTel2;
    private javax.swing.JLabel titleNumeroOS;
    private javax.swing.JLabel titlePrecoPeca;
    private javax.swing.JLabel titlePrecoServico;
    private javax.swing.JLabel titlePrevisaoSaida;
    private javax.swing.JLabel titleRgOuIe;
    private javax.swing.JLabel titleSobrenomeOuFantasia;
    private javax.swing.JLabel titleVeiculoAcessorios;
    private javax.swing.JLabel titleVeiculoAno;
    private javax.swing.JLabel titleVeiculoCor;
    private javax.swing.JLabel titleVeiculoDefeitoCliente;
    private javax.swing.JLabel titleVeiculoFabricante;
    private javax.swing.JLabel titleVeiculoModelo;
    private javax.swing.JLabel titleVeiculoObservacoes;
    private javax.swing.JLabel titleVeiculoPlaca;
    private javax.swing.JLabel titleVeiculoTipo;
    private javax.swing.JLabel txtErroBairro;
    private javax.swing.JLabel txtErroCadastrar;
    private javax.swing.JLabel txtErroCep;
    private javax.swing.JLabel txtErroCidade;
    private javax.swing.JLabel txtErroCpfOuCnpj;
    private javax.swing.JLabel txtErroDataNascimento;
    private javax.swing.JLabel txtErroDescricaoPeca;
    private javax.swing.JLabel txtErroDescricaoServico;
    private javax.swing.JLabel txtErroEmail;
    private javax.swing.JLabel txtErroEstado;
    private javax.swing.JLabel txtErroLograd;
    private javax.swing.JLabel txtErroLogradComp;
    private javax.swing.JLabel txtErroLogradNum;
    private javax.swing.JLabel txtErroNomeOuRazao;
    private javax.swing.JLabel txtErroNumTel1;
    private javax.swing.JLabel txtErroNumTel2;
    private javax.swing.JLabel txtErroPrecoPeca;
    private javax.swing.JLabel txtErroPrecoServico;
    private javax.swing.JLabel txtErroPrevisaoSaida;
    private javax.swing.JLabel txtErroRgOuIe;
    private javax.swing.JLabel txtErroSobrenomeOuFantasia;
    private javax.swing.JLabel txtErroVeiculoAcessorios;
    private javax.swing.JLabel txtErroVeiculoAno;
    private javax.swing.JLabel txtErroVeiculoCor;
    private javax.swing.JLabel txtErroVeiculoDefeitoCliente;
    private javax.swing.JLabel txtErroVeiculoFabricante;
    private javax.swing.JLabel txtErroVeiculoModelo;
    private javax.swing.JLabel txtErroVeiculoObservacoes;
    private javax.swing.JLabel txtErroVeiculoPlaca;
    private javax.swing.JLabel txtErroVeiculoTipo;
    private static javax.swing.JLabel txtNumeroOS;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    private void limparCampos() {
        /*
            MÉTODO REPSONSÁVEL POR LIMPAR OS CAMPOS
         */
        campoDataNascimento.setText("");
        campoCpfOuCnpj.setText("");
        campoRgOuIe.setText("");
        campoNomeOuRazao.setText("");
        campoSobrenomeOuFantasia.setText("");
        campoEmail.setText("");
        campoNumTel1.setText("");
        campoNumTel2.setText("");
        caixaCombinacaoEstado.setSelectedIndex(0);
        campoCep.setText("");
        campoCidade.setText("");
        campoBairro.setText("");
        campoLograd.setText("");
        campoLogradNum.setText("");
        campoLogradComp.setText("");
        campoVeiculoTipo.setText("");
        campoVeiculoFabricante.setText("");
        campoVeiculoModelo.setText("");
        campoVeiculoPlaca.setText("");
        campoVeiculoCor.setText("");
        campoVeiculoAno.setText("");
        campoVeiculoAcessorios.setText("");
        campoVeiculoDefeitoCliente.setText("");
        campoPrevisaoSaida.setText("");
        campoVeiculoObservacoes.setText("");
        campoPrecoPeca.setText("");
        campoPrecoServico.setText("");
        campoDescricaoPeca.setText("");
        campoDescricaoServico.setText("");
        txtErroBairro.setForeground(new Color(240, 240, 240));
        txtErroCep.setForeground(new Color(240, 240, 240));
        txtErroCidade.setForeground(new Color(240, 240, 240));
        txtErroCpfOuCnpj.setForeground(new Color(240, 240, 240));
        txtErroDataNascimento.setForeground(new Color(240, 240, 240));
        txtErroEmail.setForeground(new Color(240, 240, 240));
        txtErroLograd.setForeground(new Color(240, 240, 240));
        txtErroLogradComp.setForeground(new Color(240, 240, 240));
        txtErroLogradNum.setForeground(new Color(240, 240, 240));
        txtErroNomeOuRazao.setForeground(new Color(240, 240, 240));
        txtErroNumTel1.setForeground(new Color(240, 240, 240));
        txtErroNumTel2.setForeground(new Color(240, 240, 240));
        txtErroPrecoPeca.setForeground(new Color(240, 240, 240));
        txtErroPrecoServico.setForeground(new Color(240, 240, 240));
        txtErroDescricaoPeca.setForeground(new Color(240, 240, 240));
        txtErroDescricaoServico.setForeground(new Color(240, 240, 240));
        txtErroPrevisaoSaida.setForeground(new Color(240, 240, 240));
        txtErroRgOuIe.setForeground(new Color(240, 240, 240));
        txtErroSobrenomeOuFantasia.setForeground(new Color(240, 240, 240));
        txtErroVeiculoAcessorios.setForeground(new Color(240, 240, 240));
        txtErroVeiculoAno.setForeground(new Color(240, 240, 240));
        txtErroVeiculoCor.setForeground(new Color(240, 240, 240));
        txtErroVeiculoDefeitoCliente.setForeground(new Color(240, 240, 240));
        txtErroVeiculoFabricante.setForeground(new Color(240, 240, 240));
        txtErroVeiculoModelo.setForeground(new Color(240, 240, 240));
        txtErroVeiculoObservacoes.setForeground(new Color(240, 240, 240));
        txtErroVeiculoPlaca.setForeground(new Color(240, 240, 240));
        txtErroVeiculoTipo.setForeground(new Color(240, 240, 240));
    }

    private void btnClicado(java.awt.event.MouseEvent evt) {
        evt.getComponent().setBackground(new Color(100, 0, 0));
        new Timer().schedule(
                new TimerTask() {
            @Override
            public void run() {
                evt.getComponent().setBackground(new Color(204, 0, 0));
            }
        }, 50);
    }

    private boolean vazioForm() {
        boolean vazio = true;
        if (campoDataNascimento.getText().equals("")
                || campoCpfOuCnpj.getText().equals("")
                || campoCpfOuCnpj.getText().equals("")
                || campoRgOuIe.getText().equals("")
                || campoNomeOuRazao.getText().equals("")
                || campoSobrenomeOuFantasia.getText().equals("")
                || campoEmail.getText().equals("")
                || campoNumTel1.getText().equals("")
                || caixaCombinacaoEstado.getSelectedIndex() == 0
                || campoCep.getText().equals("")
                || campoCidade.getText().equals("")
                || campoBairro.getText().equals("")
                || campoLograd.getText().equals("")
                || campoLogradNum.getText().equals("")
                || campoLogradComp.getText().equals("")
                || campoVeiculoTipo.getText().equals("")
                || campoVeiculoFabricante.getText().equals("")
                || campoVeiculoModelo.getText().equals("")
                || campoVeiculoPlaca.getText().equals("")
                || campoVeiculoCor.getText().equals("")
                || campoVeiculoAno.getText().equals("")
                || campoVeiculoAcessorios.getText().equals("")
                || campoVeiculoDefeitoCliente.getText().equals("")
                || campoPrevisaoSaida.getText().equals("")
                || campoVeiculoObservacoes.getText().equals("")) {
            vazio = true;
            return vazio;
        } 
        else{
            vazio = false;
        }
        if (campoPrecoPeca.getText().equals("") && campoPrecoServico.getText().equals("")) {
            vazio = true;
        } else if (campoPrecoPeca.getText().equals("")) {
            if (campoDescricaoServico.getText().equals("")) {
                vazio = true;
            }
        } else if (campoPrecoServico.getText().equals("")) {
            if (campoDescricaoPeca.getText().equals("")) {
                vazio = true;
            }
        } else if (!campoPrecoPeca.getText().equals("") && !campoPrecoServico.getText().equals("")
                && !campoDescricaoServico.getText().equals("") && !campoDescricaoPeca.getText().equals("")) {
            vazio = false;
        } else {
            vazio = true;
        }
        return vazio;
    }

    private boolean erroForm() {
        boolean erro;
        if (txtErroDataNascimento.getForeground().getRed() == 255
                || txtErroBairro.getForeground().getRed() == 255
                || txtErroCep.getForeground().getRed() == 255
                || txtErroCidade.getForeground().getRed() == 255
                || txtErroCpfOuCnpj.getForeground().getRed() == 255
                || txtErroEmail.getForeground().getRed() == 255
                || txtErroLograd.getForeground().getRed() == 255
                || txtErroLogradComp.getForeground().getRed() == 255
                || txtErroLogradNum.getForeground().getRed() == 255
                || txtErroNomeOuRazao.getForeground().getRed() == 255
                || txtErroNumTel1.getForeground().getRed() == 255
                || txtErroNumTel2.getForeground().getRed() == 255
                || txtErroPrecoPeca.getForeground().getRed() == 255
                || txtErroPrecoServico.getForeground().getRed() == 255
                || txtErroDescricaoPeca.getForeground().getRed() == 255
                || txtErroDescricaoServico.getForeground().getRed() == 255
                || txtErroPrevisaoSaida.getForeground().getRed() == 255
                || txtErroRgOuIe.getForeground().getRed() == 255
                || txtErroSobrenomeOuFantasia.getForeground().getRed() == 255
                || txtErroVeiculoAcessorios.getForeground().getRed() == 255
                || txtErroVeiculoAno.getForeground().getRed() == 255
                || txtErroVeiculoCor.getForeground().getRed() == 255
                || txtErroVeiculoDefeitoCliente.getForeground().getRed() == 255
                || txtErroVeiculoFabricante.getForeground().getRed() == 255
                || txtErroVeiculoModelo.getForeground().getRed() == 255
                || txtErroVeiculoObservacoes.getForeground().getRed() == 255
                || txtErroVeiculoPlaca.getForeground().getRed() == 255
                || txtErroVeiculoTipo.getForeground().getRed() == 255) {
            erro = true;
        } else {
            erro = false;
        }
        return erro;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS;

/**
 *
 * @author arthu
 */
public class RELATORIO_TELA extends javax.swing.JFrame {
    
    TelaUtils u = new TelaUtils();
    boolean rudAberto;
    
    /**
     * Creates new form RELATORIO_TELA
     */
    public RELATORIO_TELA() {
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

        painelSecoes = new javax.swing.JPanel();
        btnIrOS = new javax.swing.JButton();
        btnIrUsuario = new javax.swing.JButton();
        painelCRUD = new javax.swing.JPanel();
        painelOpcoesCRUD = new javax.swing.JPanel();
        btnIrRelatorios = new javax.swing.JButton();
        btnIrCadastroOS = new javax.swing.JButton();
        btnIrConsultaOS = new javax.swing.JButton();
        painelFormularioConsulta = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                btnIrOSirCadastroOS(evt);
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
                btnIrUsuarioirInfoUser(evt);
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

        btnIrRelatorios.setBackground(new java.awt.Color(100, 0, 0));
        btnIrRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        btnIrRelatorios.setText("Consultar relatórios de venda");
        btnIrRelatorios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 0, 0)));
        btnIrRelatorios.setBorderPainted(false);
        btnIrRelatorios.setContentAreaFilled(false);
        btnIrRelatorios.setFocusPainted(false);
        btnIrRelatorios.setOpaque(true);
        btnIrRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irRelatorios(evt);
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

        javax.swing.GroupLayout painelOpcoesCRUDLayout = new javax.swing.GroupLayout(painelOpcoesCRUD);
        painelOpcoesCRUD.setLayout(painelOpcoesCRUDLayout);
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

        javax.swing.GroupLayout painelCRUDLayout = new javax.swing.GroupLayout(painelCRUD);
        painelCRUD.setLayout(painelCRUDLayout);
        painelCRUDLayout.setHorizontalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelOpcoesCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelCRUDLayout.setVerticalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDLayout.createSequentialGroup()
                .addComponent(painelOpcoesCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 194, Short.MAX_VALUE))
        );

        painelFormularioConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 35, 35)), "Formulário de consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout painelFormularioConsultaLayout = new javax.swing.GroupLayout(painelFormularioConsulta);
        painelFormularioConsulta.setLayout(painelFormularioConsultaLayout);
        painelFormularioConsultaLayout.setHorizontalGroup(
            painelFormularioConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        painelFormularioConsultaLayout.setVerticalGroup(
            painelFormularioConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnIrOSirCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIrOSirCadastroOS
        u.irDePara(this, C_OS_TELA.getC_OS());
    }//GEN-LAST:event_btnIrOSirCadastroOS

    private void btnIrUsuarioirInfoUser(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIrUsuarioirInfoUser
        u.irDePara(this, new USER_TELA());
    }//GEN-LAST:event_btnIrUsuarioirInfoUser

    private void irRelatorios(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irRelatorios
       
    }//GEN-LAST:event_irRelatorios

    private void irConsultaOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irConsultaOS
        if (!rudAberto){
            RUD_OS = new RUD_OS_TELA();
            u.irDePara(this, RUD_OS);
            C_OS_TELA.setRUD_OS(RUD_OS);
            rudAberto = true;
        } else {
            u.irDePara(this, getRUD_OS());
        }
    }//GEN-LAST:event_irConsultaOS

    private void irCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroOS
        // TODO add your handling code here:
    }//GEN-LAST:event_irCadastroOS

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RELATORIO_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RELATORIO_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RELATORIO_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RELATORIO_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RELATORIO_TELA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIrCadastroOS;
    private javax.swing.JButton btnIrConsultaOS;
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnIrRelatorios;
    private javax.swing.JButton btnIrUsuario;
    private javax.swing.JPanel painelCRUD;
    private javax.swing.JPanel painelFormularioConsulta;
    private javax.swing.JPanel painelOpcoesCRUD;
    private javax.swing.JPanel painelSecoes;
    // End of variables declaration//GEN-END:variables
}

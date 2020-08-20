/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.TELAS;

import pif.desktop.DAO.Conexao;

/**
 *
 * @author arthu
 */
public class C_EQUIP_TELA extends javax.swing.JFrame {

    private TelaUtils u = new TelaUtils(); 
    
    /**
     * Creates new form CADASTRAR_OS
     */
    public C_EQUIP_TELA() {
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

        painelSeções = new javax.swing.JPanel();
        btnIrOS = new javax.swing.JButton();
        btnIrEquipamentos = new javax.swing.JButton();
        btnIrTecnicos = new javax.swing.JButton();
        btnIrClientes = new javax.swing.JButton();
        painelCRUD = new javax.swing.JPanel();
        btnIrCadastroOS = new javax.swing.JButton();
        btnIrCadastroOS1 = new javax.swing.JButton();
        painelFormulário = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));

        painelSeções.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Para qual seção deseja ir?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnIrOS.setBackground(new java.awt.Color(204, 204, 204));
        btnIrOS.setText("Ordem de serviço");
        btnIrOS.setBorderPainted(false);
        btnIrOS.setContentAreaFilled(false);
        btnIrOS.setFocusPainted(false);
        btnIrOS.setOpaque(true);
        btnIrOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroOS(evt);
            }
        });

        btnIrEquipamentos.setBackground(new java.awt.Color(210, 210, 210));
        btnIrEquipamentos.setForeground(new java.awt.Color(102, 102, 102));
        btnIrEquipamentos.setText("Equipamentos");
        btnIrEquipamentos.setToolTipText("");
        btnIrEquipamentos.setBorderPainted(false);
        btnIrEquipamentos.setContentAreaFilled(false);
        btnIrEquipamentos.setFocusPainted(false);
        btnIrEquipamentos.setOpaque(true);
        btnIrEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroEquip(evt);
            }
        });

        btnIrTecnicos.setBackground(new java.awt.Color(210, 210, 210));
        btnIrTecnicos.setForeground(new java.awt.Color(102, 102, 102));
        btnIrTecnicos.setText("Técnicos");
        btnIrTecnicos.setBorderPainted(false);
        btnIrTecnicos.setContentAreaFilled(false);
        btnIrTecnicos.setFocusPainted(false);
        btnIrTecnicos.setOpaque(true);
        btnIrTecnicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irCadastroTec(evt);
            }
        });

        btnIrClientes.setBackground(new java.awt.Color(210, 210, 210));
        btnIrClientes.setForeground(new java.awt.Color(102, 102, 102));
        btnIrClientes.setText("Clientes");
        btnIrClientes.setBorderPainted(false);
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
                .addComponent(btnIrEquipamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnIrTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btnIrEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        painelCRUD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "O que deseja fazer?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnIrCadastroOS.setBackground(new java.awt.Color(210, 210, 210));
        btnIrCadastroOS.setForeground(new java.awt.Color(102, 102, 102));
        btnIrCadastroOS.setText("Consultar um equipamento");
        btnIrCadastroOS.setBorderPainted(false);
        btnIrCadastroOS.setContentAreaFilled(false);
        btnIrCadastroOS.setFocusPainted(false);
        btnIrCadastroOS.setOpaque(true);
        btnIrCadastroOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irConsultaEquip(evt);
            }
        });

        btnIrCadastroOS1.setBackground(new java.awt.Color(204, 204, 204));
        btnIrCadastroOS1.setText("Cadastrar um equipamento");
        btnIrCadastroOS1.setBorderPainted(false);
        btnIrCadastroOS1.setContentAreaFilled(false);
        btnIrCadastroOS1.setFocusPainted(false);
        btnIrCadastroOS1.setOpaque(true);

        javax.swing.GroupLayout painelCRUDLayout = new javax.swing.GroupLayout(painelCRUD);
        painelCRUD.setLayout(painelCRUDLayout);
        painelCRUDLayout.setHorizontalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIrCadastroOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        painelCRUDLayout.setVerticalGroup(
            painelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnIrCadastroOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnIrCadastroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        painelFormulário.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de equipamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout painelFormulárioLayout = new javax.swing.GroupLayout(painelFormulário);
        painelFormulário.setLayout(painelFormulárioLayout);
        painelFormulárioLayout.setHorizontalGroup(
            painelFormulárioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormulárioLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        painelFormulárioLayout.setVerticalGroup(
            painelFormulárioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormulárioLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelSeções, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelFormulário, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(painelSeções, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelFormulário, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void irConsultaEquip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irConsultaEquip
        u.irDePara(this, C_OS_TELA.getRUD_EQUIP());
    }//GEN-LAST:event_irConsultaEquip

    private void irCadastroOS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroOS
        u.irDePara(this, C_OS_TELA.getC_OS());
    }//GEN-LAST:event_irCadastroOS

    private void irCadastroEquip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroEquip
        //u.irDePara(this, C_OS_TELA.getC_EQUIP());
    }//GEN-LAST:event_irCadastroEquip

    private void irCadastroTec(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroTec
       // u.irDePara(this, C_OS_TELA.getC_TEC());
    }//GEN-LAST:event_irCadastroTec

    private void irCadastroCliente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irCadastroCliente
       // u.irDePara(this, C_OS_TELA.getC_CLIENTE());
    }//GEN-LAST:event_irCadastroCliente

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
            java.util.logging.Logger.getLogger(C_EQUIP_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_EQUIP_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_EQUIP_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_EQUIP_TELA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIrCadastroOS;
    private javax.swing.JButton btnIrCadastroOS1;
    private javax.swing.JButton btnIrClientes;
    private javax.swing.JButton btnIrEquipamentos;
    private javax.swing.JButton btnIrOS;
    private javax.swing.JButton btnIrTecnicos;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel painelCRUD;
    private javax.swing.JPanel painelFormulário;
    private javax.swing.JPanel painelSeções;
    // End of variables declaration//GEN-END:variables
}

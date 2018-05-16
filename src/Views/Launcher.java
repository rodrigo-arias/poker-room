package Views;

public class Launcher extends javax.swing.JDialog {

    public Launcher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoginJugador = new javax.swing.JToggleButton();
        btnLoginAdmin = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnLoginJugador.setText("Nuevo Login Jugador");
        btnLoginJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginJugadorActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginJugador);
        btnLoginJugador.setBounds(40, 80, 161, 32);

        btnLoginAdmin.setText("Nuevo Login Admin");
        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginAdmin);
        btnLoginAdmin.setBounds(40, 130, 160, 32);

        jLabel1.setFont(new java.awt.Font("POKERFACE", 0, 36)); // NOI18N
        jLabel1.setText("DEV PANEL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 200, 30);

        setBounds(0, 0, 250, 222);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginJugadorActionPerformed
        new LoginJugador(null, false).setVisible(true);
    }//GEN-LAST:event_btnLoginJugadorActionPerformed

    private void btnLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAdminActionPerformed
        new LoginAdmin(null, false).setVisible(true);
    }//GEN-LAST:event_btnLoginAdminActionPerformed

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
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Launcher dialog = new Launcher(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLoginAdmin;
    private javax.swing.JToggleButton btnLoginJugador;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

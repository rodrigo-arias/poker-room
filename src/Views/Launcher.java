package Views;

import java.awt.Color;
import static java.lang.System.exit;

public class Launcher extends javax.swing.JDialog {

    private Color lightBlue = new Color(0, 183, 254);
    private Color blue = new Color(0, 144, 255);
    private Color lightPink = new Color(231, 66, 124);
    private Color pink = new Color(186, 43, 98);
    private Color lightRed = new Color(255, 47, 57);
    private Color red = new Color(183, 47, 57);

    public Launcher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //===============  Initial  ===============//
        this.setTitle("Poker Moons");

        //===============  Styles  ================//
        btnLoginJugador.setBorder(null);
        btnLoginJugador.setOpaque(true);
        btnLoginAdmin.setBorder(null);
        btnLoginAdmin.setOpaque(true);
        btnSalir.setBorder(null);
        btnSalir.setOpaque(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnLoginJugador = new javax.swing.JToggleButton();
        btnLoginAdmin = new javax.swing.JToggleButton();
        btnSalir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBack.setBackground(new java.awt.Color(42, 42, 49));

        lblTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(153, 153, 153));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Developer Panel");

        btnLoginJugador.setBackground(new java.awt.Color(0, 183, 254));
        btnLoginJugador.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnLoginJugador.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginJugador.setText("Aplicación para Jugador");
        btnLoginJugador.setBorder(null);
        btnLoginJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginJugadorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginJugadorMouseEntered(evt);
            }
        });
        btnLoginJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginJugadorActionPerformed(evt);
            }
        });

        btnLoginAdmin.setBackground(new java.awt.Color(231, 66, 124));
        btnLoginAdmin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnLoginAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginAdmin.setText("Aplicación para Admin");
        btnLoginAdmin.setBorder(null);
        btnLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginAdminMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginAdminMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginAdminMouseEntered(evt);
            }
        });
        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAdminActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 47, 57));
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Finalizar Aplicación");
        btnSalir.setBorder(null);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLoginAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoginJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnLoginJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 280, 348);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginJugadorActionPerformed
        new JugadorLogin(null, false).setVisible(true);
    }//GEN-LAST:event_btnLoginJugadorActionPerformed

    private void btnLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAdminActionPerformed
        new AdminLogin(null, false).setVisible(true);
    }//GEN-LAST:event_btnLoginAdminActionPerformed

    private void btnLoginAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginAdminMouseClicked

    private void btnLoginAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginAdminMouseEntered
        btnLoginAdmin.setBackground(pink);
    }//GEN-LAST:event_btnLoginAdminMouseEntered

    private void btnLoginAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginAdminMouseExited
        btnLoginAdmin.setBackground(lightPink);
    }//GEN-LAST:event_btnLoginAdminMouseExited

    private void btnLoginJugadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginJugadorMouseEntered
        btnLoginJugador.setBackground(blue);
    }//GEN-LAST:event_btnLoginJugadorMouseEntered

    private void btnLoginJugadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginJugadorMouseExited
        btnLoginJugador.setBackground(lightBlue);
    }//GEN-LAST:event_btnLoginJugadorMouseExited

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(lightRed);
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(red);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLoginAdmin;
    private javax.swing.JToggleButton btnLoginJugador;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBack;
    // End of variables declaration//GEN-END:variables
}

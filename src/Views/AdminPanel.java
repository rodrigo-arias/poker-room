package Views;

import Controllers.ControladorAdminPanel;
import Controllers.IVistaAdminPanel;
import java.awt.Color;

public class AdminPanel extends javax.swing.JDialog implements IVistaAdminPanel {

    private ControladorAdminPanel controlador;
    private Color lightPink = new Color(231, 66, 124);
    private Color pink = new Color(186, 43, 98);

    public AdminPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorAdminPanel(this);
        this.setTitle("Poker Moons");

        btnConfig.setBorder(null);
        btnConfig.setOpaque(true);
        btnMonitor.setBorder(null);
        btnMonitor.setOpaque(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnConfig = new javax.swing.JToggleButton();
        btnMonitor = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBack.setBackground(new java.awt.Color(42, 42, 49));

        lblTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(153, 153, 153));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Amin Panel");

        btnConfig.setBackground(new java.awt.Color(231, 66, 124));
        btnConfig.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnConfig.setText("Configurar Partidas");
        btnConfig.setBorder(null);
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
        });
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnMonitor.setBackground(new java.awt.Color(231, 66, 124));
        btnMonitor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnMonitor.setForeground(new java.awt.Color(255, 255, 255));
        btnMonitor.setText("Monitor Partidas");
        btnMonitor.setBorder(null);
        btnMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMonitorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMonitorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMonitorMouseEntered(evt);
            }
        });
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
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

        setBounds(0, 310, 280, 287);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        controlador.config();
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorActionPerformed
        controlador.monitor();
    }//GEN-LAST:event_btnMonitorActionPerformed

    private void btnMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMonitorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMonitorMouseClicked

    private void btnMonitorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMonitorMouseEntered
        btnMonitor.setBackground(pink);
    }//GEN-LAST:event_btnMonitorMouseEntered

    private void btnMonitorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMonitorMouseExited
        btnMonitor.setBackground(lightPink);
    }//GEN-LAST:event_btnMonitorMouseExited

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        btnConfig.setBackground(pink);
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        btnConfig.setBackground(lightPink);
    }//GEN-LAST:event_btnConfigMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConfig;
    private javax.swing.JToggleButton btnMonitor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBack;
    // End of variables declaration//GEN-END:variables

    @Override
    public void salir() {
        dispose();
    }
}

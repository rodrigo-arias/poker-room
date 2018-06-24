package Views;

import Controllers.ControladorAdminLogin;
import java.awt.Color;
import java.awt.event.KeyEvent;
import Controllers.VistaAdminLogin;

public class AdminLogin extends javax.swing.JDialog implements VistaAdminLogin {

    private ControladorAdminLogin controlador;
    private Color grey = new Color(51, 57, 64);
    private Color pink = new Color(186, 43, 98);
    private Color lightPink = new Color(231, 66, 124);

    public AdminLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorAdminLogin(this);
        this.setTitle("Poker Moons");

        //===============  Additional styles  ===============//
        fieldNombre.setBackground(grey);
        fieldPass.setBackground(grey);

        btnLogin.setBorder(null);
        btnLogin.setOpaque(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Administrator = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        fieldPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(312, 340));
        setMinimumSize(new java.awt.Dimension(312, 340));
        setName("dialogLogin"); // NOI18N
        setSize(new java.awt.Dimension(312, 340));

        Administrator.setBackground(new java.awt.Color(42, 42, 49));
        Administrator.setMaximumSize(new java.awt.Dimension(340, 340));
        Administrator.setMinimumSize(new java.awt.Dimension(340, 340));
        Administrator.setPreferredSize(new java.awt.Dimension(340, 340));

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(153, 153, 153));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Administrator");

        fieldNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        fieldNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldNombre.setBorder(null);
        fieldNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        fieldNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        lblPass.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(153, 153, 153));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPass.setText("Password");

        fieldPass.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        fieldPass.setForeground(new java.awt.Color(153, 153, 153));
        fieldPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldPass.setBorder(null);
        fieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPassActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(231, 66, 124));
        btnLogin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.setBorder(null);
        btnLogin.setSize(new java.awt.Dimension(83, 30));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo-pink.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(70, 70));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblMensaje.setToolTipText("");

        javax.swing.GroupLayout AdministratorLayout = new javax.swing.GroupLayout(Administrator);
        Administrator.setLayout(AdministratorLayout);
        AdministratorLayout.setHorizontalGroup(
            AdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministratorLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(AdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldNombre))
                .addGap(48, 48, 48))
        );
        AdministratorLayout.setVerticalGroup(
            AdministratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministratorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fieldPass.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Administrator, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Administrator, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(312, 422));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPassActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(pink);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(lightPink);
    }//GEN-LAST:event_btnLoginMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Administrator;
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String u = fieldNombre.getText();
        String p = new String(fieldPass.getPassword());
        controlador.login(u, p);
    }

    @Override
    public void mostrarError(String msg) {
        lblMensaje.setText(msg);
        lblMensaje.setForeground(Color.red);
    }

    @Override
    public void salir() {
        lblMensaje.setText("");
        dispose();
    }
}

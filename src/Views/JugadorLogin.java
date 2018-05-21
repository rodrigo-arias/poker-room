package Views;

import Controllers.ControladorJugadorLogin;
import java.awt.Color;
import java.awt.event.KeyEvent;
import Controllers.IVistaJugadorLogin;

public class JugadorLogin extends javax.swing.JDialog implements IVistaJugadorLogin {

    private ControladorJugadorLogin controlador;
    private Color grey = new Color(51, 57, 64);
    private Color lightBlue = new Color(0, 183, 254);
    private Color blue = new Color(0, 144, 255);

    public JugadorLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorJugadorLogin(this);
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

        panelBack = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        fieldPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(340, 340));
        setName("dialogLogin"); // NOI18N
        setSize(new java.awt.Dimension(340, 340));

        panelBack.setBackground(new java.awt.Color(42, 42, 49));
        panelBack.setMaximumSize(new java.awt.Dimension(340, 340));
        panelBack.setMinimumSize(new java.awt.Dimension(340, 340));
        panelBack.setPreferredSize(new java.awt.Dimension(340, 340));

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(153, 153, 153));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Username");

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

        btnLogin.setBackground(new java.awt.Color(0, 183, 254));
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
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(70, 70));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldPass)
                    .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fieldPass.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(400, 422));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPassActionPerformed
        login();
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
        btnLogin.setBackground(blue);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(lightBlue);
    }//GEN-LAST:event_btnLoginMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JPanel panelBack;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String user = fieldNombre.getText();
        String pass = new String(fieldPass.getPassword());
        controlador.login(user, pass);
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

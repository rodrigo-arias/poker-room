package Views;

import Controllers.ControladorLoginJugador;
import javax.swing.JOptionPane;
import Controllers.IVistaLoginJugador;
import java.awt.event.KeyEvent;

public class LoginJugador extends javax.swing.JDialog implements IVistaLoginJugador {

    private ControladorLoginJugador controlador;

    public LoginJugador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorLoginJugador(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBackground = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        panelBottom = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        panelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/login.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(103, 38, 20));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName("dialogLogin"); // NOI18N
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        panelBottom.setBackground(new java.awt.Color(24, 38, 50));
        panelBottom.setMaximumSize(new java.awt.Dimension(400, 300));
        panelBottom.setMinimumSize(new java.awt.Dimension(400, 300));
        panelBottom.setLayout(null);

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("ProFont for Powerline", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(153, 153, 153));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("USUARIO");
        panelBottom.add(lblNombre);
        lblNombre.setBounds(40, 30, 80, 30);

        txtNombre.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(69, 73, 74));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        panelBottom.add(txtNombre);
        txtNombre.setBounds(40, 60, 300, 30);

        lblPass.setFont(new java.awt.Font("ProFont for Powerline", 1, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(153, 153, 153));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPass.setText("CONTRASEÑA");
        panelBottom.add(lblPass);
        lblPass.setBounds(40, 100, 80, 30);

        btnLogin.setBackground(new java.awt.Color(24, 38, 50));
        btnLogin.setFont(new java.awt.Font("ProFont for Powerline", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(149, 120, 52));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 168, 79), 1, true));
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
        panelBottom.add(btnLogin);
        btnLogin.setBounds(40, 180, 160, 30);

        txtPass.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtPass.setForeground(new java.awt.Color(69, 73, 74));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPass.setBorder(null);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        panelBottom.add(txtPass);
        txtPass.setBounds(40, 130, 300, 30);
        txtPass.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(panelBottom);
        panelBottom.setBounds(0, 120, 400, 280);

        panelTop.setBackground(new java.awt.Color(103, 38, 20));
        panelTop.setLayout(null);

        jLabel1.setFont(new java.awt.Font("POKERFACE", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 73, 59));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("POKER MOONS");
        panelTop.add(jLabel1);
        jLabel1.setBounds(20, 30, 350, 70);

        getContentPane().add(panelTop);
        panelTop.setBounds(0, 0, 400, 120);

        setSize(new java.awt.Dimension(400, 422));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String user = txtNombre.getText();
        String pass = new String(txtPass.getPassword());
        controlador.login(user, pass);
    }

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void salir() {
        dispose();
    }
}

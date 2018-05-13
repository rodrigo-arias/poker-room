package Views;

import Controllers.ControladorLogin;
import javax.swing.JOptionPane;
import Controllers.IVistaLogin;
import Model.Participante;

public class Login extends javax.swing.JDialog implements IVistaLogin {

    private ControladorLogin controlador;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorLogin(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("dialogLogin"); // NOI18N
        getContentPane().setLayout(null);

        lblNombre.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNombre.setText("USER");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(230, 210, 40, 20);
        getContentPane().add(fieldNombre);
        fieldNombre.setBounds(130, 230, 220, 30);
        getContentPane().add(fieldPass);
        fieldPass.setBounds(130, 300, 220, 30);

        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 280, 70, 20);

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(180, 370, 130, 40);

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo.png"))); // NOI18N
        lblLogo.setName(""); // NOI18N
        lblLogo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblLogo);
        lblLogo.setBounds(30, 60, 447, 100);

        setSize(new java.awt.Dimension(500, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String pwd = new String(fieldPass.getPassword());
        controlador.login(fieldNombre.getText(), pwd);
    }

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void mostrarPartida(Participante p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

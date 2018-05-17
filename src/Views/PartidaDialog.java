package Views;

import Controllers.ControladorPartida;
import Controllers.IVistaPartida;
import javax.swing.JOptionPane;
import Model.Participante;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PartidaDialog extends javax.swing.JDialog implements IVistaPartida {

    private ControladorPartida controlador;

    public class Imagen extends javax.swing.JPanel {

        private String path;
        private int width;
        private int height;

        public Imagen(int width, int height, String path) {

            this.width = width;
            this.height = height;
            this.path = path;
            this.setSize(this.width, this.height); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        @Override
        public void paint(Graphics grafico) {
            Dimension alto = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource(this.path));
            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, alto.width, alto.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public PartidaDialog(java.awt.Frame parent, boolean modal, Participante participante) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorPartida(participante, this);

        String nombre = participante.getJugador().getNombre();
        this.setTitle("Sesion Poker Moons de " + nombre);

        this.lblNombre.setText(nombre);
        int pos = participante.getPartida().getJugadores().size() - 1;
        this.setTitle("Poker Moons - Partida de " + participante.getPartida().getJugadores().get(pos).getNombre());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        btnTipos = new javax.swing.JComboBox();
        btnPagar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        panelUser = new javax.swing.JPanel();
        panelCartas = new javax.swing.JPanel();
        btnCarta1 = new javax.swing.JButton();
        btnCarta2 = new javax.swing.JButton();
        btnCarta3 = new javax.swing.JButton();
        btnCarta4 = new javax.swing.JButton();
        btnCarta5 = new javax.swing.JButton();
        txtUser1 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblNombre);
        lblNombre.setBounds(150, 10, 100, 30);

        getContentPane().add(btnTipos);
        btnTipos.setBounds(120, 120, 170, 30);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar);
        btnPagar.setBounds(270, 50, 100, 40);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(150, 50, 100, 40);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApostar);
        btnApostar.setBounds(30, 50, 100, 40);

        panelCartas.add(btnCarta1);
        panelCartas.add(btnCarta2);
        panelCartas.add(btnCarta3);
        panelCartas.add(btnCarta4);
        panelCartas.add(btnCarta5);

        panelUser.add(panelCartas);
        panelUser.add(txtUser1);

        getContentPane().add(panelUser);
        panelUser.setBounds(110, 200, 200, 60);

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/table.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 400, 300);

        setSize(new java.awt.Dimension(400, 322));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed

    }//GEN-LAST:event_btnApostarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnCarta1;
    private javax.swing.JButton btnCarta2;
    private javax.swing.JButton btnCarta3;
    private javax.swing.JButton btnCarta4;
    private javax.swing.JButton btnCarta5;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox btnTipos;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelCartas;
    private javax.swing.JPanel panelUser;
    private javax.swing.JLabel txtUser1;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        dispose();
    }

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actualizarParticipantes(Participante p) {

        int tam = p.getPartida().getTam();
        int jug = p.getPartida().getJugadores().size();

        if (tam - jug > 0) {
            JOptionPane.showMessageDialog(this, "Faltan " + (tam - jug) + " de " + tam + " jugadores");
        } else {
            JOptionPane.showMessageDialog(this, "La partida va a comenzar...");
        }

        /*Imagen img = new Imagen(this.img_userActual.getWidth(), this.img_userActual.getHeight(), "/Assets/imgUser.png");
        this.img_userActual.add(img);
        this.img_userActual.repaint();
        int pos = laPartida.getParticipantes().size() - 1;
        this.setTitle("Poker Moons - Partida de " + laPartida.getParticipantes().get(pos).getNombre());*/
    }

//    @Override
//    public void mostrarCantidadContactos(int cantidad) {
//        setTitle(nombreD + " - " + cantidad + " contacto(s)");
//    }
}

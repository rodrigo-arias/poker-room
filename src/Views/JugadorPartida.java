package Views;

import Controllers.ControladorJugadorPartida;
import javax.swing.JOptionPane;
import Model.Participante;
import Controllers.IVistaJugadorPartida;
import Model.Jugador;

public class JugadorPartida extends javax.swing.JDialog implements IVistaJugadorPartida {

    private ControladorJugadorPartida controlador;
    private Participante participante;

    public JugadorPartida(java.awt.Frame parent, boolean modal, Participante ppte) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorJugadorPartida(ppte, this);
        participante = ppte;

        Jugador j = ppte.getJugador();

        this.setTitle("Poker Moons - Partida de " + participante.getJugador().getNombre());

        lblJugador1.setText(j.getNombre());
        lblSaldo1.setText("$" + Integer.toString(j.getSaldo()));
    }

    @Override
    public void iniciarPartida() {
        cambiarVisibilidad(true);
        lblMensaje.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        lblCarta1 = new javax.swing.JLabel();
        lblCarta2 = new javax.swing.JLabel();
        lblCarta3 = new javax.swing.JLabel();
        lblCarta4 = new javax.swing.JLabel();
        lblCarta5 = new javax.swing.JLabel();
        lblPozo = new javax.swing.JLabel();
        lblSaldo1 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblSaldo2 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblSaldo3 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblSaldo4 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();
        lblSaldo5 = new javax.swing.JLabel();
        lblJugador5 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBack.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 100, 30));

        btnPagar.setText("Pagar");
        btnPagar.setEnabled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panelBack.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 100, 30));

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        panelBack.add(btnApostar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 100, 30));

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        panelBack.add(btnPasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 100, 30));

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 440, 22));

        lblCarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/2_of_diamonds.jpg"))); // NOI18N
        lblCarta1.setText("jLabel1");
        lblCarta1.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 83, 121));

        lblCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/queen_of_diamonds.jpg"))); // NOI18N
        lblCarta2.setText("jLabel1");
        lblCarta2.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 83, 121));

        lblCarta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/ace_of_hearts.jpg"))); // NOI18N
        lblCarta3.setText("jLabel1");
        lblCarta3.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 83, 121));

        lblCarta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/10_of_spades.jpg"))); // NOI18N
        lblCarta4.setText("jLabel1");
        lblCarta4.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 83, 121));

        lblCarta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/2_of_clubs.jpg"))); // NOI18N
        lblCarta5.setText("jLabel1");
        lblCarta5.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 83, 121));

        lblPozo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblPozo.setForeground(new java.awt.Color(204, 204, 0));
        lblPozo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPozo.setText("Pozo $750");
        panelBack.add(lblPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 400, -1));

        lblSaldo1.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo1.setForeground(new java.awt.Color(204, 204, 0));
        lblSaldo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo1.setText("$200");
        panelBack.add(lblSaldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 100, -1));

        lblJugador1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador1.setForeground(new java.awt.Color(204, 204, 0));
        lblJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador1.setText("Rodrigo");
        panelBack.add(lblJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, -1));

        lblSaldo2.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo2.setText("$200");
        panelBack.add(lblSaldo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, -1));

        lblJugador2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador2.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador2.setText("Jugador 2");
        panelBack.add(lblJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 100, -1));

        lblSaldo3.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo3.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo3.setText("$200");
        panelBack.add(lblSaldo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 100, -1));

        lblJugador3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador3.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador3.setText("Jugador 3");
        panelBack.add(lblJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 100, -1));

        lblSaldo4.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo4.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo4.setText("$200");
        panelBack.add(lblSaldo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 100, -1));

        lblJugador4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador4.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador4.setText("Jugador 4");
        panelBack.add(lblJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 100, -1));

        lblSaldo5.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo5.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo5.setText("$200");
        panelBack.add(lblSaldo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 100, -1));

        lblJugador5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador5.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJugador5.setText("Jugador 5");
        panelBack.add(lblJugador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 100, -1));

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/table-blue.png"))); // NOI18N
        panelBack.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(790, 432));
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

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPasarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCarta1;
    private javax.swing.JLabel lblCarta2;
    private javax.swing.JLabel lblCarta3;
    private javax.swing.JLabel lblCarta4;
    private javax.swing.JLabel lblCarta5;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JLabel lblJugador5;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPozo;
    private javax.swing.JLabel lblSaldo1;
    private javax.swing.JLabel lblSaldo2;
    private javax.swing.JLabel lblSaldo3;
    private javax.swing.JLabel lblSaldo4;
    private javax.swing.JLabel lblSaldo5;
    private javax.swing.JPanel panelBack;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        dispose();
    }

    public void cambiarVisibilidad(boolean state) {
        btnApostar.setVisible(state);
        btnPagar.setVisible(state);
        btnPasar.setVisible(state);
        btnSalir.setVisible(state);
        lblCarta1.setVisible(state);
        lblCarta2.setVisible(state);
        lblCarta3.setVisible(state);
        lblCarta4.setVisible(state);
        lblCarta5.setVisible(state);
        lblJugador1.setVisible(state);
        lblJugador2.setVisible(state);
        lblJugador3.setVisible(state);
        lblJugador4.setVisible(state);
        lblJugador5.setVisible(state);
        lblMensaje.setVisible(state);
        lblPozo.setVisible(state);
        lblSaldo1.setVisible(state);
        lblSaldo2.setVisible(state);
        lblSaldo3.setVisible(state);
        lblSaldo4.setVisible(state);
        lblSaldo5.setVisible(state);
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
            cambiarVisibilidad(false);
            lblMensaje.setVisible(true);
            lblMensaje.setText("Esperando inicio del juego, faltan " + (tam - jug) + " de " + tam + " jugadores");
        }
    }
}

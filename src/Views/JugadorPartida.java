package Views;

import Controllers.ControladorJugadorPartida;
import Model.Participante;
import Model.Apuesta;
import Model.Carta;
import Model.Jugador;
import Model.Mano;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import Controllers.VistaJugadorPartida;

public class JugadorPartida extends javax.swing.JDialog implements VistaJugadorPartida {

    private ControladorJugadorPartida controlador;

    public JugadorPartida(java.awt.Frame parent, boolean modal, Participante p) {
        super(parent, modal);
        controlador = new ControladorJugadorPartida(p, this);

        //===============  Initial  ===============//
        initComponents();
        this.setTitle("Poker Moons - Partida de " + p.getJugador().getNombre());
        iniciar(p);
    }

    //===============  General ===============//
    @Override
    public void apostar() {
        int m = (Integer) spinnerApuesta.getValue();
        controlador.apostar(m);
    }

    @Override
    public void pasar() {
        mensaje("Pasaste, espera que termine la mano");
        mostrarInfo(false);
        controlador.pasar();
    }

    @Override
    public void pagar() {
        mensaje("Pagaste, espera el resultado");
        controlador.pagar();
    }

    @Override
    public void salir() {
        dispose();
        controlador.salir();
    }

    @Override
    public void mensaje(String msg) {
        lblMensaje.setText(msg);
    }

    @Override
    public void iniciar(Participante p) {
        reiniciar();

        int tam = p.getPartida().getTam();
        int jug = p.getPartida().getJugadores().size();
        int faltan = tam - jug;

        if (faltan == 0) {
            actualizarParticipantes(p);
            actualizarCartas(p);
            manoIniciar(p);
        } else {
            mensaje("Esperando inicio del juego, faltan " + faltan + " de " + tam + " jugadores");
        }
    }

    @Override
    public void finalizar(Participante p) {
        mostrarInfo(false);
        mostrarAcciones(false);
        mensaje("");
        JOptionPane.showMessageDialog(this, "La partida ha finalizado, solo quedas tú");
        dispose();
    }

    //========================================//
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
        lblCarta4 = new javax.swing.JLabel();
        lblCarta5 = new javax.swing.JLabel();
        lblCarta2 = new javax.swing.JLabel();
        lblCarta3 = new javax.swing.JLabel();
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
        spinnerApuesta = new javax.swing.JSpinner();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        setMinimumSize(new java.awt.Dimension(790, 410));
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
        panelBack.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 100, 30));

        btnPagar.setText("Pagar");
        btnPagar.setEnabled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panelBack.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 100, 30));

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        panelBack.add(btnApostar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 100, 30));

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        panelBack.add(btnPasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 100, 30));

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 440, 22));

        lblCarta1.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 83, 121));

        lblCarta4.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 83, 121));

        lblCarta5.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 83, 121));

        lblCarta2.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 83, 121));

        lblCarta3.setPreferredSize(new java.awt.Dimension(110, 160));
        panelBack.add(lblCarta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 83, 121));

        lblPozo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblPozo.setForeground(new java.awt.Color(204, 204, 0));
        lblPozo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 400, 19));

        lblSaldo1.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo1.setForeground(new java.awt.Color(204, 204, 0));
        lblSaldo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo1.setToolTipText("");
        panelBack.add(lblSaldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 100, 17));

        lblJugador1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador1.setForeground(new java.awt.Color(204, 204, 0));
        lblJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 15));

        lblSaldo2.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblSaldo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, 17));

        lblJugador2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador2.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 100, 15));

        lblSaldo3.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo3.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblSaldo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 100, 17));

        lblJugador3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador3.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 100, 15));

        lblSaldo4.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo4.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblSaldo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 100, 17));

        lblJugador4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador4.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 100, 15));

        lblSaldo5.setBackground(new java.awt.Color(255, 255, 255));
        lblSaldo5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblSaldo5.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblSaldo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 100, 17));

        lblJugador5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblJugador5.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBack.add(lblJugador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 100, 15));

        spinnerApuesta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        panelBack.add(spinnerApuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 70, 30));

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
        pagar();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        apostar();
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        pasar();
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
    private javax.swing.JSpinner spinnerApuesta;
    // End of variables declaration//GEN-END:variables

    //========================================//
    @Override
    public void manoIniciar(Participante p) {
        reiniciar();
        mostrarAcciones(true);
        habilitarAcciones("iniciar");
        actualizarParticipantes(p);
        actualizarCartas(p);
    }

    @Override
    public void manoFinalizar(Participante p) {
        limpiarParticipantes();

        // Actualizar datos del jugador actual
        String nomActual = p.getJugador().getNombre();
        String saldoActual = "$" + Integer.toString(p.getJugador().getSaldo());

        String[] options = {"Jugar", "Salir"};

        int retry = JOptionPane.showOptionDialog(
                null,
                "La mano terminó, ¿quieres jugar de nuevo " + nomActual + "?",
                "Poker Moons",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (retry == JOptionPane.YES_OPTION) {
            controlador.jugar();
        } else {
            controlador.jugar();
            salir();
        }
    }

    @Override
    public void saldoInsuficiente() {
        JOptionPane.showMessageDialog(this, "Saldo insuficiente");
        salir();
    }

    @Override
    public void ganador(Participante p) {
        mostrarInfo(false);
        mostrarAcciones(false);
        Mano m = p.getPartida().getManoActual();

        // Si el jugador pago puede ver quien ganó
        if (m.getPagaron().contains(p)) {

            if (p.equals(m.getGanador())) {
                mensaje("Ganaste la mano!");
            } else {
                mensaje(m.getApuesta().getApostador().getJugador().getNombre() + " gano la mano");
            }

            // Muestra la carta ganadora
            if (m.getCartaGanadora() != null) {
                lblCarta3.setVisible(true);
                mostrarCarta(lblCarta3, rutaImagen(m.getCartaGanadora()));
            }
        } else {
            // Si no pagó, solo sabe que termino la mano
            mensaje("La mano ha finalizado");
        }
    }

    @Override
    public void responder(Participante p) {
        Apuesta a = p.getPartida().getManoActual().getApuesta();
        actualizarPozo(p.getPartida().getPozo() + a.getValor());

        if (!p.equals(a.getApostador())) {
            mensaje(a.getApostador().getJugador().getNombre() + " aposto $" + a.getValor() + " ¿pagas o pasas?");
            habilitarAcciones("responder");

        } else {
            mensaje("Espera la respuesta de los otros jugadores");
            habilitarAcciones("esperar");
        }
    }

    //===============  Function  ==============//
    @Override
    public void actualizarParticipantes(Participante p) {
        int i = 2;
        int m = Integer.MAX_VALUE;

        limpiarParticipantes();

        // Actualizar datos del jugador actual y el pozo
        String nomActual = p.getJugador().getNombre();
        String saldoActual = "$" + Integer.toString(p.getJugador().getSaldo());

        actualizarParticipante(nomActual, saldoActual, 1);
        actualizarPozo(p.getPartida().getPozo());

        // Actualizo los datos del resto de los jugadores
        for (Jugador j : p.getPartida().getJugadores()) {

            if (j.getSaldo() < m && j.getSaldo() != 0) {
                m = j.getSaldo();
            }

            if (!j.equals(p.getJugador())) {

                String n = j.getNombre();
                String s = "$" + Integer.toString(j.getSaldo());

                actualizarParticipante(n, s, i);

                i++;
            }
        }

        // Apostar hasta el saldo del que tiene menos
        actualizarApuestaMax(m);
    }

    @Override
    public void actualizarCartas(Participante p) {
        if (p.getCartas().size() == 5) {

            int i = 1;

            for (Carta c : p.getCartas()) {

                switch (i) {
                    case 1:
                        mostrarCarta(lblCarta1, rutaImagen(c));
                        break;
                    case 2:
                        mostrarCarta(lblCarta2, rutaImagen(c));
                        break;
                    case 3:
                        mostrarCarta(lblCarta3, rutaImagen(c));
                        break;
                    case 4:
                        mostrarCarta(lblCarta4, rutaImagen(c));
                        break;
                    case 5:
                        mostrarCarta(lblCarta5, rutaImagen(c));
                        break;
                }
                i++;
            }
        }
    }

    @Override
    public void actualizarPozo(int pozo) {
        lblPozo.setText("Pozo: $" + Integer.toString(pozo));
    }

    public void actualizarParticipante(String n, String s, int i) {

        switch (i) {
            case 1:
                lblJugador1.setText(n);
                lblSaldo1.setText(s);
                break;
            case 2:
                lblJugador2.setText(n);
                lblSaldo2.setText(s);
                break;
            case 3:
                lblJugador3.setText(n);
                lblSaldo3.setText(s);
                break;
            case 4:
                lblJugador4.setText(n);
                lblSaldo4.setText(s);
                break;
            case 5:
                lblJugador5.setText(n);
                lblSaldo5.setText(s);
        }
    }

    public void mostrarCarta(javax.swing.JLabel label, URL url) {
        if (url != null) {
            label.setIcon(new ImageIcon(url));
        } else {
            label.setText("No se pudo cargar la imagen");
        }
    }

    public void actualizarApuestaMax(int max) {
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, max, 1);
        spinnerApuesta.setModel(model);
    }

    //===============  Auxiliar  ==============//
    public void mostrarInfo(boolean state) {
        lblCarta1.setVisible(state);
        lblCarta2.setVisible(state);
        lblCarta3.setVisible(state);
        lblCarta4.setVisible(state);
        lblCarta5.setVisible(state);

        lblSaldo1.setVisible(state);
        lblSaldo2.setVisible(state);
        lblSaldo3.setVisible(state);
        lblSaldo4.setVisible(state);
        lblSaldo5.setVisible(state);

        lblJugador1.setVisible(state);
        lblJugador2.setVisible(state);
        lblJugador3.setVisible(state);
        lblJugador4.setVisible(state);
        lblJugador5.setVisible(state);

        lblPozo.setVisible(state);
        spinnerApuesta.setVisible(state);
    }

    public void mostrarAcciones(boolean state) {
        btnApostar.setVisible(state);
        btnPasar.setVisible(state);
        btnPagar.setVisible(state);
        btnSalir.setVisible(state);
        spinnerApuesta.setVisible(state);
    }

    public void habilitarAcciones(String code) {
        switch (code) {
            case "responder":
                btnApostar.setEnabled(false);
                btnPasar.setEnabled(true);
                btnPagar.setEnabled(true);
                break;
            case "esperar":
                btnApostar.setEnabled(false);
                btnPasar.setEnabled(false);
                btnPagar.setEnabled(false);
                break;
            case "iniciar":
                btnApostar.setEnabled(true);
                btnPasar.setEnabled(false);
                btnPagar.setEnabled(false);
                break;
        }
    }

    private void limpiarParticipantes() {
        lblJugador1.setText("");
        lblJugador2.setText("");
        lblJugador3.setText("");
        lblJugador4.setText("");
        lblJugador5.setText("");
        lblSaldo1.setText("");
        lblSaldo2.setText("");
        lblSaldo3.setText("");
        lblSaldo4.setText("");
        lblSaldo5.setText("");
    }

    public void reiniciar() {
        mostrarInfo(true);
        mostrarAcciones(false);
        mensaje("");
    }

    public URL rutaImagen(Carta c) {
        try {
            return JugadorPartida.class.getResource(c.getSource());
        } catch (Exception e) {
            return null;
        }
    }
}

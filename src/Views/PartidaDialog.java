package Views;

import Controllers.ControladorPartida;
import Controllers.IVistaPartida;
import Model.Carta;
import javax.swing.JOptionPane;
import Model.Participante;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
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
        this.panelJuego.setVisible(false);
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
        panelJuego = new javax.swing.JPanel();
        lblTituloListaParticipantes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listParticipantes = new javax.swing.JList();
        btnApostar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnTipos = new javax.swing.JComboBox();
        panelUser = new javax.swing.JPanel();
        panelCartas = new javax.swing.JPanel();
        panel_carta1 = new javax.swing.JPanel();
        panel_carta2 = new javax.swing.JPanel();
        panel_carta3 = new javax.swing.JPanel();
        panel_carta4 = new javax.swing.JPanel();
        panel_carta5 = new javax.swing.JPanel();
        txtUser1 = new javax.swing.JLabel();
        lblPrePartida = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblNombre);
        lblNombre.setBounds(290, 10, 290, 30);

        lblTituloListaParticipantes.setText("Participantes");
        panelJuego.add(lblTituloListaParticipantes);

        jScrollPane1.setViewportView(listParticipantes);

        panelJuego.add(jScrollPane1);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        panelJuego.add(btnApostar);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelJuego.add(btnSalir);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panelJuego.add(btnPagar);

        panelJuego.add(btnTipos);

        panelUser.setPreferredSize(new java.awt.Dimension(771, 2000));

        javax.swing.GroupLayout panel_carta1Layout = new javax.swing.GroupLayout(panel_carta1);
        panel_carta1.setLayout(panel_carta1Layout);
        panel_carta1Layout.setHorizontalGroup(
            panel_carta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        panel_carta1Layout.setVerticalGroup(
            panel_carta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_carta2Layout = new javax.swing.GroupLayout(panel_carta2);
        panel_carta2.setLayout(panel_carta2Layout);
        panel_carta2Layout.setHorizontalGroup(
            panel_carta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        panel_carta2Layout.setVerticalGroup(
            panel_carta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_carta3Layout = new javax.swing.GroupLayout(panel_carta3);
        panel_carta3.setLayout(panel_carta3Layout);
        panel_carta3Layout.setHorizontalGroup(
            panel_carta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        panel_carta3Layout.setVerticalGroup(
            panel_carta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_carta4Layout = new javax.swing.GroupLayout(panel_carta4);
        panel_carta4.setLayout(panel_carta4Layout);
        panel_carta4Layout.setHorizontalGroup(
            panel_carta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        panel_carta4Layout.setVerticalGroup(
            panel_carta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_carta5Layout = new javax.swing.GroupLayout(panel_carta5);
        panel_carta5.setLayout(panel_carta5Layout);
        panel_carta5Layout.setHorizontalGroup(
            panel_carta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        panel_carta5Layout.setVerticalGroup(
            panel_carta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCartasLayout = new javax.swing.GroupLayout(panelCartas);
        panelCartas.setLayout(panelCartasLayout);
        panelCartasLayout.setHorizontalGroup(
            panelCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasLayout.createSequentialGroup()
                .addComponent(panel_carta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(panel_carta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_carta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_carta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_carta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelCartasLayout.setVerticalGroup(
            panelCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_carta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_carta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_carta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_carta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_carta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCartas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1840, Short.MAX_VALUE))
        );

        panelJuego.add(panelUser);

        getContentPane().add(panelJuego);
        panelJuego.setBounds(0, 120, 930, 280);

        lblPrePartida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrePartida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPrePartida);
        lblPrePartida.setBounds(20, 74, 340, 40);

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/table.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 940, 390);

        setSize(new java.awt.Dimension(951, 453));
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
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox btnTipos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrePartida;
    private javax.swing.JLabel lblTituloListaParticipantes;
    private javax.swing.JList listParticipantes;
    private javax.swing.JPanel panelCartas;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel panel_carta1;
    private javax.swing.JPanel panel_carta2;
    private javax.swing.JPanel panel_carta3;
    private javax.swing.JPanel panel_carta4;
    private javax.swing.JPanel panel_carta5;
    private javax.swing.JLabel txtUser1;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        this.controlador.salirPartida();
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
            this.lblPrePartida.setText("Faltan " + (tam - jug) + " de " + tam + " jugadores");            
        } else {
            this.actualizarParticipantesListado(p);
            JOptionPane.showMessageDialog(this, "La partida va a comenzar...");
            this.comenzarPartida();
        }
    }
    
    @Override
    public void actualizarParticipantesListado(Participante participante) {
        this.listParticipantes.removeAll();
        this.listParticipantes.setListData(participante.getPartida().getJugadores().toArray());
    }
    
    public void comenzarPartida() {        
        this.panelJuego.setVisible(true);
        this.lblPrePartida.setVisible(false);
        ArrayList<Carta> cartas = this.controlador.iniciarPartida();
       
        this.panel_carta1.add(new Imagen(160, 110, cartas.get(0).getSource())).repaint();
        this.panel_carta2.add(new Imagen(160, 110, cartas.get(1).getSource())).repaint();
        this.panel_carta3.add(new Imagen(160, 110, cartas.get(2).getSource())).repaint();
        this.panel_carta4.add(new Imagen(160, 110, cartas.get(3).getSource())).repaint();
        this.panel_carta5.add(new Imagen(160, 110, cartas.get(4).getSource())).repaint();
        
    }

//    @Override
//    public void mostrarCantidadContactos(int cantidad) {
//        setTitle(nombreD + " - " + cantidad + " contacto(s)");
//    }

}

package Views;

import Controllers.ControladorPartida;
import Controllers.IVistaPartida;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import Model.Participante;
import Model.Partida;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PartidaDialog extends javax.swing.JDialog implements IVistaPartida {
    
    private ControladorPartida controlador;
    private String nombreUsuario = "";
    private int contadorParticipante = 1;
    //private String nombree = "";

    //Clase para Imagenes
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
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource(this.path));
            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    
    public PartidaDialog(java.awt.Frame parent, boolean modal, Partida partida, Participante participante) {
        super(parent, modal);
        initComponents();
        this.nombreUsuario = participante.getNombre();
        this.setTitle("Sesion Poker Moons de "+this.nombreUsuario);
        controlador = new ControladorPartida(partida, participante, this);
        
        this.txtUser1.setText(this.nombreUsuario);
        int pos = partida.getParticipantes().size() - 1;
        this.setTitle("Poker Moons - Partida de " + partida.getParticipantes().get(pos).getNombre());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tipos = new javax.swing.JComboBox();
        crearContacto = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        crearContacto1 = new javax.swing.JButton();
        panel_user1 = new javax.swing.JPanel();
        panelCartas_user1 = new javax.swing.JPanel();
        carta1_user1 = new javax.swing.JButton();
        carta2_user1 = new javax.swing.JButton();
        carta3_user1 = new javax.swing.JButton();
        carta4_user1 = new javax.swing.JButton();
        carta5_user1 = new javax.swing.JButton();
        txtUser1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 210, 50, 30);

        getContentPane().add(tipos);
        tipos.setBounds(360, 240, 170, 30);

        crearContacto.setText("Crear");
        crearContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearContactoActionPerformed(evt);
            }
        });
        getContentPane().add(crearContacto);
        crearContacto.setBounds(530, 320, 110, 40);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(400, 320, 120, 40);

        crearContacto1.setText("Crear");
        crearContacto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearContacto1ActionPerformed(evt);
            }
        });
        getContentPane().add(crearContacto1);
        crearContacto1.setBounds(280, 320, 110, 40);

        panelCartas_user1.add(carta1_user1);
        panelCartas_user1.add(carta2_user1);
        panelCartas_user1.add(carta3_user1);
        panelCartas_user1.add(carta4_user1);
        panelCartas_user1.add(carta5_user1);

        panel_user1.add(panelCartas_user1);
        panel_user1.add(txtUser1);

        getContentPane().add(panel_user1);
        panel_user1.setBounds(320, 400, 200, 160);

        setSize(new java.awt.Dimension(900, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void crearContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearContactoActionPerformed
        // TODO add your handling code here:
        //crearContacto();
    }//GEN-LAST:event_crearContactoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_salirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void crearContacto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearContacto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearContacto1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carta1_user1;
    private javax.swing.JButton carta2_user1;
    private javax.swing.JButton carta3_user1;
    private javax.swing.JButton carta4_user1;
    private javax.swing.JButton carta5_user1;
    private javax.swing.JButton crearContacto;
    private javax.swing.JButton crearContacto1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelCartas_user1;
    private javax.swing.JPanel panel_user1;
    private javax.swing.JButton salir;
    private javax.swing.JComboBox tipos;
    private javax.swing.JLabel txtUser1;
    // End of variables declaration//GEN-END:variables

//    private void crearContacto() {
//        controlador.crearContacto(nombre.getText(), numero.getText(),
//                (Tipo) tipos.getSelectedItem());
//    }
//    private void limpiar() {
//        nombre.setText("");
//        numero.setText("");
//        tipos.setSelectedIndex(0);
//        nombre.requestFocus();
//    }
    /* private void mostrarTitulo() {
        setTitle("AGENDA DE " + agenda.getDueño().getNombreCompleto().toUpperCase() +
                " - " + agenda.getContactos().size() + " contacto(s)");

    }*/
    private void salir() {
        dispose();
        new LoginJugador(null, false).setVisible(true);
    }

//    @Override
//    public void contactoCreado() {
//        limpiar();
//    }
    @Override
    public void error(String msg) {
        JOptionPane.showMessageDialog(this, msg);

    }

    @Override
    public void actualizarParticipantes(Partida laPartida) {     
        int cantParticipantes = 5 - laPartida.getParticipantes().size();
        if(cantParticipantes == 0) {
          JOptionPane.showMessageDialog(this, "Ingreso un nuevo participante a la partida. Va a comenzar la partida");
          this.controlador.repartirCartas();
        } else
            JOptionPane.showMessageDialog(this, "Ingreso un nuevo participante a la partida. Faltan: "+cantParticipantes);
    
        this.contadorParticipante =  this.contadorParticipante + 1;
        
        /*Imagen img = new Imagen(this.img_userActual.getWidth(), this.img_userActual.getHeight(), "/Assets/imgUser.png");
        this.img_userActual.add(img);
        this.img_userActual.repaint();    
        int pos = laPartida.getParticipantes().size() - 1;
        this.setTitle("Poker Moons - Partida de " + laPartida.getParticipantes().get(pos).getNombre());*/
                
    }

//    @Override
//    public void mostrarContactos(ArrayList<Contacto> lista) {
//        contactos.setListData(lista.toArray());
//    }
//
//    @Override
//    public void mostrarCantidadContactos(int cantidad) {
//        setTitle(nombreD + " - " + cantidad + " contacto(s)");
//    }
//
//    @Override
//    public void mostrarNombreDueño(String nombreCompleto) {
//        nombreD = nombreCompleto.toUpperCase();
//        setTitle(nombreD);
//    }
//
//    @Override
//    public void cargarTipos(ArrayList<Tipo> lista) {
//        for (Tipo t : lista) {
//            tipos.addItem(t);
//        }
//    }
    
    
}
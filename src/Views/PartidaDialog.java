package Views;

import Controllers.ControladorPartida;
import Controllers.IVistaPartida;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import Model.Participante;

public class PartidaDialog extends javax.swing.JDialog implements IVistaPartida {

    private ControladorPartida controlador;
    //private String nombree = "";

    public PartidaDialog(java.awt.Frame parent, boolean modal, Participante p) {
        super(parent, modal);
        initComponents();

        controlador = new ControladorPartida(p, this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombree = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipos = new javax.swing.JComboBox();
        crearContacto = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 60, 20);
        getContentPane().add(nombree);
        nombree.setBounds(80, 80, 170, 30);
        getContentPane().add(numero);
        numero.setBounds(80, 140, 170, 30);

        jLabel2.setText("Numero");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 50, 30);

        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 200, 50, 30);

        getContentPane().add(tipos);
        tipos.setBounds(80, 200, 170, 30);

        crearContacto.setText("Crear");
        crearContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearContactoActionPerformed(evt);
            }
        });
        getContentPane().add(crearContacto);
        crearContacto.setBounds(133, 290, 110, 40);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(403, 360, 120, 30);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearContacto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombree;
    private javax.swing.JTextField numero;
    private javax.swing.JButton salir;
    private javax.swing.JComboBox tipos;
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
        new LoginDialog(null, false).setVisible(true);
    }

//    @Override
//    public void contactoCreado() {
//        limpiar();
//    }
    @Override
    public void error(String msg) {
        JOptionPane.showMessageDialog(this, msg);

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

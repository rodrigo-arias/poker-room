package Views;

import Controllers.ControladorMonitor;
import Controllers.IVistaMonitor;
import Model.Jugador;
import Model.Partida;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Monitor extends javax.swing.JFrame implements IVistaMonitor {

    private ControladorMonitor controlador;

    public Monitor(ArrayList<Partida> partidas) {
        initComponents();
        controlador = new ControladorMonitor(partidas, this);

        cargarPartidas(partidas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMonitor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMonitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant. jugadores", "Apuesta base", "Pozo", "Jugador #1", "Jugador #2", "Jugador #3", "Jugador #4", "Jugador #5"
            }
        ));
        tableMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMonitorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMonitor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMonitorMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableMonitor.getModel();

        String row = model.getValueAt(tableMonitor.getSelectedRow(), 0).toString();
        JOptionPane.showMessageDialog(this, row);
    }//GEN-LAST:event_tableMonitorMouseClicked

    @Override
    public void cargarPartidas(ArrayList<Partida> partidas) {
        DefaultTableModel model = (DefaultTableModel) tableMonitor.getModel();
        int largo = partidas.size();
        Object rowData[] = new Object[model.getColumnCount()];

        for (int i = 0; i < largo; i++) {
            Partida p = partidas.get(i);
            ArrayList<Jugador> j = p.getJugadores();

            rowData[0] = p.getTam();
            rowData[1] = p.getBase();
            rowData[2] = p.getPozo();

            for (int k = 0; k < j.size(); k++) {
                rowData[k + 3] = j.get(k).getNombre();
            }

            model.addRow(rowData);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMonitor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}

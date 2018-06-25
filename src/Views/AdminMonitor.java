package Views;

import Controllers.ControladorAdminMonitor;
import Model.Partida;
import Model.TablaPartida;
import java.util.ArrayList;
import Model.Sistema;
import Model.TablaParticipante;
import Controllers.VistaAdminMonitor;

public class AdminMonitor extends javax.swing.JFrame implements VistaAdminMonitor {

    private ControladorAdminMonitor controlador;
    TablaPartida modelPartida;
    TablaParticipante modelParticipantes;

    public AdminMonitor(ArrayList<Partida> p) {
        controlador = new ControladorAdminMonitor(p, this);

        //===============  Initial  ===============//
        initComponents();
        modelPartida = (TablaPartida) tablaPartida.getModel();
        modelParticipantes = (TablaParticipante) tablaParticipante.getModel();
        this.setTitle("Poker Moons");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        panePartida = new javax.swing.JScrollPane();
        tablaPartida = new javax.swing.JTable();
        paneParticipante = new javax.swing.JScrollPane();
        tablaParticipante = new javax.swing.JTable();
        lblTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 441));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelBack.setBackground(new java.awt.Color(42, 42, 49));
        panelBack.setMaximumSize(new java.awt.Dimension(500, 441));
        panelBack.setMinimumSize(new java.awt.Dimension(500, 441));
        panelBack.setPreferredSize(new java.awt.Dimension(500, 441));

        lblTitle2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(153, 153, 153));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Detalle de Partida");

        panePartida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        tablaPartida.setModel(new Model.TablaPartida());
        tablaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPartidaMouseClicked(evt);
            }
        });
        panePartida.setViewportView(tablaPartida);

        tablaParticipante.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaParticipante.setModel(new Model.TablaParticipante(null));
        paneParticipante.setViewportView(tablaParticipante);

        lblTitle1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(153, 153, 153));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Configuración de Partidas");

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneParticipante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(panePartida, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panePartida, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(600, 0, 500, 463);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPartidaMouseClicked
        actualizarParticipantes();
    }//GEN-LAST:event_tablaPartidaMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JScrollPane paneParticipante;
    private javax.swing.JScrollPane panePartida;
    private javax.swing.JPanel panelBack;
    private javax.swing.JTable tablaParticipante;
    private javax.swing.JTable tablaPartida;
    // End of variables declaration//GEN-END:variables

    public boolean esInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actualizarPartidas() {
        modelPartida.fireTableDataChanged();
    }

    @Override
    public void actualizarParticipantes() {
        int id = (Integer) modelPartida.getValueAt(tablaPartida.getSelectedRow(), 0);

        Partida partida = Sistema.instancia().getPartidaId(id);
        tablaParticipante.setModel(new TablaParticipante(partida));
        modelParticipantes.fireTableDataChanged();
    }
}

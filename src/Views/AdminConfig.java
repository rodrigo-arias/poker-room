package Views;

import Controllers.ControladorAdminConfig;
import Model.Partida;
import java.awt.Color;
import Model.Sistema;
import Controllers.VistaAdminConfig;

public class AdminConfig extends javax.swing.JFrame implements VistaAdminConfig {

    private ControladorAdminConfig controlador;

    public AdminConfig(Partida proxPartida) {
        initComponents();
        controlador = new ControladorAdminConfig(this);

        this.setTitle("Poker Moons");
        btnTam.setBorder(null);
        btnTam.setOpaque(true);
        btnBase.setBorder(null);
        btnBase.setOpaque(true);

        spinnerTam.setValue(proxPartida.getTam());
        fieldBase.setText(Integer.toString(proxPartida.getBase()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        spinnerTam = new javax.swing.JSpinner();
        lblTam = new javax.swing.JLabel();
        fieldBase = new javax.swing.JTextField();
        lblBase = new javax.swing.JLabel();
        btnBase = new javax.swing.JToggleButton();
        lblMensaje = new javax.swing.JLabel();
        btnTam = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(286, 320));
        setMinimumSize(new java.awt.Dimension(286, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelBack.setBackground(new java.awt.Color(42, 42, 49));

        lblTitle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 153, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Configuración de Partidas");

        spinnerTam.setModel(new javax.swing.SpinnerNumberModel(2, 2, 5, 1));

        lblTam.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblTam.setForeground(new java.awt.Color(153, 153, 153));
        lblTam.setText("Cant. jugadores");

        fieldBase.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fieldBase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblBase.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblBase.setForeground(new java.awt.Color(153, 153, 153));
        lblBase.setText("Apuesta base");

        btnBase.setBackground(new java.awt.Color(53, 175, 110));
        btnBase.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnBase.setForeground(new java.awt.Color(255, 255, 255));
        btnBase.setText("Actualizar");
        btnBase.setBorder(null);
        btnBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaseActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblMensaje.setToolTipText("");

        btnTam.setBackground(new java.awt.Color(53, 175, 110));
        btnTam.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnTam.setForeground(new java.awt.Color(255, 255, 255));
        btnTam.setText("Actualizar");
        btnTam.setBorder(null);
        btnTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addComponent(spinnerTam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTam))
                    .addComponent(btnTam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addComponent(fieldBase, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBase)))
                .addGap(40, 40, 40))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitle)
                .addGap(34, 34, 34)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBase, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBase, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(280, 310, 286, 342);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaseActionPerformed

        String txtBase = fieldBase.getText();

        if (txtBase != "" && esInteger(txtBase)) {

            int base = Integer.parseInt(txtBase);

            if (base > 0) {
                int ret = controlador.actualizarBase(base);

                switch (ret) {
                    case 1:
                        mostrarMensaje(2);
                        break;
                    case 2:
                        mostrarMensaje(3);
                        break;
                    default:
                        mostrarMensaje(1);
                        break;
                }
            } else {
                mostrarMensaje(1);
            }
        }
    }//GEN-LAST:event_btnBaseActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamActionPerformed
        int tam = (Integer) spinnerTam.getValue();
        int ret = controlador.actualizarTam(tam);

        if (ret == 1) {
            mostrarMensaje(4);
        } else if (ret == 2) {
            mostrarMensaje(5);
        }
    }//GEN-LAST:event_btnTamActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBase;
    private javax.swing.JToggleButton btnTam;
    private javax.swing.JTextField fieldBase;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTam;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBack;
    private javax.swing.JSpinner spinnerTam;
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
    public void mostrarMensaje(int code) {
        String msg = "";
        Color color = new Color(53, 175, 110);

        switch (code) {
            case 1:
                msg = "Ingrese una apuesta base mayor a 0";
                color = Color.red;
                break;
            case 2:
                msg = "Nueva apuesta rige en la sig. partida";
                break;
            case 3:
                msg = "La cant. de jugadores fue actualizada";
                break;
            case 4:
                msg = "Cant. de jug. rige en la sig. partida";
                break;
            case 5:
                msg = "La apuesta base fue actualizada";
                break;
        }
        lblMensaje.setText(msg);
        lblMensaje.setForeground(color);
    }

    @Override
    public void actualizar() {
        Partida proxPartida = Sistema.getInstance().getProximaPartida();

        spinnerTam.setValue(proxPartida.getTam());
        fieldBase.setText(Integer.toString(proxPartida.getBase()));
    }
}

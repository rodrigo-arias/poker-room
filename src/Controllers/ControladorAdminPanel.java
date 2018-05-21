package Controllers;

import Model.Partida;
import Model.Sistema;
import Views.AdminConfig;
import Views.AdminMonitor;
import java.util.ArrayList;

public class ControladorAdminPanel {

    private Sistema sistema = Sistema.getInstance();
    private IVistaAdminPanel vista;

    public ControladorAdminPanel(IVistaAdminPanel vista) {
        this.vista = vista;
    }

    public void config() {
        Partida proxPartida = sistema.getProximaPartida();
        // Create config interface
        new AdminConfig(proxPartida).setVisible(true);
    }

    public void monitor() {
        ArrayList<Partida> partidas = sistema.getPartidas();
        // Create config interface
        new AdminMonitor(partidas).setVisible(true);
    }
}

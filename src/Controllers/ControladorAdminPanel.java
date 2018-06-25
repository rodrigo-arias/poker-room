package Controllers;

import Model.Admin;
import Model.Partida;
import Model.Sistema;
import Views.AdminConfig;
import Views.AdminMonitor;
import java.util.ArrayList;

public class ControladorAdminPanel {

    private Sistema sistema = Sistema.instancia();
    private VistaAdminPanel vista;
    private Admin admin;

    public ControladorAdminPanel(Admin a, VistaAdminPanel v) {
        this.vista = v;
        this.admin = a;
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

    public void salir() {
        Sistema.instancia().salirAdmin(admin);
    }
}

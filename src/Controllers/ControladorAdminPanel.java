package Controllers;

import Model.Admin;
import Model.Partida;
import Model.Sistema;
import Views.AdminConfig;
import Views.AdminMonitor;
import java.util.ArrayList;

public class ControladorAdminPanel {

    private Sistema sistema = Sistema.getInstance();
    private VistaAdminPanel vista;
    private Admin admin;

    public ControladorAdminPanel(Admin adm, VistaAdminPanel vista) {
        this.vista = vista;
        this.admin = adm;
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
        Sistema.getInstance().logoutAdmin(admin);
    }
}

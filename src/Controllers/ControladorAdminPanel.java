package Controllers;

import Model.Admin;
import Model.Partida;
import Model.Sistema;
import Views.AdminConfig;
import Views.AdminMonitor;
import java.util.ArrayList;

public class ControladorAdminPanel {

    private Sistema sistema = Sistema.instancia();
    private Admin admin;

    public ControladorAdminPanel(Admin admin) {
        this.admin = admin;
    }

    public void config() {
        Partida proxPartida = sistema.proximaPartida();
        // Create config interface
        new AdminConfig(proxPartida).setVisible(true);
    }

    public void monitor() {
        ArrayList<Partida> partidas = sistema.partidasTodas();
        // Create config interface
        new AdminMonitor(partidas).setVisible(true);
    }

    public void salir() {
        sistema.salirAdmin(admin);
    }
}

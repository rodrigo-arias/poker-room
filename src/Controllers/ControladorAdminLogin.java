package Controllers;

import Model.Admin;
import Model.Partida;
import Model.Sistema;
import Views.AdminPanel;
import java.util.ArrayList;

public class ControladorAdminLogin {

    private Sistema sistema = Sistema.getInstance();
    private IVistaAdminLogin vista;

    public ControladorAdminLogin(IVistaAdminLogin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Admin admin = sistema.loginAdmin(u, p);

        if (admin == null) {
            vista.mostrarError("Usuario o contraseña incorrectos");
        } else {
            vista.salir();
            ArrayList<Partida> partidas = sistema.getPartidas();
            // Create monitor interface
            new AdminPanel(null, false).setVisible(true);
        }
    }
}

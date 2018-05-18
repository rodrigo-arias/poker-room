package Controllers;

import Model.Admin;
import Model.Partida;
import Model.Sistema;
import Views.Monitor;
import java.util.ArrayList;

public class ControladorLoginAdmin {

    private Sistema sistema = Sistema.getInstance();
    private IVistaLoginAdmin vista;

    public ControladorLoginAdmin(IVistaLoginAdmin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Admin admin = sistema.loginAdmin(u, p);

        if (admin == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            vista.salir();
            ArrayList<Partida> partidas = sistema.getPartidas();
            // Create monitor interface
            new Monitor(partidas).setVisible(true);
        }
    }
}

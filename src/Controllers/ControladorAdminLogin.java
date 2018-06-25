package Controllers;

import Model.Admin;
import Model.Sistema;
import Views.AdminPanel;

public class ControladorAdminLogin {

    private Sistema sistema = Sistema.instancia();
    private VistaAdminLogin vista;

    public ControladorAdminLogin(VistaAdminLogin vista) {
        this.vista = vista;
    }

    public void ingresar(String u, String p) {
        Admin admin = sistema.ingresarAdmin(u, p);

        if (admin == null) {
            vista.mensaje("No se pudo loguear.");
        } else {
            vista.salir();
            // Creación de interfaz de administrador
            new AdminPanel(null, false, admin).setVisible(true);
        }
    }
}

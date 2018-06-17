package Controllers;

import Model.Admin;
import Model.Sistema;
import Views.AdminPanel;

public class ControladorAdminLogin {

    private Sistema sistema = Sistema.getInstance();
    private IVistaAdminLogin vista;

    public ControladorAdminLogin(IVistaAdminLogin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Admin admin = sistema.loginAdmin(u, p);

        if (admin == null) {
            vista.mostrarError("No se pudo loguear.");
        } else {
            vista.salir();
            // Creación de interfaz de administrador
            new AdminPanel(null, false, admin).setVisible(true);
        }
    }
}

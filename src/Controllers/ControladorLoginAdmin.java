package Controllers;

import Model.Admin;
import Model.Sistema;

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
            //new PanelDialog(null, false).setVisible(true);
        }
    }
}

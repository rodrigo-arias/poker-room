package Controllers;

import Model.Participante;
import Model.Sistema;

public class ControladorLogin {

    private Sistema modelo = Sistema.getInstance();
    private IVistaLogin vista;

    public ControladorLogin(IVistaLogin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Participante participante = modelo.login(u, p);

        if (participante == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            vista.mostrarPartida(participante);
        }
    }
}

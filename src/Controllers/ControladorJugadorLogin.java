package Controllers;

import Model.Participante;
import Model.Sistema;

public class ControladorJugadorLogin {

    private Sistema sistema = Sistema.instancia();
    private VistaJugadorLogin vista;

    public ControladorJugadorLogin(VistaJugadorLogin vista) {
        this.vista = vista;
    }

    public void ingresar(String u, String p) {
        Participante ppte = sistema.ingresarJugador(u, p);

        if (ppte == null) {
            vista.mensaje("Usuario o contrasena incorrectos");
        } else {
            vista.salir();
            vista.partida(ppte);
        }
    }
}

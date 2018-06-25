package Controllers;

import Model.Participante;
import Model.Sistema;
import Views.JugadorPartida;

public class ControladorJugadorLogin {

    private Sistema sistema = Sistema.instancia();
    private VistaJugadorLogin vista;

    public ControladorJugadorLogin(VistaJugadorLogin vista) {
        this.vista = vista;
    }

    public void ingresar(String u, String p) {
        Participante ppte = sistema.ingresarJugador(u, p);

        if (ppte == null) {
            vista.mensaje("Usuario o contraseña incorrectos");
        } else {
            vista.salir();
            // Creación de interfaz de jugador
            new JugadorPartida(null, false, ppte).setVisible(true);
        }
    }
}

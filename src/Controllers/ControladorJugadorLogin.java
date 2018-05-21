package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;
import Views.JugadorPartida;

public class ControladorJugadorLogin {

    private Sistema sistema = Sistema.getInstance();
    private IVistaJugadorLogin vista;

    public ControladorJugadorLogin(IVistaJugadorLogin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Participante ppte = sistema.loginJugador(u, p);

        if (ppte == null) {
            vista.mostrarError("Usuario o contraseña incorrectos");
        } else {
            vista.salir();
            // Create partida interface and update participantes
            new JugadorPartida(null, false, ppte).setVisible(true);
            ppte.getPartida().avisar(Partida.Eventos.participanteNuevo);
        }
    }
}

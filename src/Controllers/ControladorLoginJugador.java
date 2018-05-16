package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;

public class ControladorLoginJugador {

    private Sistema sistema = Sistema.getInstance();
    private IVistaLoginJugador vista;

    public ControladorLoginJugador(IVistaLoginJugador vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Participante participante = sistema.loginJugador(u, p);

        if (participante == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            Partida partida = Sistema.getInstance().getProximaPartida();
            partida.agregarParticipante(participante);
            vista.mostrarPartida(partida, participante);
        }
    }
}

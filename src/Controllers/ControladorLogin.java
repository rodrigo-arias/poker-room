package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;

public class ControladorLogin {

    private Sistema sistema = Sistema.getInstance();
    private IVistaLogin vista;

    public ControladorLogin(IVistaLogin vista) {
        this.vista = vista;
    }

    public void login(String u, String p) {
        Participante participante = sistema.login(u, p);

        if (participante == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            Partida partida = Sistema.getInstance().getProximaPartida();
            partida.agregarParticipante(participante);
            vista.mostrarPartida(partida, participante);
        }
    }
}

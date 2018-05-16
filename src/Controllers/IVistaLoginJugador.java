package Controllers;

import Model.Participante;
import Model.Partida;

public interface IVistaLoginJugador {

    public void mostrarError(String msg);

    public void mostrarPartida(Partida partida, Participante participante);
}

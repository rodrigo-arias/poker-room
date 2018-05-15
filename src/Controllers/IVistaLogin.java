package Controllers;

import Model.Participante;
import Model.Partida;

public interface IVistaLogin {

    public void mostrarError(String msg);

    public void mostrarPartida(Partida partida, Participante participante);
}

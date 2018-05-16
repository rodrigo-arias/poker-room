package Controllers;

import Model.Partida;

public interface IVistaPartida {

    public void error(String msg);

    public void actualizarParticipantes(Partida partida);
}

package Controllers;

import Model.Participante;

public interface IVistaJugadorPartida {

    public void mostrarError(String msg);

    public void actualizarJugadores(Participante ppte);

    public void iniciarPartida(Participante ppte);
}

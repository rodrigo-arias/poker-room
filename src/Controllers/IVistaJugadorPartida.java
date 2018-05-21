package Controllers;

import Model.Participante;

public interface IVistaJugadorPartida {

    public void mostrarError(String msg);

    public void actualizarParticipantes(Participante ppte);

    public void iniciarPartida();
}
package Controllers;

import Model.Participante;

public interface IVistaJugadorPartida {

    public void mostrarError(String msg);

    public void actualizarParticipantes(Participante ppte);

    public void actualizarCartas(Participante p);

    public void iniciarPartida(Participante ppte);

    public void finalizarPartida(Participante participante);

    public void mostrarApuesta(Participante participante);

    public void mostrarGanador(Participante participante);

    public void finalizarMano(Participante participante);

    public void mostrarSaldoInsuficiente();

    public void otraMano(Participante participante);

    public void mostrarPago(Participante participante);
}

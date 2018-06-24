package Controllers;

import Model.Participante;

public interface VistaJugadorPartida {

    public void partidaIniciar(Participante ppte);

    public void partidaFinalizar(Participante participante);

    public void manoIniciar(Participante participante);

    public void manoFinalizar(Participante participante);

    public void updateParticipantes(Participante ppte);

    public void updateCartas(Participante p);

    public void showApuesta(Participante participante);

    public void showGanador(Participante participante);

    public void showSaldoInsuficiente();

    public void showPago(Participante participante);

    public void showMessage(String msg);
}

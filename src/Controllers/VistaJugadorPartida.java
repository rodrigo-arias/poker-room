package Controllers;

import Model.Participante;

public interface VistaJugadorPartida {

    public void mensaje(String msg);

    public void apostar();

    public void pasar();

    public void pagar();

    public void salir();

    public void iniciar(Participante p);

    public void finalizar(Participante p);

    //-------------------------------------
    public void actualizarParticipantes(Participante p);

    public void actualizarCartas(Participante p);

    public void actualizarPozo(int p);

    //-------------------------------------
    public void manoIniciar(Participante p);

    public void manoFinalizar(Participante p);

    public void responder(Participante p);

    public void ganador(Participante p);

    public void saldoInsuficiente();
}

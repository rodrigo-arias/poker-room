package Controllers;

import Model.Mano;
import Model.Participante;
import Model.Partida;

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

    public void actualizarPozo(Partida p);

    //-------------------------------------
    public void manoIniciar(Participante p);

    public void manoFinalizar(Participante p);

    public void responder(Participante p);

    public void ganador(Participante p, Mano m);

    public void saldoInsuficiente();

    public void timeOut(Participante p);
}

package Controllers;

import Model.Participante;
import Model.Partida;
import java.util.Observable;
import java.util.Observer;

public class ControladorJugadorPartida implements Observer {

    private VistaJugadorPartida v;
    private Participante p;

    //==================  Constructor  ==================//
    public ControladorJugadorPartida(Participante p, VistaJugadorPartida v) {
        this.v = v;
        this.p = p;
        p.getPartida().addObserver(this);

        if (this.p.getPartida().isActiva()) {
            this.p.getPartida().getManoActual().addObserver(this);
        }
    }

    //==================  Properties  =================//
    public void apostar(int apuesta) {
        if (apuesta > p.getPartida().apuestaMaxima()) {
            v.mensaje("No puedes apostar esa cantidad");
        } else {
            p.getPartida().accion(p, Partida.Accion.apostar, apuesta);
        }
    }

    public void pasar() {
        p.getPartida().accion(p, Partida.Accion.pasar, 0);
    }

    public void pagar() {
        p.getPartida().accion(p, Partida.Accion.pagar, 0);
    }

    public void jugar() {
        p.getPartida().jugarOtraMano();
    }

    public void salir() {
        p.getPartida().deleteObserver(this);
        p.getPartida().accion(p, Partida.Accion.salir, 0);
    }

    @Override
    public void update(Observable o, Object e) {
        //===============  General ===============//
        if (e.equals(Partida.Eventos.actualizar)) {
            v.actualizarParticipantes(p);
        }
        if (e.equals(Partida.Eventos.iniciar)) {
            v.iniciar(p);
        }
        if (e.equals(Partida.Eventos.finalizar)) {
            v.finalizar(p);
        }
        if (e.equals(Partida.Eventos.iniciarMano)) {
            v.manoIniciar(p);
        }
        if (e.equals(Partida.Eventos.finalizarMano)) {
            if (p.getPartida().getJugadores().contains(p.getJugador())) {
                v.manoFinalizar(p);
            }
        }

        //========================================//
        if (e.equals(Partida.Eventos.saldoInsuficiente)) {
            if (!p.getPartida().getJugadores().contains(p.getJugador())) {
                v.saldoInsuficiente();
            }
        }
        if (e.equals(Partida.Eventos.responder)) {
            v.responder(p);
        }
        if (e.equals(Partida.Eventos.ganador)) {
            v.ganador(p);
        }

        if (e.equals(Partida.Eventos.retry)) {
            v.manoIniciar(p);
        }
    }
}

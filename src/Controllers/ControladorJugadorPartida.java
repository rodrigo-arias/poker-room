package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;
import Model.Mano;
import java.util.Observable;
import java.util.Observer;

public class ControladorJugadorPartida implements Observer {

    private IVistaJugadorPartida vista;
    private Participante participante;

    //==================  Constructor  ==================//
    public ControladorJugadorPartida(Participante participante, IVistaJugadorPartida vista) {
        this.vista = vista;
        this.participante = participante;
        Sistema.getInstance().observarPartida(participante.getPartida(), this);

        if (participante.getPartida().isActiva()) {
            participante.getPartida().getManoActual().addObserver(this);
        }
    }

    //==================  Properties  =================//
    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.cambiaronParticipantes)) {
            vista.actualizarParticipantes(participante);
        }

        if (evento.equals(Partida.Eventos.inicioPartida)) {
            vista.iniciarPartida(participante);
        }

        if (evento.equals(Partida.Eventos.inicioMano)) {
            participante.getPartida().getManoActual().addObserver(this);
        }

        if (evento.equals(Mano.Eventos.cartasRepartidas)) {
            vista.actualizarCartas(participante);
        }

        if (evento.equals(Partida.Eventos.finalizoPartida)) {
            vista.finalizarPartida(participante);
        }

        if (evento.equals(Mano.Eventos.hayApuesta)) {
            vista.mostrarApuesta(participante);
        }

        if (evento.equals(Mano.Eventos.hayGanador)) {
            vista.mostrarGanador(participante);
        }

        if (evento.equals(Partida.Eventos.finalizoMano)) {
            vista.actualizarMano(participante);
        }
    }

    public void salir() {
        participante.getPartida().quitarJugador(participante.getJugador());
    }

    public void apostar(int apuesta) {
        if (!participante.getPartida().accion(participante.getJugador(), Mano.Accion.aposto, apuesta)) {
            vista.mostrarError("No puedes apostar esa cantidad");
        }
    }

    public void pasar() {
        participante.getPartida().accion(participante.getJugador(), Mano.Accion.paso, 0);
    }
}

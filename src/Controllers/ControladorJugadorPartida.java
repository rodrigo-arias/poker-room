package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;
import Model.Mano;
import java.util.Observable;
import java.util.Observer;

public class ControladorJugadorPartida implements Observer {

    private VistaJugadorPartida vista;
    private Participante participante;

    //==================  Constructor  ==================//
    public ControladorJugadorPartida(Participante participante, VistaJugadorPartida vista) {
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
            vista.updateParticipantes(participante);
        }

        if (evento.equals(Partida.Eventos.inicioPartida)) {
            vista.partidaIniciar(participante);
        }

        if (evento.equals(Partida.Eventos.inicioMano)) {
            participante.getPartida().getManoActual().addObserver(this);
        }

        if (evento.equals(Mano.Eventos.cartasRepartidas)) {
            vista.updateCartas(participante);
        }

        if (evento.equals(Partida.Eventos.finalizoPartida)) {
            vista.partidaFinalizar(participante);
        }

        if (evento.equals(Mano.Eventos.hayApuesta)) {
            vista.showApuesta(participante);
        }

        if (evento.equals(Mano.Eventos.alguienPago)) {
            vista.showPago(participante);
        }

        if (evento.equals(Mano.Eventos.hayGanador)) {
            vista.showGanador(participante);
        }

        if (evento.equals(Partida.Eventos.finalizoMano)) {
            if (participante.getPartida().getJugadores().contains(participante.getJugador())) {
                vista.manoFinalizar(participante);
            }
        }

        if (evento.equals(Partida.Eventos.saldoInsuficiente)) {
            if (!participante.getPartida().getJugadores().contains(participante.getJugador())) {
                vista.showSaldoInsuficiente();
            }
        }

        if (evento.equals(Partida.Eventos.otraMano)) {
            vista.manoIniciar(participante);
        }
    }

    public void salir() {
        participante.getPartida().quitarJugador(participante);
    }

    public void apostar(int apuesta) {
        if (!participante.getPartida().accion(participante, Mano.Accion.aposto, apuesta)) {
            vista.showMessage("No puedes apostar esa cantidad");
        }
    }

    public void pasar() {
        participante.getPartida().accion(participante, Mano.Accion.paso, 0);
    }

    public void pagar() {
        participante.getPartida().accion(participante, Mano.Accion.pago, 0);
    }

    public void jugarOtraMano() {
        participante.getPartida().jugarOtraMano();
    }
}

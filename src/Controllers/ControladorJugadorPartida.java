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

        /**
         * ** REVISAR ***
         */
        participante.getPartida().getSiguienteMano().addObserver(this);
    }

    //==================  Properties  =================//
    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.participanteNuevo)) {
            vista.actualizarJugadores(participante);
        }

        if (evento.equals(Mano.Eventos.cartasRepartidas)) {
            vista.actualizarCartas(participante);
        }

        if (evento.equals(Partida.Eventos.partidaIniciada)) {
            vista.iniciarPartida(participante);
        }
    }
}

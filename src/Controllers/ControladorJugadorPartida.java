package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;
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
    }

    //==================  Properties  =================//
    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.participanteNuevo)) {
            vista.actualizarParticipantes(participante);
        }

        if (evento.equals(Partida.Eventos.partidaIniciada)) {
            vista.iniciarPartida();
        }
    }
}

package Controllers;

import Model.Participante;
import Model.Partida;
import java.util.Observable;
import java.util.Observer;

public class ControladorPartida implements Observer {

    private IVistaPartida vista;
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }

    //==================  Constructor  ==================//
    public ControladorPartida(Participante participante, IVistaPartida vista) {
        this.vista = vista;
        this.participante = participante;
        participante.getPartida().addObserver(this);
    }

    //==================  Properties  =================//
    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.actualizarParticipantes)) {
            vista.actualizarParticipantes(participante);
        }
        if(evento.equals(Partida.Eventos.actualizarParticipantesListado)) {
            vista.actualizarParticipantesListado(participante);
        }
    }

    public void salirPartida() {
        this.participante.getPartida().salirPartida(this.participante);
    }
}
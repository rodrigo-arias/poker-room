package Controllers;

import Model.Participante;
import Model.Partida;
import java.util.Observable;
import java.util.Observer;

public class ControladorPartida implements Observer {

    private Partida partida;
    private IVistaPartida vista;

    public ControladorPartida(Partida partida, Participante participante, IVistaPartida vista) {
        this.partida = partida;
        this.vista = vista;
        partida.addObserver(this);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.actualizarParticipantes)) {
            vista.actualizarParticipantes();
        }
    }
}

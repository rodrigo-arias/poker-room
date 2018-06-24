package Controllers;

import Model.Partida;
import Model.Sistema;
import Model.SistemaPartida;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminMonitor implements Observer {

    private VistaAdminMonitor vista;
    private ArrayList<Partida> partidas;

    //==================  Constructor  ==================//
    public ControladorAdminMonitor(ArrayList<Partida> partidas, VistaAdminMonitor vista) {
        this.vista = vista;
        this.partidas = partidas;
        Sistema.getInstance().observarPartidas(this);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.cambiaronParticipantes)
                || evento.equals(SistemaPartida.Eventos.partidaActualizada)) {
            vista.actualizar();
        }

        if (evento.equals(SistemaPartida.Eventos.partidaNueva)) {
            Sistema.getInstance().observarNuevaPartida(this);
            vista.actualizar();
        }
    }
}

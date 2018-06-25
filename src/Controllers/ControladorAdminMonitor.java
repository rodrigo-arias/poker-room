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
    public ControladorAdminMonitor(ArrayList<Partida> p, VistaAdminMonitor v) {
        this.vista = v;
        this.partidas = p;
        Sistema.instancia().observarPartidas(this);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.actualizar)
                || evento.equals(SistemaPartida.Eventos.partidaActualizada)) {
            vista.actualizarPartidas();
        }

        if (evento.equals(SistemaPartida.Eventos.partidaNueva)) {
            Sistema.instancia().observarNuevaPartida(this);
            vista.actualizarPartidas();
        }
    }
}

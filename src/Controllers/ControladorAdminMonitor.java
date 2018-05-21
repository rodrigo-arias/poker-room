package Controllers;

import Model.Partida;
import Model.Sistema;
import Model.SistemaPartida;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminMonitor implements Observer {

    private IVistaAdminMonitor vista;
    private ArrayList<Partida> partidas;

    //==================  Constructor  ==================//
    public ControladorAdminMonitor(ArrayList<Partida> partidas, IVistaAdminMonitor vista) {
        this.vista = vista;
        this.partidas = partidas;
        Sistema.getInstance().observarPartidas(this);
    }

    public Boolean guardar(int id, int tam, int base) {
        //return Sistema.getInstance().actualizarPartida(id, tam, base);
        return false;
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.participanteNuevo)
                || evento.equals(SistemaPartida.Eventos.partidaNueva)
                || evento.equals(SistemaPartida.Eventos.partidaActualizada)) {
            vista.actualizar();
        }
    }
}

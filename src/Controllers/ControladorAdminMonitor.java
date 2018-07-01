package Controllers;

import Model.Partida;
import Model.Sistema;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminMonitor implements Observer {

    private VistaAdminMonitor vista;
    private Sistema sistema = Sistema.instancia();

    //==================  Constructor  ==================//
    public ControladorAdminMonitor(VistaAdminMonitor vista) {
        this.vista = vista;
        this.sistema.addObserver(this);
    }

    @Override
    public void update(Observable o, Object e) {

        if (e.equals(Partida.Eventos.actualizar)
                || e.equals(Sistema.Eventos.partidaActualizada)
                || e.equals(Sistema.Eventos.jugadorActualizado)) {
            vista.actualizarPartidas();
        }

        if (e.equals(Sistema.Eventos.partidaNueva)) {
            sistema.proximaPartida().addObserver(this);
            vista.actualizarPartidas();
        }
    }
}

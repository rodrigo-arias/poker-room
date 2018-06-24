package Controllers;

import Model.Partida;
import Model.Sistema;
import Model.SistemaPartida;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminConfig implements Observer {

    private VistaAdminConfig vista;
    private ArrayList<Partida> partidas;

    //==================  Constructor  ==================//
    public ControladorAdminConfig(VistaAdminConfig vista) {
        this.vista = vista;
        Sistema.getInstance().observarPartidas(this);
    }

    public int actualizarTam(int tam) {
        return Sistema.getInstance().actualizarDefaultTam(tam);
    }

    public int actualizarBase(int base) {
        return Sistema.getInstance().actualizarDefaultBase(base);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(SistemaPartida.Eventos.partidaActualizada)) {
            vista.actualizar();
        }
    }
}

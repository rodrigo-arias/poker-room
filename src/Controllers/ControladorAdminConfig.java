package Controllers;

import Model.Sistema;
import Model.SistemaPartida;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminConfig implements Observer {

    private VistaAdminConfig vista;

    //==================  Constructor  ==================//
    public ControladorAdminConfig(VistaAdminConfig vista) {
        this.vista = vista;
        Sistema.instancia().observarPartidas(this);
    }

    public int actualizarTam(int tam) {
        return Sistema.instancia().actualizarDefaultTam(tam);
    }

    public int actualizarBase(int base) {
        return Sistema.instancia().actualizarDefaultBase(base);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(SistemaPartida.Eventos.partidaActualizada)) {
            vista.actualizar();
        }
    }
}

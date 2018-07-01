package Controllers;

import Model.Sistema;
import java.util.Observable;
import java.util.Observer;

public class ControladorAdminConfig implements Observer {

    private Sistema sistema = Sistema.instancia();
    private VistaAdminConfig vista;

    //==================  Constructor  ==================//
    public ControladorAdminConfig(VistaAdminConfig vista) {
        this.vista = vista;
        this.sistema.addObserver(this);
    }

    public int actualizarTam(int tam) {
        return sistema.inicialTam(tam);
    }

    public int actualizarBase(int base) {
        return sistema.inicialBase(base);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Sistema.Eventos.partidaActualizada)) {
            vista.actualizar();
        }
    }
}

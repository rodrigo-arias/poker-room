package Controllers;

import Model.Partida;
import java.util.ArrayList;

public interface IVistaMonitor {

    public void mostrarError(String msg);

    public void cargarPartidas(ArrayList<Partida> partidas);

}

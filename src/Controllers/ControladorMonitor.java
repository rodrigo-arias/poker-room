package Controllers;

import Model.Partida;
import java.util.ArrayList;

public class ControladorMonitor {

    private IVistaMonitor vista;
    private ArrayList<Partida> partidas;

    //==================  Constructor  ==================//
    public ControladorMonitor(ArrayList<Partida> partidas, IVistaMonitor vista) {
        this.vista = vista;
        this.partidas = partidas;
        //partidas.addObserver(this);
    }

    //==================  Properties  =================//
//    @Override
//    public void update(Observable o, Object evento) {
//        if (evento.equals(Partida.Eventos.actualizarParticipantes)) {
//            vista.actualizarParticipantes(participante);
//        }
//    }
}

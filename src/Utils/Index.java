package Utils;

import Model.Admin;
import Model.Jugador;
import Model.Sistema;
import Views.Launcher;

public class Index {

    public static void main(String[] args) {
        cargarDatos();
        new Launcher(null, false).setVisible(true);
    }

    private static void cargarDatos() {
        Sistema s = Sistema.getInstance();

        //===================  Partidas  ===================//
        s.setBase(10);
        s.setTam(2);
        s.crearProximaPartida();

        //==================  Jugadores  ==================//
        s.registrarJugador(new Jugador("a", "a", "Ana", 350));
        s.registrarJugador(new Jugador("b", "b", "Beatriz", 100));
        s.registrarJugador(new Jugador("c", "c", "Carlos", 200));
        s.registrarJugador(new Jugador("d", "d", "Daniel", 50));
        s.registrarJugador(new Jugador("e", "e", "Esteban", 150));

        //===================  Admins  ====================//
        s.registrarAdmin(new Admin("r", "r", "Rodrigo"));
        s.registrarAdmin(new Admin("n", "n", "Nicolas"));
    }
}

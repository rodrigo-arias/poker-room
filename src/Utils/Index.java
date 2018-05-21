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
        Sistema model = Sistema.getInstance();

        model.setBase(10);
        model.setTam(3);
        model.crearProximaPartida();

        model.agregarJugador(new Jugador("a", "a", "Ana", 100));
        model.agregarJugador(new Jugador("b", "b", "Beatriz", 100));
        model.agregarJugador(new Jugador("c", "c", "Carlos", 100));
        model.agregarJugador(new Jugador("d", "d", "Daniel", 100));
        model.agregarJugador(new Jugador("e", "e", "Esteban", 100));

        model.agregarAdmin(new Admin("r", "r", "Rodrigo"));
        model.agregarAdmin(new Admin("n", "n", "Nicolas"));
    }
}

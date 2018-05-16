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

        model.setBase(1);
        model.setMax(2);
        model.setPozo(3);
        model.crearProximaPartida();

        model.agregarJugador(new Jugador("a", "a", "Ana"));
        model.agregarJugador(new Jugador("b", "b", "Beatriz"));
        model.agregarJugador(new Jugador("c", "c", "Carlos"));

        model.agregarAdmin(new Admin("d", "d", "Rodrigo"));
        model.agregarAdmin(new Admin("e", "e", "Nicolas"));

    }

}

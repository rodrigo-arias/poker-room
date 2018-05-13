package Utils;

import Model.Jugador;
import Model.Sistema;
import Views.Login;

public class Index {

    public static void main(String[] args) {

        cargarDatos();

        new Login(null, false).setVisible(true);
        new Login(null, false).setVisible(true);
        new Login(null, false).setVisible(true);
    }

    private static void cargarDatos() {
        Sistema model = Sistema.getInstance();

        model.addJugador(new Jugador("a", "a", "Ana"));
        model.addJugador(new Jugador("b", "b", "Beatriz"));
        model.addJugador(new Jugador("c", "c", "Carlos"));
    }

}

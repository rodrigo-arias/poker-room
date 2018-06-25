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
        Sistema s = Sistema.instancia();

        //===================  Partidas  ===================//
        s.setBase(10);
        s.setTam(3);
        s.crearProximaPartida();

        //==================  Jugadores  ==================//
        s.registrarJugador(new Jugador("a", "a", "Ana", 350));
        s.registrarJugador(new Jugador("b", "b", "Beatriz", 100));
        s.registrarJugador(new Jugador("c", "c", "Carlos", 200));
        s.registrarJugador(new Jugador("d", "d", "Daniel", 50));
        s.registrarJugador(new Jugador("e", "e", "Esteban", 150));

        s.registrarJugador(new Jugador("carolina03", "carolina1234", "Carolina", 150));
        s.registrarJugador(new Jugador("gonza05", "gg05", "Gonzalo Gomez", 200));
        s.registrarJugador(new Jugador("juan27", "juanpa01", "Juan Martinez", 250));
        s.registrarJugador(new Jugador("estebanN", "esteban12", "Esteban Mas", 90));

        //===================  Admins  ====================//
        s.registrarAdmin(new Admin("r", "r", "Rodrigo"));
        s.registrarAdmin(new Admin("n", "n", "Nicolas"));

        s.registrarAdmin(new Admin("marcelo12", "marceP12", "Marcelo Perez"));
        s.registrarAdmin(new Admin("cecilia19", "cecilia19", "Cecilia Malaga"));
    }
}

package Utils;

import Model.Admin;
import Model.Color;
import Model.DoblePar;
import Model.Jugador;
import Model.Par;
import Model.Sistema;
import Views.Launcher;

public class Index {

    public static void main(String[] args) {

        Sistema sistema = Sistema.instancia();

        //===================  Partidas  ===================//
        sistema.crearProximaPartida();

        //===================  Figuras  ===================//
        sistema.registrarFigura(new Par());
        sistema.registrarFigura(new DoblePar());
        sistema.registrarFigura(new Color());

        //==================  Jugadores  ==================//
        sistema.registrarJugador(new Jugador("a", "a", "Ana", 350));
        sistema.registrarJugador(new Jugador("b", "b", "Beatriz", 100));
        sistema.registrarJugador(new Jugador("c", "c", "Carlos", 200));
        sistema.registrarJugador(new Jugador("d", "d", "Daniel", 50));
        sistema.registrarJugador(new Jugador("e", "e", "Esteban", 150));

        sistema.registrarJugador(new Jugador("carolina03", "carolina1234", "Carolina", 150));
        sistema.registrarJugador(new Jugador("gonza05", "gg05", "Gonzalo Gomez", 200));
        sistema.registrarJugador(new Jugador("juan27", "juanpa01", "Juan Martinez", 250));
        sistema.registrarJugador(new Jugador("estebanN", "esteban12", "Esteban Mas", 90));

        //===================  Admins  ====================//
        sistema.registrarAdmin(new Admin("r", "r", "Rodrigo"));
        sistema.registrarAdmin(new Admin("n", "n", "Nicolas"));

        sistema.registrarAdmin(new Admin("marcelo12", "marceP12", "Marcelo Perez"));
        sistema.registrarAdmin(new Admin("cecilia19", "cecilia19", "Cecilia Malaga"));

        new Launcher(null, false).setVisible(true);
    }
}

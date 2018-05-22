package Utils;

import Model.Admin;
import Model.Carta;
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

        model.agregarAdmin(new Admin("d", "d", "Rodrigo"));
        model.agregarAdmin(new Admin("e", "e", "Nicolas"));
        
        /*
        * CARGA DE CARTAS
        */
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/10c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/10d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/10p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/10t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/2c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/2d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/2p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/2t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/3c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/3d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/3p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/3t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/4c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/4d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/4p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/4t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/5c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/5d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/5p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/5t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/6c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/6d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/6p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/6t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/7c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/7d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/7p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/7t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/8c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/8d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/8p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/8t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/9c.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/9d.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/9p.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/9t.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Ac.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Ad.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Ap.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/At.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Jc.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Jd.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Jp.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Jt.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Kc.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Kd.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Kp.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Kt.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Qc.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Qd.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Qp.gif"));
        model.getMazo().agregarCarta(new Carta(1, "/Assets/Cartas/Qt.gif"));
    }
}

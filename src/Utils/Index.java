package Utils;

import Persistence.MapeadorJugador;
import Model.Admin;
import Model.Color;
import Model.DoblePar;
import Model.Par;
import Model.Sistema;
import Persistence.BaseDatos;
import Persistence.Persistencia;
import Views.Launcher;

public class Index {

    public static void main(String[] args) {

        //==================  Attributes  ==================//
        Sistema sistema = Sistema.instancia();
        Persistencia persistencia = Persistencia.instancia();
        BaseDatos db = BaseDatos.instancia();

        //===================  Partidas  ===================//
        sistema.crearProximaPartida();

        //===================  Figuras  ===================//
        sistema.registrarFigura(new Par());
        sistema.registrarFigura(new DoblePar());
        sistema.registrarFigura(new Color());

        //==================  Jugadores  ==================//
        sistema.cargarJugadores(persistencia.all(new MapeadorJugador()));
        db.close();

        //===================  Admins  ====================//
        sistema.registrarAdmin(new Admin("r", "r", "Rodrigo"));
        sistema.registrarAdmin(new Admin("n", "n", "Nicolas"));

        sistema.registrarAdmin(new Admin("marcelo12", "marceP12", "Marcelo Perez"));
        sistema.registrarAdmin(new Admin("cecilia19", "cecilia19", "Cecilia Malaga"));

        new Launcher(null, false).setVisible(true);
    }
}

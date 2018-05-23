package Model;

import java.util.ArrayList;
import java.util.Observer;

public class Sistema {

    //==================  Attributes  ==================//
    private SistemaJugador sj = new SistemaJugador();
    private SistemaAdmin sa = new SistemaAdmin();
    private SistemaPartida sp = new SistemaPartida();

    //==================  Singleton  ==================//
    private static Sistema instance = new Sistema();

    public static Sistema getInstance() {
        return instance;
    }

    private Sistema() {
    }

    //==================  Sis. Jugador  ==================//
    public boolean registrarJugador(Jugador j) {
        return sj.registrarJugador(j);
    }

    public Participante loginJugador(String user, String pass) {
        return sj.loginJugador(user, pass);
    }

    //===================  Sis. Admin  ===================//
    public boolean registrarAdmin(Admin a) {
        return sa.registrarAdmin(a);
    }

    public Admin loginAdmin(String user, String pass) {
        return sa.loginAdmin(user, pass);
    }

    //==================  Sis. Partida  ==================//
    public void crearProximaPartida() {
        sp.crearProximaPartida();
    }

    public Partida getProximaPartida() {
        return sp.getProximaPartida();
    }

    public void setBase(int base) {
        sp.setBase(base);
    }

    public void setTam(int tam) {
        sp.setTam(tam);
    }

    public int actualizarDefaultBase(int base) {
        return sp.actualizarDefaultBase(base);
    }

    public int actualizarDefaultTam(int tam) {
        return sp.actualizarDefaultTam(tam);
    }

    //----------------------------------------------------//
    public ArrayList<Partida> getPartidas() {
        return sp.getPartidas();
    }

    public ArrayList<Partida> getPartidasActivas() {
        return sp.getPartidasActivas();
    }

    public Partida getPartidaId(int id) {
        return sp.getPartidaId(id);
    }
    //----------------------------------------------------//

    public void observarPartidas(Observer o) {
        sp.observarPartidas(o);
    }

    public void observarPartida(Partida p, Observer o) {
        sp.observarPartida(p, o);
    }
    //----------------------------------------------------//

}

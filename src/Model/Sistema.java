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
    public Participante loginJugador(String user, String pass) {
        return sj.loginJugador(user, pass);
    }

    public void agregarJugador(Jugador j) {
        sj.agregarJugador(j);
    }

    //===================  Sis. Admin  ===================//
    public Admin loginAdmin(String user, String pass) {
        return sa.loginAdmin(user, pass);
    }

    public void agregarAdmin(Admin a) {
        sa.agregarAdmin(a);
    }

    //==================  Sis. Partida  ==================//
    public void crearProximaPartida() {
        sp.crearProximaPartida();
    }

    public Partida getProximaPartida() {
        return sp.getProximaPartida();
    }

    public void setTam(int tam) {
        sp.setTam(tam);
    }

    public void setBase(int base) {
        sp.setBase(base);
    }

    public ArrayList<Partida> getPartidas() {
        return sp.getPartidas();
    }

    public ArrayList<Partida> getPartidasActivas() {
        return sp.getPartidasActivas();
    }

    public void observarPartidas(Observer o) {
        sp.observarPartidas(o);
    }

    public void observarPartida(Partida p, Observer o) {
        sp.observarPartida(p, o);
    }

    public int actualizarDefaultBase(int base) {
        return sp.actualizarDefaultBase(base);
    }

    public int actualizarDefaultTam(int tam) {
        return sp.actualizarDefaultTam(tam);
    }

    public Partida getPartidaId(int id) {
        return sp.getPartidaId(id);
    }

}

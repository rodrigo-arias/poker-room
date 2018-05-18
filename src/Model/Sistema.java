package Model;

import java.util.ArrayList;

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

}

package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Sistema extends Observable {

    //==================  Attributes  ==================//
    private static Sistema instancia = new Sistema();
    private SistemaJugador sj = new SistemaJugador();
    private SistemaAdmin sa = new SistemaAdmin();
    private SistemaPartida sp = new SistemaPartida();

    public enum Eventos {
        partidaNueva,
        partidaActualizada,
        jugadorActualizado;
    }

    //==================  Singleton  ==================//
    public static Sistema instancia() {
        return instancia;
    }

    private Sistema() {
    }

    protected void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    //==================  Sis. Jugador  ==================//
    public boolean registrarJugador(Jugador j) {
        return sj.registrarJugador(j);
    }

    public Participante ingresarJugador(String u, String p) {
        return sj.ingresarJugador(u, p);
    }

    //===================  Sis. Admin  ===================//
    public boolean registrarAdmin(Admin a) {
        return sa.registrarAdmin(a);
    }

    public Admin ingresarAdmin(String u, String p) {
        return sa.ingresarAdmin(u, p);
    }

    public void salirAdmin(Admin a) {
        sa.salirAdmin(a);
    }

    //==================  Sis. Partida  ==================//
    public void crearProximaPartida() {
        sp.crearProximaPartida();
    }

    public Partida proximaPartida() {
        return sp.getProximaPartida();
    }

    public int inicialBase(int base) {
        return sp.inicialBase(base);
    }

    public int inicialTam(int tam) {
        return sp.inicialTam(tam);
    }

    //----------------------------------------------------//
    protected ArrayList<Partida> partidasActivas() {
        return sp.partidasActivas();
    }

    public ArrayList<Partida> partidasTodas() {
        return sp.getPartidas();
    }

    public Partida partidaById(int id) {
        return sp.partidaById(id);
    }
}

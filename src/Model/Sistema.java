package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Sistema extends Observable {

    //==================  Attributes  ==================//
    private static Sistema instancia = new Sistema();
    private SistemaJugador sj = new SistemaJugador();
    private SistemaAdmin sa = new SistemaAdmin();
    private SistemaPartida sp = new SistemaPartida();
    private SistemaParticipante ss = new SistemaParticipante();

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

    public void cargarJugadores(ArrayList<Object> lista) {
        sj.cargarJugadores(lista);
    }

    protected void actualizarJugador(Jugador j) {
        sj.actualizarJugador(j);
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

    //================  Sis. Participante  ===============//
    public ArrayList<Participante> participantesPartida(Partida p) {
        return ss.participantesPartida(p);
    }

    public void registrarParticipante(Participante p) {
        ss.registrarParticipante(p);
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

    public void mejorFigura(Participante p) {
        sp.mejorFigura(p);
    }

    protected void guardarPartida(Partida p) {
        sp.guardarPartida(p);
    }

    public void cargarPartidas(ArrayList<Object> lista) {
        sp.cargarPartidas(lista);
    }

    //----------------------------------------------------//
    protected ArrayList<Partida> partidasActivas() {
        return sp.partidasActivas();
    }

    public ArrayList<Partida> partidasTodas() {
        return sp.getPartidas();
    }

    public Partida partidaByIndex(int index) {
        return sp.partidaByIndex(index);
    }
    //----------------------------------------------------//

    public void registrarFigura(Figura figura) {
        sp.registrarFigura(figura);
    }

}

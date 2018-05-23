package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable {

    //==================  Attributes  ==================//
    private int id;
    private int tam;
    private int pozo;
    private int base;
    private LocalDateTime inicio;
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manos;
    private boolean activa;

    public enum Eventos {
        participanteNuevo,
        partidaIniciada;
    }

    //==================  Constructor  =================//
    public Partida(int id, int tam, int base) {
        this.id = id;
        this.tam = tam;
        this.pozo = 0;
        this.base = base;
        this.inicio = null;
        this.mazo = new Mazo();
        this.jugadores = new ArrayList();
        this.manos = new ArrayList();
        this.activa = false;
    }

    //==================  Properties  =================//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getBase() {
        return base;
    }

    public int getTam() {
        return tam;
    }

    public int getPozo() {
        return pozo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public boolean isActiva() {
        return activa;
    }

    //==================  Methods  ==================//
    public void agregarJugador(Jugador j) {
        jugadores.add(j);

        // Paga apuesta base y se conforma el pozo
        j.setSaldo(j.getSaldo() - this.base);
        this.pozo += base;
        avisar(Eventos.participanteNuevo);

        if (this.jugadores.size() == this.tam) {
            // Se completaron los participante, creo una nueva partida e inicio la actual
            Sistema.getInstance().crearProximaPartida();
            this.iniciar();
        }
    }

    public void iniciar() {
        this.inicio = LocalDateTime.now();
        this.activa = true;
        avisar(Eventos.partidaIniciada);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public int getTotalApostado() {
        return 0;
    }
}

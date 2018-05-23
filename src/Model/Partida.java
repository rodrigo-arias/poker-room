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
    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manos;
    private boolean activa;
    private Mano siguienteMano;

    public enum Eventos {
        participanteNuevo,
        partidaIniciada,
        repartirCartas;
    }

    //==================  Constructor  =================//
    public Partida(int id, int tam, int base) {
        this.id = id;
        this.tam = tam;
        this.pozo = 0;
        this.base = base;
        this.inicio = null;
        this.jugadores = new ArrayList();
        this.manos = new ArrayList();
        this.activa = false;
        this.siguienteMano = new Mano();
        this.manos.add(siguienteMano);
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

    public Mano getSiguienteMano() {
        return siguienteMano;
    }

    public boolean isActiva() {
        return activa;
    }

    //==================  Methods  ==================//
    public Participante agregarJugador(Jugador j) {
        Participante p = null;

        // No se encuentra en la prox. partida, y tiene saldo de apuesta base x cant. de jugadores
        if (!this.getJugadores().contains(j) && j.getSaldo() >= this.getBase() * this.getTam()) {

            // Jugador válido, creo el participante y agrego el jugador a la próxima partida
            p = new Participante(j, this);
            jugadores.add(j);

            // Paga apuesta base y se conforma el pozo
            j.pagarIngreso(base);
            this.pozo += base;
            avisar(Eventos.participanteNuevo);

            if (this.jugadores.size() == this.tam) {
                // Se completaron los participante, creo una nueva partida e inicio la actual
                Sistema.getInstance().crearProximaPartida();
                this.iniciar();
            }
        }
        return p;
    }

    public void iniciar() {
        this.inicio = LocalDateTime.now();
        this.activa = true;

        avisar(Eventos.repartirCartas);
        avisar(Eventos.partidaIniciada);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public int getTotalApostado() {
        return 0;
    }

    public void repartirCartas(Participante p) {
        siguienteMano.repartirCartas(p);
    }
}

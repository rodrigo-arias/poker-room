package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Mano extends Observable {

    private Mazo mazo;
    private Apuesta apuesta;
    private Jugador ganador;
    private ArrayList<Jugador> jugando;
    private ArrayList<Jugador> pasaron;
    private ArrayList<Jugador> pagaron;
    private int respuesta;
    private int pozo;
    private Carta cartaGanadora;

    public enum Accion {
        paso,
        pago,
        aposto,
        salio;
    }

    public enum Eventos {
        cartasRepartidas,
        hayApuesta,
        hayGanador;
    }

    //==================  Constructor  ==================//
    public Mano(ArrayList<Jugador> jugando) {
        this.mazo = new Mazo();
        this.mazo.barajar();
        this.apuesta = null;
        this.jugando = jugando;
        this.pagaron = new ArrayList<>();
        this.pasaron = new ArrayList<>();
        this.respuesta = 0;
        this.pozo = 0;
        this.cartaGanadora = null;
    }

    //==================  Properties  =================//
    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public int getPozo() {
        return pozo;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    //==================  Methods  ==================//
    public void repartirCartas(Participante p) {
        p.setCartas(this.mazo.repartir(5));
        avisar(Eventos.cartasRepartidas);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public void retirarJugador(Jugador j) {
        if (this.jugando.contains(j)) {
            jugando.remove(j);
        }
    }

    public boolean accion(Jugador j, Accion accion, int apuesta) {

        switch (accion) {
            case salio:
                retirarJugador(j);
                break;
            case aposto:
                hayApuesta(j, apuesta);
                respuesta++;
                break;
            case paso:
                this.pasaron.add(j);
                respuesta++;
                break;
        }
        return evaluarMano();
    }

    public boolean evaluarMano() {
        if (respuesta == jugando.size()) {
            if (jugando.size() == pasaron.size()) {
                this.ganador = null;
            } else {
                if (pagaron.size() == 1) {
                    this.ganador = pagaron.get(0);
                } else {
                    compararCartas();
                }
            }
            avisar(Eventos.hayGanador);
            return true;
        }
        return false;
    }

    private void compararCartas() {
        // Agregar logica de comparacion de cartas
        this.ganador = pagaron.get(0);
    }

    private void hayApuesta(Jugador j, int valor) {
        this.apuesta = new Apuesta(j, valor);

        this.pagaron.add(j);
        this.pasaron = new ArrayList<>();
        this.pozo += valor;
        avisar(Eventos.hayApuesta);
    }
}

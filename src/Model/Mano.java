package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Mano extends Observable {

    private Mazo mazo;
    private Apuesta apuesta;
    private Participante ganador;
    private ArrayList<Participante> jugando;
    private ArrayList<Participante> pasaron;
    private ArrayList<Participante> pagaron;
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
    public Mano() {
        this.mazo = new Mazo();
        this.mazo.barajar();
        this.apuesta = null;
        this.jugando = new ArrayList<>();
        this.pagaron = new ArrayList<>();
        this.pasaron = new ArrayList<>();
        this.respuesta = 0;
        this.pozo = 0;
        this.cartaGanadora = null;
    }

    //==================  Properties  =================//
    public Participante getGanador() {
        return ganador;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public int getPozo() {
        return pozo;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public ArrayList<Participante> getPagaron() {
        return pagaron;
    }

    public Carta getCartaGanadora() {
        return cartaGanadora;
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

    public void retirarParticipante(Participante p) {
        if (this.jugando.contains(p)) {
            jugando.remove(p);
        }
    }

    public boolean accion(Participante p, Accion accion, int apuesta) {

        switch (accion) {
            case salio:
                retirarParticipante(p);
                break;
            case aposto:
                hayApuesta(p, apuesta);
                respuesta++;
                break;
            case paso:
                this.pasaron.add(p);
                respuesta++;
                break;
            case pago:
                this.pagaron.add(p);
                this.pozo += this.apuesta.getValor();
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
                    this.cartaGanadora = pagaron.get(0).mejorCarta();
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
        Participante mejor = pagaron.get(0);

        for (int i = 1; i < pagaron.size(); i++) {

            // Ganador es el que tiene la mejor carta entre las mejores de cada participante
            if (pagaron.get(0).mejorCarta().compareTo(pagaron.get(i).mejorCarta()) > 0) {
                mejor = pagaron.get(i);
            }
        }
        this.ganador = mejor;
        this.cartaGanadora = mejor.mejorCarta();
    }

    private void hayApuesta(Participante p, int valor) {
        this.apuesta = new Apuesta(p, valor);

        // Agregó a la lista de pagadores a quien apostó y reinicio las respuestas
        this.pagaron.add(p);
        this.pasaron = new ArrayList<>();
        this.respuesta = 0;
        this.pozo += valor;
        avisar(Eventos.hayApuesta);
    }

    public void participar(Participante p) {
        this.jugando.add(p);
    }

}

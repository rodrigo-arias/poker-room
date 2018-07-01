package Model;

import java.util.ArrayList;

public class Mano {

    private Mazo mazo;
    private Apuesta apuesta;
    private Participante ganador;
    private ArrayList<Participante> jugando;
    private ArrayList<Participante> pasaron;
    private ArrayList<Participante> pagaron;
    private int respuesta;
    private int pozo;
    private Carta carta;

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
        this.carta = null;
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
        return carta;
    }

    //==================  Methods  ==================//
    public boolean procesar(Participante p, Partida.Accion a, int m) {
        switch (a) {
            case salir:
                salir(p);
                break;
            case apostar:
                apostar(p, m);
                break;
            case pasar:
                pasar(p);
                break;
            case pagar:
                pagar(p, m);
                break;
        }
        return evaluarMano();
    }

    public boolean evaluarMano() {
        if (respuesta == jugando.size()) {
            if (jugando.size() == pasaron.size()) {
                ganador = null;
            } else {
                if (pagaron.size() == 1) {
                    ganador = pagaron.get(0);
                    carta = pagaron.get(0).mejorCarta();
                } else {
                    compararCartas();
                }
            }
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
        ganador = mejor;
        carta = mejor.mejorCarta();
    }

    //===============================================//
    public void repartir(Participante p) {
        p.setCartas(this.mazo.repartir(5));
    }

    void jugar(Participante p) {
        jugando.add(p);
    }

    private void apostar(Participante p, int valor) {
        apuesta = new Apuesta(p, valor);

        // Agregó a la lista de pagadores a quien apostó y reinicio las respuestas
        pagaron.add(p);
        pasaron = new ArrayList<>();
        respuesta = 1;
        pozo += valor;
    }

    private void pasar(Participante p) {
        respuesta++;
        pasaron.add(p);
    }

    private void pagar(Participante p, int m) {
        respuesta++;
        pagaron.add(p);
        pozo += apuesta.getValor();
    }

    public void salir(Participante p) {
        if (jugando.contains(p)) {
            jugando.remove(p);
        }
    }

    public void salir(Jugador j) {
        Participante b = null;
        for (Participante p : jugando) {
            if (p.getJugador().equals(j)) {
                b = p;
            }
        }
        if (b != null) {
            jugando.remove(b);
        }
    }

    public boolean jugando(Participante p) {
        return jugando.contains(p) && !pasaron.contains(p);
    }

    public boolean apuesta() {
        return apuesta != null;
    }
}

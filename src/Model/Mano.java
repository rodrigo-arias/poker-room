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
    private ArrayList<Carta> ganadoras;

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
        this.ganadoras = new ArrayList<>();
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

    public ArrayList<Carta> getGanadoras() {
        return ganadoras;
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
                    cartasGanadoras();

                } else {
                    evaluarGanador();
                }
            }
            return true;
        }
        return false;
    }

    private void evaluarGanador() {
        Participante mejor = pagaron.get(0);

        for (int i = 1; i < pagaron.size(); i++) {

            Participante otro = pagaron.get(i);

            // Defino mejor figura y carta de los dos participantes a comparar
            Figura mejorFigura = mejor.getFigura();
            Figura otraFigura = pagaron.get(i).getFigura();
            Carta mejorCarta = mejor.mejorCarta();
            Carta otraCarta = pagaron.get(i).mejorCarta();

            // Los dos tienen figura, las comparo
            if (mejorFigura != null && otraFigura != null) {
                //int comparacion = mejorFigura.compareTo(otraFigura);

                // El otro tiene la mejor figura
                if (mejorFigura.compareTo(otraFigura) > 0) {
                    mejor = pagaron.get(i);
                }

            } else if (mejorFigura != null && otraFigura == null) {
                // El mejor es el único que tiene figura

            } else if (mejorFigura == null && otraFigura != null) {
                // El otro es el único que tiene figura
                mejor = otro;

            } else {
                // Ninguno tiene figura, define la carta mas alta
                if (mejorCarta.compareTo(otraCarta) > 0) {
                    mejor = otro;
                }
            }
        }
        ganador = mejor;
        cartasGanadoras();
    }

    private void cartasGanadoras() {
        if (ganador != null) {
            if (ganador.getFigura() != null) {
                ganadoras = ganador.getFigura().getConjunto();
            } else {
                ganadoras.add(ganador.mejorCarta());
            }
        }
    }

    //===============================================//
    public void repartir(Participante p) {
        p.setCartas(this.mazo.repartir(5));
        p.ordenarCartas();
        p.mejorFigura();
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

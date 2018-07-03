package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Participante implements Observer {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;
    private Jugador jugador;
    private Partida partida;
    private Figura figura;

    //==================  Properties  =================//
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Figura getFigura() {
        return figura;
    }

    //==================  Constructor  ==================//
    public Participante(Jugador jugador, Partida partida) {
        this.cartas = new ArrayList(5);
        this.jugador = jugador;
        this.partida = partida;
        this.figura = null;

        // Observa la partida que está jugando
        this.partida.addObserver(this);
    }

    //==================  Methods  ==================//
    @Override
    public void update(Observable o, Object e) {

        if (e.equals(Partida.Eventos.jugarMano)) {
            this.partida.jugarMano(this);
        }

        if (e.equals(Partida.Eventos.saldoInsuficiente)) {
            if (!partida.jugando(this)) {
                partida.deleteObserver(this);
            }
        }
    }

    public Carta mejorCarta() {
        Carta mejor = cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            if (mejor.compareTo(cartas.get(i)) > 0) {
                mejor = this.cartas.get(i);
            }
        }
        return mejor;
    }

    public void mejorFigura() {

        Par par = new Par(cartas);
        DoblePar doblepar = new DoblePar(cartas);
        Color color = new Color(cartas);

        if (par.valido()) {
            this.figura = par;
        }

        if (figura == par && doblepar.valido()) {
            this.figura = doblepar;
        }

        if (color.valido()) {
            this.figura = color;
        }
    }

    public void ordenarCartas() {

        for (int i = 0; i < cartas.size(); i++) {
            for (int j = 0; j < cartas.size(); j++) {
                if (cartas.get(i).compareTo(cartas.get(j)) > 0) {
                    Collections.swap(cartas, i, j);
                }
            }
        }
    }
}

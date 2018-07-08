package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Participante implements Observer {

    //==================  Attributes  ==================//
    private int oid;
    private ArrayList<Carta> cartas;
    private Jugador jugador;
    private Partida partida;
    private Figura figura;
    private int inicial;
    private int ganado;
    private int apostado;
    private String nombre;

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

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int getGanado() {
        return ganado;
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public int getApostado() {
        return apostado;
    }

    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //==================  Constructor  ==================//
    public Participante(Jugador jugador, Partida partida) {
        this.cartas = new ArrayList(5);
        this.jugador = jugador;
        this.partida = partida;
        this.figura = null;
        this.nombre = jugador.getNombre();

        // Observa la partida que está jugando
        this.partida.addObserver(this);
    }

    public Participante(String nombre, int inicial, int apostado, int ganado, Partida partida) {
        this.nombre = nombre;
        this.inicial = inicial;
        this.apostado = apostado;
        this.ganado = ganado;
        this.partida = partida;
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

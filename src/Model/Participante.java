package Model;

import java.util.ArrayList;

public class Participante {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;
    Jugador jugador;
    Partida partida;

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

    //==================  Constructor  ==================//
    public Participante(Jugador jugador, Partida partida) {
        this.cartas = new ArrayList(5);
        this.jugador = jugador;
        this.partida = partida;
    }
}

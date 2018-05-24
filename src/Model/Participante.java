package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Participante implements Observer {

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

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    //==================  Constructor  ==================//
    public Participante(Jugador jugador, Partida partida) {
        this.cartas = new ArrayList(5);
        this.jugador = jugador;
        this.partida = partida;

        // Observa la partida que está jugando
        this.partida.addObserver(this);
    }

    //==================  Methods  ==================//
    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Partida.Eventos.inicioMano)) {
            this.partida.participar(this);
        }
    }

    public Carta mejorCarta() {
        Carta mejor = this.cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            if (mejor.compareTo(cartas.get(i)) > 0) {
                mejor = this.cartas.get(i);
            }
        }
        return mejor;
    }
}

package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable {

    //==================  Attributes  ==================//
    private int tam;
    private int pozo;
    private int base;
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;

    public enum Eventos {
        actualizarParticipantes,
        actualizarParticipantesListado;
    }

    //==================  Constructor  =================//
    public Partida(int tam, int base) {
        this.tam = tam;
        this.pozo = 0;
        this.base = base;
        this.mazo = new Mazo();
        this.jugadores = new ArrayList();
    }

    //==================  Properties  =================//
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

    public Mazo getMazo() {
        return mazo;
    }

    
    
    //==================  Methods  ==================//
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }
    
    public void salirPartida(Participante participante) {
        for (int i = 0; i < this.jugadores.size(); i++) {
            if(this.jugadores.get(i).getUsuario() == participante.getJugador().getUsuario()) {
                this.jugadores.remove(participante.getJugador());
                this.avisar(Eventos.actualizarParticipantesListado);
            }
        }
    }
    
    public boolean repartirCartas(Participante participante) {
        boolean ret = false;
        this.mazo.embarajar();
        
        //for (int i = 0; i < this.jugadores.size(); i++) {
            //repartir cartas
            participante.setCartas(this.mazo.getCartas(5));
        //}
        
        return ret;
    }

}

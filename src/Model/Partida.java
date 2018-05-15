package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable {

    //==================  Attributes  ==================//
    private int max;
    private int pozo;
    private int base;
    private Mazo mazo;
    private ArrayList<Participante> participantes;

    public enum Eventos {
        actualizarParticipantes;
    }

    //==================  Constructor  =================//
    public Partida(int max, int pozo, int base) {
        this.max = max;
        this.pozo = pozo;
        this.base = base;
        this.mazo = new Mazo();
        this.participantes = new ArrayList();
    }

    //==================  Properties  =================//
    public void setMax(int max) {
        this.max = max;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    //==================  Methods  ==================//
    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

}

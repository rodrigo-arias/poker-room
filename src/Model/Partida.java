package Model;

import java.util.ArrayList;

public class Partida {

    //==================  Attributes  ==================//
    private int max;
    private int pozo;
    private int base;
    private ArrayList<Participante> participantes;

    //==================  Constructor  =================//
    public Partida(int max, int pozo, int base) {
        this.max = max;
        this.pozo = pozo;
        this.base = base;
        this.participantes = new ArrayList();
    }

    //==================  Properties  =================//
    public void setMax(int max) {
        this.max = max;
    }

    //==================  Methods  ==================//
    public void addParticipante(Participante p) {
        participantes.add(p);
    }
}

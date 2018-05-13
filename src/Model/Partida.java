package Model;

import java.util.ArrayList;

public class Partida {

    //==================  Attributes  ==================//
    private int max;
    private int pozo;
    private int base;
    private ArrayList<Participante> participantes = new ArrayList();

    //==================  Properties  =================//
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setMax(int max) {
        this.max = max;
    }

    //==================  Methods  ==================//
    public void addParticipante(Participante p) {
        participantes.add(p);
    }
}

package Model;

import java.util.ArrayList;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private ArrayList<Partida> partidas = new ArrayList();
    private Partida proximaPartida;
    private int defaultTam;
    private int defaultBase;

    //==================  Properties  ==================//
    public void setTam(int tam) {
        this.defaultTam = tam;
    }

    public void setBase(int base) {
        this.defaultBase = base;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        this.proximaPartida = new Partida(this.defaultTam, this.defaultBase);
        agregarPartida(proximaPartida);
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }

    public void agregarPartida(Partida p) {
        partidas.add(p);
    }
}

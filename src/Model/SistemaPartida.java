package Model;

import java.util.ArrayList;

public class SistemaPartida {

    //==================  Attributes  ==================//
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

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        this.proximaPartida = new Partida(this.defaultTam, this.defaultBase);
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }
    
    
}

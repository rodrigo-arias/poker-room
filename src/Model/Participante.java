package Model;

import java.util.ArrayList;

public class Participante {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;
    private int saldo;

    //==================  Properties  =================//
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    //==================  Constructor  ==================//
    public Participante(int saldo) {
        this.cartas = new ArrayList(5);
        this.saldo = saldo;
    }
}

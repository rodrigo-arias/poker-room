package Model;

import java.util.ArrayList;

public class Participante {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;
    private String nombre;
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

    public String getNombre() {
        return nombre;
    }
    
    

    //==================  Constructor  ==================//
    public Participante(String nombre, int saldo) {
        this.nombre = nombre;
        this.cartas = new ArrayList(5);
        this.saldo = saldo;
    }
}

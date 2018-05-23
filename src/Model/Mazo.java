package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;

    //==================  Constructor  ==================//
    public Mazo() {
        this.cartas = new ArrayList<>(52);

        this.cartas.add(new Carta(2, Carta.Palo.Corazon, "/Cartas/2c.jpg"));
        this.cartas.add(new Carta(2, Carta.Palo.Diamante, "/Cartas/2d.jpg"));
        this.cartas.add(new Carta(2, Carta.Palo.Pique, "/Cartas/2p.jpg"));
        this.cartas.add(new Carta(2, Carta.Palo.Trebol, "/Cartas/2t.jpg"));
        this.cartas.add(new Carta(3, Carta.Palo.Corazon, "/Cartas/3c.jpg"));
        this.cartas.add(new Carta(3, Carta.Palo.Diamante, "/Cartas/3d.jpg"));
        this.cartas.add(new Carta(3, Carta.Palo.Pique, "/Cartas/3p.jpg"));
        this.cartas.add(new Carta(3, Carta.Palo.Trebol, "/Cartas/3t.jpg"));
        this.cartas.add(new Carta(4, Carta.Palo.Corazon, "/Cartas/4c.jpg"));
        this.cartas.add(new Carta(4, Carta.Palo.Diamante, "/Cartas/4d.jpg"));
        this.cartas.add(new Carta(4, Carta.Palo.Pique, "/Cartas/4p.jpg"));
        this.cartas.add(new Carta(4, Carta.Palo.Trebol, "/Cartas/4t.jpg"));
        this.cartas.add(new Carta(5, Carta.Palo.Corazon, "/Cartas/5c.jpg"));
        this.cartas.add(new Carta(5, Carta.Palo.Diamante, "/Cartas/5d.jpg"));
        this.cartas.add(new Carta(5, Carta.Palo.Pique, "/Cartas/5p.jpg"));
        this.cartas.add(new Carta(5, Carta.Palo.Trebol, "/Cartas/5t.jpg"));
        this.cartas.add(new Carta(6, Carta.Palo.Corazon, "/Cartas/6c.jpg"));
        this.cartas.add(new Carta(6, Carta.Palo.Diamante, "/Cartas/6d.jpg"));
        this.cartas.add(new Carta(6, Carta.Palo.Pique, "/Cartas/6p.jpg"));
        this.cartas.add(new Carta(6, Carta.Palo.Trebol, "/Cartas/6t.jpg"));
        this.cartas.add(new Carta(7, Carta.Palo.Corazon, "/Cartas/7c.jpg"));
        this.cartas.add(new Carta(7, Carta.Palo.Diamante, "/Cartas/7d.jpg"));
        this.cartas.add(new Carta(7, Carta.Palo.Pique, "/Cartas/7p.jpg"));
        this.cartas.add(new Carta(7, Carta.Palo.Trebol, "/Cartas/7t.jpg"));
        this.cartas.add(new Carta(8, Carta.Palo.Corazon, "/Cartas/8c.jpg"));
        this.cartas.add(new Carta(8, Carta.Palo.Diamante, "/Cartas/8d.jpg"));
        this.cartas.add(new Carta(8, Carta.Palo.Pique, "/Cartas/8p.jpg"));
        this.cartas.add(new Carta(8, Carta.Palo.Trebol, "/Cartas/8t.jpg"));
        this.cartas.add(new Carta(9, Carta.Palo.Corazon, "/Cartas/9c.jpg"));
        this.cartas.add(new Carta(9, Carta.Palo.Diamante, "/Cartas/9d.jpg"));
        this.cartas.add(new Carta(9, Carta.Palo.Pique, "/Cartas/9p.jpg"));
        this.cartas.add(new Carta(9, Carta.Palo.Trebol, "/Cartas/9t.jpg"));
        this.cartas.add(new Carta(10, Carta.Palo.Corazon, "/Cartas/10c.jpg"));
        this.cartas.add(new Carta(10, Carta.Palo.Diamante, "/Cartas/10d.jpg"));
        this.cartas.add(new Carta(10, Carta.Palo.Pique, "/Cartas/10p.jpg"));
        this.cartas.add(new Carta(10, Carta.Palo.Trebol, "/Cartas/10t.jpg"));
        this.cartas.add(new Carta(11, Carta.Palo.Corazon, "/Cartas/Jc.jpg"));
        this.cartas.add(new Carta(11, Carta.Palo.Diamante, "/Cartas/Jd.jpg"));
        this.cartas.add(new Carta(11, Carta.Palo.Pique, "/Cartas/Jp.jpg"));
        this.cartas.add(new Carta(11, Carta.Palo.Trebol, "/Cartas/Jt.jpg"));
        this.cartas.add(new Carta(12, Carta.Palo.Corazon, "/Cartas/Qc.jpg"));
        this.cartas.add(new Carta(12, Carta.Palo.Diamante, "/Cartas/Qd.jpg"));
        this.cartas.add(new Carta(12, Carta.Palo.Pique, "/Cartas/Qp.jpg"));
        this.cartas.add(new Carta(12, Carta.Palo.Trebol, "/Cartas/Qt.jpg"));
        this.cartas.add(new Carta(13, Carta.Palo.Corazon, "/Cartas/Kc.jpg"));
        this.cartas.add(new Carta(13, Carta.Palo.Diamante, "/Cartas/Kd.jpg"));
        this.cartas.add(new Carta(13, Carta.Palo.Pique, "/Cartas/Kp.jpg"));
        this.cartas.add(new Carta(13, Carta.Palo.Trebol, "/Cartas/Kt.jpg"));
        this.cartas.add(new Carta(14, Carta.Palo.Corazon, "/Cartas/Ac.jpg"));
        this.cartas.add(new Carta(14, Carta.Palo.Diamante, "/Cartas/Ad.jpg"));
        this.cartas.add(new Carta(14, Carta.Palo.Pique, "/Cartas/Ap.jpg"));
        this.cartas.add(new Carta(14, Carta.Palo.Trebol, "/Cartas/At.jpg"));
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public ArrayList<Carta> repartir(int cant) {
        ArrayList<Carta> repartidas = new ArrayList<>(cant);

        for (int i = 0; i < cant; i++) {
            repartidas.add(this.cartas.get(0));
            this.cartas.remove(0);
        }
        return repartidas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

}

package Model;

import java.util.Observable;

public class Mano extends Observable {

    private Mazo mazo;
    private Apuesta apuesta;

    public enum Eventos {
        cartasRepartidas;
    }

    //==================  Constructor  ==================//
    public Mano() {
        this.mazo = new Mazo();
        this.apuesta = new Apuesta();
    }

    //==================  Methods  ==================//
    public void repartirCartas(Participante p) {
        this.mazo.barajar();

        p.setCartas(this.mazo.repartir(5));

        avisar(Eventos.cartasRepartidas);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }
}

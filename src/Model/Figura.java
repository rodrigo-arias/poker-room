package Model;

import java.util.ArrayList;

public abstract class Figura {

    //==================  Attributes  ==================//
    private ArrayList<Carta> mano = new ArrayList();
    private ArrayList<Carta> conjunto = new ArrayList();

    //==================  Properties  =================//
    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public ArrayList<Carta> getConjunto() {
        return conjunto;
    }

    public void setFigura(ArrayList<Carta> figura) {
        this.conjunto = figura;
    }

    //==================  Methods  ==================//
    public abstract boolean valido();

    public abstract String nombre();

    public abstract int jerarquia();

    public abstract int compareInternal(Object o);

    public int compareTo(Object o) {
        Figura otra = (Figura) o;

        if (this.jerarquia() > otra.jerarquia()) {
            return -1;
        } else if (this.jerarquia() < otra.jerarquia()) {
            return 1;
        } else {
            return 0;
        }
    }
}

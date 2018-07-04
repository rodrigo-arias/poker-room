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

    public abstract String getNombre();

    public abstract int getJerarquia();

    public abstract Figura crearNueva();

    //==================  Methods  ==================//
    public abstract boolean valido();

    public abstract int compareInternal(Object o);

    public int compareTo(Object o) {
        Figura otra = (Figura) o;

        if (this.getJerarquia() > otra.getJerarquia()) {
            return -1;
        } else if (this.getJerarquia() < otra.getJerarquia()) {
            return 1;
        } else {
            if (this.compareInternal(o) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public Carta mejorCarta(ArrayList<Carta> cartas) {
        Carta mejor = cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            if (mejor.compareTo(cartas.get(i)) > 0) {
                mejor = cartas.get(i);
            }
        }
        return mejor;
    }

    public ArrayList<Carta> cartasRestantes(ArrayList<Carta> mano, ArrayList<Carta> conjunto) {
        ArrayList<Carta> aux = new ArrayList();

        for (Carta c : mano) {
            if (!conjunto.contains(c)) {
                aux.add(c);
            }
        }
        return aux;
    }
}

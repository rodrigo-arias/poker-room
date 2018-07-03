package Model;

import java.util.ArrayList;

public class Par extends Figura {

    public Par(ArrayList<Carta> cartas) {
        super.setMano(cartas);
    }

    @Override
    public boolean valido() {
        int numero = 0;
        ArrayList<Carta> mano = super.getMano();
        ArrayList<Carta> figura = super.getConjunto();

        // Recorro las cartas y comparo su número
        for (int i = 0; i < mano.size() - 1; i++) {
            int actual = mano.get(i).getValor();

            if (actual == mano.get(i + 1).getValor() && actual > numero) {

                // Las agrego a la lista de cartas que componen la figura
                figura.clear();
                figura.add(mano.get(i));
                figura.add(mano.get(i + 1));

                numero = actual;
            }
        }

        return numero > 0;
    }

    @Override
    public String getNombre() {
        return "par";
    }

    @Override
    public int getJerarquia() {
        return 1;
    }

    @Override
    public int compareInternal(Object o) {
        Par otro = (Par) o;

        int parActual = this.getConjunto().get(0).getValor();
        int parOtro = otro.getConjunto().get(0).getValor();

        if (parActual > parOtro) {
            return -1;
        } else if (parActual < parOtro) {
            return 1;
        } else {

            // Tienen par del mismo número, define la carta mas alta del resto
            ArrayList<Carta> restoCartasActual = cartasRestantes(this.getMano(), this.getConjunto());
            ArrayList<Carta> restoCartasOtro = cartasRestantes(otro.getMano(), otro.getMano());

            // Obtengo las mejores cartas que no forman la figura
            Carta mejorCartaActual = mejorCarta(restoCartasActual);
            Carta mejorCartaOtro = mejorCarta(restoCartasOtro);

            if (mejorCartaActual.compareTo(mejorCartaOtro) > 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

package Model;

import java.util.ArrayList;

public class DoblePar extends Figura {

    @Override
    public boolean valido() {
        int pares = 0;
        ArrayList<Carta> mano = super.getMano();
        ArrayList<Carta> figura = super.getConjunto();

        // Recorro las cartas y comparo su número
        for (int i = 0; i < mano.size() - 1; i++) {
            int actual = mano.get(i).getValor();

            if (actual == mano.get(i + 1).getValor()
                    && !figura.contains(mano.get(i))
                    && !figura.contains(mano.get(i + 1))) {

                pares++;

                // Las agrego a la lista de cartas que componen la figura
                figura.add(mano.get(i));
                figura.add(mano.get(i + 1));
            }
        }
        return pares > 1;
    }

    @Override
    public String getNombre() {
        return "poble par";
    }

    @Override
    public int getJerarquia() {
        return 2;
    }

    @Override
    public int compareInternal(Object o) {
        DoblePar otro = (DoblePar) o;

        // Obtengo el número de los pares mas altos
        int parAltoActual = this.getConjunto().get(this.getConjunto().size() - 1).getValor();
        int parAltoOtro = otro.getConjunto().get(otro.getConjunto().size() - 1).getValor();

        if (parAltoActual > parAltoOtro) {
            return -1;
        } else if (parAltoActual < parAltoOtro) {
            return 1;
        } else {

            // Obtengo el número de los pares mas bajos
            int parBajoActual = this.getConjunto().get(0).getValor();
            int parBajoOtro = otro.getConjunto().get(0).getValor();

            if (parBajoActual > parBajoOtro) {
                return -1;
            } else if (parBajoActual < parBajoOtro) {
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

    @Override
    public Figura crearNueva() {
        return new DoblePar();
    }
}

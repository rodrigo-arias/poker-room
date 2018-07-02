package Model;

import java.util.ArrayList;

public class Color extends Figura {

    public Color(ArrayList<Carta> cartas) {
        super.setMano(cartas);
    }

    @Override
    public boolean valido() {
        boolean color = true;
        ArrayList<Carta> mano = super.getMano();
        super.setFigura(mano);

        // Recorro las cartas y comparo su número
        for (int i = 0; i < mano.size() - 1; i++) {
            if (color == true) {
                int actual = mano.get(i).palo.getValor();

                if (actual != mano.get(i + 1).palo.getValor()) {
                    color = false;
                }
            }
        }

        return color;
    }

    @Override
    public String nombre() {
        return "Color";
    }

    @Override
    public int jerarquia() {
        return 3;
    }

    @Override
    public int compareInternal(Object o) {
        Color otro = (Color) o;

        int paloActual = this.getConjunto().get(0).palo.getValor();
        int paloOtro = otro.getConjunto().get(0).palo.getValor();

        if (paloActual > paloOtro) {
            return -1;
        } else {
            return 1;
        }
    }
}

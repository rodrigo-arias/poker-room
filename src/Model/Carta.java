package Model;

public class Carta implements Comparable {

    //==================  Attributes  ==================//
    private int numero;
    private String source;
    public Palo palo;

    public enum Palo {
        Corazon(4),
        Diamante(3),
        Trebol(2),
        Pique(1);

        private int valor;

        private Palo(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return this.valor;
        }

    }

    //=================  Constructor  ================//
    public Carta(int valor, Palo palo, String source) {
        this.numero = valor;
        this.palo = palo;
        this.source = source;
    }

    //==================  Properties  =================//
    public int getValor() {
        return numero;
    }

    public String getSource() {
        return source;
    }

    @Override
    public int compareTo(Object o) {
        Carta otra = (Carta) o;

        if (this.numero > otra.numero) {
            return -1;
        } else if (this.numero < otra.numero) {
            return 1;
        } else {
            if (this.palo.getValor() > otra.palo.getValor()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

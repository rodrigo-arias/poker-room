package Model;

public class Carta {

    //==================  Attributes  ==================//
    private int numero;
    private String source;
    private Palo palo;

    public enum Palo {
        Corazon,
        Diamante,
        Trebol,
        Pique;
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

}

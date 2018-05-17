package Model;

public class Carta {

    //==================  Attributes  ==================//
    private int valor;
    private String source;

    //=================  Constructor  ================//
    public Carta(int valor, String source) {
        this.valor = valor;
        this.source = source;
    }

    //==================  Properties  =================//
    public int getValor() {
        return valor;
    }

    public String getSource() {
        return source;
    }

}

package Model;

public class Apuesta {

    private Jugador apostador;
    private int valor;

    //==================  Constructor  ==================//
    public Apuesta(Jugador apostador, int valor) {
        this.apostador = apostador;
        this.valor = valor;
    }

    //==================  Properties  =================//s
    public Jugador getApostador() {
        return apostador;
    }

    public void setApostador(Jugador apostador) {
        this.apostador = apostador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

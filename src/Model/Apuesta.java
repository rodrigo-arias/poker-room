package Model;

public class Apuesta {

    private Participante apostador;
    private int valor;

    //==================  Constructor  ==================//
    public Apuesta(Participante apostador, int valor) {
        this.apostador = apostador;
        this.valor = valor;
    }

    //==================  Properties  =================//s
    public Participante getApostador() {
        return apostador;
    }

    public void setApostador(Participante apostador) {
        this.apostador = apostador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

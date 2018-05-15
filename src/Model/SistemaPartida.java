package Model;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private Partida proximaPartida;
    private int max;
    private int pozo;
    private int base;

    //==================  Properties  ==================//
    public void setMax(int max) {
        this.max = max;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public void setBase(int base) {
        this.base = base;
    }

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        this.proximaPartida = new Partida(this.max, this.pozo, this.base);
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }
}

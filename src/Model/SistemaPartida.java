package Model;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private Partida proximaPartida;
    private int max;
    private int pozo;
    private int base;

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        this.proximaPartida = new Partida(this.max, this.pozo, this.base);
    }
}

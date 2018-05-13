package Model;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private Partida proximaPartida;

    //==================  Methods  ==================//
    public void crearProximaPartida(int max, int pozo, int base) {
        this.proximaPartida = new Partida(max, pozo, base);
    }
}

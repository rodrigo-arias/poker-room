package Model;

public class Sistema {

    //==================  Attributes  ==================//
    private SistemaJugador sj = new SistemaJugador();
    private SistemaAdmin sa = new SistemaAdmin();
    private SistemaPartida sp = new SistemaPartida();

    //==================  Singleton  ==================//
    private static Sistema instance = new Sistema();

    public static Sistema getInstance() {
        return instance;
    }

    private Sistema() {
    }

    //==================  Sis. Jugador  ==================//
    public Participante login(String u, String p) {
        return sj.login(u, p);
    }

    public void addJugador(Jugador j) {
        sj.addJugador(j);
    }

    //==================  Sis. Partida  ==================//
}

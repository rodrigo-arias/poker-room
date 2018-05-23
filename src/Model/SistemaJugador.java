package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();

    //==================  Methods  ==================//
    public Participante loginJugador(String user, String pass) {

        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                Partida p = Sistema.getInstance().getProximaPartida();

                // No se encuentra en la prox. partida, y tiene saldo de apuesta base x cant. de jugadores
                if (!p.getJugadores().contains(j) && j.getSaldo() >= p.getBase() * p.getTam()) {

                    // Jugador válido, creo el participante y agrego el jugador a la próxima partida
                    p.agregarJugador(j);

                    return new Participante(j, p);
                }
            }
        }
        return null;
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }
}

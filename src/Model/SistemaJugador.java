package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();

    //==================  Methods  ==================//
    public Participante loginJugador(String user, String pass) {
        Participante retorno = null;

        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                Partida p = Sistema.getInstance().getProximaPartida();

                if (!p.getJugadores().contains(j) && j.getSaldo() >= p.getBase()) {
                    //Jugador válido, creo el participante y agrego el jugador a la próxima partida
                    p.agregarJugador(j);
                    retorno = new Participante(j, p);                    
                }
            }
        }
        return retorno;
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }
}

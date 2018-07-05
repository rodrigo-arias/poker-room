package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();

    //==================  Methods  ==================//
    public Participante ingresarJugador(String user, String pass) {

        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                Partida p = Sistema.instancia().proximaPartida();

                return p.agregarJugador(j);
            }
        }
        return null;
    }

    public boolean registrarJugador(Jugador j) {

        if (!jugadores.contains(j)) {
            for (Jugador jug : jugadores) {
                if (jug.equals(j)) {
                    return false;
                }
            }
            // Si el jugador no fue registrado y no hay otro con el mismo usuario
            jugadores.add(j);
            return true;
        }
        return false;
    }

    public void cargarJugadores(ArrayList<Jugador> lista) {
        for (Jugador j : lista) {
            registrarJugador(j);
        }
    }
}

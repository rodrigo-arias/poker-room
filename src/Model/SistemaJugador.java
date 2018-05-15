package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();

    //==================  Methods  ==================//
    public Participante login(String user, String pass) {
        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                //Jugador válido, creo el participante
                //credenciales correctas + no en proxima partida + guita para pagar base de proxima partida
                Participante p = new Participante(j.getNombre(), j.getSaldo());
                //Sistema.getInstance().avisar(Sistema.Eventos.listaAgendas);

                return p;
            }
        }
        return null;
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }
}

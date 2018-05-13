package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();

    //==================  Methods  ==================//
    public Participante login(String user, String pass) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                //Jugador válido, creo el participante
                //Participante p = Sistema.getInstance().addParticipante(j);
                //Sistema.getInstance().avisar(Sistema.Eventos.listaAgendas);
                Participante p = new Participante();

                return p;
            }
        }
        return null;
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }
}

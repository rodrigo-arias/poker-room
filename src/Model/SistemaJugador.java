package Model;

import java.util.ArrayList;

class SistemaJugador {

    //==================  Attributes  ==================//
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Participante> participantes = new ArrayList();

    //==================  Methods  ==================//
    public Participante login(String user, String pass) {
        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(user) && j.getContrasena().equals(pass)) {

                //Jugador válido, creo el participante
                Participante p = new Participante();
                //Sistema.getInstance().avisar(Sistema.Eventos.listaAgendas);

                return p;
            }
        }
        return null;
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }
}

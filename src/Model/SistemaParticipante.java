package Model;

import java.util.ArrayList;

class SistemaParticipante {

    //==================  Attributes  ==================//
    private ArrayList<Participante> participantes = new ArrayList();

    //==================  Properties  ==================//
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    //==================  Methods  ==================//
    public void registrarParticipante(Participante p) {
        if (!participantes.contains(p)) {
            participantes.add(p);
        }
    }

    public ArrayList<Participante> participantesPartida(Partida p) {
        ArrayList<Participante> aux = new ArrayList();

        for (Participante o : participantes) {
            if (o.getPartida().equals(p)) {
                aux.add(o);
            }
        }

        return aux;
    }
}

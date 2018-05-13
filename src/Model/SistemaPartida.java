package Model;

import java.util.ArrayList;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private ArrayList<Participante> participantes = new ArrayList();

    //==================  Methods  ==================//
    public void addParticipante(Participante p) {
        participantes.add(p);
    }

}

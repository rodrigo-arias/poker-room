package Utils;

import java.util.ArrayList;

public class Observable {

    private ArrayList<Observador> lista = new ArrayList();

    public void agregar(Observador es) {
        if (!lista.contains(es)) {
            lista.add(es);
        }
    }

    public void quitar(Observador es) {
        lista.remove(es);
    }

    public void avisar(Object evento) {
        for (Observador obs : lista) {
            obs.actualizar(evento, this);
        }
    }

}

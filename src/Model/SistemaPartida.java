package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SistemaPartida extends Observable {

    //==================  Attributes  ==================//
    private ArrayList<Partida> partidas = new ArrayList();
    private Partida proximaPartida;
    private int defaultTam;
    private int defaultBase;
    private int lastId;

    public enum Eventos {
        partidaNueva,
        partidaActualizada;
    }

    //==================  Properties  ==================//
    public void setTam(int tam) {
        this.defaultTam = tam;
    }

    public void setBase(int base) {
        this.defaultBase = base;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        this.proximaPartida = new Partida(this.lastId + 1, this.defaultTam, this.defaultBase);
        lastId++;
        registrarPartida(proximaPartida);
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }

    public void registrarPartida(Partida p) {
        partidas.add(p);
        avisar(Eventos.partidaNueva);
    }

    public ArrayList<Partida> getPartidasActivas() {
        ArrayList<Partida> aux = new ArrayList<>();

        for (Partida p : partidas) {
            if (p.isActiva()) {
                aux.add(p);
            }
        }
        return aux;
    }

    public void avisar(SistemaPartida.Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public void observarPartidas(Observer o) {
        this.addObserver(o);
    }

    public void observarPartida(Partida p, Observer o) {
        p.addObserver(o);
    }

    public void observarManoActual(Partida p, Observer o) {
        p.getManoActual().addObserver(o);
    }

    public int actualizarDefaultBase(int base) {
        int retorno = 1;

        this.defaultBase = base;

        if (proximaPartida.getJugadores().isEmpty()) {
            proximaPartida.setBase(base);
            retorno = 2;
            avisar(Eventos.partidaActualizada);
        }
        return retorno;
    }

    public int actualizarDefaultTam(int tam) {
        int retorno = 1;

        this.defaultTam = tam;

        if (proximaPartida.getJugadores().size() <= tam) {
            proximaPartida.setTam(tam);
            retorno = 2;
            avisar(Eventos.partidaActualizada);

            if (proximaPartida.getJugadores().size() == proximaPartida.getTam()) {
                proximaPartida.iniciar();
                crearProximaPartida();
            }
        }
        return retorno;
    }

    Partida getPartidaId(int id) {
        Partida aux = null;

        for (Partida p : partidas) {
            if (p.getId() == id) {
                aux = p;
            }
        }
        return aux;
    }
}

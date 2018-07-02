package Model;

import java.util.ArrayList;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private ArrayList<Partida> partidas = new ArrayList();
    private Partida proximaPartida;
    private int inicialTam = 4;
    private int inicialBase = 2;
    private int ultimoId = 0;

    //==================  Properties  ==================//
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        ultimoId++;
        proximaPartida = new Partida(ultimoId, inicialTam, inicialBase);
        partidas.add(proximaPartida);
        Sistema.instancia().avisar(Sistema.Eventos.partidaNueva);
    }

    public int inicialTam(int nuevoTam) {
        //Actualizar nuevo tamaño inicial
        inicialTam = nuevoTam;

        int ingresados = proximaPartida.getJugadores().size();

        //Si los jugadores ingresados son menores al nuevo tamaño
        if (ingresados <= nuevoTam) {
            proximaPartida.setTam(nuevoTam);
            Sistema.instancia().avisar(Sistema.Eventos.partidaActualizada);

            //Si los jugadores ingresados son iguales al nuevo tamaño
            if (ingresados == proximaPartida.getTam()) {
                proximaPartida.iniciar();
                crearProximaPartida();
            }
            return 2;
        }
        return 1;
    }

    public int inicialBase(int nuevaBase) {
        //Actualizar nueva apuesta base
        inicialBase = nuevaBase;

        if (proximaPartida.getJugadores().isEmpty()) {
            proximaPartida.setBase(nuevaBase);
            Sistema.instancia().avisar(Sistema.Eventos.partidaActualizada);
            return 2;
        }
        return 1;
    }

    //===============================================//
    public ArrayList<Partida> partidasActivas() {
        ArrayList<Partida> aux = new ArrayList<>();

        for (Partida p : partidas) {
            if (p.activa) {
                aux.add(p);
            }
        }
        return aux;
    }

    public Partida partidaById(int id) {
        for (Partida p : partidas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    //===============================================//
}

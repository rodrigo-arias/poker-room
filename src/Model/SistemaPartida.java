package Model;

import Persistence.MapeadorPartida;
import Persistence.Persistencia;
import java.util.ArrayList;

public class SistemaPartida {

    //==================  Attributes  ==================//
    private ArrayList<Partida> partidas = new ArrayList();
    private Partida proximaPartida;
    private int inicialTam = 3;
    private int inicialBase = 2;
    private ArrayList<Figura> figuras = new ArrayList();

    //==================  Properties  ==================//
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public Partida getProximaPartida() {
        return proximaPartida;
    }

    //==================  Methods  ==================//
    public void crearProximaPartida() {
        proximaPartida = new Partida(inicialTam, inicialBase);
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

    public Partida partidaByIndex(int index) {
        if (index >= 0) {
            return partidas.get(index);
        } else {
            return null;
        }
    }

    //===============================================//
    public void mejorFigura(Participante p) {
        for (Figura f : figuras) {

            // Creo una figura del mismo tipo con las cartas del participante para evaluar
            Figura nueva = f.crearNueva();
            nueva.setMano(p.getCartas());

            if (nueva.valido()) {

                // Si no tenía figura registrada o la actual es mejor
                if (p.getFigura() == null || p.getFigura().getJerarquia() < f.getJerarquia()) {
                    p.setFigura(nueva);
                }
            }
        }
    }

    public void registrarFigura(Figura figura) {
        if (!figuras.contains(figura)) {
            figuras.add(figura);
        }
    }

    //=================  Persistence ==================//
    public void guardarPartida(Partida p) {
        MapeadorPartida mp = new MapeadorPartida(p, Sistema.instancia().participantesPartida(p));
        Persistencia.instancia().save(mp);
    }

    void cargarPartidas(ArrayList<Object> lista) {
        if (!lista.isEmpty()) {
            for (Object o : lista) {
                partidas.add((Partida) o);
            }
        }
    }
}

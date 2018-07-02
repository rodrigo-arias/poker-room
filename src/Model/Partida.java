package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable {

    //==================  Attributes  ==================//
    private int id;
    private int tam;
    private int pozo;
    private int base;
    private Mano mano;
    private LocalDateTime inicio;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manos;
    private int respuestas;
    ArrayList<Integer> saldos = new ArrayList<>();
    boolean activa = false;

    public enum Eventos {
        actualizar,
        iniciar,
        finalizar,
        iniciarMano,
        jugarMano,
        finalizarMano,
        saldoInsuficiente,
        responder,
        ganador,
        retry;
    }

    public enum Accion {
        apostar,
        pasar,
        pagar,
        salir;
    }

    //==================  Constructor  =================//
    public Partida(int id, int tam, int base) {
        this.id = id;
        this.tam = tam;
        this.pozo = 0;
        this.base = base;
        this.mano = null;
        this.inicio = null;
        this.jugadores = new ArrayList();
        this.manos = new ArrayList();
    }

    //==================  Properties  =================//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getBase() {
        return base;
    }

    public int getTam() {
        return tam;
    }

    public int getPozo() {
        return pozo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public Mano getMano() {
        return mano;
    }

    public ArrayList<Integer> getSaldosIniciales() {
        return saldos;
    }

    //==================  Methods  ==================//
    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Participante agregarJugador(Jugador j) {
        Participante p = null;

        // No se encuentra en la prox. partida, y tiene saldo mayor a apuesta base x cant. de jugadores
        if (!jugadores.contains(j) && j.getSaldo() >= base * tam) {

            // Jugador válido, creo el participante y agrego el jugador a la próxima partida
            p = new Participante(j, this);
            jugadores.add(j);
            saldos.add(j.getSaldo());

            if (jugadores.size() == tam) {
                // Se completaron los participante, creo una nueva partida e inicio la actual
                Sistema.instancia().crearProximaPartida();
                iniciar();
            }
        }
        return p;
    }

    public void quitarJugador(Participante p) {

        jugadores.remove(p.getJugador());
        this.deleteObserver(p);

        if (jugadores.size() == 1) {
            // Queda un solo jugador, se termina la partida
            finalizar();
        } else {
            avisar(Eventos.actualizar);
        }

    }

    public void iniciar() {
        inicio = LocalDateTime.now();

        avisar(Eventos.iniciar);
        iniciarMano();
        activa = true;
    }

    private void finalizar() {
        avisar(Eventos.finalizar);
        jugadores.clear();
        activa = false;
    }

    public void iniciarMano() {
        mano = new Mano();
        manos.add(mano);
        avisar(Eventos.jugarMano);
        avisar(Eventos.iniciarMano);
    }

    public void jugarMano(Participante p) {
        // Se agrega a la partida y se le reparten las cartas
        mano.jugar(p);
        mano.repartir(p);

        // Paga apuesta base y se conforma el pozo
        p.getJugador().restarSaldo(base);
        pozo += base;
    }

    public void finalizarMano() {
        ArrayList<Jugador> sinSaldo = new ArrayList();

        // Quito a los jugadores que no tienen saldo suficiente;
        for (Jugador j : jugadores) {
            if (j.getSaldo() <= base) {
                sinSaldo.add(j);
            }
        }

        for (Jugador j : sinSaldo) {
            jugadores.remove(j);
            mano.salir(j);
            avisar(Eventos.saldoInsuficiente);
        }

        respuestas = 0;
        avisar(Eventos.finalizarMano);
    }

    public void jugarOtraMano() {
        respuestas++;

        // Si ya todos respondieron
        if (respuestas == jugadores.size()) {
            if (respuestas > 1) {
                iniciarMano();
                avisar(Eventos.retry);
            } else {
                finalizar();
            }
        }
    }

    public boolean jugandoMano(Participante p) {
        return mano.jugando(p);
    }

    public boolean jugando(Participante p) {
        return jugadores.contains(p.getJugador());
    }
    //===============================================//

    public void salir(Participante p, Accion a) {
        quitarJugador(p);

        if (mano.procesar(p, Accion.salir, 0)) {
            ganador();
        } else {
            avisar(Eventos.actualizar);
        }
    }

    public void apostar(Participante p, Accion a, int m) {
        p.getJugador().restarSaldo(m);

        if (mano.procesar(p, a, m)) {
            ganador();
        } else {
            avisar(Eventos.actualizar);
            avisar(Eventos.responder);
        }
    }

    public void pasar(Participante p, Accion a) {
        if (mano.procesar(p, a, 0)) {
            ganador();
        } else {
            avisar(Eventos.actualizar);
            avisar(Eventos.responder);
        }
    }

    public void pagar(Participante p, Accion a) {
        p.getJugador().restarSaldo(mano.getApuesta().getValor());

        if (mano.procesar(p, a, 0)) {
            ganador();
        } else {
            avisar(Eventos.actualizar);
            avisar(Eventos.responder);
        }
    }

    public void ganador() {
        // Si hay un ganador actualizo el pozo y el saldo del ganador
        if (mano.getGanador() != null) {
            mano.getGanador().getJugador().sumarSaldo(mano.getPozo() + pozo);
            pozo = 0;
        } else {
            pozo += mano.getPozo();
        }

        avisar(Eventos.ganador);
        finalizarMano();
    }

    //==================  Monitor  ==================//
    public int totalApostado() {
        int total = 0;
        for (Mano m : manos) {
            if (m.getApuesta() != null) {
                total += m.getApuesta().getValor();
            }
        }
        return total;
    }

    public int totalApostadoJugador(Jugador j) {
        int totalApostado = 0;
        for (Mano m : manos) {

            ArrayList<Participante> pagaron = m.getPagaron();

            for (Participante p : pagaron) {
                if (p.getJugador().equals(j)) {
                    totalApostado += m.getApuesta().getValor();
                }
            }
        }
        return totalApostado;
    }

    public int totalGanado(Jugador j, Partida p) {
        int totalGanado = 0;
        boolean aposto = false;

        // Me fijo si fue uno de los que apostó
        for (Mano m : manos) {
            ArrayList<Participante> pagaron = m.getPagaron();

            for (Participante ppte : pagaron) {
                if (ppte.getJugador().equals(j)) {
                    aposto = true;
                }
            }

            // Si apostó
            if (aposto) {
                int apuesta = m.getApuesta().getValor();

                // Si no ganó la banca
                if (m.getGanador() != null) {

                    // Si ganó él
                    if (m.getGanador().getJugador().equals(j)) {
                        totalGanado += apuesta;
                        totalGanado += (p.base * (p.getJugadores().size() - 1));
                    } else {
                        totalGanado -= apuesta;
                        totalGanado -= p.base;
                    }
                } else {
                    totalGanado -= apuesta;
                    totalGanado -= p.base;
                }
            } else {
                totalGanado -= p.base;
            }
            aposto = false;
        }
        return totalGanado;
    }

    public int apuestaMaxima() {
        int max = Integer.MAX_VALUE;

        for (Jugador j : jugadores) {
            if (j.getSaldo() < max) {
                max = j.getSaldo();
            }
        }
        return max;
    }
}

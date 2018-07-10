package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable implements Runnable {

    //==================  Attributes  ==================//
    private int oid;
    private int tam;
    private int pozo;
    private int base;
    private Mano mano;
    private LocalDateTime inicio;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manos;
    private int respuestas;
    boolean activa = false;
    private int cantManos;
    private int apostado;
    private Thread hilo;
    private boolean corriendo;
    private int time = 1;
    private int limite = 10;

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
        retry,
        timeout;
    }

    public enum Accion {
        apostar,
        pasar,
        pagar,
        salir;
    }

    //==================  Constructor  =================//
    public Partida() {
    }

    public Partida(int tam, int base) {
        this.tam = tam;
        this.pozo = 0;
        this.base = base;
        this.mano = null;
        this.inicio = null;
        this.jugadores = new ArrayList();
        this.manos = new ArrayList();
    }

    //==================  Properties  =================//
    public int getOid() {
        return oid;
    }

    public void setOid(int id) {
        this.oid = id;
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

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getCantManos() {
        return cantManos;
    }

    public void setCantManos(int cantManos) {
        this.cantManos = cantManos;
    }

    public int getApostado() {
        return apostado;
    }

    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    public int getTime() {
        return time;
    }

    public int getLimite() {
        return limite;
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
            p.setInicial(p.getJugador().getSaldo());

            Sistema.instancia().registrarParticipante(p);

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
        cantManos++;

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

        // Finalizo el timeout si está corriendo
        if (corriendo) {
            pararTimeout();
        }

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
        guardar();
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

        if (mano != null) {
            if (mano.procesar(p, Accion.salir, 0)) {
                ganador();
            } else {
                avisar(Eventos.actualizar);
            }
        }
    }

    public void apostar(Participante p, Accion a, int m) {
        // Resto el saldo al jugador y sumo saldos apostados al participante
        p.getJugador().restarSaldo(m);
        p.setApostado(p.getApostado() + m);
        apostado += m;

        if (mano.procesar(p, a, m)) {
            ganador();
        } else {
            avisar(Eventos.actualizar);
            avisar(Eventos.responder);

            // Comienza el timeout para responder
            iniciarTimeout();
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
        int m = mano.getApuesta().getValor();

        // Resto el saldo al jugador y sumo saldos apostados al participante
        p.getJugador().restarSaldo(m);
        p.setApostado(p.getApostado() + m);
        apostado += m;

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
            Participante g = mano.getGanador();

            // Sumo saldo al jugador y total ganado al participante
            int ganado = mano.getPozo() - mano.getApuesta().getValor();

            g.getJugador().sumarSaldo(ganado);
            g.setGanado(ganado);
            pozo = 0;
        } else {
            pozo += mano.getPozo();
        }

        avisar(Eventos.ganador);
        finalizarMano();
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

    //=================  Persistence ==================//
    private void guardar() {
        Sistema.instancia().guardarPartida(this);
    }

    //====================  Hilos =====================//
    @Override
    public void run() {
        for (; time <= limite && corriendo; time++) {
            avisar(Eventos.timeout);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        pausarTimeout();
    }

    public void iniciarTimeout() {
        if (!corriendo) {
            hilo = new Thread(this);
            corriendo = true;
            hilo.start();
        }
    }

    public void pararTimeout() {
        if (pausarTimeout()) {
            time = 0;
        }
    }

    public boolean pausarTimeout() {
        if (corriendo) {
            corriendo = false;
            hilo.interrupt();

            mano.forzarRespuestas();

            return true;
        }
        return false;
    }
}

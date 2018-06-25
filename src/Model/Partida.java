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
    private LocalDateTime inicio;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manos;
    private boolean activa;
    private Mano manoActual;
    private int respuestas;
    ArrayList<Integer> saldosIniciales = new ArrayList<>();

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
        this.inicio = null;
        this.jugadores = new ArrayList();
        this.manos = new ArrayList();
        this.activa = false;
        this.manoActual = null;
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

    public Mano getManoActual() {
        return manoActual;
    }

    public boolean isActiva() {
        return activa;
    }

    public ArrayList<Integer> getSaldosIniciales() {
        return saldosIniciales;
    }

    //==================  Methods  ==================//
    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Participante agregarJugador(Jugador j) {
        Participante p = null;

        // No se encuentra en la prox. partida, y tiene saldo de apuesta base x cant. de jugadores
        if (!this.getJugadores().contains(j) && j.getSaldo() >= this.getBase() * this.getTam()) {

            // Jugador válido, creo el participante y agrego el jugador a la próxima partida
            p = new Participante(j, this);
            jugadores.add(j);
            this.saldosIniciales.add(j.getSaldo());

            if (this.jugadores.size() == this.tam) {
                // Se completaron los participante, creo una nueva partida e inicio la actual
                Sistema.instancia().crearProximaPartida();
                this.iniciar();
            }
        }
        return p;
    }

    public void quitarJugador(Participante p) {

        jugadores.remove(p.getJugador());

        if (this.jugadores.size() == 1) {
            // Queda un solo jugador, se termina la partida
            this.finalizar();
        } else {
            avisar(Eventos.actualizar);
        }

    }

    public void iniciar() {
        this.inicio = LocalDateTime.now();
        this.activa = true;

        avisar(Eventos.iniciar);
        iniciarMano();
    }

    private void finalizar() {
        this.activa = false;
        this.jugadores.clear();
        avisar(Eventos.finalizar);
    }

    public void iniciarMano() {
        this.manoActual = new Mano();
        this.manos.add(manoActual);
        avisar(Eventos.jugarMano);
        avisar(Eventos.iniciarMano);
    }

    public void jugarMano(Participante p) {
        // Se agrega a la partida y se le reparten las cartas
        manoActual.jugar(p);
        manoActual.repartir(p);

        // Paga apuesta base y se conforma el pozo
        p.getJugador().restarSaldo(base);
        this.pozo += base;
        avisar(Eventos.actualizar);
    }
    //===============================================//

    public void accion(Participante p, Accion a, int m) {

        // Si aposto o pago, le quito al saldo el valor de la apuesta y actualizo
        if (a == Accion.apostar || a == Accion.pagar) {
            p.jugador.restarSaldo(m);
            avisar(Eventos.actualizar);
        }

        if (a == Accion.salir) {
            quitarJugador(p);
        }

        if (manoActual.accion(p, a, m)) {
            // Si hay un ganador actualizo el pozo y el saldo del ganador
            if (manoActual.getGanador() != null) {
                manoActual.getGanador().getJugador().sumarSaldo(manoActual.getPozo() + this.pozo);
                this.pozo = 0;
            } else {
                this.pozo += this.manoActual.getPozo();
            }
            avisar(Eventos.ganador);
            finalizarMano();
        } else {
            avisar(Eventos.actualizar);
            avisar(Eventos.responder);
        }
    }

    public void finalizarMano() {

        // Quito a los jugadores que no tienen saldo suficiente;
        for (Jugador j : this.jugadores) {
            if (j.getSaldo() <= this.getBase()) {
                jugadores.remove(j);
                avisar(Eventos.saldoInsuficiente);
            }
        }

        this.respuestas = 0;
        avisar(Eventos.finalizarMano);
    }

    public void jugarOtraMano() {
        respuestas++;

        // Si ya todos respondieron
        if (respuestas == this.getJugadores().size()) {
            if (respuestas > 1) {
                iniciarMano();
                avisar(Eventos.retry);
            } else {
                this.finalizar();
            }
        }
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
        for (Mano m : this.manos) {

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
        for (Mano m : this.manos) {
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

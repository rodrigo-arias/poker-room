package Model;

import Model.Mano.Accion;
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

    public enum Eventos {
        cambiaronParticipantes,
        inicioPartida,
        finalizoPartida,
        inicioMano,
        finalizoMano,
        saldoInsuficiente;
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

    //==================  Methods  ==================//
    public Participante agregarJugador(Jugador j) {
        Participante p = null;

        // No se encuentra en la prox. partida, y tiene saldo de apuesta base x cant. de jugadores
        if (!this.getJugadores().contains(j) && j.getSaldo() >= this.getBase() * this.getTam()) {

            // Jugador válido, creo el participante y agrego el jugador a la próxima partida
            p = new Participante(j, this);
            jugadores.add(j);

            // Paga apuesta base y se conforma el pozo
            j.restarSaldo(base);
            this.pozo += base;
            avisar(Eventos.cambiaronParticipantes);

            if (this.jugadores.size() == this.tam) {
                // Se completaron los participante, creo una nueva partida e inicio la actual
                Sistema.getInstance().crearProximaPartida();
                this.iniciar();
            }
        }
        return p;
    }

    public void quitarJugador(Participante p) {
        if (this.jugadores.contains(p.getJugador())) {
            jugadores.remove(p.getJugador());
            avisar(Eventos.cambiaronParticipantes);

            // Aviso a la mano que se retiro un jugador
            accion(p, Accion.salio, 0);

            if (this.jugadores.size() == 1) {
                // Queda un solo jugador, se termina la partida
                this.finalizar();
            }
        }
    }

    public void iniciar() {
        this.inicio = LocalDateTime.now();
        this.activa = true;

        crearMano();
        avisar(Eventos.inicioPartida);
    }

    private void finalizar() {
        this.activa = false;
        avisar(Eventos.finalizoPartida);
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public int getTotalApostado() {
        return 0;
    }

    public void repartirCartas(Participante p) {
        manoActual.repartirCartas(p);
    }

    public void crearMano() {
        this.manoActual = new Mano();
        this.manos.add(manoActual);

        avisar(Eventos.inicioMano);
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

    public boolean accion(Participante p, Mano.Accion accion, int apuesta) {

        // Si aposto, le quito al saldo el valor de la apuesta
        if (accion == Mano.Accion.aposto) {
            if (apuesta <= apuestaMaxima()) {
                p.jugador.restarSaldo(apuesta);
            } else {
                return false;
            }
        }

        // Paga el valor de la apuesta actual
        if (accion == Mano.Accion.pago) {
            p.jugador.restarSaldo(manoActual.getApuesta().getValor());
        }

        boolean finalizo = this.manoActual.accion(p, accion, apuesta);

        if (finalizo) {
            // Si hay un ganador actualizo el pozo y el saldo del ganador
            if (this.manoActual.getGanador() != null) {
                this.manoActual.getGanador().getJugador().sumarSaldo(this.manoActual.getPozo() + this.pozo);
                this.pozo = 0;
            } else {
                this.pozo += this.manoActual.getPozo();
            }
            finalizoManoActual();
        }

        return true;
    }

    public void finalizoManoActual() {

        // Quito a los jugadores que no tienen saldo suficiente;
        for (Jugador j : this.jugadores) {
            if (j.getSaldo() < this.getBase()) {
                jugadores.remove(j);
                avisar(Eventos.saldoInsuficiente);
            }
        }

        avisar(Eventos.finalizoMano);
    }
}

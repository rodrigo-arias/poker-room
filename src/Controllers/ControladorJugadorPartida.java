package Controllers;

import Model.Mano;
import Model.Participante;
import Model.Partida;
import Model.Sistema;
import java.util.Observable;
import java.util.Observer;

public class ControladorJugadorPartida implements Observer {

    private Sistema sistema = Sistema.instancia();
    private VistaJugadorPartida vista;
    private Participante ppte;
    private Partida partida;

    //==================  Constructor  ==================//
    public ControladorJugadorPartida(Participante p, VistaJugadorPartida v) {
        this.vista = v;
        this.ppte = p;
        this.partida = p.getPartida();

        partida.addObserver(this);
        sistema.addObserver(this);
    }

    //==================  Properties  =================//
    public void apostar(int apuesta) {
        if (apuesta > partida.apuestaMaxima()) {
            vista.mensaje("No puedes apostar esa cantidad");
        } else {
            partida.apostar(ppte, Partida.Accion.apostar, apuesta);
        }
    }

    public void pasar() {
        partida.pasar(ppte, Partida.Accion.pasar);
    }

    public void pagar() {
        partida.pagar(ppte, Partida.Accion.pagar);
    }

    public void jugar() {
        partida.jugarOtraMano();
    }

    public void salir() {
        partida.deleteObserver(this);
        sistema.deleteObserver(this);
        partida.salir(ppte, Partida.Accion.salir);
    }

    @Override
    public void update(Observable o, Object e) {
        //===============  General ===============//
        if (e.equals(Partida.Eventos.actualizar)) {
            vista.actualizarParticipantes(ppte);
        }
        if (e.equals(Partida.Eventos.iniciar)) {
            vista.iniciar(ppte);
        }
        if (e.equals(Partida.Eventos.finalizar)) {
            partida.deleteObserver(this);
            sistema.deleteObserver(this);
            vista.finalizar(ppte);
        }
        if (e.equals(Partida.Eventos.iniciarMano)) {
            vista.manoIniciar(ppte);
        }
        if (e.equals(Partida.Eventos.finalizarMano)) {
            if (partida.getJugadores().contains(ppte.getJugador())) {
                vista.manoFinalizar(ppte);
            }
        }

        if (e.equals(Sistema.Eventos.jugadorActualizado)) {
            vista.actualizarParticipantes(ppte);
        }

        //========================================//
        if (e.equals(Partida.Eventos.saldoInsuficiente)) {
            if (!partida.jugando(ppte)) {
                partida.deleteObserver(this);
                sistema.deleteObserver(this);
                vista.saldoInsuficiente();
            }
        }
        if (e.equals(Partida.Eventos.responder)) {
            if (partida.jugandoMano(ppte) && partida.getMano().apuesta()) {
                vista.responder(ppte);
            }
        }
        if (e.equals(Partida.Eventos.ganador)) {
            Mano mano = partida.getMano();
            vista.ganador(ppte, mano);
        }

        if (e.equals(Partida.Eventos.retry)) {
            vista.manoIniciar(ppte);
        }
    }
}

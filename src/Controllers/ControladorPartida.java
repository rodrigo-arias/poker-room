package Controllers;

import Model.Participante;
import Model.Partida;
import java.util.Observable;
import java.util.Observer;

public class ControladorPartida implements Observer {

    private Partida partida;
    private IVistaPartida vista;

    public ControladorPartida(Participante participante, IVistaPartida vista) {
        this.partida = partida;
        this.vista = vista;

        //partida.addObserver(this);
        //vista.mostrarNombreDueño(agenda.getDueño().getNombreCompleto());
        //vista.mostrarCantidadContactos(agenda.getContactos().size());
        //vista.mostrarContactos(agenda.getContactos());
        //vista.cargarTipos(Sistema.getInstancia().getTipos());
    }
//    public void crearContacto(String nom,String num,Tipo t){
//        if (agenda.crearContacto(num, nom, t)){
//            vista.contactoCreado();
//        }else vista.error("No se pudo crear contacto");
//    }
//    @Override
//    public void update(Observable o, Object evento) {
//       if(evento.equals(Partida.Eventos.listaContactos)){
//           vista.mostrarContactos(Partida.getContactos());
//           vista.mostrarCantidadContactos(Partida.getContactos().size());
//       }
//    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

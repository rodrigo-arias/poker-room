/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Observable;
import java.util.Observer;
import Model.Sistema;

/**
 *
 * @author alumnoFI
 */
public class ControladorPartida implements Observer {

    //private Agenda agenda;
    private IVistaPartida vista;

//    public ControladorPartida(Agenda agenda, IVistaPartida vista) {
//        this.agenda = agenda;
//        this.vista = vista;
//        agenda.addObserver(this);
//        vista.mostrarNombreDueño(agenda.getDueño().getNombreCompleto());
//        vista.mostrarCantidadContactos(agenda.getContactos().size());
//        vista.mostrarContactos(agenda.getContactos());
//        vista.cargarTipos(Sistema.getInstancia().getTipos());
//    }
//    public void crearContacto(String nom,String num,Tipo t){
//        if (agenda.crearContacto(num, nom, t)){
//            vista.contactoCreado();
//        }else vista.error("No se pudo crear contacto");
//    }
//    @Override
//    public void update(Observable o, Object evento) {
//       if(evento.equals(Agenda.Eventos.listaContactos)){
//           vista.mostrarContactos(agenda.getContactos());
//           vista.mostrarCantidadContactos(agenda.getContactos().size());
//       }
//    }
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
//import modelo.AplicacionException;
import Modelo.LogicaNumeros;
//import controlador.Vista;

/**
 *
 * @author alumnoFI
 */
public class Controlador implements Observer {

    private LogicaNumeros modelo = LogicaNumeros.getInstancia();
    private Vista vista;

//    public Controlador(Vista v) {
//        vista = v;
//        modelo.addObserver(this);
//    }
//    public void iniciar(int n) {
//        try {
//            modelo.iniciar(n);
//            vista.cantidadIniciada();
//        } catch (AplicacionException ex) {
//            vista.mostrarError(ex.getMessage());
//        }
//    }
    public void agregar(int n) {
        modelo.agregar(n);
    }

    @Override
    public void update(Observable origen, Object evento) {
        if (evento.equals(LogicaNumeros.Eventos.hayResultado)) {
            vista.mostrarNumeros(modelo.getResultado());
        }
        if (evento.equals(LogicaNumeros.Eventos.faltan)) {
            int f = modelo.faltan();
            vista.mostarFaltan(f);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author docenteFI
 */
public class LogicaNumeros extends Observable {

    private int cantidad;
    private ArrayList<Integer> numeros = new ArrayList();
    private ArrayList<Integer> pares = new ArrayList();
    private ArrayList<Integer> impares = new ArrayList();

    private static LogicaNumeros instancia = new LogicaNumeros();

    public static LogicaNumeros getInstancia() {
        return instancia;
    }

    private LogicaNumeros() {
    }

    public enum Eventos {
        faltan, hayResultado;
    }

    private void avisar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

//    public void iniciar(int cantidad) throws AplicacionException {
//        if (cantidad < 1) {
//            throw new AplicacionException("Cantidad debe ser mayor que 0");
//        }
//        if (cantidad > 10) {
//            throw new AplicacionException("Maximo 10");
//        }
//
//        this.cantidad = cantidad;
//        numeros.clear();
//        pares.clear();
//        impares.clear();
//        avisar(Eventos.faltan);
//
//    }
    private boolean iniciado() {
        return cantidad > 0;
    }

    private boolean hayResultado() {
        return iniciado() && cantidad == numeros.size();
    }

    public void agregar(int n) {
        if (iniciado() && !hayResultado()) {
            Integer num = new Integer(n);
            if (n % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
            numeros.add(num);
            avisar(Eventos.faltan);
            if (hayResultado()) {
                avisar(Eventos.hayResultado);
            }
        }
    }

    public ArrayList<Integer> getResultado() {
        ArrayList<Integer> resultado = null;
        if (hayResultado()) {
            resultado = numeros;
            if (pares.size() > impares.size()) {
                resultado = pares;
            } else if (impares.size() > pares.size()) {
                resultado = impares;
            }
        }
        return resultado;
    }

    public int faltan() {
        return cantidad - numeros.size();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author alumnoFI
 */
public interface Vista {
    
    public void mostrarNumeros(ArrayList<Integer> numeros);
    public void mostarFaltan(int f);
    public void cantidadIniciada();
    public void mostrarError(String msg);
    
}

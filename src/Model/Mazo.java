package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    //==================  Attributes  ==================//
    private ArrayList<Carta> cartas;

    //==================  Constructor  ==================//
    public Mazo() {
        this.cartas = new ArrayList<Carta>(52);
    }
    
    public ArrayList<Carta> getCartas(int cant) {
        ArrayList<Carta> cartas = new ArrayList<Carta>(cant);
        for (int i = 0; i < cant; i++) {
            cartas.add(this.cartas.get(i));
            this.cartas.remove(i);
        }
        return cartas;
    }
    
    public void agregarCarta(Carta nuevaCarta) {
        if(!this.cartas.contains(nuevaCarta)) this.cartas.add(nuevaCarta);
    }
    
    /*private void cargarCartas() {
        String sDirectorio = ".\\Assets\\Cartas";
        File f = new File(sDirectorio);
        File[] imagenes = f.listFiles();
        for (int i = 0; i < imagenes.length; i++) {
            this.cartas.add(new Carta(i, imagenes[i].getAbsolutePath()));            
        }
    }*/
    
    public void embarajar() {
        Collections.shuffle(this.cartas);
    }
    
}

package Model;

public class Jugador {

    //==================  Attributes  ==================//
    private String usuario;
    private String contrasena;
    private String nombre;

    //=================  Constructor  ================//
    public Jugador(String usuario, String contrasena, String nombre) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    //==================  Properties  =================//
    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }
    private int saldo;
}

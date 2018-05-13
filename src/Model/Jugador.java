package Model;

public class Jugador {

    //==================  Attributes  ==================//
    private String usuario;
    private String contrasena;
    private String nombre;
    private int saldo;

    //=================  Constructor  ================//
    public Jugador(String usuario, String contrasena, String nombre) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.saldo = 100;
    }

    //==================  Properties  =================//
    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getSaldo() {
        return saldo;
    }
}

package Model;

public class Admin {

    //==================  Attributes  ==================//
    private String usuario;
    private String contrasena;
    private String nombre;

    //=================  Constructor  ================//
    public Admin(String usuario, String contrasena, String nombre) {
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

    public String getUsuario() {
        return usuario;
    }
}

package Model;

public class Jugador {

    //==================  Attributes  ==================//
    private String usuario;
    private String contrasena;
    private String nombre;
    private int saldo;

    //=================  Constructor  ================//
    public Jugador(String usuario, String contrasena, String nombre, int saldo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.saldo = saldo;
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

    public int getTotalApostado() {
        return 0;
    }

    public int getSaldoInicial() {
        return 0;
    }

    public int getTotalGanado() {
        return 0;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    //==================  Methods  ==================//
    @Override
    public boolean equals(Object o) {
        Jugador j = (Jugador) o;
        return j.getUsuario().equalsIgnoreCase(usuario);
    }

    public void pagarIngreso(int base) {
        this.saldo = this.getSaldo() - base;
    }
}

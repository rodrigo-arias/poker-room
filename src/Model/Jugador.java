package Model;

public class Jugador {

    //==================  Attributes  ==================//
    private String usuario;
    private String contrasena;
    private String nombre;
    private int saldo;
    private int Oid;

    //=================  Constructor  ================//
    public Jugador(String usuario, String contrasena, String nombre, int saldo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Jugador() {
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

    public int getOid() {
        return Oid;
    }

    public void setOid(int Oid) {
        this.Oid = Oid;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //==================  Methods  ==================//
    @Override
    public boolean equals(Object o) {
        Jugador j = (Jugador) o;
        return j.getUsuario().equalsIgnoreCase(usuario);
    }

    public void restarSaldo(int base) {
        this.saldo = this.saldo - base;
        Sistema.instancia().avisar(Sistema.Eventos.jugadorActualizado);
    }

    void sumarSaldo(int pozo) {
        this.saldo = this.saldo + pozo;
        Sistema.instancia().avisar(Sistema.Eventos.jugadorActualizado);
    }
}

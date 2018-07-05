package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Jugador;

public class MapeadorJugador implements Mapeador {

    //==================  Attributes  ==================//
    private Jugador j;

    //=================  Constructor  ================//
    public MapeadorJugador() {
    }

    public MapeadorJugador(Jugador j) {
        this.j = j;
    }

    //==================  Properties  =================//
    public void setUsuario(Jugador j) {
        this.j = j;
    }

    @Override
    public int getOid() {
        return j.getOid();
    }

    @Override
    public void setOid(int oid) {
        j.setOid(oid);
    }

    //==================  Methods  ==================//
    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO Jugador values (" + getOid() + ",'"
                + j.getUsuario() + "','"
                + j.getContrasena() + "','"
                + j.getNombre() + "','"
                + j.getSaldo() + "')");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE Jugador set usuario='" + j.getUsuario()
                + "',contrasena='" + j.getContrasena()
                + "',nombre='" + j.getNombre()
                + "',saldo='" + j.getSaldo()
                + "' where oid=" + getOid());
        return sqls;

    }

    @Override
    public ArrayList<String> getSqlDelete() {
        ArrayList<String> sqls = new ArrayList();

        sqls.add("DELETE FROM Jugador WHERE oid =" + j.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM Jugador";
    }

    //===============================================//
    @Override
    public void newSameType() {
        j = new Jugador();
    }

    @Override
    public Object getObjet() {
        return j;
    }

    @Override
    public void readComposite(ResultSet rs) throws SQLException {
        j.setUsuario(rs.getString("usuario"));
        j.setContrasena(rs.getString("contrasena"));
        j.setNombre(rs.getString("nombre"));
        j.setSaldo((int) rs.getObject("saldo"));
    }

    @Override
    public void readComponent(ResultSet rs) throws SQLException {
    }
}

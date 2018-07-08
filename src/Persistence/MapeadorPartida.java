package Persistence;

import Model.Participante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Partida;
import Model.Sistema;
import java.sql.Timestamp;

public class MapeadorPartida implements Mapeador {

    //==================  Attributes  ==================//
    private Partida partida;
    private ArrayList<Participante> pptes;

    //=================  Constructor  ================//
    public MapeadorPartida() {
    }

    public MapeadorPartida(Partida partida, ArrayList<Participante> pptes) {
        this.partida = partida;
        this.pptes = pptes;
    }

    //==================  Properties  =================//
    public void setPartida(Partida p) {
        this.partida = p;
    }

    @Override
    public int getOid() {
        return partida.getOid();
    }

    @Override
    public void setOid(int oid) {
        partida.setOid(oid);
    }

    //==================  Methods  ==================//
    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();

        sqls.add("INSERT INTO Partida values (" + getOid() + ",'"
                + Timestamp.valueOf(partida.getInicio()) + "',"
                + partida.getApostado() + ","
                + partida.getCantManos() + ")");

        insertParticipante(sqls);
        return sqls;
    }

    private void insertParticipante(ArrayList<String> sqls) {

        for (Participante p : pptes) {
            sqls.add("INSERT INTO Participante VALUES (" + getOid() + ",'"
                    + p.getNombre() + "',"
                    + p.getInicial() + ","
                    + p.getApostado() + ","
                    + p.getGanado() + ")"
            );
        }
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE Partida set inicio='" + partida.getInicio()
                + "',total_apostado=" + partida.getApostado()
                + ",manos=" + partida.getCantManos()
                + " where oid=" + getOid());
        insertParticipante(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlDelete() {
        ArrayList<String> sqls = new ArrayList();

        sqls.add("DELETE FROM Partida WHERE oid =" + partida.getOid());
        sqls.add("DELETE FROM Participante WHERE oid = " + partida.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM Partida p1, Participante p2 WHERE p1.oid = p2.oid ORDER BY p1.oid";
    }

    //===============================================//
    @Override
    public void newSameType() {
        partida = new Partida();
    }

    @Override
    public Object getObjet() {
        return partida;
    }

    @Override
    public void readComposite(ResultSet rs) throws SQLException {

        Timestamp fecha = rs.getTimestamp("inicio");

        partida.setInicio(fecha.toLocalDateTime());
        partida.setApostado((int) rs.getObject("total_apostado"));
        partida.setCantManos((int) rs.getObject("manos"));
    }

    @Override
    public void readComponent(ResultSet rs) throws SQLException {
        Participante nuevo = new Participante(
                rs.getString("nombre"),
                (int) rs.getObject("inicial"),
                (int) rs.getObject("apostado"),
                (int) rs.getObject("ganado"),
                partida
        );

        Sistema.instancia().registrarParticipante(nuevo);
    }
}

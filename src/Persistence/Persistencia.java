package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Jugador;

public class Persistencia {

    //==================  Attributes  ==================//
    private static Persistencia instancia = new Persistencia();
    private BaseDatos base;

    //=================  Constructor  ================//
    public static Persistencia instancia() {
        return instancia;
    }

    private Persistencia() {
        base = BaseDatos.instancia();
        base.connect("Poker Moons", "poker", "poker");
    }

    //==================  Methods  ==================//
    private int nextOid() {
        int oid = -1;
        ResultSet rs = base.execute("SELECT valor from Oid");
        try {
            if (rs.next()) {
                oid = rs.getInt("valor");
                base.update("UPDATE Oid set valor = " + (oid + 1));
            } else {
                System.out.println("Debe inicializar el id");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener id:" + ex.getMessage());
        }
        return oid;
    }

    public void save(Mapeador p) {
        if (p.getOid() == 0) {
            insert(p);
        } else {
            update(p);
        }
    }

    private void insert(Mapeador p) {
        int oid = nextOid();
        p.setOid(oid);
        ArrayList<String> sqls = p.getSqlInsert();
        if (!base.transaction(sqls)) {
            System.out.println("No se pudo insertar el objeto");
            p.setOid(0);
        }
    }

    private void update(Mapeador p) {

        ArrayList<String> sqls = p.getSqlUpdate();
        if (!base.transaction(sqls)) {
            System.out.println("Error al actualizar el objeto");
        }

    }

    public void delete(Mapeador p) {
        if (p.getOid() == 0) {
            return;
        }
        ArrayList<String> sqls = p.getSqlDelete();
        if (!base.transaction(sqls)) {
            System.out.println("Error al borrar el objeto");
        } else {
            p.setOid(0);
        }
    }

    public ArrayList<Object> all(Mapeador map) {
        return search(map, null);
    }

    public ArrayList search(Mapeador map, String filtro) {
        ArrayList lista = new ArrayList();
        String sql = map.getSqlSelect();//
        if (filtro != null) {
            sql += " WHERE " + filtro;
        }
        ResultSet rs = base.execute(sql);
        try {
            //Asumo orden por oid
            int oidAnt = -1;
            int oidActual;
            while (rs.next()) {
                oidActual = rs.getInt("oid");
                if (oidActual != oidAnt) {
                    map.newSameType();
                    map.setOid(oidActual);
                    oidAnt = oidActual;
                    lista.add(map.getObjet());
                    map.readComposite(rs); //cabezal
                }
                map.readComponent(rs);//linea

            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar:" + ex);
            return null;
        }
        return lista;
    }
}

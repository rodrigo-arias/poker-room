package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Mapeador {

    public int getOid();

    public void setOid(int oid);

    public ArrayList<String> getSqlInsert();

    public ArrayList<String> getSqlUpdate();

    public ArrayList<String> getSqlDelete();

    public String getSqlSelect();

    public void newSameType();

    public void readComposite(ResultSet rs) throws SQLException;

    public void readComponent(ResultSet rs) throws SQLException;

    public Object getObjet();
}

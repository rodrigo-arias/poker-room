package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

    //==================  Attributes  ==================//
    private static BaseDatos instancia = new BaseDatos();
    private Connection conexion;
    private Statement stmt;

    //=================  Constructor  ================//
    public static BaseDatos instancia() {
        return instancia;
    }

    private BaseDatos() {
    }

    //==================  Methods  ==================//
    public void connect(String base, String usuario, String pass) {
        String driver = "com.mysql.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/" + base;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(connection, usuario, pass);
            stmt = conexion.createStatement();

            System.out.println("Conectado");
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    public int update(String sql) {
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al modificar:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return -1;
        }
    }

    public ResultSet execute(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al consultar:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return null;
        }
    }

    public void close() {
        try {
            conexion.close();
        } catch (SQLException ex) {

        }
    }

    public boolean transaction(ArrayList<String> sqls) {
        try {
            conexion.setAutoCommit(false); // Begin transaction
            for (String sql : sqls) {
                if (update(sql) < 0) {
                    throw new SQLException("Fallo update en la transacción");
                }
            }
            conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Error en la transacción:" + ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en la transacción. No se pudo ejecutar el rollback");
            }
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true); // End transaction
            } catch (SQLException ex) {
            }
        }
        return true;
    }

}

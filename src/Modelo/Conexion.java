package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    static Connection con = null;
    static String usuario;
    static String password;
    static boolean status = false;
    static String IpRemoto;
    
    public static String getIpRemoto() {
        return IpRemoto;
    }

    public static void setIpRemoto(String IpRemoto) {
        Conexion.IpRemoto = IpRemoto;
    }

    public static Connection getConexion() {
        status = false;
        
        String url = "jdbc:sqlserver://sqlpruebasmvc.database.windows.net:1433;databaseName=Licoreria";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "error al conectar " + e);
        }

        try {
            con = DriverManager.getConnection(url, "lgonzalo", "@lmgv0704");
            status = true;
            //JOptionPane.showMessageDialog(null, "conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error " + e);
        }
        return con;
    }
   
    
    public static ResultSet consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al obtener datos");
        }
        return null;
    }
}

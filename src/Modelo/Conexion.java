package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    static Connection con = null;
    static ResultSet respuesta = null;
    
    

   public static Connection getConexion() {
        try {
            String db = "jdbc:mysql://localhost:3306/licoreria";
            con = DriverManager.getConnection(db, "root", "");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }
    
   /* public static Connection getConexion() {
        status = false;
        
        String url = "jdbc:sqlserver://192.168.100.45:1433;databaseName=Licoreria";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "error al conectar " + e);
        }

        try {
            con = DriverManager.getConnection(url, "sa", "gonzalo1996");
            status = true;
            //JOptionPane.showMessageDialog(null, "conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error " + e);
        }
        return con;
    }*/
   
    
   public static ResultSet consulta(String consulta) {
        Connection con = getConexion();
        Statement declara = null;
        try {
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al obtener datos");
        }
        return null;
    }
}

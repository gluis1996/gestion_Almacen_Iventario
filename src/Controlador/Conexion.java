/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LUIS
 */
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

        String url = "jdbc:sqlserver://" + Conexion.getIpRemoto() + ":1433;databaseName=Licoreria";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "error al conectar " + e);
        }

        try {
            con = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            status = true;
            //JOptionPane.showMessageDialog(null, "conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error " + e);
        }
        return con;

    }
    public static void setCuenta(String usu, String pas) {
        usuario = usu;
        password = pas;
    }
    
    public static boolean getStatus() {
        return status;
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


package Modelo;

/**
 *
 * @author LUIS
 */
import Controlador.*;
import java.sql.*;
public class M_Insercion {
    public static void sp_InsentarEmpleados(String a,String b ,String c,String d,String e,int f,String g,String h,String i) throws SQLException{
         CallableStatement cs = Conexion.getConexion().prepareCall("{call SP_NuevoEmpleado(?,?,?,?,?,?,?,?,?)}");
         cs.setString(1, a);
         cs.setString(2, b);
         cs.setString(3, c);
         cs.setString(4, d);
         cs.setString(5, e);
         cs.setInt(6, f);
         cs.setString(7, g);
         cs.setString(8, h);
         cs.setString(9, i);
         cs.execute();
    }
    
}

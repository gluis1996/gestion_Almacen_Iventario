/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;
public class m_detalleReponedorDAO {
    Connection cn;

public void ingresaDetalleReponedor(m_detalleReponedor m){

String consulta = "{call sp_ingresar_detalle_reponedor (?,?,?,?)}";
    try {
        CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
        cs.setString(1, m.getIdEmpleado());
        cs.setString(2, m.getIdProducto());
        cs.setInt(3, m.getCantidadRegistrada());
        cs.setString(4, m.getDetalle());
        cs.execute();
        JOptionPane.showMessageDialog(null, "exito dr");
        
    } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error Ingresar Deta Repo" + e, "Error", JOptionPane.ERROR_MESSAGE);
    }

}




}

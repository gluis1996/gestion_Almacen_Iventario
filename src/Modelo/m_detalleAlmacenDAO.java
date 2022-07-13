/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class m_detalleAlmacenDAO {
    
    
    
    public void ingresar(m_detalleAlmacen m){
        String consulta="call sp_ingreso_detalleAlmacen(?,?,?,?,?)";
        try {
           CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
           cs.setString(1, m.getIdEmpleado());
           cs.setString(2, m.getIdproducto());
           cs.setString(3, m.getRUC());
           cs.setInt(4, m.getCantidadIngresada());
           cs.setDouble(5, m.getPreico_compra());
           cs.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Registrar detalle A "+e);
        }    
    }
    
    
    public DefaultTableModel mostrar(){
     DefaultTableModel modelo;
     String cabecera[] = {"idemp", "idpro", "nombre pro", "categoria", "ruc", "cantidad Ingresada","precio Compra","precio Venta"};
     modelo = new DefaultTableModel(null, cabecera);
     String []Registros = new String[8];
     return  modelo;
     }
    
}

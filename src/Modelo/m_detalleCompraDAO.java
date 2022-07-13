
package modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class m_detalleCompraDAO {
    
    ResultSet rs ;
    
    public void MostrarCompra(JTable tabla)  {
        DefaultTableModel  modelo;
        String cabecera []={"idCompra", "Idproducto ", "Cantidad", "Precio_Unitario","sub_total"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("select *from compra");
        try {
            while (rs.next()){
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getInt(3));
                vc.add(rs.getDouble(4));
                vc.add(rs.getDouble(5));
                modelo.addRow(vc);
                tabla.setModel(modelo);            
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        }
    
     public void ingresarCompra(m_detalleCompra em) {
        String sql = "{call sp_Ingresar_DetalleCompra(?,?,?,?,?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.setString(1, em.getIdCompra());
            cs.setString(2, em.getIdproducto());
            cs.setInt(3, em.getCantidad());
            cs.setDouble(4, em.getPrecio_Unitario());
            cs.setDouble(5, em.getSub_total());            
            cs.execute();
            JOptionPane.showMessageDialog(null, "exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el " + "\n" + e);
        }
    }
     
     public DefaultTableModel mostrar(){
     DefaultTableModel modelo;
     String cabecera[]={"Idproducto ", "Cantidad", "Precio_Unitario","sub_total"};
     modelo = new DefaultTableModel(null, cabecera);
     String []Registros = new String[4];
     return  modelo;
     }
    
     
     
}

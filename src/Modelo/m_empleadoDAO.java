package modelo;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class m_empleadoDAO {

    Conexion con;

    public m_empleadoDAO() {
        con = new Conexion();
    }
    
       ResultSet rs;
       
    public void InsertarEmpleado(m_empleado em){
        try {
          CallableStatement cs = Conexion.getConexion().prepareCall("{call SP_NuevoEmpleado (?,?,?,?,?,?,?,?,?,?)}");
          cs.setString(1, em.getTipodocumento());
          cs.setString(2, em.getNumerodocumento());
          cs.setString(3, em.getNombre());
          cs.setString(4, em.getApellido());
          cs.setString(5, em.getNacionalidad());
          cs.setInt(6, em.getEdad());
          cs.setString(7, em.getGenero());
          cs.setString(8, em.getDistrito());
          cs.setString(9, em.getEstado());
          cs.setString(10, em.getRol());
          cs.execute();    
          JOptionPane.showMessageDialog(null, "exitoso");
     } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el "+"\n"+e);
     }
 }  
    
    
    public void llenarEnTabla(JTable tabla){
        DefaultTableModel  modelo;
        String cabecera []={"CodEmpleado", "Tdocumento", "numeroDocumento", "nombre", "apellido", "nacionalidad", "edad", "genero", "distrito", "estado"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("select *from empleado");
        try {
            while (rs.next()){
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                vc.add(rs.getString(5));
                vc.add(rs.getString(6));
                vc.add(rs.getInt(7));
                vc.add(rs.getString(8));
                vc.add(rs.getString(9));
                vc.add(rs.getString(10));
                modelo.addRow(vc);
                tabla.setModel(modelo);            
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        }
    
}


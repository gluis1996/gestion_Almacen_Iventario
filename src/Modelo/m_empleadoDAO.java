package modelo;
import java.sql.*;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class m_empleadoDAO {

    private Conexion con ;
    private Connection cn = Conexion.getConexion();

    /*public m_empleadoDAO() {
       con = new Conexion();
    }*/
    
       ResultSet rs;
       
    public void InsertarEmpleado(m_empleado em){
        try {
          CallableStatement cs = Conexion.getConexion().prepareCall("{call SP_NuevoEmpleado (?,?,?,?,?,?,?,?,?,?,?)}");
          cs.setString(1, em.getCodigo());
          cs.setString(2, em.getTipodocumento());
          cs.setString(3, em.getNumerodocumento());
          cs.setString(4, em.getNombre());
          cs.setString(5, em.getApellido());
          cs.setString(6, em.getNacionalidad());
          cs.setInt(7, em.getEdad());
          cs.setString(8, em.getGenero());
          cs.setString(9, em.getDistrito());
          cs.setString(10, em.getEstado());
          cs.setInt(11, em.getRol());
          cs.execute();    
          JOptionPane.showMessageDialog(null, "exitoso");
     } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el "+"\n"+e);
     }

 }  
    
    
        public void actualziarEmpleado(m_empleado em){
        try {
          CallableStatement cs = Conexion.getConexion().prepareCall("{call SP_Actualizar_NuevoEmpleado(?,?,?,?,?,?,?,?,?)}");
          cs.setString(1, em.getCodigo());
          cs.setString(2, em.getNumerodocumento());
          cs.setString(3, em.getNombre());
          cs.setString(4, em.getApellido());
          cs.setString(5, em.getNacionalidad());
          cs.setInt(6, em.getEdad());
          cs.setString(7, em.getDistrito());
          cs.setString(8, em.getEstado());
          cs.setInt(9, em.getRol());
          cs.execute();    
          JOptionPane.showMessageDialog(null, "Actualizacion exitoso");
     } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el "+"\n"+e);
     }

 }  
    
    public void eliminar(m_empleado em){
        
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call sp_eliminarEmpleado(?)}");
            cs.setString(1, em.getCodigo());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado","exito",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el " + "\n" +e);
        
        }
    
    }
    
    public int generarCodigo() {
    String consulta = ("select count(idempleado) as id from empleado");
        int cod = 0;
        try {
            
            ResultSet rs = Conexion.consulta(consulta);
            if (rs.next()) {
                cod = rs.getInt("id") + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error sql" + e.getMessage());

        }
        return cod;
    }
    
    
    public void llenarEnTablaEmpleado(JTable tabla)  {
        DefaultTableModel  modelo;
        String cabecera []={"Cod", "Documento", "Numero", "Nombre", "Apellido", "Nacionalidad", "Edad", "Genero", "Distrito", "Estado","idroles"};
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
                vc.add(rs.getInt(11));
                modelo.addRow(vc);
                tabla.setModel(modelo);            
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        }
    
    public void llenarTablaUsuario(JTable tabla) {
        DefaultTableModel  modelo;
        String cabecera []={"Usuario", "Contraseña", "Fecha Creacion", "IdEmpleado"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("SELECT * FROM usuario");
        try {
            while (rs.next()){
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));               
                modelo.addRow(vc);
                tabla.setModel(modelo);            
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarRolEmpleado(JComboBox c) {
        try {
            rs = Conexion.consulta("select concat(idroles,' - ',nombre) as cod from roles");
            c.addItem("selecionar");
            while (rs.next()) {
                c.addItem(rs.getString("cod"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error cargar categoria " + e.getMessage());
        }
    }
    
    
}


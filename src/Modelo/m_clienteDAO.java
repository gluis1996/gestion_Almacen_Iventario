
package modelo;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class m_clienteDAO {
    Conexion c;

    /*public m_clienteDAO() {
        c = new Conexion();
    }*/
    
     public void ingresar (m_cliente c){
     String sql = ("call sp_ingresar_Cliente(?,?,?,?,?,?,?,?,?,?,?)");
         try {
             CallableStatement cs = Conexion.getConexion().prepareCall(sql);
             cs.setString(1, c.getIdCliente());
             cs.setString(2, c.getTipoDocumento());
             cs.setString(3, c.getDocuemnto());
             cs.setString(4, c.getNombre());
             cs.setString(5, c.getApellido());
             cs.setString(6, c.getDireccion());
             cs.setString(7, c.getTelefono());
             cs.setString(8, c.getEmail());
             cs.setString(9, c.getFechaNacimiento());
             cs.setString(10, c.getEstadoCivil());
             cs.setString(11, c.getGenero());
             cs.execute();
             JOptionPane.showMessageDialog(null,"Cliente Registrado");
             
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error en registro "+e);
         }
     
     }
     
      public void Actualizar (m_cliente c){
     String sql = ("call sp_actualizar_Cliente(?,?,?,?,?,?,?,?,?,?,?)");
         try {
             CallableStatement cs = Conexion.getConexion().prepareCall(sql);
             cs.setString(1, c.getIdCliente());
             cs.setString(2, c.getTipoDocumento());
             cs.setString(3, c.getDocuemnto());
             cs.setString(4, c.getNombre());
             cs.setString(5, c.getApellido());
             cs.setString(6, c.getDireccion());
             cs.setString(7, c.getTelefono());
             cs.setString(8, c.getEmail());
             cs.setString(9, c.getFechaNacimiento());
             cs.setString(10, c.getEstadoCivil());
             cs.setString(11, c.getGenero());
             cs.execute();
             JOptionPane.showMessageDialog(null,"Cliente Actualizado");
             
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error en registro "+e);
         }
     
     }
    
      public void mostrar(JTable tabla) {
      DefaultTableModel modelo;
      String cabecera[] = {"ID","Documento","Nº Doc","Nombre","Apellido","Direccion","Telefono","Email","Nacimiento","Estado C","Genero"};
      modelo = new DefaultTableModel(null,cabecera);
      tabla.setModel(modelo);
      modelo.setNumRows(0);
      ResultSet rs = Conexion.consulta("select *from Cliente");      
          try {
              while (rs.next()){
              Vector v = new Vector();
              v.add(rs.getString(1));
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
              v.add(rs.getString(7));
              v.add(rs.getString(8));
              v.add(rs.getString(9));
              v.add(rs.getString(10));
              v.add(rs.getString(11));
              modelo.addRow(v);
              tabla.setModel(modelo);
              }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Hubo un probelma "+e);
          }
      }
      
      public int generarCodigo() {
    String consulta = ("select count(IdCliente) as id from cliente");
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
      
      public void EliminarCliente(m_cliente c){
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call sp_EliminarCliente(?)}");
            cs.setString(1, c.getIdCliente());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado","exito",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el " + "\n" +e);
        
        }    
      
      }
       public void buscar(m_cliente c) {        
        String consulta = "SELECT * from cliente where idCliente = '" + c.getIdCliente() + "' or docuemnto = '" + c.getIdCliente() + "'";
        ResultSet rs = Conexion.consulta(consulta);
        try {
            while (rs.next()) {
               c.setIdCliente(rs.getNString(1));
               c.setNombre(rs.getNString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en Buscar Cliente " + e);
        }

    }
    
}

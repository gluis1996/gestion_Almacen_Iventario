package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class m_proveedorDAO {

    Conexion cn = new Conexion();
    Connection con;
    ResultSet rs;

    public void registrar(m_proveedor prov) {
        String sql = "call sp_ingresar_proveedor(?,?,?,?,?,?)";
        try {
            CallableStatement ps = Conexion.getConexion().prepareCall(sql);
            ps.setString(1, prov.getId_proveedor());
            ps.setString(2, prov.getRazon_social());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getCorreo());
            ps.setString(5, prov.getContacto());
            ps.setString(6, prov.getContacto_comercial());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en regitrar proveedor" + e, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void modificar(m_proveedor prov) {
        String sql = "call sp_actualizar_proveedor(?,?,?,?,?,?)";
        try {
            CallableStatement ps = Conexion.getConexion().prepareCall(sql);
            ps.setString(1, prov.getId_proveedor());
            ps.setString(2, prov.getRazon_social());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getCorreo());
            ps.setString(5, prov.getContacto());
            ps.setString(6, prov.getContacto_comercial());
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void eliminar(String d) {
        String consulta = "DELETE FROM proveedor WHERE IdProveedor='" + d + "'";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            int r = JOptionPane.showConfirmDialog(null, "desea eliminar","atencion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (r == 0){
                cs.execute();
                JOptionPane.showMessageDialog(null, "Eliminado con Exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error eliminar pro", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostrar(JTable tabla) {
        DefaultTableModel modelo;
        String cabecera[] = {"Id_proveedor","RUC"+ "Razon_social", "Direccion", "Correo", "Contacto", "Contacto_comercial", "Fecha_registro"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("select *from Proveedor");
        try {
            while (rs.next()) {
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                vc.add(rs.getString(5));
                vc.add(rs.getString(6));
                vc.add(rs.getString(7));
                modelo.addRow(vc);
                tabla.setModel(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public int generarCodigo() {
        String consulta = ("select count(IdProveedor) as id from proveedor");
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
    
    public String buscarProveedor(String cod){
        String consulta="select RUC,Razon_Social from proveedor where ruc =('"+cod+"')";
        rs = Conexion.consulta(consulta);
        try {
            while(rs.next()){
                return rs.getNString(2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Buscar "+e);
            return null;
        }
        return null;
    
    }
}

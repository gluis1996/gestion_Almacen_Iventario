package modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.*;

public class m_compraDAO {

    ResultSet rs;
    Connection cn;

    public void ingresarCompra(m_compra em) {

        String sql = "{call sp_ingresar_Compra (?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.setString(1, em.getIdCompra());
            cs.setString(2, em.getIdEmpleado());
            cs.setString(3, em.getIdCliente());
            cs.setDouble(4, em.getTotal());
            cs.setString(5, em.getComprovante());
            cs.setString(6, em.getNumero_comprovante());
            cs.setInt(7, em.getCantidadTotal());
            cs.execute();
            JOptionPane.showMessageDialog(null, "exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el " + "\n" + e);
        }
    }

    public void MostrarCompra(JTable tabla) {
        DefaultTableModel modelo;
        String cabecera[] = {"idCompra", "IdEmpleado", "IdCliente", "Fecha_Compra", "total", "comprovante", "numero_comprovante", "cantidadTotal"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("select *from compra");
        try {
            while (rs.next()) {
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getString(4));
                vc.add(rs.getDouble(5));
                vc.add(rs.getString(6));
                vc.add(rs.getString(7));
                vc.add(rs.getInt(8));
                modelo.addRow(vc);
                tabla.setModel(modelo);
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo;
        String cabecera[] = {"Idproducto ", "cantidadTotal", "total"};
        modelo = new DefaultTableModel(null, cabecera);
        String[] Registros = new String[6];
        return modelo;
    }

    public int GenerarCompraventeFactura() {
        String consulta = ("select count(numero_comprovante) as id from compra where comprovante='Factura'");
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

    public int GenerarCompraventeBoleta() {
        String consulta = ("select count(numero_comprovante) as id from compra where comprovante='Boleta'");
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

    public String idCompra() {
        String idv = "";
        String consulta = ("select count(idCompra) as id from compra");

        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error sql" + e.getMessage());
        }
        return idv;
    }
}

package modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class m_categoriaDAO {

    Conexion con;
    Connection cn;

    public m_categoriaDAO() {
        con = new Conexion();
    }

    public void mostarTabla(JTable tabla) {
        DefaultTableModel modelo;
        String cabecera[] = {"id", "nombre"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        ResultSet rs = Conexion.consulta("Select *from categoria");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registar(m_categoria mc) {
        String consulta = "{call sp_insertar_categoria(?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setString(1, mc.getNombre());
            cs.execute();
            JOptionPane.showMessageDialog(null, "exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en regitrar Categoria" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

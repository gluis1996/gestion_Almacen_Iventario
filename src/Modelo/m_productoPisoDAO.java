/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.*;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class m_productoPisoDAO {

    Conexion con;
    Connection cn;

    public m_productoPisoDAO() {
        con = new Conexion();
    }

    public void ingresar(m_productoPiso mps) {
        String consulta = "{call sp_insertar_productoPiso(?,?,?,?,?,?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setString(1, mps.getCodigo());
            cs.setString(2, mps.getDescripcion());
            cs.setInt(3, mps.getCategoria());
            cs.setInt(4, mps.getCantidad());
            cs.setDouble(5, mps.getPrecioUnitario());
            cs.setInt(6, mps.getLimiteStock());
            cs.execute();
            JOptionPane.showMessageDialog(null, "exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en regitrar Categoria" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(m_productoPiso mps) {
        String consulta = "{call sp_actualizar_productoPiso(?,?,?,?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setString(1, mps.getCodigo());
            cs.setInt(2, mps.getCantidad());
            cs.setDouble(3, mps.getPrecioUnitario());
            cs.setInt(4, mps.getLimiteStock());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en regitrar Categoria" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int generarCodigo() {
        String consulta = ("select count(Idproducto) as id from producto");
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

    public void cargarcategoria(JComboBox c) {
        try {
            ResultSet rs = Conexion.consulta("select concat( IdCategoria,' - ', Descripcion) as cod from categoria ");
            c.addItem("selecionar");
            while (rs.next()) {
                c.addItem(rs.getString("cod"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error cargar categoria " + e.getMessage());
        }
    }

    public void llenarEnTabla(JTable tabla) {
        DefaultTableModel modelo;
        String cabecera[] = {"Id", "Nombre", "nombre_categoria", "cantidad", "precio", "limite"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        ResultSet rs = Conexion.consulta("{call 	sp_listar_producto}");
        try {
            while (rs.next()) {
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getString(3));
                vc.add(rs.getInt(4));
                vc.add(rs.getDouble(5));
                vc.add(rs.getInt(6));
                modelo.addRow(vc);
                tabla.setModel(modelo);
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

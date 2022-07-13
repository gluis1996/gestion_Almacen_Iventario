/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class m_productoAlmacenDAO {

    private Connection cn;
    private ResultSet rs;

    public m_productoAlmacenDAO() {
    }

    public void IngresarproductoAlmacen(m_productoAlmacen m) {
        String consulta = "call sp_ingreso_productoAlmacen(?,?,?,?,?)";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setString(1, m.getCodigo());
            cs.setString(2, m.getDescripcion());
            cs.setInt(3, m.getCategoria());
            cs.setInt(4, m.getCantidad());
            cs.setDouble(5, m.getPrecio_venta());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Registro almacen Exitoso ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error registro en PA " + e);
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
            JOptionPane.showMessageDialog(null, "Error sql existe o hay un error " + e.getMessage());
        }
        return cod;
    }

    public void cargarcategoria(JComboBox c) {
        try {
            rs = Conexion.consulta("select concat(IdCategoria,' - ',Descripcion) as cod from categoria");
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
        String cabecera[] = {"idpro", "nombre pro","idCAt","ruc","Razon social", "cantidad Ingresada", "precio Compra", "precio Venta"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        ResultSet rs = Conexion.consulta("{call 	sp_lista_productosAlmacen}");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getInt(7));
                v.add(rs.getDouble(8));
                v.add(rs.getDouble(9));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga PA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void MPAmenores(JTable tabla, int c) {
        String consulta = "call sp_buscarPAmenores ('" + c + "')";
        DefaultTableModel modelo;
        String cabecera[] = {"idpro", "nombre pro","idCAt","ruc","Razon social", "cantidad Ingresada", "precio Compra", "precio Venta"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta(consulta);
        try {
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getInt(7));
                v.add(rs.getDouble(8));
                v.add(rs.getDouble(9));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
        } catch (Exception e) {
        }
        
    }
    public void disminuir(String idp, int can) {
        String consulta = "update producto_almacen set Cantidad=Cantidad-? where Idproducto=?";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setInt(1, can);
            cs.setString(2, idp);
            cs.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en disminuir " + e);
        }
    }

    public boolean Aumentar(String idp, int can) {
        String consulta = "update producto_almacen set Cantidad=Cantidad+? "
                + "where Idproducto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(consulta);
            pst.setInt(1, can);
            pst.setString(2, idp);
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en Aumentar " + e);
            return false;
        }
    }

    public void actualizar(m_productoAlmacen mps) {
        String consulta = "{call sp_actualizar_productoAlmacen(?,?,?)}";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            cs.setString(1, mps.getCodigo());
            cs.setInt(2, mps.getCantidad());
            cs.setDouble(3, mps.getPrecio_venta());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Producto AA Actualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe en Actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String buscarProdcuto(String cod) {
        String consulta = "call sp_buscarProdutoAlmacen('" + cod + "')";
        rs = Conexion.consulta(consulta);
        try {
            while (rs.next()) {
                return rs.getNString(2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Buscar " + e);
            return null;
        }
        return null;
    }


}

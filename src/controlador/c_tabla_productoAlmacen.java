/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.vi_tabla_productoAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author LUIS
 */
public class c_tabla_productoAlmacen implements ActionListener{
    vi_tabla_productoAlmacen vista;
    
    public c_tabla_productoAlmacen(vi_tabla_productoAlmacen vista) {
        this.vista = vista;
        llenarEnTabla(vista.tabla);
        this.vista.boton_buscar.addActionListener(this);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.boton_buscar){
            buscar(vista.tabla);
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
        
        
         public void buscar(JTable tabla) {        
        DefaultTableModel modelo;
        String cabecera[] = {"idpro", "nombre pro","cat","ruc","Razon social", "Stock", "precio Venta"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        String consulta = "call sp_buscarProdutoAlmacen('"+vista.txtBuscarCodig.getText()+"')";
        ResultSet rs = Conexion.consulta(consulta);
        try {
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getInt(6));
                v.add(rs.getDouble(7));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }


}

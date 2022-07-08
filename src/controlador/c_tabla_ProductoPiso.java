/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.vi_tabla_ProductoPiso;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.m_productoPisoDAO;

/**
 *
 * @author LUIS
 */
public class c_tabla_ProductoPiso implements ActionListener{
    vi_tabla_ProductoPiso vista;
   
    m_productoPisoDAO mp = new m_productoPisoDAO();

    public c_tabla_ProductoPiso(vi_tabla_ProductoPiso vista) {
        this.vista = vista;
        //mp.llenarEnTabla(vista.tabla);
        this.vista.boton_buscar.addActionListener(this);
        this.vista.boton_todo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.boton_buscar){
            buscar(vista.tabla);
        }else if (e.getSource()== vista.boton_todo){
            mp.llenarEnTabla(vista.tabla);
        }
    
    }
    

   
     public void buscar(JTable tabla) {
        DefaultTableModel modelo;
        String cabecera[] = {"Id", "Nombre", "nombre_categoria", "cantidad", "precio", "limite"};
        modelo = new DefaultTableModel(null, cabecera);
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        String consulta = "call sp_bucarProducto ('" + vista.txtbuscar.getText() + "')";
        ResultSet rs = Conexion.consulta(consulta);
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
                JOptionPane.showMessageDialog(null,"El prodcuto  : "+ rs.getString(2)+ "\n su cantida es : "+ rs.getInt(4)+"\n su precio es : "+rs.getDouble(5));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

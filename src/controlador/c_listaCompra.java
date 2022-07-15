/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.vi_listaCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author LUIS
 */
public class c_listaCompra implements ActionListener{
    private vi_listaCompra vista;
    private 
    ResultSet rs ;
    
    public c_listaCompra(vi_listaCompra vista) {
        this.vista = vista;
        this.vista.boton_buscar.addActionListener(this);
        this.vista.boton_buscarDetalle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == vista.boton_buscar){
       lenartabla();
       }else if (e.getSource() == vista.boton_buscarDetalle){
           buscarDetalleCompra();
       }
    }
    
    
        public void lenartabla(){
    
        DefaultTableModel  modelo;
        String cabecera []={"idCompra ", "IdEmpleado ", "IdCliente ", "Fecha_Compra", "total", "comprovante", "numero_comprovante","cantidadTotal"};
        modelo = new DefaultTableModel(null, cabecera);
        vista.tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("SELECT * FROM compra WHERE IdEmpleado = '"+vista.lblcodv.getText()+"'");
        try {
            while (rs.next()){
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
                vista.tabla.setModel(modelo);            
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
        
        public void buscarDetalleCompra(){
    
        DefaultTableModel  modelo;
        String cabecera []={"idCompra  ", "Idproducto  ", "Cantidad ", "Precio_Unitario", "sub_total"};
        modelo = new DefaultTableModel(null, cabecera);
        vista.tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("SELECT * FROM `detalle_compra` WHERE idCompra='"+vista.txtCodigo.getText()+"'");
        try {
            while (rs.next()){
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
               vc.add(rs.getInt(3));
                vc.add(rs.getDouble(4));
                vc.add(rs.getDouble(5));
                modelo.addRow(vc);
                vista.tabla.setModel(modelo);            
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
        
}

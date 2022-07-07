
package controlador;

import Vistas_InternasAdmin.vi_detalleIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Conexion;
import vistav.v_principal;

/**
 *
 * @author LUIS
 */
public class c_detalleIngreso implements ActionListener{
    private vi_detalleIngreso vista;
    
    ResultSet rs;
    public c_detalleIngreso(vi_detalleIngreso vista) {
        this.vista = vista;
        this.vista.boton_mostrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.boton_mostrar){
            cargar();
        }
    }
    
    public void cargar(){
    
    DefaultTableModel  modelo;
        String cabecera []={"IdEmpleado", "Idproducto", "Cantidad_Registrada", "fecha", "Detalle"};
        modelo = new DefaultTableModel(null, cabecera);
        vista.tabla.setModel(modelo);
        modelo.setRowCount(0);
        rs = Conexion.consulta("select IdEmpleado,Idproducto,Cantidad_Registrada,fecha,Detalle from detalle_reponedor where IdEmpleado='"+
               vista.lblcodi.getText()+"'");
        try {
            while (rs.next()){
                Vector vc = new Vector();
                vc.add(rs.getString(1));
                vc.add(rs.getString(2));
                vc.add(rs.getInt(3));
                vc.add(rs.getString(4));
                vc.add(rs.getString(5));
                modelo.addRow(vc);
                vista.tabla.setModel(modelo);            
            }
            JOptionPane.showMessageDialog(null, "exito");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la Carga","Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
}

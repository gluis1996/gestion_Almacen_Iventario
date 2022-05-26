package Modelo;
import java.sql.*;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Controlador.*;
public class M_MostrarDatos {
    ResultSet rs;
    
    public void MostrarModelo(JTable jTable1){
        DefaultTableModel modelo ;        
        String cabecera []={"CodEmpleado","Tdocumento","numeroDocumento","nombre","apellido","nacionalidad","edad","genero","distrito","estado"};
        String data [][]={};        
        modelo = new DefaultTableModel(data, cabecera);
        jTable1.setModel(modelo);  
        modelo.setRowCount(0);
        rs = Conexion.consulta("select * from Empleado"); 
        try {
            while (rs.next()) {                
            Vector vc = new Vector();
            vc.add(rs.getString(1));
            vc.add(rs.getString(2));
            vc.add(rs.getString(3));
            vc.add(rs.getString(4));
            vc.add(rs.getString(5));
            vc.add(rs.getString(6));
            vc.add(rs.getInt(7));
            vc.add(rs.getString(8));
            vc.add(rs.getString(9));
            vc.add(rs.getString(10));
            modelo.addRow(vc);
            jTable1.setModel(modelo);    
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro en los datos \n" +e);
        }
        }
}

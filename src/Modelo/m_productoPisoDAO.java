/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class m_productoPisoDAO {

    Conexion con;
    Connection cn ;

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
    
    public int generarCodigo() {
        String consulta = ("select max(Idproducto) as id from producto");
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
    
    public void cargarcategoria(JComboBox c){       
    
        try {
            ResultSet rs = Conexion.consulta("select concat( IdCategoria,' - ', Descripcion) as cod from categoria ");
            c.addItem("selecionar");
            while(rs.next()){
                c.addItem(rs.getString("cod"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error cargar categoria "+e.getMessage());
        }
    
    }

}

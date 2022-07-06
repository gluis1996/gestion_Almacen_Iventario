package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class m_loginDAO {
    
    Conexion con;
    
    /*public m_loginDAO(){
    con = new Conexion();
    }*/
    
    public ArrayList<m_login> lo(String user,String pass){
    
     Connection Conectar;
     PreparedStatement ps;
     ResultSet rs = null;
     ArrayList lista = new ArrayList();
     
        try {
            Conectar = Conexion.getConexion();
            if(Conectar != null){
                String sql = "select usuario,contraseña,rol from usuario where usuario = ? and contraseña = ?";
                ps = Conectar.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);
                
                rs= ps.executeQuery();
                
                while (rs.next()){
                    m_login l = new m_login();
                    l.setUsuario(rs.getString(1));
                    l.setContraseña(rs.getString(2));
                    l.setRol(rs.getString(3));                    
                    lista.add(l);                    
                }            
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e, "Error", JOptionPane.ERROR_MESSAGE);
        }    
    return lista;
    }
    
}

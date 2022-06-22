package controlador;

import Vistas_InternasAdmin.vi_categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.m_categoria;
import modelo.m_categoriaDAO;

public class c_categoria implements ActionListener {

    private vi_categoria vista;
    private m_categoria c;
    private m_categoriaDAO cd;
    private ResultSet rs;
    int contador;

    public c_categoria(vi_categoria vista) {
        this.vista = vista;
        this.vista.boton_guardar.addActionListener(this);
        this.vista.boton_listar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();
        if (ev.equals(vista.boton_guardar)) {
            ingresar();
        }else if (ev.equals(vista.boton_listar)){
            cd = new m_categoriaDAO();
            cd.mostarTabla(vista.tabla);
        }
    }

    public void ingresar() {
        try {
            c = new m_categoria();
            cd = new m_categoriaDAO();
            c.setNombre(vista.txtnombre.getText());

            if (vista.txtnombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios");
                vista.txtnombre.requestFocus();
            } else {
                rs = Conexion.consulta("select COUNT(Descripcion) from categoria where Descripcion = '" + vista.txtnombre.getText() + "'");
                try {
                    while (rs.next()) {
                        contador = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erroe en la consulta " + e);
                }
                if (contador >= 1) {
                    JOptionPane.showMessageDialog(null, "Ya exite la categoria", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    cd.registar(c);
                    cd.mostarTabla(vista.tabla);
                    vista.txtnombre.setText("");
                    vista.txtnombre.requestFocus();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
    
    public void mostrar(){
    
    }

}

package controlador;

import Vistas_InternasAdmin.vi_Ingreso_a_Piso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.m_productoPisoDAO;

public class c_ingreso_piso implements ActionListener{
    m_productoPisoDAO mpisoDAO = new m_productoPisoDAO();
    vi_Ingreso_a_Piso vista;

    public c_ingreso_piso() {
    }

    public c_ingreso_piso(vi_Ingreso_a_Piso vista) {
        this.vista = vista;
        this.vista.boton_mostar_todo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == vista.boton_mostar_todo){
       mpisoDAO.llenarEnTabla(vista.tabla);
       
       }
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.v_principal;

/**
 *
 * @author LUIS
 */
public class c_principal implements ActionListener{
    private v_principal vista;
    
    private vi_empleado ve = new vi_empleado(); 
    private vi_proveedores vp = new vi_proveedores();
    private vi_categoria vc = new vi_categoria();
    private vi_productoPiso vpp = new vi_productoPiso();
    
    
    
    
    public c_principal(v_principal vista) {
        this.vista = vista;
        this.vista.tb_empleados.addActionListener(this);
        this.vista.ms_salir.addActionListener(this);
        this.vista.ma_proveedor.addActionListener(this);
        this.vista.mp_categoria.addActionListener(this);
        this.vista.mp_productopiso.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();
        if (ev.equals(vista.tb_empleados)){
            vista.ADescritorio.add(ve);
            ve.setVisible(true);             
        }else if (ev.equals(vista.ms_salir)){
            vista.dispose();
            c_login.mostrar();
        }else if (ev.equals(vista.ma_proveedor)){
            JOptionPane.showMessageDialog(null, "exito");
        }else if (ev.equals(vista.mp_categoria)){
            vista.ADescritorio.add(vc);
            vc.setVisible(true);
        }else if (ev.equals(vista.mp_productopiso)){
            vista.ADescritorio.add(vpp);
            vpp.setVisible(true);
        }
    }
    
    
    

    
}

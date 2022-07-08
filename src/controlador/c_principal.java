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
import modelo.m_productoPisoDAO;
import vistav.v_principal;

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
    private m_productoPisoDAO mp;
    private vi_Cliente vcli = new vi_Cliente();
    private vi_compra vcp = new vi_compra();
    private vi_Ingreso_a_Piso vip = new vi_Ingreso_a_Piso();
    private vi_tabla_ProductoPiso vtp = new vi_tabla_ProductoPiso();
    private vi_detalleIngreso vdi = new vi_detalleIngreso();
    //proveedor
    private vi_proveedores vpro = new vi_proveedores();
    
    
    
    public c_principal(v_principal vista) {
        this.vista = vista;
        this.vista.tb_empleados.addActionListener(this);
        this.vista.mv_clientes.addActionListener(this);
        this.vista.ms_salir.addActionListener(this);
        this.vista.mp_categoria.addActionListener(this);
        this.vista.mp_productopiso.addActionListener(this);
        this.vista.mv_nuevaVenta.addActionListener(this);
        this.vista.mr_ingresoapiso.addActionListener(this);
        this.vista.mr_detalleIngreso.addActionListener(this);
        //proveedor        
        this.vista.ma_proveedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();
        if (ev.equals(vista.tb_empleados)){
            v_principal.ADescritorio.add(ve);
            ve.setVisible(true);             
        }else if (ev.equals(vista.ms_salir)){
            vista.dispose();
            c_login.mostrar();
        }else if (ev.equals(vista.mp_categoria)){
            v_principal.ADescritorio.add(vc);
            vc.setVisible(true);
        }else if (ev.equals(vista.mp_productopiso)){
            v_principal.ADescritorio.add(vtp);              
            vtp.setVisible(true);
        }else if (ev.equals(vista.mv_clientes)){
            v_principal.ADescritorio.add(vcli);
            vcli.setVisible(true);
        }else if (ev.equals(vista.mv_nuevaVenta)){
            v_principal.ADescritorio.add(vcp);
            vcp.txtcodigoVendedor.setText(vista.lblcod.getText());
            vcp.setVisible(true);
        }else if (ev.equals(vista.mr_ingresoapiso)){
            v_principal.ADescritorio.add(vpp);
            vpp.txtcodEmpleado.setText(vista.lblcod.getText());
            vpp.setVisible(true);
        }else if (ev.equals(vista.mr_detalleIngreso)){
            v_principal.ADescritorio.add(vdi);
            vdi.lblcodi.setText(vista.lblcod.getText());
            vdi.setVisible(true);
            //area proveedores
        }else if (ev.equals(vista.ma_proveedor)){
            v_principal.ADescritorio.add(vpro);
            //v.lblcodi.setText(vista.lblcod.getText());
            vpro.setVisible(true);
        }
        
        
        
    }

    
    
///mr_detalleIngreso
    
}

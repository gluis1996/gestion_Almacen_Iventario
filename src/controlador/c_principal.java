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
    private vi_listaCompra vlc = new vi_listaCompra();
    private vi_tabla_ProductoPiso vtp = new vi_tabla_ProductoPiso();
    private vi_detalleIngreso vdi = new vi_detalleIngreso();
    //proveedor
    private vi_proveedores vpro = new vi_proveedores();
    private vi_ingresoAlmacen via = new vi_ingresoAlmacen();
    //ingreso almacen
    private vi_tabla_productoAlmacen vta = new vi_tabla_productoAlmacen();
    
    
    
    public c_principal(v_principal vista) {
        this.vista = vista;
        //area empleado
        this.vista.boton_empleado.addActionListener(this);
        this.vista.me_nuevoEmpleado.addActionListener(this);
        //area venta
        this.vista.mv_clientes.addActionListener(this);
        this.vista.mv_nuevaVenta.addActionListener(this);
        this.vista.boton_nueva_Venta.addActionListener(this);
        this.vista.mrv_resumenVenta.addActionListener(this);
        //area producto
        this.vista.mp_productoAlmacen.addActionListener(this);
        this.vista.mp_categoria.addActionListener(this);
        this.vista.mp_productopiso.addActionListener(this);
        this.vista.tb_productoPiso.addActionListener(this);
        //area almacen 
        this.vista.ma_proveedor.addActionListener(this);
        this.vista.ma_ingresarAlmacen.addActionListener(this);
        this.vista.tb_ingresoAlmacen.addActionListener(this);
        //area reposicion
        this.vista.mr_ingresoapiso.addActionListener(this);
        this.vista.mr_detalleIngreso.addActionListener(this);
        
        //salir 
        this.vista.ms_salir.addActionListener(this);
        
           
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();
        //area empleado
        if (ev.equals(vista.boton_empleado)){
            v_principal.ADescritorio.add(ve);
            ve.setVisible(true);             
        }else if (ev.equals(vista.me_nuevoEmpleado)){
            v_principal.ADescritorio.add(ve);
            ve.setVisible(true);  
        }
        //area Venta
        else if (ev.equals(vista.mv_clientes)){
            v_principal.ADescritorio.add(vcli);
            vcli.setVisible(true);
        }else if (ev.equals(vista.mv_nuevaVenta)){
            v_principal.ADescritorio.add(vcp);
            vcp.txtcodigoVendedor.setText(vista.lblcod.getText());
            vcp.setVisible(true);
        }else if (ev.equals(vista.boton_nueva_Venta)){
            v_principal.ADescritorio.add(vcp);
            vcp.txtcodigoVendedor.setText(vista.lblcod.getText());
            vcp.setVisible(true);
        }else if (ev.equals(vista.mrv_resumenVenta)){
            v_principal.ADescritorio.add(vlc);
            vlc.lblcodv.setText(vista.lblcod.getText());
            vlc.setVisible(true);
        }
        //area producto
        else if (ev.equals(vista.mp_productoAlmacen)){
            v_principal.ADescritorio.add(vta);            
            vta.setVisible(true);
        }else if (ev.equals(vista.mp_productopiso)){
            v_principal.ADescritorio.add(vtp);              
            vtp.setVisible(true);
        }else if (ev.equals(vista.mp_categoria)){
            v_principal.ADescritorio.add(vc);
            vc.setVisible(true);
        }else if (ev.equals(vista.tb_productoPiso)){
            v_principal.ADescritorio.add(vtp);              
            vtp.setVisible(true);
        }
        
        //area almacen tb_ingresoAlmacen
        
        else if (ev.equals(vista.ma_ingresarAlmacen)){
            v_principal.ADescritorio.add(via);
            via.LBLidEmpleado.setText(vista.lblcod.getText());
            via.setVisible(true);
        }else if (ev.equals(vista.ma_proveedor)){
            v_principal.ADescritorio.add(vpro);
            //v.lblcodi.setText(vista.lblcod.getText());
            vpro.setVisible(true);
        }else if (ev.equals(vista.tb_ingresoAlmacen)){
            v_principal.ADescritorio.add(via);
            via.LBLidEmpleado.setText(vista.lblcod.getText());
            via.setVisible(true);
        }
        
        //area reposicion
        else if (ev.equals(vista.mr_ingresoapiso)){
            v_principal.ADescritorio.add(vpp);
            vpp.txtcodEmpleado.setText(vista.lblcod.getText());
            vpp.setVisible(true);
        }else if (ev.equals(vista.mr_detalleIngreso)){
            v_principal.ADescritorio.add(vdi);
            vdi.lblcodi.setText(vista.lblcod.getText());
            vdi.setVisible(true);
            //area proveedores
        }
        //Salir
        else if (ev.equals(vista.ms_salir)){
            vista.dispose();
            paraElBotonSAlir();
            c_login.mostrar();
        }
    }
    void paraElBotonSAlir(){
    ve.dispose();
    vc.dispose();
    vtp.dispose();
    vcli.dispose();
    vcp.dispose();
    vpp.dispose();
    vdi.dispose();
    vpro.dispose();
    via.dispose();
    vta.dispose();
    }
}

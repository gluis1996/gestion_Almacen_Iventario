package controlador;

import vistav.v_login;
import vistav.v_principal;
import vistav.v_DashJobs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.m_login;
import modelo.m_loginDAO;

public class c_login implements ActionListener {

    private static v_login vista;
    private m_loginDAO ld = new m_loginDAO();
    private v_principal vp = new v_principal();
    private v_DashJobs vd = new v_DashJobs();
    private m_login l = new m_login();
    static  String rol = "";
    static String user ;
    static String pass ;
    static String id ;

    public c_login(v_login vista) {
        this.vista = vista;
        this.vista.boton_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();

        if (ev.equals(vista.boton_login)) {
            ingresar();
        }
    }

    public void ingresar() {
         user = vista.txtusuario.getText();
         pass = vista.txtpass.getText();
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "digite usuario o contraseña ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<m_login> lista;
            String rol = "";
            lista = ld.lo(user, pass);
            for (int i = 0; i < lista.size(); i++) {
                rol = lista.get(i).getRol();
                user = lista.get(i).getUsuario();
                id = lista.get(i).getIdemp();
            }
            
            if (lista.size() > 0) {
                if (rol.equalsIgnoreCase("Administrador")) {
                    vista.dispose();
                    vp.setVisible(true);
                    mostrarAdministrador();
                    vp.lblcod.setText(id);
                    vp.lbluser.setText(user);
                } else if (rol.equalsIgnoreCase("Vendedor")) {
                    vista.dispose();
                    vp.setVisible(true);
                    mostrarintenvendedor();
                    vp.lblcod.setText(id);
                    vp.lbluser.setText(user);
                    JOptionPane.showMessageDialog(null, "Bienvenido al Vendedor", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else if (rol.equalsIgnoreCase("Reponedor")) {
                    vista.dispose();
                    vp.setVisible(true);
                    mostrarintenReponedor();
                    vp.lblcod.setText(id);
                    vp.lbluser.setText(user);
                    JOptionPane.showMessageDialog(null, "Bienvenido al Reponedor", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else if (rol.equalsIgnoreCase("Almacenero")) {
                    vista.dispose();
                    vp.setVisible(true);
                    mostrarintenAlmacenero();
                    vp.lblcod.setText(id);
                    vp.lbluser.setText(user);
                    JOptionPane.showMessageDialog(null, "Bienvenido al Reponedor", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Acceso Denegado", "Denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public static void mostrar() {
        vista.setVisible(true);
    }
    
    
    public static void ocultar() {
        vista.setVisible(false);
    }
    
    
    public void mostrarAdministrador (){
        vp.m_ventas.setVisible(true);
        vp.m_producto.setVisible(true);
        vp.m_sesion.setVisible(true);
        vp.m_empleados.setVisible(true);
        vp.m_repocicion.setVisible(true);
        vp.m_resumenVentas.setVisible(true);
        vp.m_almacen.setVisible(true);
        //botones
        vp.boton_nueva_Venta.setVisible(true);
        vp.boton_empleado.setVisible(true);
        vp.tb_ingresoAlmacen.setVisible(true);
        vp.tb_productoAlmacen.setVisible(true);
        vp.tb_productoPiso.setVisible(true);
        vp.tb_productosMASvendidos.setVisible(true);
        vp.tb_reportes.setVisible(true);    
    }
    
    
    public void mostrarintenvendedor() {
        vp.m_ventas.setVisible(true);
        vp.m_producto.setVisible(true);
        vp.m_sesion.setVisible(true);
        vp.m_empleados.setVisible(false);
        vp.m_repocicion.setVisible(false);
        vp.m_resumenVentas.setVisible(false);
        vp.m_almacen.setVisible(false);
        //botones
        vp.boton_nueva_Venta.setVisible(true);
        vp.boton_empleado.setVisible(false);
        vp.tb_ingresoAlmacen.setVisible(false);
        vp.tb_productoAlmacen.setVisible(true);
        vp.tb_productoPiso.setVisible(true);
        vp.tb_productosMASvendidos.setVisible(false);
        vp.tb_reportes.setVisible(false);
        vp.lblcod.setVisible(true);
        
    }
    
    
    public void mostrarintenReponedor() {
        vp.m_ventas.setVisible(false);
        vp.m_producto.setVisible(true);
        vp.m_sesion.setVisible(true);
        vp.m_empleados.setVisible(false);
        vp.m_repocicion.setVisible(true);
        vp.m_resumenVentas.setVisible(false);
        vp.m_almacen.setVisible(false);
        //botones
        vp.boton_nueva_Venta.setVisible(false);
        vp.boton_empleado.setVisible(false);
        vp.tb_ingresoAlmacen.setVisible(false);
        vp.tb_productoAlmacen.setVisible(true);
        vp.tb_productoPiso.setVisible(true);
        vp.tb_productosMASvendidos.setVisible(false);
        vp.tb_reportes.setVisible(false);
        vp.lblcod.setVisible(true);
    }
    
    
    public void mostrarintenAlmacenero() {
        vp.m_ventas.setVisible(false);
        vp.m_producto.setVisible(true);
        vp.m_sesion.setVisible(true);
        vp.m_empleados.setVisible(false);
        vp.m_repocicion.setVisible(false);
        vp.m_resumenVentas.setVisible(false);
        vp.m_almacen.setVisible(true);
        //botones
        vp.boton_nueva_Venta.setVisible(false);
        vp.boton_empleado.setVisible(false);
        vp.tb_ingresoAlmacen.setVisible(true);
        vp.tb_productoAlmacen.setVisible(true);
        vp.tb_productoPiso.setVisible(true);
        vp.tb_productosMASvendidos.setVisible(false);
        vp.tb_reportes.setVisible(false);
        vp.lblcod.setVisible(true);
    }
    
        
}

package controlador;

import vistav.v_DashJobs;
import vistav.v_login;
import controlador.c_login;
import VentanasInternasJob.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class c_dashjobs implements ActionListener {

    private v_DashJobs vista;
    private t_Proveedor tp = new t_Proveedor();
    private v_login vl = new v_login();

    public c_dashjobs(v_DashJobs vista) {
        this.vista = vista;
        this.vista.m_proveedor.addActionListener(this);
        this.vista.m_salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ev = e.getSource();
        if (ev.equals(vista.m_proveedor)) {
            JOptionPane.showMessageDialog(null, "proveedor");
        } else if (ev.equals(vista.m_salir)) {
            vista.dispose();
            c_login.mostrar();
        }

    }

}

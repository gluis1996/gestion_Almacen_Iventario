/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.vi_proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Conexion;
import modelo.m_proveedor;
import modelo.m_proveedorDAO;

/**
 *
 * @author LUIS
 */
public class c_proveedor implements ActionListener {

    private m_proveedor prov = new m_proveedor();
    private m_proveedorDAO provDAO = new m_proveedorDAO();
    public vi_proveedores vista;
    DefaultTableModel modelo = new DefaultTableModel();

    public c_proveedor(vi_proveedores vista) {
        this.vista = vista;
        provDAO.mostrar(vista.Tables);
        this.vista.btnREGISTRAR_PROVEEDOR.addActionListener(this);
        this.vista.btnMODIFICAR_PROVEEDOR.addActionListener(this);
        this.vista.btnELIMINAR_PROVEEDOR.addActionListener(this);
        this.vista.boton_cargar.addActionListener(this);
        this.vista.boton_buscar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnREGISTRAR_PROVEEDOR) {
            ingresarproveedor();
            limpiar();
        } else if (e.getSource() == vista.btnMODIFICAR_PROVEEDOR) {
            actualizar();
            limpiar();
        } else if (e.getSource() == vista.btnELIMINAR_PROVEEDOR) {
            provDAO.eliminar(vista.txtIDPROVEEDOR.getText());            
            provDAO.mostrar(vista.Tables);
            limpiar();
        } else if (e.getSource() == vista.boton_cargar) {
            cargar();
        } else if (e.getSource() == vista.boton_buscar) {
            String c = provDAO.buscarProveedor(vista.txtIDPROVEEDOR.getText());
            vista.txtRAZONSOCIAL.setText(c);
        }
    }

    public void ingresarproveedor() {
        prov.setId_proveedor(vista.txtIDPROVEEDOR.getText());
        prov.setRazon_social(vista.txtRAZONSOCIAL.getText());
        prov.setDireccion(vista.txtDIRECCION.getText());
        prov.setCorreo(vista.txtCORREO.getText());
        prov.setContacto(vista.txtCONTACTO.getText());
        prov.setContacto_comercial(vista.txtCONTACTOCOMERCIAL.getText());
        int contador = 0;

        if (vista.txtIDPROVEEDOR.getText().isEmpty()
                || vista.txtRAZONSOCIAL.getText().isEmpty()
                || vista.txtDIRECCION.getText().isEmpty()
                || vista.txtCORREO.getText().isEmpty()
                || vista.txtCONTACTO.getText().isEmpty()
                || vista.txtCONTACTOCOMERCIAL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios...");
        } else {

            try {
                ResultSet rs = Conexion.consulta("Select count(Razon_Social) from proveedor where Razon_Social='" + vista.txtRAZONSOCIAL + "'");
                try {
                    while (rs.next()) {
                        contador = rs.getInt(1);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error en el contador" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
                if (contador == 1) {
                    JOptionPane.showMessageDialog(null, "Ya exite este producto ", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    provDAO.registrar(prov);
                    provDAO.mostrar(vista.Tables);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "UPss PAso algo con el registro " + e);
            }

        }
    }

    public void generarcodigo() {
        m_proveedorDAO fun = new m_proveedorDAO();
        DecimalFormat df = new DecimalFormat("00000");
        String c = ("P" + String.valueOf(df.format(fun.generarCodigo())));
        vista.txtIDPROVEEDOR.setText(c);
    }

    public void actualizar() {
        prov.setId_proveedor(vista.txtIDPROVEEDOR.getText());
        prov.setRazon_social(vista.txtRAZONSOCIAL.getText());
        prov.setDireccion(vista.txtDIRECCION.getText());
        prov.setCorreo(vista.txtCORREO.getText());
        prov.setContacto(vista.txtCONTACTO.getText());
        prov.setContacto_comercial(vista.txtCONTACTOCOMERCIAL.getText());
        int contador = 0;
        if (vista.txtIDPROVEEDOR.getText().isEmpty()
                || vista.txtRAZONSOCIAL.getText().isEmpty()
                || vista.txtDIRECCION.getText().isEmpty()
                || vista.txtCORREO.getText().isEmpty()
                || vista.txtCONTACTO.getText().isEmpty()
                || vista.txtCONTACTOCOMERCIAL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios...");
        } else {
            int r = JOptionPane.showConfirmDialog(null, "Desea actualizar", "atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (r == 0) {
                provDAO.modificar(prov);
                provDAO.mostrar(vista.Tables);
                JOptionPane.showMessageDialog(null, "Actualziado proveedor");
            }

        }

    }

    public void cargar() {
        int fila = vista.Tables.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "sin datos");
        } else {
            String codigo = (String) vista.Tables.getValueAt(fila, 0);
            String Razon_social = (String) vista.Tables.getValueAt(fila, 1);
            String Direccion = (String) vista.Tables.getValueAt(fila, 2);
            String Correo = (String) vista.Tables.getValueAt(fila, 3);
            String Contacto = (String) vista.Tables.getValueAt(fila, 4);
            String Contacto_comercial = (String) vista.Tables.getValueAt(fila, 5);

            vista.txtIDPROVEEDOR.setText(codigo);
            vista.txtRAZONSOCIAL.setText(Razon_social);
            vista.txtDIRECCION.setText(Direccion);
            vista.txtCORREO.setText(Correo);
            vista.txtCONTACTO.setText(Contacto);
            vista.txtCONTACTOCOMERCIAL.setText(Contacto_comercial);
        }

    }

    void limpiar() {
        vista.txtIDPROVEEDOR.setText("");
        vista.txtRAZONSOCIAL.setText("");
        vista.txtDIRECCION.setText("");
        vista.txtCORREO.setText("");
        vista.txtCONTACTO.setText("");
        vista.txtCONTACTOCOMERCIAL.setText("");
    }

}

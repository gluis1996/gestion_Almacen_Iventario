package controlador;

import Vistas_InternasAdmin.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class c_tablaCliente implements ActionListener {

    private vi_tablaCliente vista;
    static String codigoC;
    static String nombre;

    public c_tablaCliente(vi_tablaCliente vista) {
        this.vista = vista;
        MostrarDatos();
        this.vista.boton_buscar.addActionListener(this);
        this.vista.boton_cargar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.boton_buscar) {
            buscar(vista.txtbuscar.getText());
        } else if (e.getSource() == vista.boton_cargar) {
            //JOptionPane.showMessageDialog(null, "ld");
            cargarCliente();
            vista.dispose();
        }
    }

    public void MostrarDatos() {
        DefaultTableModel modelo;
        String cabecera[] = {"ID", "TIPO DOCUMENTO", "DOCUMENTO", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "EMAIL", "NACIMIENTO", "ESTADO C", "GENERO"};
        modelo = new DefaultTableModel(null, cabecera);
        vista.tabla.setModel(modelo);
        modelo.setRowCount(0);
        ResultSet rs = Conexion.consulta("SELECT * FROM cliente;");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                modelo.addRow(v);
                vista.tabla.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en carga clientes a la tabla " + e);
        }
    }

    public void buscar(String co) {
        DefaultTableModel modelo;
        String cabecera[] = {"ID", "TIPO DOCUMENTO", "DOCUMENTO", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "EMAIL", "NACIMIENTO", "ESTADO C", "GENERO"};
        modelo = new DefaultTableModel(null, cabecera);
        vista.tabla.setModel(modelo);
        modelo.setRowCount(0);
        String consulta = "SELECT * from cliente where idCliente = '" + co + "' or docuemnto = '" + co + "'";
        ResultSet rs = Conexion.consulta(consulta);
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                modelo.addRow(v);
                vista.tabla.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en Buscar Cliente " + e);
        }

    }

    public void cargarCliente() {
        vi_Cliente c = new vi_Cliente();
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "sin datos");
        } else {
            codigoC = (String) vista.tabla.getValueAt(fila, 0);
            nombre = (String) vista.tabla.getValueAt(fila, 2);
            String doc = (String) vista.tabla.getValueAt(fila, 2);
            String nombre = (String) vista.tabla.getValueAt(fila, 3);
            String apellido = (String) vista.tabla.getValueAt(fila, 4);
            String direccion = (String) vista.tabla.getValueAt(fila, 5);
            String telefono = (String) vista.tabla.getValueAt(fila, 6);
            String email = (String) vista.tabla.getValueAt(fila, 7);
            String fnacimiento = (String) vista.tabla.getValueAt(fila, 8);
            String estadoC = (String) vista.tabla.getValueAt(fila, 9);
            String genero = (String) vista.tabla.getValueAt(fila, 10);

            c.txtCodigo.setText(codigoC);
            c.txtDocumento.setText(doc);
            c.txtNombre.setText(nombre);
            c.txtApellido.setText(apellido);
            c.txtDireccion.setText(direccion);
            c.txtTelefono.setText(telefono);
            c.txtEmail.setText(email);
            c.txtFechaNacimiento.setText(fnacimiento);
            
        }

    }
}

package controlador;

import vistav.v_principal;
import Vistas_InternasAdmin.vi_Cliente;
import Vistas_InternasAdmin.vi_tablaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DecimalFormat;
import modelo.*;

public class c_cliente implements ActionListener {

    private vi_Cliente vista;

    //private vi_tablaCliente tc = new vi_tablaCliente();
    public c_cliente() {
    }

    public c_cliente(vi_Cliente vista) {
        this.vista = vista;
        this.vista.boton_registrar.addActionListener(this);
        this.vista.boton_nuevo.addActionListener(this);
        this.vista.boton_actualizar.addActionListener(this);
        this.vista.boton_verlista.addActionListener(this);
        this.vista.boton_buscar.addActionListener(this);
        this.vista.boton_eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(vista.boton_registrar)) {
            ingresar();
            limpiar();
        } else if (o.equals(vista.boton_nuevo)) {
            generarcodigo();
        } else if (o.equals(vista.boton_actualizar)) {
            Actualizar();
            limpiar();
        } else if (o.equals(vista.boton_verlista)) {
            vi_tablaCliente tc = new vi_tablaCliente();
            vistav.v_principal.ADescritorio.add(tc);
            tc.setVisible(true);
        } else if (o.equals(vista.boton_buscar)) {
            Buscar();

        } else if (o.equals(vista.boton_eliminar)) {
            eliminar();
            limpiar();

        }

    }

    public void ingresar() {
        try {
            m_cliente m = new m_cliente();
            m_clienteDAO cdao = new m_clienteDAO();
            int contador = 0;

            m.setIdCliente(vista.txtCodigo.getText());
            m.setTipoDocumento(vista.cbxTdocumento.getSelectedItem().toString());
            m.setDocuemnto(vista.txtDocumento.getText());
            m.setNombre(vista.txtNombre.getText());
            m.setApellido(vista.txtApellido.getText());
            m.setDireccion(vista.txtDireccion.getText());
            m.setTelefono(vista.txtTelefono.getText());
            m.setEmail(vista.txtEmail.getText());
            m.setFechaNacimiento(vista.txtFechaNacimiento.getText());
            m.setEstadoCivil(vista.cbxEstado.getSelectedItem().toString());
            m.setGenero(vista.cbxGenero.getSelectedItem().toString());

            if (vista.txtCodigo.getText().isEmpty()
                    || vista.cbxTdocumento.getSelectedItem().toString().isEmpty()
                    || vista.txtDocumento.getText().isEmpty()
                    || vista.txtNombre.getText().isEmpty()
                    || vista.txtApellido.getText().isEmpty()
                    || vista.txtDireccion.getText().isEmpty()
                    || vista.txtTelefono.getText().isEmpty()
                    || vista.txtEmail.getText().isEmpty()
                    || vista.txtFechaNacimiento.getText().isEmpty()
                    || vista.cbxEstado.getSelectedItem().toString().isEmpty()
                    || vista.cbxGenero.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos");
            } else {
                try {
                    ResultSet rs = Conexion.consulta("Select count(docuemnto) from cliente where docuemnto = '" + vista.txtDocumento.getText() + "'");
                    try {
                        while (rs.next()) {
                            contador = rs.getInt(1);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    if (contador >= 1) {
                        JOptionPane.showMessageDialog(null, "el cliente existe");
                    } else {
                        cdao.ingresar(m);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error en al BD " + e);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "upp un erro en cliente " + e);
        }

    }

    public void Actualizar() {
        try {
            m_cliente m = new m_cliente();
            m_clienteDAO cdao = new m_clienteDAO();
            int contador = 0;

            m.setIdCliente(vista.txtCodigo.getText());
            m.setTipoDocumento(vista.cbxTdocumento.getSelectedItem().toString());
            m.setDocuemnto(vista.txtDocumento.getText());
            m.setNombre(vista.txtNombre.getText());
            m.setApellido(vista.txtApellido.getText());
            m.setDireccion(vista.txtDireccion.getText());
            m.setTelefono(vista.txtTelefono.getText());
            m.setEmail(vista.txtEmail.getText());
            m.setFechaNacimiento(vista.txtFechaNacimiento.getText());
            m.setEstadoCivil(vista.cbxEstado.getSelectedItem().toString());
            m.setGenero(vista.cbxGenero.getSelectedItem().toString());

            if (vista.txtCodigo.getText().isEmpty()
                    || vista.cbxTdocumento.getSelectedItem().toString().isEmpty()
                    || vista.txtDocumento.getText().isEmpty()
                    || vista.txtNombre.getText().isEmpty()
                    || vista.txtApellido.getText().isEmpty()
                    || vista.txtDireccion.getText().isEmpty()
                    || vista.txtTelefono.getText().isEmpty()
                    || vista.txtEmail.getText().isEmpty()
                    || vista.txtFechaNacimiento.getText().isEmpty()
                    || vista.cbxEstado.getSelectedItem().toString().isEmpty()
                    || vista.cbxGenero.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos");
            } else {
                cdao.Actualizar(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "upp un erro en cliente " + e);
        }

    }

    public void generarcodigo() {
        m_clienteDAO fun = new m_clienteDAO();
        DecimalFormat df = new DecimalFormat("0000");
        String c = ("CL" + String.valueOf(df.format(fun.generarCodigo())));
        vista.txtCodigo.setText(c);
    }

    public void Buscar() {
        String consulta = "SELECT * from cliente where idCliente ='" + vista.txtCodigo.getText() + "' or docuemnto = '" + vista.txtDocumento.getText() + "'";
        ResultSet rs = Conexion.consulta(consulta);
        try {
            while (rs.next()) {
                vista.txtDocumento.setText(rs.getString(3));
                vista.txtNombre.setText(rs.getString(4));
                vista.txtApellido.setText(rs.getString(5));
                vista.txtDireccion.setText(rs.getString(6));
                vista.txtTelefono.setText(rs.getString(7));
                vista.txtEmail.setText(rs.getString(8));
                vista.txtFechaNacimiento.setText(rs.getString(9));
                if (rs.getString(10).equals("S")) {
                    vista.cbxEstado.setSelectedIndex(1);
                } else if (rs.getString(10).equals("C")) {
                    vista.cbxEstado.setSelectedIndex(2);
                }

                if (rs.getString(11).equals("M")) {
                    vista.cbxGenero.setSelectedIndex(1);
                } else if (rs.getString(11).equals("F")) {
                    vista.cbxGenero.setSelectedIndex(2);
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Busqueda");
        }

    }

    public void eliminar() {
        m_cliente m = new m_cliente();
        m_clienteDAO md = new m_clienteDAO();
        m.setIdCliente(vista.txtCodigo.getText());
        md.EliminarCliente(m);
    }

    public void limpiar() {

        vista.txtCodigo.setText("");
        vista.cbxTdocumento.setSelectedIndex(0);
        vista.txtDocumento.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtDireccion.setText("");
        vista.txtTelefono.setText("");
        vista.txtEmail.setText("");
        vista.txtFechaNacimiento.setText("");
        vista.cbxEstado.setSelectedIndex(0);
        vista.cbxGenero.setSelectedIndex(0);
    }
}

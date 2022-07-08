package controlador;

import Vistas_InternasAdmin.vi_empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import modelo.*;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class c_empleado implements ActionListener {

    private vi_empleado vista;
    private m_empleadoDAO edao = new m_empleadoDAO();
    private m_empleado e;
    private ButtonGroup brt = new ButtonGroup();
    private String codigoRoles;
    private ResultSet rs;
    int contador;

    public c_empleado(vi_empleado vista) {
        this.vista = vista;
        agruparBotones();
        edao.cargarRolEmpleado(vista.CBX_roles);
        this.vista.boton_Nuevo.addActionListener(this);
        this.vista.BTN_MostrarEmpleado.addActionListener(this);
        this.vista.BTN_Registrar.addActionListener(this);
        this.vista.BTN_Cargar.addActionListener(this);
        this.vista.boton_Eliminar.addActionListener(this);
        this.vista.boton_mostrar_usuario.addActionListener(this);
        this.vista.CBX_roles.addActionListener(this);
        this.vista.boton_actualizar.addActionListener(this);
    }

    void agruparBotones() {
        brt.add(vista.rb_Activo);
        brt.add(vista.rb_Inactivo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ev = e.getSource();
        if (ev.equals(vista.boton_Nuevo)) {
            generarcodigo();
        } else if (ev.equals(vista.BTN_MostrarEmpleado)) {
            edao = new m_empleadoDAO();
            edao.llenarEnTablaEmpleado(vista.tabla1);
        } else if (ev.equals(vista.BTN_Registrar)) {
            RegistrarEmpleado();
        } else if (ev.equals(vista.BTN_Cargar)) {
            cargaratabla();
        } else if (ev.equals(vista.boton_Eliminar)) {
            eliminar();
            cargaratabla();
        } else if (ev.equals(vista.boton_mostrar_usuario)) {
            edao = new m_empleadoDAO();
            edao.llenarTablaUsuario(vista.tabla1);
        } else if (ev.equals(vista.CBX_roles)) {
            cb_ObtenerCodRoles();
        } else if (ev.equals(vista.boton_actualizar)) {
            actualizar();
        }

    }

    public void generarcodigo() {
        m_empleadoDAO fun = new m_empleadoDAO();
        DecimalFormat df = new DecimalFormat("00000");
        String c = ("E" + String.valueOf(df.format(fun.generarCodigo())));
        vista.txtCodigo.setText(c);
    }

    public void RegistrarEmpleado() {
        try {
            e = new m_empleado();
            edao = new m_empleadoDAO();
            e.setCodigo(vista.txtCodigo.getText());
            e.setTipodocumento(vista.cbxTdocument.getSelectedItem().toString());
            e.setNumerodocumento(vista.txtNdocumento.getText());
            e.setNombre(vista.txtNombre.getText());
            e.setApellido(vista.txtApellido.getText());
            e.setNacionalidad(vista.txtNacionalidad.getText());
            e.setGenero(vista.cbxGenero.getSelectedItem().toString());
            try {
                e.setEdad(Integer.parseInt(vista.txtEdad.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Diguite un numero valido " + e);
                vista.txtEdad.requestFocus();
            }
            e.setDistrito(vista.txtDistrito.getText());
            e.setRol(Integer.parseInt(codigoRoles));
            if (vista.rb_Activo.isSelected()) {
                e.setEstado("A");
            }
            if (vista.rb_Inactivo.isSelected()) {
                e.setEstado("I");
            }

            if (vista.cbxTdocument.getSelectedItem().toString().isEmpty()
                    || vista.txtNdocumento.getText().isEmpty()
                    || vista.txtNombre.getText().isEmpty()
                    || vista.txtApellido.getText().isEmpty()
                    || vista.txtNacionalidad.getText().isEmpty()
                    || vista.txtEdad.getText().isEmpty()
                    || vista.cbxGenero.getSelectedItem().toString().isEmpty()
                    || vista.txtDistrito.getText().isEmpty()
                    || vista.CBX_roles.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Verifique el Campo de Documento");
                vista.txtNdocumento.setText("");
                vista.txtNdocumento.requestFocus();
            } else {
                try {
                    rs = Conexion.consulta("select COUNT(numeroDocumento) from Empleado where numeroDocumento = '" + vista.txtNdocumento.getText() + "'");
                    try {
                        while (rs.next()) {
                            contador = rs.getInt(1);
                        }
                    } catch (SQLException ed) {
                        System.out.println(ed);
                    }
                    if (contador >= 1) {
                        JOptionPane.showMessageDialog(null, "El Usuario Existe");
                    } else {
                        edao.InsertarEmpleado(e);
                        JOptionPane.showMessageDialog(null, "Registrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        edao.llenarEnTablaEmpleado(vista.tabla1);
                        limpiar();
                    }
                } catch (Exception ed) {
                    JOptionPane.showMessageDialog(null, "UPss PAso algo con el registro" + "\n" + ed);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void actualizar() {
        try {
            e = new m_empleado();
            edao = new m_empleadoDAO();
            e.setCodigo(vista.txtCodigo.getText());
            e.setNumerodocumento(vista.txtNdocumento.getText());
            e.setNombre(vista.txtNombre.getText());
            e.setApellido(vista.txtApellido.getText());
            e.setNacionalidad(vista.txtNacionalidad.getText());            
            try {
                e.setEdad(Integer.parseInt(vista.txtEdad.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Diguite un numero valido " + e);
                vista.txtEdad.requestFocus();
            }
            e.setDistrito(vista.txtDistrito.getText());
            e.setRol(Integer.parseInt(codigoRoles));
            if (vista.rb_Activo.isSelected()) {
                e.setEstado("A");
            }
            if (vista.rb_Inactivo.isSelected()) {
                e.setEstado("I");
            }

            if ( vista.txtNdocumento.getText().isEmpty()
                    || vista.txtNombre.getText().isEmpty()
                    || vista.txtApellido.getText().isEmpty()
                    || vista.txtNacionalidad.getText().isEmpty()
                    || vista.txtEdad.getText().isEmpty()
                    || vista.txtDistrito.getText().isEmpty()
                    || vista.CBX_roles.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Verifique el Campo de Documento");
                vista.txtNdocumento.setText("");
                vista.txtNdocumento.requestFocus();
            } else {
                edao.actualziarEmpleado(e);
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Actualizar " + e);
        }

    }

    void limpiar() {
        vista.cbxTdocument.setSelectedIndex(0);
        vista.txtNdocumento.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtNacionalidad.setText("");
        vista.txtEdad.setText("");
        vista.cbxGenero.setSelectedIndex(0);
        vista.txtDistrito.setText("");
        vista.CBX_roles.setSelectedIndex(0);
        vista.txtNdocumento.requestFocus();

    }

    public void cargaratabla() {
        
        int fila = vista.tabla1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "sin datos");
        } else {
            String codigo = (String) vista.tabla1.getValueAt(fila, 0);
            String n = (String) vista.tabla1.getValueAt(fila, 2);
            String nom = (String) vista.tabla1.getValueAt(fila, 3);
            String ape = (String) vista.tabla1.getValueAt(fila, 4);
            String nac = (String) vista.tabla1.getValueAt(fila, 5);
            int eda = (int) vista.tabla1.getValueAt(fila, 6);
            String est = (String) vista.tabla1.getValueAt(fila, 9);
            int rol = (int) vista.tabla1.getValueAt(fila, 10);

            vista.txtCodigo.setText(codigo);
            vista.txtNdocumento.setText(n);
            vista.txtNombre.setText(nom);
            vista.txtApellido.setText(ape);
            vista.txtNacionalidad.setText(nac);
            vista.txtEdad.setText(String.valueOf(eda));
            switch (est) {
                case "A":
                    vista.rb_Activo.setSelected(true);
                    break;
                case "I":
                    vista.rb_Inactivo.setSelected(true);
                    break;
                default:
                    vista.rb_Activo.setSelected(false);
                    break;
            }
            
            
        }

    }

    public void eliminar() {
        try {
            e = new m_empleado();
            edao = new m_empleadoDAO();
            if (!vista.txtCodigo.getText().equals(""));
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea Eliminar ", "Peligro", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (confirmacion == 0) {
                e.setCodigo(vista.txtCodigo.getText());
                edao.eliminar(e);
                JOptionPane.showMessageDialog(null, "Exito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "UPPsERROR " + e);
        }

    }

    public void cargarCategorias() {
        vista.CBX_roles.removeAllItems();
        edao.cargarRolEmpleado(vista.CBX_roles);
    }

    public void cb_ObtenerCodRoles() {
        String linea = vista.CBX_roles.getSelectedItem().toString();
        String[] split = linea.split(" - ");
        codigoRoles = split[0];
        System.out.println(codigoRoles);
    }
}

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
    private m_empleadoDAO edao;
    private m_empleado e;
    private ButtonGroup brt = new ButtonGroup();
    
    private ResultSet rs;
    int contador;

    public c_empleado(vi_empleado vista) {
        this.vista = vista;
        agruparBotones();
        this.vista.boton_Nuevo.addActionListener(this);
        this.vista.BTN_MostrarEmpleado.addActionListener(this);
        this.vista.BTN_Registrar.addActionListener(this);
        this.vista.BTN_Cargar.addActionListener(this);
        this.vista.boton_Eliminar.addActionListener(this);
        this.vista.boton_mostrar_usuario.addActionListener(this);
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
            edao.llenarEnTabla(vista.tabla1);
        } else if (ev.equals(vista.BTN_Registrar)) {
            RegistrarEmpleado();
        } else if (ev.equals(vista.BTN_Cargar)) {
            cargaratabla();
        } else if (ev.equals(vista.boton_Eliminar)) {
            eliminar();
            cargaratabla();
        }else if (ev.equals(vista.boton_mostrar_usuario)){
            edao = new m_empleadoDAO();
            edao.llenarTablaUsuario(vista.tabla1);
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
            e.setRol(vista.CBX_roles.getSelectedItem().toString());
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
                    || vista.txtNacionalidad.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                    || vista.cbxGenero.getSelectedItem().toString().isEmpty() || vista.txtDistrito.getText().isEmpty()
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
                        edao.llenarEnTabla(vista.tabla1);
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
            vista.txtCodigo.setText(codigo);
        }
    }

    public void eliminar() {
        try {
        e = new m_empleado();
        edao = new m_empleadoDAO();
        if (!vista.txtCodigo.getText().equals(""));
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea Eliminar ", "Peligro", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
            if (confirmacion == 0){
            e.setCodigo(vista.txtCodigo.getText());
            edao.eliminar(e);
            JOptionPane.showMessageDialog(null, "Exito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "UPPsERROR "+ e);
        }

    }

}

package controlador;

import Vistas_InternasAdmin.vi_productoPiso;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import vistav.v_login;
import vistav.v_principal;

public class c_productoPiso implements ActionListener {

    private vi_productoPiso vista;
    private m_productoPisoDAO mp = new m_productoPisoDAO();
    private m_detalleReponedorDAO mdrd = new m_detalleReponedorDAO();
    private m_productoAlmacenDAO fun = new m_productoAlmacenDAO();
    private String codigocategoria;
    private DefaultTableModel modelo;
    private m_loginDAO l = new m_loginDAO();
    private m_login ml = new m_login();
    static int acumulador;

    public c_productoPiso(vi_productoPiso vista) {
        this.vista = vista;
        vista.txtcodEmpleado.setText(c_login.id);
        //desabiliar();
        this.mp.cargarcategoria(vista.cbxCategoria);
        this.vista.boton_guardar.addActionListener(this);
        this.vista.cbxCategoria.addActionListener(this);
        this.vista.boton_mostrar.addActionListener(this);
        this.vista.boton_cargar.addActionListener(this);
        this.vista.boton_actualizar.addActionListener(this);
        this.vista.boton_salir.addActionListener(this);
        this.vista.boton_suma.addActionListener(this);
        this.vista.boton_buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(vista.boton_guardar)) {
            registrar();
        } else if (o.equals(vista.cbxCategoria)) {
            cb_codigocategoria();
        } else if (o.equals(vista.boton_mostrar)) {
            mp.llenarEnTabla(vista.tabla);
        } else if (o.equals(vista.boton_cargar)) {
            cargartabla();
        } else if (o.equals(vista.boton_actualizar)) {
            actualizarProducto();
        } else if (o.equals(vista.boton_salir)) {
            cargarCategorias();
        } else if (o.equals(vista.boton_suma)) {
            int a = Integer.parseInt(vista.txtstockActual.getText()) + Integer.parseInt(vista.txtingreso.getText());
            vista.txtnuevoStock.setText(String.valueOf(a));
        } else if (o.equals(vista.boton_buscar)){
            buscar();
        }

    }

    public void registrar() {
        m_productoPiso p = new m_productoPiso();
         m_detalleReponedor d = new m_detalleReponedor();
         int c = Integer.parseInt(vista.txtingreso.getText());
        int contador = 0;
        p.setCodigo(vista.txtcodigo.getText());
        p.setDescripcion(vista.txtdescripcion.getText());
        p.setCategoria(Integer.parseInt(codigocategoria));
        d.setIdEmpleado(vista.txtcodEmpleado.getText());
        d.setIdProducto(vista.txtcodigo.getText());
        d.setDetalle(vista.txtobs.getText());
        try {
            if (Integer.parseInt(vista.txtingreso.getText()) >= 1) {
                p.setCantidad(Integer.parseInt(vista.txtingreso.getText()));
                d.setCantidadRegistrada(c);
                vista.txtstockActual.requestFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "verifuqe que sea un numero positivo");
        }
        p.setPrecioUnitario(Double.parseDouble(vista.txtprecioUni.getText()));
        p.setLimiteStock(Integer.parseInt(vista.txtLimiteStock.getText()));

        if (vista.txtcodigo.getText().isEmpty() || vista.txtdescripcion.getText().isEmpty()
                || vista.cbxCategoria.getSelectedItem().equals("seleccionar") || vista.txtstockActual.getText().isEmpty()
                || vista.txtprecioUni.getText().isEmpty() || vista.txtLimiteStock.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Verifique los datos");

        } else {
            try {
                ResultSet rs = Conexion.consulta("Select count(descripcion) from producto where descripcion = '" + vista.txtdescripcion + "'");
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
                    mp.ingresar(p);
                    mdrd.ingresaDetalleReponedor(d);
                    fun.disminuir(vista.txtcodigo.getText(), Integer.parseInt(vista.txtingreso.getText()));
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "UPss PAso algo con el registro " + e);
            }

        }

    }
    

    
    public void cb_codigocategoria() {
        String linea = vista.cbxCategoria.getSelectedItem().toString();
        String[] split = linea.split(" - ");
        codigocategoria = split[0];
        System.out.println(codigocategoria);
    }

    public void actualizarProducto() {
        m_productoPiso p = new m_productoPiso();
        m_detalleReponedor d = new m_detalleReponedor();
        int contador = 0;
        int c = Integer.parseInt(vista.txtingreso.getText());
        acumulador = acumulador + c;
        d.setIdEmpleado(vista.txtcodEmpleado.getText());
        d.setIdProducto(vista.txtcodigo.getText());
        d.setDetalle(vista.txtobs.getText());
        p.setCodigo(vista.txtcodigo.getText());
        try {
            if (Integer.parseInt(vista.txtstockActual.getText()) >= 0) {
                p.setCantidad(acumulador);
                d.setCantidadRegistrada(c);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "verifuqe que sea un numero positivo");
        }
        p.setPrecioUnitario(Double.parseDouble(vista.txtprecioUni.getText()));
        p.setLimiteStock(Integer.parseInt(vista.txtLimiteStock.getText()));
        int resul = JOptionPane.showConfirmDialog(null, "Desea Actualziar", "Atencion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (resul == 0) {
            mp.actualizar(p);
            fun.disminuir(vista.txtcodigo.getText(), c);
            mdrd.ingresaDetalleReponedor(d);
            limpiar();
        }

    }

    public void cargartabla() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "sin datos");
        } else {
            String codigo = (String) vista.tabla.getValueAt(fila, 0);
            String descripcion = (String) vista.tabla.getValueAt(fila, 1);
            String categoria = (String) vista.tabla.getValueAt(fila, 2);
            acumulador = (int) vista.tabla.getValueAt(fila, 3);
            double precio = (double) vista.tabla.getValueAt(fila, 4);
            int limi = (int) vista.tabla.getValueAt(fila, 5);

            vista.txtcodigo.setText(codigo);
            vista.txtdescripcion.setText(descripcion);
            vista.cbxCategoria.setSelectedIndex(0);
            vista.txtstockActual.setText(String.valueOf(acumulador));
            vista.txtprecioUni.setText(String.valueOf(precio));
            vista.txtLimiteStock.setText(String.valueOf(limi));
            System.out.println(acumulador);
        }
    }

    public void cargarCategorias() {
        vista.cbxCategoria.removeAllItems();
        mp.cargarcategoria(vista.cbxCategoria);
    }

    public void limpiar() {
        vista.txtcodigo.setText("");
        vista.txtdescripcion.setText("");
        vista.cbxCategoria.setSelectedIndex(0);
        vista.txtstockActual.setText("");
        vista.txtprecioUni.setText("");
        vista.txtLimiteStock.setText("");
        vista.txtdescripcion.requestFocus();

    }

    public void buscar() {
        String consulta = "call sp_buscarProdutoAlmacen ('"+vista.txtcodigo.getText()+"')";

        ResultSet rs = Conexion.consulta(consulta);
        try {
            while (rs.next()) {
                vista.txtcodigo.setText(rs.getString(1));
                vista.txtdescripcion.setText(rs.getString(2));                
                vista.cbxCategoria.setSelectedIndex(rs.getInt(4));
                vista.txtstockActual.setText(String.valueOf(rs.getInt(7)));
                vista.txtprecioUni.setText(String.valueOf(rs.getDouble(8)));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erroe en el query");
        }

    }

}

package controlador;

import Vistas_InternasAdmin.vi_compra;
import Vistas_InternasAdmin.vi_tablaCliente;
import Vistas_InternasAdmin.vi_tabla_ProductoPiso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.m_compra;
import modelo.m_compraDAO;
import modelo.m_detalleCompra;
import modelo.m_detalleCompraDAO;
import modelo.m_productoPisoDAO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;
import vistav.v_principal;

public class c_compra implements ActionListener {

    private Connection conn = new Conexion().getConexion();
    private vi_compra vista;
    m_compraDAO md = new m_compraDAO();
    m_detalleCompraDAO fun = new m_detalleCompraDAO();

    DefaultTableModel modelo;
    Connection cn;

    public c_compra(vi_compra vista) {
        this.vista = vista;
        mostrar();
        buscarVendedor();
        this.vista.boton_buscarProducto.addActionListener(this);
        this.vista.boton_añadir.addActionListener(this);
        this.vista.cbxTipoDePago.addActionListener(this);
        this.vista.boton_eliminar.addActionListener(this);
        this.vista.boton_buscarCliente.addActionListener(this);
        this.vista.boton_buscarVendedor.addActionListener(this);
        this.vista.boton_salir.addActionListener(this);
        this.vista.boton_guardar.addActionListener(this);
        this.vista.boton_nuevo.addActionListener(this);
        this.vista.boton_mostrar.addActionListener(this);
        this.vista.boton_mostrarCliente.addActionListener(this);
        this.vista.boton_imprimir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o.equals(vista.boton_buscarProducto)) {
            vi_tabla_ProductoPiso fun1 = new vi_tabla_ProductoPiso();
            v_principal.ADescritorio.add(fun1);
            fun1.setVisible(true);
            /*if (vista.txtIdproducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese codigo del produco");
            } else {
                buscarproducto();
            }*/
        } else if (o.equals(vista.boton_añadir)) {
            botonAgregar();
        } else if (o.equals(vista.cbxTipoDePago)) {
            comboTipoDoc();
        } else if (o.equals(vista.boton_eliminar)) {
            removerProducto();
        } else if (o.equals(vista.boton_buscarCliente)) {
            vi_tablaCliente fun2 = new vi_tablaCliente();
            v_principal.ADescritorio.add(fun2);
            fun2.setVisible(true);

            /*if (vista.txtCodigoCliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese haber ingresado DNI o CODIGO del Cliente");
            } else {
                buscarCliente();
            }*/
        } else if (o.equals(vista.boton_buscarVendedor)) {
            if (vista.txtcodigoVendedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese haber ingresado DNI o CODIGO del Vendedor");
            } else {
                buscarVendedor();
            }
        } else if (o.equals(vista.boton_salir)) {
            vista.dispose();
        } else if (o.equals(vista.boton_guardar)) {
            GuardarVenta();
        } else if (o.equals(vista.boton_nuevo)) {
            GenerarCorrelativoCompra();
        } else if (o.equals(vista.boton_mostrar)) {
            vista.txtIdproducto.setText(c_tabla_ProductoPiso.c);
            vista.txtNombrePro.setText(c_tabla_ProductoPiso.nombre);
            vista.txtprecio.setText(String.valueOf(c_tabla_ProductoPiso.precio));
            vista.txtStock.setText(String.valueOf(c_tabla_ProductoPiso.cantidad));
        } else if (o.equals(vista.boton_mostrarCliente)) {
            vista.txtCodigoCliente.setText(c_tablaCliente.codigoC);
            vista.txtNombreCliente.setText(c_tablaCliente.nombre);
        } else if (o.equals(vista.boton_imprimir)) {
            paraElBotonImprimir();
        }
    }

    void mostrar() {
        try {
            DefaultTableModel modelo;
            modelo = fun.mostrar();
            vista.tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void GenerarCorrelativoCompra() {
        DecimalFormat df = new DecimalFormat("00000000");
        vista.txtidCompra.setText(df.format(md.idCompra()));
    }

    void GenerarCorrelativoBoleta() {
        DecimalFormat df = new DecimalFormat("00000000");

        vista.txtCodigoVenta.setText("B001 - " + df.format(md.GenerarCompraventeBoleta()));
    }

    void GenerarCorrelativoFactura() {
        DecimalFormat df = new DecimalFormat("00000000");
        vista.txtCodigoVenta.setText("F001 - " + df.format(md.GenerarCompraventeFactura()));
    }

    public void GuardarCompra() {
        m_compra p = new m_compra();
        int contador = 0;
        p.setIdCompra(vista.txtidCompra.getText());
        p.setIdEmpleado(vista.txtcodigoVendedor.getText());
        p.setIdCliente(vista.txtCodigoCliente.getText());
        p.setTotal(Double.parseDouble(vista.txtSubtotal.getText()));
        p.setComprovante(vista.cbxTipoDePago.getSelectedItem().toString());
        p.setNumero_comprovante(vista.txtCodigoVenta.getText());
        p.setCantidadTotal(Integer.parseInt(vista.txtcantidadTotalProductos.getText()));
        if (vista.txtidCompra.getText().isEmpty()
                || vista.txtnombreVendedor.getText().isEmpty()
                || vista.cbxTipoDePago.getSelectedItem().equals("seleccionar")
                || vista.txtCodigoCliente.getText().isEmpty()
                || vista.txtSubtotal.getText().isEmpty()
                || vista.txtCodigoVenta.getText().isEmpty()
                || vista.txtcantidadTotalProductos.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Verifique los datos");
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Desea Regsitrar", "Informacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (i == 0) {
                md.ingresarCompra(p);
            }
        }
    }

    public void GuardarDetalleCompra() {

        //String id = md.idCompra();
        m_detalleCompra mdc = new m_detalleCompra();
        m_detalleCompraDAO mdcD = new m_detalleCompraDAO();
        m_productoPisoDAO mpd = new m_productoPisoDAO();
        //int idc = Integer.parseInt(id);

        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            mdc.setIdCompra(vista.txtidCompra.getText());
            mdc.setIdproducto(vista.tabla.getValueAt(i, 0).toString());
            mdc.setCantidad(Integer.parseInt(vista.tabla.getValueAt(i, 1).toString()));
            mdc.setPrecio_Unitario(Double.parseDouble(vista.tabla.getValueAt(i, 2).toString()));
            mdc.setSub_total(Double.parseDouble(vista.tabla.getValueAt(i, 3).toString()));
            mdcD.ingresarCompra(mdc);
            mpd.disminuir(vista.tabla.getValueAt(i, 0).toString(), Integer.parseInt(vista.tabla.getValueAt(i, 1).toString()));
        }

    }

    public void AgregarProducto() {
        Double subtotal;
        modelo = (DefaultTableModel) vista.tabla.getModel();

        int cantidad = Integer.parseInt(vista.txtCantidad.getText());
        Double precioP = Double.parseDouble(vista.txtprecio.getText());

        subtotal = cantidad * precioP;

        ArrayList lista = new ArrayList();
        lista.add(vista.txtIdproducto.getText());
        lista.add(vista.txtCantidad.getText());
        lista.add(vista.txtprecio.getText());
        lista.add(subtotal);

        Object[] o = new Object[4];
        o[0] = lista.get(0);
        o[1] = lista.get(1);
        o[2] = lista.get(2);
        o[3] = lista.get(3);
        modelo.addRow(o);
        vista.tabla.setModel(modelo);
        CalcularTotal();
    }

    public void CalcularTotal() {

        try {
            Double subtotal = 0.0;
            Double totalPagar = 0.0;
            int cant = 0;
            String d1, d2;

            for (int i = 0; i < vista.tabla.getRowCount(); i++) {
                int cantidad = Integer.parseInt(vista.tabla.getValueAt(i, 1).toString());
                Double preciU = Double.parseDouble(vista.tabla.getValueAt(i, 2).toString());
                cant = cant + cantidad;
                subtotal = subtotal + (cantidad * preciU);
                //totalPagar = totalPagar + subtotal;
            }

            d1 = String.valueOf(subtotal);
            d2 = String.valueOf(cant);
            vista.txtcantidadTotalProductos.setText(d2);
            vista.txtSubtotal.setText(d1);
            //vista.txtTotalPagar.setText(String.valueOf(totalPagar));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void limpiarproducto() {
        vista.txtIdproducto.setText("");
        vista.txtNombrePro.setText("");
        vista.txtprecio.setText("");
        vista.txtStock.setText("");
        vista.txtCantidad.setText("");
    }

    public void limpiarFormulario() {
        vista.txtCodigoCliente.setText("");
        vista.txtNombreCliente.setText("");
        //vista.cbxTipoDePago.setSelectedIndex(0);
        vista.txtCodigoVenta.setText("");
        vista.txtSubtotal.setText("");
        vista.txtcantidadTotalProductos.setText("");
        vista.txtSubtotal.setText("");
        vista.txtidCompra.setText("");
        limpiarproducto();
        limpiarTabla();
    }

    public void limpiarTabla() {
        try {
            for (int i = 0; i < vista.tabla.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Limpiar tabla " + e);
        }
    }

    public void removerProducto() {
        DefaultTableModel compra = (DefaultTableModel) vista.tabla.getModel();
        int iten = vista.tabla.getSelectedRow();

        if (iten > 0) {
            compra.removeRow(iten);
            CalcularTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione una fila", "Atencion", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void buscarproducto() {
        String consulta = "call sp_bucarProducto ('" + vista.txtIdproducto.getText() + "')";
        try {
            CallableStatement ps = Conexion.getConexion().prepareCall(consulta);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    vista.txtNombrePro.setText(rs.getString(2));
                    vista.txtprecio.setText(String.valueOf(rs.getDouble(5)));
                    vista.txtStock.setText(String.valueOf(rs.getInt(4)));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error111 Busqueda" + e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cap err");
        }
    }

    public void botonAgregar() {
        if (vista.txtIdproducto.getText().isEmpty()
                || vista.txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "verfique que los campos de producto y cantidad esten llenas");

        } else {
            AgregarProducto();
            limpiarproducto();
        }

    }

    public void BotonQuitarProdcuto() {
    }

    public void comboTipoDoc() {
        int tipo = vista.cbxTipoDePago.getSelectedIndex();

        if (tipo == 0) {
            vista.lbl_tdoc.setText("DOCUMENTO DE COMPRA");
        }
        if (tipo == 1) {
            vista.lbl_tdoc.setText("BOLETA DE COMPRA");
            GenerarCorrelativoBoleta();
        }
        if (tipo == 2) {
            vista.lbl_tdoc.setText("FACTURA DE COMPRA");
            GenerarCorrelativoFactura();
        }
    }

    public void buscarCliente() {
        String consulta = "SELECT IdCliente , concat(nombre,' ',apellido) as nombre FROM `cliente` "
                + "WHERE IdCliente='" + vista.txtCodigoCliente.getText() + "' or docuemnto='" + vista.txtCodigoCliente.getText() + "'";
        try {
            CallableStatement ps = Conexion.getConexion().prepareCall(consulta);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    vista.txtCodigoCliente.setText(rs.getString(1));
                    vista.txtNombreCliente.setText(rs.getString(2));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error111 Busqueda" + e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cap err");
        }

    }

    public void buscarVendedor() {

        String consulta = "CALL sp_buscar_vendedor('" + vista.txtcodigoVendedor.getText() + "')";
        try {
            CallableStatement ps = Conexion.getConexion().prepareCall(consulta);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    vista.txtcodigoVendedor.setText(rs.getString(1));
                    vista.txtDocumentoVendedor.setText(rs.getString(2));
                    vista.txtnombreVendedor.setText(rs.getString(3));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error111 Busqueda" + e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cap err");
        }

    }

    public void GuardarVenta() {
        if (vista.txtcodigoVendedor.getText().isEmpty()
                || vista.txtCodigoCliente.getText().isEmpty()
                || vista.txtSubtotal.getText().isEmpty()
                || vista.cbxTipoDePago.getSelectedItem().equals("Selecionar")
                || vista.txtCodigoVenta.getText().isEmpty()
                || vista.txtcantidadTotalProductos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique los datos esten todos llenos");
        } else {
            GuardarCompra();
            GuardarDetalleCompra();
            limpiarFormulario();
        }
    }

    void paraElBotonImprimir() {

        String idc = vista.txtidCompra.getText();
        String tipoD = vista.cbxTipoDePago.getSelectedItem().toString();
        if (tipoD.equalsIgnoreCase("boleta")) {
            Map p = new HashMap();
            p.put("idCompra ", idc);

            JasperReport reporte;
            JasperPrint print;

            try {
                reporte = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/reporte/reportecompra2.jasper");
                print = JasperFillManager.fillReport(reporte, p, this.conn);
                JasperViewer vista = new JasperViewer(print, false);
                vista.setTitle("comprovante Venta");
                vista.setVisible(true);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error en mostrar comprobante " + e);
            }
        } else if (tipoD.equalsIgnoreCase("factura")) {
            Map p = new HashMap();
            p.put("idCompra ", idc);

            JasperReport reporte;
            JasperPrint print;

            try {
                reporte = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/reporte/reportecompra2.jasper");
                print = JasperFillManager.fillReport(reporte, p, this.conn);
                JasperViewer vista = new JasperViewer(print, false);
                vista.setTitle("comprovante Venta");
                vista.setVisible(true);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error en mostrar comprobante " + e);
            }
        
        }else {
        JOptionPane.showMessageDialog(null, "selecione una venta");
        }

    }
}

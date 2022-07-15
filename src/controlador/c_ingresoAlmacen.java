/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas_InternasAdmin.vi_ingresoAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import modelo.m_productoAlmacen;
import modelo.m_productoAlmacenDAO;
import modelo.m_proveedor;
import modelo.m_proveedorDAO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.m_detalleAlmacen;
import modelo.m_detalleAlmacenDAO;

/**
 *
 * @author LUIS
 */
public class c_ingresoAlmacen implements ActionListener {

    private vi_ingresoAlmacen vista;
    private m_proveedorDAO mp = new m_proveedorDAO();
    private String codigocategoria;
    private m_productoAlmacenDAO mpad = new m_productoAlmacenDAO();
    private m_detalleAlmacenDAO fun = new m_detalleAlmacenDAO();
    private DefaultTableModel modelo;
    private static int num;
    private static int acumulador;

    public c_ingresoAlmacen(vi_ingresoAlmacen vista) {
        this.vista = vista;
       
        mostrar();
        mpad.cargarcategoria(vista.cbxCategoria);
        this.vista.boton_buscar_proveedor.addActionListener(this);
        this.vista.boton_cargarCodigo_producto.addActionListener(this);
        this.vista.boton_registrar.addActionListener(this);
        this.vista.cbxCategoria.addActionListener(this);
        this.vista.boton_mostrar_todo.addActionListener(this);
        this.vista.boton_añadir.addActionListener(this);
        this.vista.boton_filtrar.addActionListener(this);
        this.vista.boton_cargar.addActionListener(this);
        this.vista.boton_actualisar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o.equals(vista.boton_buscar_proveedor)) {
            String c = mp.buscarProveedor(vista.txRUC.getText());
            vista.txtdescripcion.setText(c);
          
        } else if (o.equals(vista.boton_cargarCodigo_producto)) {
            generarcodigo();
        } else if (o.equals(vista.boton_registrar)) {
            if (vista.txtIdproducto.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.cbxCategoria.getSelectedItem().equals("Selecionar")
                    || vista.txtcantidadIngresada.getText().isEmpty()
                    || vista.txt_precioCompra.getText().isEmpty()
                    || vista.txtPrecioVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "verifique que todo los campos esten llenos");
            } else {
               registrar();
                DetalleigresoAlmacen0();
            }
        } else if (o.equals(vista.cbxCategoria)) {
            categoriasEnCBXcat();
        } else if (o.equals(vista.boton_mostrar_todo)) {
            mpad.llenarEnTabla(vista.tabla);
        } else if (o.equals(vista.boton_añadir)) {
             paraElBotonAñadir();

        } else if (o.equals(vista.boton_filtrar)) {
            if (vista.txtcantidadIngresada.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "verifique que tengas algun numero ingresado");
            } else {
                mpad.MPAmenores(vista.tabla, Integer.parseInt(vista.txtcantidadIngresada.getText()));
                
            }
        } else if (o.equals(vista.boton_cargar)) {
            if(vista.tabla.getRowCount()==-1){
             JOptionPane.showMessageDialog(null, "verifique que tengas algun datos la tabla");
            }else {
            CargarBM();
            }            
        } else if (o.equals(vista.boton_actualisar)) {
             if (vista.txtIdproducto.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.cbxCategoria.getSelectedItem().equals("Selecionar")
                    || vista.txtcantidadIngresada.getText().isEmpty()
                    || vista.txt_precioCompra.getText().isEmpty()
                    || vista.txtPrecioVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "verifique que todo los campos esten llenos");
            } else {
                actualizar();
            }
            
        }
    }

    void autoincrementoBA() {
        DecimalFormat df = new DecimalFormat("00000");
        num++;
        String c = ("P" + df.format(num));
        System.out.println(num);
        vista.txtIdproducto.setText(c);
    }

    public void generarcodigo() {
        m_productoAlmacenDAO fun = new m_productoAlmacenDAO();
        DecimalFormat df = new DecimalFormat("00000");
        num = fun.generarCodigo();
        String c = ("P" + String.valueOf(df.format(fun.generarCodigo())));
        System.out.println(num);
        vista.txtIdproducto.setText(c);
    }

    public void categoriasEnCBXcat() {
        String linea = vista.cbxCategoria.getSelectedItem().toString();
        String[] split = linea.split(" - ");
        codigocategoria = split[0];
        System.out.println(codigocategoria);
    }

    public void registrar() {
        m_productoAlmacen p = new m_productoAlmacen();
        m_productoAlmacenDAO pd = new m_productoAlmacenDAO();
        int contador = 0;
        p.setCodigo(vista.txtIdproducto.getText());
        p.setDescripcion(vista.txtnombrePro.getText());
        p.setCategoria(Integer.parseInt(codigocategoria));
        try {
            if (Integer.parseInt(vista.txtcantidadIngresada.getText()) >= 0) {
                p.setCantidad(Integer.parseInt(vista.txtcantidadIngresada.getText()));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "verifuqe que sea un numero positivo");
        }
        p.setPrecio_venta(Double.parseDouble(vista.txtPrecioVenta.getText()));
        if (vista.txtIdproducto.getText().isEmpty()
                || vista.txtnombrePro.getText().isEmpty()
                || vista.cbxCategoria.getSelectedItem().equals("seleccionar")
                || vista.txtcantidadIngresada.getText().isEmpty()
                || vista.txtPrecioVenta.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Verifique los datos");

        } else {
            try {
                ResultSet rs = Conexion.consulta("Select count(descripcion) from producto where descripcion = '" + vista.txtnombrePro + "'");
                try {
                    while (rs.next()) {
                        contador = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el contador" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }
                if (contador == 1) {
                    JOptionPane.showMessageDialog(null, "Ya exite este producto ", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    pd.IngresarproductoAlmacen(p);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "UPss PAso algo con el registro " + e);
            }
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

    public void AgregarProducto() {
        int c = 0;
        modelo = (DefaultTableModel) vista.tabla.getModel();
        vista.tabla.getModel();
        String ide = vi_ingresoAlmacen.LBLidEmpleado.getText();
        String ipo = vista.txtIdproducto.getText();
        String n = vista.txtnombrePro.getText();
        c = Integer.parseInt(codigocategoria);
        String ruc = vista.txRUC.getText();
        int cantidad = Integer.parseInt(vista.txtcantidadIngresada.getText());
        Double precioC = Double.parseDouble(vista.txt_precioCompra.getText());
        Double precioV = Double.parseDouble(vista.txtPrecioVenta.getText());

        ArrayList lista = new ArrayList();
        lista.add(ide);
        lista.add(ipo);
        lista.add(n);
        lista.add(c);
        lista.add(ruc);
        lista.add(cantidad);
        lista.add(precioC);
        lista.add(precioV);

        Object[] o = new Object[8];
        o[0] = lista.get(0);
        o[1] = lista.get(1);
        o[2] = lista.get(2);
        o[3] = lista.get(3);
        o[4] = lista.get(4);
        o[5] = lista.get(5);
        o[6] = lista.get(6);
        o[7] = lista.get(7);
        modelo.addRow(o);
        vista.tabla.setModel(modelo);
    }

    public void DetalleigresoAlmacen() {
        m_detalleAlmacen fun = new m_detalleAlmacen();
        m_detalleAlmacenDAO fun1 = new m_detalleAlmacenDAO();
        m_productoAlmacenDAO fun3 = new m_productoAlmacenDAO();
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            fun.setIdEmpleado(vista.tabla.getValueAt(i, 0).toString());
            fun.setIdproducto(vista.tabla.getValueAt(i, 1).toString());
            fun.setRUC(vista.tabla.getValueAt(i, 4).toString());
            fun.setCantidadIngresada(Integer.parseInt(vista.tabla.getValueAt(i, 5).toString()));
            fun.setPreico_compra(Double.parseDouble(vista.tabla.getValueAt(i, 6).toString()));
            fun1.ingresar(fun);
        }
    }

    public void DetalleigresoAlmacen0() {
        m_detalleAlmacen fun = new m_detalleAlmacen();
        m_detalleAlmacenDAO fun1 = new m_detalleAlmacenDAO();
        m_productoAlmacenDAO fun3 = new m_productoAlmacenDAO();

        fun.setIdEmpleado(vi_ingresoAlmacen.LBLidEmpleado.getText());
        fun.setIdproducto(vista.txtIdproducto.getText());
        fun.setRUC(vista.txRUC.getText());
        fun.setCantidadIngresada(Integer.parseInt(vista.txtcantidadIngresada.getText()));
        fun.setPreico_compra(Double.parseDouble(vista.txt_precioCompra.getText()));
        fun1.ingresar(fun);

    }



    public void CargarBM() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Sin datos TA");
            
            
        } else {
            String a = (String) vista.tabla.getValueAt(fila, 0);
            String b = (String) vista.tabla.getValueAt(fila, 1);
            int c = (int) vista.tabla.getValueAt(fila, 2);
            String d = (String) vista.tabla.getValueAt(fila, 3);
            String e = (String) vista.tabla.getValueAt(fila, 4);
            int f = (int) vista.tabla.getValueAt(fila, 5);
            double h = (double) vista.tabla.getValueAt(fila, 6);
            double i = (double) vista.tabla.getValueAt(fila, 7);

            vista.txtIdproducto.setText(a);
            vista.txtnombrePro.setText(b);
            vista.cbxCategoria.setSelectedIndex(c);
            vista.txRUC.setText(d);
            vista.txtdescripcion.setText(e);
            vista.txtcantidadIngresada.setText(String.valueOf(f));
            vista.txt_precioCompra.setText(String.valueOf(h));
            vista.txtPrecioVenta.setText(String.valueOf(i));
            acumulador = f;
            System.out.println(acumulador);
            
        }
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

        if (iten >= 0) {
            compra.removeRow(iten);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione una fila", "Atencion", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void buscarProductoAlmacen() {
        String consulta = "call sp_buscarProdutoAlmacen('" + vista.txtIdproducto.getText() + "')";
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(consulta);
            ResultSet rs = cs.executeQuery();
            try {
                while (rs.next()) {

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error en buscar " + e);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error en el query " + e);
        }

    }

    public void actualizar() {
        acumulador = acumulador + Integer.parseInt(vista.txtcantidadIngresada.getText());
        System.out.println(acumulador);
        m_productoAlmacen fun = new m_productoAlmacen();
        m_productoAlmacenDAO fun1 = new m_productoAlmacenDAO();
        fun.setCodigo(vista.txtIdproducto.getText());
        fun.setCantidad(acumulador);
        fun.setPrecio_venta(Double.parseDouble(vista.txtPrecioVenta.getText()));
        fun1.actualizar(fun);
        DetalleigresoAlmacen0();
        removerProducto();
        limipar();
    }

    public void limipar() {
        vista.txRUC.setText("");
        vista.txtdescripcion.setText("");
        vista.txtIdproducto.setText("");
        vista.txtnombrePro.setText("");
        vista.cbxCategoria.setSelectedIndex(0);
        vista.txtcantidadIngresada.setText("");
        vista.txt_precioCompra.setText("");
        vista.txtPrecioVenta.setText("");
    }

    void paraElBotonAñadir(){
    if (vista.txtIdproducto.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.txtnombrePro.getText().isEmpty()
                    || vista.cbxCategoria.getSelectedItem().equals("Selecionar")
                    || vista.txtcantidadIngresada.getText().isEmpty()
                    || vista.txt_precioCompra.getText().isEmpty()
                    || vista.txtPrecioVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "verifique que todo los campos esten llenos");
            } else {
                if (vista.tabla.getRowCount()==-1){
                vista.boton_registrar.setEnabled(false);
                }else{
                    vista.boton_registrar.setEnabled(true);
                 autoincrementoBA();
                AgregarProducto();
                limipar();
                }
               
            }
    }
}

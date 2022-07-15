/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas_InternasAdmin;
import controlador.c_productoPiso;
public class vi_productoPiso extends javax.swing.JInternalFrame {

    c_productoPiso cpp;
    
    public vi_productoPiso() {
        initComponents();
        cpp = new c_productoPiso(this);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtprecioUni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLimiteStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        boton_guardar = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        boton_cargar = new javax.swing.JButton();
        boton_mostrar = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        boton_suma = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtobs = new javax.swing.JTextField();
        txtcodEmpleado = new javax.swing.JTextField();
        txtstockActual = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtingreso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtnuevoStock = new javax.swing.JLabel();
        boton_buscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PRODUCTO PISO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Codigo :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, -1, -1));

        jLabel2.setText("Descripcion :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 52, -1, -1));

        jLabel3.setText("Categoria :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 170, -1));
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 394, -1));

        getContentPane().add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 240, -1));

        jLabel4.setText("Stock Actual :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, -1, -1));

        jLabel5.setText("Precio Unitario :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 136, -1, -1));
        getContentPane().add(txtprecioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 170, -1));

        jLabel6.setText("Limite Stock : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 167, -1, -1));
        getContentPane().add(txtLimiteStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 170, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 204, 720, 210));

        boton_guardar.setText("Guardar");
        getContentPane().add(boton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 100, -1));

        boton_actualizar.setText("Actualizar");
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 100, -1));

        boton_cargar.setText("Cargar");
        getContentPane().add(boton_cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 100, -1));

        boton_mostrar.setText("M. Tablas");
        getContentPane().add(boton_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 100, -1));

        boton_salir.setText("Refresh");
        getContentPane().add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 100, -1));

        jLabel7.setText("Cod Empleado :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        boton_suma.setText("+");
        getContentPane().add(boton_suma, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jLabel8.setText("obs :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));
        getContentPane().add(txtobs, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 220, -1));
        getContentPane().add(txtcodEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 10, 80, -1));

        txtstockActual.setText(".....");
        getContentPane().add(txtstockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel9.setText("Ingreso :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));
        getContentPane().add(txtingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 40, -1));

        jLabel10.setText("Nº");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        txtnuevoStock.setText(".....");
        getContentPane().add(txtnuevoStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        boton_buscar.setText("Buscar");
        getContentPane().add(boton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_actualizar;
    public javax.swing.JButton boton_buscar;
    public javax.swing.JButton boton_cargar;
    public javax.swing.JButton boton_guardar;
    public javax.swing.JButton boton_mostrar;
    public javax.swing.JButton boton_salir;
    public javax.swing.JButton boton_suma;
    public javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtLimiteStock;
    public javax.swing.JTextField txtcodEmpleado;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtingreso;
    public javax.swing.JLabel txtnuevoStock;
    public javax.swing.JTextField txtobs;
    public javax.swing.JTextField txtprecioUni;
    public javax.swing.JLabel txtstockActual;
    // End of variables declaration//GEN-END:variables
}

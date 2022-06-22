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
        txtstockActual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtprecioUni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLimiteStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        boton_guardar = new javax.swing.JButton();
        boton_nuevo = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Codigo :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, -1, -1));

        jLabel2.setText("Descripcion :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 52, -1, -1));

        jLabel3.setText("Categoria :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 21, 142, -1));
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 49, 394, -1));

        getContentPane().add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 77, 142, -1));

        jLabel4.setText("Stock Actual :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, -1, -1));
        getContentPane().add(txtstockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 105, 145, -1));

        jLabel5.setText("Precio Unitario :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 136, -1, -1));
        getContentPane().add(txtprecioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 133, 145, -1));

        jLabel6.setText("Limite Stock :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 167, -1, -1));
        getContentPane().add(txtLimiteStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 158, 146, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 197, 613, 214));

        boton_guardar.setText("Guardar");
        getContentPane().add(boton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 163, -1, -1));

        boton_nuevo.setText("nuevo");
        getContentPane().add(boton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_guardar;
    public javax.swing.JButton boton_nuevo;
    public javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField txtLimiteStock;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtprecioUni;
    public javax.swing.JTextField txtstockActual;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas_InternasAdmin;

import controlador.c_empleado;

public class vi_empleado extends javax.swing.JInternalFrame {

    c_empleado c;
    
    public vi_empleado() {
        initComponents();
        c= new c_empleado(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        cbxTdocument = new javax.swing.JComboBox<>();
        txtNdocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rb_Activo = new javax.swing.JRadioButton();
        rb_Inactivo = new javax.swing.JRadioButton();
        BTN_Registrar = new javax.swing.JButton();
        BTN_MostrarEmpleado = new javax.swing.JButton();
        BTN_Cargar = new javax.swing.JButton();
        boton_Nuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CBX_roles = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        cbxGenero = new javax.swing.JComboBox<>();
        boton_Eliminar = new javax.swing.JButton();
        boton_mostrar_usuario = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Empleado");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 200, -1));

        cbxTdocument.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Dni", "Carnet Extranjeria" }));
        jPanel1.add(cbxTdocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 200, -1));
        jPanel1.add(txtNdocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, -1));

        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtCodigo.setText("Codigo");
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 197, -1));

        jLabel3.setText("T. Documento");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setText("Nª Documento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 197, -1));

        txtNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 197, -1));

        jLabel6.setText("Apellido");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel7.setText("Nacionalidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel8.setText("Edad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 170, -1));
        jPanel1.add(txtDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 170, -1));

        jLabel9.setText("Genero");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel10.setText("Distrito");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel11.setText("Estado");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        rb_Activo.setText("Activo");
        jPanel1.add(rb_Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        rb_Inactivo.setText("Inactivo");
        jPanel1.add(rb_Inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        BTN_Registrar.setText("Registrar");
        BTN_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        BTN_MostrarEmpleado.setText("Mostrar Empleado");
        BTN_MostrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MostrarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_MostrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, -1));

        BTN_Cargar.setText("Cargar");
        BTN_Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CargarActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 80, -1));

        boton_Nuevo.setText("Nuevo");
        boton_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_NuevoActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel2.setText("Rol:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jPanel1.add(CBX_roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 170, -1));

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "F", "M" }));
        jPanel1.add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 170, -1));

        boton_Eliminar.setText("Eliminar");
        jPanel1.add(boton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        boton_mostrar_usuario.setText("Mostrar Usuarios");
        jPanel1.add(boton_mostrar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 110, -1));

        boton_actualizar.setText("Actualizar");
        jPanel1.add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked

        /*  if (tabla1.getSelectedRow() >= 0) {
            try {
                DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
                String codigo = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 0));
                String tipoDocumen = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 1));
                String nDocumento = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 2));
                String nombre = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 3));
                String apellido = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 4));
                String nacionalidad = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 5));
                String edad = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 6));
                String genero = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 7));
                String distrito = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 8));
                String estado = String.valueOf(modelo.getValueAt(tabla1.getSelectedRow(), 9));

                lblCod.setText(codigo);
                cbxTdocument.setSelectedItem(nombre);
                txtNdocumento.setText(nDocumento);
                txtNombre.setText(nombre);
                txtApellido.setText(apellido);
                txtNacionalidad.setText(nacionalidad);
                txtEdad.setText(edad);
                txtGenero.setText(genero);
                txtDistrito.setText(distrito);
                switch (estado) {
                    case "A":
                    rb_Activo.setSelected(true);
                    break;
                    case "I":
                    rb_Inactivo.setSelected(true);
                    break;
                    case "R":
                    rb_Retirado.setSelected(true);
                    break;
                    default:
                    rb_Activo.setSelected(false);
                    break;
                }

            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en el Jtable");
        }*/
    }//GEN-LAST:event_tabla1MouseClicked

    private void txtNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadActionPerformed

    private void BTN_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_RegistrarActionPerformed

        /*   String Tdocumento = cbxTdocument.getSelectedItem().toString();
        String numeroDoc = txtNdocumento.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String nacionalidad = txtNacionalidad.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String genero = txtGenero.getText();
        String distrito = txtDistrito.getText();
        String estado = null;

        if (rb_Activo.isSelected()) {
            estado = "A";
        }
        if (rb_Inactivo.isSelected()) {
            estado = "I";
        }
        if (rb_Retirado.isSelected()) {
            estado = "R";
        }

        if (txtNdocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique el Campo de Documento");
            txtNdocumento.setText("");
            txtNdocumento.requestFocus();
        } else {
            try {
                rs = Conexion.consulta("select COUNT(numeroDocumento) from Empleado where numeroDocumento = '" + txtNdocumento.getText() + "'");
                try {
                    while (rs.next()) {
                        con = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                if (con >= 1) {
                    JOptionPane.showMessageDialog(null, "El Usuario Existe");
                } else {
                    M_Insercion.sp_InsentarEmpleados(Tdocumento, numeroDoc, nombre, apellido, nacionalidad, edad, genero, distrito, estado);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "UPss PAso algo con el registro" + "\n" + e);
            }

        }
        */
    }//GEN-LAST:event_BTN_RegistrarActionPerformed

    private void BTN_MostrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MostrarEmpleadoActionPerformed

        //mm.MostrarModelo(tabla1);
    }//GEN-LAST:event_BTN_MostrarEmpleadoActionPerformed

    private void BTN_CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CargarActionPerformed

    }//GEN-LAST:event_BTN_CargarActionPerformed

    private void boton_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_NuevoActionPerformed

    }//GEN-LAST:event_boton_NuevoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_Cargar;
    public javax.swing.JButton BTN_MostrarEmpleado;
    public javax.swing.JButton BTN_Registrar;
    public javax.swing.JComboBox<String> CBX_roles;
    public javax.swing.JButton boton_Eliminar;
    public javax.swing.JButton boton_Nuevo;
    public javax.swing.JButton boton_actualizar;
    public javax.swing.JButton boton_mostrar_usuario;
    public javax.swing.JComboBox<String> cbxGenero;
    public javax.swing.JComboBox<String> cbxTdocument;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rb_Activo;
    public javax.swing.JRadioButton rb_Inactivo;
    public javax.swing.JTable tabla1;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JLabel txtCodigo;
    public javax.swing.JTextField txtDistrito;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNdocumento;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

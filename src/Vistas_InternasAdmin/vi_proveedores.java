
package Vistas_InternasAdmin;
import controlador.c_proveedor;
public class vi_proveedores extends javax.swing.JInternalFrame {
    c_proveedor cp;
    public vi_proveedores() {
        initComponents();
        cp = new c_proveedor(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIDPROVEEDOR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRAZONSOCIAL = new javax.swing.JTextField();
        txtDIRECCION = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnMODIFICAR_PROVEEDOR = new javax.swing.JButton();
        txtCORREO = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tables = new javax.swing.JTable();
        txtCONTACTO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCONTACTOCOMERCIAL = new javax.swing.JTextField();
        btnREGISTRAR_PROVEEDOR = new javax.swing.JButton();
        btnELIMINAR_PROVEEDOR = new javax.swing.JButton();
        boton_cargar = new javax.swing.JButton();
        boton_buscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nuevo Proveedor");

        jLabel3.setText("Razon Social");

        jLabel4.setText("Direccion");

        jLabel5.setText("Correo");

        btnMODIFICAR_PROVEEDOR.setText("Modificar Proveedor");
        btnMODIFICAR_PROVEEDOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMODIFICAR_PROVEEDORActionPerformed(evt);
            }
        });

        Tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Proveedor", "Razon Social", "Dirección", "Correo", "Contacto", "Contacto Comercial", "Fecha de Registro"
            }
        ));
        jScrollPane1.setViewportView(Tables);

        jLabel6.setText("Contacto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Proveedores");

        jLabel7.setText("Contacto Comercial");

        jLabel2.setText("ID_Proveedor");

        btnREGISTRAR_PROVEEDOR.setText("Registrar Proveedor");
        btnREGISTRAR_PROVEEDOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREGISTRAR_PROVEEDORActionPerformed(evt);
            }
        });

        btnELIMINAR_PROVEEDOR.setText("Eliminar Proveedor");
        btnELIMINAR_PROVEEDOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnELIMINAR_PROVEEDORActionPerformed(evt);
            }
        });

        boton_cargar.setText("cargar");

        boton_buscar.setText("buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(txtIDPROVEEDOR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(boton_buscar)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(84, 84, 84)
                .addComponent(txtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(txtRAZONSOCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel6)
                .addGap(81, 81, 81)
                .addComponent(txtCONTACTO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(50, 50, 50)
                .addComponent(txtDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addGap(24, 24, 24)
                .addComponent(txtCONTACTOCOMERCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnMODIFICAR_PROVEEDOR)
                .addGap(42, 42, 42)
                .addComponent(btnREGISTRAR_PROVEEDOR)
                .addGap(27, 27, 27)
                .addComponent(btnELIMINAR_PROVEEDOR))
            .addGroup(layout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(boton_cargar))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDPROVEEDOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_buscar)
                            .addComponent(jLabel5)
                            .addComponent(txtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtRAZONSOCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCONTACTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(txtDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCONTACTOCOMERCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMODIFICAR_PROVEEDOR)
                    .addComponent(btnREGISTRAR_PROVEEDOR)
                    .addComponent(btnELIMINAR_PROVEEDOR))
                .addGap(8, 8, 8)
                .addComponent(boton_cargar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMODIFICAR_PROVEEDORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMODIFICAR_PROVEEDORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMODIFICAR_PROVEEDORActionPerformed

    private void btnREGISTRAR_PROVEEDORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREGISTRAR_PROVEEDORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnREGISTRAR_PROVEEDORActionPerformed

    private void btnELIMINAR_PROVEEDORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnELIMINAR_PROVEEDORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnELIMINAR_PROVEEDORActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tables;
    public javax.swing.JButton boton_buscar;
    public javax.swing.JButton boton_cargar;
    public javax.swing.JButton btnELIMINAR_PROVEEDOR;
    public javax.swing.JButton btnMODIFICAR_PROVEEDOR;
    public javax.swing.JButton btnREGISTRAR_PROVEEDOR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtCONTACTO;
    public javax.swing.JTextField txtCONTACTOCOMERCIAL;
    public javax.swing.JTextField txtCORREO;
    public javax.swing.JTextField txtDIRECCION;
    public javax.swing.JTextField txtIDPROVEEDOR;
    public javax.swing.JTextField txtRAZONSOCIAL;
    // End of variables declaration//GEN-END:variables
}

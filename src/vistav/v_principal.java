/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistav;
import controlador.c_principal;
import java.awt.Frame;
public class v_principal extends javax.swing.JFrame {
    c_principal c;
    
    public v_principal() {
        initComponents();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        c= new c_principal(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ADescritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        tb_empleados = new javax.swing.JButton();
        tb_productosMASvendidos = new javax.swing.JButton();
        tb_reportes = new javax.swing.JButton();
        tb_nuevaVenta = new javax.swing.JButton();
        tb_productoPiso = new javax.swing.JButton();
        tb_productoAlmacen = new javax.swing.JButton();
        tb_entregas = new javax.swing.JButton();
        tb_ingresoAlmacen = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblcod = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_resumenVentas = new javax.swing.JMenu();
        mrv_resumenVenta = new javax.swing.JMenuItem();
        m_empleados = new javax.swing.JMenu();
        me_nuevoEmpleado = new javax.swing.JMenuItem();
        m_ventas = new javax.swing.JMenu();
        mv_nuevaVenta = new javax.swing.JMenuItem();
        mv_detalleVetas = new javax.swing.JMenuItem();
        mv_clientes = new javax.swing.JMenuItem();
        m_producto = new javax.swing.JMenu();
        mp_productoAlmacen = new javax.swing.JMenuItem();
        mp_productopiso = new javax.swing.JMenuItem();
        mp_categoria = new javax.swing.JMenuItem();
        m_almacen = new javax.swing.JMenu();
        ma_proveedor = new javax.swing.JMenuItem();
        ma_Entregas = new javax.swing.JMenuItem();
        ma_ingresarAlmacen = new javax.swing.JMenuItem();
        m_repocicion = new javax.swing.JMenu();
        mr_ingresoapiso = new javax.swing.JMenuItem();
        mr_detalleIngreso = new javax.swing.JMenuItem();
        m_sesion = new javax.swing.JMenu();
        ms_salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ADescritorioLayout = new javax.swing.GroupLayout(ADescritorio);
        ADescritorio.setLayout(ADescritorioLayout);
        ADescritorioLayout.setHorizontalGroup(
            ADescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ADescritorioLayout.setVerticalGroup(
            ADescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        tb_empleados.setText("Empleados");
        tb_empleados.setFocusable(false);
        tb_empleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_empleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_empleados);

        tb_productosMASvendidos.setText("Productos+Vendidos");
        tb_productosMASvendidos.setFocusable(false);
        tb_productosMASvendidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_productosMASvendidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_productosMASvendidos);

        tb_reportes.setText("Reportes");
        tb_reportes.setFocusable(false);
        tb_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_reportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_reportes);

        tb_nuevaVenta.setText("Nueva Venta");
        tb_nuevaVenta.setFocusable(false);
        tb_nuevaVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_nuevaVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_nuevaVenta);

        tb_productoPiso.setText("Producto Piso");
        tb_productoPiso.setFocusable(false);
        tb_productoPiso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_productoPiso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_productoPiso);

        tb_productoAlmacen.setText("Producto Almacen");
        tb_productoAlmacen.setFocusable(false);
        tb_productoAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_productoAlmacen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_productoAlmacen);

        tb_entregas.setText("Entregas");
        tb_entregas.setFocusable(false);
        tb_entregas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_entregas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_entregas);

        tb_ingresoAlmacen.setText("Ingresar Almacen");
        tb_ingresoAlmacen.setFocusable(false);
        tb_ingresoAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tb_ingresoAlmacen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tb_ingresoAlmacen);

        lblcod.setText("sesion");

        jLabel1.setText("ID");

        jLabel2.setText("User");

        lbluser.setText("user");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblcod)
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcod)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lbluser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        m_resumenVentas.setText("Resumen Ventas");

        mrv_resumenVenta.setText("Resumen Ventas");
        m_resumenVentas.add(mrv_resumenVenta);

        jMenuBar1.add(m_resumenVentas);

        m_empleados.setText("Nuevo Trabajador");
        m_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_empleadosMouseClicked(evt);
            }
        });
        m_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_empleadosActionPerformed(evt);
            }
        });

        me_nuevoEmpleado.setText("Nuevo Empleado");
        m_empleados.add(me_nuevoEmpleado);

        jMenuBar1.add(m_empleados);

        m_ventas.setText("Ventas");

        mv_nuevaVenta.setText("Nueva Venta");
        m_ventas.add(mv_nuevaVenta);

        mv_detalleVetas.setText("Detalle Ventas");
        m_ventas.add(mv_detalleVetas);

        mv_clientes.setText("Clientes");
        m_ventas.add(mv_clientes);

        jMenuBar1.add(m_ventas);

        m_producto.setText("Productos");

        mp_productoAlmacen.setText("Producto Almacen");
        m_producto.add(mp_productoAlmacen);

        mp_productopiso.setText("Producto Piso");
        m_producto.add(mp_productopiso);

        mp_categoria.setText("Categoria");
        m_producto.add(mp_categoria);

        jMenuBar1.add(m_producto);

        m_almacen.setText("Almacen");

        ma_proveedor.setText("Proveedor");
        m_almacen.add(ma_proveedor);

        ma_Entregas.setText("Entregas");
        ma_Entregas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ma_EntregasActionPerformed(evt);
            }
        });
        m_almacen.add(ma_Entregas);

        ma_ingresarAlmacen.setText("Ingresar Almacen");
        m_almacen.add(ma_ingresarAlmacen);

        jMenuBar1.add(m_almacen);

        m_repocicion.setText("Repocicion");

        mr_ingresoapiso.setText("Ingreso P. Piso");
        m_repocicion.add(mr_ingresoapiso);

        mr_detalleIngreso.setText("Detalle Ingresos");
        m_repocicion.add(mr_detalleIngreso);

        jMenuBar1.add(m_repocicion);

        m_sesion.setText("Sesion");
        m_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_sesionMouseClicked(evt);
            }
        });

        ms_salir.setText("Salir");
        m_sesion.add(ms_salir);

        jMenuBar1.add(m_sesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADescritorio)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADescritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_empleadosMouseClicked
       
    }//GEN-LAST:event_m_empleadosMouseClicked

    private void m_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_empleadosActionPerformed

    }//GEN-LAST:event_m_empleadosActionPerformed

    private void m_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_sesionMouseClicked
    
    }//GEN-LAST:event_m_sesionMouseClicked

    private void ma_EntregasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ma_EntregasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ma_EntregasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(v_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane ADescritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lblcod;
    public javax.swing.JLabel lbluser;
    public javax.swing.JMenu m_almacen;
    public javax.swing.JMenu m_empleados;
    public javax.swing.JMenu m_producto;
    public javax.swing.JMenu m_repocicion;
    public javax.swing.JMenu m_resumenVentas;
    public javax.swing.JMenu m_sesion;
    public javax.swing.JMenu m_ventas;
    public javax.swing.JMenuItem ma_Entregas;
    public javax.swing.JMenuItem ma_ingresarAlmacen;
    public javax.swing.JMenuItem ma_proveedor;
    public javax.swing.JMenuItem me_nuevoEmpleado;
    public javax.swing.JMenuItem mp_categoria;
    public javax.swing.JMenuItem mp_productoAlmacen;
    public javax.swing.JMenuItem mp_productopiso;
    public javax.swing.JMenuItem mr_detalleIngreso;
    public javax.swing.JMenuItem mr_ingresoapiso;
    public javax.swing.JMenuItem mrv_resumenVenta;
    public javax.swing.JMenuItem ms_salir;
    public javax.swing.JMenuItem mv_clientes;
    public javax.swing.JMenuItem mv_detalleVetas;
    public javax.swing.JMenuItem mv_nuevaVenta;
    public javax.swing.JButton tb_empleados;
    public javax.swing.JButton tb_entregas;
    public javax.swing.JButton tb_ingresoAlmacen;
    public javax.swing.JButton tb_nuevaVenta;
    public javax.swing.JButton tb_productoAlmacen;
    public javax.swing.JButton tb_productoPiso;
    public javax.swing.JButton tb_productosMASvendidos;
    public javax.swing.JButton tb_reportes;
    // End of variables declaration//GEN-END:variables
}

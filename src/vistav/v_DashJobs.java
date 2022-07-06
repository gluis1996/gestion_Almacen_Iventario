/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistav;

import java.awt.Frame;
import controlador.c_dashjobs;
public class v_DashJobs extends javax.swing.JFrame {
    
    c_dashjobs cj;
        
    public v_DashJobs() {
        initComponents();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        cj = new c_dashjobs(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_ventas = new javax.swing.JMenu();
        m_producto = new javax.swing.JMenu();
        m_productosPiso = new javax.swing.JMenuItem();
        m_productosAlmacen = new javax.swing.JMenuItem();
        m_reponedor = new javax.swing.JMenu();
        m_almacen = new javax.swing.JMenu();
        m_proveedor = new javax.swing.JMenuItem();
        m_sesion = new javax.swing.JMenu();
        j_menus = new javax.swing.JMenu();
        m_salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        m_ventas.setText("Ventas");
        m_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_ventasMouseClicked(evt);
            }
        });
        jMenuBar1.add(m_ventas);

        m_producto.setText("Productos");

        m_productosPiso.setText("Productos Piso");
        m_producto.add(m_productosPiso);

        m_productosAlmacen.setText("Productos Almacen");
        m_producto.add(m_productosAlmacen);

        jMenuBar1.add(m_producto);

        m_reponedor.setText("Reponedor");
        jMenuBar1.add(m_reponedor);

        m_almacen.setText("Almacenero");

        m_proveedor.setText("Prioveedores");
        m_almacen.add(m_proveedor);

        jMenuBar1.add(m_almacen);

        m_sesion.setText("sesion");
        m_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_sesionMouseClicked(evt);
            }
        });

        j_menus.setText("remane");
        m_sesion.add(j_menus);

        m_salir.setText("salir");
        m_sesion.add(m_salir);

        jMenuBar1.add(m_sesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_ventasMouseClicked

    }//GEN-LAST:event_m_ventasMouseClicked

    private void m_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_sesionMouseClicked

    }//GEN-LAST:event_m_sesionMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(v_DashJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_DashJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_DashJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_DashJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_DashJobs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu j_menus;
    public javax.swing.JMenu m_almacen;
    public javax.swing.JMenu m_producto;
    public javax.swing.JMenuItem m_productosAlmacen;
    public javax.swing.JMenuItem m_productosPiso;
    public javax.swing.JMenuItem m_proveedor;
    public javax.swing.JMenu m_reponedor;
    public javax.swing.JMenuItem m_salir;
    public javax.swing.JMenu m_sesion;
    public javax.swing.JMenu m_ventas;
    // End of variables declaration//GEN-END:variables
}

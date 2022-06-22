package controlador;

import Vistas_InternasAdmin.vi_productoPiso;
import java.awt.Component;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class c_productoPiso implements ActionListener {

    private vi_productoPiso vista;
    private m_productoPisoDAO mp = new m_productoPisoDAO();
    private String codigocategoria;

    public c_productoPiso(vi_productoPiso vista) {
        this.vista = vista;
        mp.cargarcategoria(vista.cbxCategoria);
        this.vista.boton_guardar.addActionListener(this);
        this.vista.boton_nuevo.addActionListener(this);
        this.vista.cbxCategoria.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(vista.boton_guardar)) {
            JOptionPane.showMessageDialog(null, "exito");
        } else if (o.equals(vista.boton_nuevo)) {
            generarcodigo();
        } else if (o.equals(vista.cbxCategoria)) {
            cb_codigocategoria();
        }

    }

    public void generarcodigo() {
        m_productoPisoDAO fun = new m_productoPisoDAO();
        DecimalFormat df = new DecimalFormat("00000");
        vista.txtcodigo.setText("P" + df.format(fun.generarCodigo()));
    }

    public void registrar() {
        m_productoPiso p = new m_productoPiso();        
        p.setCodigo(vista.txtcodigo.getText());
        p.setDescripcion(vista.txtdescripcion.getText());
        p.setCategoria(Integer.parseInt(codigocategoria));
        p.setCantidad(Integer.parseInt(vista.txtstockActual.getText()));
        p.setPrecioUnitario(Double.parseDouble(vista.txtprecioUni.getText()));
        p.setLimiteStock(Integer.parseInt(vista.txtLimiteStock.getText()));
        
        if (vista.txtcodigo.getText().isEmpty() || vista.txtdescripcion.getText().isEmpty() || 
                vista.cbxCategoria.getSelectedItem().equals("seleccionar")|| vista.txtstockActual.getText().isEmpty() ||
                vista.txtprecioUni.getText().isEmpty() || vista.txtLimiteStock.getText().isEmpty()){
            
                 JOptionPane.showMessageDialog(null, "Verifique los datos");
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public void cb_codigocategoria() {
        String linea = vista.cbxCategoria.getSelectedItem().toString();
        String[] split = linea.split(" - ");
        codigocategoria = split[0];
        System.out.println(codigocategoria);
    }

   
}

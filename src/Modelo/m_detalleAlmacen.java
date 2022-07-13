/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LUIS
 */
public class m_detalleAlmacen {
    private String idEmpleado;
    private String idproducto;
    private String RUC;
    private int cantidadIngresada;
    private double preico_compra;
    private String unidad_medida;

    public m_detalleAlmacen() {
    }

    public m_detalleAlmacen(String idEmpleado, String idproducto, String RUC, int cantidadIngresada, double preico_compra, String unidad_medida) {
        this.idEmpleado = idEmpleado;
        this.idproducto = idproducto;
        this.RUC = RUC;
        this.cantidadIngresada = cantidadIngresada;
        this.preico_compra = preico_compra;
        this.unidad_medida = unidad_medida;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public int getCantidadIngresada() {
        return cantidadIngresada;
    }

    public void setCantidadIngresada(int cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    public double getPreico_compra() {
        return preico_compra;
    }

    public void setPreico_compra(double preico_compra) {
        this.preico_compra = preico_compra;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
    
    
    
    
}

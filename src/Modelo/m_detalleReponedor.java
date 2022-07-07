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
public class m_detalleReponedor {
    private String idEmpleado;
    private String idProducto;
    private int cantidadRegistrada;
    private String Detalle;

    public m_detalleReponedor() {
    }
    
    
    public m_detalleReponedor(String idEmpleado, String idProducto, int cantidadRegistrada, String Detalle) {
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.cantidadRegistrada = cantidadRegistrada;
        this.Detalle = Detalle;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadRegistrada() {
        return cantidadRegistrada;
    }

    public void setCantidadRegistrada(int cantidadRegistrada) {
        this.cantidadRegistrada = cantidadRegistrada;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }
    
    
    
}

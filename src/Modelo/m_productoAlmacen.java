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
public class m_productoAlmacen extends m_producto{
    
    private double Precio_venta;
    private int Cantidad;

    public m_productoAlmacen() {
    }

    public m_productoAlmacen(double Precio_venta, int Cantidad, String codigo, String descripcion, int categoria) {
        super(codigo, descripcion, categoria);
        this.Precio_venta = Precio_venta;
        this.Cantidad = Cantidad;
    }

    public double getPrecio_venta() {
        return Precio_venta;
    }

    public void setPrecio_venta(double Precio_venta) {
        this.Precio_venta = Precio_venta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    }

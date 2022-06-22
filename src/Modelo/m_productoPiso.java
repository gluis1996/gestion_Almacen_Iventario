
package modelo;

public class m_productoPiso extends m_producto{
   private int cantidad;
   private double precioUnitario;
   private int limiteStock;

    public m_productoPiso() {
    }

    public m_productoPiso(int cantidad, double precioUnitario, int limiteStock, String codigo, String descripcion, int categoria) {
        super(codigo, descripcion, categoria);
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.limiteStock = limiteStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getLimiteStock() {
        return limiteStock;
    }

    public void setLimiteStock(int limiteStock) {
        this.limiteStock = limiteStock;
    }
   
   
   
}

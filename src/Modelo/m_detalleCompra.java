
package modelo;

public class m_detalleCompra {
    private String idCompra;
    private String Idproducto ;
    private int Cantidad;
    private Double Precio_Unitario;
    private Double sub_total;

    public m_detalleCompra() {
    }

    public m_detalleCompra(String idCompra, String Idproducto, int Cantidad, Double Precio_Unitario, Double sub_total) {
        this.idCompra = idCompra;
        this.Idproducto = Idproducto;
        this.Cantidad = Cantidad;
        this.Precio_Unitario = Precio_Unitario;
        this.sub_total = sub_total;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdproducto() {
        return Idproducto;
    }

    public void setIdproducto(String Idproducto) {
        this.Idproducto = Idproducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(Double Precio_Unitario) {
        this.Precio_Unitario = Precio_Unitario;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }
    
    
    
    
}


package modelo;

/**
 *
 * @author LUIS
 */
public class m_compra {
    private String idCompra;
    private String IdEmpleado ;
    private String IdCliente ;
    private String Fecha_Compra ;
    private double total;
    private String comprovante ;
    private String numero_comprovante ;
    private int cantidadTotal;

    public m_compra() {
    }

    public m_compra(String idCompra, String IdEmpleado, String IdCliente, String Fecha_Compra, double total, String comprovante, String numero_comprovante, int cantidadTotal) {
        this.idCompra = idCompra;
        this.IdEmpleado = IdEmpleado;
        this.IdCliente = IdCliente;
        this.Fecha_Compra = Fecha_Compra;
        this.total = total;
        this.comprovante = comprovante;
        this.numero_comprovante = numero_comprovante;
        this.cantidadTotal = cantidadTotal;
    }

   

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(String Fecha_Compra) {
        this.Fecha_Compra = Fecha_Compra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    public String getNumero_comprovante() {
        return numero_comprovante;
    }

    public void setNumero_comprovante(String numero_comprovante) {
        this.numero_comprovante = numero_comprovante;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

   
    
}

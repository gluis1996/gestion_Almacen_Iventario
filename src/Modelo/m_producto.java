
package modelo;

public class m_producto {
    private String codigo;
    private String descripcion;
    private int  categoria;

    public m_producto() {
    }

    public m_producto(String codigo, String descripcion, int categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
  
    
}

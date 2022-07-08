
package modelo;


public class m_proveedor {
    private String id_proveedor;
    private String razon_social;
    private String direccion;
    private String correo;
    private String contacto;
    private String contacto_comercial;
    private String fecha_registro;

    public m_proveedor() {
    }

    public m_proveedor(String id_proveedor, String razon_social, String direccion, String correo, String contacto, String contacto_comercial, String fecha_registro) {
        this.id_proveedor = id_proveedor;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.correo = correo;
        this.contacto = contacto;
        this.contacto_comercial = contacto_comercial;
        this.fecha_registro = fecha_registro;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto_comercial() {
        return contacto_comercial;
    }

    public void setContacto_comercial(String contacto_comercial) {
        this.contacto_comercial = contacto_comercial;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}

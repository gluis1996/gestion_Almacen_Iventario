package modelo;

/**
 *
 * @author LUIS
 */
public class m_cliente {

    private String IdCliente;
    private String tipoDocumento;
    private String docuemnto;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String fechaNacimiento;
    private String EstadoCivil;
    private String Genero;

    public m_cliente() {
    }

    public m_cliente(String IdCliente, String tipoDocumento, String docuemnto, String nombre, String apellido, String direccion, String telefono, String email, String fechaNacimiento, String EstadoCivil, String Genero) {
        this.IdCliente = IdCliente;
        this.tipoDocumento = tipoDocumento;
        this.docuemnto = docuemnto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.EstadoCivil = EstadoCivil;
        this.Genero = Genero;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocuemnto() {
        return docuemnto;
    }

    public void setDocuemnto(String docuemnto) {
        this.docuemnto = docuemnto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    
}


package F_Empleado;

/**
 *
 * @author LUIS
 */
public class Empelado {
    String tipoDocumento;
    String nummeroDocumento;
    String nombre;
    String apellido;
    String nacionalidad;
    int edad;
    String genero;
    String distrito;
    String estado;
    
    public void Empleado (){}

    public Empelado(String tipoDocumento, String nummeroDocumento, String nombre, String apellido, String nacionalidad, int edad, String genero, String distrito, String estado) {
        this.tipoDocumento = tipoDocumento;
        this.nummeroDocumento = nummeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
        this.distrito = distrito;
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNummeroDocumento() {
        return nummeroDocumento;
    }

    public void setNummeroDocumento(String nummeroDocumento) {
        this.nummeroDocumento = nummeroDocumento;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

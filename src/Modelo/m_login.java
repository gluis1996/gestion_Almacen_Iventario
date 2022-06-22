package modelo;

public class m_login {
    private String usuario;
    private String contraseña;
    private String rol;

    public m_login() {
        this.usuario = "";
        this.contraseña = "";
        this.rol = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

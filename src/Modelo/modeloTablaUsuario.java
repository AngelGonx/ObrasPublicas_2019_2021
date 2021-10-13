package Modelo;
public class modeloTablaUsuario {
    
    private String usuarioNombre;
    private String password;    

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    @Override
    public String toString() {
        return "modeloTablas{" + "Usuario=" + usuarioNombre + ", Contraseña=" + password +'}';
    }      
}

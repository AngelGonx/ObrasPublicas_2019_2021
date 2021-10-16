package Modelo
//created on 16-10-2021 at 8:12:54
//class 'TablaUsuarioSesion'
public class TablaUsuarioSesion{
// variables for TablaUsuarioSesion

	private int idtabla_usuario;
	private String usuario_nombre;
	private String contraseña;


// setters and getters for TablaUsuarioSesion

// setter method for 'idtabla_usuario'
public void setidtabla_usuario(int idtabla_usuario){
    this.idtabla_usuario = idtabla_usuario;
}

// getter method for 'idtabla_usuario'
public int getidtabla_usuario(int idtabla_usuario){
    return this.idtabla_usuario = idtabla_usuario;
}
// setter method for 'usuario_nombre'
public void setusuario_nombre(String usuario_nombre){
    this.usuario_nombre = usuario_nombre;
}

// getter method for 'usuario_nombre'
public String getusuario_nombre(String usuario_nombre){
    return this.usuario_nombre = usuario_nombre;
}
// setter method for 'contraseña'
public void setcontraseña(String contraseña){
    this.contraseña = contraseña;
}

// getter method for 'contraseña'
public String getcontraseña(String contraseña){
    return this.contraseña = contraseña;
}

}
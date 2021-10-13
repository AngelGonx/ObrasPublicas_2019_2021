/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.modeloTablaUsuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 * Esta librería nos permitira controlar el acceso y consultas en base de datos.
 * Date: 25/06/2020
 * @author joseluis.caamal
 */
public class LibreriaBDControlador {
    private static Connection Conexion; //Abro la conexión
/*Inciamos el constructor*/

   //controladorLibrerias lv = new controladorLibrerias();
   
/*Se llamada a libreria Tools*/
    LibreriaToolsControlador lbt = new LibreriaToolsControlador();
    public modeloTablaUsuario mtu = new modeloTablaUsuario();
/*  ----------------------------------------------------------------------------------
    Nombre: Clase conex()
    Función: Apertura La Conexión con la BD/ Utilizado para la consulta de tablas
    Aut@r: José Luis Caamal Ic
    Parametros: 
    ----------------------------------------------------------------------------------
    Nota: Para la url de la conexión usar el driver compatible con SQL 5.5 o 8.0
    ----------------------------------------------------------------------------------
Crecenciales de DB
*/
    public Connection openConnection() {
        
        try {
            //Como obtener la información desde un archivo properties
            String db_nam = lbt.obtenerClave("nombreBD");
            String use = lbt.obtenerClave("user");
            String pas = lbt.obtenerClave("password");
            System.out.println(db_nam);
            System.out.println(use);
            System.out.println(pas);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_nam + "?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC", use, pas);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa.");
        } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(LibreriaBDControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LibreriaBDControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Conexion;
    }
    
/*  ----------------------------------------------------------------------------------
    Nombre: Clase MySQLConnection
    Función: Apertura La Conexión con la BD
    Aut@r: José Luis Caamal Ic
    Parametros: 
    ----------------------------------------------------------------------------------

    public void MySQLConnection(String user, String pass, String db_name) {
        db_name = "gasvalid";
        user = "root";
        pass="sakai";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LibreriaBDControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    /*  ----------------------------------------------------------------------------------
    Nombre: Clase closeConnection
    Función: Cierra La Conexión con la BD
    Aut@r: José Luis Caamal Ic
    Parametros: 
    ----------------------------------------------------------------------------------
*/
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(LibreriaBDControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List <Object> obtenerDatosUsuario(String table_name, String usuarioIngresado,
                                             String passwordIngresado) {
        //int id = 0;
        List <Object> datosUsuarios = new ArrayList<Object>(); //Cargo una lista JLCI 28/06/2020 :D
        try {
            String Query = "SELECT * FROM " +table_name+" WHERE usuario_nombre = '"+usuarioIngresado+"' and password = '"+passwordIngresado+"'";
            System.out.println(Query);
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while (resultSet.next()) {
                
                mtu.setUsuarioNombre(resultSet.getString("usuario_nombre"));
                datosUsuarios.add(resultSet.getString("usuario_nombre"));
                
                mtu.setPassword(resultSet.getString("password"));
                datosUsuarios.add(resultSet.getString("password"));

            }
            System.out.println("Lista datosUsuarios es: "+datosUsuarios);
            System.out.println("ModeloTablas datosUsuarios es: "+mtu.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
            Logger.getLogger(LibreriaBDControlador.class.getName()).log(Level.SEVERE, null, ex);
            return datosUsuarios;
        }
        return datosUsuarios;
    }    
    
}
//Final de LibreriaBDControlador.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaObrasInformacion;
import Modelo.TablaUsuarios;
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
public class ControladorBaseDeDatos {
    private static Connection Conexion; //Abro la conexión
/*Inciamos el constructor*/

   //controladorLibrerias lv = new controladorLibrerias();
   
/*Se llamada a libreria Tools*/
    ControladorUtilerias lbt = new ControladorUtilerias();
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
            //For MySql 5.5
            //Class.forName("com.mysql.jdbc.Driver");
            //For MySql 8.0
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_nam + "?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC", use, pas);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /*Nombre: Clase Consulta Usuario Valido
    Función:Consulta el usuario y lo valida
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public TablaUsuarios obtenerUsuario(TablaUsuarios tbu) {
        TablaUsuarios tbuAux = new TablaUsuarios();
        String Query = "SELECT * FROM tabla_usuarios WHERE username = '" + tbu.getUsername() + "' and password = '" + tbu.getPassword() + "'";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tbuAux.setUsername(resultSet.getString("username"));
                tbuAux.setPassword(resultSet.getString("password"));
                tbuAux.setId(resultSet.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tbuAux;
    }
    
    
    /*Nombre: Clase crearObrasInformación
    Función: Crea las información de las obras.
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public int crearObrasInformación(TablaObrasInformacion toi) {
        int operacionExitosa = 0;
        try {
            String Query = "INSERT INTO  tabla_obras_informacion VALUES("
                    + "\"" + toi.getId() + "\", "
                    + "\"" + toi.getObra()+ "\", "
                    + "\"" + toi.getLocalidad()+ "\", "
                    + "\"" + toi.getFondo()+ "\", "
                    + "\"" + toi.getFolio()+ "\", "
                    + "\"" + toi.getNumero()+ "\","
                    + "\"" + toi.getInicio()+ "\","
                    + "\"" + toi.getFin()+ "\","
                    + "\"" + toi.getAge()+ "\","
                    + "\"" + toi.getId_tipo_obra()+ "\","
                    + "\"" + toi.getCreated_at()+ "\")";
            //Inica el statement de la conexión
            System.out.println(Query);
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            operacionExitosa = 1;
            //JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            operacionExitosa = 0;
        }

        return operacionExitosa;
    }
    
    /*Nombre: Clase Consulta obtenerIDInformacionObras
    Función:Consulta la tabla información de las obras
    Aut@r: José Luis Caamal Ic
    Parametros: 
    date: 26/10/2021*/
    public int obtenerIDInformacionObras() {
        int tpAux = 0;
        String Query = "SELECT max(id) as idmax FROM tabla_obras_informacion";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tpAux = resultSet.getInt("idmax");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tpAux;
    }
    
    /*Nombre: Clase Consulta obtenerIDBeneficiaros
    Función:Consulta la tabla información de las beneficiarios
    Aut@r: José Luis Caamal Ic
    Parametros: 
    date: 26/10/2021*/
    public int obtenerIDBeneficiaros() {
        int tpAux = 0;
        String Query = "SELECT max(id) as idmax FROM tabla_beneficiarios";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tpAux = resultSet.getInt("idmax");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tpAux;
    }
    
    
    /*Nombre: Clase Consulta obtenerIDInformacionObras
    Función:Consulta la tabla información de las obras
    Aut@r: José Luis Caamal Ic
    Parametros: 
    date: 26/10/2021*/
    public int obtenerIDFotos() {
        int tpAux = 0;
        String Query = "SELECT max(id) as idmax FROM tabla_obras_informacion";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tpAux = resultSet.getInt("idmax");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tpAux;
    }
    
    
    /*Nombre: Clase Consulta obtenerIDInformacionObras
    Función:Consulta la tabla información de las obras
    Aut@r: José Luis Caamal Ic
    Parametros: 
    date: 26/10/2021*/
    public int obtenerIDDoctos() {
        int tpAux = 0;
        String Query = "SELECT max(id) as idmax FROM tabla_obras_informacion";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tpAux = resultSet.getInt("idmax");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tpAux;
    }
    
}
//Final de ControladorBaseDeDatos.
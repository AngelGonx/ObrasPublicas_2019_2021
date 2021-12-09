/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaBeneficiarios;
import Modelo.TablaDocumentosBeneficiarios;
import Modelo.TablaFotosBeneficiarios;
import Modelo.TablaObrasInformacion;
import Modelo.TablaUsuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    /*Nombre: Clase crearBeneficiarios
    Función: Crea las información de los beneficiarios.
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public int crearBeneficiarios(TablaBeneficiarios tbf) {
        int operacionExitosa = 0;
        try {
            String Query = "INSERT INTO  tabla_beneficiarios VALUES("
                    + "\"" + tbf.getId() + "\", "
                    + "\"" + tbf.getNombre()+ "\", "
                    + "\"" + tbf.getLocalidad()+ "\", "
                    + "\"" + tbf.getId_obra()+ "\", "
                    + "\"" + tbf.getCreated_at()+ "\")";
            /*
                Table: tabla_beneficiarios
                Columns:
                id int AI PK 
                nombre varchar(45) 
                localidad varchar(45) 
                id_obra int 
                created_at datetime
            */
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
    /*
    Clase: Se insertan las imagenes para la obra;
    Fecha: 08/12/2021
    Create: José Luis Caamal Ic
    */
    public int insertaImagenes(TablaFotosBeneficiarios tfb){
        int procesoExitoso = 0;
        try {
            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
            Statement stSetLimit = Conexion.createStatement();
            stSetLimit.execute(querySetLimit);
            String sql = "INSERT INTO tabla_fotos_beneficiarios (id,"
                    + "foto_uno,"
                    + "foto_dos,"
                    + "foto_tres,"
                    + "foto_cuatro,"
                    + "foto_cinco,"
                    + "id_beneficiario,"
                    + "created_at) values (default,?, ?, ? , ? , ? , ?,?)";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            InputStream inputStream = new FileInputStream(new File(tfb.getFoto_uno()));
            statement.setBlob(1, inputStream);
            inputStream = new FileInputStream(new File(tfb.getFoto_dos()));
            statement.setBlob(2, inputStream);
            inputStream = new FileInputStream(new File(tfb.getFoto_tres()));
            statement.setBlob(3, inputStream);
            inputStream = new FileInputStream(new File(tfb.getFoto_cuatro()));
            statement.setBlob(4, inputStream);
            inputStream = new FileInputStream(new File(tfb.getFoto_cinco()));
            statement.setBlob(5, inputStream);
            statement.setInt(6, tfb.getId_beneficiario());
            statement.setTimestamp(7, new Timestamp(100));
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
                procesoExitoso = 1;
            }
            inputStream.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            procesoExitoso =0;
        }
        return procesoExitoso;
    
    }
    
    
    /*
    Clase: Se insertan los documentos para la obra;
    Fecha: 08/12/2021
    Create: José Luis Caamal Ic
    */
    public int insertaDocumentos(TablaDocumentosBeneficiarios tdb){
        int procesoExitoso = 0;
        try {
            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
            Statement stSetLimit = Conexion.createStatement();
            stSetLimit.execute(querySetLimit);
            String sql = "INSERT INTO tabla_doc_beneficiarios (id,"
                    + "doc_uno,"
                    + "doc_dos,"
                    + "doc_tres,"
                    + "doc_cuatro,"
                    + "doc_cinco,"
                    + "id_beneficiario,"
                    + "created_at) values (default,?, ?, ? , ? , ? , ?,?)";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            InputStream inputStream = new FileInputStream(new File(tdb.getDoc_uno()));
            statement.setBlob(1, inputStream);
            inputStream = new FileInputStream(new File(tdb.getDoc_dos()));
            statement.setBlob(2, inputStream);
            inputStream = new FileInputStream(new File(tdb.getDoc_tres()));
            statement.setBlob(3, inputStream);
            inputStream = new FileInputStream(new File(tdb.getDoc_cuatro()));
            statement.setBlob(4, inputStream);
            inputStream = new FileInputStream(new File(tdb.getDoc_cinco()));
            statement.setBlob(5, inputStream);
            statement.setInt(6, tdb.getId_beneficiario());
            statement.setTimestamp(7, new Timestamp(100));
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
                procesoExitoso = 1;
            }
            inputStream.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            procesoExitoso =0;
        }
        return procesoExitoso;
    
    }
    
    /*Nombre: Clase modeloVehiculoPropietario
    Función: Obtiene el modelo de los vehiculos y propietarios y las pinta en la tabla
    Aut@r: Angel 
    Parametros: */
    public DefaultTableModel modeloInformacionObras(String columna[],int tipoObra, String ageObra) {
        DefaultTableModel modeloRetorno;
        modeloRetorno = new DefaultTableModel(null, columna);
        try {
            String Query = "SELECT * FROM tabla_obras_informacion where id_tipo_obra ="+tipoObra+" and age='"+ageObra+"'";

            System.out.println("Contenido en ejecución: " + Query);

            PreparedStatement us = Conexion.prepareStatement(Query);
            ResultSet res = us.executeQuery();
            Object objDatos[] = new Object[columna.length]; //Siempre debe cconexoincidir con el numero de columnas!

            while (res.next()) {
                for (int i = 0; i < columna.length; i++) {
                    objDatos[i] = res.getObject(i + 1);
                    //System.out.println(objDatos[i]);
                }
                modeloRetorno.addRow(objDatos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

        return modeloRetorno;
    }
    
    /*Nombre: Clase Consulta TablaObrasInformacion toi
    Función:Consulta la TablaObrasInformacion toi
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public TablaObrasInformacion obtenerInformacion(TablaObrasInformacion toi) {
        TablaObrasInformacion toiAux = new TablaObrasInformacion();
        String Query = "SELECT * FROM tabla_obras_informacion WHERE id = '" + toi.getId() + "'";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            /*
                Table: tabla_obras_informacion
                Columns:
                id int AI PK 
                obra varchar(60) 
                localidad varchar(45) 
                fondo varchar(45) 
                folio varchar(45) 
                numero varchar(45) 
                inicio varchar(45) 
                fin varchar(45) 
                age int 
                id_tipo_obra int 
                created_at datetime
            */
            while (resultSet.next()) {
                toiAux.setId(resultSet.getInt("id"));
                toiAux.setObra(resultSet.getString("obra"));
                toiAux.setLocalidad(resultSet.getString("localidad"));
                toiAux.setFondo(resultSet.getString("fondo"));
                toiAux.setFolio(resultSet.getString("folio"));
                toiAux.setNumero(resultSet.getString("numero"));
                toiAux.setInicio(resultSet.getString("inicio"));
                toiAux.setFin(resultSet.getString("fin"));
                toiAux.setAge(resultSet.getInt("age"));
                toiAux.setId_tipo_obra(resultSet.getInt("id_tipo_obra"));
                toiAux.setCreated_at(resultSet.getTimestamp("created_at"));
//                toiAux.setNombre(resultSet.getString("nombre"));
//                toiAux.setPrecio(resultSet.getString("precio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toiAux;
    }
    
    /*Nombre: Clase actualizaObrasInformacio
    Función: Actualiza las multas a los automovilistas
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public int actualizaObrasInformacion(TablaObrasInformacion toi) {
        int operacionExitosa = 0;
        try {
            /*
                Table: tabla_obras_informacion
                Columns:
                id int AI PK 
                obra varchar(60) 
                localidad varchar(45) 
                fondo varchar(45) 
                folio varchar(45) 
                numero varchar(45) 
                inicio varchar(45) 
                fin varchar(45) 
                age int 
                id_tipo_obra int 
                created_at datetime
            */
            //Inica el statement de la conexión
            String Query = ("UPDATE tabla_obras_informacion "
                    + "SET "
                    + "obra = '" + toi.getObra()+ "', "
                    + "localidad = '" + toi.getLocalidad()+ "', "
                    + "fondo = '" + toi.getFondo()+ "', "
                    + "folio = '" + toi.getFolio()+ "', "
                    + "numero = '" + toi.getNumero()+ "', "
                    + "inicio = '" + toi.getInicio()+ "', "
                    + "fin = '" + toi.getFin()+ "' "
                    + "WHERE id = '" + toi.getId() + "'");
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
    
}
//Final de ControladorBaseDeDatos.
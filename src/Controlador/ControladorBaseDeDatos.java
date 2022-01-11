/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaArchivos;
import Modelo.TablaBeneficiarios;
import Modelo.TablaDocumentosBeneficiarios;
import Modelo.TablaFotosBeneficiarios;
import Modelo.TablaObrasInformacion;
import Modelo.TablaUsuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta librería nos permitira controlar el acceso y consultas en base de datos.
 * Date: 25/06/2020
 * @author joseluis.caamal
 */
public class ControladorBaseDeDatos {
    private static Connection Conexion; //Abro la conexión
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
                    + "\"" + timestamp+ "\")";
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
                    + "\"" + timestamp+ "\")";
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
    
    /*Nombre: Clase Consulta obtiene la información de un solo beneficiario
    Función:Consulta la tabla información de las beneficiarios
    Aut@r: José Luis Caamal Ic
    Parametros: 
    date: 26/10/2021*/
    public TablaBeneficiarios obtenerBeneficiario(int idBeneficiario) {
        TablaBeneficiarios tbe = new TablaBeneficiarios();
        int tpAux = 0;
        String Query = "SELECT * FROM tabla_beneficiarios where id= "+idBeneficiario+"";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
//                tpAux = resultSet.getInt("idmax");
                  tbe.setId(resultSet.getInt("id"));
                  tbe.setNombre(resultSet.getString("nombre"));
                  tbe.setLocalidad(resultSet.getString("localidad"));
                  tbe.setId_obra(resultSet.getInt("id_obra"));
                  tbe.setCreated_at(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbe;
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
            String querySetLimit = "SET GLOBAL max_allowed_packet=524288000;";  // 10 MB
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
            statement.setTimestamp(7, timestamp);
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
            String querySetLimit = "SET GLOBAL max_allowed_packet=524288000;";  // 10 MB
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
            statement.setTimestamp(7, timestamp);
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
    
    
    /*
    Clase: Se insertan los archivos para la obra;
    Fecha: 08/12/2021
    Create: José Luis Caamal Ic
    */
    public int insertaArchivos(TablaArchivos tar){
        int procesoExitoso = 0;
        try {
            String querySetLimit = "SET GLOBAL max_allowed_packet=524288000;";  // 10 MB
            Statement stSetLimit = Conexion.createStatement();
            stSetLimit.execute(querySetLimit);
            String sql = "INSERT INTO tabla_archivos (id,"
                    + "archivo_uno,"
                    + "archivo_dos,"
                    + "archivo_tres,"
                    + "archivo_cuatro,"
                    + "archivo_cinco,"
                    + "archivo_seis,"
                    + "archivo_siete,"
                    + "id_obra,"
                    + "created_at) values (default,?, ?, ? , ? , ? , ?,?,?,?)";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            InputStream inputStream = new FileInputStream(new File(tar.getArchivo_uno()));
            statement.setBlob(1, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_dos()));
            statement.setBlob(2, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_tres()));
            statement.setBlob(3, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_cuatro()));
            statement.setBlob(4, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_cinco()));
            statement.setBlob(5, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_seis()));
            statement.setBlob(6, inputStream);
            inputStream = new FileInputStream(new File(tar.getArchivo_siete()));
            statement.setBlob(7, inputStream);
            statement.setInt(8, tar.getId_obra());
            statement.setTimestamp(9, timestamp);
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with date.");
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
    
    /*Nombre: Clase Consulta TablaObrasInformacion toi
    Función:Consulta la TablaObrasInformacion toi
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public TablaArchivos obtenerArchivos(TablaArchivos tar) {
        TablaArchivos tarAux = new TablaArchivos();
        String Query = "SELECT * FROM tabla_archivos WHERE id_obra = '" + tar.getId_obra()+ "'";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            /*
                Table: tabla_archivos
                Columns:
                id int AI PK 
                archivo_uno longblob 
                archivo_dos longblob 
                archivo_tres longblob 
                archivo_cuatro longblob 
                archivo_cinco longblob 
                archivo_seis longblob 
                archivo_siete longblob 
                id_obra int 
                created_at
            */
            while (resultSet.next()) {
                tarAux.setId(resultSet.getInt("id"));
                tarAux.setArchivo_uno(resultSet.getString("archivo_uno"));
                tarAux.setArchivo_dos(resultSet.getString("archivo_dos"));
                tarAux.setArchivo_tres(resultSet.getString("archivo_tres"));
                tarAux.setArchivo_cuatro(resultSet.getString("archivo_cuatro"));
                tarAux.setArchivo_cinco(resultSet.getString("archivo_cinco"));
                tarAux.setArchivo_seis(resultSet.getString("archivo_seis"));
                tarAux.setArchivo_siete(resultSet.getString("archivo_siete"));
                tarAux.setId_obra(resultSet.getInt("id_obra"));
                tarAux.setCreated_at(resultSet.getTimestamp("created_at"));
//                toiAux.setNombre(resultSet.getString("nombre"));
//                toiAux.setPrecio(resultSet.getString("precio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarAux;
    }
    /*
    Clase: guardarArchivo
    Nota: Permite guardar el archivo en la dirección que se le asigne
    Por: Jose Luis Caamal Ic
    Fecha 11/12/2021
    */
    public int guardarArchivo(String filePath,int docGuardar,TablaArchivos tar){
        int operacionExitosa = 0;
//        String filePath = "C:/src/m.jpg";
        int BUFFER_SIZE = 4096;
        try {
//            Connection conn = DriverManager.getConnection(url, user, password);
            filePath = filePath +".pdf";
            String sql = "SELECT * FROM tabla_archivos "
                    + "WHERE id =?";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            statement.setInt(1, tar.getId());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = null;
                if(docGuardar == 1)
                    blob = result.getBlob("archivo_uno");
                if(docGuardar == 2)
                    blob = result.getBlob("archivo_dos");
                if(docGuardar == 3)
                    blob = result.getBlob("archivo_tres");
                if(docGuardar == 4)
                    blob = result.getBlob("archivo_cuatro");
                if(docGuardar == 5)
                    blob = result.getBlob("archivo_cinco");
                if(docGuardar == 6)
                    blob = result.getBlob("archivo_seis");
                if(docGuardar == 7)
                    blob = result.getBlob("archivo_siete");
                
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
                operacionExitosa = 1;
            }
            Conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        } catch (IOException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        }
        return operacionExitosa;
    
    }
    
    /*
    Clase: guardarDocumento
    Nota: Permite guardar el documento en la dirección que se le asigne
    Por: Jose Luis Caamal Ic
    Fecha 11/12/2021
    */
    public int guardarDocumento(String filePath,int docGuardar,TablaDocumentosBeneficiarios tdb){
        int operacionExitosa = 0;
//        String filePath = "C:/src/m.jpg";
        int BUFFER_SIZE = 4096;
        try {
//            Connection conn = DriverManager.getConnection(url, user, password);
            filePath = filePath +".pdf";
            String sql = "SELECT * FROM tabla_doc_beneficiarios "
                    + "WHERE id =?";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            statement.setInt(1, tdb.getId());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = null;
                if(docGuardar == 1)
                    blob = result.getBlob("doc_uno");
                if(docGuardar == 2)
                    blob = result.getBlob("doc_dos");
                if(docGuardar == 3)
                    blob = result.getBlob("doc_tres");
                if(docGuardar == 4)
                    blob = result.getBlob("doc_cuatro");
                if(docGuardar == 5)
                    blob = result.getBlob("doc_cinco");
                
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("Documento Guardado");
                operacionExitosa = 1;
            }
            Conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        } catch (IOException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        }
        return operacionExitosa;
    
    }
    
     /*
    Clase: guardarFoto
    Nota: Permite guardar el documento en la dirección que se le asigne
    Por: Jose Luis Caamal Ic
    Fecha 11/12/2021
    */
    public int guardarFoto(String filePath,int docGuardar,TablaFotosBeneficiarios tfb){
        int operacionExitosa = 0;
//        String filePath = "C:/src/m.jpg";
        int BUFFER_SIZE = 4096;
        try {
//            Connection conn = DriverManager.getConnection(url, user, password);
            filePath = filePath +".jpg";
            String sql = "SELECT * FROM tabla_fotos_beneficiarios "
                    + "WHERE id =?";
            PreparedStatement statement = Conexion.prepareStatement(sql);
            statement.setInt(1, tfb.getId());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = null;
                if(docGuardar == 1)
                    blob = result.getBlob("foto_uno");
                if(docGuardar == 2)
                    blob = result.getBlob("foto_dos");
                if(docGuardar == 3)
                    blob = result.getBlob("foto_tres");
                if(docGuardar == 4)
                    blob = result.getBlob("foto_cuatro");
                if(docGuardar == 5)
                    blob = result.getBlob("foto_cinco");
                
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("Foto Guardado");
                operacionExitosa = 1;
            }
            Conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        } catch (IOException ex) {
            ex.printStackTrace();
            operacionExitosa = 0;
        }
        return operacionExitosa;
    
    }
    
    
     /*Nombre: Clase actualizaObrasInformacio
    Función: Actualiza las multas a los automovilistas
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public int actualizaArchivos(TablaArchivos tar){
        int operacionExitosa = 0;
        try {
//            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
//            Statement stSetLimit = Conexion.createStatement();
//            stSetLimit.execute(querySetLimit);
            //Inica el statement de la conexión
//            InputStream inputStreamAux1 = new FileInputStream(new File(tar.getArchivo_uno()));
//            byte [] inputStream1 = IOUtils.toByteArray(inputStreamAux1);
//            //st.setBlob(1, inputStream);
//            InputStream inputStreamAux2 = new FileInputStream(new File(tar.getArchivo_dos()));
//            byte [] inputStream2 = IOUtils.toByteArray(inputStreamAux2);
//            //st.setBlob(2, inputStream);
//            InputStream inputStreamAux3 = new FileInputStream(new File(tar.getArchivo_tres()));
//            byte [] inputStream3 = IOUtils.toByteArray(inputStreamAux3);
//            //st.setBlob(3, inputStream);
//            InputStream inputStreamAux4 = new FileInputStream(new File(tar.getArchivo_cuatro()));
//            byte [] inputStream4 = IOUtils.toByteArray(inputStreamAux4);
//            //st.setBlob(4, inputStream);
//            InputStream inputStreamAux5 = new FileInputStream(new File(tar.getArchivo_cinco()));
//            byte [] inputStream5 = IOUtils.toByteArray(inputStreamAux5);
//            //st.setBlob(5, inputStream);
//            
//            InputStream inputStreamAux6 = new FileInputStream(new File(tar.getArchivo_seis()));
//            byte [] inputStream6 = IOUtils.toByteArray(inputStreamAux6);
//            //st.setBlob(6, inputStream);
//            InputStream inputStreamAux7 = new FileInputStream(new File(tar.getArchivo_siete()));
//            byte [] inputStream7 = IOUtils.toByteArray(inputStreamAux7);
//            //st.setBlob(7, inputStream);
//            Blob sb1 = new Blob(inputStream1);
//            Blob sb2 = new SerialBlob(inputStream2);
//            Blob sb3 = new SerialBlob(inputStream3);
//            Blob sb4 = new SerialBlob(inputStream4);
//            Blob sb5 = new SerialBlob(inputStream5);
//            Blob sb6 = new SerialBlob(inputStream6);
//            Blob sb7 = new SerialBlob(inputStream7);
            /*
                id int AI PK 
                archivo_uno longblob 
                archivo_dos longblob 
                archivo_tres longblob 
                archivo_cuatro longblob 
                archivo_cinco longblob 
                archivo_seis longblob 
                archivo_siete longblob 
                id_obra int 
                created_at datetime
            */
            String Query = "UPDATE `tabla_archivos` SET `archivo_uno` =?,"
                    + "`archivo_dos`=?, `archivo_tres`=?, `archivo_tres`=?,`archivo_cuatro`=?,`archivo_cinco`=?,"
                    + "`archivo_seis`=?,`archivo_siete`=? where `id`=?";
            System.out.println(Query);
            PreparedStatement st = Conexion.prepareStatement(Query);
            InputStream inputStream = new FileInputStream(new File(tar.getArchivo_uno()));
            st.setBinaryStream(1, inputStream);
            
            inputStream = new FileInputStream(new File(tar.getArchivo_dos()));
            st.setBinaryStream(2, inputStream);
            
            inputStream = new FileInputStream(new File(tar.getArchivo_tres()));
            st.setBinaryStream(3, inputStream);
            
            inputStream = new FileInputStream(new File(tar.getArchivo_cuatro()));
            st.setBinaryStream(4, inputStream);
            
            inputStream = new FileInputStream(new File(tar.getArchivo_cinco()));
            st.setBinaryStream(5, inputStream);
            
            
            inputStream = new FileInputStream(new File(tar.getArchivo_seis()));
            st.setBinaryStream(6, inputStream);
           
            inputStream = new FileInputStream(new File(tar.getArchivo_siete()));
            st.setBinaryStream(7, inputStream);
            
            st.setInt(8, tar.getId());
            
            st.executeUpdate(Query);
            operacionExitosa = 1;
            
            inputStream.close();
            //JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            operacionExitosa = 0;
        }catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            operacionExitosa = 0;
        }

        return operacionExitosa;
    }
    
    /*  ----------------------------------------------------------------------------------
    Nombre: Clase eliminarArchivoRegistro
    Función: Elimina los valores en la tabla correspondiente.
    Aut@r: José Luis Caamal Ic
    Parametros: Table: tabla_pacientes
                Columns:
    Date: 27/06/2020
    ----------------------------------------------------------------------------------
*/

    public int eliminarArchivoRegistro(int ID) {
        int operacionExitosa = 0;
        try {
            String Query = "DELETE FROM tabla_archivos WHERE ID = \"" + ID + "\"";
            System.out.println("SQL Elimina: "+Query);
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            operacionExitosa = 1;
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");return 0;
            operacionExitosa = 0;
        }
        return operacionExitosa;
    }
    
    /*Nombre: Clase modeloVehiculoPropietario
    Función: Obtiene el modelo de los vehiculos y propietarios y las pinta en la tabla
    Aut@r: Angel 
    Parametros: */
    public DefaultTableModel modeloBeneficiarios(String columna[],int idObra) {
        DefaultTableModel modeloRetorno;
        modeloRetorno = new DefaultTableModel(null, columna);
        try {
            String Query = "SELECT * FROM tabla_beneficiarios where id_obra ="+idObra+"";

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
    
    /*Nombre: Clase actualizaBeneficiarios
    Función: Actualiza los beneficiarios
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public int actualizaBeneficiarios(TablaBeneficiarios tben) {
        int operacionExitosa = 0;
        try {
            String Query = ("UPDATE tabla_beneficiarios "
                    + "SET "
                    + "nombre = '" + tben.getNombre()+ "', "
                    + "localidad = '" + tben.getLocalidad()+ "' "
                    + "WHERE id = '" + tben.getId() + "'");
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
    
     /*  ----------------------------------------------------------------------------------
    Nombre: Clase eliminaBeneficiarios
    Función: Elimina los valores en la tabla correspondiente y sus relacionados
    Aut@r: José Luis Caamal Ic
    Parametros: Table: tabla_pacientes
                Columns:
    Date: 27/06/2020
    ----------------------------------------------------------------------------------
*/

    public int eliminaBeneficiarios(int ID) {
        int operacionExitosa = 0;
        try {
            String Query = "DELETE FROM tabla_fotos_beneficiarios WHERE id_beneficiario = \"" + ID + "\"";
            System.out.println("SQL Elimina: "+Query);
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            st.close();
            operacionExitosa = 1;
            if(operacionExitosa == 1){
                Query = "DELETE FROM tabla_doc_beneficiarios WHERE id_beneficiario = \"" + ID + "\"";
                System.out.println("SQL Elimina: "+Query);
                st = Conexion.createStatement();
                st.executeUpdate(Query);
                st.close();
            }
            if(operacionExitosa == 1){
                 Query = "DELETE FROM tabla_beneficiarios WHERE id = \"" + ID + "\"";
                 System.out.println("SQL Elimina: "+Query);
                 st = Conexion.createStatement();
                 st.executeUpdate(Query);
                 st.close();
            }
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");return 0;
            operacionExitosa = 0;
        }
        return operacionExitosa;
    }
    
     /*Nombre: Clase Consulta TablaDocumentosBeneficiarios obtenerDocumentos
    Función:Consulta la TablaDocumentosBeneficiarios obtenerDocumentos
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public TablaDocumentosBeneficiarios obtenerDocumentos(TablaBeneficiarios tbf) {
        TablaDocumentosBeneficiarios tarAux = new TablaDocumentosBeneficiarios();
        String Query = "SELECT * FROM tabla_doc_beneficiarios WHERE id_beneficiario = '" + tbf.getId()+ "'";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tarAux.setId(resultSet.getInt("id"));
                tarAux.setDoc_uno(resultSet.getString("doc_uno"));
                tarAux.setDoc_uno(resultSet.getString("doc_dos"));
                tarAux.setDoc_uno(resultSet.getString("doc_tres"));
                tarAux.setDoc_uno(resultSet.getString("doc_cuatro"));
                tarAux.setDoc_uno(resultSet.getString("doc_cinco"));
                tarAux.setId_beneficiario(resultSet.getInt("id_beneficiario"));
                tarAux.setCreated_at(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarAux;
    }
    
    /*Nombre: Clase Consulta TablaFotosBeneficiarios obtenerFotos
    Función:Consulta la TablaFotosBeneficiarios obtenerFotos
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public TablaFotosBeneficiarios obtenerFotos(TablaBeneficiarios tbf) {
        TablaFotosBeneficiarios tarAux = new TablaFotosBeneficiarios();
        String Query = "SELECT * FROM tabla_fotos_beneficiarios WHERE id_beneficiario = '" + tbf.getId()+ "'";
        System.out.println(Query);
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                tarAux.setId(resultSet.getInt("id"));
                tarAux.setFoto_uno(resultSet.getString("foto_uno"));
                tarAux.setFoto_dos(resultSet.getString("foto_dos"));
                tarAux.setFoto_tres(resultSet.getString("foto_tres"));
                tarAux.setFoto_cuatro(resultSet.getString("foto_cuatro"));
                tarAux.setFoto_cinco(resultSet.getString("foto_cinco"));
                tarAux.setId_beneficiario(resultSet.getInt("id_beneficiario"));
                tarAux.setCreated_at(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarAux;
    }
    
      /*  ----------------------------------------------------------------------------------
    Nombre: Clase eliminarObras
    Función: Elimina los valores en la tabla correspondiente y sus relacionados
    Aut@r: José Luis Caamal Ic
    Parametros: Table: tabla_pacientes
                Columns:
    Date: 9/1/2022
    ----------------------------------------------------------------------------------
*/

    public int eliminarObras(int ID) {
        int operacionExitosa = 0;
        try {
            String Query = "DELETE FROM tabla_archivos WHERE id_obra = \"" + ID + "\"";
            System.out.println("SQL Elimina: "+Query);
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            st.close();
            operacionExitosa = 1;
            if(operacionExitosa == 1){
                List listaRes = new ArrayList();
                listaRes = obtenerIDBeneficiario(ID);
                for(int i=0;i<listaRes.size();i++){
                    
                    operacionExitosa = eliminaBeneficiarios((int) listaRes.get(i));
                    
                }
//                Query = "DELETE FROM tabla_beneficiarios WHERE id_obra = \"" + ID + "\"";
//                System.out.println("SQL Elimina: "+Query);
//                st = Conexion.createStatement();
//                st.executeUpdate(Query);
//                st.close();
            }
            if(operacionExitosa == 1){
                 Query = "DELETE FROM tabla_obras_informacion WHERE id = \"" + ID + "\"";
                 System.out.println("SQL Elimina: "+Query);
                 st = Conexion.createStatement();
                 st.executeUpdate(Query);
                 st.close();
            }
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");return 0;
            operacionExitosa = 0;
        }
        return operacionExitosa;
    }
    
     /*Nombre: Clase Consulta TablaDocumentosBeneficiarios obtenerDocumentos
    Función:Consulta la TablaDocumentosBeneficiarios obtenerDocumentos
    Aut@r: José Luis Caamal Ic
    Parametros: */
    public List obtenerIDBeneficiario(int id_obra) {
//        TablaDocumentosBeneficiarios tarAux = new TablaDocumentosBeneficiarios();
        String Query = "SELECT * FROM tabla_beneficiarios WHERE id_obra = '" + id_obra+ "'";
        System.out.println(Query);
        List listaRes = new ArrayList();
        try {
            Statement st;
            st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                  listaRes.add(resultSet.getInt("id"));
//                tarAux.setDoc_uno(resultSet.getString("doc_uno"));
//                tarAux.setDoc_uno(resultSet.getString("doc_dos"));
//                tarAux.setDoc_uno(resultSet.getString("doc_tres"));
//                tarAux.setDoc_uno(resultSet.getString("doc_cuatro"));
//                tarAux.setDoc_uno(resultSet.getString("doc_cinco"));
//                tarAux.setId_beneficiario(resultSet.getInt("id_beneficiario"));
//                tarAux.setCreated_at(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }
    
}
//Final de ControladorBaseDeDatos.
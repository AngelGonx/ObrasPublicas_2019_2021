/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Principal.accesoPrincipal;
import Vista.Principal.ventanaPrincipal;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;

/**
 * Está Librieria nos permitira realizar herramientas de apoyo en el sistema entre otras.
 * Date: 25/06/2020
 * @author joseluis.caamal
 */
public class ControladorUtilerias {
    public String nombreTipoUsuario = "";
    
    /*Inicia: Llamo al modeloTablas para recuperar la información en get y set
    @Author: Jose L. Caamal Ic 28/06/2020
    */
    
    /*
    Inicia:
    Se declaran las variables de tipo usuario para manipular el sistema en tiempo real
    Nota: Siempre hay que obtener la validación desde aquí:
    @Author: Jose Luis Caamal Ic 27/06/2020
    */
    
    public String validaUsuario(int tipoUser){
        
        /*
        0 = Gerente Técnico
        1 = Técnico Verificador
        2 = Personal de Apoyo
        */
        switch(tipoUser){
            case 0:
                nombreTipoUsuario = "Gerente Técnico";
            break;
            case 1:
                nombreTipoUsuario = "Técnico Verificador";
            break;
            case 2:
                nombreTipoUsuario = "Personal de Apoyo";
            break;
            default:
                nombreTipoUsuario = "No existe el rol de usuario";
            break;
            
            
        }
        
            
        return nombreTipoUsuario;
    }
    
    
    /*
    Termina:
    Se declaran las variables de tipo usuario para manipular el sistema en tiempo real
    Nota: Siempre hay que obtener la validación desde aquí:
    @Author: Jose Caamal 27/06/2020
    */
    
    /*
    Inicia:
    Se encripta la contraseña
    Nota: Siempre hay que obtener la validación desde aquí:
    @Author: Jose Caamal 27/06/2020
    */
    public String obtenerMD5(String input) {
       try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(input.getBytes());
                BigInteger number = new BigInteger(1, messageDigest);
                String hashtext = number.toString(16);

                while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
       return hashtext;
            }
       catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
       }
    }
    
    /*
    Formateo la fecha para recibirla y guardarla en MySQL
    @Author: Jose Caamal 15/07/2020
    */
    
    public String convertirFecha(Date fecha){
        SimpleDateFormat plantilla;
        //fecha = new java.util.Date();  
        plantilla = new SimpleDateFormat("yyyy/MM/dd H:mm:ss"); //Obtengo Horas y 
        String tiempo = plantilla.format(fecha);
        return tiempo;
    }
    //Formateo de fecha Ángel González
    public String convertirFechaDict(Date fecha){
        SimpleDateFormat plantilla;
        //fecha = new java.util.Date();  
        plantilla = new SimpleDateFormat("dd/MM/yyyy"); //Obtengo Horas y 
        String tiempo = plantilla.format(fecha);
        
        return tiempo;
    }

    public static Date fechaFormato(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = new Date();
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }    
    
    public static Date fechaFormatoDateCalendar(String fecha)
    {
        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = new Date();
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }    
    
    /*
    Se abre la ventana principal desde el acceso principal
    @Author: Christian Olmedo 23/07/2020
    */
    public void usuarioCorrecto(ControladorBaseDeDatos lbd){
//        System.out.println(lbd.mtu.toString());
//        ventanaPrincipal ventanaPrincipal = new ventanaPrincipal(lbd.mtu);
//        accesoPrincipal accesoPrincipal = new accesoPrincipal(); 
////        this.setVisible(false);
//        ventanaPrincipal.show(true);
//        //accesoPrincipal.show(false);  
    }
    
    /*
    Permite identificar el tipo de documento que se va imprimir
    @Author: Jose Luis Caamal Ic 31/08/2020
    */
    public String tipoDocumentoImprimir(int tipoDoc){
        String tipoDocumento = "";
        
        switch(tipoDoc){
            
            case 1:
                tipoDocumento = "CONTRATO2021.docx";
            break;
            case 2:
                tipoDocumento = "SOLICITUD2021.docx";
            break;
            case 3:
                tipoDocumento = "DICTAMENBOMBAS2021.docx"; //Sirve para generar el último documento
            break;
            case 4:
                tipoDocumento = "DICTAMENBOMBAS2021H2.docx"; //Sirve para generar el último documento
            break;
            case 5:
                tipoDocumento = "DICTAMENDEBOMBAS2021.docx";
            break;
            case 6:
                tipoDocumento = "registropruebas.xlsx";
            break;
            default:
                //tipoDocumento = "CONTRATO2021.docx";
            break;
        }
        System.out.println(tipoDocumento);
        
        return tipoDocumento;
    }
    
    /*
    Permite identificar el tipo de documento que se va imprimir
    @Author: Jose Luis Caamal Ic 31/08/2020
    */
    public String tipoDocumentoGenerar(int tipoDoc, String nameArchive){
        String tipoDocumento = "";
        
        switch(tipoDoc){
            
            case 1:
                tipoDocumento = "ContratoFolio-"+nameArchive;
            break;
            case 2:
                tipoDocumento = "SolicitudFolio-"+nameArchive;
            break;
            case 3:
                tipoDocumento = "DictamenBombaUno-"+nameArchive;
            break;
            case 4:
                tipoDocumento = "DictamenBombaDos-"+nameArchive;
            break;
            case 5:
                tipoDocumento = "DictamenBombas-"+nameArchive;
            break;
            case 6:
                tipoDocumento = "RegistroPruebas-"+nameArchive;
            break;
            default:
                //tipoDocumento = "CONTRATO2021.docx";
            break;
        }
        System.out.println(tipoDocumento);
        
        return tipoDocumento;
    }
        //Abre el archivo deseado en la dirección deseada
    //@direccionArchivo C:/Formatos
    //@Jose Luis Caamal Ic
    public void openWord(String direccionArchivo){

     try {

            File objetofile = new File (direccionArchivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

    }
    //Elimina el archivo deseado en la dirección deseada
    //@direccionArchivo C:/Formatos
    //@Jose Luis Caamal Ic
    public int deleteDocumento(String direccionArchivo){
     int valida = 0;
        try {
               //File objetofile = new File (direccionArchivo);
               Files.delete(Paths.get(direccionArchivo));
               //Desktop.getDesktop().open(objetofile);
               valida = 1;
        }catch (IOException ex) {

               System.out.println(ex);
               valida = 0;
        }
       return valida;
    }
    
    //Obtiene el Periodo para el documento
    //@direccionArchivo C:/Formatos
    //@Jose Luis Caamal Ic
    //31/08/2020
    public String obtenerPeriodo(){
     
       String[] periodo={"1ER PERIODO","2DO PERIODO"};
       JComboBox jcd = new JComboBox(periodo);
       jcd.setEditable(true);
       jcd.setSelectedIndex(1);
       
       JOptionPane.showMessageDialog(null, jcd, "Periodo",JOptionPane.QUESTION_MESSAGE);
       
       String opcion = (String) jcd.getSelectedItem();
       
       return opcion;
    }
    
    public String obtenerHorarioInicio(){
        
       //JOptionPane.showMessageDialog(null, "Por favor, ingresa la hora inicial en formato: AM/PM");
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       String formattedDate = dateFormat.format(new Date()).toString();
       System.out.println(formattedDate);
       
       //Date newDate = new Date();
       String[] periodo={formattedDate};
      
       JComboBox jcd = new JComboBox(periodo);
       jcd.setEditable(true);
       jcd.setSelectedIndex(0);
       
       //JOptionPane.showMessageDialog(null, jcd, "Hora Inicio",JOptionPane.QUESTION_MESSAGE);
       
       String opcion = (String) jcd.getSelectedItem();
       
       return opcion;
    }
    
    public String obtenerHorarioFIN(){
     
       //JOptionPane.showMessageDialog(null, "Por favor, ingresa la hora fin en formato: AM/PM");
       //Date newDate = new Date();
       
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       String formattedDate = dateFormat.format(new Date()).toString();
       System.out.println(formattedDate);       
       
       String[] periodo={formattedDate};
       
       JComboBox jcd = new JComboBox(periodo);
       jcd.setEditable(true);
       jcd.setSelectedIndex(0);
       
       //JOptionPane.showMessageDialog(null, jcd, "Hora Fin",JOptionPane.QUESTION_MESSAGE);
       
       String opcion = (String) jcd.getSelectedItem();
       
       return opcion;
    }
    
    
    /*
        Obtengo los parametros en la bd para evitar ir cambiando a cada rato la contraseña
        y asegurarnos que nadie pueda utilizarlo.
        Author: José Luis Caamal Ic
        Date: 07/05/2021
    */
    public String obtenerClave(String clave) throws FileNotFoundException, IOException{
        String respClave = "";
        Properties propiedades = new Properties();
        
        propiedades.load(new FileReader("src/Controlador/propiedades.properties"));
        //C:\Users\joseluis.caamal\Documents\GitProjects\SoftwareGasoValidaciones\src\Controlador\propiedades.properties
        respClave = propiedades.getProperty(clave);
        System.out.println("La clave especificada es: " +  respClave);
        return respClave;
    }
    /*
        getByteArrayFromFile(): 
        Metodo que convierte un documento en byte para almacenarlo correctamente
        Jose Luis Caamal Ic
        9992059252
        
    */
    private byte[] getByteArrayFromFile(final Document handledDocument) throws IOException {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final InputStream in = new FileInputStream((File) handledDocument);
    final byte[] buffer = new byte[500];

    int read = -1;
    while ((read = in.read(buffer)) > 0) {
        baos.write(buffer, 0, read);
    }
    in.close();

    return baos.toByteArray();
}

    public String obtenerRuta(int tipoDocumento){
        //Creamos el objeto JFileChooser
    JFileChooser fc=new JFileChooser();

    //Indicamos lo que podemos seleccionar
    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    //Creamos el filtro
    FileNameExtensionFilter filtro = null;
    if(tipoDocumento == 1)
        filtro = new FileNameExtensionFilter("*.jpg", "jpg");
    if(tipoDocumento == 2)
        filtro = new FileNameExtensionFilter("*.pdf", "pdf");
    if(tipoDocumento == 3)
        filtro = new FileNameExtensionFilter("*.pdf", "pdf");
    
    String cadena="";
    //Le indicamos el filtro
    fc.setFileFilter(filtro);

    //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc.showOpenDialog(null);

        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){

            //Seleccionamos el fichero
            File fichero=fc.getSelectedFile();
            cadena = fichero.getAbsolutePath();
//            //Ecribe la ruta del fichero seleccionado en el campo de texto
//            textField.setText(fichero.getAbsolutePath());
//            
//            try(FileReader fr=new FileReader(fichero)){
//
//                int valor=fr.read();
//                while(valor!=-1){
//                    cadena=cadena+(char)valor;
//                    valor=fr.read();
//                }
//                textArea.setText(cadena);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return cadena;
    }
    
    public String tipoObra(int tipoObra){
        String nombreTipoObra = "";
        switch(tipoObra){
            case 1:
                nombreTipoObra = "Cuartos Dormitorio";
            break;
            case 2:
                nombreTipoObra = "Techos de Concreto";
            break;
            case 3:
                nombreTipoObra = "Cuartos para Cocina";
            break;
            case 4:
                nombreTipoObra = "Baños";
            break;
        }
     
        return nombreTipoObra;
    }
    
    public boolean isValidPath(String path) {
    try {
        Paths.get(path);
    } catch (InvalidPathException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
        return true;
    }
}

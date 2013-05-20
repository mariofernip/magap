/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.accesodatos;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author root
 */
public final  class Global {

    //public final static String URL="jdbc:postgresql://172.30.60.87:5432/sisepec";
    public final static String URL="jdbc:postgresql://localhost:5433/inv_magap";
    public final static String DRIVER="org.postgresql.Driver";
    public final static String USER="postgres";
    //public final static String PASS="sisepecdesitel2010";
    public final static String PASS="sql1";

//    //Mails
//    public final static String SISEPECMASTERMAIL = "sisepec@espoch.edu.ec";
//
//    //Mensajes de error
//    public final static String MENSAJEERRORDATOS = "Error al procesar la solicitud, revise los datos";
//    public final static String MENSAJEERRORSESION = "Su sesi&oacute;n ha caducado, reinicie sesi&oacute;n ";
//    public final static String MENSAJEERRORCLAVES = "Las claves no coinciden";
//
//    //Direcciones
//    public final static String DOMINIO="http://sisepec.espoch.edu.ec/";

    
     
//     public  String getDriver()
//     {
//        //return  obtenerPropiedad("conexion.driver");
//         return  "org.postgresql.Driver";
//     }
//     public  String getUsuario()
//     {
//          //return  obtenerPropiedad("conexion.usuario");
//          return  "postgres";
//     }
//     public  String getClave()
//     {
//          //return  obtenerPropiedad("conexion.clave");
//          return  "epecespoch2010";
//     }
//     public  String getURL()
//     {
//          //return  obtenerPropiedad("conexion.url");
//          return  "jdbc:postgresql://127.0.0.1:5432/EPECDB";
//     }
//
//     private String  obtenerPropiedad(String clave)
//     {
//     String res="";
//        Properties prop = new Properties();
//          try {
//              //Para Linux
//              File f = new File("/root/propiedades.properties");
//              FileInputStream fis = new FileInputStream(f);
//             prop.load (fis);
//             res= prop.getProperty(clave).toString();
//             fis.close();
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//        return res;
//     }



}

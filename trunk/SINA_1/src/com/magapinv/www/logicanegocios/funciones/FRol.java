/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Rol;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FRol {
    
     //INSERTA UN ROL DE FUNCIONARIO
    
    public static int insertarRol (Rol rol) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_rol(?)";
    lstpar.add(new Parametro(1,rol.getNombre_rol()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Rol"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
    public static ArrayList<Rol> llenarRol(ConjuntoResultado crs) throws Exception {
        ArrayList<Rol> lstD = new ArrayList<Rol>();
        Rol dls =null;
        try {
            while (crs.next()) {
              dls = new Rol(crs.getInt(0),crs.getString(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Rol> obtenerTodoslosRoles() throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        try {
            String sql = "select * from bodega.rol;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarRol(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
       
       public static Rol obtenerRoles_xcodigo(int codigo) throws Exception {
            Rol fun = new Rol();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigo));        
            try {
                String sql = "Select * from bodega.f_obtener_rol_xcodigo(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarRol(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
       
       
      public static Rol obtenerRoles_xnombre(String nombrerol) throws Exception {
            Rol fun = new Rol();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,nombrerol));        
            try {
                String sql = "Select * from bodega.f_obtener_rol_xnombre(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarRol(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
      
   public static boolean eliminarRol(Rol rol) throws Exception{           
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="DELETE FROM bodega.rol WHERE id_rol=?;";
    lstpar.add(new Parametro(1,rol.getId_rol()));

    try {
            boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);
            
        } catch (Exception ex) {
           throw new Exception("Error al eliminar un Rol"+ex.getMessage());
        }
        return codigo;
} 
   public static Rol actualizarRol_xcodigo(int id_rol,String nombre_rol)throws Exception{
            Rol rol = new Rol();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,id_rol));
                  lstpar.add(new Parametro(2,nombre_rol));   
                      String sql = "select bodega.act_rol(?,?)";
                       boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                      ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                      rol=llenarRol(crs).get(0);
//                      crs = null;
              return rol;
       
   }
}

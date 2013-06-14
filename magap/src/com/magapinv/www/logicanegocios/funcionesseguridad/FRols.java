/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;


import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clasesseguridad.Rols;

import java.sql.SQLException;
import java.util.ArrayList;


public class FRols {
    
    
    public static boolean insertarRol(Rols rol) throws Exception{
        boolean band=false;
        ArrayList<Parametro> lisP =new ArrayList<Parametro>();
        String sql ="select * from seguridad.f_insertar_rol(?,?)";
        lisP.add(new Parametro(1, rol.getId_rol()));
        lisP.add(new Parametro(2, rol.getDescripcion_rol()));
        try {
            ConjuntoResultado crs =AccesoDatos.ejecutaQuery(sql,lisP);
              //if (crs.getString(0).equals("true"));
                band = true;
        } catch (Exception e) {
            throw new Exception("No se pudo insertar el rol");
        }
        return band;
    }
    
    //PERMITE MOSTRAR EL ROL DE UN USUARIO MEDIANTE UN CÓDIGO DETERMINADO
     public static Rols obtenerRolesxCodigo(String codigo) throws Exception{
        Rols rols =null;
        ConjuntoResultado crs =null;
        String sql ="Select * from seguridad.f_obtenertodosroles_xcodigo";                
        ArrayList<Parametro> lstpar =new ArrayList<Parametro>();     
        lstpar.add(new Parametro(1,codigo));
        
         try {
             crs=AccesoDatos.ejecutaQuery(sql,lstpar);
             rols=llenarRoles(crs).get(0);
         } catch (Exception e) {
            throw new Exception("Error al ejecuetar la sentencia");
         }
        return rols;
    }
     
     //PERMITE MOSTRAR EL ROL DE UN USUARIO MEDIANTE UN NOMNBRE DETERMINADO
     public static Rols obtenerRolesxNombre(String nombre) throws Exception{
        Rols rols =null;
        
        ConjuntoResultado crs =null;
        String sql ="SELECT id_rol, descripcion_rol FROM seguridad.rol where descripcion_rol=?";                
        ArrayList<Parametro> lstpar =new ArrayList<Parametro>();     
        lstpar.add(new Parametro(1,nombre));
        
         try {
             crs=AccesoDatos.ejecutaQuery(sql,lstpar);
             while (crs.next()) {                                  
                 rols =new Rols();
                 rols.setId_rol(crs.getString("id_rol"));
                 rols.setDescripcion_rol(nombre);
             }
         } catch (Exception e) {
            throw new Exception("Error al ejecuetar la sentencia");
         }
        return rols;
    }
     //LLENAR ROLES
     public static ArrayList<Rols> llenarRoles(ConjuntoResultado crs) throws Exception {
        ArrayList<Rols> lstR = new ArrayList<Rols>();
        Rols rls =null;
        try {
            while (crs.next()) {
                rls = new Rols(crs.getString("pcodigo"),crs.getString("pnombre"));
                lstR.add(rls);
            }
        } catch (Exception e) {
            lstR.clear();
            throw e;
        }
        return lstR;
    }
     
     
    //PERMITE MOSTRAR TODOS LOS ROLES DE LA BASE DE DATOS
      public static ArrayList<Rols> obtenerTodoslosRoles() throws Exception {
        ArrayList<Rols> lst = new ArrayList<Rols>();
        try {
            String sql = "Select * from seguridad.f_obtenertodosroles()";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarRoles(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   public static boolean actualizarRoles(Rols rols) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from seguridad.actualizar_rol(?,?);";
            lstP.add(new Parametro(1, rols.getDescripcion_rol()));
            lstP.add(new Parametro(2, rols.getId_rol()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}

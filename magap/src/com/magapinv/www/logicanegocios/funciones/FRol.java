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

/**
 *
 * @author User
 */
public class FRol {
    
     //INSERTA UN ROL
    
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
    
}

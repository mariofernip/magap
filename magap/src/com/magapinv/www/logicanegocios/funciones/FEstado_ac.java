/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Estado_ac;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FEstado_ac {
    
     public static int insertarEstado_ac (Estado_ac estado) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_estado_ac(?)";
    lstpar.add(new Parametro(1,estado.getNombre_estado()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Estado"+ex.getMessage());
        }
    
    return codigo;
    }
    
     
      public static ArrayList<Estado_ac> llenarEstado_ac(ConjuntoResultado crs) throws Exception {
        ArrayList<Estado_ac> lstD = new ArrayList<Estado_ac>();
        Estado_ac dls =null;
        try {
            while (crs.next()) {
              dls = new Estado_ac(crs.getInt(0),crs.getString(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Estado_ac> obtenerTodoslosEstado_ac() throws Exception {
        ArrayList<Estado_ac> lst = new ArrayList<Estado_ac>();
        try {
            String sql = "select * from bodega.estado_ac;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarEstado_ac(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
      public static Estado_ac obtenerEstado_ac_xcodigo(int codigoe) throws Exception {
            Estado_ac est = new Estado_ac();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigoe));        
            try {
                String sql = "Select * from bodega.f_obtener_estado_ac_xcodigo(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                est=llenarEstado_ac(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return est;
    }
     
}

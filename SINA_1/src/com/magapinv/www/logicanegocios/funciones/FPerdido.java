/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Perdido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FPerdido {
    
     public static int insertarPerdido (Perdido per) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_perdido(?,?)";
    lstpar.add(new Parametro(1,per.getFecha_perdida()));
    lstpar.add(new Parametro(2,per.getId_perdido()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Elemento perdido"+ex.getMessage());
        }
    
    return codigo;
    }
    
     
      public static ArrayList<Perdido> llenarPerdido(ConjuntoResultado crs) throws Exception {
        ArrayList<Perdido> lstD = new ArrayList<Perdido>();
        Perdido dls =null;
        try {
            while (crs.next()) {
              dls = new Perdido(crs.getDate(1),crs.getInt(2));              
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Perdido> obtenerTodoslosEstado_ac() throws Exception {
        ArrayList<Perdido> lst = new ArrayList<Perdido>();
        try {
            String sql = "select * from bodega.perdido;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarPerdido(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
     
    
     
}

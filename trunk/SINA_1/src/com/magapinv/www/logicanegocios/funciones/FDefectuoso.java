/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Defectuoso;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FDefectuoso {
     
    public static int insertarDefectuso (Defectuoso def) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_defectuoso(?,?)";
    lstpar.add(new Parametro(1,def.getObservacion()));
    lstpar.add(new Parametro(2,def.getId_estado()));
    
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Elemento defectuoso"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
    public static ArrayList<Defectuoso> llenarDefectuoso(ConjuntoResultado crs) throws Exception {
        ArrayList<Defectuoso> lstD = new ArrayList<Defectuoso>();
        Defectuoso dls =null;
        try {
            while (crs.next()) {
              dls = new Defectuoso(crs.getString(0),crs.getInt(1));              
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Defectuoso> obtenerTodoslosEstado_ac() throws Exception {
        ArrayList<Defectuoso> lst = new ArrayList<Defectuoso>();
        try {
            String sql = "select * from bodega.defectuoso;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarDefectuoso(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
     
    
    
}

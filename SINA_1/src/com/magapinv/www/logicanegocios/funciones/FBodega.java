/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Bodega;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FBodega {
    public static boolean insertarbodega(Bodega bod) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_bodega(?,?)";
    lstpar.add(new Parametro(1,bod.getUbicacion()));
    lstpar.add(new Parametro(2,bod.getFecha_creacion()));
    try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getBoolean(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una nueva bodega"+ex.getMessage());
        }
        return codigo;
    }
   public static boolean eliminarbodega(Bodega bod) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="DELETE FROM bodega.bodega WHERE id_bodega=?;";
    lstpar.add(new Parametro(1,bod.getId_bodega()));

    try {
            boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);
           
        } catch (Exception ex) {
           throw new Exception("Error al eliminar una bodega"+ex.getMessage());
        }
        return codigo;
    }
    
    public static ArrayList<Bodega> llenarbodega(ConjuntoResultado crs) throws Exception {
        ArrayList<Bodega> lstD = new ArrayList<Bodega>();
        Bodega dls =null;
        try {
            while (crs.next()) {
              dls = new Bodega(crs.getInt(0),crs.getString(1),crs.getDate(2));
              lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Bodega> obtenerTodaslasbodegas() throws Exception {
        ArrayList<Bodega> lst = new ArrayList<Bodega>();
        try {
            String sql = "select * from bodega.bodega;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarbodega(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Bodega obtenerBodega_xcodigo(int ubi) throws Exception {
            Bodega fun = new Bodega();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,ubi));        
            try {
                String sql = "Select * from bodega.bodega where id_bodega=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarbodega(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
     
     
     //obtenerBodega_xnombre
     
       public static Bodega obtenerBodega_xnombre(String ubi) throws Exception {
            Bodega fun = new Bodega();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,ubi));        
            try {
                String sql = "Select * from bodega.sel_bod_ubicacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarbodega(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    } 
     
        public static void actualizar_Bodega_xnombre(String nombre,String nnombre_, Date fecha)throws Exception{
            Bodega bod = new Bodega();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,nombre));
                  lstpar.add(new Parametro(2,nnombre_)); 
                   lstpar.add(new Parametro(3,fecha));                                   
                      String sql = "select bodega.act_bodega(?,?,?)";
                      boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                      bod=llenarbodega(crs).get(0);
//                      crs = null;
              //return bod;            
   }
}

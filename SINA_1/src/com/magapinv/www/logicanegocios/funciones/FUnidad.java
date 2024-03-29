/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Unidad;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FUnidad {
    public static int insertarunidad (Unidad uni) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_unidad(?,?,?)";
    lstpar.add(new Parametro(1,uni.getUbicacion_unidad()));
    lstpar.add(new Parametro(2,uni.getNombre_unidad()));
    lstpar.add(new Parametro(3,uni.getFuncion_unidad()));
     
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una Unidad"+ex.getMessage());
        }
    
    return codigo;
    }
    
     public static ArrayList<Unidad> llenarunidades(ConjuntoResultado crs) throws Exception {
        ArrayList<Unidad> lstD = new ArrayList<Unidad>();
        Unidad dls =null;
        try {
            while (crs.next()) {
              dls = new Unidad(crs.getInt(0),crs.getString(1),crs.getString(2),crs.getString(3));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
    public static ArrayList<Unidad> obtenerTodoaslas_unidades() throws Exception {
        ArrayList<Unidad> lst = new ArrayList<Unidad>();
        try {
            String sql = "select * from bodega.unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarunidades(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Unidad obtenerUnidad_xnombre(String nom) throws Exception {
            Unidad uni = new Unidad();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,nom)); 
                      try {
                String sql = "Select * from bodega.sel_unidad_nombr(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                uni=llenarunidades(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return uni;
    }
    
    
    public static boolean eliminarUnidad(Unidad uni) throws Exception{           
        boolean codigo=false;
        ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
        lstpar.add(new Parametro(1,uni.getId_unidad()));
        String sql ="DELETE FROM bodega.unidad WHERE id_unidad=?;";
        try {
                boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);       
            } catch (Exception ex) {
               throw new Exception("Error al eliminar una Unidad"+ex.getMessage());
            }
            return codigo;
    } 
    
    public static Unidad actualizarUnidad_xcodigo(String oldNombre_uni,String ubicacion_uni, String nombre_uni, String funcion_uni)throws Exception{
              Unidad uni = new Unidad();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,oldNombre_uni));
                  lstpar.add(new Parametro(2,ubicacion_uni));
                  lstpar.add(new Parametro(3,nombre_uni));
                  lstpar.add(new Parametro(4,funcion_uni));                 
                      String sql = "select bodega.act_uni_nombre(?,?,?,?)";
                      boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                      ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                      uni=llenarunidades(crs).get(0);
//                      crs = null;
              return uni;
    }
}


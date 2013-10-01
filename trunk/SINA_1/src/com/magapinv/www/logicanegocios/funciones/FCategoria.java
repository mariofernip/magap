/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Bodega;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Categoria;
import com.magapinv.www.logicanegocios.clases.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FCategoria {
    
     
    public static boolean insertarCategorias (Categoria cat) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_categoria(?)";
    lstpar.add(new Parametro(1,cat.getNombre_categoria()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            
            while (cres.next()){
                codigo=cres.getBoolean(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una Categoria"+ex.getMessage());
        }
    
    return codigo;
    }
    
    public static ArrayList<Categoria> llenarcategoria(ConjuntoResultado crs) throws Exception {
        ArrayList<Categoria> lstD = new ArrayList<Categoria>();
        Categoria dls =null;
        try {
            while (crs.next()) {
              dls = new Categoria(crs.getInt(0),crs.getString(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Categoria> obtenerTodaslascategorias() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from bodega.categoria";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarcategoria(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    //obtenerCategoria_xcodigo recibe el nombre devuelve el codigo
    public static Categoria obtenerCategoria_xcodigo(int n_cat) throws Exception {
            Categoria cat = new Categoria();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,n_cat));        
            try {
                String sql = "Select * from bodega.categoria where id_categoria=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                cat=llenarcategoria(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
               // throw new Exception(exConec.getMessage());
              }
        return cat;
    }
    
    public static Categoria obtenerCategoria_xnombre(String n_cat) throws Exception {
            Categoria cat = new Categoria();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,n_cat));        
            try {
                String sql = "Select * from bodega.f_obtener_categoria_xnombre(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                cat=llenarcategoria(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return cat;
    }
    
   
public static boolean eliminarCategoria(Categoria cat) throws Exception{           
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="DELETE FROM bodega.categoria WHERE id_categoria=?;";
    lstpar.add(new Parametro(1,cat.getId_categoria()));
    try {
          boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);   
//        while (cres.next()){
//                codigo=cres.getBoolean(0);
//            }
        } catch (Exception ex) {
           throw new Exception("Error al eliminar una categoria"+ex.getMessage());
        }
        return codigo;
} 

public static Categoria actualizarCategoria_xcodigo(int id_cate,String nombre_cate) throws Exception{
    //ArrayList<Categoria> lstD = new ArrayList<Categoria>();
        Categoria dls =null;
        //Categoria cat = new Categoria();
             ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
             lstpar.add(new Parametro(1,id_cate));
             lstpar.add(new Parametro(2,nombre_cate));   
                 String sql = "select bodega.act_categoria(?,?)";
                  boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                 dls=llenarcategoria(crs).get(0);
//                 crs = null;   
         return dls;
   }
    
}

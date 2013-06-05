/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Categoria;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FCategoria {
    
     
    public static int insertarCategorias (Categoria cat) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_categoria(?)";
    lstpar.add(new Parametro(1,cat.getNombre_categoria()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
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
                String sql = "Select * from bodega.sel_cat_nombre(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                cat=llenarcategoria(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return cat;
    }
    
    public static Categoria  obtenerCategoria_xnombre(String n_cat) throws Exception {
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
    
   
            
}

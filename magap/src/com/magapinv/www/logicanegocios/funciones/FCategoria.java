/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Categoria;
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
              dls = new Categoria(crs.getString(0),crs.getString(1));
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
            String sql = "select * from bodega.listar_categoria()";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarcategoria(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}

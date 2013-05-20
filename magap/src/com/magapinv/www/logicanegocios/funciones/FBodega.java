/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Bodega;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FBodega {
    public static int insertarbodega(Bodega bod) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_bodega(?,?)";
    lstpar.add(new Parametro(1,bod.getUbicacion()));
    lstpar.add(new Parametro(2,bod.getFecha_creacion()));
    try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una nueva bodega"+ex.getMessage());
        }
        return codigo;
    }
    
    public static ArrayList<Bodega> llenarbodega(ConjuntoResultado crs) throws Exception {
        ArrayList<Bodega> lstD = new ArrayList<Bodega>();
        Bodega dls =null;
        try {
            while (crs.next()) {
              dls = new Bodega(crs.getString(0),crs.getString(1),crs.getDate(2));
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
            String sql = "select * from bodega.listar_bodega;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarbodega(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
}

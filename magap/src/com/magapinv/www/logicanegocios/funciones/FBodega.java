/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Bodega;
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
            String sql = "select * from bodega.listar_bodega;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarbodega(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Bodega obtenerBodega_xcodigo(int codigob) throws Exception {
            Bodega fun = new Bodega();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigob));        
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
}

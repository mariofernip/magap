/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Unidad;
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
    lstpar.add(new Parametro(1,uni.getNombre_unidad()));
    lstpar.add(new Parametro(1,uni.getFuncion_unidad()));
     
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
     public static ArrayList<Unidad> llenarunidades(ConjuntoResultado crs) throws Exception {
        ArrayList<Unidad> lstD = new ArrayList<Unidad>();
        Unidad dls =null;
        try {
            while (crs.next()) {
              dls = new Unidad(crs.getString(0),crs.getString(1),crs.getString(2),crs.getString(3));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Unidad> obtenerTodoslostip_movimientos() throws Exception {
        ArrayList<Unidad> lst = new ArrayList<Unidad>();
        try {
            String sql = "select * from bodega.listar_unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarunidades(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}

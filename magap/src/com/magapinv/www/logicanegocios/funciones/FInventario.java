/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Inventario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FInventario {
    
    public static int insertarInventario (Inventario inv) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    //lstpar.add(new Parametro(1,inv.getId_inventario()));
    lstpar.add(new Parametro(1,inv.getId_equipo()));
    lstpar.add(new Parametro(2,inv.getMarca()));
    lstpar.add(new Parametro(3,inv.getModelo()));
    lstpar.add(new Parametro(4,inv.getDescripcion()));
    lstpar.add(new Parametro(5,inv.getId_bodega().getId_bodega()));
    lstpar.add(new Parametro(6,inv.getId_categoria().getId_categoria()));
    lstpar.add(new Parametro(7,inv.getId_bodega().getId_bodega())); 
    lstpar.add(new Parametro(8,inv.getStock()));
    String sql ="Select * from bodega.insert_inventario(?,?,?,?,?,?,?,?)";
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Inventario"+ex.getMessage());
        }
     
    return codigo;
    }
    
     public static ArrayList<Inventario> llenarInventario(ConjuntoResultado crs) throws Exception {
        ArrayList<Inventario> lstD = new ArrayList<Inventario>();
        Inventario dls =null;
        try {
            while (crs.next()) {
     dls = new Inventario(crs.getInt(0),crs.getString(1),crs.getString(2),crs.getString(3),crs.getString(4),FEstado_ac.obtenerEstado_ac_xcodigo(crs.getInt(5)),FCategoria.obtenerCategoria_xcodigo(crs.getInt(6)),FBodega.obtenerBodega_xcodigo(crs.getString(7)), crs.getInt(8));
              lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Inventario> obtenerTodaslasbodegas() throws Exception {
        ArrayList<Inventario> lst = new ArrayList<Inventario>();
        try {
            String sql = "select * from bodega.inventario;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarInventario(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Inventario obtenerInventario_xcodigo(int codigoi) throws Exception {
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigoi));        
            try {
                String sql = "Select * from bodega.f_obtener_inventario_xcodigo(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarInventario(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Movimientos;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FMovimientos {
    public static int insertarmovimientos (Movimientos movi) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_movimientos(?)";
    lstpar.add(new Parametro(1,movi.getObservacion()));
     
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un movimiento"+ex.getMessage());
        }
    
    return codigo;
    }
    public static ArrayList<Movimientos> llenarmovimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Movimientos> lstD = new ArrayList<Movimientos>();
        Movimientos dls =null;
        try {
            while (crs.next()) {
              dls = new Movimientos(crs.getInt(0),crs.getString(1),crs.getString(2));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Movimientos> obtenerTodoslosmovimientos() throws Exception {
        ArrayList<Movimientos> lst = new ArrayList<Movimientos>();
        try {
            String sql = "select * from bodega.listar_movimientos;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarmovimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     public static Movimientos obtenerMovimiento_xcodigo(int id) throws Exception {
            Movimientos man = new Movimientos(0, null, null);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id)); 
                      try {
                String sql = "Select * from bodega.sel_movimientos_observacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                man=llenarmovimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return man;
    }
}

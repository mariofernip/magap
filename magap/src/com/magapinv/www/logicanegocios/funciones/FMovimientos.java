/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Movimiento;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FMovimientos {
    public static int insertarmovimientos (Movimiento movi) throws Exception{
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
    public static ArrayList<Movimiento> llenarmovimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Movimiento> lstD = new ArrayList<Movimiento>();
        Movimiento dls =null;
        try {
            while (crs.next()) {
              dls = new Movimiento(crs.getString(0),crs.getString(1));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Movimiento> obtenerTodoslosmovimientos() throws Exception {
        ArrayList<Movimiento> lst = new ArrayList<Movimiento>();
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
}

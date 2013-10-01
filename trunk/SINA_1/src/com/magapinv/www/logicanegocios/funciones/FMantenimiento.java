/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Mantenimiento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FMantenimiento {
    
    public static int insertarMantenimiento (Mantenimiento man) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_mantenimiento(?,?,?,?,?)";
    lstpar.add(new Parametro(1,man.getEncargadomant()));
    lstpar.add(new Parametro(2,man.getFecha_ingreso()));
    lstpar.add(new Parametro(3,man.getFecha_salida()));
    lstpar.add(new Parametro(4,man.getDescripcion_danio()));
    lstpar.add(new Parametro(5,man.getId_estado()));  
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(5);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario Mantenimiento"+ex.getMessage());
        }
    
    return codigo;
    }
    
     public static ArrayList<Mantenimiento> llenarMantenimiento(ConjuntoResultado crs) throws Exception {
        ArrayList<Mantenimiento> lstD = new ArrayList<Mantenimiento>();
        Mantenimiento dls =null;
        try {
            while (crs.next()) {
              dls = new Mantenimiento(crs.getString(0),crs.getDate(1),crs.getDate(2),crs.getString(3),crs.getInt(4));              
              lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Mantenimiento> obtenerTodosMantenimiento() throws Exception {
        ArrayList<Mantenimiento> lst = new ArrayList<Mantenimiento>();
        try {
            String sql = "select * from bodega.mantenimiento;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarMantenimiento(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
     
    public static Mantenimiento obtenerMantenimiento_xcodigo(int id) throws Exception {
            Mantenimiento man = new Mantenimiento();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id)); 
                      try {
                String sql = "Select * from bodega.sel_movimientos_observacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                man=llenarMantenimiento(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return man;
    }
    
}

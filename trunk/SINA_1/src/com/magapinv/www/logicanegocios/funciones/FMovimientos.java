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
    public static boolean insertarmovimientos (Movimientos movi) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    lstpar.add(new Parametro(1,movi.getObservacion()));
    lstpar.add(new Parametro(2,movi.getTipo_mov())); 
    lstpar.add(new Parametro(3,movi.getFecha())); 
    String sql ="Select * from bodega.insert_movimientos(?,?,?)";
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            while (cres.next()){
                codigo=cres.getBoolean(0);
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
              dls = new Movimientos(crs.getInt(0),crs.getString(1),crs.getInt(2),crs.getDate(3));
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
            String sql = "select * from bodega.movimientos;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarmovimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Movimientos obtenerMovimiento_xdescripcion(String obs) throws Exception{
            Movimientos fun = new Movimientos();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,obs));        
            try {
                String sql = "Select * from bodega.movimientos where observacion=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarmovimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
   
        public static Movimientos obtenerMovimiento_xcodigo(int cod) throws Exception{
            Movimientos fun = new Movimientos();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cod));        
            try {
                String sql = "Select * from bodega.movimientos where id_movimiento=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarmovimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
     
      public static void actualizar_Movimiento_xcodigo(int id_movi,String nombre, int id_tip_movi)throws Exception{
            Movimientos bod = new Movimientos();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,id_movi));
                  lstpar.add(new Parametro(2,nombre));
                  lstpar.add(new Parametro(3,id_tip_movi));                  
                      String sql = "select bodega.act_movimientos(?,?,?)";
                      ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                      bod=llenarmovimientos(crs).get(0);
                      crs = null;
              //return bod;            
   }
      public static Integer ultimo_mov() throws Exception{
            Movimientos fun = new Movimientos();
           try {
                String sql = "Select * from bodega.obtener_ult_mov()";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
                fun=llenarmovimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun.getId_movimiento();
    }
      
}

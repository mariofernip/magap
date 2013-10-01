/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Tipo_Movimiento;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FTipo_Movimiento {
    public static int insertartipo_mov (Tipo_Movimiento t_movi) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_tipo_mov(?)";
    lstpar.add(new Parametro(1,t_movi.getTipomovimiento()));
     
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un tipo de Movimiento"+ex.getMessage());
        }
    
    return codigo;
    }   
    
      public static ArrayList<Tipo_Movimiento> llenartip_movimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Tipo_Movimiento> lstD = new ArrayList<Tipo_Movimiento>();
        Tipo_Movimiento dls =null;
        try {
            while (crs.next()) {
              dls = new Tipo_Movimiento(crs.getInt(0),crs.getString(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    
    
    public static ArrayList<Tipo_Movimiento> obtenerTodoslostip_movimientos() throws Exception {
        ArrayList<Tipo_Movimiento> lst = new ArrayList<Tipo_Movimiento>();
        try {
            String sql = "select * from bodega.tipo_movimiento;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenartip_movimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Tipo_Movimiento obtenertipo_movimiento_xnombre(String desc) throws Exception {
            Tipo_Movimiento tmov = new Tipo_Movimiento();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,desc));        
            try {
                String sql = "Select * from bodega.sel_timovimiento_tipo(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                tmov=llenartip_movimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return tmov;
    }
    
    public static Tipo_Movimiento obtenertipo_movimiento_xcodigo(int cod) throws Exception {
            Tipo_Movimiento tmov = new Tipo_Movimiento();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cod));        
            try {
                String sql = "Select * from bodega.tipo_movimiento where id_movimiento=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                tmov=llenartip_movimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return tmov;
    }
    
    public static Tipo_Movimiento actualizarTipoMovimiento_xnombre(int id_tipomov,String nombre_tipomov)throws Exception{
            Tipo_Movimiento tip = new Tipo_Movimiento();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,id_tipomov));
                  lstpar.add(new Parametro(2,nombre_tipomov));   
                      String sql = "select bodega.act_tipo_mov(?,?)";
                      boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                      ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                      tip=llenartip_movimientos(crs).get(0);
//                      crs = null;
              return tip;
       
   }
 
    
    public static boolean eliminarTipoMovimiento(Tipo_Movimiento tip) throws Exception{           
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="DELETE FROM bodega.tipo_movimiento WHERE tipo_movimento=?;";
    lstpar.add(new Parametro(1,tip.getTipomovimiento()));
    try {
          boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);   
//        while (cres.next()){
//                codigo=cres.getBoolean(0);
//            }
        } catch (Exception ex) {
           throw new Exception("Error al eliminar tipo movimiento"+ex.getMessage());
        }
        return codigo;
} 
}


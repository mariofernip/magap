/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Detalle_Mov;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FDetalle_Mov {
     public static boolean  insertardetalle_mov(Detalle_Mov mov) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    lstpar.add(new Parametro(1,mov.getId_mov()));
    lstpar.add(new Parametro(2,mov.getEncargado()));
    //lstpar.add(new Parametro(3,mov.getNuevo_encargado()));
    lstpar.add(new Parametro(3,mov.getId_inventario()));
    lstpar.add(new Parametro(4,mov.getCant()));
    lstpar.add(new Parametro(5,mov.getVerificador()));
    
    String sql ="Select * from bodega.insert_detallemov(?,?,?,?,?)";
    
    try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getBoolean(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Detalle de Movimiento"+ex.getMessage());
        }
        return codigo;
    }
     
    public static ArrayList<Detalle_Mov> llenardetalle_mov(ConjuntoResultado crs) throws Exception {
        ArrayList<Detalle_Mov> lstD = new ArrayList<Detalle_Mov>();
       Detalle_Mov dls =null;
        try {
            while (crs.next()) {
              dls = new Detalle_Mov(crs.getInt(0),crs.getString(1),crs.getInt(2),crs.getInt(3),crs.getInt(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    
    public static ArrayList<Detalle_Mov> obtenerdetalles_mov_ced(String ced) throws Exception { 
        ArrayList<Detalle_Mov> lst = new ArrayList<Detalle_Mov>(); 
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>(); 
        try { lstpar.add(new Parametro(1,ced)); 
        String sql = "select * from bodega.detalle_mov where encargado=?;"; 
        ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar); 
        lst=llenardetalle_mov(crs); 
        crs = null; } 
        catch (SQLException exConec) 
    { throw new Exception(exConec.getMessage()); } return lst; }
    
    public static ArrayList<Detalle_Mov> obtenerdetalles_mov() throws Exception {
        ArrayList<Detalle_Mov> lst = new ArrayList<Detalle_Mov>();
        try {
            String sql = "select * from bodega.listar_detallemov;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenardetalle_mov(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     public static Detalle_Mov obtenerdet_ced_inv(String cedula, Integer id) throws Exception {
            Detalle_Mov det = new Detalle_Mov();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cedula));
            lstpar.add(new Parametro(2,id));
                      try {
                String sql = "select * from bodega.f_obtener_det_movcant(?,?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                det=llenardetalle_mov(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return det;
    }
     
     public static Detalle_Mov actualizarencargado(String funcionario,int inventario) throws Exception{
            Detalle_Mov cat = new Detalle_Mov();
             ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
             lstpar.add(new Parametro(1,funcionario));
             lstpar.add(new Parametro(2,inventario));   
                 String sql = "select bodega.act_detalle_mov_verificador(?,?);";
                 boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                 cat=llenarcategoria(crs).get(0);
//                 crs = null;   
         return cat;
        
   }
}

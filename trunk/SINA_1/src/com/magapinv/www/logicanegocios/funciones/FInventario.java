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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    lstpar.add(new Parametro(5,inv.getId_estado().getId_estado()));
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
                dls = new Inventario(crs.getInt(0),crs.getString(1),crs.getString(2),crs.getString(3),crs.getString(4),FEstado_ac.obtenerEstado_ac_xcodigo(crs.getInt(5)),FCategoria.obtenerCategoria_xcodigo(crs.getInt(6)),FBodega.obtenerBodega_xcodigo(crs.getInt(7)), crs.getInt(8));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
    public static ArrayList<Inventario> obtenertodoslosInventarios() throws Exception {
        ArrayList<Inventario> lst = new ArrayList<Inventario>();
        try {
            String sql = "SELECT id_inventario, id_equipo, marca, modelo, descripcion, id_estado, id_categoria, id_bodega, stock_inventario FROM bodega.inventario;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarInventario(crs);
            //crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
       public static ArrayList<Inventario> obtenertodoslosInventarios_stock() throws Exception {
        ArrayList<Inventario> lst = new ArrayList<Inventario>();
        try {
            String sql = "SELECT id_inventario, id_equipo, marca, modelo, descripcion, id_estado, id_categoria, id_bodega, stock_inventario FROM bodega.inventario where id_categoria=2 and stock_inventario<10 ";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarInventario(crs);
            //crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static Inventario obtenerInventario_xcodigoEquipo(String codigoe) throws Exception {
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigoe));        
            try {
                String sql = "Select * from bodega.inventario where id_equipo=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarInventario(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }

    public static Inventario actualizarInventario_stock_xcodigoEquipo(String id_eq,int cant) throws Exception {
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));     
            lstpar.add(new Parametro(2,cant));
          
            try {
                String sql = "Select * from bodega.act_inventario_stock(?,?)";
                 boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
    
   public static Inventario actualizarInventario_xcodigoEquipo(String id_eq, String marca,String modelo,String descripcion, int id_estado, int id_categoria, int id_bodega, int stock, String nid_eq)throws Exception{
            Inventario fun = new Inventario();
             ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
             lstpar.add(new Parametro(1,id_eq));     
             lstpar.add(new Parametro(2,marca));
             lstpar.add(new Parametro(3,modelo));
             lstpar.add(new Parametro(4,descripcion));
             lstpar.add(new Parametro(5,id_estado));
             lstpar.add(new Parametro(6,id_categoria));
             lstpar.add(new Parametro(7,id_bodega));
             lstpar.add(new Parametro(8,stock)); 
             lstpar.add(new Parametro(9,nid_eq)); 
             try {
                 String sql = "Select * from bodega.act_inventario(?,?,?,?,?,?,?,?,?)";
                  boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
                  } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
//                 fun=llenarInventario(crs).get(0);
//                 crs = null;   
         return fun;
        
   }
   
   public static Inventario obtenerInventario_xcodigoEquipo_p(String codigoe) throws Exception {
            Inventario inv = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigoe));        
            try {
                String sql = "Select * from bodega.f_obtener_inventario_xcodigoequipo_p(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                inv=llenarInventario(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return inv;
    }
   
   public static Inventario actualizarInventario_estado_xcodigoEquipo(String id_eq,int estado)throws Exception {
    Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));
            lstpar.add(new Parametro(2,estado));         
            try {
                String sql = "select bodega.act_inventario_estado(?,?);";
                boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
}    
    
   
   public static Inventario actualizarInventario_solo_estado_xcodigoEquipo(String id_eq,int estado)throws Exception {
    Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));
            lstpar.add(new Parametro(2,estado));     
            try {
                String sql = "select bodega.act_inventario_solo_estado(?,?);";
                 boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
}    
   
public static Inventario actualizarInventario_estado_xcodigoEquipo(String id_eq,int estado, int num_art_per)throws Exception {
    Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));
            lstpar.add(new Parametro(2,estado));
            lstpar.add(new Parametro(3,num_art_per));      
            try {
                String sql = "select bodega.act_inventario_estado(?,?,?);";
                boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
}    
    
        public static Inventario actualizarInventario_estado_stock_xcodigoEquipo(String id_eq, int estado, int numero) throws Exception {
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));     
            lstpar.add(new Parametro(2,estado));
            lstpar.add(new Parametro(3,numero));
           
            try {
                String sql = "Select * from bodega.act_inventario_estado_stock_perdido(?,?,?)";
                 boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
        
          
        public static Inventario actualizarInventario_estado_stock_xcodigoEquipo_baja(String id_eq, int estado) throws Exception {
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,id_eq));     
            lstpar.add(new Parametro(2,estado));
            try {
                String sql = "Select * from bodega.act_inventario_estado_stock_baja(?,?)";
                boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
        
    public static Inventario obtenerInventario_xcodigo(int codigoi) throws Exception {
//            Inventario fun = new Inventario();
//            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
//            lstpar.add(new Parametro(1,codigoi));        
//            try {
//                String sql = "Select * from bodega.f_obtener_inventario_xcodigo(?)";
//                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
//                fun=llenarInventario(crs).get(0);
//                crs = null;
//            } catch (SQLException exConec) {
//                throw new Exception(exConec.getMessage());
//              }
//        return fun;
        
            Inventario fun = new Inventario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigoi));        
            try {
                String sql = "Select * from bodega.inventario where id_inventario=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarInventario(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
               // throw new Exception(exConec.getMessage());
              }
        return fun;
        
        
    }
    
        public static boolean eliminarInventario(Inventario inv) throws Exception{           
        boolean codigo=false;
        ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
        String sql ="DELETE FROM bodega.inventario WHERE id_equipo=?;";
        lstpar.add(new Parametro(1,inv.getId_equipo()));

        try {
               boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);
//               while (cres.next()){
//                    codigo=cres.getBoolean(0);
//                }
            } catch (Exception ex) {
               throw new Exception("Error al eliminar un Inventario"+ex.getMessage());
            }
            return codigo;
    } 
}

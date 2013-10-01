/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario_Rol;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FFuncionario_Rol {
    
        
        public static int insertarFuncionarioRol (Funcionario_Rol funr) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    lstpar.add(new Parametro(1,funr.getNumero_cedula().getCedula()));
    lstpar.add(new Parametro(2,funr.getId_rol().getId_rol()));
    lstpar.add(new Parametro(3,funr.getFecha_asignacion()));
    lstpar.add(new Parametro(4,funr.getFecha_salida()));
    lstpar.add(new Parametro(5,funr.getPassword()));
    String sql ="Select * from bodega.insert_funcionario_rol(?,?,?,?,?)";
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario Rol"+ex.getMessage());
        }
    
    return codigo;
    }
    
     
    public static ArrayList<Funcionario_Rol> llenarFuncionario_Rol(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario_Rol> lstD = new ArrayList<Funcionario_Rol>();
        Funcionario_Rol dls =null;
        try {
            while (crs.next()) {
    dls = new Funcionario_Rol(FFuncionario.obtenerFuncionario_xcodigo((crs.getString(0))),FRol.obtenerRoles_xcodigo((crs.getInt(1))),crs.getDate(2),crs.getDate(3),crs.getString(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Funcionario_Rol> obtenerTodoslosFuncionariosRol() throws Exception {
        ArrayList<Funcionario_Rol> lst = new ArrayList<Funcionario_Rol>();
        try {
            String sql = "select * from bodega.funcionario_rol;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarFuncionario_Rol(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
    
    public static Funcionario_Rol actualizarFuncionario_Rol_xrol(String cedula,int id_rol,int nid_rol, Date fecha, Date fechasalida,String pass)throws Exception{
            Funcionario_Rol fur = new Funcionario_Rol();
                  ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
                  lstpar.add(new Parametro(1,cedula));
                  lstpar.add(new Parametro(2,id_rol)); 
                   lstpar.add(new Parametro(3,nid_rol));
                  lstpar.add(new Parametro(4,fecha));
                  lstpar.add(new Parametro(5,fechasalida)); 
                  lstpar.add(new Parametro(6,pass));
                   
                      String sql = "select bodega.act_funcionario_rol(?,?,?,?,?,?)";
                       boolean crs = AccesoDatos.ejecutaComando(sql,lstpar);
//                      fur=llenarFuncionario_Rol(crs).get(0);
//                      crs = null;
              return fur;            
   }
    
     public static Funcionario_Rol obtenerFuncionarioRol_xcodigo(String codigo, int rolfun) throws Exception {
            Funcionario_Rol fun = new Funcionario_Rol();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigo));
            lstpar.add(new Parametro(2,rolfun));
            try {
                String sql = "Select * from bodega.funcionario_rol where numero_cedula=? and id_rol=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarFuncionario_Rol(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
     
      public static Funcionario_Rol obtener_rol (String cedula,String pass) throws Exception {
           Funcionario_Rol frol = new Funcionario_Rol();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cedula));
            lstpar.add(new Parametro(2,pass));
                try {
                String sql = "Select * from bodega.f_obtener_funcionario_rol_xcodigo(?,?);";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                frol=FFuncionario_Rol.llenarFuncionario_Rol(crs).get(0);
                crs = null;
                } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return frol ;
    }
         
    public static boolean eliminarFuncionarioRol(String cedula,int id_rol) throws Exception{           
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    lstpar.add(new Parametro(1,cedula));
    lstpar.add(new Parametro(2,id_rol));
    String sql ="DELETE from bodega.funcionario_rol WHERE numero_cedula=? and id_rol=?;";
    
    try {
          boolean cres = AccesoDatos.ejecutaComando1(sql,lstpar);   
//        while (cres.next()){
//                codigo=cres.getBoolean(0);
//            }
        } catch (Exception ex) {
           throw new Exception("Error al eliminar una categoria"+ex.getMessage());
        }
        return codigo;
} 
         
       public static Funcionario_Rol obtenerFuncionarioRol_xcodigo_reporte(String codigo) throws Exception {
            Funcionario_Rol fun = new Funcionario_Rol();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,codigo));   
            try {
                String sql = "Select * from bodega.funcionario_rol where numero_cedula=?";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarFuncionario_Rol(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }   
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario_Rol_Bodega;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FFuncionario_Rol_Bodega {
    
    public static int insertarFuncionarioRolBodega (Funcionario_Rol_Bodega funrb) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_funcionario_rol_bodega(?,?,?,?)";
    lstpar.add(new Parametro(1,funrb.getNumero_cedula()));
    lstpar.add(new Parametro(2,funrb.getId_bodega()));
    lstpar.add(new Parametro(3,funrb.getFecha_ingreso()));
    lstpar.add(new Parametro(4,funrb.getFecha_salida())); 
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario Rol Bodega"+ex.getMessage());
        }
    
    return codigo;
    }
    
    public static ArrayList<Funcionario_Rol_Bodega> llenarFuncionario_Rol_Bodega(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario_Rol_Bodega> lstD = new ArrayList<Funcionario_Rol_Bodega>();
        Funcionario_Rol_Bodega dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario_Rol_Bodega(FFuncionario.obtenerFuncionarios_xcodigo((crs.getInt(0))),FFuncionario.obtenerBodega_xcodigo((crs.getInt(0))),crs.getDate(2),crs.getDate(3));
              // Funcionario numero_cedula, Bodega id_bodega, Date fecha_ingreso, Date fecha_salida
              lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Funcionario_Rol_Bodega> obtenerTodoslosRoles() throws Exception {
        ArrayList<Funcionario_Rol_Bodega> lst = new ArrayList<Funcionario_Rol_Bodega>();
        try {
            String sql = "select * from bodega.funcionario_rol_bodega;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarFuncionario_Rol_Bodega(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
    
    
}

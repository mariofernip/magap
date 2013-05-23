/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario_Rol;
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
    String sql ="Select * from bodega.insert_funcionario_rol(?,?,?,?)";
    lstpar.add(new Parametro(1,funr.getNumero_cedula()));
    lstpar.add(new Parametro(2,funr.getId_rol()));
    lstpar.add(new Parametro(3,funr.getFecha_asignacion()));
    lstpar.add(new Parametro(4,funr.getFecha_salida())); 
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
              dls = new Funcionario_Rol(FFuncionario.obtenerFuncionario_xcodigo((crs.getString(0))),FRol.obtenerRoles_xcodigo((crs.getInt(1))),crs.getDate(2),crs.getDate(3));
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
    
    
}

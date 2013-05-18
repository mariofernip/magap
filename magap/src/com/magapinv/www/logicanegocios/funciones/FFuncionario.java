/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FFuncionario {
    
     public static int insertarFuncionario (Funcionario fun) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_funcionario(?)";
    lstpar.add(new Parametro(1,fun.getCedula()));
    lstpar.add(new Parametro(2,fun.getNombres()));
    lstpar.add(new Parametro(3,fun.getApellidos()));
    lstpar.add(new Parametro(3,fun.getNumerostelefonicos()));
    lstpar.add(new Parametro(4,fun.getCorreo()));
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
    public static ArrayList<Funcionario> llenarFuncionarios(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario> lstD = new ArrayList<Funcionario>();
        Funcionario dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario(crs.getString(0),crs.getString(1),crs.getString(2),crs.getString(3));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Funcionario> obtenerTodoslosFuncionarios() throws Exception {
        ArrayList<Funcionario> lst = new ArrayList<Funcionario>();
        try {
            String sql = "select * from bodega.funcionario;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarFuncionarios(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Funcionario_Unidad;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FFuncionario_Unidad {
    public static int insertarfuncionario_unidad (Funcionario_Unidad fun_u) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_func_unidad(?,?)";
    lstpar.add(new Parametro(1,fun_u.getCedula_funcionario()));
    lstpar.add(new Parametro(2,fun_u.getId_unidad()));
    
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al asignar un funcionario a una unidad"+ex.getMessage());
        }
    
    return codigo;
    }
     public static ArrayList<Funcionario_Unidad> llenarfuncio_unidad(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario_Unidad> lstD = new ArrayList<Funcionario_Unidad>();
        Funcionario_Unidad dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario_Unidad(crs.getString(0),crs.getInt(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Funcionario_Unidad> obtenerTodos_funcionarios() throws Exception {
        ArrayList<Funcionario_Unidad> lst = new ArrayList<Funcionario_Unidad>();
        try {
            String sql = "select * from bodega.listar_func_unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarfuncio_unidad(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Funcionario_Unidad obtenerFuncionario_xcodigo(String cedula) throws Exception {
            Funcionario_Unidad fun_u = new Funcionario_Unidad(null,0);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cedula)); 
                      try {
                String sql = "Select * from bodega.sel_funcio_unidad_ced(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun_u=llenarfuncio_unidad(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun_u;
    }
}


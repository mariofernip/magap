/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario_Unidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FFuncionario_Unidad {
    
    public static boolean insertarFuncionarioUnidad (Funcionario_Unidad funu) throws Exception{
     boolean band = false;
    String sql ="Select * from bodega.insert_func_unidad(?,?)";
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    lstpar.add(new Parametro(1,funu.getCedula_funcionario()));
    lstpar.add(new Parametro(2,funu.getId_unidad()));
        try {
            band=AccesoDatos.ejecutaComando(sql, lstpar);
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario Unidad"+ex.getMessage());
        }
    return band;
    }
        
     
      public static ArrayList<Funcionario_Unidad> llenarFuncionarioUnidad(ConjuntoResultado crs) throws Exception {
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
     
     
       public static ArrayList<Funcionario_Unidad> obtenerTodoslosFuncionariosUnidad() throws Exception {
        ArrayList<Funcionario_Unidad> lst = new ArrayList<Funcionario_Unidad>();
        try {
            String sql = "select * from bodega.funcionario_unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarFuncionarioUnidad(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
    
}

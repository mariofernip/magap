/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Funcionario;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FFuncionario {
    public static int insertarfuncionario (Funcionario fun) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_funcionario(?,?,?,?,?)";
    lstpar.add(new Parametro(1,fun.getCedula()));
    lstpar.add(new Parametro(2,fun.getNombres()));
    lstpar.add(new Parametro(3,fun.getApellidos()));
    lstpar.add(new Parametro(4,fun.getNumerostelefonicos()));
    lstpar.add(new Parametro(5,fun.getCorreo()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario"+ex.getMessage());
        }
    
    return codigo;
    }
     public static ArrayList<Funcionario> llenarfuncionarios(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario> lstD = new ArrayList<Funcionario>();
        Funcionario dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario(crs.getString(0),crs.getString(1),crs.getString(2),crs.getString(3),crs.getString(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Funcionario> obtenerTodos_funcionarios() throws Exception {
        ArrayList<Funcionario> lst = new ArrayList<Funcionario>();
        try {
            String sql = "select * from bodega.listar_funcionario;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarfuncionarios(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}

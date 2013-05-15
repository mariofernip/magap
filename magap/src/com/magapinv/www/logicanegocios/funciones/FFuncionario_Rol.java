/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Funcionario_Rol;
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
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Mantenimiento;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FMantenimiento {
    
     public static int insertarFuncionarioRol (Mantenimiento man) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_mantenimiento(?,?,?,?,?)";
    lstpar.add(new Parametro(1,man.getEncargadomant()));
    lstpar.add(new Parametro(2,man.getFecha_ingreso()));
    lstpar.add(new Parametro(3,man.getFecha_salida()));
    lstpar.add(new Parametro(4,man.getDescripcion_danio()));
    lstpar.add(new Parametro(5,man.getId_estado()));  
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario Mantenimiento"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
}

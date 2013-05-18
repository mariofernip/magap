/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Perdido;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FPerdido {
    
     public static int insertarPerdido (Perdido per) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_(?,?,?)";
    lstpar.add(new Parametro(1,per.getId_estado()));
    lstpar.add(new Parametro(2,per.getFecha_perdida()));
    lstpar.add(new Parametro(3,per.getId_perdido()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Elemento perdido"+ex.getMessage());
        }
    
    return codigo;
    }
    
}

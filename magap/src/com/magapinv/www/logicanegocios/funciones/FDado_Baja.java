/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Dado_Baja;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FDado_Baja {
    
    public static int insertarDefectuso (Dado_Baja dad) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_dado_baja(?,?,?,?)";
    lstpar.add(new Parametro(1,dad.getFecha_dadobaja()));
    lstpar.add(new Parametro(2,dad.getMotivo_dado_baja()));
    lstpar.add(new Parametro(3,dad.getId_estado()));
    lstpar.add(new Parametro(3,dad.getId_dado_baja()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Elemento dado baja"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
}

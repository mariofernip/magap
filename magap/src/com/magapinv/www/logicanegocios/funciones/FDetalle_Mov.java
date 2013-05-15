/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Detalle_Mov;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FDetalle_Mov {
   
    public static int insertarDetalleMovimiento (Detalle_Mov det) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_detallemov(?,?,?,?,?)";
    lstpar.add(new Parametro(1,det.getId_detmov()));
    lstpar.add(new Parametro(2,det.getFecha_mov()));
    lstpar.add(new Parametro(3,det.getId_mov()));
    lstpar.add(new Parametro(4,det.getEncargado()));
    lstpar.add(new Parametro(5,det.getNuevo_encargado()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un DetalleMovimiento"+ex.getMessage());
        }
    
    return codigo;
    }
    
    
}

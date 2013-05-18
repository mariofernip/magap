/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Inventario;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FInventario {
    
    public static int insertarInventario (Inventario inv) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_inventario(?,?,?,?,?,?,?,?)";
    lstpar.add(new Parametro(1,inv.getId_inventario()));
    lstpar.add(new Parametro(2,inv.getId_equipo()));
    lstpar.add(new Parametro(3,inv.getMarca()));
    lstpar.add(new Parametro(4,inv.getModelo()));
    lstpar.add(new Parametro(5,inv.getDescripcion()));
    lstpar.add(new Parametro(6,inv.getId_estado()));
    lstpar.add(new Parametro(7,inv.getId_categoria()));
    lstpar.add(new Parametro(8,inv.getId_bodega()));  
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Inventario"+ex.getMessage());
        }
     
    return codigo;
    }
    
    
}

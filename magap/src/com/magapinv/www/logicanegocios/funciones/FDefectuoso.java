/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Defectuoso;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FDefectuoso {
     
    public static int insertarDefectuso (Defectuoso def) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_defectuoso(?,?,?)";
    lstpar.add(new Parametro(1,def.getId_defectuoso()));
    lstpar.add(new Parametro(2,def.getObservacion()));
    lstpar.add(new Parametro(3,def.getId_defectuoso()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Elemento defectuoso"+ex.getMessage());
        }
    
    return codigo;
    }
}

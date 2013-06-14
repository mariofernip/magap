/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;


import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clasesseguridad.RolUsuario;
import java.util.ArrayList;

/**
 *
 * @author YONY
 */
public class FRolUsuario {
    
    public static boolean insertarRolUsuario(RolUsuario rolusr) throws Exception{
        boolean band=false;
        ArrayList<Parametro> lstP =new ArrayList<Parametro>();
        lstP.add(new Parametro(1, rolusr.getUsuario().getId_usuario()));
        lstP.add(new Parametro(2, rolusr.getRol().getId_rol()));
        lstP.add(new Parametro(3, rolusr.getDescripcion_rol_usr()));
        String sql="select * from seguridad.f_insertar_rol_usuario(?,?,?)"; 
        try {
             ConjuntoResultado crs =AccesoDatos.ejecutaQuery(sql,lstP);
             band=true;
        } catch (Exception e) {
            throw new Exception("Eror al insertar en la tabla rolusuario");
        }
        return band;
    }
    
}

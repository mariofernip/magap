/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;


import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clasesseguridad.RolUsuario;
import com.magapinv.www.logicanegocios.clasesseguridad.Rols;
import java.sql.SQLException;
import java.util.ArrayList;


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
    
     public static ArrayList<RolUsuario> llenarFuncionario_Rol(ConjuntoResultado crs) throws Exception {
        ArrayList<RolUsuario> lstD = new ArrayList<RolUsuario>();
        RolUsuario dls =null;
        try {
            while (crs.next()) {
              dls = new RolUsuario(FRols.obtenerRolesxCodigo(crs.getString(0)),FUsuario.obtenerUsuariosxCodigo(crs.getString(1)),crs.getString(2));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<RolUsuario> obtenerTodoslosFuncionariosRol() throws Exception {
        ArrayList<RolUsuario> lst = new ArrayList<RolUsuario>();
        try {
            String sql = "select * from bodega.funcionario_rol;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarFuncionario_Rol(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
       
       public static RolUsuario obtenerTodoslosFuncionariosRolxcodigo(String codigo) throws Exception{
        RolUsuario rols =null;
        ConjuntoResultado crs =null;
        String sql ="Select * from seguridad.f_obtener_todos_roles_usuario_xcodigo";                
        ArrayList<Parametro> lstpar =new ArrayList<Parametro>();     
        lstpar.add(new Parametro(1,codigo));
        
         try {
             crs=AccesoDatos.ejecutaQuery(sql,lstpar);
             rols=llenarFuncionario_Rol(crs).get(0);
         } catch (Exception e) {
            throw new Exception("Error al ejecuetar la sentencia");
         }
        return rols;
    }
    
    
    
}

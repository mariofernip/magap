/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;


import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Rol;
import com.magapinv.www.logicanegocios.clasesseguridad.Usuario;
import java.util.ArrayList;


public class FUsuario {
    
    //INSERTAR USUARIO
    
    public static boolean insertarUsiario(Usuario usr) throws Exception{
        boolean band=false;
        ArrayList<Parametro> lstP =new ArrayList<Parametro>();
        lstP.add(new Parametro(1, usr.getId_usuario()));
        lstP.add(new Parametro(2, usr.getNombre_usu()));
        String sql="select * from seguridad.f_insertar_usuario(?,?)";
        try {
            ConjuntoResultado crs =AccesoDatos.ejecutaQuery(sql,lstP);
            band=true;
        } catch (Exception e) {
            throw new Exception("Error al insertar el Usuario");
        }
        return band;
    }
    
    //PERMITE MOSTRAR EL ROL DE UN USUARIO MEDIANTE UN CÓDIGO DETERMINADO
     public static Usuario obtenerUsuariosxCodigo(String codigo) throws Exception{
        Usuario usr =null;
        Rol rol =null;
        ConjuntoResultado crs =null;
        String sql ="Select * from seguridad.f_obtener_usuarios_xcodigo(?)";                
        ArrayList<Parametro> lstpar =new ArrayList<Parametro>();     
        lstpar.add(new Parametro(1,codigo));
        
         try {
             crs=AccesoDatos.ejecutaQuery(sql,lstpar);
             usr=llenarUsuarios(crs).get(0);
         } catch (Exception e) {
            throw new Exception("Error al ejecuetar la sentencia");
         }
        return usr;
    }

    private static ArrayList<Usuario> llenarUsuarios(ConjuntoResultado crs) throws Exception {
        ArrayList<Usuario> lstU=new ArrayList<Usuario>();
        Usuario usr=null;
        try {
            usr=new Usuario(crs.getString("pcodigo"), crs.getString("pnombre"));
            lstU.add(usr);
        } catch (Exception e) {
            lstU.clear();
            throw e;
        }
                
        return lstU;
    }
    
    public static ArrayList<Usuario> obtenerTodosRoles() throws Exception{
        ArrayList<Usuario> lstU=new ArrayList<Usuario>();
        String sql="Select * from seguridad.f_obtener_todos_usuarios()";
        try {
            ConjuntoResultado crs=AccesoDatos.ejecutaQuery(sql);
            lstU=llenarUsuarios(crs);
            crs=null;
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los usuarios");
        }
        return lstU;
    }
    
    
}

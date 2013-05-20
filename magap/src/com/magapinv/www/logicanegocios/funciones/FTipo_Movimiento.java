/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Tipo_Movimiento;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FTipo_Movimiento {
    public static int insertartipo_mov (Tipo_Movimiento t_movi) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_tipo_mov(?)";
    lstpar.add(new Parametro(1,t_movi.getTipomovimiento()));
     
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una Categoria"+ex.getMessage());
        }
    
    return codigo;
    }
    public static ArrayList<Tipo_Movimiento> llenartip_movimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Tipo_Movimiento> lstD = new ArrayList<Tipo_Movimiento>();
        Tipo_Movimiento dls =null;
        try {
            while (crs.next()) {
              dls = new Tipo_Movimiento(crs.getString(0),crs.getString(1));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Tipo_Movimiento> obtenerTodoslostip_movimientos() throws Exception {
        ArrayList<Tipo_Movimiento> lst = new ArrayList<Tipo_Movimiento>();
        try {
            String sql = "select * from bodega.listar_tipo_mov;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenartip_movimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}

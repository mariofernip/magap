/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import negocio_clases.Detalle_mov;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class FDetalle_Mov {
     public static int insertardetalle_mov(Detalle_mov mov) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_detallemov(?,?,?,?)";
    lstpar.add(new Parametro(1,mov.getFecha_mov()));
    lstpar.add(new Parametro(2,mov.getId_mov()));
    lstpar.add(new Parametro(3,mov.getEncargado()));
    lstpar.add(new Parametro(4,mov.getNuevo_encargado()));
    try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Detalle de Movimiento"+ex.getMessage());
        }
        return codigo;
    }
    public static ArrayList<Detalle_mov> llenardetalle_mov(ConjuntoResultado crs) throws Exception {
        ArrayList<Detalle_mov> lstD = new ArrayList<Detalle_mov>();
        Detalle_mov dls =null;
        try {
            while (crs.next()) {
              dls = new Detalle_mov(crs.getString(0),crs.getDate(1),crs.getString(2),crs.getString(3),crs.getString(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Detalle_mov> obtenerdetalles_mov() throws Exception {
        ArrayList<Detalle_mov> lst = new ArrayList<Detalle_mov>();
        try {
            String sql = "select * from bodega.listar_detallemov;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenardetalle_mov(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}

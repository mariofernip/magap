/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Bodega;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class FBodega {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public static boolean insertarbodega(Bodega bod) throws Exception{
    boolean codigo=false;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_bodega(?,?)";
    lstpar.add(new Parametro(1,bod.getUbicacion()));
    lstpar.add(new Parametro(2,bod.getFecha_creacion()));
    try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getBoolean(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una nueva bodega"+ex.getMessage());
        }
        return codigo;
    }
    
    public static ArrayList<Bodega> llenarbodega(ConjuntoResultado crs) throws Exception {
        ArrayList<Bodega> lstD = new ArrayList<Bodega>();
        Bodega dls =null;
        try {
            while (crs.next()) {
              dls = new Bodega(crs.getInt(0),crs.getString(1),crs.getDate(2));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Bodega> obtenerTodaslasbodegas() throws Exception {
        ArrayList<Bodega> lst = new ArrayList<Bodega>();
        try {
            String sql = "select * from bodega.bodega;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarbodega(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Bodega obtenerBodega_xcodigo(String ubi) throws Exception {
            Bodega fun = new Bodega();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,ubi));        
            try {
                String sql = "Select * from bodega.sel_bod_ubicacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarbodega(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    }
     
     
     //obtenerBodega_xnombre
     
       public static Bodega obtenerBodega_xnombre(String ubi) throws Exception {
            Bodega fun = new Bodega();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,ubi));        
            try {
                String sql = "Select * from bodega.sel_bod_ubicacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarbodega(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun;
    } 
       private Connection getConexion()throws Exception{
        Class.forName("org.postgresql.Driver");
        cn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/inv_magap","postgres","sql1");
        return cn;
    }
       public void llenarTabla(JTable tabla)throws Exception{
        ps=getConexion().prepareStatement("select s_dni,s_apellidos,s_nombres from socios");
        rs=ps.executeQuery();
        rsm=rs.getMetaData();
        ArrayList<Object[]> datos =new ArrayList<Object[]>();
        while (rs.next()) {            
            Object[] filas=new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=rs.getObject(i+1);
                
            }
            datos.add(filas);
        }
        dtm=(DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
    }
           
}

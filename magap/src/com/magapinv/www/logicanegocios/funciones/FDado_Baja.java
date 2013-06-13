/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Dado_Baja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FDado_Baja {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
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
    
    
    public static ArrayList<Dado_Baja> llenarDado_Baja(ConjuntoResultado crs) throws Exception {
        ArrayList<Dado_Baja> lstD = new ArrayList<Dado_Baja>();
        Dado_Baja dls =null;
        try {
            while (crs.next()) {
              dls = new Dado_Baja(crs.getDate(0),crs.getString(1),crs.getInt(2),crs.getInt(3),crs.getString(4));              
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
     
     
       public static ArrayList<Dado_Baja> obtenerTodoslosEstado_ac() throws Exception {
        ArrayList<Dado_Baja> lst = new ArrayList<Dado_Baja>();
        try {
            String sql = "select * from bodega.dado_baja;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarDado_Baja(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
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

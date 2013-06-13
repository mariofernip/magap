/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Movimientos;
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
public class FMovimientos {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public static int insertarmovimientos (Movimientos movi) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_movimientos(?)";
    lstpar.add(new Parametro(1,movi.getObservacion()));
     
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un movimiento"+ex.getMessage());
        }
    
    return codigo;
    }
    public static ArrayList<Movimientos> llenarmovimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Movimientos> lstD = new ArrayList<Movimientos>();
        Movimientos dls =null;
        try {
            while (crs.next()) {
              dls = new Movimientos(crs.getInt(0),crs.getString(1),crs.getString(2));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Movimientos> obtenerTodoslosmovimientos() throws Exception {
        ArrayList<Movimientos> lst = new ArrayList<Movimientos>();
        try {
            String sql = "select * from bodega.listar_movimientos;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarmovimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     public static Movimientos obtenerMovimiento_xcodigo(String obs) throws Exception {
            Movimientos man = new Movimientos(0, null, null);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,obs)); 
                      try {
                String sql = "Select * from bodega.sel_movimientos_observacion(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                man=llenarmovimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return man;
    }
      private Connection getConexion()throws Exception{
        Class.forName("org.postgresql.Driver");
        cn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/inv_magap","postgres","sql1");
        return cn;
    }
      public void llenarTabla(JTable tabla)throws Exception{
        ps=getConexion().prepareStatement("select * from bodega.listar_movimientos");
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

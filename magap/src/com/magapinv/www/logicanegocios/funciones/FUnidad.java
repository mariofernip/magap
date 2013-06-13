/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Unidad;
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
public class FUnidad {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public static int insertarunidad (Unidad uni) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_unidad(?,?,?)";
    lstpar.add(new Parametro(1,uni.getUbicacion_unidad()));
    lstpar.add(new Parametro(2,uni.getNombre_unidad()));
    lstpar.add(new Parametro(3,uni.getFuncion_unidad()));
     
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
     public static ArrayList<Unidad> llenarunidades(ConjuntoResultado crs) throws Exception {
        ArrayList<Unidad> lstD = new ArrayList<Unidad>();
        Unidad dls =null;
        try {
            while (crs.next()) {
              dls = new Unidad(crs.getInt(0),crs.getString(1),crs.getString(2),crs.getString(3));//tipo de dato 
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Unidad> obtenerTodoaslas_unidades() throws Exception {
        ArrayList<Unidad> lst = new ArrayList<Unidad>();
        try {
            String sql = "select * from bodega.listar_unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarunidades(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static Unidad obtenerunidad_xcodigo(String nom) throws Exception {
            Unidad uni = new Unidad(0, null, null, null);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,nom)); 
                      try {
                String sql = "Select * from bodega.sel_unidad_nombr(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                uni=llenarunidades(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return uni;
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


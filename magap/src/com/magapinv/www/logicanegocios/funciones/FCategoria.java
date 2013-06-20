/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Categoria;
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
public class FCategoria {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
     
    public static int insertarCategorias (Categoria cat) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_categoria(?)";
    lstpar.add(new Parametro(1,cat.getNombre_categoria()));
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
    public static ArrayList<Categoria> llenarcategoria(ConjuntoResultado crs) throws Exception {
        ArrayList<Categoria> lstD = new ArrayList<Categoria>();
        Categoria dls =null;
        try {
            while (crs.next()) {
              dls = new Categoria(crs.getInt(0),crs.getString(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Categoria> obtenerTodaslascategorias() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from bodega.categoria";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarcategoria(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    //obtenerCategoria_xcodigo recibe el nombre devuelve el codigo
    public static Categoria obtenerCategoria_xcodigo(int n_cat) throws Exception {
            Categoria cat = new Categoria();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,n_cat));        
            try {
                String sql = "Select * from bodega.sel_cat_nombre(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                cat=llenarcategoria(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return cat;
    }
    
    public static Categoria  obtenerCategoria_xnombre(String n_cat) throws Exception {
            Categoria cat = new Categoria();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,n_cat));        
            try {
                String sql = "Select * from bodega.f_obtener_categoria_xnombre(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                cat=llenarcategoria(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return cat;
    }
    
   private Connection getConexion()throws Exception{
        Class.forName("org.postgresql.Driver");
        cn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/inv_magap","postgres","sql1");
        return cn;
    }
       public void llenarTabla(JTable tabla)throws Exception{
        ps=getConexion().prepareStatement("select *from bodega.listar_categoria");
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
      public static int actualizarCategorias (Categoria cat) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.act_categoria(?,?)";
    lstpar.add(new Parametro(1,cat.getId_categoria()));
    lstpar.add(new Parametro(2,cat.getNombre_categoria()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al actualizar una Categoria"+ex.getMessage());
        }
    
    return codigo;
    }
            
}

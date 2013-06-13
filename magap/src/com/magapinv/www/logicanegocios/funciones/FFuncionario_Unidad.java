/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Funcionario_Unidad;
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
public class FFuncionario_Unidad {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public static int insertarfuncionario_unidad (Funcionario_Unidad fun_u) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_func_unidad(?,?)";
    lstpar.add(new Parametro(1,fun_u.getCedula_funcionario()));
    lstpar.add(new Parametro(2,fun_u.getId_unidad()));
    
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al asignar un funcionario a una unidad"+ex.getMessage());
        }
    
    return codigo;
    }
     public static ArrayList<Funcionario_Unidad> llenarfuncio_unidad(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario_Unidad> lstD = new ArrayList<Funcionario_Unidad>();
        Funcionario_Unidad dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario_Unidad(crs.getString(0),crs.getInt(1));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Funcionario_Unidad> obtenerTodos_funcionarios() throws Exception {
        ArrayList<Funcionario_Unidad> lst = new ArrayList<Funcionario_Unidad>();
        try {
            String sql = "select * from bodega.listar_func_unidad;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarfuncio_unidad(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Funcionario_Unidad obtenerFuncionario_xcodigo(String cedula) throws Exception {
            Funcionario_Unidad fun_u = new Funcionario_Unidad(null,0);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cedula)); 
                      try {
                String sql = "Select * from bodega.sel_funcio_unidad_ced(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun_u=llenarfuncio_unidad(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return fun_u;
    }
      private Connection getConexion()throws Exception{
        Class.forName("org.postgresql.Driver");
        cn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/inv_magap","postgres","sql1");
        return cn;
    }
       public void llenarTabla(JTable tabla)throws Exception{
        ps=getConexion().prepareStatement("select * from bodega.listar_func_unidad");
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


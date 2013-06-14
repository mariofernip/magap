/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Funcionario;
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
public class FFuncionario {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public static int insertarfuncionario (Funcionario fun) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_funcionario(?,?,?,?,?)";
    lstpar.add(new Parametro(1,fun.getCedula()));
    lstpar.add(new Parametro(2,fun.getNombres()));
    lstpar.add(new Parametro(3,fun.getApellidos()));
    lstpar.add(new Parametro(4,fun.getNumerostelefonicos()));
    lstpar.add(new Parametro(5,fun.getCorreo()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario"+ex.getMessage());
        }
    
    return codigo;
    }
     public static ArrayList<Funcionario> llenarfuncionarios(ConjuntoResultado crs) throws Exception {
        ArrayList<Funcionario> lstD = new ArrayList<Funcionario>();
        Funcionario dls =null;
        try {
            while (crs.next()) {
              dls = new Funcionario(crs.getString(0),crs.getString(1),crs.getString(2),crs.getString(3),crs.getString(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Funcionario> obtenerTodos_funcionarios() throws Exception {
        ArrayList<Funcionario> lst = new ArrayList<Funcionario>();
        try {
            String sql = "select * from bodega.listar_funcionario;";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenarfuncionarios(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static Funcionario obtenerFuncionario_xcodigo(String cedula) throws Exception {
            Funcionario fun = new Funcionario();
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,cedula)); 
                      try {
                String sql = "Select * from bodega.sel_fun_cedula(?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                fun=llenarfuncionarios(crs).get(0);
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
        ps= getConexion().prepareStatement("select * from bodega.listar_funcionario ");
        rs=ps.executeQuery();
        rsm=rs.getMetaData();
       ArrayList<Object[]> datos =new ArrayList<Object[]>();
        while (rs.next()) {            
            Object[] filas=new FBodega[rsm.getColumnCount()];
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
    public static int actualizarfuncionario (Funcionario fun) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.act_funcionario(?,?,?,?,?)";
    lstpar.add(new Parametro(1,fun.getCedula()));
    lstpar.add(new Parametro(2,fun.getNombres()));
    lstpar.add(new Parametro(3,fun.getApellidos()));
    lstpar.add(new Parametro(4,fun.getNumerostelefonicos()));
    lstpar.add(new Parametro(5,fun.getCorreo()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Funcionario"+ex.getMessage());
        }
    
    return codigo;
    }
}
    


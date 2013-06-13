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
public class FTipo_Movimiento {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
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
           throw new Exception("Error al insertar un tipo de Inventario"+ex.getMessage());
        }
    
    return codigo;
    }
    public static ArrayList<Tipo_Movimiento> llenartip_movimientos(ConjuntoResultado crs) throws Exception {
        ArrayList<Tipo_Movimiento> lstD = new ArrayList<Tipo_Movimiento>();
        Tipo_Movimiento dls =null;
        try {
            while (crs.next()) {
              dls = new Tipo_Movimiento(crs.getInt(0),crs.getString(1));//tipo de dato 
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
            String sql = "select * from bodega.listar_tipo_mov();";
            ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql);
            lst=llenartip_movimientos(crs);
            crs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static Tipo_Movimiento obtenert_movimiento_xcodigo(String desc) throws Exception {
            Tipo_Movimiento t_mov = new Tipo_Movimiento(0,null);
            ArrayList <Parametro> lstpar = new  ArrayList<Parametro>();
            lstpar.add(new Parametro(1,desc));        
            try {
                String sql = "Select * from bodega.sel_timovimiento_tipo?)";
                ConjuntoResultado crs = AccesoDatos.ejecutaQuery(sql,lstpar);
                t_mov=llenartip_movimientos(crs).get(0);
                crs = null;
            } catch (SQLException exConec) {
                throw new Exception(exConec.getMessage());
              }
        return t_mov;
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


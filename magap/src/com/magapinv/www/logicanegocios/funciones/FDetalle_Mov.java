/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.SQLException;
import com.magapinv.www.logicanegocios.clases.Detalle_Mov;
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
public class FDetalle_Mov {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
     public static int insertardetalle_mov(Detalle_Mov mov) throws Exception{
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
    public static ArrayList<Detalle_Mov> llenardetalle_mov(ConjuntoResultado crs) throws Exception {
        ArrayList<Detalle_Mov> lstD = new ArrayList<Detalle_Mov>();
       Detalle_Mov dls =null;
        try {
            while (crs.next()) {
              dls = new Detalle_Mov(crs.getString(0),crs.getDate(1),crs.getString(2),crs.getString(3),crs.getString(4));
                lstD.add(dls);
            }
        } catch (Exception e) {
            lstD.clear();
            throw e;
        }
        return lstD;
    }
    public static ArrayList<Detalle_Mov> obtenerdetalles_mov() throws Exception {
        ArrayList<Detalle_Mov> lst = new ArrayList<Detalle_Mov>();
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
     private Connection getConexion()throws Exception{
        Class.forName("org.postgresql.Driver");
        cn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/inv_magap","postgres","sql1");
        return cn;
    }
      public void llenarTabla(JTable tabla)throws Exception{
        ps=getConexion().prepareStatement("select *from bodega.listar_detallemov");
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

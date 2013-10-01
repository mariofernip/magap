/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mario
 */
public class Estado_Articulo {
    private Connection conexion;
    public final static String URL="jdbc:postgresql://192.168.185.2:5434/inventariobd";
    public final static String DRIVER="org.postgresql.Driver";
    public final static String USER="postgres";
    public final static String PASS="Po$tgre$123";

      public Estado_Articulo(){
        try {
            Class.forName(DRIVER);
            conexion=DriverManager.getConnection(URL,USER,PASS);
         }
        catch (Exception ex) {
        }
    }
    
public void ejecutarReporte_Estado_Articulo(String codigo_equipo) {
        try {
                  String master = "C:\\reportes\\reporte_Estado_articulo.jasper";
                  String sub = "C:\\reportes\\reporte_Estado_articulo_count.jasper";  
           
             System.out.println("master " + master);
             if (master == null) {
                 System.out.println("No encuentro el reporte");
                 System.exit(2);
             }
             
             JasperReport masterReport = null;
             JasperReport subReport = null;

            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
                subReport = (JasperReport) JRLoader.loadObject(sub);
            } catch (JRException ex) {
                Logger.getLogger(Stock_Articulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             Map<String,Object> parametro = new HashMap<String,Object>();
              parametro.put("estado_articulo", codigo_equipo);
              JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conexion);
              
             JasperViewer jviewer = new JasperViewer(jasperPrint,false);
             jviewer.setVisible(true);
                } catch (JRException ex) {
            Logger.getLogger(Stock_Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }      
}

           
public void ejecutarReporte_Estado_Articulo_Grafico() {
        try {
              String master="C:\\reportes\\reporte_estados_articulo.jasper";
 
             System.out.println("master " + master);
             if (master == null) {
                 System.out.println("No encuentro el reporte");
                 System.exit(2);
             }
             
             JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException ex) {
                Logger.getLogger(Stock_Articulos.class.getName()).log(Level.SEVERE, null, ex);
            }
             Map parametro = new HashMap();
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conexion);
             JasperViewer jviewer = new JasperViewer(jasperPrint,false);
             jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Stock_Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }     
}


 public void cerrar() {
        try {
            conexion.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

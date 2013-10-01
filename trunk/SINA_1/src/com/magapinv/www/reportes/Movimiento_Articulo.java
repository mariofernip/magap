/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mario
 */
public class Movimiento_Articulo {
    private Connection conexion;
    public final static String URL="jdbc:postgresql://192.168.185.2:5434/inventariobd";
    public final static String DRIVER="org.postgresql.Driver";
    public final static String USER="postgres";
    public final static String PASS="Po$tgre$123";

      public Movimiento_Articulo(){
        try {
            Class.forName(DRIVER);
            conexion=DriverManager.getConnection(URL,USER,PASS);
         }
        catch (Exception ex) {
        }
    }
    
public void ejecutarReporte_Estado_Articulo(String tipo, String nombre_bodega,String nombre_recibe, int producto, String cargo_funcionario) throws IOException {
        try {        
            String master="C:\\reportes\\reporte_Movimiento_funcionarios.jasper";
         
             System.out.println("master " + master);
             if (master == null) {
                 System.out.println("No encuentro el reporte");
                 System.exit(2);
             }
             
             JasperReport masterReport = null;
           
                masterReport = (JasperReport) JRLoader.loadObject(master);
           
            
             Map<String,Object> parametro = new HashMap<String,Object>();
             //parametro.clear();
              parametro.put("tipo_movimiento", tipo);
              parametro.put("nombre_bodega", nombre_bodega);
              parametro.put("nombre_recibe", nombre_recibe);
              parametro.put("id_mov", producto);
              parametro.put("logo_izq", this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/LOGO_MAGAP_SSTRA.png"));
              parametro.put("logo_der", this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/LOGO_SSTRA1.png"));
              parametro.put("cargo_fucionario", cargo_funcionario);
              
                        
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conexion);
            
             JasperViewer jviewer = new JasperViewer(jasperPrint,false);
             jviewer.setVisible(true);
             
            JRExporter exporter = null;
            exporter = new JRPdfExporter();
            Date date = new Date();
            DateFormat hourdateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
            
             JasperExportManager.exportReportToPdfFile(jasperPrint,"C:/informes/".concat(hourdateFormat.format(date))+".pdf"); 
          } catch (JRException ex) {
            Logger.getLogger(Movimiento_Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }	
         
}

public void ejecutarReporte_Funcionario_Mensual(String cedula, Date fecha, Date fecha1, String nombre_bodega,String nombre_recibe,String cargo_funcionario_mensual) throws IOException {
        try {        
            String dir_current = System.getProperty("user.dir") ;
            String master="C:\\reportes\\reporte_Movimiento_funcionarios.jasper";
             System.out.println("master " + master);
             if (master == null) {
                 System.out.println("No encuentro el reporte");
                 System.exit(2);
             }
             JasperReport masterReport = null;
                masterReport = (JasperReport) JRLoader.loadObject(master);
           
            
             Map<String,Object> parametro = new HashMap<String,Object>();
              parametro.put("cedula", cedula);
              parametro.put("fechain", fecha);
              parametro.put("fechafin", fecha1);
              parametro.put("logo_izq", this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/LOGO_MAGAP_SSTRA.png"));
              parametro.put("logo_der", this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/LOGO_SSTRA1.png"));
              parametro.put("nombre_bodega", nombre_bodega);
              parametro.put("nombre_recibe", nombre_recibe);
              parametro.put("cargo_funcionario_mensual", cargo_funcionario_mensual);
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conexion);
            
             JasperViewer jviewer = new JasperViewer(jasperPrint,false);
             jviewer.setVisible(true);
             
          } catch (JRException ex) {
            Logger.getLogger(Movimiento_Articulo.class.getName()).log(Level.SEVERE, null, ex);
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

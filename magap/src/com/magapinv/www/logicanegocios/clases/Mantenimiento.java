/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

import java.util.Date;

/**
 *
 * @author User
 */
public class Mantenimiento extends Estado_ac{
    private String encargadomant;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private String descripcion_danio;
    private int id_mantenimiento;
   
    public Mantenimiento() {
    }

    public Mantenimiento(String encargadomant, Date fecha_ingreso, Date fecha_salida, String descripcion_danio, int id_mantenimiento, int Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.encargadomant = encargadomant;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.descripcion_danio = descripcion_danio;
        this.id_mantenimiento = id_mantenimiento;
    }

        
    public String getEncargadomant() {
        return encargadomant;
    }

    
    public void setEncargadomant(String encargadomant) {
        this.encargadomant = encargadomant;
    }

   
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

   
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

  
    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    
    public String getDescripcion_danio() {
        return descripcion_danio;
    }

    
    public void setDescripcion_danio(String descripcion_danio) {
        this.descripcion_danio = descripcion_danio;
    }

    
    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }
    
    
}

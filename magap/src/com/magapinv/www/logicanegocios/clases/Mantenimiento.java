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

    public Mantenimiento() {
    }

    public Mantenimiento(String encargadomant, Date fecha_ingreso, Date fecha_salida, String descripcion_danio, String Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.encargadomant = encargadomant;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.descripcion_danio = descripcion_danio;
    }

    /**
     * @return the encargadomant
     */
    public String getEncargadomant() {
        return encargadomant;
    }

    /**
     * @param encargadomant the encargadomant to set
     */
    public void setEncargadomant(String encargadomant) {
        this.encargadomant = encargadomant;
    }

    /**
     * @return the fecha_ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the fecha_salida
     */
    public Date getFecha_salida() {
        return fecha_salida;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    /**
     * @return the descripcion_danio
     */
    public String getDescripcion_danio() {
        return descripcion_danio;
    }

    /**
     * @param descripcion_danio the descripcion_danio to set
     */
    public void setDescripcion_danio(String descripcion_danio) {
        this.descripcion_danio = descripcion_danio;
    }
    
    
    
    
}

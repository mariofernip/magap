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
public class Funcionario_Rol {
   private Funcionario numero_cedula;
   private Rol id_rol;
   private Date fecha_asignacion;
   private Date fecha_salida;

    public Funcionario_Rol() {
        this.numero_cedula = new Funcionario();
        this.id_rol = new Rol();
        this.fecha_asignacion = null;
        this.fecha_salida = null;
    }

    public Funcionario_Rol(Funcionario numero_cedula, Rol id_rol, Date fecha_asignacion, Date fecha_salida) {
        this.numero_cedula = numero_cedula;
        this.id_rol = id_rol;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_salida = fecha_salida;
    }

    /**
     * @return the numero_cedula
     */
    public Funcionario getNumero_cedula() {
        return numero_cedula;
    }

    /**
     * @param numero_cedula the numero_cedula to set
     */
    public void setNumero_cedula(Funcionario numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    /**
     * @return the id_rol
     */
    public Rol getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * @return the fecha_asignacion
     */
    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    /**
     * @param fecha_asignacion the fecha_asignacion to set
     */
    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
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
     
    
 
    
}

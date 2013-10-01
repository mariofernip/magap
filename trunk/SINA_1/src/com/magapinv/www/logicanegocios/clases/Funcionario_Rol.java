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
   private String password;
   
 public Funcionario_Rol() {
    }
 
   public Funcionario_Rol(Funcionario numero_cedula, Rol id_rol, Date fecha_asignacion, Date fecha_salida, String password) {
        this.numero_cedula = numero_cedula;
        this.id_rol = id_rol;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_salida = fecha_salida;
        this.password = password;
    }

    public Funcionario_Rol(Funcionario numero_cedula, Rol id_rol, Date fecha_asignacion, Date fecha_salida) {
        this.numero_cedula = numero_cedula;
        this.id_rol = id_rol;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_salida = fecha_salida;
    }

    
    public Funcionario getNumero_cedula() {
        return numero_cedula;
    }

   
    public void setNumero_cedula(Funcionario numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    
    public Rol getId_rol() {
        return id_rol;
    }

    
    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    
    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    
    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    
    public Date getFecha_salida() {
        return fecha_salida;
    }

    
    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    } 

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}

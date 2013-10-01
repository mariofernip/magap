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
public class Funcionario_Rol_Bodega {
  private Funcionario numero_cedula;
  private Bodega id_bodega;
  private Rol id_rol;
  private Date fecha_ingreso;
  private Date fecha_salida;

    public Funcionario_Rol_Bodega() {
    }

    public Funcionario_Rol_Bodega(Funcionario numero_cedula, Bodega id_bodega, Rol id_rol, Date fecha_ingreso, Date fecha_salida) {
        this.numero_cedula = numero_cedula;
        this.id_bodega = id_bodega;
        this.id_rol = id_rol;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    

    public Funcionario getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(Funcionario numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

   
    public Bodega getId_bodega() {
        return id_bodega;
    }

    
    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
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

   
    public Rol getId_rol() {
        return id_rol;
    }

   
    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }
  
  
}

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
  private Date fecha_ingreso;
  private Date fecha_salida;

    public Funcionario_Rol_Bodega() {
    }

    public Funcionario_Rol_Bodega(Funcionario numero_cedula, Bodega id_bodega, Date fecha_ingreso, Date fecha_salida) {
        this.numero_cedula = numero_cedula;
        this.id_bodega = id_bodega;
        this.fecha_ingreso = fecha_ingreso;
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
     * @return the id_bodega
     */
    public Bodega getId_bodega() {
        return id_bodega;
    }

    /**
     * @param id_bodega the id_bodega to set
     */
    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
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
  
  
}

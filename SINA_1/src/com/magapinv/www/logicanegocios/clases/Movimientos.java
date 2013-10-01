/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

import java.sql.Date;

/**
 *
 * @author mario
 */
public class Movimientos {
    private int id_movimiento;
    private String observacion;
    private int tipo_mov; 
    private Date fecha;

    public int getId_movimiento() {
        return id_movimiento;
    }

    public Movimientos(int id_movimiento, String observacion, int tipo_mov, Date fecha) {
        this.id_movimiento = id_movimiento;
        this.observacion = observacion;
        this.tipo_mov = tipo_mov;
        this.fecha = fecha;
    }

    public Movimientos(String observacion, int tipo_mov, Date fecha) {
        this.observacion = observacion;
        this.tipo_mov = tipo_mov;
        this.fecha = fecha;
    }
    
    
    public Movimientos() {
    }
       
    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(int tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

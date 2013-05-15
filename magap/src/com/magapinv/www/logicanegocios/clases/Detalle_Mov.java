/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

import java.sql.Date;

/**
 *
 * @author Cpadron
 */
public class Detalle_Mov {
    private String id_detmov;
    private Date fecha_mov;
    private String id_mov;
    private String encargado;
    private String nuevo_encargado;

    public Detalle_Mov(String id_detmov, Date fecha_mov, String id_mov, String encargado, String nuevo_encargado) {
        this.id_detmov = id_detmov;
        this.fecha_mov = fecha_mov;
        this.id_mov = id_mov;
        this.encargado = encargado;
        this.nuevo_encargado = nuevo_encargado;
    }

    public String getId_detmov() {
        return id_detmov;
    }

    public void setId_detmov(String id_detmov) {
        this.id_detmov = id_detmov;
    }

    public Date getFecha_mov() {
        return fecha_mov;
    }

    public void setFecha_mov(Date fecha_mov) {
        this.fecha_mov = fecha_mov;
    }

    public String getId_mov() {
        return id_mov;
    }

    public void setId_mov(String id_mov) {
        this.id_mov = id_mov;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNuevo_encargado() {
        return nuevo_encargado;
    }

    public void setNuevo_encargado(String nuevo_encargado) {
        this.nuevo_encargado = nuevo_encargado;
    }
    
}

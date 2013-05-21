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
public class Bodega {
    private int id_bodega;
    private String ubicacion;
    private Date fecha_creacion;

    public Bodega() {
    }
      
    public Bodega(int id_bodega, String ubicacion, Date fecha_creacion) {
        this.id_bodega = id_bodega;
        this.ubicacion = ubicacion;
        this.fecha_creacion = fecha_creacion;
    }
   
   
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    } 

    public int getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }
      
}

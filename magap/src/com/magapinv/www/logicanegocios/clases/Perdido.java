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
public class Perdido extends Estado_ac{
    private Date fecha_perdida;

    public Perdido() {
    }

    public Perdido(Date fecha_perdida, String Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.fecha_perdida = fecha_perdida;
    }

    /**
     * @return the fecha_perdida
     */
    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    /**
     * @param fecha_perdida the fecha_perdida to set
     */
    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }
    
    
    
}

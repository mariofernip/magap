/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author User
 */
public class Defectuoso extends Estado_ac{
    private String observacion;

    public Defectuoso() {
    }

    public Defectuoso( String observacion, String Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
   this.observacion = observacion;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

   
    
    
}

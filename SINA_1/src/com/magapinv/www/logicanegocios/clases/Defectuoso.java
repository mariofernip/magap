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
     private int id_estado;
    
    public Defectuoso() {
    }

    public Defectuoso(String observacion, int id_estado) {
        this.observacion = observacion;
        this.id_estado = id_estado;
    }

     
    public String getObservacion() {
        return observacion;
    }

   
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }   

   
    @Override
    public int getId_estado() {
        return id_estado;
    }

   
    @Override
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
 
}

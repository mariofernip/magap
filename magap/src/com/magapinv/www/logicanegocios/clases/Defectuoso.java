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
    private int id_defectuoso;
    
    public Defectuoso() {
    }

    public Defectuoso(String observacion, int id_defectuoso, int Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.observacion = observacion;
        this.id_defectuoso = id_defectuoso;
    }

   
   
    public String getObservacion() {
        return observacion;
    }

   
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the id_defectuoso
     */
    public int getId_defectuoso() {
        return id_defectuoso;
    }

    /**
     * @param id_defectuoso the id_defectuoso to set
     */
    public void setId_defectuoso(int id_defectuoso) {
        this.id_defectuoso = id_defectuoso;
    }
 
}

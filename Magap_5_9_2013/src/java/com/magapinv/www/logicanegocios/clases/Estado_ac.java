/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author User
 */
public class Estado_ac {
    private String Id_estado;
    private String nombre_estado;

    public Estado_ac() {
    }

    public Estado_ac(String Id_estado, String nombre_estado) {
        this.Id_estado = Id_estado;
        this.nombre_estado = nombre_estado;
    }

        
    /**
     * @return the Id_estado
     */
    public String getId_estado() {
        return Id_estado;
    }

    /**
     * @param Id_estado the Id_estado to set
     */
    public void setId_estado(String Id_estado) {
        this.Id_estado = Id_estado;
    }

    /**
     * @return the nombre_estado
     */
    public String getNombre_estado() {
        return nombre_estado;
    }

    /**
     * @param nombre_estado the nombre_estado to set
     */
    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
    
}

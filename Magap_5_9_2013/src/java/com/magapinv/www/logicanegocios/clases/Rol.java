/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author User
 */
public class Rol {
    private String id_rol;
    private String nombre_rol;

    public Rol() {
    }

    public Rol(String id_rol, String nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    
    /**
     * @return the id_rol
     */
    public String getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * @return the nombre_rol
     */
    public String getNombre_rol() {
        return nombre_rol;
    }

    /**
     * @param nombre_rol the nombre_rol to set
     */
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
        
}

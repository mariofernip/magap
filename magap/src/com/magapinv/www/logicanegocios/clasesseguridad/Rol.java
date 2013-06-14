/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clasesseguridad;


public class Rol {
    private String id_rol;
    private String descripcion_rol;

    public Rol() {
    }

    public Rol(String id_rol, String descripcion_rol) {
        this.id_rol = id_rol;
        this.descripcion_rol = descripcion_rol;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }
    
}

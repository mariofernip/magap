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
    private int Id_estado;
    private String nombre_estado;

    public Estado_ac() {
    }

    public Estado_ac(int Id_estado, String nombre_estado) {
        this.Id_estado = Id_estado;
        this.nombre_estado = nombre_estado;
    }

   
    public int getId_estado() {
        return Id_estado;
    }

   
    public void setId_estado(int Id_estado) {
        this.Id_estado = Id_estado;
    }

   
    public String getNombre_estado() {
        return nombre_estado;
    }

    
    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

   
    
}

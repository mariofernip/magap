/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clasesseguridad;


public class Usuario {
    
   private String id_usuario;
   private String nombre_usu;
  
    public Usuario() {
    }

    public Usuario(String id_usuario, String nombre_usu) {
        this.id_usuario = id_usuario;
        this.nombre_usu = nombre_usu;
    }

  

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }
  
     
    
}

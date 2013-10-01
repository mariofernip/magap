/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clasesseguridad;


public class RolUsuario {
    
    private Rol rol;
    private Usuario usuario;
    private String descripcion_rol_usr;

    public RolUsuario() {
    }

    public RolUsuario(Rol rol, Usuario usuario, String descripcion_rol_usr) {
        this.rol = rol;
        this.usuario = usuario;
        this.descripcion_rol_usr = descripcion_rol_usr;
    }

    

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion_rol_usr() {
        return descripcion_rol_usr;
    }

    public void setDescripcion_rol_usr(String descripcion_rol_usr) {
        this.descripcion_rol_usr = descripcion_rol_usr;
    }
    
    
    
}

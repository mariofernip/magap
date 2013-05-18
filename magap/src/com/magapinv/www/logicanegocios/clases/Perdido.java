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
    private int id_perdido;
    public Perdido() {
    }

    public Perdido(Date fecha_perdida, int id_perdido, int Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.fecha_perdida = fecha_perdida;
        this.id_perdido = id_perdido;
    }

        
    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    
    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }

   
    public int getId_perdido() {
        return id_perdido;
    }

   
    public void setId_perdido(int id_perdido) {
        this.id_perdido = id_perdido;
    }
    
    
}

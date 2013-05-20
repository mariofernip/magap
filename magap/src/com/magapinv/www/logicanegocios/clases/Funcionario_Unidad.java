/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author Cpadron
 */
public class Funcionario_Unidad {
    private String cedula_funcionario;
    private int Id_unidad;

    public Funcionario_Unidad(String cedula_funcionario, int Id_unidad) {
        this.cedula_funcionario = cedula_funcionario;
        this.Id_unidad = Id_unidad;
    }

    public String getCedula_funcionario() {
        return cedula_funcionario;
    }

    public void setCedula_funcionario(String cedula_funcionario) {
        this.cedula_funcionario = cedula_funcionario;
    }

    public int getId_unidad() {
        return Id_unidad;
    }

    public void setId_unidad(int Id_unidad) {
        this.Id_unidad = Id_unidad;
    }
   

    
}

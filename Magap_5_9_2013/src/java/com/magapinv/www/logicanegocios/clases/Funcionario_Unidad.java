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
    private String Id_unidad;
    private String observacion;
    private String id_tipo_mov;

    public Funcionario_Unidad(String cedula_funcionario, String Id_unidad, String observacion, String id_tipo_mov) {
        this.cedula_funcionario = cedula_funcionario;
        this.Id_unidad = Id_unidad;
        this.observacion = observacion;
        this.id_tipo_mov = id_tipo_mov;
    }

    public String getCedula_funcionario() {
        return cedula_funcionario;
    }

    public void setCedula_funcionario(String cedula_funcionario) {
        this.cedula_funcionario = cedula_funcionario;
    }

    public String getId_unidad() {
        return Id_unidad;
    }

    public void setId_unidad(String Id_unidad) {
        this.Id_unidad = Id_unidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getId_tipo_mov() {
        return id_tipo_mov;
    }

    public void setId_tipo_mov(String id_tipo_mov) {
        this.id_tipo_mov = id_tipo_mov;
    }
    
}

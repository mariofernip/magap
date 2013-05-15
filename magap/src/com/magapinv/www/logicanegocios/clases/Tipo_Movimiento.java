/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author Cpadron
 */
public class Tipo_Movimiento {
    private String id_tipo_movimiento;
    private String tipomovimiento;

    public Tipo_Movimiento(String id_tipo_movimiento, String tipomovimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
        this.tipomovimiento = tipomovimiento;
    }

    public String getId_tipo_movimiento() {
        return id_tipo_movimiento;
    }

    public void setId_tipo_movimiento(String id_tipo_movimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
    }

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio_clases;

/**
 *
 * @author Cpadron
 */
public class Movimientos {
    private String id_movimiento;
    private String observacion;
    private String tipo_mov; 

    public Movimientos(String id_movimiento, String observacion, String tipo_mov) {
        this.id_movimiento = id_movimiento;
        this.observacion = observacion;
        this.tipo_mov = tipo_mov;
    }

    public String getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(String id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }
    
}
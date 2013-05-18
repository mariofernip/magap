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
public class Dado_Baja extends Estado_ac{
    private Date fecha_dadobaja;
    private String motivo_dado_baja;
    private int id_dado_baja;

    public Dado_Baja() {
    }

    public Dado_Baja(Date fecha_dadobaja, String motivo_dado_baja, int id_dado_baja, int Id_estado, String nombre_estado) {
        super(Id_estado, nombre_estado);
        this.fecha_dadobaja = fecha_dadobaja;
        this.motivo_dado_baja = motivo_dado_baja;
        this.id_dado_baja = id_dado_baja;
    }

       
    public Date getFecha_dadobaja() {
        return fecha_dadobaja;
    }

    public void setFecha_dadobaja(Date fecha_dadobaja) {
        this.fecha_dadobaja = fecha_dadobaja;
    }

    public String getMotivo_dado_baja() {
        return motivo_dado_baja;
    }

    public void setMotivo_dado_baja(String motivo_dado_baja) {
        this.motivo_dado_baja = motivo_dado_baja;
    }

   
    public int getId_dado_baja() {
        return id_dado_baja;
    }

    
    public void setId_dado_baja(int id_dado_baja) {
        this.id_dado_baja = id_dado_baja;
    }
    
       
}

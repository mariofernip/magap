/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Detalle_Mov {
   private Integer id_detmov;
    private Integer id_mov;
    private String encargado;
    //private String nuevo_encargado;
    private Integer id_inventario;
    private Integer cant;
    private int verificador;
    
    public Detalle_Mov() {
    }
   
    public Detalle_Mov(Integer id_mov, String encargado, /*String nuevo_encargado,*/ Integer id_inventario, Integer cant, int verificador) {
        this.id_mov = id_mov;
        this.encargado = encargado;
        //this.nuevo_encargado = nuevo_encargado;
        this.id_inventario = id_inventario;
        this.cant = cant;
        this.verificador=verificador;
    }

    public Integer getId_detmov() {
        return id_detmov;
    }

    public void setId_detmov(Integer id_detmov) {
        this.id_detmov = id_detmov;
    }

    public Integer getId_mov() {
        return id_mov;
    }

    public void setId_mov(Integer id_mov) {
        this.id_mov = id_mov;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

//    public String getNuevo_encargado() {
//        return nuevo_encargado;
//    }
//
//    public void setNuevo_encargado(String nuevo_encargado) {
//        this.nuevo_encargado = nuevo_encargado;
//    }

    public Integer getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Integer id_inventario) {
        this.id_inventario = id_inventario;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }
  
    public int getVerificador() {
        return verificador;
    }
   
    public void setVerificador(int verificador) {
        this.verificador = verificador;
    }
}

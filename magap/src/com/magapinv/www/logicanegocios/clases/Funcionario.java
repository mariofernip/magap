/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author Cpadron
 */
public class Funcionario {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String numerostelefonicos;
    private String correo;

    public Funcionario() {
    }
   
    public Funcionario(String cedula, String nombres, String apellidos, String numerostelefonicos, String correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numerostelefonicos = numerostelefonicos;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumerostelefonicos() {
        return numerostelefonicos;
    }

    public void setNumerostelefonicos(String numerostelefonicos) {
        this.numerostelefonicos = numerostelefonicos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    
    }
    

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.clases;

/**
 *
 * @author User
 */
public class Inventario {
  private String id_inventario;
  private String id_equipo;
  private String marca;
  private String modelo;
  private String descripcion;
  private Estado_ac id_estado;
  private Categoria id_categoria;
  private Bodega id_bodega;

    public Inventario() {
    }

    public Inventario(String id_inventario, String id_equipo, String marca, String modelo, String descripcion, Estado_ac id_estado, Categoria id_categoria, Bodega id_bodega) {
        this.id_inventario = id_inventario;
        this.id_equipo = id_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.id_estado = id_estado;
        this.id_categoria = id_categoria;
        this.id_bodega = id_bodega;
    }

    /**
     * @return the id_inventario
     */
    public String getId_inventario() {
        return id_inventario;
    }

    /**
     * @param id_inventario the id_inventario to set
     */
    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    /**
     * @return the id_equipo
     */
    public String getId_equipo() {
        return id_equipo;
    }

    /**
     * @param id_equipo the id_equipo to set
     */
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the id_estado
     */
    public Estado_ac getId_estado() {
        return id_estado;
    }

    /**
     * @param id_estado the id_estado to set
     */
    public void setId_estado(Estado_ac id_estado) {
        this.id_estado = id_estado;
    }

    /**
     * @return the id_categoria
     */
    public Categoria getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the id_bodega
     */
    public Bodega getId_bodega() {
        return id_bodega;
    }

    /**
     * @param id_bodega the id_bodega to set
     */
    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
    }
  
 
}

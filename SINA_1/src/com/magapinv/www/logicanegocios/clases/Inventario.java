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
  private int id_inventario;
  private String id_equipo;
  private String marca;
  private String modelo;
  private String descripcion;
  private Estado_ac id_estado;
  private Categoria id_categoria;
  private Bodega id_bodega;
  private int Stock;

    public Inventario() {
    }

    public Inventario(int id_inventario, String id_equipo, String marca, String modelo, String descripcion, Estado_ac id_estado, Categoria id_categoria, Bodega id_bodega, int Stock) {
        this.id_inventario = id_inventario;
        this.id_equipo = id_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.id_estado = id_estado;
        this.id_categoria = id_categoria;
        this.id_bodega = id_bodega;
        this.Stock = Stock;
    }

   
    public int getId_inventario() {
        return id_inventario;
    }

   
    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    
    public String getId_equipo() {
        return id_equipo;
    }

    
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

   
    public String getMarca() {
        return marca;
    }

   
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    public String getModelo() {
        return modelo;
    }

    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Estado_ac getId_estado() {
        return id_estado;
    }


    public void setId_estado(Estado_ac id_estado) {
        this.id_estado = id_estado;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

   
    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

   
    public Bodega getId_bodega() {
        return id_bodega;
    }

   
    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
    }

   
    public int getStock() {
        return Stock;
    }

   
    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
   
    
}

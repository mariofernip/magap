/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio_clases;

/**
 *
 * @author Cpadron
 */
public class Unidad {
    private String id_unidad;
    private String nombre_unidad;
    private String ubicacion_unidad;
    private String funcion_unidad;

    public Unidad(String id_unidad, String nombre_unidad, String ubicacion_unidad, String funcion_unidad) {
        this.id_unidad = id_unidad;
        this.nombre_unidad = nombre_unidad;
        this.ubicacion_unidad = ubicacion_unidad;
        this.funcion_unidad = funcion_unidad;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getUbicacion_unidad() {
        return ubicacion_unidad;
    }

    public void setUbicacion_unidad(String ubicacion_unidad) {
        this.ubicacion_unidad = ubicacion_unidad;
    }

    public String getFuncion_unidad() {
        return funcion_unidad;
    }

    public void setFuncion_unidad(String funcion_unidad) {
        this.funcion_unidad = funcion_unidad;
    }
    
}

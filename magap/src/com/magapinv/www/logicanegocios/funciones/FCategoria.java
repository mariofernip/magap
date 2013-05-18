/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Categoria;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FCategoria { 
    
    //INSERTA UNA CATEGORIA
    
    public static int insertarCategorias (Categoria cat) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.f_insertar_categoria(?)";
    lstpar.add(new Parametro(1,cat.getNombre_categoria()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar una Categoria"+ex.getMessage());
        }
    
    return codigo;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funciones;
import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Parametro;
import com.magapinv.www.logicanegocios.clases.Tipo_Movimiento;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FTipo_Movimiento {
    
     public static int insertarTipoMovimiento (Tipo_Movimiento tip) throws Exception{
    int codigo=-1;
    ArrayList<Parametro> lstpar= new ArrayList<Parametro>();
    String sql ="Select * from bodega.insert_tipo_mov(?)";
    lstpar.add(new Parametro(2,tip.getTipomovimiento()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql,lstpar);
            //band=AccesoDatos.ejecutaComando(sql, lstpar);
            while (cres.next()){
                codigo=cres.getInt(0);
            }
        } catch (Exception ex) {
           throw new Exception("Error al insertar un Tipo Movimiento"+ex.getMessage());
        }
    
    return codigo;
    } 
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
;


public class Convert {
    
    public static Date stringToDate(String cadena) 
    { Date myDate= null;
        SimpleDateFormat format =new SimpleDateFormat("yy-mm-dd");//SimpleDateFormat(this.txtFecha.getText());              
        myDate=new Date(Integer.valueOf(cadena.substring(0, 3)) ,Integer.valueOf(cadena.substring(5, 6)),Integer.valueOf(cadena.substring(8, 9) ));
        return myDate;
    }
    
}

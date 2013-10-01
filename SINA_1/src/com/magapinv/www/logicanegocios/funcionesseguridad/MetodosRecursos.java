/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.sql.Date;




public class MetodosRecursos {
     private String cadena;
    public static String MD5 = "MD5";
    
    public static Date stringToDate(String cadena) 
    { Date myDate= null;
        SimpleDateFormat format =new SimpleDateFormat("yy-mm-dd");//SimpleDateFormat(this.txtFecha.getText());              
        myDate=new Date(Integer.valueOf(cadena.substring(0, 3)) ,Integer.valueOf(cadena.substring(5, 6)),Integer.valueOf(cadena.substring(8, 9) ));
        return myDate;
    }
   

 public static String toHexadecimal(byte[] digest){

        String hash = "";

        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }

        return hash;
         }

 public static String getStringMessageDigest(String message, String algorithm){

        byte[] digest = null;
        byte[] buffer = message.getBytes();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }

        return toHexadecimal(digest);
    }
    
}

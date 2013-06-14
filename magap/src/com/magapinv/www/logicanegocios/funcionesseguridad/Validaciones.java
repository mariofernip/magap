/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.logicanegocios.funcionesseguridad;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Validaciones {

    public static boolean ValidarCajasTexto(JTextField componente, String texto, String NombreCampo, Component Ventana){
        boolean validacion=false;
        if(!texto.isEmpty()){
            validacion=true;
        }else{
            JOptionPane.showMessageDialog(Ventana,"Ingrese el valor del campo "+NombreCampo,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            componente.setBackground(Color.yellow);
            componente.grabFocus();
        }
        return validacion;
    }
    public static int  ValidarCajasEnteros(JTextField componente, String texto, String NombreCampo, Component Ventana){
        int validacion=-1;

            try {
                validacion=Integer.parseInt(texto);
                if(validacion<1){
                JOptionPane.showMessageDialog(Ventana,"El campo "+NombreCampo+" debe ser mayor que cero ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                componente.setBackground(Color.yellow);
                componente.grabFocus();
                validacion=-1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Ventana,"Error de formato en "+NombreCampo+" por favor ingrese solo números error: "+e.getMessage(),"Atencion",JOptionPane.ERROR_MESSAGE);
                componente.setBackground(Color.yellow);
                componente.grabFocus();
            }
        //JOptionPane.showMessageDialog(Ventana,"valor "+validacion);
        return validacion;
    }
    public static double  ValidarCajasDecimales(JTextField componente, String texto, String NombreCampo, Component Ventana){
        double validacion=-1;

            try {
                validacion=Double.parseDouble(texto);
                if(validacion<=0){
                JOptionPane.showMessageDialog(Ventana,"El campo "+NombreCampo+" debe ser mayor que cero ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                componente.setBackground(Color.yellow);
                componente.grabFocus();
                validacion=-1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Ventana,"Error de formato en "+NombreCampo+" por favor verifique solo números sin coma y un solo punto","Atencion",JOptionPane.ERROR_MESSAGE);
                componente.setBackground(Color.yellow);
                componente.grabFocus();
            }
        //JOptionPane.showMessageDialog(Ventana,"valor "+validacion);
        return validacion;
    }
        public static boolean  ValidarCajasPassw0rd(JPasswordField componente, String texto, String NombreCampo,Component Ventana){
        boolean validacion=false;
        if(!texto.isEmpty()){
            validacion=true;
        }else{
            JOptionPane.showMessageDialog(Ventana,"Ingrese el valor del campo "+NombreCampo,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            componente.setBackground(Color.yellow);
            componente.grabFocus();
        }
        return validacion;
    }
    public static String quitaEspacios(String texto) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append(" ").append(tokens.nextToken());
        }
        return buff.toString().trim();
    }
    public static boolean  ValidarCajasSoloNumeros(JTextField componente, String texto, String NombreCampo, Component Ventana){
          boolean validacion=false;
         
          try {
		Integer.parseInt(texto);
                validacion=true;
//                System.out.println("es num");
	} catch (NumberFormatException nfe){
//            System.out.println("es l");
            JOptionPane.showMessageDialog(Ventana,"El valor del campo solo debe contener numeros "+NombreCampo,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            componente.setBackground(Color.yellow);
            componente.grabFocus();
	}

        return validacion;

    }
     public static boolean validarCedula(String cedula){//la misma consideracion anterior
        boolean band=false;
        int longitud = cedula.length();
        if (longitud ==10){
            band=true;
        }
        return band;
    }

}
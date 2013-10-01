/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

//import com.magapinv.www.interfacesmagap.Ingresar_Unidad;
//import com.magapinv.www.interfacesmagap.login;
//import com.magapinv.www.logicanegocios.clases.Bodega;
//import com.magapinv.www.logicanegocios.clases.Categoria;
//import com.magapinv.www.logicanegocios.clases.Detalle_Mov;
//import com.magapinv.www.logicanegocios.clases.Estado_ac;
//import com.magapinv.www.logicanegocios.clases.Funcionario;
//import com.magapinv.www.logicanegocios.clases.Funcionario_Rol;
//import com.magapinv.www.logicanegocios.clases.Funcionario_Unidad;
import com.magapinv.www.logicanegocios.clases.Inventario;
//import com.magapinv.www.logicanegocios.clases.Mantenimiento;
//import com.magapinv.www.logicanegocios.clases.Movimientos;
//import com.magapinv.www.logicanegocios.clases.Rol;
//import com.magapinv.www.logicanegocios.clases.Tipo_Movimiento;
//import com.magapinv.www.logicanegocios.clases.Unidad;
//import com.magapinv.www.logicanegocios.funciones.FBodega;
//import com.magapinv.www.logicanegocios.funciones.FCategoria;
//import com.magapinv.www.logicanegocios.funciones.FDetalle_Mov;
//import com.magapinv.www.logicanegocios.funciones.FEstado_ac;
//import com.magapinv.www.logicanegocios.funciones.FFuncionario;
//import com.magapinv.www.logicanegocios.funciones.FFuncionario_Rol;
//import com.magapinv.www.logicanegocios.funciones.FFuncionario_Unidad;
import com.magapinv.www.logicanegocios.funciones.FInventario;
//import com.magapinv.www.logicanegocios.funciones.FMantenimiento;
//import com.magapinv.www.logicanegocios.funciones.FMovimientos;
//import com.magapinv.www.logicanegocios.funciones.FRol;
//import com.magapinv.www.logicanegocios.funciones.FTipo_Movimiento;
//import com.magapinv.www.logicanegocios.funciones.FUnidad;
import com.magapinv.www.interfacesmagap.Movimiento_Inventario_Responsable;
import com.magapinv.www.logicanegocios.funciones.FFuncionario_Rol;
//import java.io.FileInputStream;
import java.sql.Date;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.crypto.spec.IvParameterSpec;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
/**
 *
 * @author User
 */
public class Main {
    
     public static void main(String[] args) {
//        try {
//            //try {
//                //         Estado_ac as=new Estado_ac();
//                //         Categoria ca = new Categoria();
//                //         Bodega bo = new Bodega();
//                //         
//                //         bo.setId_bodega(1);
//                //         
             Date date;
            date = new Date(2012-11-11);
             Date date1 = new Date(2012-11-11);
//            
    //                    try {
    //                       Tipo_Movimiento funu = new Tipo_Movimiento(1,"tipo Mov prueba");
    ////                    
    //                Movimientos ec=new Movimientos(6,"prueba movi ",funu);
    //                //System.out.println(e.getId_rol());
    //               FMovimientos.insertarmovimientos(ec);
    //                    
    //                    } catch (Exception ex) {
    //                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    //                    }
    //                   
                       
    //                 
    //                 Bodega funu = new Bodega("daads",2012-10-10);
    //                        FBodega.insertarbodega(funu);
                     
                     
                     
                     //probar obtener
                     
//                      
//                            for(Detalle_Mov e : FDetalle_Mov.obtenerdetalles_mov_ced("0603783846")){    
//                                System.out.println(e.getId_detmov());
//                                System.out.println(e.getId_mov());
//                                System.out.println(e.getEncargado());
//                                System.out.println(e.getNuevo_encargado());
//                                
//                               // System.out.println(e.getCedula_funcionario());
//                            }
                            
                        
    //                    }

//           for(Bodega e : FBodega.obtenerTodaslasbodegas())
//                          System.out.println(e.getUbicacion());        
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                        }
             
                         
                         //probar obtener por codigo
//                     
//                     try {
//                        for(Detalle_Mov e : FDetalle_Mov.obtenerdetalles_mov_ced("0603456875"))
//                         // Detalle_Mov e1 = FDetalle_Mov.obtenerdetalles_mov_ced("0603456875");             
//                               System.out.println(e1.getNuevo_encargado());
//                               // System.out.println(e.getCedula_funcionario());        
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                        }
//                     try {
//                         Detalle_Mov e = new Detalle_Mov(date, 2, "0603783846", "0603783846", 2);
//                         Funcionario_Rol e= FFuncionario_Rol.obtenerFuncionarioRol_xcodigo_reporte("0603456875");           
//                                System.out.println(e.getId_rol().getNombre_rol());
                                //System.out.println(e.getEncargado());
//                               // System.out.println(e.getCedula_funcionario());        
//                        } catch (Exception e) {
//                            System.out.println("Error al insertar"+e.getMessage());
//                        }
//                        Unidad e= FUnidad.obtenerUnidad_xnombre("Colta");
//                        System.out.println(e.getUbicacion_unidad());
//                        System.out.println(e.getId_unidad());
                        // aqui obtengo el camino absoluto de mi directorio actual
//String directorio = System.getProperty("user.dir");
//
//// aqui obtengo el tipo de separador que hay entre las carpetas
//String separador = System.getProperty("file.separator");
//      //  Icon icono=new ImageIcon(directorio+separador+"com"+separador+"magapinv"+separador+"www"+separador+"interfacesmagap"+separador+"recursos"+separador+"logo_magap");
//       
//String dire= directorio+separador+"com"+separador+"magapinv"+separador+"www"+separador+"interfacesmagap"+separador+"recursos"+separador+"logo_magap";
//// cargo en mi clase Properties() el fichero que necesito
////props.load(new FileInputStream(directorio + separador + "src\\nombre_proyecto\\ressources\\propiedades.pro perties"));
//
////si imprimes por pantalla con un 
//System.out.println(dire); 
//se entiende mejor que devuelve la funcion getProperty()
    //                 
                         
                         try {
                              for(Inventario e: FInventario.obtenertodoslosInventarios()){ 
                                             
                                System.out.println(e.getId_equipo());}
                                //System.out.println(e.getCedula_funcionario());        
                        } catch (Exception e) {
                            System.out.println("Error al obtenter"+e.getMessage());
                        }
//             FFuncionario_Rol.actualizarFuncionario_Rol_xrol("0001233342",2,1,date1,null,"2222");
//
//          // }
//           //     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//           // }
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
       //     Movimiento_Inventario_Responsable e = new Movimiento_Inventario_Responsable();
//      e.setVisible(true);
     }
}
    
         
    


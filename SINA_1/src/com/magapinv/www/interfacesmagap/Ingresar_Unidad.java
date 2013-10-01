/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.interfacesmagap;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.accesodatos.Global;
import com.magapinv.www.logicanegocios.clases.*;
import com.magapinv.www.logicanegocios.funciones.*;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
//import java.sql.Date;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
import javax.swing.JTextField;
import sun.misc.Cleaner;
//import javax.swing.table.DefaultTableModel;
//import org.postgresql.Driver;

/**
 *
 * @author User
 */
public class Ingresar_Unidad extends javax.swing.JFrame {
DefaultListModel modelo= new DefaultListModel();
DefaultListModel modelo2= new DefaultListModel();
DefaultListModel modelo3= new DefaultListModel();
DefaultListModel modelo4= new DefaultListModel();
DefaultListModel modelo5= new DefaultListModel();
DefaultListModel modelo6= new DefaultListModel();
DefaultListModel modeloModificarRol= new DefaultListModel();
DefaultListModel modeloModificarUnidad = new DefaultListModel();
DefaultListModel modeloModificarEstadoInventario = new DefaultListModel();
DefaultListModel modeloEliminarEstadoInventario = new DefaultListModel();
DefaultListModel modeloModificarTipoMovimiento = new DefaultListModel();
DefaultListModel modeloEliminarTipoMovimiento = new DefaultListModel();
DefaultListModel modeloModificarFuncionarioRol= new DefaultListModel();
DefaultListModel modeloModificarFuncionarioRol2= new DefaultListModel();
DefaultListModel modeloModificarFuncionarioRol3= new DefaultListModel();
DefaultListModel modeloModificarFuncionarioRol4= new DefaultListModel();
DefaultListModel modeloModificarBodega = new DefaultListModel();
DefaultListModel modeloModificarMovimiento= new DefaultListModel();
        
    public Ingresar_Unidad() {
        initComponents();
              
         try {
            cmbestadoInventario.removeAllItems();
            cmbestadoInventario_ModificarArticulo.removeAllItems();
            for(Estado_ac e: FEstado_ac.obtenerTodoslosEstado_ac()){
              
                cmbestadoInventario.addItem(e.getNombre_estado());
                cmbestadoInventario_ModificarArticulo.addItem(e.getNombre_estado());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box estados"+e.getMessage());
        }
        try {
            cmbcategoriaInventario.removeAllItems();
            cmbcategoriaInventario_ModificarArticulo.removeAllItems();
            for(Categoria e: FCategoria.obtenerTodaslascategorias()){
              
                cmbcategoriaInventario.addItem(e.getNombre_categoria());
                cmbcategoriaInventario_ModificarArticulo.addItem(e.getNombre_categoria());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box "+e.getMessage());
        }
        
        try {
            cmbbodegaInventario.removeAllItems();
            cmbbodegarfuncionarioRolBodega.removeAllItems();
            cmbbodegaInventario_ModificarArticulo.removeAllItems();
            for(Bodega e: FBodega.obtenerTodaslasbodegas()){
                
                cmbbodegaInventario.addItem(e.getUbicacion());
                cmbbodegaInventario_ModificarArticulo.addItem(e.getUbicacion());
            }
            for(Bodega e: FBodega.obtenerTodaslasbodegas()){
                
                cmbbodegarfuncionarioRolBodega.addItem(e.getUbicacion());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box"+e.getMessage());
        }
        
           try {
            cmbrolFuncionario.removeAllItems();
            cmbrolFuncionarioRolModificar.removeAllItems();
            for(Rol e: FRol.obtenerTodoslosRoles()){
               
                cmbrolFuncionario.addItem(e.getNombre_rol());
                cmbrolFuncionarioRolModificar.addItem(e.getNombre_rol());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box rol funcionario"+e.getMessage());
        }
              
        try {
            cmbEliminarCategoria.removeAllItems();
            for(Categoria e: FCategoria.obtenerTodaslascategorias()){
                
                cmbEliminarCategoria.addItem(e.getNombre_categoria());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box categoria"+e.getMessage());
        }      
  
        try {
            cmbEliminarRol.removeAllItems();
            for(Rol e: FRol.obtenerTodoslosRoles()){
                
               cmbEliminarRol.addItem(e.getNombre_rol());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box rol"+e.getMessage());
        } 
        
        
//        try {
//            cmbEliminarUnidad.removeAllItems();
//            for(Unidad e: FUnidad.obtenerTodoaslas_unidades()){
//                cmbEliminarUnidad.addItem(e.getUbicacion_unidad());
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error al mostrar combo Unidades"+e.getMessage());
//        }
//             
        
        
            SoloNumeros(txtstock); //valida que ingrese solo numeros
            
        jScrollPane9.setPreferredSize(jLayered_ModificarArticulo.getSize());  
        cmbestadoInventario.setSelectedIndex(4);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel18 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtnombreCategoria = new javax.swing.JTextField();
        btnnombreCategoria = new javax.swing.JButton();
        jTabbedPane15 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        cmbEliminarCategoria = new javax.swing.JComboBox();
        btnEliminarCategoria = new javax.swing.JButton();
        jTabbedPane22 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jListModificarCategoria = new javax.swing.JList();
        txtModificar_Categoria = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        btn_Actualizar_Categoria = new javax.swing.JButton();
        lbl_id_categoria = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnguadarFuncionario = new javax.swing.JButton();
        txtcedulaFuncionario = new javax.swing.JTextField();
        txtnombresFuncionario = new javax.swing.JTextField();
        txtapellidosFuncionario = new javax.swing.JTextField();
        txttelefonoFuncionario = new javax.swing.JTextField();
        txtemailFuncionario = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        txtcedulaFuncionarioModificar = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtemailFuncionarioModificar = new javax.swing.JTextField();
        txttelefonoFuncionarioModificar = new javax.swing.JTextField();
        txtapellidosFuncionarioModificar = new javax.swing.JTextField();
        txtnombresFuncionarioModificar = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txt_BuscarModificarFuncionario = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListModificarFuncionario = new javax.swing.JList();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListModificarFuncionario1 = new javax.swing.JList();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListModificarFuncionario2 = new javax.swing.JList();
        jLabel61 = new javax.swing.JLabel();
        btnActualizar_Funcionario = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        btnEliminar_Funcionario = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        jListEliminarFuncionario3 = new javax.swing.JList();
        jScrollPane25 = new javax.swing.JScrollPane();
        jListEliminarFuncionario2 = new javax.swing.JList();
        jScrollPane26 = new javax.swing.JScrollPane();
        jListEliminarFuncionario = new javax.swing.JList();
        txt_BuscarEliminarFuncionario = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtnombreRol = new javax.swing.JTextField();
        btnguardarRol = new javax.swing.JButton();
        jTabbedPane16 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        cmbEliminarRol = new javax.swing.JComboBox();
        btnEliminarRol = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jListModificarRol = new javax.swing.JList();
        txtModificar_Rol = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        btn_Actualizar_Rol = new javax.swing.JButton();
        lbl_id_rol = new javax.swing.JLabel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnombreUnidad = new javax.swing.JTextField();
        txtubicacionUnidad = new javax.swing.JTextField();
        txtfuncionUnidad = new javax.swing.JTextField();
        btnguardarUnidad = new javax.swing.JButton();
        jTabbedPane18 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cmbEliminarUnidad = new javax.swing.JComboBox();
        btnEliminarUnidad = new javax.swing.JButton();
        lblEliminarUbicacionUnidad = new javax.swing.JLabel();
        lblEliminarFuncionUnidad = new javax.swing.JLabel();
        lblEliminarUnidadUbicacion = new javax.swing.JLabel();
        lblEliminarUnidadFuncion = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jListModificarUnidad = new javax.swing.JList();
        jLabel66 = new javax.swing.JLabel();
        btn_Actualizar_Unidad = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        txtnombreUnidad_Actualizar = new javax.swing.JTextField();
        txtubicacionUnidad_Actualizar = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtfuncionUnidad_Actualizar = new javax.swing.JTextField();
        lbl_Actualizar_Unidad = new javax.swing.JLabel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtEstado_ac = new javax.swing.JTextField();
        btnGuardarEstado_ac = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jListModificarEstadoInventario = new javax.swing.JList();
        txtModificar_EstadoInventario = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        btn_Actualizar_EstadoInventario = new javax.swing.JButton();
        lbl_id_EstadoInventario = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jListEliminarEstado = new javax.swing.JList();
        txtEliminar_Estado = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        btn_Eliminar_Estado = new javax.swing.JButton();
        lbl_id_categoria1 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        lbl_id_EstadoInventario_eliminar = new javax.swing.JLabel();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnguardarInventario = new javax.swing.JButton();
        txtidentificadorInventario = new javax.swing.JTextField();
        txtmarcaInventario = new javax.swing.JTextField();
        txtmodeloInventario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadescripcionInventario = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        cmbestadoInventario = new javax.swing.JComboBox();
        cmbcategoriaInventario = new javax.swing.JComboBox();
        cmbbodegaInventario = new javax.swing.JComboBox();
        jTabbedPane19 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtBuscarEquipoEliminar = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_articuloEliminar = new javax.swing.JList();
        btnEliminarInventario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_articuloEliminar2 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList_articuloEliminar3 = new javax.swing.JList();
        jTabbedPane20 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txt_BuscarModificarArticulo = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListModificarEquipo = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListModificarEquipo2 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListModificarEquipo3 = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        jLayered_ModificarArticulo = new javax.swing.JLayeredPane();
        txtidentificadorInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtmarcaInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtmodeloInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cmbestadoInventario_ModificarArticulo = new javax.swing.JComboBox();
        cmbcategoriaInventario_ModificarArticulo = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cmbbodegaInventario_ModificarArticulo = new javax.swing.JComboBox();
        txtstockInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        btnActualizarArticuloInventario = new javax.swing.JButton();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtTipoMovimiento = new javax.swing.JTextField();
        btnguardarTipoMovimiento = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jListModificarTipoMovimiento = new javax.swing.JList();
        txtModificar_TipoMovimiento = new javax.swing.JTextField();
        btn_Actualizar_TipoMovimiento = new javax.swing.JButton();
        lbl_id_TipoMovimiento = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        lbl_id_TipoMovimiento_Eliminar = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jListEliminarTipoMovimiento = new javax.swing.JList();
        txtEliminar_TipoMovimiento = new javax.swing.JTextField();
        btn_Eliminar_TipoMovimiento = new javax.swing.JButton();
        jTabbedPane12 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        datefuncionarioRol = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        btncargarNombreFuncionario = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        btnguardarFuncionarioRol = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtnombreFuncionario = new javax.swing.JTextField();
        txtcedulafuncionarioRol = new javax.swing.JTextField();
        cmbrolFuncionario = new javax.swing.JComboBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel44 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        datefuncionarioRolModificar = new com.toedter.calendar.JDateChooser();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtcedulafuncionarioRolModificar = new javax.swing.JTextField();
        cmbrolFuncionarioRolModificar = new javax.swing.JComboBox();
        btn_Actualizar_FuncionarioRol = new javax.swing.JButton();
        txt_BuscarModificarFuncionarioRol = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        jListModificarFuncionarioRol = new javax.swing.JList();
        jScrollPane19 = new javax.swing.JScrollPane();
        jListModificarFuncionarioRol2 = new javax.swing.JList();
        jLabel75 = new javax.swing.JLabel();
        datefuncionarioRolSalidaModificar = new com.toedter.calendar.JDateChooser();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jListModificarFuncionarioRol3 = new javax.swing.JList();
        jScrollPane21 = new javax.swing.JScrollPane();
        jListModificarFuncionarioRol4 = new javax.swing.JList();
        jLabel53 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel33 = new javax.swing.JPanel();
        txt_BuscarEliminarFuncionarioRol = new javax.swing.JTextField();
        jScrollPane29 = new javax.swing.JScrollPane();
        jListEliminarFuncionarioRol = new javax.swing.JList();
        jScrollPane30 = new javax.swing.JScrollPane();
        jListEliminarFuncionarioRol2 = new javax.swing.JList();
        jScrollPane31 = new javax.swing.JScrollPane();
        jListEliminarFuncionarioRol3 = new javax.swing.JList();
        jScrollPane32 = new javax.swing.JScrollPane();
        jListEliminarFuncionarioRol4 = new javax.swing.JList();
        jLabel86 = new javax.swing.JLabel();
        btn_Eliminar_FuncionarioRol = new javax.swing.JButton();
        jTabbedPane13 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblfuncionaroBodega = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtcedulafuncionarioRolBodega = new javax.swing.JTextField();
        btncargarFuncionarioRolBodega = new javax.swing.JButton();
        cmbbodegarfuncionarioRolBodega = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        datefechaFuncionrioRolBodega = new com.toedter.calendar.JDateChooser();
        btnguardarFuncionarioRolBodega = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txtUbicacionBodega = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BotonGuardarBodega = new javax.swing.JButton();
        FechaBodega = new com.toedter.calendar.JDateChooser();
        jTabbedPane14 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lblUbicacionBodega = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblfechaCreacionBodega = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnEliminarBodega = new javax.swing.JButton();
        jScrollPane33 = new javax.swing.JScrollPane();
        jList_Actualizar_Bodega = new javax.swing.JList();
        jPanel27 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jListModificarBodega = new javax.swing.JList();
        txtUbicacionBodegaModificar = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        btn_Actualizar_Unidad1 = new javax.swing.JButton();
        FechaBodegaModificar = new com.toedter.calendar.JDateChooser();
        jLabel78 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jLabel11.setText("Nombre de la Categoría");

        btnnombreCategoria.setText("Guardar");
        btnnombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnombreCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel11)
                .addGap(68, 68, 68)
                .addComponent(txtnombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnombreCategoria)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtnombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(btnnombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Ingresar Nueva Categoría", jPanel6);

        jLabel34.setText("Nombre Categoría");

        cmbEliminarCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEliminarCategoria.setText("Eliminar");
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel34)
                .addGap(126, 126, 126)
                .addComponent(cmbEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(733, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarCategoria)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cmbEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(570, Short.MAX_VALUE))
        );

        jTabbedPane15.addTab("Datos Categoría", jPanel12);

        jTabbedPane3.addTab("Eliminar Categoría", jTabbedPane15);

        jListModificarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarCategoriaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jListModificarCategoria);

        jLabel54.setText("Categoría");

        btn_Actualizar_Categoria.setText("Actualizar");
        btn_Actualizar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_CategoriaActionPerformed(evt);
            }
        });

        jLabel62.setText("Seleccione para modificar");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Actualizar_Categoria)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtModificar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54)))))
                .addContainerGap(538, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(lbl_id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModificar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Actualizar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(497, Short.MAX_VALUE))
        );

        jTabbedPane22.addTab("Modifique la Categoría", jPanel19);

        jTabbedPane3.addTab("Actualizar Categoría", jTabbedPane22);

        jTabbedPane1.addTab("Categoría", jTabbedPane3);

        jLabel5.setText("Cédula");

        jLabel6.setText("Nombres Completos");

        jLabel7.setText("Apellidos Completos");

        jLabel8.setText("Números Telefónicos ");

        jLabel9.setText("E-mail");

        btnguadarFuncionario.setText("Guardar");
        btnguadarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguadarFuncionarioActionPerformed(evt);
            }
        });

        txtcedulaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaFuncionarioActionPerformed(evt);
            }
        });

        txtemailFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(82, 82, 82)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttelefonoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombresFuncionario)
                    .addComponent(txtapellidosFuncionario)
                    .addComponent(txtcedulaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemailFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguadarFuncionario)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcedulaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnombresFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtapellidosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttelefonoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtemailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnguadarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Ingresar Nuevo Funcionario", jPanel4);

        txtcedulaFuncionarioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaFuncionarioModificarActionPerformed(evt);
            }
        });

        jLabel55.setText("Cédula");

        jLabel56.setText("Nombres Completos");

        jLabel57.setText("Apellidos Completos");

        jLabel58.setText("Números Telefónicos ");

        jLabel59.setText("E-mail");

        txtemailFuncionarioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailFuncionarioModificarActionPerformed(evt);
            }
        });

        jLabel60.setText("Ingrese la CEDULA del funcionario");

        txt_BuscarModificarFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarFuncionarioKeyReleased(evt);
            }
        });

        jListModificarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jListModificarFuncionario);

        jListModificarFuncionario1.setEnabled(false);
        jScrollPane12.setViewportView(jListModificarFuncionario1);

        jListModificarFuncionario2.setEnabled(false);
        jScrollPane13.setViewportView(jListModificarFuncionario2);

        jLabel61.setText("A medida que ingrese el texto se desplegará los resultados");

        btnActualizar_Funcionario.setText("Actualizar");
        btnActualizar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar_FuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttelefonoFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombresFuncionarioModificar)
                            .addComponent(txtapellidosFuncionarioModificar)
                            .addComponent(txtcedulaFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemailFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(jLabel61)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnActualizar_Funcionario))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                    .addComponent(txt_BuscarModificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel61)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnActualizar_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarModificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtcedulaFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtnombresFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtapellidosFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txttelefonoFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtemailFuncionarioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Actualizar Funcionario", jPanel20);

        btnEliminar_Funcionario.setText("Eliminar");
        btnEliminar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_FuncionarioActionPerformed(evt);
            }
        });

        jListEliminarFuncionario3.setEnabled(false);
        jScrollPane24.setViewportView(jListEliminarFuncionario3);

        jListEliminarFuncionario2.setEnabled(false);
        jScrollPane25.setViewportView(jListEliminarFuncionario2);

        jListEliminarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEliminarFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jListEliminarFuncionario);

        txt_BuscarEliminarFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarEliminarFuncionarioKeyReleased(evt);
            }
        });

        jLabel80.setText("A medida que ingrese el texto se desplegará los resultados");

        jLabel79.setText("Ingrese la CEDULA del funcionario");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel80))
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar_Funcionario))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(txt_BuscarEliminarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel79)))
                .addGap(10, 10, 10)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarEliminarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(553, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Eliminar Funcionario", jPanel29);

        jTabbedPane1.addTab("Funcionario", jTabbedPane4);

        jTabbedPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane5MouseClicked(evt);
            }
        });

        jLabel10.setText("Nombre del Rol");

        btnguardarRol.setText("Guardar");
        btnguardarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addGap(57, 57, 57)
                .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarRol)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnguardarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(578, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Ingresar Nuevo Rol", jPanel5);

        jLabel36.setText("Nombre del Rol");

        cmbEliminarRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEliminarRol.setText("Eliminar");
        btnEliminarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel36)
                .addGap(91, 91, 91)
                .addComponent(cmbEliminarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(791, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarRol)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cmbEliminarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEliminarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
        );

        jTabbedPane16.addTab("Datos Rol", jPanel13);

        jTabbedPane5.addTab("Eliminar Nuevo Rol", jTabbedPane16);

        jLabel63.setText("Seleccione para modificar");

        jListModificarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarRolMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(jListModificarRol);

        jLabel64.setText("Rol");

        btn_Actualizar_Rol.setText("Actualizar");
        btn_Actualizar_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_RolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Actualizar_Rol)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtModificar_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel64)))))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel63)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(lbl_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModificar_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Actualizar_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(507, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Actualizar Rol", jPanel21);

        jTabbedPane1.addTab("Rol", jTabbedPane5);

        jTabbedPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane6MouseClicked(evt);
            }
        });

        jLabel12.setText("Nombre de la Unidad");

        jLabel13.setText("Ubicación de la Unidad");

        jLabel14.setText("Función de la Unidad");

        txtnombreUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreUnidadActionPerformed(evt);
            }
        });

        btnguardarUnidad.setText("Guardar");
        btnguardarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombreUnidad)
                    .addComponent(txtubicacionUnidad)
                    .addComponent(txtfuncionUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(414, 414, 414))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarUnidad)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtnombreUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13))
                    .addComponent(txtubicacionUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfuncionUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Ingresar Nueva Unidad", jPanel7);

        jLabel37.setText("Nombre de la Unidad ");

        jLabel38.setText("Ubicación de la Unidad");

        jLabel39.setText("Función de la Unidad");

        cmbEliminarUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEliminarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEliminarUnidadActionPerformed(evt);
            }
        });

        btnEliminarUnidad.setText("Eliminar");
        btnEliminarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(btnEliminarUnidad)
                        .addContainerGap())
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblEliminarUnidadFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbEliminarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGap(303, 303, 303)
                                            .addComponent(lblEliminarFuncionUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(lblEliminarUnidadUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblEliminarUbicacionUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                                .addContainerGap(240, Short.MAX_VALUE))))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(cmbEliminarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEliminarUbicacionUnidad)
                    .addComponent(jLabel38)
                    .addComponent(lblEliminarUnidadUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblEliminarUnidadFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnEliminarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(lblEliminarFuncionUnidad)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jTabbedPane18.addTab("Datos Unidad", jPanel14);

        jTabbedPane6.addTab("Eliminar Unidad", jTabbedPane18);

        jListModificarUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarUnidadMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(jListModificarUnidad);

        jLabel66.setText("Seleccione para modificar");

        btn_Actualizar_Unidad.setText("Actualizar");
        btn_Actualizar_Unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_UnidadActionPerformed(evt);
            }
        });

        jLabel67.setText("Nombre de la Unidad");

        txtubicacionUnidad_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtubicacionUnidad_ActualizarActionPerformed(evt);
            }
        });

        jLabel68.setText("Ubicación de la Unidad");

        jLabel69.setText("Función de la Unidad");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(53, 53, 53)
                        .addComponent(lbl_Actualizar_Unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_Actualizar_Unidad))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel67))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnombreUnidad_Actualizar)
                                    .addComponent(txtubicacionUnidad_Actualizar)
                                    .addComponent(txtfuncionUnidad_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(438, 438, 438))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(lbl_Actualizar_Unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel67)
                                    .addComponent(txtnombreUnidad_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(jLabel68))
                            .addComponent(txtubicacionUnidad_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfuncionUnidad_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69))))
                .addGap(37, 37, 37)
                .addComponent(btn_Actualizar_Unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(444, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Actualizar Unidad", jPanel22);

        jTabbedPane1.addTab("Unidad", jTabbedPane6);

        jTabbedPane7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane7MouseClicked(evt);
            }
        });

        jLabel15.setText("Nombre de Estado");

        btnGuardarEstado_ac.setText("Guardar");
        btnGuardarEstado_ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstado_acActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel15)
                .addGap(60, 60, 60)
                .addComponent(txtEstado_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarEstado_ac)
                .addGap(397, 397, 397))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEstado_ac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnGuardarEstado_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Ingresar Nuevo Estado de Inventario", jPanel8);

        jListModificarEstadoInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarEstadoInventarioMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jListModificarEstadoInventario);

        jLabel65.setText("Seleccione para modificar");

        btn_Actualizar_EstadoInventario.setText("Actualizar");
        btn_Actualizar_EstadoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_EstadoInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id_EstadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Actualizar_EstadoInventario)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txtModificar_EstadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_id_EstadoInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtModificar_EstadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Actualizar_EstadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Actualizar Inventario", jPanel23);

        jListEliminarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEliminarEstadoMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(jListEliminarEstado);

        jLabel83.setText("Estado");

        btn_Eliminar_Estado.setText("Eliminar");
        btn_Eliminar_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eliminar_EstadoActionPerformed(evt);
            }
        });

        jLabel84.setText("Seleccione para modificar");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel84)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_id_EstadoInventario_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addComponent(lbl_id_categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEliminar_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel83))))
                    .addComponent(btn_Eliminar_Estado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(538, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_id_EstadoInventario_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel84)))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(lbl_id_categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEliminar_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Eliminar_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(488, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
        );

        jTabbedPane7.addTab("Eliminar Estado ", jPanel30);

        jTabbedPane1.addTab("Estado Inventario", jTabbedPane7);

        jTabbedPane11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane11MouseClicked(evt);
            }
        });

        jLabel16.setText("Identificador/Nombre");

        jLabel17.setText("Marca");

        jLabel18.setText("Modelo");

        jLabel19.setText("Estado");

        jLabel20.setText("Categoría");

        jLabel21.setText("Bodega de Almacenamiento");

        jLabel22.setText("Stock");

        btnguardarInventario.setText("Guardar");
        btnguardarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarInventarioActionPerformed(evt);
            }
        });

        txtmarcaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmarcaInventarioActionPerformed(evt);
            }
        });

        txtadescripcionInventario.setColumns(20);
        txtadescripcionInventario.setRows(5);
        jScrollPane1.setViewportView(txtadescripcionInventario);

        jLabel23.setText("Descripción");

        cmbestadoInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbcategoriaInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbbodegaInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23))
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtidentificadorInventario)
                    .addComponent(jScrollPane1)
                    .addComponent(txtmodeloInventario)
                    .addComponent(txtmarcaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbbodegaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcategoriaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbestadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardarInventario))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtidentificadorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cmbestadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtmarcaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cmbcategoriaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtmodeloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cmbbodegaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(btnguardarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jTabbedPane11.addTab("Insertar nuevo artículo de inventario", jPanel2);

        jLabel40.setText("Identificador equipo");

        txtBuscarEquipoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEquipoEliminarActionPerformed(evt);
            }
        });
        txtBuscarEquipoEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEquipoEliminarKeyReleased(evt);
            }
        });

        jLabel42.setText("A medida que ingrese el texto se desplegará los resultados");

        jList_articuloEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_articuloEliminarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList_articuloEliminar);

        btnEliminarInventario.setText("Eliminar");
        btnEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInventarioActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList_articuloEliminar2);

        jScrollPane5.setViewportView(jList_articuloEliminar3);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel42))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarEquipoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarInventario)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtBuscarEquipoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnEliminarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane19.addTab("Datos artículo inventario", jPanel15);

        jTabbedPane11.addTab("Eliminar artículo de inventario", jTabbedPane19);

        jLabel41.setText("A medida que ingrese el texto se desplegará los resultados");

        txt_BuscarModificarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarArticuloKeyReleased(evt);
            }
        });

        jLabel43.setText("Ingrese el ID del equipo");

        jListModificarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarEquipoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListModificarEquipo);

        jScrollPane6.setViewportView(jListModificarEquipo2);

        jScrollPane7.setViewportView(jListModificarEquipo3);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLayered_ModificarArticulo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Actuales si desea los puede modificar"));
        jLayered_ModificarArticulo.setName(""); // NOI18N
        txtidentificadorInventario_ModificarArticulo.setBounds(190, 30, 254, 30);
        jLayered_ModificarArticulo.add(txtidentificadorInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel45.setText("Identificador/Nombre");
        jLabel45.setBounds(20, 40, 130, 14);
        jLayered_ModificarArticulo.add(jLabel45, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtmarcaInventario_ModificarArticulo.setBounds(190, 70, 254, 30);
        jLayered_ModificarArticulo.add(txtmarcaInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel46.setText("Marca");
        jLabel46.setBounds(20, 80, 90, 14);
        jLayered_ModificarArticulo.add(jLabel46, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtmodeloInventario_ModificarArticulo.setBounds(190, 110, 254, 30);
        jLayered_ModificarArticulo.add(txtmodeloInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel47.setText("Modelo");
        jLabel47.setBounds(20, 120, 90, 14);
        jLayered_ModificarArticulo.add(jLabel47, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane8.setViewportView(jTextArea1);

        jScrollPane8.setBounds(190, 150, 254, 96);
        jLayered_ModificarArticulo.add(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel48.setText("Descripción");
        jLabel48.setBounds(20, 150, 100, 14);
        jLayered_ModificarArticulo.add(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel49.setText("Estado");
        jLabel49.setBounds(480, 40, 90, 14);
        jLayered_ModificarArticulo.add(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbestadoInventario_ModificarArticulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbestadoInventario_ModificarArticulo.setBounds(720, 40, 200, 20);
        jLayered_ModificarArticulo.add(cmbestadoInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbcategoriaInventario_ModificarArticulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbcategoriaInventario_ModificarArticulo.setBounds(720, 80, 200, 20);
        jLayered_ModificarArticulo.add(cmbcategoriaInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel50.setText("Categoría");
        jLabel50.setBounds(480, 80, 110, 14);
        jLayered_ModificarArticulo.add(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel51.setText("Bodega de Almacenamiento");
        jLabel51.setBounds(480, 120, 160, 14);
        jLayered_ModificarArticulo.add(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbbodegaInventario_ModificarArticulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbodegaInventario_ModificarArticulo.setBounds(720, 110, 200, 20);
        jLayered_ModificarArticulo.add(cmbbodegaInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtstockInventario_ModificarArticulo.setBounds(720, 160, 164, 30);
        jLayered_ModificarArticulo.add(txtstockInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel52.setText("Stock");
        jLabel52.setBounds(480, 160, 80, 14);
        jLayered_ModificarArticulo.add(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane9.setViewportView(jLayered_ModificarArticulo);
        jLayered_ModificarArticulo.getAccessibleContext().setAccessibleDescription("");

        btnActualizarArticuloInventario.setText("Actualizar Articulo");
        btnActualizarArticuloInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarArticuloInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(txt_BuscarModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarArticuloInventario))))
                .addGap(74, 74, 74))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel41))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnActualizarArticuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        jTabbedPane20.addTab("Datos artículo inventario", jPanel16);

        jTabbedPane11.addTab("Modificar Atributos de artículo Inventario", jTabbedPane20);

        jTabbedPane1.addTab("Inventario", jTabbedPane11);

        jTabbedPane10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane10MouseClicked(evt);
            }
        });

        jLabel25.setText("Tipo de Movimiento");

        btnguardarTipoMovimiento.setText("Guardar");
        btnguardarTipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarTipoMovimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel25)
                .addGap(125, 125, 125)
                .addComponent(txtTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(586, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarTipoMovimiento)
                .addGap(430, 430, 430))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(btnguardarTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Insertar Nuevo tipo de Movimiento", jPanel1);

        jLabel70.setText("Seleccione para modificar");

        jListModificarTipoMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarTipoMovimientoMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(jListModificarTipoMovimiento);

        btn_Actualizar_TipoMovimiento.setText("Actualizar");
        btn_Actualizar_TipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_TipoMovimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Actualizar_TipoMovimiento)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txtModificar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_id_TipoMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtModificar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Actualizar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Actualizar Tipo de Movimiento", jPanel24);

        jLabel85.setText("Seleccione para modificar");

        jListEliminarTipoMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEliminarTipoMovimientoMouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(jListEliminarTipoMovimiento);

        btn_Eliminar_TipoMovimiento.setText("Eliminar");
        btn_Eliminar_TipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eliminar_TipoMovimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id_TipoMovimiento_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Eliminar_TipoMovimiento)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txtEliminar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_id_TipoMovimiento_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtEliminar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Eliminar_TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Eliminar Tipo de Movimiento", jPanel32);

        jTabbedPane1.addTab("Tipo Movimiento", jTabbedPane10);

        jTabbedPane12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane12MouseClicked(evt);
            }
        });

        datefuncionarioRol.setMaxSelectableDate(new java.util.Date(253370786515000L));

        jLabel24.setText("Fecha Asignación del rol");

        btncargarNombreFuncionario.setText("Cargar Nombre");
        btncargarNombreFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarNombreFuncionarioActionPerformed(evt);
            }
        });

        jLabel26.setText("Rol");

        btnguardarFuncionarioRol.setText("Guardar");
        btnguardarFuncionarioRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarFuncionarioRolActionPerformed(evt);
            }
        });

        jLabel27.setText("Cédula del Funcionario");

        jLabel28.setText("Nombre del Funcionario");

        cmbrolFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbrolFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbrolFuncionarioActionPerformed(evt);
            }
        });

        jLabel44.setText("Password ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel44))
                .addGap(64, 64, 64)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbrolFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(datefuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnguardarFuncionarioRol))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(txtcedulafuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncargarNombreFuncionario))
                        .addComponent(txtnombreFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtcedulafuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarNombreFuncionario))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtnombreFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cmbrolFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(datefuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnguardarFuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jTabbedPane12.addTab("Ingresar Funcionario Rol", jPanel9);

        jLabel71.setText("Fecha Asignacion del rol");

        jLabel72.setText("Rol");

        jLabel73.setText("Cédula del Funcionario");

        cmbrolFuncionarioRolModificar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbrolFuncionarioRolModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbrolFuncionarioRolModificarActionPerformed(evt);
            }
        });

        btn_Actualizar_FuncionarioRol.setText("Actualizar");
        btn_Actualizar_FuncionarioRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_FuncionarioRolActionPerformed(evt);
            }
        });

        txt_BuscarModificarFuncionarioRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarFuncionarioRolKeyReleased(evt);
            }
        });

        jListModificarFuncionarioRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarFuncionarioRolMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(jListModificarFuncionarioRol);

        jListModificarFuncionarioRol2.setEnabled(false);
        jScrollPane19.setViewportView(jListModificarFuncionarioRol2);

        jLabel75.setText("A medida que ingrese el texto se desplegará los resultados");

        jLabel76.setText("Fecha Salida del rol");

        jListModificarFuncionarioRol3.setEnabled(false);
        jScrollPane20.setViewportView(jListModificarFuncionarioRol3);

        jListModificarFuncionarioRol4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarFuncionarioRol4MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(jListModificarFuncionarioRol4);

        jLabel53.setText("Password");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel75))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel53))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datefuncionarioRolSalidaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbrolFuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datefuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcedulafuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Actualizar_FuncionarioRol))))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txt_BuscarModificarFuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel75)
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(txt_BuscarModificarFuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(txtcedulafuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel72)
                                    .addComponent(cmbrolFuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(datefuncionarioRolModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datefuncionarioRolSalidaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Actualizar_FuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE)))
        );

        jTabbedPane12.addTab("Actualizar Funcionario Rol", jPanel25);

        txt_BuscarEliminarFuncionarioRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarEliminarFuncionarioRolKeyReleased(evt);
            }
        });

        jListEliminarFuncionarioRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEliminarFuncionarioRolMouseClicked(evt);
            }
        });
        jScrollPane29.setViewportView(jListEliminarFuncionarioRol);

        jListEliminarFuncionarioRol2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEliminarFuncionarioRol2MouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(jListEliminarFuncionarioRol2);

        jListEliminarFuncionarioRol3.setEnabled(false);
        jScrollPane31.setViewportView(jListEliminarFuncionarioRol3);

        jListEliminarFuncionarioRol4.setEnabled(false);
        jScrollPane32.setViewportView(jListEliminarFuncionarioRol4);

        jLabel86.setText("A medida que ingrese el texto se desplegará los resultados");

        btn_Eliminar_FuncionarioRol.setText("Eliminar");
        btn_Eliminar_FuncionarioRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eliminar_FuncionarioRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(btn_Eliminar_FuncionarioRol))
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addComponent(txt_BuscarEliminarFuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel86)
                .addGap(34, 34, 34)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarEliminarFuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(btn_Eliminar_FuncionarioRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
        );

        jTabbedPane12.addTab("Eliminar Funcionario Rol", jPanel33);

        jTabbedPane1.addTab("Funcionario Rol", jTabbedPane12);

        jLabel29.setText("Cédula de Funcionario");

        lblfuncionaroBodega.setText("Presiona el botón cargar para desplegar el nombre del Funcionario");

        jLabel31.setText("Bodega asignada");

        btncargarFuncionarioRolBodega.setText("Cargar Nombre");
        btncargarFuncionarioRolBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarFuncionarioRolBodegaActionPerformed(evt);
            }
        });

        cmbbodegarfuncionarioRolBodega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel30.setText("Fecha de Ingreso");

        btnguardarFuncionarioRolBodega.setText("Guardar");
        btnguardarFuncionarioRolBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarFuncionarioRolBodegaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addGap(88, 88, 88)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbbodegarfuncionarioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblfuncionaroBodega)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(txtcedulafuncionarioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncargarFuncionarioRolBodega)))
                    .addComponent(datefechaFuncionrioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarFuncionarioRolBodega)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtcedulafuncionarioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarFuncionarioRolBodega))
                .addGap(18, 18, 18)
                .addComponent(lblfuncionaroBodega)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cmbbodegarfuncionarioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(datefechaFuncionrioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnguardarFuncionarioRolBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );

        jTabbedPane13.addTab("Ingresar Funcionario Rol Bodega", jPanel10);

        jTabbedPane1.addTab("Funcionario Rol Bodega", jTabbedPane13);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jLabel3.setText("Ubicación de la bodega");

        jLabel4.setText("Fecha de creación de la bodega");

        BotonGuardarBodega.setText("Guardar");
        BotonGuardarBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarBodegaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUbicacionBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(FechaBodega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(577, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonGuardarBodega)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacionBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(FechaBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(BotonGuardarBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(487, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Datos Bodega", jPanel3);

        jTabbedPane2.addTab("Ingresar Nueva Bodega", jTabbedPane8);

        jLabel32.setText("Seleccione la Bodega que desa Eliminar");

        jLabel33.setText("Ubicación de la Bodega");

        jLabel35.setText("Fecha de Creación");

        btnEliminarBodega.setText("Eliminar");
        btnEliminarBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBodegaActionPerformed(evt);
            }
        });

        jList_Actualizar_Bodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_Actualizar_BodegaMouseClicked(evt);
            }
        });
        jScrollPane33.setViewportView(jList_Actualizar_Bodega);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35))
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUbicacionBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblfechaCreacionBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                        .addComponent(btnEliminarBodega))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnEliminarBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(lblUbicacionBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfechaCreacionBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        jTabbedPane14.addTab("Datos Bodega", jPanel11);

        jTabbedPane2.addTab("Eliminar Atributos de Bodega", jTabbedPane14);

        jLabel74.setText("Seleccione para modificar");

        jListModificarBodega.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListModificarBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarBodegaMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(jListModificarBodega);

        jLabel77.setText("Ubicación de la bodega");

        btn_Actualizar_Unidad1.setText("Actualizar");
        btn_Actualizar_Unidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_Unidad1ActionPerformed(evt);
            }
        });

        jLabel78.setText("Fecha de creación de la bodega");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(879, 879, 879))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(jLabel77))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(FechaBodegaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Actualizar_Unidad1))
                            .addComponent(txtUbicacionBodegaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel74)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtUbicacionBodegaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(FechaBodegaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addComponent(btn_Actualizar_Unidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Actualizar Bodega", jPanel27);

        jTabbedPane1.addTab("Bodega", jTabbedPane2);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/magapinv/www/interfacesmagap/recursos/logo_magap.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/magapinv/www/interfacesmagap/recursos/LOGO SSTRA1.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 150));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel87.setText("ADMINISTRACIÓN");

        jMenu2.setText("Ayuda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Reportes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu4.setText("A cerca de ");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void SoloNumeros(JTextField stock){
    stock.addKeyListener(new KeyAdapter() {       
        @Override
    public void keyTyped(KeyEvent a){
       char c = a.getKeyChar();
       if(Character.isLetter(c)){
           getToolkit().beep();
           a.consume();
       }
     }
    });
    }
    
public void SoloLetras(JTextField stock){
    stock.addKeyListener(new KeyAdapter() {
        @Override
    public void keyTyped(KeyEvent a){
       char c = a.getKeyChar();
       if(Character.isDigit(c)){
           getToolkit().beep();
           a.consume();
       }
     }
    });
    }

    private boolean validaIngresoFuncionarioNulos(){
        boolean ban = false;
            if(txtcedulaFuncionario.getText().isEmpty() || txtnombresFuncionario.getText().isEmpty() || txtapellidosFuncionario.getText().isEmpty() || txttelefonoFuncionario.getText().isEmpty() || txtemailFuncionario.getText().isEmpty()){
                ban =true;
            }
        return ban;
    }
    private boolean validaActualizarFuncionarioNulos(){
        boolean ban = false;
            if(txtcedulaFuncionarioModificar.getText().isEmpty() || txtnombresFuncionarioModificar.getText().isEmpty() || txtapellidosFuncionarioModificar.getText().isEmpty() || txttelefonoFuncionarioModificar.getText().isEmpty() || txtemailFuncionarioModificar.getText().isEmpty()){
                ban =true;
            }
        return ban;
    }

    
    public static java.sql.Date formatoFecha(String fechaBodega) throws ParseException{
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateStr = formatter.parse(fechaBodega);

            java.sql.Date sqlDate = new java.sql.Date(dateStr.getTime());
        return sqlDate;
    }
       
    private void actualizarRol(){
    try {
            cmbEliminarRol.removeAllItems();
            for(Rol e: FRol.obtenerTodoslosRoles()){
                cmbEliminarRol.addItem(e.getNombre_rol());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box rol"+e.getMessage());
        }
    }
    
    
    private void actualizarUnidadcmb(){
        try {
            cmbEliminarUnidad.removeAllItems();
            for(Unidad e: FUnidad.obtenerTodoaslas_unidades()){
                cmbEliminarUnidad.addItem(e.getUbicacion_unidad());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box rol"+e.getMessage());
        }
    }
     private boolean verificarIngresarInventarioNulos(){
        boolean ban = false;      
        if( txtidentificadorInventario.getText().isEmpty() || txtmarcaInventario.getText().isEmpty() || txtmodeloInventario.getText().isEmpty() || txtadescripcionInventario.getText().isEmpty() || txtstock.getText().isEmpty()){
            ban=true;
        }
        return ban;
    }
    
    private void actualizar_equipo()throws Exception{
    try {
            // TODO add your handling code here:
    //        int xaxis1 = Integer.parseInt(txt_BuscarModificarArticulo.getText());
            txt_BuscarModificarArticulo.setText(jListModificarEquipo.getSelectedValue().toString());
            int xaxis1 = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getStock();      
            txtidentificadorInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo());
            txtmarcaInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getMarca());
            txtmodeloInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getModelo());
            jTextArea1.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getDescripcion());
            cmbestadoInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_estado().getNombre_estado());
            cmbcategoriaInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_categoria().getNombre_categoria());           
            cmbbodegaInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_bodega().getUbicacion());            
            String Stock = String.valueOf(xaxis1); 
            txtstockInventario_ModificarArticulo.setText(Stock);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verificarModificarArticulosInventario(){
    boolean ban=false;
        if(txtidentificadorInventario_ModificarArticulo.getText().isEmpty()){
        ban=true;
        }
        if(txtmarcaInventario_ModificarArticulo.getText().isEmpty()){
        ban=true;
        }
            if(txtmodeloInventario_ModificarArticulo.getText().isEmpty()){
        ban=true;
        }
            if(jTextArea1.getText().isEmpty()){
        ban=true;
        }
            if(txtstockInventario_ModificarArticulo.getText().isEmpty()){
        ban=true;
        }
        return ban; 
    }
    
    
    private void actualizar_jListModificarRol(){
        try {
            String sql ="Select * from bodega.rol";
   
                ConjuntoResultado cres=null;
                cres = AccesoDatos.ejecutaQuery(sql);
                modeloModificarRol.clear();
                while (cres.next()){
                modeloModificarRol.addElement(cres.getObject(1));                   
                }

                this.jListModificarRol.setModel(modeloModificarRol);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
       private void actualizar_jListModificarUnidad(){
        try {
                    String sql ="Select * from bodega.unidad";
           
                        ConjuntoResultado cres=null;
                        cres = AccesoDatos.ejecutaQuery(sql);
                        modeloModificarUnidad.clear();
                        while (cres.next()){
                        modeloModificarUnidad.addElement(cres.getObject(2));                   
                        }

                        this.jListModificarUnidad.setModel(modeloModificarUnidad);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizar_jListModificarEstadoInventario(){
        try {
            String sql ="Select * from bodega.estado_ac";
   
                ConjuntoResultado cres=null;
                cres = AccesoDatos.ejecutaQuery(sql);
                modeloModificarEstadoInventario.clear();
                modeloEliminarEstadoInventario.clear();
                while (cres.next()){
                modeloModificarEstadoInventario.addElement(cres.getObject(1));    
                modeloEliminarEstadoInventario.addElement(cres.getObject(1));
                }
                this.jListModificarEstadoInventario.setModel(modeloModificarEstadoInventario);
                this.jListEliminarEstado.setModel(modeloEliminarEstadoInventario);
                
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     private void actualizar_jListModificarTipoMovimiento(){
        try {
            String sql ="Select * from bodega.tipo_movimiento";
          
                       ConjuntoResultado cres=null;
                       cres = AccesoDatos.ejecutaQuery(sql);
                       modeloModificarTipoMovimiento.clear();
                       modeloEliminarTipoMovimiento.clear();
                       while (cres.next()){
                       modeloModificarTipoMovimiento.addElement(cres.getObject(1));
                       modeloEliminarTipoMovimiento.addElement(cres.getObject(1));
                       }
                       this.jListModificarTipoMovimiento.setModel(modeloModificarTipoMovimiento);
                       this.jListEliminarTipoMovimiento.setModel(modeloEliminarTipoMovimiento);
                       
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
        private void actualizar_jListModificarBodega(){
        try {
            String sql ="Select * from bodega.bodega";
          
                       ConjuntoResultado cres=null;
                       cres = AccesoDatos.ejecutaQuery(sql);
                       modeloModificarBodega.clear();
                       while (cres.next()){
                       modeloModificarBodega.addElement(cres.getObject(1));
                       }

                       this.jListModificarBodega.setModel(modeloModificarBodega);
                       this.jList_Actualizar_Bodega.setModel(modeloModificarBodega);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
    private void acualizarFuncionarioRol(){
        try {
            int id_rol =  FRol.obtenerRoles_xnombre(jListModificarFuncionarioRol4.getSelectedValue().toString()).getId_rol();       
           cmbrolFuncionarioRolModificar.setSelectedItem(FFuncionario_Rol.obtenerFuncionarioRol_xcodigo(txt_BuscarModificarFuncionarioRol.getText(),id_rol).getId_rol().getNombre_rol());
           txtcedulafuncionarioRolModificar.setText(jListModificarFuncionarioRol.getSelectedValue().toString());
           datefuncionarioRolModificar.setDate(FFuncionario_Rol.obtenerFuncionarioRol_xcodigo(txt_BuscarModificarFuncionarioRol.getText(),id_rol).getFecha_asignacion());
           datefuncionarioRolSalidaModificar.setDate(FFuncionario_Rol.obtenerFuncionarioRol_xcodigo(txt_BuscarModificarFuncionarioRol.getText(),id_rol).getFecha_salida());
        } catch (Exception ex) {
             //Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
             //JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
         
    }
    
    
//    private void actualizarjListModificarMovimientos(){
//     try {
//            String sql ="Select * from bodega.movimientos";
//          
//                       ConjuntoResultado cres=null;
//                       cres = AccesoDatos.ejecutaQuery(sql);
//                       modeloModificarMovimiento.clear();
//                       while (cres.next()){
//                       modeloModificarMovimiento.addElement(cres.getObject(1));
//                       }
//                       this.jListModificarMovimientos.setModel(modeloModificarMovimiento);
//        } catch (Exception ex) {
//            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
         try{
            File directorio = new File("temp"); //Creas un nuevo directorio a nivel de tu jar.
            directorio.mkdirs();
            directorio.setWritable(true);
            //copias la direccion
            String archivo = directorio.getCanonicalPath() + File.pathSeparator + "erfc.pdf";
            //nuevo archivo en esa direccion
            File temp = new File(archivo);
            InputStream is = this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/Manual_de_Adimistrador_del_sistema_de_inventario_Automatizado_SINA.pdf");
            FileOutputStream archivoDestino = new FileOutputStream(temp);
            FileWriter fw = new FileWriter(temp);
            byte[] buffer = new byte[512*1024];
            //lees el archivo hasta que se acabe...
            int nbLectura;
            while ((nbLectura = is.read(buffer)) != -1)
                archivoDestino.write(buffer, 0, nbLectura);
            //cierras el archivo,el inputS y el FileW
            fw.close();
            archivoDestino.close();
            is.close();
            //abres el archivo temporal
            Desktop.getDesktop().open(temp);
        } catch (IOException ex) {
            System.out.println("Problema abriendo el pdf de erfc");
        }

        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        SoloNumeros(txtcedulaFuncionario);
        SoloNumeros(txtcedulaFuncionarioModificar);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        actualizar_jListModificarBodega();
        // actualizarBodega();
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void btn_Actualizar_Unidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_Unidad1ActionPerformed
        try {
            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(FechaBodegaModificar.getDate());
            java.sql.Date fecha;
            fecha = formatoFecha(fechaBodega);
            FBodega.actualizar_Bodega_xnombre(jListModificarBodega.getSelectedValue().toString(), txtUbicacionBodegaModificar.getText(), fecha);
            JOptionPane.showMessageDialog(rootPane, "Unidad Actualizada", "EXITO", WIDTH);

        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos no sean nulos ", "ERROR", WIDTH);

        }
        actualizar_jListModificarBodega();
        lblUbicacionBodega.setText("");
        lblfechaCreacionBodega.setText("");
    }//GEN-LAST:event_btn_Actualizar_Unidad1ActionPerformed

    private void jListModificarBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarBodegaMouseClicked
        try {
            // TODO add your handling code here:
            txtUbicacionBodegaModificar.setText(FBodega.obtenerBodega_xnombre(jListModificarBodega.getSelectedValue().toString()).getUbicacion());
            FechaBodegaModificar.setDate(FBodega.obtenerBodega_xnombre(jListModificarBodega.getSelectedValue().toString()).getFecha_creacion());
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarBodegaMouseClicked

    private void jList_Actualizar_BodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_Actualizar_BodegaMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            lblUbicacionBodega.setText(FBodega.obtenerBodega_xnombre(jList_Actualizar_Bodega.getSelectedValue().toString()).getUbicacion());
            lblfechaCreacionBodega.setText(FBodega.obtenerBodega_xnombre(jList_Actualizar_Bodega.getSelectedValue().toString()).getFecha_creacion().toString());
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jList_Actualizar_BodegaMouseClicked

//    private void actualizarBodega(){
//     try {
//            cmbEliminarBodega.removeAllItems();
//            for(Bodega e: FBodega.obtenerTodaslasbodegas()){
//                cmbEliminarBodega.addItem(e.getUbicacion());
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error al mostrar combo box estados"+e.getMessage());
//        }
//    }
    
    private void btnEliminarBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBodegaActionPerformed
        try {
            FBodega.eliminarbodega(FBodega.obtenerBodega_xnombre(lblUbicacionBodega.getText()));
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado una bodega", "EXITO", WIDTH);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un error no se pudo eliminar", "ERROR", WIDTH);
        }
        lblUbicacionBodega.setText("");
        lblfechaCreacionBodega.setText("");
        // actualizarBodega();
    }//GEN-LAST:event_btnEliminarBodegaActionPerformed

    private void BotonGuardarBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarBodegaActionPerformed
        if(FechaBodega.getDate()==null || txtUbicacionBodega.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos no esten vacios", "ERROR", WIDTH);
        }else{
            try {
                String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(FechaBodega.getDate());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dateStr = formatter.parse(fechaBodega);
                java.sql.Date sqlDate = new java.sql.Date(dateStr.getTime());

                try {
                    Bodega funu = new Bodega(txtUbicacionBodega.getText(),sqlDate);
                    FBodega.insertarbodega(funu);
                    JOptionPane.showMessageDialog(rootPane, "Bodega guardada "+txtUbicacionBodega.getText(), "EXITO", WIDTH);
                }
                catch (Exception ex) {
                    Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            catch (ParseException ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }

            //        try {
                //            cmbEliminarBodega.removeAllItems();
                //            for(Bodega e: FBodega.obtenerTodaslasbodegas()){
                    //                // System.out.println(e.getNombre_estado());
                    //                // System.out.println(e.getCedula_funcionario());
                    //                cmbEliminarBodega.addItem(e.getUbicacion());
                    //            }
                //
                //        } catch (Exception e) {
                //            System.out.println("Error al mostrar combo box estados"+e.getMessage());
                //        }
        }
    }//GEN-LAST:event_BotonGuardarBodegaActionPerformed

    private void btnguardarFuncionarioRolBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarFuncionarioRolBodegaActionPerformed
        Funcionario_Rol_Bodega funrrb = new Funcionario_Rol_Bodega();
        try {

            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(datefechaFuncionrioRolBodega.getDate());
            java.sql.Date fecha;
            java.sql.Date fecha1=null;

            fecha = formatoFecha(fechaBodega);
            String bod = (String)cmbbodegarfuncionarioRolBodega.getSelectedItem();
            String rol = "Bodeguero";
            funrrb.setId_rol(FRol.obtenerRoles_xnombre(rol));
            Funcionario_Rol_Bodega funrb= new Funcionario_Rol_Bodega(FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRolBodega.getText()), FBodega.obtenerBodega_xnombre(bod),FRol.obtenerRoles_xnombre(rol), fecha, fecha1);
            FFuncionario_Rol_Bodega.insertarFuncionarioRolBodega(funrb);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarFuncionarioRolBodegaActionPerformed

    private void btncargarFuncionarioRolBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarFuncionarioRolBodegaActionPerformed

        String nombreFuncionario, apellidoFuncionario;
        try {
            nombreFuncionario = FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRolBodega.getText()).getNombres();
            apellidoFuncionario = FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRolBodega.getText()).getApellidos();
            lblfuncionaroBodega.setText(nombreFuncionario + apellidoFuncionario);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btncargarFuncionarioRolBodegaActionPerformed

    private void jTabbedPane12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane12MouseClicked
        // TODO add your handling code here:
        //        cmbrolFuncionarioRolModificar.removeAllItems();
        //        try {
            //            for(Rol e: FRol.obtenerTodoslosRoles()){
                //
                //                cmbrolFuncionarioRolModificar.addItem(e.getNombre_rol());
                //            }
            //       // acualizarFuncionarioRol();
            //        } catch (Exception ex) {
            //            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        // acualizarFuncionarioRol();
    }//GEN-LAST:event_jTabbedPane12MouseClicked

    private void btn_Eliminar_FuncionarioRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eliminar_FuncionarioRolActionPerformed
        try {
            // TODO add your handling code here:
            int id_rol = FRol.obtenerRoles_xnombre(jListEliminarFuncionarioRol2.getSelectedValue().toString()).getId_rol();
            FFuncionario_Rol.eliminarFuncionarioRol(jListEliminarFuncionarioRol.getSelectedValue().toString(), id_rol);
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado un rol del Funcionario ", "EXITO", WIDTH);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique cedula y rol de Funcionario nulos", "ERROR", WIDTH);

        }
    }//GEN-LAST:event_btn_Eliminar_FuncionarioRolActionPerformed

    private void jListEliminarFuncionarioRol2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEliminarFuncionarioRol2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListEliminarFuncionarioRol2MouseClicked

    private void jListEliminarFuncionarioRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEliminarFuncionarioRolMouseClicked
        // TODO add your handling code here:
        txt_BuscarEliminarFuncionarioRol.setText(jListEliminarFuncionarioRol.getSelectedValue().toString());

    }//GEN-LAST:event_jListEliminarFuncionarioRolMouseClicked

    private void txt_BuscarEliminarFuncionarioRolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarEliminarFuncionarioRolKeyReleased
        // TODO add your handling code here:
        if (txt_BuscarEliminarFuncionarioRol.getText().isEmpty()){
            modeloModificarFuncionarioRol.clear();
            modeloModificarFuncionarioRol2.clear();
            modeloModificarFuncionarioRol3.clear();
            modeloModificarFuncionarioRol4.clear();

        }
        else
        {

            try {
                String cad = txt_BuscarEliminarFuncionarioRol.getText();
                String sql ="Select funcionario_rol.numero_cedula, nombres, apellidos, nombre_rol from bodega.funcionario_rol inner join bodega.funcionario on funcionario_rol.numero_cedula = funcionario.numero_cedula join bodega.rol on rol.id_rol=funcionario_rol.id_rol where funcionario_rol.numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modeloModificarFuncionarioRol.clear();
                modeloModificarFuncionarioRol2.clear();
                modeloModificarFuncionarioRol3.clear();
                modeloModificarFuncionarioRol4.clear();

                while (cres.next()){

                    modeloModificarFuncionarioRol.addElement(cres.getObject(0));
                    modeloModificarFuncionarioRol2.addElement(cres.getObject(3));
                    modeloModificarFuncionarioRol3.addElement(cres.getObject(1));
                    modeloModificarFuncionarioRol4.addElement(cres.getObject(2));

                }

                this.jListEliminarFuncionarioRol.setModel(modeloModificarFuncionarioRol);
                this.jListEliminarFuncionarioRol2.setModel(modeloModificarFuncionarioRol2);
                this.jListEliminarFuncionarioRol3.setModel(modeloModificarFuncionarioRol3);
                this.jListEliminarFuncionarioRol4.setModel(modeloModificarFuncionarioRol4);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarEliminarFuncionarioRolKeyReleased

    private void jListModificarFuncionarioRol4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarFuncionarioRol4MouseClicked
        acualizarFuncionarioRol();
    }//GEN-LAST:event_jListModificarFuncionarioRol4MouseClicked

    private void jListModificarFuncionarioRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarFuncionarioRolMouseClicked
        // TODO add your handling code here:
        txt_BuscarModificarFuncionarioRol.setText(jListModificarFuncionarioRol.getSelectedValue().toString());

    }//GEN-LAST:event_jListModificarFuncionarioRolMouseClicked

    private void txt_BuscarModificarFuncionarioRolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarFuncionarioRolKeyReleased
        if (txt_BuscarModificarFuncionarioRol.getText().isEmpty()){
            modeloModificarFuncionarioRol.clear();
            modeloModificarFuncionarioRol2.clear();
            modeloModificarFuncionarioRol3.clear();
            modeloModificarFuncionarioRol4.clear();

        }
        else
        {

            try {
                String cad = txt_BuscarModificarFuncionarioRol.getText();
                String sql ="Select funcionario_rol.numero_cedula, nombres, apellidos, nombre_rol from bodega.funcionario_rol inner join bodega.funcionario on funcionario_rol.numero_cedula = funcionario.numero_cedula join bodega.rol on rol.id_rol=funcionario_rol.id_rol where funcionario_rol.numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modeloModificarFuncionarioRol.clear();
                modeloModificarFuncionarioRol2.clear();
                modeloModificarFuncionarioRol3.clear();
                modeloModificarFuncionarioRol4.clear();

                while (cres.next()){

                    modeloModificarFuncionarioRol.addElement(cres.getObject(0));
                    modeloModificarFuncionarioRol2.addElement(cres.getObject(1));
                    modeloModificarFuncionarioRol3.addElement(cres.getObject(2));
                    modeloModificarFuncionarioRol4.addElement(cres.getObject(3));

                }

                this.jListModificarFuncionarioRol.setModel(modeloModificarFuncionarioRol);
                this.jListModificarFuncionarioRol2.setModel(modeloModificarFuncionarioRol2);
                this.jListModificarFuncionarioRol3.setModel(modeloModificarFuncionarioRol3);
                this.jListModificarFuncionarioRol4.setModel(modeloModificarFuncionarioRol4);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarFuncionarioRolKeyReleased

    private void btn_Actualizar_FuncionarioRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_FuncionarioRolActionPerformed
       String pass= "";
       char[] password = jPasswordField2.getPassword();
        for (int x = 0; x<password.length; x++){
        pass += password[x];}
        try {
            // TODO add your handling code here:
            //Funcionario_Rol fun= new Funcionario_Rol();
            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(datefuncionarioRolModificar.getDate());
            String fechaBodegaSalida = new SimpleDateFormat("yyyy-MM-dd").format(datefuncionarioRolSalidaModificar.getDate());
            java.sql.Date fecha;
            java.sql.Date fecha1=null;
            String rol = (String)cmbrolFuncionarioRolModificar.getSelectedItem();
            int id_rol =  FRol.obtenerRoles_xnombre(jListModificarFuncionarioRol4.getSelectedValue().toString()).getId_rol();
            int nid_rol =  FRol.obtenerRoles_xnombre(rol).getId_rol();

            fecha = formatoFecha(fechaBodega);
            fecha1= formatoFecha(fechaBodegaSalida);
            
            FFuncionario_Rol.actualizarFuncionario_Rol_xrol(txt_BuscarModificarFuncionarioRol.getText(), id_rol, nid_rol, fecha, fecha1,pass);
            JOptionPane.showMessageDialog(rootPane, "Funcionario Rol Actualizada", "EXITO", WIDTH);

        } catch (Exception ex) {
            //  Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos no sean nulos", "ERROR", WIDTH);

        }
        acualizarFuncionarioRol();
        modeloModificarFuncionarioRol.clear();
        modeloModificarFuncionarioRol2.clear();
        modeloModificarFuncionarioRol3.clear();
        modeloModificarFuncionarioRol4.clear();

    }//GEN-LAST:event_btn_Actualizar_FuncionarioRolActionPerformed

    private void cmbrolFuncionarioRolModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbrolFuncionarioRolModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbrolFuncionarioRolModificarActionPerformed

    private void cmbrolFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbrolFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbrolFuncionarioActionPerformed

    private void btnguardarFuncionarioRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarFuncionarioRolActionPerformed
        Funcionario_Rol fun= new Funcionario_Rol();
        String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(datefuncionarioRol.getDate());
        java.sql.Date fecha;
        java.sql.Date fecha1=null;

        String rol = (String)cmbrolFuncionario.getSelectedItem();
        String pass= "";
       char[] password = jPasswordField1.getPassword();
        for (int x = 0; x<password.length; x++){
        pass += password[x];}

        try {
            fecha = formatoFecha(fechaBodega);
            try {
                fun.setId_rol(FRol.obtenerRoles_xnombre(rol));
                fun.setNumero_cedula(FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRol.getText()));
                Funcionario_Rol funr= new Funcionario_Rol(FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRol.getText()), FRol.obtenerRoles_xnombre(rol), fecha , fecha1,pass);
                FFuncionario_Rol.insertarFuncionarioRol(funr);
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnguardarFuncionarioRolActionPerformed

    private void btncargarNombreFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarNombreFuncionarioActionPerformed
        // TODO add your handling code here:
        String nombreFuncionario, apellidoFuncionario;
        try {
            nombreFuncionario = FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRol.getText()).getNombres();
            apellidoFuncionario = FFuncionario.obtenerFuncionario_xcodigo(txtcedulafuncionarioRol.getText()).getApellidos();
            txtnombreFuncionario.setText(nombreFuncionario + apellidoFuncionario);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btncargarNombreFuncionarioActionPerformed

    private void jTabbedPane10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane10MouseClicked
        // TODO add your handling code here:
        actualizar_jListModificarTipoMovimiento();
    }//GEN-LAST:event_jTabbedPane10MouseClicked

    private void btn_Eliminar_TipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eliminar_TipoMovimientoActionPerformed
        try {
            // TODO add your handling code here:
            FTipo_Movimiento.eliminarTipoMovimiento(FTipo_Movimiento.obtenertipo_movimiento_xnombre(lbl_id_TipoMovimiento_Eliminar.getText()));
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado un Tipo Movimiento", "EXITO", WIDTH);

        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique tipo Movimiento", "ERROR", WIDTH);

        }
        actualizar_jListModificarTipoMovimiento();
    }//GEN-LAST:event_btn_Eliminar_TipoMovimientoActionPerformed

    private void jListEliminarTipoMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEliminarTipoMovimientoMouseClicked
        // TODO add your handling code here:
        lbl_id_TipoMovimiento_Eliminar.setText(jListEliminarTipoMovimiento.getSelectedValue().toString());
        txtEliminar_TipoMovimiento.setText(jListEliminarTipoMovimiento.getSelectedValue().toString());
    }//GEN-LAST:event_jListEliminarTipoMovimientoMouseClicked

    private void btn_Actualizar_TipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_TipoMovimientoActionPerformed
        try {
            // TODO add your handling code here:
            FTipo_Movimiento.actualizarTipoMovimiento_xnombre(FTipo_Movimiento.obtenertipo_movimiento_xnombre(lbl_id_TipoMovimiento.getText()).getId_tipo_movimiento(),txtModificar_TipoMovimiento.getText());
            JOptionPane.showMessageDialog(rootPane, "Tipo Movimiento Actualizada", "EXITO", WIDTH);

        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique que no haya campos nulos", "ERROR", WIDTH);

        }
        actualizar_jListModificarTipoMovimiento();
    }//GEN-LAST:event_btn_Actualizar_TipoMovimientoActionPerformed

    private void jListModificarTipoMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarTipoMovimientoMouseClicked
        // TODO add your handling code here:
        txtModificar_TipoMovimiento.setText(jListModificarTipoMovimiento.getSelectedValue().toString());
        lbl_id_TipoMovimiento.setText(jListModificarTipoMovimiento.getSelectedValue().toString());
    }//GEN-LAST:event_jListModificarTipoMovimientoMouseClicked

    private void btnguardarTipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarTipoMovimientoActionPerformed
        // TODO add your handling code here:
        if(txtTipoMovimiento.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Tipo Movimiento no debe ser vacio", "ERROR", WIDTH);
        }else{
            try {
                Tipo_Movimiento mov = new Tipo_Movimiento(0,txtTipoMovimiento.getText());
                FTipo_Movimiento.insertartipo_mov(mov);
                JOptionPane.showMessageDialog(rootPane, "Se ha insertado un Tipo Movimiento "+txtTipoMovimiento.getText(), "EXITO", WIDTH);

            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Verifique que Tipo Movimiento no sea nulo", "ERROR", WIDTH);

            }
        }
    }//GEN-LAST:event_btnguardarTipoMovimientoActionPerformed

    private void jTabbedPane11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane11MouseClicked
        //        try {
            //            actualizar_equipo();
            //        } catch (Exception ex) {
            //            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            //        }
    }//GEN-LAST:event_jTabbedPane11MouseClicked

    private void btnActualizarArticuloInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarArticuloInventarioActionPerformed
        if(txt_BuscarModificarArticulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese el codigo por favor el campo esta vacio");
        }else{
            if(verificarModificarArticulosInventario()){
                JOptionPane.showMessageDialog(rootPane, "Verifique que los campos esten llenos por favor");
            }else{

                try {
                    // TODO add your handling code here:
                    String stock =txtstockInventario_ModificarArticulo.getText();
                    int stck = Integer.parseInt(stock);
                    FInventario.actualizarInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText(), txtmarcaInventario_ModificarArticulo.getText().toUpperCase(), txtmodeloInventario_ModificarArticulo.getText().toUpperCase(), jTextArea1.getText() ,  FEstado_ac.obtenerEstado_ac_xnombre(cmbestadoInventario_ModificarArticulo.getSelectedItem().toString()).getId_estado(), FCategoria.obtenerCategoria_xnombre(cmbcategoriaInventario_ModificarArticulo.getSelectedItem().toString()).getId_categoria(), FBodega.obtenerBodega_xnombre(cmbbodegaInventario_ModificarArticulo.getSelectedItem().toString()).getId_bodega(), stck, txtidentificadorInventario_ModificarArticulo.getText());

                    JOptionPane.showMessageDialog(rootPane, "Inventario Actualizado", "EXITO", WIDTH);
                } catch (Exception ex) {
                    Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Verifique que no haya campos nulos", "ERROR", WIDTH);
                }
            }
        }
        modelo.clear();
        modelo2.clear();
        modelo3.clear();
    }//GEN-LAST:event_btnActualizarArticuloInventarioActionPerformed

    private void jListModificarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarEquipoMouseClicked
        try {
            // TODO add your handling code here:
            //        int xaxis1 = Integer.parseInt(txt_BuscarModificarArticulo.getText());
            txt_BuscarModificarArticulo.setText(jListModificarEquipo.getSelectedValue().toString());
            int xaxis1 = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getStock();
            txtidentificadorInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo());
            txtmarcaInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getMarca());
            txtmodeloInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getModelo());
            jTextArea1.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getDescripcion());
            cmbestadoInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_estado().getNombre_estado());
            cmbcategoriaInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_categoria().getNombre_categoria());
            cmbbodegaInventario_ModificarArticulo.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_bodega().getUbicacion());

            String Stock = String.valueOf(xaxis1);
            txtstockInventario_ModificarArticulo.setText(Stock);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarEquipoMouseClicked

    private void txt_BuscarModificarArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarArticuloKeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarArticulo.getText().isEmpty()){
            modelo.clear();
            modelo2.clear();
            modelo3.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarModificarArticulo.getText();
                String sql ="Select * from bodega.inventario where id_equipo like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo.clear();
                modelo2.clear();
                modelo3.clear();

                while (cres.next()){

                    modelo.addElement(cres.getObject(1));
                    modelo2.addElement(cres.getObject(2));
                    modelo3.addElement(cres.getObject(3));

                }

                this.jListModificarEquipo.setModel(modelo);
                this.jListModificarEquipo2.setModel(modelo2);
                this.jListModificarEquipo3.setModel(modelo3);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarArticuloKeyReleased

    private void btnEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInventarioActionPerformed
        if(txtBuscarEquipoEliminar.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese el codigo por favor el campo esta vacio");
        }else{
            try {
                FInventario.eliminarInventario(FInventario.obtenerInventario_xcodigoEquipo(txtBuscarEquipoEliminar.getText()));
                JOptionPane.showMessageDialog(rootPane, "Articulo eliminado", "EXITO", WIDTH);

            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Verifique el codigo del articulo", "ERROR", WIDTH);

            }
        }
    }//GEN-LAST:event_btnEliminarInventarioActionPerformed

    private void jList_articuloEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_articuloEliminarMouseClicked
        // TODO add your handling code here:
        txtBuscarEquipoEliminar.setText(jList_articuloEliminar.getSelectedValue().toString());
    }//GEN-LAST:event_jList_articuloEliminarMouseClicked

    private void txtBuscarEquipoEliminarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEquipoEliminarKeyReleased

        if (txtBuscarEquipoEliminar.getText().isEmpty()){
            modelo.clear();
            modelo2.clear();
            modelo3.clear();

        }
        else
        {

            try {
                String cad = txtBuscarEquipoEliminar.getText();
                String sql ="Select * from bodega.inventario where id_equipo like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo.clear();
                modelo2.clear();
                modelo3.clear();

                while (cres.next()){

                    modelo.addElement(cres.getObject(1));
                    modelo2.addElement(cres.getObject(2));
                    modelo3.addElement(cres.getObject(3));

                }

                this.jList_articuloEliminar.setModel(modelo);
                this.jList_articuloEliminar2.setModel(modelo2);
                this.jList_articuloEliminar3.setModel(modelo3);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txtBuscarEquipoEliminarKeyReleased

    private void txtBuscarEquipoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEquipoEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEquipoEliminarActionPerformed

    private void txtmarcaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmarcaInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmarcaInventarioActionPerformed

    private void btnguardarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarInventarioActionPerformed
        if(verificarIngresarInventarioNulos()){
            JOptionPane.showMessageDialog(rootPane, "Verificar que los campos no esten vacios", "Campos con valores nulos", WIDTH);
        }else{

            Inventario inv = new Inventario();
            String estado = (String)cmbestadoInventario.getSelectedItem();
            String categoria = (String)cmbcategoriaInventario.getSelectedItem();
            String bodega = cmbbodegaInventario.getSelectedItem().toString();

            int stock = Integer.parseInt(txtstock.getText());
            try {
                inv.setId_estado(FEstado_ac.obtenerEstado_ac_xnombre(estado));
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                inv.setId_categoria(FCategoria.obtenerCategoria_xnombre(categoria));
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Inventario funu = new Inventario(0, txtidentificadorInventario.getText() , txtmarcaInventario.getText().toUpperCase(), txtmodeloInventario.getText().toUpperCase(),txtadescripcionInventario.getText() ,
                    FEstado_ac.obtenerEstado_ac_xnombre(estado), FCategoria.obtenerCategoria_xnombre(categoria), FBodega.obtenerBodega_xnombre(bodega), stock);
                FInventario.insertarInventario(funu);
                JOptionPane.showMessageDialog(rootPane, "Articulo insertado", "EXITO", WIDTH);

            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            if(FCategoria.obtenerCategoria_xnombre(cmbcategoriaInventario.getSelectedItem().toString()).getId_categoria()==1){
                java.util.Date fecha12 = new Date();
                   String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(fecha12);
                   java.sql.Date fecha;
                   try {
                       fecha = formatoFecha(fechaBodega);
                       Movimientos mov = new Movimientos("Ingresado",4,fecha);
                       try {
                           FMovimientos.insertarmovimientos(mov);
                       } catch (Exception ex) {
                           Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   } catch (ParseException ex) {
                       Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                   }   Detalle_Mov det = null;
            
                   try {
                       det = new Detalle_Mov(FMovimientos.ultimo_mov(),"0603783846",FInventario.obtenerInventario_xcodigoEquipo(txtidentificadorInventario.getText()).getId_inventario(),1,0);
                   } catch (Exception ex) {
                       Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   try {
   //                    FDetalle_Mov.actualizarencargado(txt_BuscarModificarFuncionario.getText(), FInventario.obtenerInventario_xcodigoEquipo(jTable1.getValueAt(i, 0).toString()).getId_inventario());
                       FDetalle_Mov.insertardetalle_mov(det);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);

                   }
                    
                   } 
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmbestadoInventario.setSelectedIndex(4);
    }//GEN-LAST:event_btnguardarInventarioActionPerformed

    private void jTabbedPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane7MouseClicked
        actualizar_jListModificarEstadoInventario();
    }//GEN-LAST:event_jTabbedPane7MouseClicked

    private void btn_Eliminar_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eliminar_EstadoActionPerformed
        try {
            FEstado_ac.eliminarEstado_ac(FEstado_ac.obtenerEstado_ac_xnombre(lbl_id_EstadoInventario_eliminar.getText()));
            JOptionPane.showMessageDialog(rootPane,"Se ha eliminado un Estado", "EXITO", WIDTH);
            actualizar_jListModificarEstadoInventario();
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"Verifique el Nombre o dependencias", "ERROR", WIDTH);

        }
    }//GEN-LAST:event_btn_Eliminar_EstadoActionPerformed

    private void jListEliminarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEliminarEstadoMouseClicked
        // TODO add your handling code here:
        txtEliminar_Estado.setText(jListEliminarEstado.getSelectedValue().toString());
        lbl_id_EstadoInventario_eliminar.setText(jListEliminarEstado.getSelectedValue().toString());
    }//GEN-LAST:event_jListEliminarEstadoMouseClicked

    private void btn_Actualizar_EstadoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_EstadoInventarioActionPerformed
        try {
            // TODO add your handling code here:
            FEstado_ac.actualizarEstadoInventario_xnombre(FEstado_ac.obtenerEstado_ac_xnombre(lbl_id_EstadoInventario.getText()).getId_estado(),txtModificar_EstadoInventario.getText());
            JOptionPane.showMessageDialog(rootPane, "Estado Actualizada", "EXITO", WIDTH);

        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verificar que los campos no sean nulos", "ERROR", WIDTH);

        }
        actualizar_jListModificarEstadoInventario();
    }//GEN-LAST:event_btn_Actualizar_EstadoInventarioActionPerformed

    private void jListModificarEstadoInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarEstadoInventarioMouseClicked
        // TODO add your handling code here:
        txtModificar_EstadoInventario.setText(jListModificarEstadoInventario.getSelectedValue().toString());
        lbl_id_EstadoInventario.setText(jListModificarEstadoInventario.getSelectedValue().toString());
    }//GEN-LAST:event_jListModificarEstadoInventarioMouseClicked

    private void btnGuardarEstado_acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstado_acActionPerformed
        if(txtEstado_ac.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese un nombre de Estado", "ERROR", WIDTH);
        }else{
            try {
                Estado_ac est = new Estado_ac(0,txtEstado_ac.getText());
                FEstado_ac.insertarEstado_ac(est);
                JOptionPane.showMessageDialog(rootPane, "Se ha ingresado un Estado "+txtEstado_ac.getText(), "EXITO", WIDTH);
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_btnGuardarEstado_acActionPerformed

    private void jTabbedPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane6MouseClicked
        // TODO add your handling code here:
        actualizar_jListModificarUnidad();
        actualizarUnidadcmb();
    }//GEN-LAST:event_jTabbedPane6MouseClicked

    private void txtubicacionUnidad_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtubicacionUnidad_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtubicacionUnidad_ActualizarActionPerformed

    private void btn_Actualizar_UnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_UnidadActionPerformed
        try {
            String ubicacion=FUnidad.obtenerUnidad_xnombre(lbl_Actualizar_Unidad.getText()).getUbicacion_unidad();
            FUnidad.actualizarUnidad_xcodigo(lbl_Actualizar_Unidad.getText(),ubicacion,txtnombreUnidad_Actualizar.getText(),txtfuncionUnidad_Actualizar.getText());
            JOptionPane.showMessageDialog(rootPane, "Unidad Actualizada", "EXITO", WIDTH);

        } catch (Exception ex) {
            //Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizar_jListModificarUnidad();
    }//GEN-LAST:event_btn_Actualizar_UnidadActionPerformed

    private void jListModificarUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarUnidadMouseClicked
        try {
            lbl_Actualizar_Unidad.setText(jListModificarUnidad.getSelectedValue().toString());
            txtnombreUnidad_Actualizar.setText(jListModificarUnidad.getSelectedValue().toString());
            txtubicacionUnidad_Actualizar.setText(FUnidad.obtenerUnidad_xnombre(lbl_Actualizar_Unidad.getText()).getNombre_unidad());
            txtfuncionUnidad_Actualizar.setText(FUnidad.obtenerUnidad_xnombre(lbl_Actualizar_Unidad.getText()).getFuncion_unidad());

        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarUnidadMouseClicked

    private void btnEliminarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUnidadActionPerformed
        // TODO add your handling code here:
        try {
            FUnidad.eliminarUnidad(FUnidad.obtenerUnidad_xnombre(cmbEliminarUnidad.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado la Unidad", "EXITO", WIDTH);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar una Unidad que tenga dependencias");
            System.out.println("Error al eliminar una Unidad que tenga dependencias"+ex.getMessage());
        }

        actualizarUnidadcmb();
    }//GEN-LAST:event_btnEliminarUnidadActionPerformed

    private void cmbEliminarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEliminarUnidadActionPerformed
        String ubicacionUnidad;
        String funcionUnidad;

        try {
            ubicacionUnidad = FUnidad.obtenerUnidad_xnombre(cmbEliminarUnidad.getSelectedItem().toString()).getNombre_unidad();
            funcionUnidad = FUnidad.obtenerUnidad_xnombre(cmbEliminarUnidad.getSelectedItem().toString()).getFuncion_unidad();
            lblEliminarUnidadUbicacion.setText(ubicacionUnidad);
            lblEliminarUnidadFuncion.setText(funcionUnidad);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cmbEliminarUnidadActionPerformed

    private void btnguardarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarUnidadActionPerformed
        // TODO add your handling code here:
        try {
            Unidad uni = new Unidad(0,txtnombreUnidad.getText(), txtubicacionUnidad.getText(),txtfuncionUnidad.getText());
            FUnidad.insertarunidad(uni);
            JOptionPane.showMessageDialog(rootPane, "Se ha ingresado una unidad "+txtnombreUnidad.getText(), "EXITO", WIDTH);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos esten llenos", "ERROR", WIDTH);
        }
    }//GEN-LAST:event_btnguardarUnidadActionPerformed

    private void txtnombreUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreUnidadActionPerformed

    private void jTabbedPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane5MouseClicked
        actualizar_jListModificarRol();
        actualizarRol();
    }//GEN-LAST:event_jTabbedPane5MouseClicked

    private void btn_Actualizar_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_RolActionPerformed
        try {
            // TODO add your handling code here:
            FRol.actualizarRol_xcodigo(FRol.obtenerRoles_xnombre(lbl_id_rol.getText()).getId_rol(),txtModificar_Rol.getText().toUpperCase());
            JOptionPane.showMessageDialog(rootPane, "Rol Actualizado", "EXITO", WIDTH);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizar_jListModificarRol();
    }//GEN-LAST:event_btn_Actualizar_RolActionPerformed

    private void jListModificarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarRolMouseClicked
        // TODO add your handling code here:
        txtModificar_Rol.setText(jListModificarRol.getSelectedValue().toString());
        lbl_id_rol.setText(jListModificarRol.getSelectedValue().toString());
    }//GEN-LAST:event_jListModificarRolMouseClicked

    private void btnEliminarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRolActionPerformed
        try {
            FRol.eliminarRol(FRol.obtenerRoles_xnombre(cmbEliminarRol.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el Rol", "EXITO", WIDTH);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar un Rol que tenga dependencias");
            System.out.println("Error al eliminar un Rol que tenga dependencias"+ex.getMessage());
        }
        actualizarRol();

    }//GEN-LAST:event_btnEliminarRolActionPerformed

    private void btnguardarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarRolActionPerformed
        if(txtnombreRol.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese un nombre de Rol", "ERROR", WIDTH);
        }else{
            try {
                Rol rol = new Rol(txtnombreRol.getText().toUpperCase());
                FRol.insertarRol(rol);
                JOptionPane.showMessageDialog(rootPane, "Rol Insertado "+txtnombreRol.getText().toUpperCase(), "Exito", WIDTH);
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Hubo algun error", "ERROR", WIDTH);
            }
        }
    }//GEN-LAST:event_btnguardarRolActionPerformed

    private void txt_BuscarEliminarFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarEliminarFuncionarioKeyReleased
        if (txt_BuscarEliminarFuncionario.getText().isEmpty()){
            modelo4.clear();
            modelo5.clear();
            modelo6.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarEliminarFuncionario.getText();
                String sql ="Select * from bodega.funcionario where numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo4.clear();
                modelo5.clear();
                modelo6.clear();

                while (cres.next()){

                    modelo4.addElement(cres.getObject(0));
                    modelo5.addElement(cres.getObject(1));
                    modelo6.addElement(cres.getObject(2));

                }

                this.jListEliminarFuncionario.setModel(modelo4);
                this.jListEliminarFuncionario2.setModel(modelo5);
                this.jListEliminarFuncionario3.setModel(modelo6);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarEliminarFuncionarioKeyReleased

    private void jListEliminarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEliminarFuncionarioMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            txt_BuscarEliminarFuncionario.setText(jListEliminarFuncionario.getSelectedValue().toString());
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListEliminarFuncionarioMouseClicked

    private void btnEliminar_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_FuncionarioActionPerformed
        try {
            FFuncionario.eliminarFuncionario(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarEliminarFuncionario.getText()));
            JOptionPane.showMessageDialog(rootPane, "El funcionario ha sido eliminado ", "EXITO", WIDTH);

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box categoria"+e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "El funcionario tiene asociado movimientos, error en la cedula ", "ERROR", WIDTH);
        }

    }//GEN-LAST:event_btnEliminar_FuncionarioActionPerformed

    private void btnActualizar_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar_FuncionarioActionPerformed
        if(validaActualizarFuncionarioNulos()){
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos esten llenos", "Campo vacio", WIDTH);
        }else{
            if(txtcedulaFuncionarioModificar.getText().length()!=10)
            {
                JOptionPane.showMessageDialog(rootPane, "Longitud de cedula incorrecto, Ingrese solo numeros", "ERROR", WIDTH);
            }
            else
            {
                try {
                    modelo4.clear();
                    modelo5.clear();
                    modelo6.clear();
                    FFuncionario.actualizarFuncionario_xcedula(txt_BuscarModificarFuncionario.getText(), txtnombresFuncionarioModificar.getText(), txtapellidosFuncionarioModificar.getText(), txttelefonoFuncionarioModificar.getText(), txtemailFuncionarioModificar.getText(),txtcedulaFuncionarioModificar.getText());
                    JOptionPane.showMessageDialog(rootPane, "Funcionario Modificado", "EXITO", WIDTH);

                } catch (Exception ex) {
                    Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Compruebe el cambio", "CHEQUEO", WIDTH);

                }
            }
        }
    }//GEN-LAST:event_btnActualizar_FuncionarioActionPerformed

    private void jListModificarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarFuncionarioMouseClicked
        try {
            // TODO add your handling code here:
            txt_BuscarModificarFuncionario.setText(jListModificarFuncionario.getSelectedValue().toString());
            txtcedulaFuncionarioModificar.setText(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarFuncionario.getText()).getCedula());
            txtnombresFuncionarioModificar.setText(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarFuncionario.getText()).getNombres());
            txtapellidosFuncionarioModificar.setText(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarFuncionario.getText()).getApellidos());
            txttelefonoFuncionarioModificar.setText(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarFuncionario.getText()).getNumerostelefonicos());
            txtemailFuncionarioModificar.setText(FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarFuncionario.getText()).getCorreo());
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarFuncionarioMouseClicked

    private void txt_BuscarModificarFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarFuncionarioKeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarFuncionario.getText().isEmpty()){
            modelo4.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarModificarFuncionario.getText();
                String sql ="Select * from bodega.funcionario where numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo4.clear();
                modelo5.clear();
                modelo6.clear();

                while (cres.next()){

                    modelo4.addElement(cres.getObject(0));
                    modelo5.addElement(cres.getObject(1));
                    modelo6.addElement(cres.getObject(2));

                }

                this.jListModificarFuncionario.setModel(modelo4);
                this.jListModificarFuncionario1.setModel(modelo5);
                this.jListModificarFuncionario2.setModel(modelo6);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarFuncionarioKeyReleased

    private void txtemailFuncionarioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailFuncionarioModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailFuncionarioModificarActionPerformed

    private void txtcedulaFuncionarioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaFuncionarioModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaFuncionarioModificarActionPerformed

    private void txtemailFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailFuncionarioActionPerformed

    private void txtcedulaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaFuncionarioActionPerformed

    private void btnguadarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguadarFuncionarioActionPerformed
        //JOptionPane.showMessageDialog(null, "Elemento Funcionario Guardado exitosamente");
        if(validaIngresoFuncionarioNulos()){
            JOptionPane.showMessageDialog(rootPane, "Verifique que los campos esten llenos", "Campo vacio", WIDTH);
        }else{
            if(txtcedulaFuncionario.getText().length()!=10)
            {
                JOptionPane.showMessageDialog(rootPane, "Longitud de cedula incorrecto, Ingrese solo numeros", "ERROR", WIDTH);
            }
            else
            {
                try {
                    Funcionario fun = new Funcionario(txtcedulaFuncionario.getText(), txtnombresFuncionario.getText(), txtapellidosFuncionario.getText(),
                        txttelefonoFuncionario.getText(), txtemailFuncionario.getText());
                    FFuncionario.insertarfuncionario(fun);
                    JOptionPane.showMessageDialog(rootPane, "Funcionario Insertado "+txtcedulaFuncionario.getText(), "EXITO", WIDTH);
                } catch (Exception ex) {
                    Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Funcionario ya existe verifique la cedula ", "ERROR", WIDTH);

                }
            }
        }
    }//GEN-LAST:event_btnguadarFuncionarioActionPerformed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        try {
            // TODO add your handling code here:
            String sql ="Select * from bodega.categoria";
            ConjuntoResultado cres=null;

            cres = AccesoDatos.ejecutaQuery(sql);

            modelo4.clear();

            while (cres.next()){

                modelo4.addElement(cres.getObject(1));

            }

            this.jListModificarCategoria.setModel(modelo4);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cmbEliminarCategoria.removeAllItems();
            for(Categoria e: FCategoria.obtenerTodaslascategorias()){

                cmbEliminarCategoria.addItem(e.getNombre_categoria());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box "+e.getMessage());
        }

    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void btn_Actualizar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_CategoriaActionPerformed
        if(txtModificar_Categoria.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Verifique el nombre de la Categoria esta vacio", "Campo vacio", WIDTH);
        }else{
            try {
                FCategoria.actualizarCategoria_xcodigo(FCategoria.obtenerCategoria_xnombre(lbl_id_categoria.getText()).getId_categoria(),txtModificar_Categoria.getText());
                JOptionPane.showMessageDialog(rootPane, "Categoria Actualizada", "EXITO", WIDTH);

            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                String sql ="Select * from bodega.categoria";
                ConjuntoResultado cres=null;
                cres = AccesoDatos.ejecutaQuery(sql);
                modelo4.clear();
                while (cres.next()){
                    modelo4.addElement(cres.getObject(1));
                }

                this.jListModificarCategoria.setModel(modelo4);
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btn_Actualizar_CategoriaActionPerformed

    private void jListModificarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarCategoriaMouseClicked
        // TODO add your handling code here:
        txtModificar_Categoria.setText(jListModificarCategoria.getSelectedValue().toString());
        lbl_id_categoria.setText(jListModificarCategoria.getSelectedValue().toString());
    }//GEN-LAST:event_jListModificarCategoriaMouseClicked

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        try {
            FCategoria.eliminarCategoria(FCategoria.obtenerCategoria_xnombre(cmbEliminarCategoria.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminato la categoria", "EXITO", WIDTH);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cmbEliminarCategoria.removeAllItems();
            for(Categoria e: FCategoria.obtenerTodaslascategorias()){
                cmbEliminarCategoria.addItem(e.getNombre_categoria());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box categoria"+e.getMessage());
        }

    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnnombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnombreCategoriaActionPerformed

        if(txtnombreCategoria.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Verifique el nombre de la Categoria esta vacio", "Campo vacio", WIDTH);
        }else{
            try {
                Categoria cat = new Categoria(0,txtnombreCategoria.getText());
                FCategoria.insertarCategorias(cat);
                JOptionPane.showMessageDialog(rootPane, "Ingreso Exitoso " + txtnombreCategoria.getText(), "EXITO", WIDTH);
            } catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnnombreCategoriaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Salir();
    }//GEN-LAST:event_formWindowClosing

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        Reportes rep = new Reportes();
        rep.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        acercade rep = new acercade();
        rep.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked
    
              
            
    public Date DeStringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
                        System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }
    
    private void Salir() {
  
     Object[] options = { "Aceptar", "Cancelar" };
        int seleccion=JOptionPane.showOptionDialog(this, "Esta Seguro que desea salir de la Aplicación", "Atención",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[1]);
        if(seleccion==0){
           System.exit(0);
        }

    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Unidad().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGuardarBodega;
    private com.toedter.calendar.JDateChooser FechaBodega;
    private com.toedter.calendar.JDateChooser FechaBodegaModificar;
    private javax.swing.JButton btnActualizarArticuloInventario;
    private javax.swing.JButton btnActualizar_Funcionario;
    private javax.swing.JButton btnEliminarBodega;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnEliminarInventario;
    private javax.swing.JButton btnEliminarRol;
    private javax.swing.JButton btnEliminarUnidad;
    private javax.swing.JButton btnEliminar_Funcionario;
    private javax.swing.JButton btnGuardarEstado_ac;
    private javax.swing.JButton btn_Actualizar_Categoria;
    private javax.swing.JButton btn_Actualizar_EstadoInventario;
    private javax.swing.JButton btn_Actualizar_FuncionarioRol;
    private javax.swing.JButton btn_Actualizar_Rol;
    private javax.swing.JButton btn_Actualizar_TipoMovimiento;
    private javax.swing.JButton btn_Actualizar_Unidad;
    private javax.swing.JButton btn_Actualizar_Unidad1;
    private javax.swing.JButton btn_Eliminar_Estado;
    private javax.swing.JButton btn_Eliminar_FuncionarioRol;
    private javax.swing.JButton btn_Eliminar_TipoMovimiento;
    private javax.swing.JButton btncargarFuncionarioRolBodega;
    private javax.swing.JButton btncargarNombreFuncionario;
    private javax.swing.JButton btnguadarFuncionario;
    private javax.swing.JButton btnguardarFuncionarioRol;
    private javax.swing.JButton btnguardarFuncionarioRolBodega;
    private javax.swing.JButton btnguardarInventario;
    private javax.swing.JButton btnguardarRol;
    private javax.swing.JButton btnguardarTipoMovimiento;
    private javax.swing.JButton btnguardarUnidad;
    private javax.swing.JButton btnnombreCategoria;
    private javax.swing.JComboBox cmbEliminarCategoria;
    private javax.swing.JComboBox cmbEliminarRol;
    private javax.swing.JComboBox cmbEliminarUnidad;
    private javax.swing.JComboBox cmbbodegaInventario;
    private javax.swing.JComboBox cmbbodegaInventario_ModificarArticulo;
    private javax.swing.JComboBox cmbbodegarfuncionarioRolBodega;
    private javax.swing.JComboBox cmbcategoriaInventario;
    private javax.swing.JComboBox cmbcategoriaInventario_ModificarArticulo;
    private javax.swing.JComboBox cmbestadoInventario;
    private javax.swing.JComboBox cmbestadoInventario_ModificarArticulo;
    private javax.swing.JComboBox cmbrolFuncionario;
    private javax.swing.JComboBox cmbrolFuncionarioRolModificar;
    private com.toedter.calendar.JDateChooser datefechaFuncionrioRolBodega;
    private com.toedter.calendar.JDateChooser datefuncionarioRol;
    private com.toedter.calendar.JDateChooser datefuncionarioRolModificar;
    private com.toedter.calendar.JDateChooser datefuncionarioRolSalidaModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayered_ModificarArticulo;
    private javax.swing.JList jListEliminarEstado;
    private javax.swing.JList jListEliminarFuncionario;
    private javax.swing.JList jListEliminarFuncionario2;
    private javax.swing.JList jListEliminarFuncionario3;
    private javax.swing.JList jListEliminarFuncionarioRol;
    private javax.swing.JList jListEliminarFuncionarioRol2;
    private javax.swing.JList jListEliminarFuncionarioRol3;
    private javax.swing.JList jListEliminarFuncionarioRol4;
    private javax.swing.JList jListEliminarTipoMovimiento;
    private javax.swing.JList jListModificarBodega;
    private javax.swing.JList jListModificarCategoria;
    private javax.swing.JList jListModificarEquipo;
    private javax.swing.JList jListModificarEquipo2;
    private javax.swing.JList jListModificarEquipo3;
    private javax.swing.JList jListModificarEstadoInventario;
    private javax.swing.JList jListModificarFuncionario;
    private javax.swing.JList jListModificarFuncionario1;
    private javax.swing.JList jListModificarFuncionario2;
    private javax.swing.JList jListModificarFuncionarioRol;
    private javax.swing.JList jListModificarFuncionarioRol2;
    private javax.swing.JList jListModificarFuncionarioRol3;
    private javax.swing.JList jListModificarFuncionarioRol4;
    private javax.swing.JList jListModificarRol;
    private javax.swing.JList jListModificarTipoMovimiento;
    private javax.swing.JList jListModificarUnidad;
    private javax.swing.JList jList_Actualizar_Bodega;
    private javax.swing.JList jList_articuloEliminar;
    private javax.swing.JList jList_articuloEliminar2;
    private javax.swing.JList jList_articuloEliminar3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane12;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane14;
    private javax.swing.JTabbedPane jTabbedPane15;
    private javax.swing.JTabbedPane jTabbedPane16;
    private javax.swing.JTabbedPane jTabbedPane18;
    private javax.swing.JTabbedPane jTabbedPane19;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane20;
    private javax.swing.JTabbedPane jTabbedPane22;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblEliminarFuncionUnidad;
    private javax.swing.JLabel lblEliminarUbicacionUnidad;
    private javax.swing.JLabel lblEliminarUnidadFuncion;
    private javax.swing.JLabel lblEliminarUnidadUbicacion;
    private javax.swing.JLabel lblUbicacionBodega;
    private javax.swing.JLabel lbl_Actualizar_Unidad;
    private javax.swing.JLabel lbl_id_EstadoInventario;
    private javax.swing.JLabel lbl_id_EstadoInventario_eliminar;
    private javax.swing.JLabel lbl_id_TipoMovimiento;
    private javax.swing.JLabel lbl_id_TipoMovimiento_Eliminar;
    private javax.swing.JLabel lbl_id_categoria;
    private javax.swing.JLabel lbl_id_categoria1;
    private javax.swing.JLabel lbl_id_rol;
    private javax.swing.JLabel lblfechaCreacionBodega;
    private javax.swing.JLabel lblfuncionaroBodega;
    private javax.swing.JTextField txtBuscarEquipoEliminar;
    private javax.swing.JTextField txtEliminar_Estado;
    private javax.swing.JTextField txtEliminar_TipoMovimiento;
    private javax.swing.JTextField txtEstado_ac;
    private javax.swing.JTextField txtModificar_Categoria;
    private javax.swing.JTextField txtModificar_EstadoInventario;
    private javax.swing.JTextField txtModificar_Rol;
    private javax.swing.JTextField txtModificar_TipoMovimiento;
    private javax.swing.JTextField txtTipoMovimiento;
    private javax.swing.JTextField txtUbicacionBodega;
    private javax.swing.JTextField txtUbicacionBodegaModificar;
    private javax.swing.JTextField txt_BuscarEliminarFuncionario;
    private javax.swing.JTextField txt_BuscarEliminarFuncionarioRol;
    private javax.swing.JTextField txt_BuscarModificarArticulo;
    private javax.swing.JTextField txt_BuscarModificarFuncionario;
    private javax.swing.JTextField txt_BuscarModificarFuncionarioRol;
    private javax.swing.JTextArea txtadescripcionInventario;
    private javax.swing.JTextField txtapellidosFuncionario;
    private javax.swing.JTextField txtapellidosFuncionarioModificar;
    private javax.swing.JTextField txtcedulaFuncionario;
    private javax.swing.JTextField txtcedulaFuncionarioModificar;
    private javax.swing.JTextField txtcedulafuncionarioRol;
    private javax.swing.JTextField txtcedulafuncionarioRolBodega;
    private javax.swing.JTextField txtcedulafuncionarioRolModificar;
    private javax.swing.JTextField txtemailFuncionario;
    private javax.swing.JTextField txtemailFuncionarioModificar;
    private javax.swing.JTextField txtfuncionUnidad;
    private javax.swing.JTextField txtfuncionUnidad_Actualizar;
    private javax.swing.JTextField txtidentificadorInventario;
    private javax.swing.JTextField txtidentificadorInventario_ModificarArticulo;
    private javax.swing.JTextField txtmarcaInventario;
    private javax.swing.JTextField txtmarcaInventario_ModificarArticulo;
    private javax.swing.JTextField txtmodeloInventario;
    private javax.swing.JTextField txtmodeloInventario_ModificarArticulo;
    private javax.swing.JTextField txtnombreCategoria;
    private javax.swing.JTextField txtnombreFuncionario;
    private javax.swing.JTextField txtnombreRol;
    private javax.swing.JTextField txtnombreUnidad;
    private javax.swing.JTextField txtnombreUnidad_Actualizar;
    private javax.swing.JTextField txtnombresFuncionario;
    private javax.swing.JTextField txtnombresFuncionarioModificar;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtstockInventario_ModificarArticulo;
    private javax.swing.JTextField txttelefonoFuncionario;
    private javax.swing.JTextField txttelefonoFuncionarioModificar;
    private javax.swing.JTextField txtubicacionUnidad;
    private javax.swing.JTextField txtubicacionUnidad_Actualizar;
    // End of variables declaration//GEN-END:variables
}

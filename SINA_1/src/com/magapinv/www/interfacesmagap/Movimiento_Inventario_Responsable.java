/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magapinv.www.interfacesmagap;

import com.magapinv.www.accesodatos.AccesoDatos;
import com.magapinv.www.accesodatos.ConjuntoResultado;
import com.magapinv.www.logicanegocios.clases.Bodega;
import com.magapinv.www.logicanegocios.clases.Categoria;
import com.magapinv.www.logicanegocios.clases.Dado_Baja;
import com.magapinv.www.logicanegocios.clases.Defectuoso;
import com.magapinv.www.logicanegocios.clases.Detalle_Mov;
import com.magapinv.www.logicanegocios.clases.Estado_ac;
import com.magapinv.www.logicanegocios.clases.Inventario;
import com.magapinv.www.logicanegocios.clases.Mantenimiento;
import com.magapinv.www.logicanegocios.clases.Movimientos;
import com.magapinv.www.logicanegocios.clases.Perdido;
import com.magapinv.www.logicanegocios.funciones.FBodega;
import com.magapinv.www.logicanegocios.funciones.FCategoria;
import com.magapinv.www.logicanegocios.funciones.FDado_Baja;
import com.magapinv.www.logicanegocios.funciones.FDefectuoso;
import com.magapinv.www.logicanegocios.funciones.FDetalle_Mov;
import com.magapinv.www.logicanegocios.funciones.FEstado_ac;
import com.magapinv.www.logicanegocios.funciones.FFuncionario;
import com.magapinv.www.logicanegocios.funciones.FFuncionario_Rol;
import com.magapinv.www.logicanegocios.funciones.FInventario;
import com.magapinv.www.logicanegocios.funciones.FMantenimiento;
import com.magapinv.www.logicanegocios.funciones.FMovimientos;
import com.magapinv.www.logicanegocios.funciones.FPerdido;
import com.magapinv.www.reportes.Movimiento_Articulo;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mario
 */
public class Movimiento_Inventario_Responsable extends javax.swing.JFrame {
        DefaultListModel modelo= new DefaultListModel();
        DefaultListModel modelo2= new DefaultListModel();
        DefaultListModel modelo3= new DefaultListModel();     
        DefaultListModel modelo_estado_inventario= new DefaultListModel();     
        
        // para realizar traspasos
        DefaultListModel mov_det_cant=new DefaultListModel();
        DefaultListModel modelo_funcionario_cedula= new DefaultListModel();
        DefaultListModel inventario_funcionario_cedula= new DefaultListModel();
        DefaultListModel inventario_marca_funcionario_cedula= new DefaultListModel();
       DefaultListModel inventario_descripcion_funcionario_cedula= new DefaultListModel();
       DefaultListModel  stock_det_mov=new DefaultListModel();
       //nuevo funcionario
       DefaultListModel modelo_n_funcionario_cedula= new DefaultListModel();
       DefaultListModel inventario_n_funcionario_cedula= new DefaultListModel();
       DefaultListModel inventario_n_marca_funcionario_cedula= new DefaultListModel();
      DefaultListModel inventario_n_descripcion_funcionario_cedula= new DefaultListModel();
      //para realizar prestamos
       DefaultListModel modelo_funcionario_cedula_p= new DefaultListModel();
       DefaultListModel inventario_funcionario_cedula_p= new DefaultListModel();
       DefaultListModel inventario_marca_funcionario_cedula_p= new DefaultListModel();
       DefaultListModel inventario_descripcion_funcionario_cedula_p= new DefaultListModel();
       DefaultListModel inventario_id_eq = new DefaultListModel();
       DefaultListModel inventario_marca=new DefaultListModel();
       DefaultListModel inventario_modelo=new DefaultListModel();
       DefaultListModel inventario_descripcion=new DefaultListModel();
       DefaultListModel stock_inv = new DefaultListModel();
       DefaultTableModel modelotabla = new DefaultTableModel();
         DefaultListModel modelojListArticulosAsignados= new  DefaultListModel();
        DefaultListModel modelojListFuncionario_asignar= new  DefaultListModel();
        DefaultListModel modelojListArticulosAsignados1= new  DefaultListModel();
       JTable tabla = new JTable(modelotabla);
      int deseo=0;   
      DefaultTableModel modelotabla1 = new DefaultTableModel();
       JTable tabla1 = new JTable(modelotabla1);
      int deseo1=0;
      boolean tablaselecionada=false;
      private Movimiento_Articulo jasper3;
      
        
        
    public Movimiento_Inventario_Responsable() {
        initComponents();
        jasper3=new Movimiento_Articulo();
        
//        String directorio = System.getProperty("user.dir");
//        // aqui obtengo el tipo de separador que hay entre las carpetas
//        String separador = System.getProperty("file.separator");
//        Icon icono=new ImageIcon(directorio+separador+"com"+separador+"magapinv"+separador+"www"+separador+"interfacesmagap"+separador+"recursos"+separador+"logo_magap");
//       lbl_iconoApp_derecha.setIcon(icono);

        try {
                
                cmbbodegaInventario_ModificarArticulo_ri.removeAllItems();
                cmbcategoriaInventario_ModificarArticulo_ri.removeAllItems();
                cmbcategoriaInventario.removeAllItems();
                cmbestadoInventario.removeAllItems();
                cmbbodegaInventario.removeAllItems();
            for(Estado_ac e: FEstado_ac.obtenerTodoslosEstado_ac()){
                
                cmbestadoInventario_ModificarArticulo_ri.addItem(e.getNombre_estado());
                cmbestadoInventario.addItem(e.getNombre_estado());
                
            }
            for(Bodega e: FBodega.obtenerTodaslasbodegas()){
                cmbbodegaInventario_ModificarArticulo_ri.addItem(e.getUbicacion());
                cmbbodegaInventario.addItem(e.getUbicacion());
            }
            for(Categoria e: FCategoria.obtenerTodaslascategorias()){
                cmbcategoriaInventario_ModificarArticulo_ri.addItem(e.getNombre_categoria());
                cmbcategoriaInventario.addItem(e.getNombre_categoria());
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar combo box estados"+e.getMessage());
        }
        
     //Metodo carga en label lbl_estado_actual estado actual de inventario   
     lbl_estado_actual_inventario();
        
        
     Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, false); 
     Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, false); 
     Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, false); 
     Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, false);
     cargar_modelo_estado_invetario();   
     
     SoloNumeros(txtstock);
     SoloNumeros(txtstockInventario_ModificarArticulo);
     SoloNumeros(txt_num_art_dadobaja);
     SoloNumeros(txt_num_art_perdidos);
     
     aviso_stock();
     actualizar_jListFuncionario_asignar();
     actualizar_jListArticulosAsignados();
     cmbestadoInventario.setSelectedIndex(4);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jScrollPane8 = new javax.swing.JScrollPane();
        txtadescripcionInventario = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        cmbestadoInventario = new javax.swing.JComboBox();
        cmbcategoriaInventario = new javax.swing.JComboBox();
        cmbbodegaInventario = new javax.swing.JComboBox();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        jListArticulosAsignados = new javax.swing.JList();
        btnAsignar_Articulo_Funcionario = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jListFuncionario_asignar = new javax.swing.JList();
        jScrollPane27 = new javax.swing.JScrollPane();
        jListArticulosAsignados1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txt_BuscarModificarArticulo1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListModificarEquipo1 = new javax.swing.JList();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListModificarEquipo4 = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        jListModificarEquipo5 = new javax.swing.JList();
        jScrollPane15 = new javax.swing.JScrollPane();
        jLayered_ModificarArticulo = new javax.swing.JLayeredPane();
        txtidentificadorInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtmarcaInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtmodeloInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cmbestadoInventario_ModificarArticulo_ri = new javax.swing.JComboBox();
        cmbcategoriaInventario_ModificarArticulo_ri = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cmbbodegaInventario_ModificarArticulo_ri = new javax.swing.JComboBox();
        txtstockInventario_ModificarArticulo = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        btnActualizarArticuloInventario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtBuscarEquipoEliminar = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList_articuloEliminar = new javax.swing.JList();
        btnEliminarInventario = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList_articuloEliminar2 = new javax.swing.JList();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList_articuloEliminar3 = new javax.swing.JList();
        jPanel_Inventario = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListModificarEquipo3 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListModificarEquipo2 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListModificarEquipo = new javax.swing.JList();
        txt_BuscarModificarArticulo = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList_Estado_Inventario = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        lbl_stock_actual_inventario = new javax.swing.JLabel();
        lbl_estado_actual_inventario = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelContenedorEstados = new javax.swing.JTabbedPane();
        jTabbedPaneMantenimiento = new javax.swing.JTabbedPane();
        jPanelMantenimiento = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FechaIngresoMantenimiento = new com.toedter.calendar.JDateChooser();
        FechaSalidaMantenimiento = new com.toedter.calendar.JDateChooser();
        txtEncargadoMantenimiento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionDanio = new javax.swing.JTextArea();
        btnGuardarMantenimiento = new javax.swing.JButton();
        jTabbedPaneDefectuoso = new javax.swing.JTabbedPane();
        jPanelDefectuoso = new javax.swing.JPanel();
        btnGuardarDefectuoso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesDefectuoso = new javax.swing.JTextArea();
        jTabbedPaneDadoBaja = new javax.swing.JTabbedPane();
        jPanelDadoBaja = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        FechaDadoBaja = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnGuardarDadoBaja = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMotivoDadoBaja = new javax.swing.JTextArea();
        txt_num_art_dadobaja = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTabbedPanePerdido = new javax.swing.JTabbedPane();
        jPanelPerdido = new javax.swing.JPanel();
        FechaPerdido = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        btnGuardarPerdido = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_num_art_perdidos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_BuscarModificarFuncionario = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        jListModificarFuncionario = new javax.swing.JList();
        jScrollPane19 = new javax.swing.JScrollPane();
        jid_inventario = new javax.swing.JList();
        jLabel25 = new javax.swing.JLabel();
        txt_BuscarModificarnFuncionario1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jListModificar_nFuncionario1 = new javax.swing.JList();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane33 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btn_quitar = new javax.swing.JButton();
        jScrollPane34 = new javax.swing.JScrollPane();
        jTablePrestamos = new javax.swing.JTable();
        jScrollPane25 = new javax.swing.JScrollPane();
        jListequipos = new javax.swing.JList();
        jLabel26 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txt_Buscarequi = new javax.swing.JTextField();
        jScrollPane26 = new javax.swing.JScrollPane();
        jListModificar_nFuncionario2 = new javax.swing.JList();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txt_BuscarModificarnFuncionario2 = new javax.swing.JTextField();
        lbl_iconoApp_derecha = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/magapinv/www/interfacesmagap/recursos/LOGO SSTRA1.png"))); // NOI18N

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
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
        jScrollPane8.setViewportView(txtadescripcionInventario);

        jLabel23.setText("Descripción");

        cmbestadoInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbcategoriaInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbbodegaInventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Artículo a Funcionario"));

        jScrollPane20.setViewportView(jListArticulosAsignados);

        jScrollPane20.setBounds(30, 30, 160, 100);
        jLayeredPane2.add(jScrollPane20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAsignar_Articulo_Funcionario.setText("Asignar");
        btnAsignar_Articulo_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignar_Articulo_FuncionarioActionPerformed(evt);
            }
        });
        btnAsignar_Articulo_Funcionario.setBounds(840, 103, 90, 30);
        jLayeredPane2.add(btnAsignar_Articulo_Funcionario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane21.setViewportView(jListFuncionario_asignar);

        jScrollPane21.setBounds(440, 30, 170, 100);
        jLayeredPane2.add(jScrollPane21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane27.setViewportView(jListArticulosAsignados1);

        jScrollPane27.setBounds(210, 30, 170, 100);
        jLayeredPane2.add(jScrollPane27, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidentificadorInventario)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtmodeloInventario)
                            .addComponent(txtmarcaInventario))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbcategoriaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbbodegaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel22))
                                        .addGap(138, 138, 138)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbestadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnguardarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtidentificadorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cmbestadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtmarcaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cmbcategoriaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtmodeloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cmbbodegaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 443, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Insertar nuevo artículo Inventario", jPanel1);

        jLabel43.setText("A medida que ingrese el texto se desplegará los resultados");

        txt_BuscarModificarArticulo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarArticulo1KeyReleased(evt);
            }
        });

        jLabel44.setText("Ingrese el ID del equipo");

        jListModificarEquipo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarEquipo1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jListModificarEquipo1);

        jScrollPane13.setViewportView(jListModificarEquipo4);

        jScrollPane14.setViewportView(jListModificarEquipo5);

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane16.setViewportView(jTextArea2);

        jScrollPane16.setBounds(190, 150, 254, 96);
        jLayered_ModificarArticulo.add(jScrollPane16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel48.setText("Descripción");
        jLabel48.setBounds(20, 150, 100, 14);
        jLayered_ModificarArticulo.add(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel49.setText("Estado");
        jLabel49.setBounds(480, 40, 90, 14);
        jLayered_ModificarArticulo.add(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbestadoInventario_ModificarArticulo_ri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbestadoInventario_ModificarArticulo_ri.setBounds(720, 40, 200, 20);
        jLayered_ModificarArticulo.add(cmbestadoInventario_ModificarArticulo_ri, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbcategoriaInventario_ModificarArticulo_ri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbcategoriaInventario_ModificarArticulo_ri.setBounds(720, 80, 200, 20);
        jLayered_ModificarArticulo.add(cmbcategoriaInventario_ModificarArticulo_ri, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel50.setText("Categoría");
        jLabel50.setBounds(480, 80, 110, 14);
        jLayered_ModificarArticulo.add(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel51.setText("Bodega de Almacenamiento");
        jLabel51.setBounds(480, 120, 160, 14);
        jLayered_ModificarArticulo.add(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmbbodegaInventario_ModificarArticulo_ri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbodegaInventario_ModificarArticulo_ri.setBounds(720, 110, 200, 20);
        jLayered_ModificarArticulo.add(cmbbodegaInventario_ModificarArticulo_ri, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtstockInventario_ModificarArticulo.setBounds(720, 160, 164, 30);
        jLayered_ModificarArticulo.add(txtstockInventario_ModificarArticulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel52.setText("Stock");
        jLabel52.setBounds(480, 160, 80, 14);
        jLayered_ModificarArticulo.add(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane15.setViewportView(jLayered_ModificarArticulo);

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
                        .addComponent(jScrollPane15))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel43)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(txt_BuscarModificarArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarArticuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel44))
                    .addComponent(btnActualizarArticuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarModificarArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 344, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Modificar artículo Inventario", jPanel2);

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
        jScrollPane9.setViewportView(jList_articuloEliminar);

        btnEliminarInventario.setText("Eliminar");
        btnEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInventarioActionPerformed(evt);
            }
        });

        jScrollPane10.setViewportView(jList_articuloEliminar2);

        jScrollPane11.setViewportView(jList_articuloEliminar3);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarEquipoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(jLabel42))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnEliminarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 448, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Eliminar artículo Inventario", jPanel3);

        jTabbedPane1.addTab("Administración de Artículo", jTabbedPane2);

        jLabel41.setText("A medida que ingrese el texto se desplegará los resultados");

        jListModificarEquipo3.setEnabled(false);
        jScrollPane7.setViewportView(jListModificarEquipo3);

        jListModificarEquipo2.setEnabled(false);
        jScrollPane6.setViewportView(jListModificarEquipo2);

        jListModificarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarEquipoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListModificarEquipo);

        txt_BuscarModificarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarArticuloKeyReleased(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado de Inventario"));

        jList_Estado_Inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_Estado_InventarioMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(jList_Estado_Inventario);

        jScrollPane17.setBounds(20, 60, 200, 100);
        jLayeredPane1.add(jScrollPane17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Stock");
        jLabel10.setBounds(280, 60, 50, 20);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_stock_actual_inventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_stock_actual_inventario.setBounds(270, 80, 60, 20);
        jLayeredPane1.add(lbl_stock_actual_inventario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_estado_actual_inventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_estado_actual_inventario.setBounds(110, 20, 150, 20);
        jLayeredPane1.add(lbl_estado_actual_inventario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Estado actual:");
        jLabel11.setBounds(30, 20, 110, 20);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Encargado de dar Mantenimiento");

        jLabel3.setText("Fecha de Ingreso a Mantenimiento");

        jLabel4.setText("Fecha de Salida de Mantenimiento");

        jLabel5.setText("Descripción del daño");

        txtDescripcionDanio.setColumns(20);
        txtDescripcionDanio.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionDanio);

        btnGuardarMantenimiento.setText("Guardar");
        btnGuardarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMantenimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMantenimientoLayout = new javax.swing.GroupLayout(jPanelMantenimiento);
        jPanelMantenimiento.setLayout(jPanelMantenimientoLayout);
        jPanelMantenimientoLayout.setHorizontalGroup(
            jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                        .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechaSalidaMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                        .addGap(158, 158, 158))
                    .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                        .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                                .addComponent(FechaIngresoMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                .addGap(160, 160, 160))
                            .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                                .addComponent(txtEncargadoMantenimiento)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarMantenimiento)
                .addContainerGap())
        );
        jPanelMantenimientoLayout.setVerticalGroup(
            jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEncargadoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(FechaIngresoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(FechaSalidaMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5))
                    .addGroup(jPanelMantenimientoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPaneMantenimiento.addTab("Ingreso Datos artículo en Mantenimiento", jPanelMantenimiento);

        jPanelContenedorEstados.addTab("Mantenimiento", jTabbedPaneMantenimiento);

        btnGuardarDefectuoso.setText("Guardar");
        btnGuardarDefectuoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDefectuosoActionPerformed(evt);
            }
        });

        jLabel6.setText("Observaciones");

        txtObservacionesDefectuoso.setColumns(20);
        txtObservacionesDefectuoso.setRows(5);
        jScrollPane3.setViewportView(txtObservacionesDefectuoso);

        javax.swing.GroupLayout jPanelDefectuosoLayout = new javax.swing.GroupLayout(jPanelDefectuoso);
        jPanelDefectuoso.setLayout(jPanelDefectuosoLayout);
        jPanelDefectuosoLayout.setHorizontalGroup(
            jPanelDefectuosoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDefectuosoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarDefectuoso)
                .addContainerGap())
            .addGroup(jPanelDefectuosoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanelDefectuosoLayout.setVerticalGroup(
            jPanelDefectuosoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDefectuosoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarDefectuoso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanelDefectuosoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPaneDefectuoso.addTab("Ingreso de datos artículo Perdido", jPanelDefectuoso);

        jPanelContenedorEstados.addTab("Defectuoso", jTabbedPaneDefectuoso);

        jLabel7.setText("Fecha dado de baja");

        jLabel8.setText("Motivo por el que fue dado de baja");

        btnGuardarDadoBaja.setText("Guardar");
        btnGuardarDadoBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDadoBajaActionPerformed(evt);
            }
        });

        txtMotivoDadoBaja.setColumns(20);
        txtMotivoDadoBaja.setRows(5);
        jScrollPane5.setViewportView(txtMotivoDadoBaja);

        jLabel13.setText("Numero artículo perdidos");

        javax.swing.GroupLayout jPanelDadoBajaLayout = new javax.swing.GroupLayout(jPanelDadoBaja);
        jPanelDadoBaja.setLayout(jPanelDadoBajaLayout);
        jPanelDadoBajaLayout.setHorizontalGroup(
            jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadoBajaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarDadoBaja)
                .addContainerGap())
            .addGroup(jPanelDadoBajaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_num_art_dadobaja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addComponent(FechaDadoBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanelDadoBajaLayout.setVerticalGroup(
            jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadoBajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarDadoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FechaDadoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(50, 50, 50)
                .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanelDadoBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_num_art_dadobaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        jTabbedPaneDadoBaja.addTab("Ingreso de datos artículo dado de baja", jPanelDadoBaja);

        jPanelContenedorEstados.addTab("Dado de baja", jTabbedPaneDadoBaja);

        jLabel9.setText("Fecha de artículo perdido");

        btnGuardarPerdido.setText("Guardar");
        btnGuardarPerdido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPerdidoActionPerformed(evt);
            }
        });

        jLabel12.setText("Numero artículo perdidos");

        javax.swing.GroupLayout jPanelPerdidoLayout = new javax.swing.GroupLayout(jPanelPerdido);
        jPanelPerdido.setLayout(jPanelPerdidoLayout);
        jPanelPerdidoLayout.setHorizontalGroup(
            jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPerdidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarPerdido)
                .addContainerGap())
            .addGroup(jPanelPerdidoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addGroup(jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPerdidoLayout.createSequentialGroup()
                        .addComponent(FechaPerdido, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanelPerdidoLayout.createSequentialGroup()
                        .addComponent(txt_num_art_perdidos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelPerdidoLayout.setVerticalGroup(
            jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerdidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_num_art_perdidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPerdidoLayout.createSequentialGroup()
                        .addComponent(btnGuardarPerdido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanelPerdidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechaPerdido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(65, 65, 65)
                        .addComponent(jLabel12)))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jTabbedPanePerdido.addTab("Ingreso de datos artículo perdido", jPanelPerdido);

        jPanelContenedorEstados.addTab("Perdido", jTabbedPanePerdido);

        jScrollPane1.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Al seleccionar el estado del artículo\nse muestra los controles necesarios\ncorrespondientes ");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel33.setText("Ingrese el ID del equipo");

        javax.swing.GroupLayout jPanel_InventarioLayout = new javax.swing.GroupLayout(jPanel_Inventario);
        jPanel_Inventario.setLayout(jPanel_InventarioLayout);
        jPanel_InventarioLayout.setHorizontalGroup(
            jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(jPanelContenedorEstados)
                .addGap(45, 45, 45))
            .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                        .addComponent(txt_BuscarModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_InventarioLayout.setVerticalGroup(
            jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel41)
                .addGap(5, 5, 5)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_BuscarModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel_InventarioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanelContenedorEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Manejo de Estado de Artículo", jPanel_Inventario);

        jLabel61.setText("A medida que ingrese el texto se desplegará los resultados");

        jLabel60.setText("Ingrese la CEDULA del funcionario");

        jLabel24.setText("Números de cédula");

        txt_BuscarModificarFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarFuncionarioKeyReleased(evt);
            }
        });

        jListModificarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jListModificarFuncionarioMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificarFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(jListModificarFuncionario);

        jid_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jid_inventarioMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jid_inventarioMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(jid_inventario);

        jLabel25.setText("Seleccione el equipo ");

        txt_BuscarModificarnFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarModificarnFuncionario1ActionPerformed(evt);
            }
        });
        txt_BuscarModificarnFuncionario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarnFuncionario1KeyReleased(evt);
            }
        });

        jLabel62.setText("Ingrese la CEDULA del nuevo funcionario al que se realizará el traspaso");

        jLabel27.setText("Números de cédula");

        jListModificar_nFuncionario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificar_nFuncionario1MouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(jListModificar_nFuncionario1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Traspaso");
        jScrollPane22.setViewportView(jTextArea3);

        jLabel29.setText("Observación ");

        jLabel30.setText("Seleccionar la fecha");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Marca", "Descripción", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane33.setViewportView(jTable1);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel61)))
                            .addComponent(jLabel60)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_BuscarModificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel25))
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62)
                                    .addComponent(txt_BuscarModificarnFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel31)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(txt_BuscarModificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txt_BuscarModificarnFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel29))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(282, 282, 282))
        );

        jTabbedPane3.addTab("Traspaso de equipos", jPanel5);

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_quitar.setText("Quitar prestamo");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

        jTablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Marca", " Modelo", "Stock disponible", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePrestamosMouseClicked(evt);
            }
        });
        jScrollPane34.setViewportView(jTablePrestamos);

        jListequipos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListequipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListequiposMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(jListequipos);

        jLabel26.setText("Equipos");

        jLabel67.setText("Ingrese el equipo o insumo a prestar");

        txt_Buscarequi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarequiActionPerformed(evt);
            }
        });
        txt_Buscarequi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarequiKeyReleased(evt);
            }
        });

        jListModificar_nFuncionario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListModificar_nFuncionario2MouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jListModificar_nFuncionario2);

        jLabel28.setText("Números de cédula");

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setText("Préstamo");
        jScrollPane24.setViewportView(jTextArea5);

        jLabel15.setText("Observación ");

        jLabel14.setText("Escoja la fecha");

        jLabel64.setText("Ingrese la CEDULA del funcionario");

        txt_BuscarModificarnFuncionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarModificarnFuncionario2ActionPerformed(evt);
            }
        });
        txt_BuscarModificarnFuncionario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarModificarnFuncionario2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel28))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txt_BuscarModificarnFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(170, 170, 170)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(txt_Buscarequi, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_quitar))))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addGap(30, 30, 30)
                                .addComponent(txt_Buscarequi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_BuscarModificarnFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(90, 90, 90)
                                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(btn_quitar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Préstamo/Entrega de equipos/insumos", jPanel6);

        jTabbedPane1.addTab("Manejo de Movimientos", jTabbedPane3);

        lbl_iconoApp_derecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/magapinv/www/interfacesmagap/recursos/logo_magap.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel32.setText("ARTÍCULOS Y MOVIMIENTOS");

        jMenu1.setText("Reportes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

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
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_iconoApp_derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_iconoApp_derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void SoloNumeros(JTextField stock){
    stock.addKeyListener(new KeyAdapter() {       
    public void keyTyped(KeyEvent a){
       char c = a.getKeyChar();
       if(Character.isLetter(c)){
           getToolkit().beep();
           a.consume();
       }
     }
    });
    }
@Override
public void setEnabled(boolean en) {
    super.setEnabled(en);
    setComponentsEnabled(this, en);
}
    
    private void setComponentsEnabled(java.awt.Container c, boolean en) {
    Component[] components = c.getComponents();
    for (Component comp: components) {
        if (comp instanceof java.awt.Container)
            setComponentsEnabled((java.awt.Container) comp, en);
        comp.setEnabled(en);
    }
}
    

public static void setEnableContainer(Container c, boolean band) {
         
 Component[] components = c.getComponents();
 c.setEnabled(band);
 for(int i = 0; i < components.length; i++){           
  components[i].setEnabled(band);
   
  if(components[i] instanceof Container){
   setEnableContainer((Container)components[i], band);
  }
   
 }       
} 
    
    private void lbl_estado_actual_inventario(){
        try {
            String stock= Integer.toString(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getStock());
            lbl_estado_actual_inventario.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_estado().getNombre_estado());
            lbl_stock_actual_inventario.setText(stock);
        } catch (Exception ex) {
           // Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnGuardarPerdidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPerdidoActionPerformed
        if (verificarPerdidoNulos())
        {
            JOptionPane.showMessageDialog(rootPane, "Algun campo no contiene datos verifique por favor", "Verficar campos NULOS", WIDTH);

        }else{
            try {
                String id_equipo = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo();
                String fechaperdido = new SimpleDateFormat("yyyy-MM-dd").format(FechaPerdido.getDate());
                java.sql.Date fechaPerdido;
                fechaPerdido = formatoFecha(fechaperdido);
                int id_estadope = FEstado_ac.obtenerEstado_ac_xnombre(jList_Estado_Inventario.getSelectedValue().toString()).getId_estado();
                Perdido per = new Perdido(fechaPerdido, id_estadope);
                if(Integer.parseInt(txt_num_art_perdidos.getText())<=0 || Integer.parseInt(txt_num_art_perdidos.getText())<=Integer.parseInt(lbl_stock_actual_inventario.getText())){
                    if(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_categoria().getId_categoria()==2){
                        FInventario.actualizarInventario_estado_stock_xcodigoEquipo(id_equipo, id_estadope,Integer.parseInt(txt_num_art_perdidos.getText()));
                        FPerdido.insertarPerdido(per);
                    } else{
                        int num_art_per = Integer.parseInt(txt_num_art_perdidos.getText());
                        FInventario.actualizarInventario_estado_xcodigoEquipo(id_equipo, id_estadope,num_art_per);
                        FPerdido.insertarPerdido(per);
                    }

                    JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "EL numero ingresado excede las existencias o es menor a 0", "ERROR", WIDTH);
                }
            } catch (Exception ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);

            }
        }
        lbl_estado_actual_inventario();
    }//GEN-LAST:event_btnGuardarPerdidoActionPerformed

    private void btnGuardarDadoBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDadoBajaActionPerformed
        if (verificarDadoBajaNulos())
        {
            JOptionPane.showMessageDialog(rootPane, "Algun campo no contiene datos verifique por favor", "Verficar campos NULOS", WIDTH);
        }else{
            try {
                String id_equipo = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo();
                String fechadadobaja = new SimpleDateFormat("yyyy-MM-dd").format(FechaDadoBaja.getDate());
                java.sql.Date fechaBaja;
                fechaBaja = formatoFecha(fechadadobaja);
                int id_estadoda = FEstado_ac.obtenerEstado_ac_xnombre(jList_Estado_Inventario.getSelectedValue().toString()).getId_estado();
                if(Integer.parseInt(txt_num_art_dadobaja.getText())<=0 || Integer.parseInt(txt_num_art_dadobaja.getText())<=Integer.parseInt(lbl_stock_actual_inventario.getText())){
                    if(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_categoria().getId_categoria()==2){
                        Dado_Baja dado = new Dado_Baja(fechaBaja, txtMotivoDadoBaja.getText(),id_estadoda);
                        FDado_Baja.insertarDado_Baja(dado);
                        JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
                        FInventario.actualizarInventario_estado_stock_xcodigoEquipo(id_equipo, id_estadoda,Integer.parseInt(txt_num_art_dadobaja.getText()));
                    } else{
                        //                     int num_art_da = Integer.parseInt(txt_num_art_dadobaja.getText());
                        //                     FInventario.actualizarInventario_estado_xcodigoEquipo(id_equipo, id_estadoda,num_art_da);
                        Dado_Baja dado = new Dado_Baja(fechaBaja, txtMotivoDadoBaja.getText(),id_estadoda);
                        FDado_Baja.insertarDado_Baja(dado);
                        JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
                        FInventario.actualizarInventario_estado_stock_xcodigoEquipo_baja(id_equipo, id_estadoda);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "EL numero ingresado excede las existencias o es menor a 0", "ERROR", WIDTH);
                }
                //FInventario.actualizarInventario_estado_stock_xcodigoEquipo_baja(id_equipo, id_estadoda);
                //FInventario.actualizarInventario_estado_xcodigoEquipo(id_equipo, id_estadoda);

                JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
            } catch (Exception ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lbl_estado_actual_inventario();
    }//GEN-LAST:event_btnGuardarDadoBajaActionPerformed

    private void btnGuardarDefectuosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDefectuosoActionPerformed
        if (verificarDefectuosoNulos())
        {
            JOptionPane.showMessageDialog(rootPane, "Algun campo no contiene datos verifique por favor", "Verficar campos NULOS", WIDTH);
        }else
        {
            try {
                // TODO add your handling code here:
                String id_equipo = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo();
                int id_estado_d = FEstado_ac.obtenerEstado_ac_xnombre(jList_Estado_Inventario.getSelectedValue().toString()).getId_estado();
                Defectuoso def = new Defectuoso(txtObservacionesDefectuoso.getText(), id_estado_d);
                FDefectuoso.insertarDefectuso(def);
                JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
                FInventario.actualizarInventario_solo_estado_xcodigoEquipo(id_equipo, id_estado_d);

            } catch (Exception ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lbl_estado_actual_inventario();
    }//GEN-LAST:event_btnGuardarDefectuosoActionPerformed

    private void btnGuardarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMantenimientoActionPerformed

        if (verificarMantenimientoNulos()){
            JOptionPane.showMessageDialog(rootPane, "Algun campo no contiene datos verifique por favor", "Verficar campos NULOS", WIDTH);
        }
        else{
            String fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").format(FechaIngresoMantenimiento.getDate());
            String fechaSalida = new SimpleDateFormat("yyyy-MM-dd").format(FechaSalidaMantenimiento.getDate());
            java.sql.Date fechaIngress;
            java.sql.Date fechaExit;
            try {
                // TODO add your handling code here:
                fechaIngress = formatoFecha(fechaIngreso);
                fechaExit = formatoFecha(fechaSalida);
                String id_equipo = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo();
                int id_estado = FEstado_ac.obtenerEstado_ac_xnombre(jList_Estado_Inventario.getSelectedValue().toString()).getId_estado();

                //Ingreso Mantenimiento
                Mantenimiento man = new Mantenimiento(txtEncargadoMantenimiento.getText(),fechaIngress, fechaExit, txtDescripcionDanio.getText(), id_estado);
                JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente", "DATOS GUARDADOS", WIDTH);
                FMantenimiento.insertarMantenimiento(man);
                FInventario.actualizarInventario_solo_estado_xcodigoEquipo(id_equipo, id_estado);

            } catch (Exception ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                // JOptionPane.showMessageDialog(rootPane, "El Articulo no se encuentra verificarlo por favor", "Verifique el codigo del ARTICULO", WIDTH);
            }
        }
        lbl_estado_actual_inventario();
    }//GEN-LAST:event_btnGuardarMantenimientoActionPerformed

    private void jList_Estado_InventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_Estado_InventarioMouseClicked
        try {
            // TODO add your handling code here
            String man = jList_Estado_Inventario.getSelectedValue().toString();
            String def = FEstado_ac.obtenerEstado_ac_xcodigo(2).getNombre_estado().toString();
            String mant = FEstado_ac.obtenerEstado_ac_xcodigo(1).getNombre_estado().toString();
            String per = FEstado_ac.obtenerEstado_ac_xcodigo(4).getNombre_estado().toString();
            String dad = FEstado_ac.obtenerEstado_ac_xcodigo(3).getNombre_estado().toString();
            String normal = FEstado_ac.obtenerEstado_ac_xcodigo(5).getNombre_estado().toString();

            if (man.equals(def)) {
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, true);
                jPanelContenedorEstados.setSelectedComponent(jTabbedPaneDefectuoso);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, false);
            } else if (man.equals(mant)){

                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, true);
                jPanelContenedorEstados.setSelectedComponent(jTabbedPaneMantenimiento);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, false);
            } else if (man.equals(per)){
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, true);
                jPanelContenedorEstados.setSelectedComponent(jTabbedPanePerdido);
            } else if (man.equals(dad)){
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, true);
                jPanelContenedorEstados.setSelectedComponent(jTabbedPaneDadoBaja);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, false);
            } else if (man.equals(normal)){
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDefectuoso, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelMantenimiento, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelDadoBaja, false);
                Movimiento_Inventario_Responsable.setEnableContainer(jPanelPerdido, false);

                String id_equipo = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_equipo();
                int id_estado_d = FEstado_ac.obtenerEstado_ac_xnombre(jList_Estado_Inventario.getSelectedValue().toString()).getId_estado();

                FInventario.actualizarInventario_solo_estado_xcodigoEquipo(id_equipo, id_estado_d);
                lbl_estado_actual_inventario();
                JOptionPane.showMessageDialog(rootPane, "Estado actualizado exitosamente", "ESTADO ACTUALIZADO", WIDTH);
            }
        } catch (Exception ex) {
            Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jList_Estado_InventarioMouseClicked

    private void txt_BuscarModificarArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarArticuloKeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarArticulo.getText().isEmpty()){
            modelo.clear();
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

    private void jListModificarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarEquipoMouseClicked

        try {

            txt_BuscarModificarArticulo.setText(jListModificarEquipo.getSelectedValue().toString());
            //jList_Estado_Inventario.setSelectedValue(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo.getText()).getId_estado(),true);
            lbl_estado_actual_inventario();
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jListModificarEquipoMouseClicked

    private void btnEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInventarioActionPerformed
        if(txtBuscarEquipoEliminar.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese el codigo por favor el campo esta vacio");
        }else{
            try {
                FInventario.eliminarInventario(FInventario.obtenerInventario_xcodigoEquipo(txtBuscarEquipoEliminar.getText()));
                 JOptionPane.showMessageDialog(rootPane, "Articulo eliminado", "EXITO", WIDTH);
       
            } catch (Exception ex) {
                //Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Articulo no encontrado verifique el codigo");

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

    private void btnActualizarArticuloInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarArticuloInventarioActionPerformed
        
        if(txt_BuscarModificarArticulo1.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese el codigo por favor el campo esta vacio");
        }else{

            if(verificarModificarArticulosInventario()){
                JOptionPane.showMessageDialog(rootPane, "Verifique que los campos esten llenos por favor");
            }else{
                try {
//                    FEstado_ac.obtenerEstado_ac_xnombre(cmbestadoInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_estado();
//                    FCategoria.obtenerCategoria_xnombre(cmbcategoriaInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_categoria();
//                    FBodega.obtenerBodega_xnombre(cmbbodegaInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_bodega();
                    String stock =txtstockInventario_ModificarArticulo.getText();
                    int stck = Integer.parseInt(stock);
                    FInventario.actualizarInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText(), txtmarcaInventario_ModificarArticulo.getText().toUpperCase(), txtmodeloInventario_ModificarArticulo.getText().toUpperCase(), jTextArea2.getText() ,  FEstado_ac.obtenerEstado_ac_xnombre(cmbestadoInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_estado(), FCategoria.obtenerCategoria_xnombre(cmbcategoriaInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_categoria(), FBodega.obtenerBodega_xnombre(cmbbodegaInventario_ModificarArticulo_ri.getSelectedItem().toString()).getId_bodega(), stck, txtidentificadorInventario_ModificarArticulo.getText());
                    JOptionPane.showMessageDialog(rootPane, "Articulo actualizado", "EXITO", WIDTH);
       
                }
                catch (Exception ex) {
                    //JOptionPane.showMessageDialog(rootPane, );
                    JOptionPane.showMessageDialog(rootPane, "Verifique el codigo en el cuadro ingrese ID equipo", "Exito", WIDTH);
                }
            }
        }
        // txt_BuscarModificarArticulo1.setText(txtidentificadorInventario_ModificarArticulo.getText());
        modelo.clear();
        modelo2.clear();
        modelo3.clear();
        }

        private void cargar_modelo_estado_invetario(){
            try {
                String sql ="Select * from bodega.estado_ac";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo_estado_inventario.clear();

                while (cres.next()){
                    modelo_estado_inventario.addElement(cres.getObject(1));
                }
                this.jList_Estado_Inventario.setModel(modelo_estado_inventario);
            } catch (Exception ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnActualizarArticuloInventarioActionPerformed

    private void jListModificarEquipo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarEquipo1MouseClicked
        try {
            // TODO add your handling code here:
            //        int xaxis1 = Integer.parseInt(txt_BuscarModificarArticulo.getText());
            txt_BuscarModificarArticulo1.setText(jListModificarEquipo1.getSelectedValue().toString());
            int xaxis1 = FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getStock();
            txtidentificadorInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getId_equipo());
            txtmarcaInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getMarca());
            txtmodeloInventario_ModificarArticulo.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getModelo());
            jTextArea2.setText(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getDescripcion());
            cmbestadoInventario_ModificarArticulo_ri.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getId_estado().getNombre_estado());
            cmbcategoriaInventario_ModificarArticulo_ri.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getId_categoria().getNombre_categoria());
            cmbbodegaInventario_ModificarArticulo_ri.setSelectedItem(FInventario.obtenerInventario_xcodigoEquipo(txt_BuscarModificarArticulo1.getText()).getId_bodega().getUbicacion());

            String Stock = String.valueOf(xaxis1);
            txtstockInventario_ModificarArticulo.setText(Stock);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarEquipo1MouseClicked

    private void txt_BuscarModificarArticulo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarArticulo1KeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarArticulo1.getText().isEmpty()){
            modelo.clear();
            modelo2.clear();
            modelo3.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarModificarArticulo1.getText();
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

                this.jListModificarEquipo1.setModel(modelo);
                this.jListModificarEquipo4.setModel(modelo2);
                this.jListModificarEquipo5.setModel(modelo3);

            }
            catch (Exception ex) {
                Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarArticulo1KeyReleased

    private void txtmarcaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmarcaInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmarcaInventarioActionPerformed

    private void actualizar_jListArticulosAsignados(){
        try {
            String sql ="SELECT inventario.id_inventario, id_equipo, marca, modelo, descripcion, id_estado,"
                    + " id_categoria, id_bodega, stock_inventario"
                    + "  FROM bodega.inventario inner join bodega.detalle_mov"
                    + "  on inventario.id_inventario=detalle_mov.id_inventario "
                    + "  where verificador=0 and id_categoria=1";
          
                       ConjuntoResultado cres=null;
                       cres = AccesoDatos.ejecutaQuery(sql);
                       modelojListArticulosAsignados.clear();
                       modelojListArticulosAsignados1.clear();
                       while (cres.next()){
                       modelojListArticulosAsignados.addElement(cres.getObject(1));
                       modelojListArticulosAsignados1.addElement(cres.getObject(4));
                       }

                       this.jListArticulosAsignados.setModel(modelojListArticulosAsignados);
                       this.jListArticulosAsignados1.setModel(modelojListArticulosAsignados1);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     private void actualizar_jListFuncionario_asignar(){
        try {
            String sql ="Select * from bodega.funcionario";
          
                       ConjuntoResultado cres=null;
                       cres = AccesoDatos.ejecutaQuery(sql);
                       modelojListFuncionario_asignar.clear();
                       while (cres.next()){
                       modelojListFuncionario_asignar.addElement(cres.getObject(0));
                       }

                       this.jListFuncionario_asignar.setModel( modelojListFuncionario_asignar);
                       this.jListFuncionario_asignar.setModel( modelojListFuncionario_asignar);
        } catch (Exception ex) {
            Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    
    
    private void btnguardarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarInventarioActionPerformed
       if(verificarIngresarInventarioNulos()){
            JOptionPane.showMessageDialog(rootPane, "Verificar que los campos no esten vacios", "Campos con valores nulos", WIDTH);
        }else{
            try {
                java.util.Date fecha1 = new Date();
                String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(fecha1);
                java.sql.Date fecha;
                String estado = (String)cmbestadoInventario.getSelectedItem();
                String categoria = (String)cmbcategoriaInventario.getSelectedItem();
                String bodega = (String)cmbbodegaInventario.getSelectedItem();
                int stock = Integer.parseInt(txtstock.getText());
                Inventario funu = new Inventario(0, txtidentificadorInventario.getText() , txtmarcaInventario.getText().toUpperCase(), txtmodeloInventario.getText().toUpperCase(),txtadescripcionInventario.getText() ,
                    FEstado_ac.obtenerEstado_ac_xnombre(estado), FCategoria.obtenerCategoria_xnombre(categoria), FBodega.obtenerBodega_xnombre(bodega), stock);
                FInventario.insertarInventario(funu);
                if(FCategoria.obtenerCategoria_xnombre(cmbcategoriaInventario.getSelectedItem().toString()).getId_categoria()==1){
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
                    det = new Detalle_Mov(FMovimientos.ultimo_mov(),"1111111111",FInventario.obtenerInventario_xcodigoEquipo(txtidentificadorInventario.getText()).getId_inventario(),1,0);
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
//                    FDetalle_Mov.actualizarencargado(txt_BuscarModificarFuncionario.getText(), FInventario.obtenerInventario_xcodigoEquipo(jTable1.getValueAt(i, 0).toString()).getId_inventario());
                    FDetalle_Mov.insertardetalle_mov(det);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);

                }
                 
        actualizar_jListArticulosAsignados();
                }       
                 JOptionPane.showMessageDialog(rootPane, "Articulo Insertado", "EXITO", WIDTH);
       
            } catch (Exception ex) {
                //Logger.getLogger(Ingresar_Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "El codigo del articulo ya existe", "Codigo Duplicado", WIDTH);
            }
        }
       
       cmbestadoInventario.setSelectedIndex(4);
            
            
    }//GEN-LAST:event_btnguardarInventarioActionPerformed

    private boolean verificarprestamosnulos(){
         boolean ban = false;
            if (txt_BuscarModificarnFuncionario2.getText().isEmpty()) 
            {
                ban = true;
            }       
            if (txt_Buscarequi.getText().isEmpty()) 
            {
                ban = true;
            }       
             
              if (jDateChooser3.getDate()==null){
                  ban = true;
              }
               if (jTextArea5.getText().isEmpty()){
                   ban = true;
               }
            
         return ban;
    }
    
   private static boolean isNumeric(String cadena){
        try {
        Integer.parseInt(cadena);
        return true;
        } catch (NumberFormatException nfe){
        return false;
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      String nombre_bodega=null;
      String recibe=null;
      String nombre_acta = null;
      int producto = 0;
      int j=0;
        jTablePrestamos.editCellAt(-1,-1);
        Detalle_Mov det = null;
        if (verificarprestamosnulos()==false){
            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser3.getDate());
            java.sql.Date fecha;
            try {
                fecha = formatoFecha(fechaBodega);
                Movimientos mov = new Movimientos(jTextArea5.getText().toString(),1,fecha);
                try {
                    FMovimientos.insertarmovimientos(mov);
                    for (int i = 0; i < jTablePrestamos.getRowCount(); i++) {
                            j++;
                if(jTablePrestamos.getValueAt(i,4)==null){
                    JOptionPane.showMessageDialog(rootPane, "Ingrese la cantidad por favor", "AVISO", deseo);
                }
                if(Integer.valueOf(jTablePrestamos.getValueAt(i,4).toString())<0 || Integer.valueOf(jTablePrestamos.getValueAt(i,4).toString())>Integer.valueOf(jTablePrestamos.getValueAt(i,3).toString())){
                         JOptionPane.showMessageDialog(rootPane, "Valor no puede ser negativo o mayor a Stock", "AVISO", deseo);
                }
//                if(!isNumeric(jTablePrestamos.getValueAt(i,4).toString())){
//                         JOptionPane.showMessageDialog(rootPane, "Valor cantidad no debe contener letras", "AVISO", deseo);
//                  }
                else{
                    try {
                        if (j == jTablePrestamos.getRowCount()){
                        det = new Detalle_Mov(FMovimientos.ultimo_mov(),txt_BuscarModificarnFuncionario2.getText(),FInventario.obtenerInventario_xcodigoEquipo_p(jTablePrestamos.getValueAt(i, 0).toString()).getId_inventario(),Integer.parseInt(jTablePrestamos.getValueAt(i, 4).toString()),2);
                        FDetalle_Mov.insertardetalle_mov(det);
                        JOptionPane.showMessageDialog(rootPane, "Transaccion realizada en la base de datos", "EXITO", WIDTH);
                        FInventario.actualizarInventario_stock_xcodigoEquipo(FInventario.obtenerInventario_xcodigoEquipo_p(jTablePrestamos.getValueAt(i, 0).toString()).getId_equipo(),Integer.parseInt((jTablePrestamos.getValueAt(i,4).toString())));
                        //Reporte
                        nombre_bodega = FFuncionario.obtenerFuncionario_xrol().getNombres().trim()+" "+FFuncionario.obtenerFuncionario_xrol().getApellidos().trim();
                        recibe =FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarnFuncionario2.getText()).getNombres().trim()+" "+FFuncionario.obtenerFuncionario_xcodigo(txt_BuscarModificarnFuncionario2.getText()).getApellidos().trim();
                        nombre_acta ="ENTREGA/RECEPCION";
                        producto= FMovimientos.ultimo_mov();
                        String cargo_funcionario=FFuncionario_Rol.obtenerFuncionarioRol_xcodigo_reporte(txt_BuscarModificarnFuncionario2.getText()).getId_rol().getNombre_rol().trim();
                        //String nuevo_encargado =
                        deseo1=0;                       
                        if (j == jTablePrestamos.getRowCount()){
                         jasper3.ejecutarReporte_Estado_Articulo(nombre_acta,nombre_bodega,recibe, producto,cargo_funcionario);
                         j=0;}
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, "Verifique la CI del Funcionario o cantidad ingresada", "AVISO", deseo);               
                    }
                }
            }                         
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Verifique la CI del Funcionario, o cantidad con letras", "ERROR", deseo);
      
                }
            } catch (ParseException ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }else {
            JOptionPane.showMessageDialog(null,"No puede existir valores nulos");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        // TODO add your handling code here:
        //        DefaultTableModel modelo_prestamos = (DefaultTableModel)jTableprestamos.getModel();
        //        modelo_prestamos.removeRow(jTableprestamos.getSelectedRow());
        //modelotabla.removeRow(jTable1.getSelectedRow());
        //        modelo_prestamos.fireTableDataChanged();
        //        modelotabla1.setNumRows(modelotabla1.getRowCount()-1);
        //id_fila.setText(String.valueOf(modelotabla.getRowCount())+" "+String.valueOf(deseo));
        //        deseo1--;
        //id_fila.setText(String.valueOf(jTable1.getSelectedRow()));
        if (tablaselecionada){
            
            DefaultTableModel model = (DefaultTableModel)jTablePrestamos.getModel();
            model.removeRow(jTablePrestamos.getSelectedRow());
            //modelotabla.removeRow(jTable1.getSelectedRow());
            model.fireTableDataChanged();
            modelotabla1.setNumRows(modelotabla1.getRowCount());
            if(deseo1==0){
            deseo1=modelotabla1.getRowCount();
            }else{
            deseo1--;}
            tablaselecionada=false;
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccione el elemento para eliminarlo por favor", "AVISO", deseo);
        }

        //id_fila.setText(String.valueOf(modelotabla.getRowCount())+" "+String.valueOf(deseo));
    }//GEN-LAST:event_btn_quitarActionPerformed

    private void jTablePrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePrestamosMouseClicked
        // TODO add your handling code here:
        tablaselecionada=true;
    }//GEN-LAST:event_jTablePrestamosMouseClicked

    private void llenartabla_prestamos(){
        // se crea un modelo para la tabla, el nombre de la variable de la tabla es: tabla
	DefaultTableModel modelo_prestamos=(DefaultTableModel) jTablePrestamos.getModel();
	 //se agrega la fila en la tabla con un valor vacio
	modelo_prestamos.addRow(new Object[deseo1]);
	 //para agregar valores en la fila
	//primero va el valor del campoo despues el numero de la fila y por ultimo el numero de la columna
	//deseo++;
	//el numero de las filas y columnas empieza en cero
	      
//    try {
//        jTableprestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo_p(jListequipos.getSelectedValue().toString()).getId_equipo(),deseo1 , 0);
//        jTableprestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo_p(jListequipos.getSelectedValue().toString()).getMarca(),deseo1 , 1);
//	jTableprestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo_p(jListequipos.getSelectedValue().toString()).getModelo(),deseo1 , 2);
//        jTableprestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo_p(jListequipos.getSelectedValue().toString()).getStock(),deseo1 , 3);
//        } catch (Exception ex) {
//        Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    deseo1++;
//    modelotabla1.setNumRows(deseo1);
//    modelotabla1.fireTableDataChanged();
    
            // se crea un modelo para la tabla, el nombre de la variable de la tabla es: tabla
//	DefaultTableModel modelo=(DefaultTableModel) jTablePrestamos.getModel();
//	 //se agrega la fila en la tabla con un valor vacio
//	modelo.addRow(new Object[deseo1]);
	 //para agregar valores en la fila
	//primero va el valor del campoo despues el numero de la fila y por ultimo el numero de la columna
	//deseo++;
	//el numero de las filas y columnas empieza en cero
	      
    try {
        jTablePrestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jListequipos.getSelectedValue().toString()).getId_equipo(),deseo1 , 0);
	jTablePrestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jListequipos.getSelectedValue().toString()).getMarca(), deseo1, 1);
	jTablePrestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jListequipos.getSelectedValue().toString()).getModelo(), deseo1, 2);
        jTablePrestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jListequipos.getSelectedValue().toString()).getStock(), deseo1, 3);
        //jTablePrestamos.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jListequipos.getSelectedValue().toString())., deseo, 3);      
 
      //  jTablePrestamos.setValueAt(FDetalle_Mov.obtenerdet_ced_inv(txt_BuscarModificarFuncionario.getText().toString(),(FInventario.obtenerInventario_xcodigoEquipo(jid_inventario.getSelectedValue().toString()).getId_inventario())).getCant(), deseo, 3);
        } catch (Exception ex) {
        Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    deseo1++;
    modelo_prestamos.setNumRows(deseo1);
    modelo_prestamos.fireTableDataChanged();
    
    }
    
    
    
    private void jListequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListequiposMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            txt_Buscarequi.setText(jListequipos.getSelectedValue().toString());
            //            try {
                //                String cad = txt_Buscarequi.getText();
                //                String sql ="Select * from bodega.funcionario where bodega.funcionario.numero_cedula like '"+
                //                cad+"%'";
                //                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
                //                 }
            //            catch (Exception ex) {
                //                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                //            }
        } catch (Exception ex) {
            // Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenartabla_prestamos();
    }//GEN-LAST:event_jListequiposMouseClicked

    private void txt_BuscarequiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarequiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarequiActionPerformed

    private void txt_BuscarequiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarequiKeyReleased
        // TODO add your handling code here:
        if (txt_Buscarequi.getText().isEmpty()){
            inventario_id_eq .clear();
        }
        else
        {

            try {
                String cad = txt_Buscarequi.getText();
                String sql ="Select * from bodega.inventario where id_equipo like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
                inventario_id_eq .clear();
                while (cres.next()){
                    inventario_id_eq .addElement(cres.getObject(1));
                }

                this.jListequipos.setModel(inventario_id_eq );
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }

    }//GEN-LAST:event_txt_BuscarequiKeyReleased

    private void jListModificar_nFuncionario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificar_nFuncionario2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            txt_BuscarModificarnFuncionario2.setText(jListModificar_nFuncionario2.getSelectedValue().toString());
            try {
                String cad = txt_BuscarModificarnFuncionario2.getText();
                String sql ="Select * from bodega.funcionario where bodega.funcionario.numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
                inventario_n_funcionario_cedula.clear();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (Exception ex) {
            // Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificar_nFuncionario2MouseClicked

    private void txt_BuscarModificarnFuncionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarModificarnFuncionario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarModificarnFuncionario2ActionPerformed

    private void txt_BuscarModificarnFuncionario2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarnFuncionario2KeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarnFuncionario2.getText().isEmpty()){
            modelo_funcionario_cedula_p.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarModificarnFuncionario2.getText();
                String sql ="Select * from bodega.funcionario where numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo_funcionario_cedula_p.clear();

                while (cres.next()){

                    modelo_funcionario_cedula_p.addElement(cres.getObject(0));
                }

                this.jListModificar_nFuncionario2.setModel(modelo_funcionario_cedula_p);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarnFuncionario2KeyReleased

    private void txt_BuscarModificarFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarFuncionarioKeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarFuncionario.getText().isEmpty()){
            modelo_funcionario_cedula.clear();
            inventario_funcionario_cedula.clear();
            inventario_marca_funcionario_cedula.clear();
            inventario_descripcion_funcionario_cedula.clear();
            inventario_n_funcionario_cedula.clear();
            inventario_n_marca_funcionario_cedula.clear();
            inventario_n_descripcion_funcionario_cedula.clear();
        }
        else
        {

            try {
                String cad = txt_BuscarModificarFuncionario.getText();
                String sql ="Select * from bodega.funcionario where numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo_funcionario_cedula.clear();

                while (cres.next()){

                    modelo_funcionario_cedula.addElement(cres.getObject(0));
                }

                this.jListModificarFuncionario.setModel(modelo_funcionario_cedula);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarFuncionarioKeyReleased

    private void jListModificarFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarFuncionarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jListModificarFuncionarioMouseEntered

    private void jListModificarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificarFuncionarioMouseClicked
        try {
            // TODO add your handling code here:
            txt_BuscarModificarFuncionario.setText(jListModificarFuncionario.getSelectedValue().toString());
            try {
                String cad = txt_BuscarModificarFuncionario.getText();
                //                String sql ="Select * from bodega.inventario,bodega.detalle_mov where bodega.inventario.id_categoria=1 and bodega.inventario.id_inventario = bodega.detalle_mov.id_inventario and bodega.inventario.id_estado=5 and bodega.detalle_mov.encargado like '"+
                //                cad+"%'";
                //                 String sql ="Select * from bodega.inventario,bodega.detalle_mov where bodega.inventario.id_categoria=1 and bodega.inventario.id_inventario = bodega.detalle_mov.id_inventario and bodega.inventario.id_estado=5 and bodega.detalle_mov.encargado like '"+
                //                cad+"%'";
                String sql ="select DISTINCT bodega.inventario.id_inventario,bodega.detalle_mov.encargado,bodega.inventario.id_equipo from bodega.inventario,bodega.detalle_mov where bodega.inventario.id_categoria=1 and bodega.detalle_mov.id_inventario=bodega.inventario.id_inventario and bodega.inventario.id_estado=5 and  bodega.detalle_mov.verificador=1 and bodega.detalle_mov.encargado like '"+cad+"';";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
                inventario_funcionario_cedula.clear();
                while (cres.next()){
                    inventario_funcionario_cedula.addElement(cres.getObject(2));
                    //                    inventario_marca_funcionario_cedula.addElement(cres.getObject(2));
                    //                    inventario_descripcion_funcionario_cedula.addElement(cres.getObject(3));
                    //                    mov_det_cant.addElement(cres.getObject(15));
                }
                this.jid_inventario.setModel(inventario_funcionario_cedula);
                //                this.marca_inventario.setModel(inventario_marca_funcionario_cedula);
                //                this.descripcion_inventario.setModel(inventario_descripcion_funcionario_cedula);
                //                this.jList_cant_m.setModel(mov_det_cant);
                //
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (Exception ex) {
            // Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificarFuncionarioMouseClicked

    private void jid_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jid_inventarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jid_inventarioMouseEntered

    private void llenartabla(){
        // se crea un modelo para la tabla, el nombre de la variable de la tabla es: tabla
	DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
	 //se agrega la fila en la tabla con un valor vacio
	modelo.addRow(new Object[deseo]);
	 //para agregar valores en la fila
	//primero va el valor del campoo despues el numero de la fila y por ultimo el numero de la columna
	//deseo++;
	//el numero de las filas y columnas empieza en cero
	      
    try {
        jTable1.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jid_inventario.getSelectedValue().toString()).getId_equipo(),deseo , 0);
	jTable1.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jid_inventario.getSelectedValue().toString()).getMarca(), deseo, 1);
	jTable1.setValueAt(FInventario.obtenerInventario_xcodigoEquipo(jid_inventario.getSelectedValue().toString()).getDescripcion(), deseo, 2);
        jTable1.setValueAt(FDetalle_Mov.obtenerdet_ced_inv(txt_BuscarModificarFuncionario.getText().toString(),(FInventario.obtenerInventario_xcodigoEquipo(jid_inventario.getSelectedValue().toString()).getId_inventario())).getCant(), deseo, 3);
        } catch (Exception ex) {
        Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    deseo++;
    modelotabla.setNumRows(deseo);
    modelotabla.fireTableDataChanged();
    }
    
    private void jid_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jid_inventarioMouseClicked
        // TODO add your handling code here:
        //inventario_marca_funcionario_cedula.clear();
        //inventario_descripcion_funcionario_cedula.clear();
        //stock_det_mov.clear();
        // TODO add your handling code here:
        //txt_BuscarModificarFuncionario.setText(jListModificarFuncionario.getSelectedValue().toString());
        try {
            String cad = txt_BuscarModificarFuncionario.getText();
            String sql ="Select DISTINCT bodega.inventario.id_inventario,bodega.inventario.id_equipo,bodega.inventario.marca,bodega.inventario.modelo,bodega.inventario.descripcion,bodega.inventario.id_categoria,bodega.inventario.id_bodega,bodega.inventario.stock_inventario,detalle_mov.id_mov,detalle_mov.encargado,detalle_mov.id_inventario,detalle_mov.cantidad  from bodega.inventario,bodega.detalle_mov where bodega.inventario.id_categoria=1 and bodega.detalle_mov.id_inventario=bodega.inventario.id_inventario and bodega.inventario.id_estado=5 and bodega.detalle_mov.encargado like '"+cad+"'and bodega.inventario.id_equipo like '"+jid_inventario.getSelectedValue().toString()+"';";
            //String sql=Select * from bodega.inventario,bodega.detalle_mov where bodega.inventario.id_categoria=1 and bodega.inventario.id_estado=5 and bodega.detalle_mov.encargado like like '"+cad+"' and bodega.detalle_mov.id_inventario=2 and bodega.inventario.id_equipo='PEPEL';

            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            //inventario_funcionario_cedula.clear();
            while (cres.next()){
                //inventario_funcionario_cedula.addElement(cres.getObject(1));
                //inventario_marca_funcionario_cedula.addElement(cres.getObject(2));
                inventario_descripcion_funcionario_cedula.addElement(cres.getObject(4));
                //stock_det_mov.addElement(cres.getObject(15));
            }
            // this.id_inventario.setModel(inventario_funcionario_cedula);
            //this.jmarca_inventario.setModel(inventario_marca_funcionario_cedula);
            //this.jdescripcion_inventario.setModel(inventario_descripcion_funcionario_cedula);
            //this.canti.setModel(stock_det_mov);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

        llenartabla();
    }//GEN-LAST:event_jid_inventarioMouseClicked

    private void txt_BuscarModificarnFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarModificarnFuncionario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarModificarnFuncionario1ActionPerformed

    private void txt_BuscarModificarnFuncionario1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarModificarnFuncionario1KeyReleased
        // TODO add your handling code here:
        if (txt_BuscarModificarnFuncionario1.getText().isEmpty()){
            modelo_n_funcionario_cedula.clear();
        }
        else
        {

            try {
                String cad1 = txt_BuscarModificarFuncionario.getText();
                String cad = txt_BuscarModificarnFuncionario1.getText();
                String sql ="Select * from bodega.funcionario where numero_cedula like '"+
                cad+"%' and numero_cedula not like '"+cad1+"'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);

                modelo_n_funcionario_cedula.clear();

                while (cres.next()){

                    modelo_n_funcionario_cedula.addElement(cres.getObject(0));
                }

                this.jListModificar_nFuncionario1.setModel(modelo_n_funcionario_cedula);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());

            }
        }
    }//GEN-LAST:event_txt_BuscarModificarnFuncionario1KeyReleased

    private void jListModificar_nFuncionario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListModificar_nFuncionario1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            txt_BuscarModificarnFuncionario1.setText(jListModificar_nFuncionario1.getSelectedValue().toString());
            try {
                String cad = txt_BuscarModificarnFuncionario1.getText();
                String sql ="Select * from bodega.funcionario where bodega.funcionario.numero_cedula like '"+
                cad+"%'";
                ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
                inventario_n_funcionario_cedula.clear();
                while (cres.next()){
                    inventario_n_funcionario_cedula.addElement(cres.getObject(1));
                    inventario_n_marca_funcionario_cedula.addElement(cres.getObject(2));
                    inventario_n_descripcion_funcionario_cedula.addElement(cres.getObject(3));
                }
                //                this.id_ninventario1.setModel(inventario_n_funcionario_cedula);
                //                this.marca_ninventario1.setModel(inventario_n_marca_funcionario_cedula);
                //                this.descripcion_ninventario1.setModel(inventario_n_descripcion_funcionario_cedula);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (Exception ex) {
            // Logger.getLogger(Ingresar_Unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListModificar_nFuncionario1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow(jTable1.getSelectedRow());
        //modelotabla.removeRow(jTable1.getSelectedRow());
        model.fireTableDataChanged();
        modelotabla.setNumRows(modelotabla.getRowCount());
        //id_fila.setText(String.valueOf(modelotabla.getRowCount())+" "+String.valueOf(deseo));
        if(deseo==0){
            deseo=modelotabla1.getRowCount();
            }else{
            deseo--;}
        //id_fila.setText(String.valueOf(jTable1.getSelectedRow()));
    }//GEN-LAST:event_jTable1MouseClicked

     private boolean verificarTraspasonulos(){
         boolean ban = false;
            if (txt_BuscarModificarFuncionario.getText().isEmpty()) 
            {
                ban = true;
            }       
            if (txt_BuscarModificarnFuncionario1.getText().isEmpty()) 
            {
                ban = true;
            }       
             
              if (jDateChooser1.getDate()==null){
                  ban = true;
              }
               if (jTextArea3.getText().isEmpty()){
                   ban = true;
               }
            
         return ban;
    }

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (verificarTraspasonulos()==false){
            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            java.sql.Date fecha;
            java.sql.Date fecha1=null;
            try {
                fecha = formatoFecha(fechaBodega);
                Movimientos mov = new Movimientos(jTextArea3.getText().toString(),2,fecha);
                try {
                    FMovimientos.insertarmovimientos(mov);
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }   Detalle_Mov det = null;
            for (int i = 0; i <jTable1.getRowCount(); i++) {
                try {
                    det = new Detalle_Mov(FMovimientos.ultimo_mov(),txt_BuscarModificarnFuncionario1.getText(),FInventario.obtenerInventario_xcodigoEquipo(jTable1.getValueAt(i, 0).toString()).getId_inventario(),Integer.parseInt(jTable1.getValueAt(i, 3).toString()),1);
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    FDetalle_Mov.actualizarencargado(txt_BuscarModificarFuncionario.getText(), FInventario.obtenerInventario_xcodigoEquipo(jTable1.getValueAt(i, 0).toString()).getId_inventario());
                    FDetalle_Mov.insertardetalle_mov(det);
                    JOptionPane.showMessageDialog(rootPane, "Traspaso realizado", "EXITO", WIDTH);       
                    deseo=0;
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  else {
            JOptionPane.showMessageDialog(null,"No puede existir valores nulos");
        }

        //        } catch (Exception ex) {
        //            Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        actualizarlistas_nencargado();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            InputStream is = this.getClass().getResourceAsStream("/com/magapinv/www/interfacesmagap/recursos/Manual_de_Bodeguero_del_sistema_de_inventario_Automatizado_SINA.pdf");
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

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        Reportes rep = new Reportes();
        rep.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Salir();
    }//GEN-LAST:event_formWindowClosing

    private void btnAsignar_Articulo_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignar_Articulo_FuncionarioActionPerformed
        // TODO add your handling code here:
            java.util.Date fecha1 = new Date();
            String fechaBodega = new SimpleDateFormat("yyyy-MM-dd").format(fecha1);
            java.sql.Date fecha;
            
            try {
                fecha = formatoFecha(fechaBodega);
                Movimientos mov = new Movimientos("Asignado",3,fecha);
                try {
                    FMovimientos.insertarmovimientos(mov);
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
            }   Detalle_Mov det = null;
         
                try {
                     FDetalle_Mov.actualizarencargado("1111111111", FInventario.obtenerInventario_xcodigoEquipo(jListArticulosAsignados.getSelectedValue().toString()).getId_inventario());
                     det = new Detalle_Mov(FMovimientos.ultimo_mov(),jListFuncionario_asignar.getSelectedValue().toString(),FInventario.obtenerInventario_xcodigoEquipo(jListArticulosAsignados.getSelectedValue().toString()).getId_inventario(),1,1);
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
//                    FDetalle_Mov.actualizarencargado(txt_BuscarModificarFuncionario.getText(), FInventario.obtenerInventario_xcodigoEquipo(jTable1.getValueAt(i, 0).toString()).getId_inventario());
                    FDetalle_Mov.insertardetalle_mov(det);
                    JOptionPane.showMessageDialog(rootPane, "Articulo Asignado", "EXITO", WIDTH);
       
         
                } catch (Exception ex) {
                    Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Hubo un error verifique ", "ERROR", WIDTH);
       
         
                }            
       
        actualizar_jListFuncionario_asignar();
        actualizar_jListArticulosAsignados();
    }//GEN-LAST:event_btnAsignar_Articulo_FuncionarioActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

        actualizar_jListArticulosAsignados();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        acercade rep = new acercade();
        rep.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void aviso_stock(){  
        try {
            for(Inventario e : FInventario.obtenertodoslosInventarios_stock()){    
                               // System.out.println(e.getId_equipo());
                               // System.out.println(e.getCedula_funcionario());
                                
            if(FInventario.obtenertodoslosInventarios_stock()!=null){
                JOptionPane.showMessageDialog(rootPane, "Insumos inferiores a 10 adquiera mas por favor "+e.getId_equipo()+" CANTIDAD = "+e.getStock(), "ADVERTENCIA", WIDTH);
            }
                            }
            
        } catch (Exception ex) {
            Logger.getLogger(Movimiento_Inventario_Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static java.sql.Date formatoFecha(String fechaBodega) throws ParseException{
    
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateStr = formatter.parse(fechaBodega);

            java.sql.Date sqlDate = new java.sql.Date(dateStr.getTime());
        return sqlDate;
    }

     private boolean verificarMantenimientoNulos(){
         boolean ban = false;
            if (txtEncargadoMantenimiento.getText().isEmpty()) 
            {
                ban = true;
            }       
             if (FechaIngresoMantenimiento.getDate()==null){
                 ban = true;
             }
              if (FechaSalidaMantenimiento.getDate()==null){
                  ban = true;
              }
               if (txtDescripcionDanio.getText().isEmpty()){
                   ban = true;
               }
            
         return ban;
    }

     private  boolean verificarDefectuosoNulos(){
         boolean ban = false;
         if (txtObservacionesDefectuoso.getText().isEmpty()) {
             ban = true;
         }
         return ban;
     }
     
     private boolean verificarPerdidoNulos(){
          boolean ban = false;
         if (FechaPerdido.getDate()==null || txt_num_art_perdidos.getText().isEmpty()) {
             ban = true;
         }
         return ban;
     }
     
     private boolean verificarDadoBajaNulos(){
     boolean ban = false;
         if (txtMotivoDadoBaja.getText().isEmpty()){
             ban = true;
         }
         if (FechaDadoBaja.getDate() == null)  {
             ban = true;
         }
         return ban;
     }
 

    
    private boolean verificarIngresarInventarioNulos(){
        boolean ban = false;      
        if( txtidentificadorInventario.getText().isEmpty() || txtmarcaInventario.getText().isEmpty() || txtmodeloInventario.getText().isEmpty() || txtadescripcionInventario.getText().isEmpty() || txtstock.getText().isEmpty()){
            ban=true;
        }
        return ban;
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
            if(jTextArea2.getText().isEmpty()){
        ban=true;
        }
            if(txtstockInventario_ModificarArticulo.getText().isEmpty()){
        ban=true;
        }
        return ban; 
    }
    

    
    public static void main(String args[]) {
        //Ejm22_SubirImagen obj=new Ejm22_SubirImagen();
        //obj.setVisible(true);
        //obj.setImagen();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movimiento_Inventario_Responsable().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaDadoBaja;
    private com.toedter.calendar.JDateChooser FechaIngresoMantenimiento;
    private com.toedter.calendar.JDateChooser FechaPerdido;
    private com.toedter.calendar.JDateChooser FechaSalidaMantenimiento;
    private javax.swing.JButton btnActualizarArticuloInventario;
    private javax.swing.JButton btnAsignar_Articulo_Funcionario;
    private javax.swing.JButton btnEliminarInventario;
    private javax.swing.JButton btnGuardarDadoBaja;
    private javax.swing.JButton btnGuardarDefectuoso;
    private javax.swing.JButton btnGuardarMantenimiento;
    private javax.swing.JButton btnGuardarPerdido;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btnguardarInventario;
    private javax.swing.JComboBox cmbbodegaInventario;
    private javax.swing.JComboBox cmbbodegaInventario_ModificarArticulo_ri;
    private javax.swing.JComboBox cmbcategoriaInventario;
    private javax.swing.JComboBox cmbcategoriaInventario_ModificarArticulo_ri;
    private javax.swing.JComboBox cmbestadoInventario;
    private javax.swing.JComboBox cmbestadoInventario_ModificarArticulo_ri;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayered_ModificarArticulo;
    private javax.swing.JList jListArticulosAsignados;
    private javax.swing.JList jListArticulosAsignados1;
    private javax.swing.JList jListFuncionario_asignar;
    private javax.swing.JList jListModificarEquipo;
    private javax.swing.JList jListModificarEquipo1;
    private javax.swing.JList jListModificarEquipo2;
    private javax.swing.JList jListModificarEquipo3;
    private javax.swing.JList jListModificarEquipo4;
    private javax.swing.JList jListModificarEquipo5;
    private javax.swing.JList jListModificarFuncionario;
    private javax.swing.JList jListModificar_nFuncionario1;
    private javax.swing.JList jListModificar_nFuncionario2;
    private javax.swing.JList jList_Estado_Inventario;
    private javax.swing.JList jList_articuloEliminar;
    private javax.swing.JList jList_articuloEliminar2;
    private javax.swing.JList jList_articuloEliminar3;
    private javax.swing.JList jListequipos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jPanelContenedorEstados;
    private javax.swing.JPanel jPanelDadoBaja;
    private javax.swing.JPanel jPanelDefectuoso;
    private javax.swing.JPanel jPanelMantenimiento;
    private javax.swing.JPanel jPanelPerdido;
    private javax.swing.JPanel jPanel_Inventario;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
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
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPaneDadoBaja;
    private javax.swing.JTabbedPane jTabbedPaneDefectuoso;
    private javax.swing.JTabbedPane jTabbedPaneMantenimiento;
    private javax.swing.JTabbedPane jTabbedPanePerdido;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablePrestamos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JList jid_inventario;
    private javax.swing.JLabel lbl_estado_actual_inventario;
    private javax.swing.JLabel lbl_iconoApp_derecha;
    private javax.swing.JLabel lbl_stock_actual_inventario;
    private javax.swing.JTextField txtBuscarEquipoEliminar;
    private javax.swing.JTextArea txtDescripcionDanio;
    private javax.swing.JTextField txtEncargadoMantenimiento;
    private javax.swing.JTextArea txtMotivoDadoBaja;
    private javax.swing.JTextArea txtObservacionesDefectuoso;
    private javax.swing.JTextField txt_BuscarModificarArticulo;
    private javax.swing.JTextField txt_BuscarModificarArticulo1;
    private javax.swing.JTextField txt_BuscarModificarFuncionario;
    private javax.swing.JTextField txt_BuscarModificarnFuncionario1;
    private javax.swing.JTextField txt_BuscarModificarnFuncionario2;
    private javax.swing.JTextField txt_Buscarequi;
    private javax.swing.JTextField txt_num_art_dadobaja;
    private javax.swing.JTextField txt_num_art_perdidos;
    private javax.swing.JTextArea txtadescripcionInventario;
    private javax.swing.JTextField txtidentificadorInventario;
    private javax.swing.JTextField txtidentificadorInventario_ModificarArticulo;
    private javax.swing.JTextField txtmarcaInventario;
    private javax.swing.JTextField txtmarcaInventario_ModificarArticulo;
    private javax.swing.JTextField txtmodeloInventario;
    private javax.swing.JTextField txtmodeloInventario_ModificarArticulo;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtstockInventario_ModificarArticulo;
    // End of variables declaration//GEN-END:variables

    private void Salir() {
        Object[] options = { "Aceptar", "Cancelar" };
        int seleccion=JOptionPane.showOptionDialog(this, "Esta Seguro que desea salir de la Aplicación", "Atención",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[1]);
        if(seleccion==0){
           System.exit(0);
        }
    }
}


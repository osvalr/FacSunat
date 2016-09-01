/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import AccessoDato.DAOTablasSolas;
import AccessoDato.ECliente;
import AccessoDato.EDocumento;
import AccessoDato.EEmpresa;
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import AccessoDato.EParametro;
import AccessoDato.ERelacionadoDocumento;
import AccessoDato.ERelacionadoDocumentoDetalle;
import Negocio.BCliente;
import Negocio.BEmpresa;
import Negocio.BFactura;
import Negocio.BFacturaDetalle;
import Negocio.BParametro;
import Negocio.BRelacionadoDocumento;
import Negocio.BTablasSolas;
import Utilidad.DisplayValue;
import Utilidad.Formato;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import Utilidad.NotaDebito;
import Utilidad.OtrasEntidad;
import java.awt.Dimension;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class FrmNotaDebito extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public String m_Codigo;
    public JDesktopPane m_escritorio;
    private BParametro _bparametro;
    private EParametro _eparametro;
    private BCliente _bcliente;
    private ECliente _ecliente;
    private BEmpresa _bempresa;
    private EEmpresa _empresa;
    private EFactura _efeactura;
    private BFactura _bfactura;
    private BFacturaDetalle _bfacturadetalle;
    private BTablasSolas _btablassolas;
    private ERelacionadoDocumento _erelaciondocumento;
    private List<ERelacionadoDocumentoDetalle> _lsdocumentodetalle;
    private EFacturaDetalle _efacturadetalle;
    private List<EFacturaDetalle> _lsefacturadetalle=new ArrayList<>();
    private List<EDocumento> _lsdocumento;
    private DefaultComboBoxModel _modelocmbdocumento;
    private DefaultComboBoxModel _modelocmbnotadebito;
    private DefaultComboBoxModel _modelocmbclase;
    private BRelacionadoDocumento _brelaciodocumento;
    private OtrasEntidad _otrosTipos;
    private DAOTablasSolas _daootrasTablas;
    public String StrAgregandoReferenciaxItem;
    public FrmNotaDebito() {
        initComponents();
    }
    private static FrmNotaDebito frmdebito;
    public static FrmNotaDebito getinstancia()
    {
        if(frmdebito==null)
            frmdebito=new FrmNotaDebito();
        return frmdebito;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbclase = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        txtasunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbnotadebito = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        ldireccion = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsearchserie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtsearchnumero = new javax.swing.JTextField();
        btnbuscaritem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalledebito = new javax.swing.JTable();
        btneliminaritem = new javax.swing.JButton();
        btnagregarcomentarioitem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtdescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtvalorventa = new javax.swing.JTextField();
        txtigv = new javax.swing.JTextField();
        txtimportetotal = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Nota Debito");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        btnNuevo.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\folder_new.png")); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\savedata.png")); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnlimpiar.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\limpiar.png")); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setFocusable(false);
        btnlimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlimpiar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnlimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnlimpiar);

        jLabel1.setText("Clase Pago");

        cmbclase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Asunto");

        jLabel4.setText("Tipo de Debito");

        cmbnotadebito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Cliente");

        ldireccion.setText("Direccion");

        jLabel6.setText("Serie");

        jLabel7.setText("Numero");

        btnbuscaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\buscaritemnotecredito.png")); // NOI18N
        btnbuscaritem.setText("buscar");
        btnbuscaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscaritemActionPerformed(evt);
            }
        });

        jLabel8.setText("Numero Documento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(ldireccion)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbnotadebito, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbclase, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtsearchserie, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtsearchnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscaritem)
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtasunto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbdocumento, 0, 179, Short.MAX_VALUE)
                    .addComponent(txtruc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtsearchserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtsearchnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscaritem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbnotadebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtasunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldireccion)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        detalledebito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detalledebito);

        btneliminaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\removeitem.png")); // NOI18N
        btneliminaritem.setEnabled(false);
        btneliminaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminaritemActionPerformed(evt);
            }
        });

        btnagregarcomentarioitem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\addcomentarioitemdebito.png")); // NOI18N
        btnagregarcomentarioitem.setEnabled(false);
        btnagregarcomentarioitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarcomentarioitemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneliminaritem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregarcomentarioitem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btneliminaritem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnagregarcomentarioitem))))
        );

        txtdescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescuento.setEnabled(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Sub Total Ventas   :");

        jLabel12.setText("Descuentos  :");

        txtsubtotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtsubtotal.setEnabled(false);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Valor de Venta  :");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("IGV  :");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Importe Total  :");

        txtvalorventa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtvalorventa.setEnabled(false);

        txtigv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtigv.setEnabled(false);

        txtimportetotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtimportetotal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(652, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtimportetotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtimportetotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            m_Tipoinstancia=InstanciaForm.NEW;
            ClearForm();
            EstablecerInstancia();
        }
        catch(Exception e)
        {        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try
        {
            if(validar())
            {
                GetItem();
                _brelaciodocumento = new BRelacionadoDocumento();
                _erelaciondocumento.setRel_cserie(_eparametro.getPar_cserie());
                _erelaciondocumento.setRel_cnumero(_eparametro.getPar_cnumero());
                _erelaciondocumento.setRel_cestado(_eparametro.getPar_cestado());
                _erelaciondocumento.setVen_ncodigo(_eparametro.getPar_nvendedor());
                NotaDebito _nota = new  NotaDebito();
                _bempresa=new BEmpresa();
                _empresa=_bempresa.ObtenerUno(_eparametro.getPar_nsucursal());
                int _incrementadonumero=(Integer.parseInt(_eparametro.getPar_cnumero())+1);
                _erelaciondocumento.setRel_cnumero(String.valueOf(_incrementadonumero));
                _nota.setEempresa(_empresa);
                _nota.setEcliente(_ecliente);
                _nota.setEfactura(_efeactura);
                _nota.setErelaciondoc(_erelaciondocumento);
                _nota.setLsrelaciondoc(_lsdocumentodetalle);
//                _nota.setLsdetfactura(_lsefacturadetalle);
                if(_nota.FillXml())
                {
                    if(!_nota.Envio())
                        JOptionPane.showMessageDialog(null, "ResponseCode :"+_nota.errResponseCode+ " Detalle :" +_nota.errDescription, "Respuesta Sunat.",JOptionPane.WARNING_MESSAGE);
                    else
                    {
                        JOptionPane.showMessageDialog(null, " Sunat :" +_nota.errDescription ,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
                        if(_brelaciodocumento.Guardar(_erelaciondocumento, _lsdocumentodetalle))
                           {
                                 JOptionPane.showMessageDialog(null, "Se guardo correctamente.", "Nota Debito.",JOptionPane.WARNING_MESSAGE);
                           }
                           else
                                 JOptionPane.showMessageDialog(null, "No se pudo guardar", "Nota Debito.",JOptionPane.WARNING_MESSAGE);
                    }
                    //
                }
                ClearForm();
                m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                EstablecerInstancia();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Se encontro algunos Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        m_Tipoinstancia=InstanciaForm.UNCHANGUE;
        ClearForm();
        EstablecerInstancia();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnbuscaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaritemActionPerformed
        try
        {
            if(ValidarBuscar())
            {
                _bfactura = new BFactura();
                String _serie=txtsearchserie.getText().toUpperCase();
                String _numero=txtsearchnumero.getText().toUpperCase();
                if(_bfactura.VerificarExisteFactura(_serie, _numero))
                {
                    FrmBuscar _buscar = new FrmBuscar(true,10,this);
                    _buscar.setFac_serie(_serie);
                    _buscar.setFac_numero(_numero);
                    m_escritorio.add(_buscar);
                    _buscar.show();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "La factura no existe.", "Resultado Busqueda",JOptionPane.WARNING_MESSAGE);
                    txtsearchserie.setText("");
                    txtsearchnumero.setText("");
                }
            }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnbuscaritemActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            _btablassolas = new BTablasSolas();
            _lsdocumento=_btablassolas.ObtenerTodoDocumentos();
            _daootrasTablas= new DAOTablasSolas();
            Vector _item=new Vector();
            DisplayValue _valor=null;
            cmbdocumento.removeAllItems();
            for(int i=0;i<=_lsdocumento.size()-1;i++)
            {
                if(_lsdocumento.get(i).getDoc_ccodigo().equals("08"))
                {  _valor=(new DisplayValue(_lsdocumento.get(i).getDoc_cdescripcion(),_lsdocumento.get(i).getDoc_ccodigo()));
                    _item.addElement(_valor);
                }
            }
            _modelocmbdocumento= new DefaultComboBoxModel(_item);
            cmbdocumento.setModel(_modelocmbdocumento);
            _item=new Vector();
            _item.addElement(new DisplayValue("Seleccionar","-1"));
            for(int i=0;i<=OtrasEntidad.TipoNotaCredito.length-1;i++)
                _item.addElement(new DisplayValue(OtrasEntidad.TipoNotaCredito[i][1],OtrasEntidad.TipoNotaCredito[i][0]));
            _modelocmbnotadebito= new DefaultComboBoxModel(_item);
            cmbnotadebito.setModel(_modelocmbnotadebito);
            _otrosTipos = new OtrasEntidad();
            _item=new Vector();
            for (int i=0;i<=_otrosTipos.TipoPago.length-1;i++)
                _item.addElement(new DisplayValue(_otrosTipos.TipoPago[i][1], _otrosTipos.TipoPago[i][0]));
            _modelocmbclase = new DefaultComboBoxModel(_item);
            cmbclase.setModel(_modelocmbclase);
            txtsearchserie.setDocument(new JTextFielCharLimit(MaximoCharacter.StrSerieDoc));
            txtsearchnumero.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNumeroDoc)));
            m_igv=_daootrasTablas.Obtenerigv();
            txtigv.setText(String.valueOf(m_igv));
            CargarformDetalle();
            EstablecerInstancia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened
    FrmDescripcionRetificacionCreditoDebito frmaddnotadebito;
    Dimension desktopSize; 
    Dimension Internal;
    private int posicion=-1;
    public String _DescripcionNota;
    public Integer _Cantidad;
    public Double _ValorVentaNota;
    private void btnagregarcomentarioitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarcomentarioitemActionPerformed
        try {
            if(detalledebito.getSelectedRow()>=0)
            {
                    frmaddnotadebito=FrmDescripcionRetificacionCreditoDebito.getinstance(this);
                    frmaddnotadebito.m_Tipoinstancia=InstanciaForm.NEW;
                    posicion=detalledebito.getSelectedRow();
                    frmaddnotadebito.setEstadofrm(false);
                    if(!m_escritorio.isAncestorOf(frmaddnotadebito))
                    {
                        frmaddnotadebito.m_escritorio=m_escritorio;
                        desktopSize = m_escritorio.getSize();
                        Internal = frmaddnotadebito.getSize();
                        frmaddnotadebito.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                        m_escritorio.add(frmaddnotadebito);
                    }
                    else
                    {
                        this.m_escritorio.setSelectedFrame(frmaddnotadebito);
                        frmaddnotadebito.CargarDato();
                    }
                    frmaddnotadebito.setVisible(true);
                    frmaddnotadebito.setSelected(true);
            }
            else
            {  JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Nota Debito",JOptionPane.WARNING_MESSAGE);  }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnagregarcomentarioitemActionPerformed

    private void btneliminaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminaritemActionPerformed
        try {
            if(detalledebito.getSelectedRow()>=0)
            {
                if(detalledebito.getSelectedRow()==0)
                {
                    JOptionPane.showMessageDialog(null, "Tiene que aver minimo un item.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String _CodigoDetalle=detalledebito.getValueAt(detalledebito.getSelectedRow(), 1).toString();
                    for(int i=0;i<=_lsefacturadetalle.size()-1;i++)
                    {
                        if(_lsefacturadetalle.get(i).getDfa_ncodigo()==Integer.parseInt(_CodigoDetalle))
                        {
                            _lsefacturadetalle.remove(i);
                            break;
                        }
                    }
                    setItemsDetalle();
                }
            }
            else
            { JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Nota Debito",JOptionPane.WARNING_MESSAGE);      }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btneliminaritemActionPerformed
    private void ClearForm()
    {
        txtsearchserie.setText("");
        txtsearchnumero.setText("");
        txtasunto.setText("");
        cmbnotadebito.setSelectedIndex(0);
        _ecliente=null;
        txtcliente.setText("");
        txtdireccion.setText("");
        txtruc.setText("");
        DefaultTableModel _mod = (DefaultTableModel) detalledebito.getModel();
        _mod.setNumRows(0);
    }
    private void GetItem()
    {
        try {
            _erelaciondocumento = new ERelacionadoDocumento();
            //fecha
                    _erelaciondocumento.setM_instancia(InstancaEntidad.NEW);
                    DisplayValue _valor=(DisplayValue)cmbdocumento.getSelectedItem();
                    _erelaciondocumento.setDoc_ccodigo(_valor.getValueMenber());
                    _valor=(DisplayValue)cmbnotadebito.getSelectedItem();
                    _erelaciondocumento.setMtv_ccodigo(_valor.getValueMenber());
                    _erelaciondocumento.setFac_ncodigo(_efeactura.getFac_ncodigo());
                    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    _erelaciondocumento.setRel_dfechaemision(date);
                    _valor=((DisplayValue)cmbclase.getSelectedItem()); 
                    _erelaciondocumento.setRel_clasepago(_valor.getValueMenber());
                    _erelaciondocumento.setRel_figv(_efeactura.getFac_igv());
                    _erelaciondocumento.setRel_fsubtotal(_efeactura.getFac_fimportesubtotal());
                    _erelaciondocumento.setRel_ftotal(_efeactura.getFac_ftotal());
                    _erelaciondocumento.setRel_ftotalexonerado(_efeactura.getFac_ftotalexonerado());
                    _erelaciondocumento.setRel_ftotalinafecto(  _efeactura.getFac_ftotalinafecto());
                    _erelaciondocumento.setRel_ftotalisc(_efeactura.getFac_ftotalisc());
                    _erelaciondocumento.setRel_ftotalotrostributos(_efeactura.getFac_ftotalotrostributos());
                    _erelaciondocumento.setRel_cdescripcion(txtasunto.getText());
                    _erelaciondocumento.setRel_cmoneda(_efeactura.getMon_ccodigo());
                    _erelaciondocumento.setSuc_ncodigo(_efeactura.getSuc_ncodigo());
                    _erelaciondocumento.setRel_facserienumero(_efeactura.getFac_cserie()+"-"+_efeactura.getFac_cnumero());
                    //_erelaciondocu.setRel_cdescripcion(m_Codigo);
                    for(int i=0;i<=_lsefacturadetalle.size()-1;i++)
                    {
                        if(_lsefacturadetalle.get(i).getM_instancia()==InstancaEntidad.UNCHANGUE)
                        {
                            ERelacionadoDocumentoDetalle _erelaciondocumentodetalle= new ERelacionadoDocumentoDetalle();
                            _erelaciondocumentodetalle.setM_instancia(InstancaEntidad.NEW);
                            _erelaciondocumentodetalle.setArt_ncodigo(_lsefacturadetalle.get(i).getArt_ncodigo());
                            _erelaciondocumentodetalle.setRde_ccantidad(_lsefacturadetalle.get(i).getDfa_ccantidad());
                            _erelaciondocumentodetalle.setRde_fvalorunitario(_lsefacturadetalle.get(i).getDfa_fvalorunitario());
                            _erelaciondocumentodetalle.setRde_ctipoafectacion(_lsefacturadetalle.get(i).getPve_ctipoafectacion());
                            _erelaciondocumentodetalle.setRde_fvalorsubtotal(_lsefacturadetalle.get(i).getDfa_fvalorsubtotal());
                            _erelaciondocumentodetalle.setRde_fvalorventa(_lsefacturadetalle.get(i).getDfa_fvalorventa());
                            _erelaciondocumentodetalle.setUni_ncodigo(_lsefacturadetalle.get(i).getUni_ncodigo());
                            _erelaciondocumentodetalle.setRde_fdescuento(_lsefacturadetalle.get(i).getDfa_fdescuento());
                            _erelaciondocumentodetalle.setRde_fvaloritemigv(_lsefacturadetalle.get(i).getDfa_fvaloritemigv());
                            _erelaciondocumentodetalle.setRde_fvalortotal(_lsefacturadetalle.get(i).getDfa_fvalortotal());
                            _erelaciondocumentodetalle.setArt_cafectacion(_lsefacturadetalle.get(i).getArt_cafectacion());
                            _erelaciondocumentodetalle.setRde_cDescripcionItem(_lsefacturadetalle.get(i).getDfa_cDescripcionDetalleItem());
                            _lsdocumentodetalle.add(_erelaciondocumentodetalle);
                        }
                    }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error funcion GetItem.", "Nota Debito",JOptionPane.WARNING_MESSAGE); }
    }
    private boolean validar()
    {
        return true;
    }
    private void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
                        btnGuardar.setEnabled(true);
                        btnNuevo.setEnabled(false);
                        cmbclase.setEnabled(false);
                        txtasunto.setEnabled(true);
                        cmbnotadebito.setEnabled(true);
                        txtsearchserie.setEnabled(true);
                        txtsearchnumero.setEnabled(true);
                        btnbuscaritem.setEnabled(true);
                        btnlimpiar.setEnabled(true);
                        txtruc.setEnabled(false);
                        cmbdocumento.setEnabled(false);
//                        btnagregarcomentarioitem.setEnabled(true);
                        break;
                    case MODIFY :

                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        //btnBuscar.setEnabled(true);
                        cmbclase.setEnabled(false);
                        txtasunto.setEnabled(false);
                        txtruc.setEnabled(false);
                        cmbnotadebito.setEnabled(false);
                        txtcliente.setEnabled(false);
                        txtdireccion.setEnabled(false);
                        txtsearchserie.setEnabled(false);
                        txtsearchnumero.setEnabled(false);
                        btnbuscaritem.setEnabled(false);
                        btnlimpiar.setEnabled(false);
                        cmbdocumento.setEnabled(false);
                        btnagregarcomentarioitem.setEnabled(false);
                        break;
                        
                }
    }
    private boolean ValidarBuscar()
    {
        if(txtsearchserie.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "El valor de la serie no es correcto.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
            txtsearchserie.setFocusable(true);
            txtsearchserie.setText("");
            return false;
        }
        else if(txtsearchnumero.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "El valor del numero no es correcto.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
            txtsearchnumero.setFocusable(true);
            txtsearchnumero.setText("");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnagregarcomentarioitem;
    private javax.swing.JButton btnbuscaritem;
    private javax.swing.JButton btneliminaritem;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cmbclase;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JComboBox<String> cmbnotadebito;
    private javax.swing.JTable detalledebito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel ldireccion;
    private javax.swing.JTextField txtasunto;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtimportetotal;
    private javax.swing.JTextField txtruc;
    private javax.swing.JTextField txtsearchnumero;
    private javax.swing.JTextField txtsearchserie;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txtvalorventa;
    // End of variables declaration//GEN-END:variables

    void CargarFrm() {
        try {
            if(!m_Codigo.equals(""))
            {
                _bfactura=new BFactura();
                _efeactura=_bfactura.AccionObtenerObtenerUno(Integer.parseInt(m_Codigo));
                if(_efeactura!=null)
                {
                    _bcliente = new BCliente();
                    _ecliente=_bcliente.ObtenerUno(_efeactura.getCli_ncodigo());
                    txtcliente.setText(_ecliente.getCli_crazon());
                    txtdireccion.setText(_ecliente.getCli_cdireccionfiscal());
                    txtruc.setText(_ecliente.getCli_cnumerodoc());
                    Vector _v=new Vector();
                        for (int i=0;i<=_modelocmbclase.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)_modelocmbclase.getElementAt(i);
                            if(_valor.getValueMenber().equals(_efeactura.getFac_cclasepago()));
                            {
                               _modelocmbclase.setSelectedItem(_valor);
                               break;
                            }
                        }
                    cmbclase.setModel(_modelocmbclase);
                    _bfacturadetalle = new BFacturaDetalle();
                    _lsefacturadetalle=_bfacturadetalle.AccionObtenerAllxCabecera(Integer.parseInt(m_Codigo));
                    if(_lsefacturadetalle.size()>0)
                    { setItemsDetalle();
                      btnagregarcomentarioitem.setEnabled(true);
                      btneliminaritem.setEnabled(true);
                    }
                }
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se pudo cargar items"+e.getMessage(), "Nota Debito",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void setItemsDetalle() {
        Object [] rowData = new Object[12];
        DefaultTableModel _mod = (DefaultTableModel) detalledebito.getModel();
        _mod.setNumRows(0);
        try {
                for(int i=0;i<=_lsefacturadetalle.size()-1;i++)
                {
                    rowData[0]=""+(i+1);
                    rowData[1]=_lsefacturadetalle.get(i).getDfa_ncodigo();
                    String nombreCompleto="";
                    if(_lsefacturadetalle.get(i).getDfa_cDescripcionDetalleItem()!=null)
                        nombreCompleto= _lsefacturadetalle.get(i).getDfa_cDescripcionDetalleItem().length()==0?" ":" "+_lsefacturadetalle.get(i).getDfa_cDescripcionDetalleItem();
                    rowData[2]=_lsefacturadetalle.get(i).getArt_cdescripcion()+nombreCompleto;
                    rowData[3]=_lsefacturadetalle.get(i).getUni_cdescripcion();
                    rowData[4]=_lsefacturadetalle.get(i).getDfa_ccantidad();
                    rowData[5]=_lsefacturadetalle.get(i).getDfa_fvalorunitario();
                    rowData[6]=_lsefacturadetalle.get(i).getDfa_fdescuento();
                    rowData[7]=_lsefacturadetalle.get(i).getCategoria();
                    rowData[8]=_lsefacturadetalle.get(i).getDfa_fvalortotal();
                    rowData[9]=_lsefacturadetalle.get(i).getM_instancia();
                    //adicional
                    rowData[10]=_lsefacturadetalle.get(i).getFac_ncodigo();
                    rowData[11]=_lsefacturadetalle.get(i).getArt_ncodigo();
                    _mod.addRow(rowData);
                }
        detalledebito.setModel(_mod);
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Cargando Detalle",JOptionPane.WARNING_MESSAGE);    }
    }
    private void CargarformDetalle()
    {
        try
        {
            DefaultTableModel mdo = new DefaultTableModel()//---------------------------------------------------DESABILITANDO COLUMNAS
            { 
                boolean[] canEdit = new boolean[]{false,false,false,true,true,false,false,false,false,false,false,false };
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                {  return canEdit[columnIndex];}
            };
            Object[] columname = new Object[12];
            columname[0]="Item";
            columname[1]="dfa_ncodigo";
            columname[2]="Producto";
            columname[3]="Unidad";
            columname[4]="Cantidad";
            columname[5]="Valor Venta";
            columname[6]="Descuento";
            columname[7]="IGV";            
            columname[8]="Total";
            columname[9]="m_instancia";  
            //adicional
            columname[10]="fac_ncodigo";  
            columname[11]="art_ncodigo";  
            
            mdo.setColumnIdentifiers(columname);
            detalledebito.setModel(mdo);
            detalledebito.getColumn("Producto").setPreferredWidth(200);
            detalledebito.getColumn("Producto").setMinWidth(200);
            detalledebito.getColumn("Producto").setWidth(200);
            detalledebito.getColumn("Producto").setMaxWidth(200);
            detalledebito.getColumn("m_instancia").setPreferredWidth(0);
            detalledebito.getColumn("m_instancia").setMinWidth(0);
            detalledebito.getColumn("m_instancia").setWidth(0);
            detalledebito.getColumn("m_instancia").setMaxWidth(0);
            detalledebito.getColumn("dfa_ncodigo").setPreferredWidth(0);
            detalledebito.getColumn("dfa_ncodigo").setMinWidth(0);
            detalledebito.getColumn("dfa_ncodigo").setWidth(0);
            detalledebito.getColumn("dfa_ncodigo").setMaxWidth(0);
            detalledebito.getColumn("fac_ncodigo").setPreferredWidth(0);
            detalledebito.getColumn("fac_ncodigo").setMinWidth(0);
            detalledebito.getColumn("fac_ncodigo").setWidth(0);
            detalledebito.getColumn("fac_ncodigo").setMaxWidth(0);
            detalledebito.getColumn("art_ncodigo").setPreferredWidth(0);
            detalledebito.getColumn("art_ncodigo").setMinWidth(0);
            detalledebito.getColumn("art_ncodigo").setWidth(0);
            detalledebito.getColumn("art_ncodigo").setMaxWidth(0);
            detalledebito.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            detalledebito.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);   }
    }
    private Formato _fmd = new Formato();
    public void ActualizarDatoItem()
    {
        try {

                if(posicion!=-1)
                {
                    _efacturadetalle=_lsefacturadetalle.get(posicion);
                    _efacturadetalle.setDfa_cDescripcionDetalleItem(_DescripcionNota);
                    _efacturadetalle.setDfa_ccantidad(_Cantidad);
                    _efacturadetalle.setDfa_fvalorunitario(_ValorVentaNota);
                    _efacturadetalle.setDfa_fvalorsubtotal(_fmd.Farmat2DosDecimales(_efacturadetalle.getDfa_ccantidad()*_efacturadetalle.getDfa_fvalorunitario()));
                    _efacturadetalle.setDfa_fvalortotal(_fmd.Farmat2DosDecimales(_efacturadetalle.getDfa_fvalorsubtotal()+(_efacturadetalle.getDfa_fvalorsubtotal()*m_igv/100)));
                    _lsefacturadetalle.set(posicion, _efacturadetalle);
                    posicion=-1;
                    setItemsDetalle();
                    ActualizarDatosCabecera();
                    CalcularTotales();
                    m_escritorio.remove(frmaddnotadebito);
                    frmaddnotadebito=null;
                }
//                frmaddnotadebito=null;
        } catch (Exception e) {
        }
        
    }
    private double m_igv;
    private void ActualizarDatosCabecera()
    {
        double _totaligv=0;
                         double _subtotal=0;
                         double _netototal=0;
                         double _totalexonerada=0;
                         double _totalinafecta=0;
                         for (int i=0;i<=_lsefacturadetalle.size()-1;i++)
                         {
                             if(_lsefacturadetalle.get(i).getDfa_fdescuento()>0)
                                 _totaligv+=(_lsefacturadetalle.get(i).getDfa_fvalorsubtotal()*(m_igv/100));
                             else
                             _totaligv+=(_lsefacturadetalle.get(i).getDfa_fvaloritemigv()*_lsefacturadetalle.get(i).getDfa_ccantidad());
                             
                             switch (_lsefacturadetalle.get(i).getArt_cafectacion()) {
                                 case "01":
                                     _subtotal+=_lsefacturadetalle.get(i).getDfa_fvalorsubtotal();
                                     break;
                                 case "02":
                                     _totalexonerada+=_lsefacturadetalle.get(i).getDfa_fvalortotal();
                                     break;
                                 case "03":
                                     _totalinafecta+=_lsefacturadetalle.get(i).getDfa_fvalortotal();
                                     break;
                                 default:
                                     break;
                             }
                             _netototal+=_lsefacturadetalle.get(i).getDfa_fvalortotal();
                         }
                         _efeactura.setFac_igv(_fmd.Farmat2DosDecimales(_totaligv));
                         _efeactura.setFac_fimportesubtotal(_fmd.Farmat2DosDecimales(_subtotal));
                         _efeactura.setFac_ftotal(_fmd.Farmat2DosDecimales(_netototal));
                         _efeactura.setFac_ftotalexonerado(_totalexonerada);
                         _efeactura.setFac_ftotalinafecto(_totalinafecta);

    }
    private void CalcularTotales()
    {
        try
        {
            double sigv=0;
            double snoigv=0;
            double totaldescuento=0;
            for (int i=0;i<=detalledebito.getRowCount()-1;i++ )
            {
                String d= detalledebito.getValueAt(i, 8).toString();
                double d1=Double.parseDouble(d);
                if(detalledebito.getValueAt(i, 7).toString().equals("Gravado"))
                {
                    sigv+=d1;
                    totaldescuento+=Double.parseDouble(detalledebito.getValueAt(i, 6).toString());
                }else
                    snoigv+=d1;
            }
            txtsubtotal.setText(""+(sigv+snoigv));
//            txtanticipios.setText("0");
            txtdescuento.setText(String.valueOf(_fmd.Farmat2DosDecimales(totaldescuento)));
            txtvalorventa.setText(""+(sigv+snoigv));
            txtigv.setText(""+m_igv); //String.valueOf(m_igv*sigv/100)
            double totaligv=m_igv*sigv/100;
//            double impottetotal=Double.parseDouble(txtsubtotal.getText())+Double.parseDouble(txtanticipios.getText())+totaligv;
//            txtimportetotal.setText(String.valueOf(_fmd.Farmat2DosDecimales(impottetotal)));
        }
        catch(Exception e)
        {
        }
    }
    
//    private void ObtenerValorItemSeleccionado()
//    {
//        try {
//            DefaultTableModel _mod = (DefaultTableModel) detalledebito.getModel();
//            _efacturadetalle=(EFacturaDetalle)_mod.getClass().getComponentType().getSigners()
//            if(_efacturadetalle!=null)
//            {
//            
//            }
//        
//        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error ObteniendoItem :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE); 
//        }
//    }
}

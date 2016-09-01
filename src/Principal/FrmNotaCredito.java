
package Principal;

import AccessoDato.DAOTablasSolas;
import AccessoDato.ECliente;
import AccessoDato.EDocumento;
import AccessoDato.EEmpresa;
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import AccessoDato.EMotivoNota;
import AccessoDato.EParametro;
import AccessoDato.ERelacionadoDocumentoDetalle;
import AccessoDato.ERelacionadoDocumento;
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
import Utilidad.NotaCredito;
import Utilidad.OtrasEntidad;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmNotaCredito extends javax.swing.JInternalFrame {

    
    private static FrmNotaCredito frmnotacredito;
    private BTablasSolas _btablassolas;
    private List<EDocumento> _lsdocumento;
    private List<EMotivoNota> _lsmotivonota;
    private List<EFacturaDetalle> _lsefacturadetalle=new ArrayList<>();
    private DefaultComboBoxModel _modelotiponota;
    private DefaultComboBoxModel _modelodocumento;
    private DefaultComboBoxModel _modeloclase;
    private OtrasEntidad _otrosTipos;
    private EFactura _efeactura;
    private BFactura _bfactura;
    private BCliente _bcliente;
    private ECliente _ecliente;
    private BEmpresa _bempresa;
    private EEmpresa _empresa;
    private BParametro _bparametro;
    private EParametro _eparametro;
    private EFacturaDetalle _efacturadetalle;
    private List<ERelacionadoDocumentoDetalle> _lsrelaciondocumento= new ArrayList<>();
    private ERelacionadoDocumentoDetalle _erelaciondetalle;
    private ERelacionadoDocumento _erelaciondocu;
    private BRelacionadoDocumento _brelaciondocumento;
    private BFacturaDetalle _bfacturadetalle;
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public String m_Codigo;
    private DAOTablasSolas _daootrasTablas;

    public static FrmNotaCredito getistancia()
    {
        if(frmnotacredito==null)
            frmnotacredito= new FrmNotaCredito();
        return frmnotacredito;
    }
    public FrmNotaCredito() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbclase = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        txtasunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbtiponota = new javax.swing.JComboBox<>();
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
        detallecredito = new javax.swing.JTable();
        btneliminaritem = new javax.swing.JButton();
        btnadicionaritem = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtanticipios1 = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtvalorventa = new javax.swing.JTextField();
        txtigv = new javax.swing.JTextField();
        txtimportetotal1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Nota de Credito");
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

        jLabel1.setText("Clase Pago");

        cmbclase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdocumentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Asunto");

        jLabel4.setText("Tipo de Nota");

        cmbtiponota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel8.setText("ruc");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtasunto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbtiponota, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbclase, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtsearchserie, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtsearchnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscaritem)))
                .addContainerGap(208, Short.MAX_VALUE))
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
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbtiponota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtasunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldireccion)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        detallecredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detallecredito);

        btneliminaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\removeitem.png")); // NOI18N
        btneliminaritem.setEnabled(false);
        btneliminaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminaritemActionPerformed(evt);
            }
        });

        btnadicionaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\addcomentarioitemdebito.png")); // NOI18N
        btnadicionaritem.setEnabled(false);
        btnadicionaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionaritemActionPerformed(evt);
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
                    .addComponent(btnadicionaritem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btneliminaritem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnadicionaritem)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

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

        txtanticipios1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtanticipios1.setEnabled(false);

        txtdescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescuento.setEnabled(false);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Sub Total Ventas   :");

        jLabel21.setText("Descuentos  :");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Anticipios  :");

        txtsubtotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtsubtotal.setEnabled(false);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Valor de Venta  :");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("IGV  :");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Importe Total  :");

        txtvalorventa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtvalorventa.setEnabled(false);

        txtigv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtigv.setEnabled(false);

        txtimportetotal1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtimportetotal1.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(640, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtanticipios1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtimportetotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtanticipios1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtimportetotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdocumentoActionPerformed
    }//GEN-LAST:event_cmbdocumentoActionPerformed

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
                _brelaciondocumento = new BRelacionadoDocumento();
                _erelaciondocu.setRel_cserie(_eparametro.getPar_cserie());
                _erelaciondocu.setRel_cnumero(_eparametro.getPar_cnumero());
                _erelaciondocu.setRel_cestado(_eparametro.getPar_cestado());
                _erelaciondocu.setVen_ncodigo(_eparametro.getPar_nvendedor());
                NotaCredito _nota = new NotaCredito();
                _bempresa=new BEmpresa();
                _empresa=_bempresa.ObtenerUno(_eparametro.getPar_nsucursal());
                int _incrementadonumero=(Integer.parseInt(_eparametro.getPar_cnumero())+1);
                _erelaciondocu.setRel_cnumero(String.valueOf(_incrementadonumero));
                _nota.setEempresa(_empresa);
                _nota.setEcliente(_ecliente);
                _nota.setEfactura(_efeactura);
                _nota.setErelaciondoc(_erelaciondocu);
                _nota.setLsrelaciondoc(_lsrelaciondocumento);
                _nota.setLsdetfactura(_lsefacturadetalle);
                if(_nota.FillXml())
                {
                            if(!_nota.Envio())
                                JOptionPane.showMessageDialog(null, "ResponseCode :"+_nota.errResponseCode+ " Detalle :" +_nota.errDescription, "Respuesta Sunat.",JOptionPane.WARNING_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, " Sunat :" +_nota.errDescription ,"Respuesta",JOptionPane.INFORMATION_MESSAGE);

//
                }
//                if(_brelaciondocumento.Guardar(_erelaciondocu, _lsrelaciondocumento))
//                {
//                    JOptionPane.showMessageDialog(null, "Se guardo correctamente.", "Nota Credito.",JOptionPane.WARNING_MESSAGE);
//                }
//                else
//                    JOptionPane.showMessageDialog(null, "No se pudo guardar", "Nota Credito.",JOptionPane.WARNING_MESSAGE);
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
    private boolean validar()
    {
        try {
            if(cmbtiponota.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione un motivo.", "Nota Credito",JOptionPane.WARNING_MESSAGE);
                cmbtiponota.setFocusable(true);
                return false;
            }
            if(txtasunto.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un asunto.", "Nota Credito",JOptionPane.WARNING_MESSAGE);
                txtasunto.setFocusable(true);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            _btablassolas = new BTablasSolas();
            _lsdocumento=_btablassolas.ObtenerTodoDocumentos();
            _lsmotivonota=_btablassolas.ObtenerTodosMotivoNota();
            Vector _item=new Vector();
            DisplayValue _valor=null;
            cmbdocumento.removeAllItems();
            for(int i=0;i<=_lsdocumento.size()-1;i++)
            {
                if(_lsdocumento.get(i).getDoc_ccodigo().equals("07"))
                {  _valor=(new DisplayValue(_lsdocumento.get(i).getDoc_cdescripcion(),_lsdocumento.get(i).getDoc_ccodigo()));
                    _item.addElement(_valor);
                }
            }
            _modelodocumento = new DefaultComboBoxModel(_item);
            _modelodocumento.setSelectedItem(_valor);
            cmbdocumento.setModel(_modelodocumento);
            cmbtiponota.removeAllItems();
            _item=new Vector();
            _item.addElement(new DisplayValue("Seleccione","-1"));
            for(int i=0;i<=_lsmotivonota.size()-1;i++)
                    _item.addElement(new DisplayValue(_lsmotivonota.get(i).getMtv_cdescripcion(),_lsmotivonota.get(i).getMtv_ccodigo()));
            _modelotiponota = new DefaultComboBoxModel(_item);
            cmbtiponota.setModel(_modelotiponota);
            _item = new Vector();
            cmbclase.removeAllItems();
            _otrosTipos = new OtrasEntidad();
            for (int i=0;i<=_otrosTipos.TipoPago.length-1;i++)
                _item.addElement(new DisplayValue(_otrosTipos.TipoPago[i][1], _otrosTipos.TipoPago[i][0]));
            _modeloclase = new DefaultComboBoxModel(_item);
            cmbclase.setModel(_modeloclase);
            cmbdocumento.setEnabled(false);
            _bparametro = new BParametro();
            _eparametro=_bparametro.AccionObtenerConfiguracion(6, "07");
            _daootrasTablas= new DAOTablasSolas();
            m_igv=_daootrasTablas.Obtenerigv();
            txtigv.setText(String.valueOf(m_igv));
            
            txtsearchserie.setDocument(new JTextFielCharLimit(MaximoCharacter.StrSerieDoc));
            txtsearchnumero.setDocument(new JTextFielCharLimit(MaximoCharacter.StrNumeroDoc));
            CargarformDetalle();
            EstablecerInstancia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

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
                    FrmBuscar _buscar = new FrmBuscar(10,this);//,txtsearchserie.getText(),txtsearchnumero.getText());
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

    private void btneliminaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminaritemActionPerformed
        try {
            if(detallecredito.getSelectedRow()>=0)
            {
                if(detallecredito.getSelectedRow()==0)
                {
                    JOptionPane.showMessageDialog(null, "Tiene que aver minimo un item.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String _CodigoDetalle=detallecredito.getValueAt(detallecredito.getSelectedRow(), 1).toString();
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
            
        }catch(Exception e){}
    }//GEN-LAST:event_btneliminaritemActionPerformed
    FrmDescripcionRetificacionCreditoDebito frmagregarnota;
    Dimension desktopSize; 
    Dimension Internal;
    private int posicion=-1;
    public String _DescripcionNota;
    public Integer _Cantidad;
    public Double _ValorVentaNota;
    private void btnadicionaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionaritemActionPerformed
       try {
            if(detallecredito.getSelectedRow()>=0)
            {
                    frmagregarnota=FrmDescripcionRetificacionCreditoDebito.getinstance(this);
                    frmagregarnota.m_Tipoinstancia=InstanciaForm.NEW;
                    posicion=detallecredito.getSelectedRow();
                    frmagregarnota.setEstadofrm(true);
                    if(!m_escritorio.isAncestorOf(frmagregarnota))
                    {
                        frmagregarnota.m_escritorio=m_escritorio;
                        desktopSize = m_escritorio.getSize();
                        Internal = frmagregarnota.getSize();
                        frmagregarnota.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                        m_escritorio.add(frmagregarnota);
                    }
                    else
                    {
                        this.m_escritorio.setSelectedFrame(frmagregarnota);
                        frmagregarnota.CargarDato();
                    }
                    frmagregarnota.setVisible(true);
                    frmagregarnota.setSelected(true);
            }
            else
            {  JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Nota Debito",JOptionPane.WARNING_MESSAGE);  }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnadicionaritemActionPerformed
    public void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
                        btnGuardar.setEnabled(true);
                        btnNuevo.setEnabled(false);
//                        btnBuscar.setEnabled(false);
                        cmbclase.setEnabled(false);
//                        cmbdocumento.setEnabled(true);
                        txtasunto.setEnabled(true);
                        cmbtiponota.setEnabled(true);
                        txtsearchserie.setEnabled(true);
                        txtsearchnumero.setEnabled(true);
                        btnbuscaritem.setEnabled(true);
                        btneliminaritem.setEnabled(false);
                        btnlimpiar.setEnabled(true);
                        txtruc.setEnabled(false);
                        btnadicionaritem.setEnabled(false);
                        break;
                    case MODIFY :
//                        btnGuardar.setEnabled(true);
//                        btnNuevo.setEnabled(false);
//                        btnBuscar.setEnabled(false);
//                        cmbtiponota.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        //btnBuscar.setEnabled(true);
                        cmbclase.setEnabled(false);
//                        cmbdocumento.setEnabled(false);
                        txtasunto.setEnabled(false);
                        txtruc.setEnabled(false);
                        cmbtiponota.setEnabled(false);
                        txtcliente.setEnabled(false);
                        txtdireccion.setEnabled(false);
                        txtsearchserie.setEnabled(false);
                        txtsearchnumero.setEnabled(false);
                        btnbuscaritem.setEnabled(false);
                        btneliminaritem.setEnabled(false);
                        btnlimpiar.setEnabled(false);
                        btnadicionaritem.setEnabled(false);
                        break;
                        
                }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnadicionaritem;
    private javax.swing.JButton btnbuscaritem;
    private javax.swing.JButton btneliminaritem;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cmbclase;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JComboBox<String> cmbtiponota;
    private javax.swing.JTable detallecredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel ldireccion;
    private javax.swing.JTextField txtanticipios1;
    private javax.swing.JTextField txtasunto;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtimportetotal1;
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
                        for (int i=0;i<=_modeloclase.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)_modeloclase.getElementAt(i);
                            if(_valor.getValueMenber().equals(_efeactura.getFac_cclasepago()));
                            {
                               _modeloclase.setSelectedItem(_valor);
                               break;
                            }
                        }
                    cmbclase.setModel(_modeloclase);
                    _bfacturadetalle = new BFacturaDetalle();
                    _lsefacturadetalle=_bfacturadetalle.AccionObtenerAllxCabecera(Integer.parseInt(m_Codigo));
                    if(_lsefacturadetalle.size()>0)
                    {   setItemsDetalle();
                        btnadicionaritem.setEnabled(true);
                        btneliminaritem.setEnabled(true);
                    }
                }
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se pudo cargar items"+e.getMessage(), "Nota Credito",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void CargarformDetalle()
    {
        try
        {
            DefaultTableModel mdo = new DefaultTableModel()//---------------------------------------------------DESABILITANDO COLUMNAS
            { 
                boolean[] canEdit = new boolean[]{false,false,false,true,true,false,false,false,false,false };
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                {  return canEdit[columnIndex];}
            };
            Object[] columname = new Object[10];
            columname[0]="Item";
            columname[1]="codigo";
            columname[2]="Producto";
            columname[3]="Unidad";
            columname[4]="Cantidad";
            columname[5]="Valor Venta";
            columname[6]="Descuento";
            columname[7]="IGV";            
            columname[8]="Total";
            columname[9]="Instancia";            
            mdo.setColumnIdentifiers(columname);
            detallecredito.setModel(mdo);
            detallecredito.getColumn("Producto").setPreferredWidth(200);
            detallecredito.getColumn("Producto").setMinWidth(200);
            detallecredito.getColumn("Producto").setWidth(200);
            detallecredito.getColumn("Producto").setMaxWidth(200);
//            detallecredito.getColumn("Instancia").setPreferredWidth(0);
//            detallecredito.getColumn("Instancia").setMinWidth(0);
//            detallecredito.getColumn("Instancia").setWidth(0);
//            detallecredito.getColumn("Instancia").setMaxWidth(0);
            detallecredito.getColumn("codigo").setPreferredWidth(0);
            detallecredito.getColumn("codigo").setMinWidth(0);
            detallecredito.getColumn("codigo").setWidth(0);
            detallecredito.getColumn("codigo").setMaxWidth(0);
            detallecredito.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            detallecredito.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);   }
    }
    private void setItemsDetalle() {
        Object [] rowData = new Object[10];
        DefaultTableModel _mod = (DefaultTableModel) detallecredito.getModel();
        _mod.setNumRows(0);
        try {
                for(int i=0;i<=_lsefacturadetalle.size()-1;i++)
                {
                    rowData[0]=""+(i+1);
                    rowData[1]=_lsefacturadetalle.get(i).getDfa_ncodigo();
                    rowData[2]=_lsefacturadetalle.get(i).getArt_cdescripcion();
                    rowData[3]=_lsefacturadetalle.get(i).getUni_cdescripcion();
                    rowData[4]=_lsefacturadetalle.get(i).getDfa_ccantidad();
                    rowData[5]=_lsefacturadetalle.get(i).getDfa_fvalorunitario();
                    rowData[6]=_lsefacturadetalle.get(i).getDfa_fdescuento();
                    rowData[7]=_lsefacturadetalle.get(i).getCategoria();
                    rowData[8]=_lsefacturadetalle.get(i).getDfa_fvalortotal();
                    rowData[9]=_lsefacturadetalle.get(i).getM_instancia();
                    _mod.addRow(rowData);
                }
        detallecredito.setModel(_mod);
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Cargando Detalle",JOptionPane.WARNING_MESSAGE);    }
    }
    private void ClearForm()
    {
        try
        {
            txtsearchserie.setText("");
            txtsearchnumero.setText("");
            txtdireccion.setText("");
            txtasunto.setText("");
            txtcliente.setText("");
            txtruc.setText("");
            cmbclase.setSelectedIndex(0);
            DefaultTableModel dtm = (DefaultTableModel) detallecredito.getModel();
            dtm.setNumRows(0);
            _ecliente=null;
        }
        catch(Exception e)
        {}
    }
    private boolean  ValidarBuscar()
    {
        try {
            if(txtsearchserie.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese una serie.","Buscar Factura.",JOptionPane.WARNING_MESSAGE);
                txtsearchserie.setFocusable(true);
                return false;
            }
            if(txtsearchnumero.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un numero.","Buscar Factura.",JOptionPane.WARNING_MESSAGE);
                txtsearchnumero.setFocusable(true);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    private void GetItem() {
        try {
            if(m_Tipoinstancia==InstanciaForm.NEW)
            {
                if(_efeactura!=null)
                {
                    _erelaciondocu = new ERelacionadoDocumento();
                    _erelaciondocu.setM_instancia(InstancaEntidad.NEW);
                    DisplayValue _valor=(DisplayValue)cmbdocumento.getSelectedItem();
                    _erelaciondocu.setDoc_ccodigo(_valor.getValueMenber());
                    _valor=(DisplayValue)cmbtiponota.getSelectedItem();
                    _erelaciondocu.setMtv_ccodigo(_valor.getValueMenber());
                    _erelaciondocu.setFac_ncodigo(_efeactura.getFac_ncodigo());
                    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    _erelaciondocu.setRel_dfechaemision(date);
                    _valor=((DisplayValue)cmbclase.getSelectedItem()); 
                    _erelaciondocu.setRel_clasepago(_valor.getValueMenber());
                    _erelaciondocu.setRel_figv(_efeactura.getFac_igv());
                    _erelaciondocu.setRel_fsubtotal(_efeactura.getFac_fimportesubtotal());
                    _erelaciondocu.setRel_ftotal(_efeactura.getFac_ftotal());
                    _erelaciondocu.setRel_ftotalexonerado(_efeactura.getFac_ftotalexonerado());
                    _erelaciondocu.setRel_ftotalinafecto(  _efeactura.getFac_ftotalinafecto());
                    _erelaciondocu.setRel_ftotalisc(_efeactura.getFac_ftotalisc());
                    _erelaciondocu.setRel_ftotalotrostributos(_efeactura.getFac_ftotalotrostributos());
                    _erelaciondocu.setRel_cdescripcion(txtasunto.getText());
                    _erelaciondocu.setRel_cmoneda(_efeactura.getMon_ccodigo());
                    _erelaciondocu.setSuc_ncodigo(_efeactura.getSuc_ncodigo());
                    _erelaciondocu.setRel_facserienumero(_efeactura.getFac_cserie()+"-"+_efeactura.getFac_cnumero());
                    //_erelaciondocu.setRel_cdescripcion(m_Codigo);
                    for(int i=0;i<=_lsefacturadetalle.size()-1;i++)
                    {
                        if(_lsefacturadetalle.get(i).getM_instancia()==InstancaEntidad.UNCHANGUE)
                        {
                            _erelaciondetalle= new ERelacionadoDocumentoDetalle();
                            _erelaciondetalle.setM_instancia(InstancaEntidad.NEW);
                            _erelaciondetalle.setArt_ncodigo(_lsefacturadetalle.get(i).getArt_ncodigo());
                            _erelaciondetalle.setRde_ccantidad(_lsefacturadetalle.get(i).getDfa_ccantidad());
                            _erelaciondetalle.setRde_fvalorunitario(_lsefacturadetalle.get(i).getDfa_fvalorunitario());
                            _erelaciondetalle.setRde_ctipoafectacion(_lsefacturadetalle.get(i).getPve_ctipoafectacion());
                            _erelaciondetalle.setRde_fvalorsubtotal(_lsefacturadetalle.get(i).getDfa_fvalorsubtotal());
                            _erelaciondetalle.setRde_fvalorventa(_lsefacturadetalle.get(i).getDfa_fvalorventa());
                            _erelaciondetalle.setUni_ncodigo(_lsefacturadetalle.get(i).getUni_ncodigo());
                            _erelaciondetalle.setRde_fdescuento(_lsefacturadetalle.get(i).getDfa_fdescuento());
                            _erelaciondetalle.setRde_fvaloritemigv(_lsefacturadetalle.get(i).getDfa_fvaloritemigv());
                            _erelaciondetalle.setRde_fvalortotal(_lsefacturadetalle.get(i).getDfa_fvalortotal());
                            _erelaciondetalle.setArt_cafectacion(_lsefacturadetalle.get(i).getArt_cafectacion());
                            _lsrelaciondocumento.add(_erelaciondetalle);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error getitem."+e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
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
                    m_escritorio.remove(frmagregarnota);
                    frmagregarnota=null;
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
            for (int i=0;i<=detallecredito.getRowCount()-1;i++ )
            {
                String d= detallecredito.getValueAt(i, 8).toString();
                double d1=Double.parseDouble(d);
                if(detallecredito.getValueAt(i, 7).toString().equals("Gravado"))
                {
                    sigv+=d1;
                    totaldescuento+=Double.parseDouble(detallecredito.getValueAt(i, 6).toString());
                }else
                    snoigv+=d1;
            }
            txtsubtotal.setText(""+(sigv+snoigv));
            txtdescuento.setText(String.valueOf(_fmd.Farmat2DosDecimales(totaldescuento)));
            txtvalorventa.setText(""+(sigv+snoigv));
            txtigv.setText(""+m_igv); //String.valueOf(m_igv*sigv/100)
            double totaligv=m_igv*sigv/100;
        }
        catch(Exception e)
        {
        }
    }
}

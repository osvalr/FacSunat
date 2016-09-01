
package Principal;
import AccessoDato.DAOCliente;
import AccessoDato.DAOTablasSolas;
import AccessoDato.ECliente;
import AccessoDato.EDireccion;
import AccessoDato.EDocumento;
import AccessoDato.EEmpresa;                                                                                                                                                                                                                                                                                                                       
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import AccessoDato.EParametro;
import AccessoDato.EPlaca;
import AccessoDato.EPrecioVenta;
import Negocio.BCliente;
import Negocio.BDireccion;
import Negocio.BEmpresa;
import Negocio.BFactura;
import Negocio.BParametro;
import Negocio.BPlaca;
import Negocio.BPrecioVenta;
import Utilidad.DisplayValue;
import Utilidad.Formato;
import Utilidad.GenerarXmml;
import Utilidad.InstancaEntidad;
import javax.swing.JOptionPane;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import Utilidad.OtrasEntidad;
import com.sun.javafx.scene.control.behavior.OptionalBoolean;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Optional;
import javax.swing.JTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
public class FrmFactura extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public String m_Codigo;
    private DAOTablasSolas _daootrasTablas;
    private OtrasEntidad _otrosTipos;
    private List<EDocumento> _lsdoc= new ArrayList<>();
    Vector _items=null;
    private DefaultComboBoxModel modelocmb=null;
    private DefaultComboBoxModel _modeloruc;
//    private DefaultComboBoxModel _modelonombrecliente;
    private DefaultComboBoxModel _modeloplaca;
    private DAOCliente _daocliente=null;
    private BPrecioVenta _beprecioventa=null;
    private EPrecioVenta _eprecioventa=null;
    private ECliente _ecliente=null;
    private double m_igv;
//    private List<EPrecioVenta> _lsprecioventa;
    private List<EFacturaDetalle> _lsdetallefac;
    private EFacturaDetalle _edetallefac;
    private EFactura _efactura;
    private BFactura _bfactura;
//    private BFacturaDetalle _bedetallefac;
    private GenerarXmml _generarxml;
    private BEmpresa _bempresa;
    private EEmpresa _empresa;
    private EParametro _parametro;
    private BParametro _bparametro;
    private Formato _fmd;
    private BPlaca _bplaca;
    private BCliente _bcliente;
    private BDireccion _bdireccion;
    private EDireccion _edireccion;
    private EPlaca _eplaca;
    public String m_CodigoDocumento="";
    
    private FrmFactura() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdetallefactura = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbclase = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        txtdescripcionfactura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddnuevocliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtdireccioncli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbdireccioncli = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdescripcionart = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcantidadaert = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbplaca = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbbuscarruc = new javax.swing.JComboBox<>();
        txtbuscartextocliente = new javax.swing.JTextField();
        btncambiardocumento = new javax.swing.JButton();
        lbnumerodocumento = new javax.swing.JLabel();
        txtnumerodocnuevo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtanticipios = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtvalorventa = new javax.swing.JTextField();
        txtisc = new javax.swing.JTextField();
        txtigv = new javax.swing.JTextField();
        txtcargos = new javax.swing.JTextField();
        txttributos = new javax.swing.JTextField();
        txtimportetotal = new javax.swing.JTextField();
        btnadditem = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Factura");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnlimpiar.setToolTipText("");
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

        btnBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\search.png")); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        tdetallefactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tdetallefactura);

        jLabel1.setText("Clase Pago");

        cmbclase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdocumentoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("(F1 Busqueda)");

        btnAddnuevocliente.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\adduser.png")); // NOI18N
        btnAddnuevocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddnuevoclienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Dirección");

        jLabel9.setText("Otras Direcciones");

        cmbdireccioncli.setEditable(true);
        cmbdireccioncli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("(F2 Busqueda)");

        jLabel7.setText("Producto");

        txtdescripcionart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionartKeyPressed(evt);
            }
        });

        jLabel8.setText("Cantidad");

        txtcantidadaert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadaertKeyTyped(evt);
            }
        });

        jLabel20.setText("Placa");

        cmbplaca.setEditable(true);
        cmbplaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbplacaActionPerformed(evt);
            }
        });

        jLabel21.setText("Numero Documento ");

        jLabel3.setText("Referencia");

        cmbbuscarruc.setEditable(true);
        cmbbuscarruc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbuscarruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbuscarrucActionPerformed(evt);
            }
        });

        txtbuscartextocliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscartextoclienteKeyPressed(evt);
            }
        });

        btncambiardocumento.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\cambiartipodocumento.png")); // NOI18N
        btncambiardocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiardocumentoActionPerformed(evt);
            }
        });

        lbnumerodocumento.setText("Numero Doc.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel10)
                                            .addGap(145, 145, 145))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cmbclase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(cmbbuscarruc, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnAddnuevocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btncambiardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(81, 81, 81)))
                                    .addComponent(jLabel1)
                                    .addComponent(txtdescripcionart, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbdocumento, 0, 190, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(115, 115, 115)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnumerodocnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumerodocumento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addComponent(txtbuscartextocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtcantidadaert, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel6)
                            .addComponent(cmbplaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdireccioncli)))
                    .addComponent(txtdescripcionfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbdireccioncli, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(lbnumerodocumento)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdireccioncli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbuscartextocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnumerodocnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbdireccioncli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbbuscarruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddnuevocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncambiardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidadaert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtdescripcionart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdescripcionfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtanticipios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtanticipios.setEnabled(false);

        txtdescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescuento.setEnabled(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Sub Total Ventas   :");

        jLabel12.setText("Descuentos  :");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Anticipios  :");

        txtsubtotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtsubtotal.setEnabled(false);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Valor de Venta  :");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("ISC  :");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("IGV  :");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Otros Cargos  :");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Otros Tributos  :");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Importe Total  :");

        txtvalorventa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtvalorventa.setEnabled(false);

        txtisc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtisc.setEnabled(false);

        txtigv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtigv.setEnabled(false);

        txtcargos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcargos.setEnabled(false);

        txttributos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txttributos.setEnabled(false);

        txtimportetotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtimportetotal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(640, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtanticipios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtisc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcargos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttributos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtimportetotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtanticipios, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtvalorventa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txtisc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcargos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttributos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtimportetotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnadditem.setText("Añadir");
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });

        btnquitar.setText("Quitar");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadditem)
                    .addComponent(btnquitar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadditem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnquitar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       
        try
        {
           // _parametro=_bparametro.AccionObtenerConfiguracion(6);//------------------------------------estatico 1
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
                if(m_Tipoinstancia==InstanciaForm.NEW)
                {      
                         GetItem();
                         GetDireccion();
                         GetPlaca();
                         GetCliente();
                         if(_efactura.getDoc_ccodigo().equals("01"))//-----------Caso que el documento sea FACTURA
                         {
                             if(_ecliente.getCli_ncodigo()==0)
                                 _ecliente.setCoi_ccodigo("6");//-----------------Documento tipo ruc por defecto
                         }
                         else//---------------------------------------------------Caso que el documento sea BOLETA
                         {
                             if(!m_CodigoDocumento.equals(""))
                                 _ecliente.setCoi_ccodigo(m_CodigoDocumento);//----Documento seleccionado
                             else
                                 _ecliente.setCoi_ccodigo("1");//------------------Documento Nacionalidad de identidad
                             
                         }
                             
                        _generarxml = new GenerarXmml();//----------------------------------------------Generar XML SUNAT
                        _empresa=_bempresa.ObtenerUno(_parametro.getPar_nsucursal());
                        _generarxml.setEempresa(_empresa);
                        _generarxml.setEcliente(_ecliente);
                        _efactura.setFac_cserie(_parametro.getPar_cserie());
                        int _incrementadonumero=(Integer.parseInt(_parametro.getPar_cnumero())+1);
                        _efactura.setFac_cnumero(String.valueOf(_incrementadonumero));
                        _efactura.setSuc_ncodigo(_parametro.getPar_nsucursal());
                        _efactura.setVe_ncodigo(_parametro.getPar_nvendedor());
                        _efactura.setMon_ccodigo(_parametro.getPar_cmoneda());
                        _generarxml.setEfactura(_efactura);
                        _generarxml.setLsdetfactura(_lsdetallefac);
                         if(_generarxml.FillXml())//_generarxml.LlenarXMltoEntity())
                        {   
//                            if(!_generarxml.Envio())
//                                JOptionPane.showMessageDialog(null, "ResponseCode :"+_generarxml.errResponseCode+ " Detalle :" +_generarxml.errDescription, "Respuesta Sunat.",JOptionPane.WARNING_MESSAGE);
//                            else
//                            {
                                JOptionPane.showMessageDialog(null, " Sunat :" +_generarxml.errDescription ,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
                                _efactura.setFac_cestado(_parametro.getPar_cestado());
                                if(_bfactura.AccionGuardarCompleto(_efactura,_lsdetallefac,_parametro.getNum_ncodigo(),_edireccion,_eplaca,_ecliente))
                                {
                                    JOptionPane.showMessageDialog(null, "Se guardado correctamente.", "Factura",JOptionPane.INFORMATION_MESSAGE);
                                }
//                            }
                        }
                        _lsdetallefac.clear();
                        m_Tipoinstancia=InstanciaForm.UNCHANGUE;   
                        ClearForm();
                        EstablecerInstancia();
                }
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Se encontro algunos Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try
        {
            FrmBuscar _buscar = new FrmBuscar(5,this);
            m_escritorio.add(_buscar); 
            _buscar.show(); 
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
         try
        {
                _bcliente = new BCliente();
                _bfactura = new BFactura();
                _fmd= new Formato();
                _bparametro = new BParametro();
                _bempresa = new BEmpresa();
                _lsdetallefac =new ArrayList<>();
                _daootrasTablas = new DAOTablasSolas();
                _lsdoc=_daootrasTablas.ObtenerDocumento();
                cmbdocumento.removeAllItems();
                _items = new Vector();
                for (int i=0;i<=_lsdoc.size()-1;i++)
                {
                    if(!_lsdoc.get(i).getDoc_ccodigo().equals("07")&&!_lsdoc.get(i).getDoc_ccodigo().equals("08"))
                    _items.addElement(new DisplayValue(_lsdoc.get(i).getDoc_cdescripcion(), _lsdoc.get(i).getDoc_ccodigo()));
                }
                modelocmb = new DefaultComboBoxModel(_items);
                cmbdocumento.setModel(modelocmb);
                _items = new Vector();
                _otrosTipos = new OtrasEntidad();
                for (int i=0;i<=_otrosTipos.TipoPago.length-1;i++)
                    _items.addElement(new DisplayValue(_otrosTipos.TipoPago[i][1], _otrosTipos.TipoPago[i][0]));
                modelocmb = new DefaultComboBoxModel(_items);
                cmbclase.setModel(modelocmb);
                cmbdireccioncli.removeAllItems();
                CargarformDetalle();
                m_igv=_daootrasTablas.Obtenerigv();
                txtigv.setText(String.valueOf(m_igv));
                cmbbuscarruc.removeAllItems();
//                DisplayValue _valor=(DisplayValue)cmbdocumento.getSelectedItem();
//                _modeloruc=_bcliente.AcctionFiltrarClientexTipoDocumento(cmbbuscarruc.getEditor().getItem().toString(),_valor.getValueMenber());
//                cmbbuscarruc.setModel(_modeloruc);
//                AutoCompleteDecorator.decorate(cmbbuscarruc);
                txtnumerodocnuevo.setVisible(false);
                EstablecerInstancia();
                txtcantidadaert.setDocument(new JTextFielCharLimit(MaximoCharacter.IntNumeroMaximoSimple));
                txtdireccioncli.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDireccion)));
                txtdescripcionfactura.setDocument(new JTextFielCharLimit((MaximoCharacter.StrdireccionSimple)));
                txtbuscartextocliente.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreCompletoSimple)));
                cmbplaca.removeAllItems();
                cmbdireccioncli.removeAllItems();
                // _parametro=_bparametro.AccionObtenerConfiguracion(6,_valorDocumento.getValueMenber());/////////////////////////////estatico 1
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se producjo un error inesperado :"+  e.getMessage());
        }
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
       try
        {
            
            if(ValidarAdd(txtcantidadaert.getText()))
            {
                DefaultTableModel _modeTable =(DefaultTableModel) tdetallefactura.getModel();
//                String valorIGV="";
                double _cantidadxitem=0;
                double _totaligv=0;
                if(_eprecioventa!=null)
                {    
                    
                    //double 
                    _edetallefac = new EFacturaDetalle();
                    _edetallefac.setM_instancia(InstancaEntidad.NEW);
                    _edetallefac.setArt_ncodigo(_eprecioventa.getArt_ncodigo());
                    _edetallefac.setDfa_ccantidad(Integer.parseInt(txtcantidadaert.getText()));
                    _edetallefac.setDfa_fvalorunitario(_fmd.Farmat2DosDecimales(_eprecioventa.getPve_fpreciounitario()));
                    _edetallefac.setDfa_cnumeroitem(""+(_modeTable.getRowCount()+1));
                    _edetallefac.setArt_cdescripcion(txtdescripcionart.getText());
                    _edetallefac.setArt_ncodarticulo(""+_eprecioventa.getArt_ncodigo());
                    _edetallefac.setPve_ctipoafectacion(Integer.parseInt(_eprecioventa.getPve_ctipoafectacion()));
                    _cantidadxitem=_eprecioventa.getPve_fpreciounitario()* Integer.parseInt(txtcantidadaert.getText());                        
                    _edetallefac.setDfa_fvalorsubtotal(_fmd.Farmat2DosDecimales(_cantidadxitem));
                    _edetallefac.setDfa_fvalorventa(_eprecioventa.getPve_fprecioventa());
                    _edetallefac.setUni_ncodigo(_eprecioventa.getUni_ccodigo());
                    if(_edetallefac.getDfa_ccantidad()>_eprecioventa.getPve_ncantidad())//-preguntamos si la cantidad es mayor a la cantidad descuento 
                    {
                        double totaldescuento=_edetallefac.getDfa_fvalorsubtotal()*(_eprecioventa.getPve_nporcentajedescuento()/100.00);
                        _edetallefac.setDfa_fdescuento(_fmd.Farmat2DosDecimales(totaldescuento));
                        _cantidadxitem=_cantidadxitem-_edetallefac.getDfa_fdescuento();
                    }
                    if(_eprecioventa.getArt_cafectacion().equals("01"))
                    {
                        
                        _edetallefac.setDfa_fvaloritemigv(_fmd.Farmat2DosDecimales(_eprecioventa.getPve_fpreciounitario()*(m_igv/100)));
                        _totaligv=_fmd.Farmat2DosDecimales(_cantidadxitem*(m_igv/100));
                        _edetallefac.setDfa_fvalortotal(_fmd.Farmat2DosDecimales(_cantidadxitem+_totaligv)); 
                    }
                    else if (_eprecioventa.getArt_cafectacion().equals("02") || _eprecioventa.getArt_cafectacion().equals("03"))
                    {        _edetallefac.setDfa_fvaloritemigv(0.0);
                            _edetallefac.setDfa_fvalortotal(_fmd.Farmat2DosDecimales(_cantidadxitem+0.0)); 
                    }
                    
                    _edetallefac.setArt_cafectacion(_eprecioventa.getArt_cafectacion());
                    _modeTable.addRow(new Object[] {""+(_modeTable.getRowCount()+1),_eprecioventa.getArt_ncodigo(),_eprecioventa.getArt_cdescripcion(),""+_eprecioventa.getUni_cdescripcion(),""+txtcantidadaert.getText(),""+_eprecioventa.getPve_fpreciounitario(),""+_edetallefac.getDfa_fdescuento(),_eprecioventa.getArt_cafecdescripcion(),""+ _fmd.Farmat2DosDecimales(_cantidadxitem),"NEW"});
                    _lsdetallefac.add(_edetallefac);
                    _eprecioventa=null;
                    txtcantidadaert.setText("");
                    txtdescripcionart.setText("");
                    CalcularTotales();
                }
                else
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto", "Mensaje",JOptionPane.WARNING_MESSAGE);
            }
            else
            {    JOptionPane.showMessageDialog(null, "La cantidad no es valido.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                 txtcantidadaert.setText("");
                 txtcantidadaert.setFocusable(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnadditemActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        try
        {
            int _filaselecionada = tdetallefactura.getSelectedRow();
            if(_filaselecionada>=0)
            {
                
                if(tdetallefactura.getValueAt(_filaselecionada, 9).toString().equals("NEW"))
                {
                    int indice=tdetallefactura.getSelectedRow();
                    String _codigoItem=tdetallefactura.getValueAt(indice, 0).toString();
                    String _codigoArticulo=tdetallefactura.getValueAt(indice, 1).toString();
                    for(int i=0;i<=_lsdetallefac.size()-1;i++)
                    {
                        if(_lsdetallefac.get(i).getArt_ncodarticulo().equals(_codigoArticulo)&&_lsdetallefac.get(i).getDfa_cnumeroitem().equals(_codigoItem))
                           _lsdetallefac.remove(i);
                        
                    }
                            
                }
                else if(tdetallefactura.getValueAt(_filaselecionada, 0).toString().equals("MODIFY")||tdetallefactura.getValueAt(_filaselecionada, 0).toString().equals("UNCHANGUE"))
                {
                    String _codigo= tdetallefactura.getValueAt(_filaselecionada, 0).toString();
                    for(int i=0;i<=_lsdetallefac.size()-1;i++)
                    {
                        _edetallefac=_lsdetallefac.get(i);
                        if(_edetallefac.getArt_ncodigo() ==Integer.parseInt(_codigo))
                        {
                            _edetallefac.setM_instancia(InstancaEntidad.DELETE);
                            _lsdetallefac.set(i, _edetallefac);
                        }
                    }
                }

                 ((DefaultTableModel)tdetallefactura.getModel()).removeRow(_filaselecionada);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Fila", "Mensaje",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void cmbdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdocumentoActionPerformed
        if(cmbdocumento.getSelectedIndex()>=0)
        {
             DisplayValue _valorDocumento=(DisplayValue)cmbdocumento.getSelectedItem();
             _parametro=_bparametro.AccionObtenerConfiguracion(6,_valorDocumento.getValueMenber());
             cmbbuscarruc.removeAllItems();
             _modeloruc=_bcliente.AcctionFiltrarClientexTipoDocumento(cmbbuscarruc.getEditor().getItem().toString(),_valorDocumento.getValueMenber());
             cmbbuscarruc.setModel(_modeloruc);
             if(_valorDocumento.getValueMenber().equals("01"))
                 txtnumerodocnuevo.setDocument(new JTextFielCharLimit((MaximoCharacter.DocuMaxCharRuc)));
             else
                 txtnumerodocnuevo.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDni)));
             txtdireccioncli.setText("");
             txtbuscartextocliente.setText("");
        }
    }//GEN-LAST:event_cmbdocumentoActionPerformed
    FrmCliente objCli;
    Dimension desktopSize; 
    Dimension Internal;
    private void btnAddnuevoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddnuevoclienteActionPerformed
            CambiarRegistrocliente();
    }//GEN-LAST:event_btnAddnuevoclienteActionPerformed

    private void txtcantidadaertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadaertKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadaertKeyTyped

    private void cmbbuscarrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbuscarrucActionPerformed
        if(cmbbuscarruc.getSelectedIndex()>=1)
        {
            DisplayValue _valor=(DisplayValue)cmbbuscarruc.getSelectedItem();
            if(!_valor.getValueMenber().equals("-1"))//_ecliente.getCli_ncodigo()!=null)
            {
                  m_Codigo=_valor.getValueMenber();
                  CargarCliente(OptionalBoolean.TRUE);
            }
        }
    }//GEN-LAST:event_cmbbuscarrucActionPerformed
    FrmTipoDocumento frmdocumento;
    private void btncambiardocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiardocumentoActionPerformed
        try {
                if(frmdocumento==null)
                {
                    frmdocumento = FrmTipoDocumento.getinstacia();
                    frmdocumento.setFrmfactura(this);
                    frmdocumento.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                    frmdocumento.m_escritorio=m_escritorio;
                    desktopSize = m_escritorio.getSize();
                    Internal = frmdocumento.getSize();
                    frmdocumento.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                    frmdocumento.setVisible(true);  
                    m_escritorio.add(frmdocumento);
                    frmdocumento.setSelected(true);
                }
                else
                {
                    frmdocumento.setFrmfactura(this);
                    desktopSize = m_escritorio.getSize();
                    Internal = frmdocumento.getSize();
                    frmdocumento.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                    frmdocumento.setVisible(true);
                    frmdocumento.setSelected(true); 
            }
        } catch (PropertyVetoException e) {        }
    }//GEN-LAST:event_btncambiardocumentoActionPerformed
    private void txtbuscartextoclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscartextoclienteKeyPressed
        try {
            if(evt.getKeyCode()==KeyEvent.VK_F1)
        {
            DisplayValue _valor=(DisplayValue)cmbdocumento.getSelectedItem();
            FrmBuscar _buscar=new FrmBuscar(11,this, _valor.getValueMenber().equals("01"));
            m_escritorio.add(_buscar);
            _buscar.show();
        }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);   }
    }//GEN-LAST:event_txtbuscartextoclienteKeyPressed
    private void txtdescripcionartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionartKeyPressed
        try {
            if(evt.getKeyCode()==KeyEvent.VK_F2)
            {
                FrmBuscar _objbuscararticulo = new FrmBuscar(4,this);
                m_escritorio.add(_objbuscararticulo);
                _objbuscararticulo.show();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtdescripcionartKeyPressed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
       m_Tipoinstancia=InstanciaForm.UNCHANGUE;       
       EstablecerInstancia();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void cmbplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbplacaActionPerformed
    public void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
                        btnGuardar.setEnabled(true);
                        btnNuevo.setEnabled(false);
                        btnBuscar.setEnabled(false);
                        cmbclase.setEnabled(true);
                        cmbdocumento.setEnabled(true);
                        txtdescripcionfactura.setEnabled(true);
                        btnquitar.setEnabled(true);
                        btnadditem.setEnabled(true);
                        txtdescripcionart.setEnabled(true);
                        txtcantidadaert.setEnabled(true);
                        tdetallefactura.setEnabled(true);
//                        cmbdireccioncli.setEnabled(true);
                        btnAddnuevocliente.setEnabled(true);
                        btncambiardocumento.setEnabled(true);
                        cmbplaca.setEnabled(true);
                        cmbbuscarruc.setEnabled(true);
                        txtbuscartextocliente.setEnabled(true);
                        cmbdireccioncli.setEnabled(true);
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnNuevo.setEnabled(false);
                        btnBuscar.setEnabled(false);
                        btnAddnuevocliente.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        cmbclase.setEnabled(false);
                        cmbdocumento.setEnabled(false);
                        txtdescripcionfactura.setEnabled(false);
                        txtdireccioncli.setEnabled(false);
                        btnquitar.setEnabled(false);
                        btnadditem.setEnabled(false);
                        txtdescripcionart.setEnabled(false);
                        txtcantidadaert.setEnabled(false);
                        tdetallefactura.setEnabled(false);
                        cmbdireccioncli.setEnabled(false);
                        btnAddnuevocliente.setEnabled(false);
                        txtdireccioncli.setEnabled(false);
                        cmbplaca.setEnabled(false);
                        cmbbuscarruc.setEnabled(false);
                        txtbuscartextocliente.setEnabled(false);
                        btncambiardocumento.setEnabled(false);
                        lbnumerodocumento.setVisible(false);
                        txtnumerodocnuevo.setVisible(false);
                        cmbdireccioncli.setEnabled(false);
                        break;
                        
                }
    }
    public void CargarCliente( OptionalBoolean flag)
    {        
        try
        {
            if(m_Tipoinstancia==InstanciaForm.NEW)
              _efactura= new EFactura();
            if(!"".equals(m_Codigo))
            {
                _daocliente = new DAOCliente();
                _ecliente=_daocliente.ObtenerUno(Integer.parseInt(m_Codigo));
                if(_ecliente!=null)
                {
                   if(flag.equals(false))
                   {
                       String _codigoCliente=(String.valueOf(_ecliente.getCli_ncodigo()));//DisplayValue _valor=(DisplayValue)_modeloruc.getElementAt(i);
                        for(int i=0;i<=_modeloruc.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)_modeloruc.getElementAt(i);
                            if(_codigoCliente.equals(_valor.getValueMenber()))
                            {
                                _modeloruc.setSelectedItem(_valor);
                                break;
                            }
                        }
                        cmbbuscarruc.setModel(_modeloruc);
                   }
                    txtbuscartextocliente.setText(_ecliente.getCli_crazon());
                    txtdireccioncli.setText(_ecliente.getCli_cdireccionfiscal());
                    ObtenerplacaCliente();
                    ObtenerDireccionCliente();
                }  
            }
        }
        catch(Exception e)
        {         JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);  }
    }
    public void CargarArticulo()
    {
        try
        {
            if(!"".equals(m_Codigo))
            {
                _beprecioventa = new BPrecioVenta();
                _eprecioventa=_beprecioventa.AccionObtenerxPrecio(Integer.parseInt(m_Codigo));
                if(_eprecioventa!=null)
                    txtdescripcionart.setText(_eprecioventa.getArt_cdescripcion());
            }
        }
        catch(Exception e)
        {         JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);  }
    }
    private void CargarformDetalle()
    {
        try
        {
            DefaultTableModel mdo = new DefaultTableModel()
            {//-----------------------------------------------------------------------DESABILITANDO COLUMNAS 
                boolean[] canEdit = new boolean[]{
                false,false,false,true,true,false,false,false,false,false
                };
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
            tdetallefactura.setModel(mdo);
            tdetallefactura.getColumn("Producto").setPreferredWidth(200);
            tdetallefactura.getColumn("Producto").setMinWidth(200);
            tdetallefactura.getColumn("Producto").setWidth(200);
            tdetallefactura.getColumn("Producto").setMaxWidth(200);
            tdetallefactura.getColumn("Instancia").setPreferredWidth(0);
            tdetallefactura.getColumn("Instancia").setMinWidth(0);
            tdetallefactura.getColumn("Instancia").setWidth(0);
            tdetallefactura.getColumn("Instancia").setMaxWidth(0);
            tdetallefactura.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tdetallefactura.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void CalcularTotales()
    {
        try
        {
            double sigv=0;
            double snoigv=0;
            double totaldescuento=0;
            for (int i=0;i<=tdetallefactura.getRowCount()-1;i++ )
            {
                String d= tdetallefactura.getValueAt(i, 8).toString();
                double d1=Double.parseDouble(d);
                if(tdetallefactura.getValueAt(i, 7).toString().equals("Gravado"))
                {
                    sigv+=d1;
                    totaldescuento+=Double.parseDouble(tdetallefactura.getValueAt(i, 6).toString());
                }else
                    snoigv+=d1;
                               
            }
            txtsubtotal.setText(""+(sigv+snoigv));
            txtanticipios.setText("0");
            txtdescuento.setText(String.valueOf(_fmd.Farmat2DosDecimales(totaldescuento)));
            txtvalorventa.setText(""+(sigv+snoigv));
            txtisc.setText("0");
            txtigv.setText(""+m_igv); //String.valueOf(m_igv*sigv/100)
            double totaligv=m_igv*sigv/100;
            txtcargos.setText("0");
            txttributos.setText("0");
            double impottetotal=Double.parseDouble(txtsubtotal.getText())+Double.parseDouble(txtanticipios.getText())+totaligv;
            txtimportetotal.setText(String.valueOf(_fmd.Farmat2DosDecimales(impottetotal)));
        }
        catch(Exception e)
        {
        }
    }
    private void ClearForm()
    {
        try
        {
            txtbuscartextocliente.setText("");
            txtnumerodocnuevo.setText("");
            txtdescripcionfactura.setText("");
            txtdescripcionart.setText("");
            txtdireccioncli.setText("");
            txtcantidadaert.setText("");
            cmbdocumento.setSelectedIndex(0);
            cmbclase.setSelectedIndex(0);
            DefaultTableModel dtm = (DefaultTableModel) tdetallefactura.getModel();
            dtm.setNumRows(0);
            txtnumerodocnuevo.setVisible(false);
            btnAddnuevocliente.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\adduser.png"));
            cmbplaca.getEditor().setItem("");
            cmbdireccioncli.getEditor().setItem("");
        }
        catch(Exception e)
        {}
    }
    private boolean validar()
    {
        if(txtdescripcionfactura.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripción.", "Mensaje",JOptionPane.WARNING_MESSAGE);
            cmbdocumento.setFocusable(true);
            return false;        
        }
        if(!txtnumerodocnuevo.isVisible())
        {
            if(_ecliente.getCli_ncodigo()==0){
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente.", "Mensaje",JOptionPane.WARNING_MESSAGE);
            return false;}
        }
        if(_lsdetallefac.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese un detalle.", "Mensaje",JOptionPane.WARNING_MESSAGE);
            txtdescripcionart.setFocusable(true);
            return false;
        }
        return true;
    }
    private void GetItem()
    {
        try
        {
                         if(txtnumerodocnuevo.isVisible())
                            _efactura = new EFactura();
                         
                         _efactura.setFac_cdescripcion(txtdescripcionfactura.getText());
                         _efactura.setLey_ncodigo(1);
                         java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                         _efactura.setFac_dfechaemision(date);
                          DisplayValue _valor = ((DisplayValue)cmbdocumento.getSelectedItem());            
                         _efactura.setDoc_ccodigo(_valor.getValueMenber());
                         _valor = ((DisplayValue)cmbclase.getSelectedItem());            
                         _efactura.setFac_cclasepago(_valor.getValueMenber());
                         double _totaligv=0;
                         double _subtotal=0;
                         double _netototal=0;
                         double _totalexonerada=0;
                         double _totalinafecta=0;
                         for (int i=0;i<=_lsdetallefac.size()-1;i++)
                         {
                             if(_lsdetallefac.get(i).getDfa_fdescuento()>0)
                                 _totaligv+=(_lsdetallefac.get(i).getDfa_fvalorsubtotal()*(m_igv/100));
                             else
                             _totaligv+=(_lsdetallefac.get(i).getDfa_fvaloritemigv()*_lsdetallefac.get(i).getDfa_ccantidad());
                             
                             switch (_lsdetallefac.get(i).getArt_cafectacion()) {
                                 case "01":
                                     _subtotal+=_lsdetallefac.get(i).getDfa_fvalorsubtotal();
                                     break;
                                 case "02":
                                     _totalexonerada+=_lsdetallefac.get(i).getDfa_fvalortotal();
                                     break;
                                 case "03":
                                     _totalinafecta+=_lsdetallefac.get(i).getDfa_fvalortotal();
                                     break;
                                 default:
                                     break;
                             }
                             _netototal+=_lsdetallefac.get(i).getDfa_fvalortotal();
                         }
                         _efactura.setFac_igv(_fmd.Farmat2DosDecimales(_totaligv));
                         _efactura.setFac_fimportesubtotal(_fmd.Farmat2DosDecimales(_subtotal));
                         _efactura.setFac_ftotal(_fmd.Farmat2DosDecimales(_netototal));
                         _efactura.setFac_ftotalexonerado(_totalexonerada);
                         _efactura.setFac_ftotalinafecto(_totalinafecta);
                         _efactura.setFac_ftotalisc(_fmd.Farmat2DosDecimales(Double.parseDouble(txtisc.getText()))); //--------------------------CARGANTO OTROS y ISC
                         _efactura.setFac_ftotalotrostributos(_fmd.Farmat2DosDecimales(Double.parseDouble(txttributos.getText())));

        }
        catch(Exception e)
        {    }
    }
    private boolean ValidarAdd(String x_valor)
    {
        if(x_valor.length()==0)
            return false;
        for (char c : x_valor.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    private void ObtenerplacaCliente()
    {
        try {
            if(!m_Codigo.equals(""))
            {
                cmbplaca.removeAllItems();
                _bplaca = new BPlaca();
                _modeloplaca=_bplaca.AccionObtenerPlacaxCliente(Integer.parseInt(m_Codigo));
                cmbplaca.setModel(_modeloplaca);
            }
        } catch (Exception e) {
        }
    }
    private void ObtenerDireccionCliente()
    {
        try {
            if(!m_Codigo.equals(""))
            {
                _bdireccion = new BDireccion();
                DefaultComboBoxModel modelodireccion=_bdireccion.AccionObtenerDireccionxClienteFacturacion(Integer.parseInt(m_Codigo));
                cmbdireccioncli.setModel(modelodireccion);
            }
        } catch (Exception e) {
        }
    }
    private static FrmFactura m_frmfactura;
    public static FrmFactura getinstancia()
    {
        if(m_frmfactura==null)
            m_frmfactura = new FrmFactura();
        return m_frmfactura;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddnuevocliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btncambiardocumento;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnquitar;
    private javax.swing.JComboBox<String> cmbbuscarruc;
    private javax.swing.JComboBox<String> cmbclase;
    private javax.swing.JComboBox<String> cmbdireccioncli;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JComboBox<String> cmbplaca;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbnumerodocumento;
    private javax.swing.JTable tdetallefactura;
    private javax.swing.JTextField txtanticipios;
    private javax.swing.JTextField txtbuscartextocliente;
    private javax.swing.JTextField txtcantidadaert;
    private javax.swing.JTextField txtcargos;
    private javax.swing.JTextField txtdescripcionart;
    private javax.swing.JTextField txtdescripcionfactura;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtdireccioncli;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtimportetotal;
    private javax.swing.JTextField txtisc;
    private javax.swing.JTextField txtnumerodocnuevo;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttributos;
    private javax.swing.JTextField txtvalorventa;
    // End of variables declaration//GEN-END:variables
    public String getM_CodigoDocumento() {
        return m_CodigoDocumento;
    }
    public void setM_CodigoDocumento(String m_CodigoDocumento) {
        this.m_CodigoDocumento = m_CodigoDocumento;
    }
    private void GetDireccion() {
        try {
            String _stritem=cmbdireccioncli.getEditor().getItem().toString();
            if(cmbdireccioncli.getSelectedIndex()==-1)
            {
                if(_stritem.length()>0)
                {
                    _edireccion = new EDireccion();
                    _edireccion.setM_Instancia(InstancaEntidad.NEW);
                    _edireccion.setDir_cdescripcion(_stritem);
                }
            }
            else
            {
                if(_ecliente.getCli_ncodigo()!=0)
                {
                    _edireccion = new EDireccion();
                    _edireccion.setM_Instancia(InstancaEntidad.UNCHANGUE);
                    _edireccion.setDir_cdescripcion(_stritem);
                    _edireccion.setCli_ncodigo(_ecliente.getCli_ncodigo());
                }
            }
        } catch (Exception e) {
        }
    }
    private void GetPlaca() {
        try {
            if(cmbplaca.getSelectedIndex()==-1)
            {
                String _stritem=cmbplaca.getEditor().getItem().toString();
                if(_stritem.length()>0)
                {
                    _eplaca = new EPlaca();
                    _eplaca.setM_instancia(InstancaEntidad.NEW);
                    _eplaca.setPla_cnombre(_stritem);
                }else
                    _eplaca=null;
            }
            else{
                _eplaca=new EPlaca();
                if(_ecliente.getCli_ncodigo()!=0)
                {
                    DisplayValue displaplaca=(DisplayValue)cmbplaca.getSelectedItem();
                    _eplaca.setM_instancia(InstancaEntidad.UNCHANGUE);
                    _eplaca.setPla_ncodigo(Integer.parseInt(displaplaca.getValueMenber()));
                    _eplaca.setCli_ncodigo(_ecliente.getCli_ncodigo());
                }
            }
            
        } catch (Exception e) {     }
    }
    private void GetCliente()
    {
        try {
            if(_ecliente==null)
            {
                _ecliente= new ECliente();
                _ecliente.setCli_cdireccionfiscal(txtdireccioncli.getText());
                _ecliente.setCli_cnumerodoc(txtnumerodocnuevo.getText());
                _ecliente.setCli_crazon(txtbuscartextocliente.getText());
                if(txtnumerodocnuevo.isVisible())
                    _ecliente.setCli_ncodigo(0);
            }
            
        } catch (Exception e) {
        }
    }
    private void CambiarRegistrocliente()
    {
        try {
                if(!txtnumerodocnuevo.isVisible())
                {
                    btnAddnuevocliente.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\limpiarclientenuevo.png"));
                    txtdireccioncli.setEnabled(true);
                    txtnumerodocnuevo.setVisible(true);
                    txtnumerodocnuevo.setEnabled(true);
                    lbnumerodocumento.setVisible(true);
                    cmbbuscarruc.setEnabled(false);
                    txtnumerodocnuevo.setText("");
                    txtdireccioncli.setText("");
                    txtbuscartextocliente.setText("");
                }
                else if(txtnumerodocnuevo.isVisible())
                {
                    btnAddnuevocliente.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\adduser.png"));
                    txtdireccioncli.setEnabled(false);
                    txtnumerodocnuevo.setVisible(false);
                    txtnumerodocnuevo.setEnabled(false);
                    lbnumerodocumento.setVisible(false);
                    cmbbuscarruc.setEnabled(true);
                    txtnumerodocnuevo.setText("");
                    txtdireccioncli.setText("");
                    txtbuscartextocliente.setText("");
                }
        } catch (Exception e) {
        }
    }
}

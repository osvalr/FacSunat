
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
import Utilidad.InstanciaEntidad;
import javax.swing.JOptionPane;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import Utilidad.OtrasEntidad;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.javafx.scene.control.behavior.OptionalBoolean;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import javax.swing.JTable;
public class FrmFactura extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public String m_Codigo;
    private DAOTablasSolas _daootrasTablas;
    private OtrasEntidad _otrosTipos;
    private List<EDocumento> _lsdoc= new ArrayList<>();
    Vector _items=null;
    private DefaultComboBoxModel modelocmb=null;
//    private DefaultComboBoxModel _modeloruc;
//    private DefaultComboBoxModel _modeloplaca;
    private DAOCliente _daocliente=null;
    private BPrecioVenta _beprecioventa=null;
    private EPrecioVenta _eprecioventa=null;
    private ECliente ecliente=null;
    private double m_igv;
    private List<EFacturaDetalle> listaDetalleFactura;
    private EFacturaDetalle eDetalleFactura;
    private EFactura eFactura;
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
    private EPlaca eplaca;
    private List<DisplayValue> listaDisplay = new ArrayList<>();
    public String m_CodigoDocumento="";
    public List<ECliente> listaCliente; 
    int idCliente;
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
        jLabel6 = new javax.swing.JLabel();
        txtdireccioncli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdescripcionart = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcantidadaert = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarClientexNombre = new javax.swing.JTextField();
        txtBuscarClientexRuc = new javax.swing.JTextField();
        txtBuscarPlaca = new javax.swing.JTextField();
        txtBuscarDireccionSecundaria = new javax.swing.JTextField();
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
                formInternalFrameActivated(evt);
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

        btnlimpiar.setIcon(new javax.swing.ImageIcon("D:\\FE\\FacturaElectronica-24-06-2016\\img\\limpiar.png")); // NOI18N
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

        jLabel6.setText("Dirección");

        jLabel9.setText("Otras Direcciones");

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

        jLabel21.setText("Numero Documento ");

        jLabel3.setText("Nota");

        txtBuscarClientexNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarClientexNombreKeyPressed(evt);
            }
        });

        txtBuscarClientexRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarClientexRucKeyPressed(evt);
            }
        });

        txtBuscarPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPlacaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdescripcionfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBuscarClientexRuc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbclase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtdescripcionart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel21)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarClientexNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcantidadaert, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel20))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(txtdireccioncli, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .addComponent(txtBuscarDireccionSecundaria))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(cmbclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdireccioncli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarClientexRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarClientexNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8)
                                .addComponent(jLabel20)))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcionart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidadaert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarDireccionSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(611, Short.MAX_VALUE)
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnadditem)
                            .addComponent(btnquitar))
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
//                         GetDireccion();
                         GetPlaca();
                         //GetCliente();
//                         if(_efactura.getDoc_ccodigo().equals("01"))//-----------Caso que el documento sea FACTURA
//                         {
//                             if(ecliente.getCli_ncodigo()==0)
//                                 ecliente.setCoi_ccodigo("6");//-----------------Documento tipo ruc por defecto
//                         }
//                         else//---------------------------------------------------Caso que el documento sea BOLETA
//                         {
//                             if(!m_CodigoDocumento.equals(""))
//                                 ecliente.setCoi_ccodigo(m_CodigoDocumento);//----Documento seleccionado
//                             else
//                                 ecliente.setCoi_ccodigo("1");//------------------Documento Nacionalidad de identidad
//                             
//                         }
                             
                        _generarxml = new GenerarXmml();//----------------------------------------------Generar XML SUNAT
                        _empresa=_bempresa.ObtenerUno(_parametro.getPar_nsucursal());
                        _generarxml.setEempresa(_empresa);
                        _generarxml.setEcliente(ecliente);
                        eFactura.setFac_cserie(_parametro.getPar_cserie());
                        int _incrementadonumero=(Integer.parseInt(_parametro.getPar_cnumero())+1);
                        eFactura.setFac_cnumero(String.valueOf(_incrementadonumero));
                        eFactura.setSuc_ncodigo(_parametro.getPar_nsucursal());
                        eFactura.setVe_ncodigo(_parametro.getPar_nvendedor());
                        eFactura.setMon_ccodigo(_parametro.getPar_cmoneda());
                        _generarxml.setEfactura(eFactura);
                        _generarxml.setLsdetfactura(listaDetalleFactura);
                         if(_generarxml.FillXml())//_generarxml.LlenarXMltoEntity())
                        {   
                            if(!_generarxml.Envio())
                            {    JOptionPane.showMessageDialog(null, "ResponseCode :"+_generarxml.errResponseCode+ " Detalle :" +_generarxml.errDescription, "Respuesta Sunat.",JOptionPane.WARNING_MESSAGE);
                                                           
                                         
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, " Sunat :" +_generarxml.errDescription ,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
                                eFactura.setFac_cestado(_parametro.getPar_cestado());
                                if(_bfactura.AccionGuardarCompleto(eFactura,listaDetalleFactura,_parametro.getNum_ncodigo(),_edireccion,eplaca,ecliente))
                                {
//                                    valorResumenFirma _fima= new valorResumenFirma();
//                                    _fima.setRutaxml(_generarxml.rutaXmlCompleta);
                                    JOptionPane.showMessageDialog(null, "Se guardado correctamente ");
                                    //JOptionPane.showMessageDialog(null, "Se guardado correctamente :"+_generarxml.errDescription, "Factura",JOptionPane.INFORMATION_MESSAGE);
                                   // leerNodoXml lectura = new leerNodoXml();
//                                    lectura.setValorNodos(_fima);
                                    //lectura.buscarNodo("ds:DigestValue","ds:SignatureValue");
//                                    int tipoDocumento;
//                                    if(_efactura.getDoc_ccodigo().equals("01"))
//                                        tipoDocumento=1;
//                                    else
//                                        tipoDocumento=2;
                                    //ImprimirDocumento obj=new ImprimirDocumento(lectura.getValorNodo(),tipoDocumento, _efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero(),_efactura.getFac_ncodigo());
                                    
                                
                                }
                            }
                        }
                        listaDetalleFactura.clear();
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
                listaDetalleFactura =new ArrayList<>();
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
                CargarformDetalle();
                m_igv=_daootrasTablas.Obtenerigv();
                txtigv.setText(String.valueOf(m_igv));
                EstablecerInstancia();
                txtcantidadaert.setDocument(new JTextFielCharLimit(MaximoCharacter.IntNumeroMaximoSimple));
                txtdireccioncli.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDireccion)));
                txtdescripcionfactura.setDocument(new JTextFielCharLimit((MaximoCharacter.StrdireccionSimple)));
                txtBuscarClientexNombre.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreCompletoSimple)));
                listaCliente =_bcliente.ObtenerTodos();
                txtBuscarPlaca.setDocument(new JTextFielCharLimit(MaximoCharacter.StrPlacaSimple));
                
                txtdescripcionfactura.addFocusListener(new FocusListener(){
                    @Override
                    public void focusGained(FocusEvent e) {
                        //JOptionPane.showMessageDialog(rootPane, "Recibio el foco.");
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        
                         JOptionPane.showMessageDialog(rootPane, "Fin foco.");
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                });
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
                    eDetalleFactura = new EFacturaDetalle();
                    eDetalleFactura.setM_instancia(InstanciaEntidad.NEW);
                    eDetalleFactura.setArt_ncodigo(_eprecioventa.getArt_ncodigo());
                    eDetalleFactura.setDfa_ccantidad(Integer.parseInt(txtcantidadaert.getText()));
                    eDetalleFactura.setDfa_fvalorunitario(_fmd.Farmat2DosDecimales(_eprecioventa.getPve_fpreciounitario()));
                    eDetalleFactura.setDfa_cnumeroitem(""+(_modeTable.getRowCount()+1));
                    eDetalleFactura.setArt_cdescripcion(txtdescripcionart.getText());
                    eDetalleFactura.setArt_ncodarticulo(""+_eprecioventa.getArt_ncodigo());
                    eDetalleFactura.setPve_ctipoafectacion(Integer.parseInt(_eprecioventa.getPve_ctipoafectacion()));
                    _cantidadxitem=_eprecioventa.getPve_fpreciounitario()* Integer.parseInt(txtcantidadaert.getText());                        
                    eDetalleFactura.setDfa_fvalorsubtotal(_fmd.Farmat2DosDecimales(_cantidadxitem));
                    eDetalleFactura.setDfa_fvalorventa(_eprecioventa.getPve_fprecioventa());
                    eDetalleFactura.setUni_ncodigo(_eprecioventa.getUni_ccodigo());
                    if(eDetalleFactura.getDfa_ccantidad()>_eprecioventa.getPve_ncantidad())//-preguntamos si la cantidad es mayor a la cantidad descuento 
                    {
                        double totaldescuento=eDetalleFactura.getDfa_fvalorsubtotal()*(_eprecioventa.getPve_nporcentajedescuento()/100.00);
                        eDetalleFactura.setDfa_fdescuento(_fmd.Farmat2DosDecimales(totaldescuento));
                        _cantidadxitem=_cantidadxitem-eDetalleFactura.getDfa_fdescuento();
                    }
                    if(_eprecioventa.getArt_cafectacion().equals("01"))
                    {
                        
                        eDetalleFactura.setDfa_fvaloritemigv(_fmd.Farmat2DosDecimales(_eprecioventa.getPve_fpreciounitario()*(m_igv/100)));
                        _totaligv=_fmd.Farmat2DosDecimales(_cantidadxitem*(m_igv/100));
                        eDetalleFactura.setDfa_fvalortotal(_fmd.Farmat2DosDecimales(_cantidadxitem+_totaligv)); 
                    }
                    else if (_eprecioventa.getArt_cafectacion().equals("02") || _eprecioventa.getArt_cafectacion().equals("03"))
                    {        eDetalleFactura.setDfa_fvaloritemigv(0.0);
                            eDetalleFactura.setDfa_fvalortotal(_fmd.Farmat2DosDecimales(_cantidadxitem+0.0)); 
                    }
                    
                    eDetalleFactura.setArt_cafectacion(_eprecioventa.getArt_cafectacion());
                    _modeTable.addRow(new Object[] {""+(_modeTable.getRowCount()+1),_eprecioventa.getArt_ncodigo(),_eprecioventa.getArt_cdescripcion(),""+_eprecioventa.getUni_cdescripcion(),""+txtcantidadaert.getText(),""+_eprecioventa.getPve_fpreciounitario(),""+eDetalleFactura.getDfa_fdescuento(),_eprecioventa.getArt_cafecdescripcion(),""+ _fmd.Farmat2DosDecimales(_cantidadxitem),"NEW"});
                    listaDetalleFactura.add(eDetalleFactura);
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
                    for(int i=0;i<=listaDetalleFactura.size()-1;i++)
                    {
                        if(listaDetalleFactura.get(i).getArt_ncodarticulo().equals(_codigoArticulo)&&listaDetalleFactura.get(i).getDfa_cnumeroitem().equals(_codigoItem))
                           listaDetalleFactura.remove(i);
                        
                    }
                            
                }
                else if(tdetallefactura.getValueAt(_filaselecionada, 0).toString().equals("MODIFY")||tdetallefactura.getValueAt(_filaselecionada, 0).toString().equals("UNCHANGUE"))
                {
                    String _codigo= tdetallefactura.getValueAt(_filaselecionada, 0).toString();
                    for(int i=0;i<=listaDetalleFactura.size()-1;i++)
                    {
                        eDetalleFactura=listaDetalleFactura.get(i);
                        if(eDetalleFactura.getArt_ncodigo() ==Integer.parseInt(_codigo))
                        {
                            eDetalleFactura.setM_instancia(InstanciaEntidad.DELETE);
                            listaDetalleFactura.set(i, eDetalleFactura);
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
             if(_valorDocumento.getValueMenber().equals("01"))
                 txtBuscarClientexRuc.setDocument(new JTextFielCharLimit((MaximoCharacter.DocuMaxCharRuc)));
             else
                 txtBuscarClientexRuc.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDni)));
             txtdireccioncli.setText("");
             txtBuscarClientexNombre.setText("");
        }
    }//GEN-LAST:event_cmbdocumentoActionPerformed
    FrmCliente objCli;
    Dimension desktopSize; 
    Dimension Internal;
    private void txtcantidadaertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadaertKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadaertKeyTyped
    //FrmTipoDocumento frmdocumento;
    private void txtBuscarClientexNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClientexNombreKeyPressed
        try {
            if(evt.getKeyCode()==KeyEvent.VK_F1)
        {
            DisplayValue _valor=(DisplayValue)cmbdocumento.getSelectedItem();
            FrmBuscar _buscar=new FrmBuscar(11,this, _valor.getValueMenber().equals("01"));
            m_escritorio.add(_buscar);
            _buscar.show();
        }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);   }
    }//GEN-LAST:event_txtBuscarClientexNombreKeyPressed
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

    private void txtBuscarClientexRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClientexRucKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String numeroDocumento=txtBuscarClientexRuc.getText();
            DisplayValue _valor=(DisplayValue) cmbdocumento.getSelectedItem();
            boolean _estadoRegistro=_valor.getValueMenber().equals("01");
            if(listaCliente.stream().filter(c-> c.getCli_cnumerodoc().equals(numeroDocumento)).count()==0)
            {
                int dialogButton=JOptionPane.showConfirmDialog (null, "No se encontro ningun resultado. Desea Crear un nuevo Cliente.","Agregar Cliente",JOptionPane.YES_NO_OPTION);

                if(dialogButton == JOptionPane.YES_OPTION)
                { 
                    FrmAgregarClienteRapido _addCliente = new FrmAgregarClienteRapido(_estadoRegistro);
                    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (int) ((dimension.getWidth() - _addCliente.getWidth()) / 2);
                    int y = (int) ((dimension.getHeight() - _addCliente.getHeight()) / 2);
                    _addCliente.setLocation(x, y);
                    _addCliente.setModal(true);
                    _addCliente.setVisible(true);
                    idCliente=_addCliente.idCliente;
                    if(idCliente!=0)
                    {
                        listaCliente = _bcliente.ObtenerTodos();
                        ecliente =listaCliente.stream().filter(f->f.getCli_ncodigo()==idCliente).findFirst().orElse(null);
                        CargarCliente(OptionalBoolean.FALSE);
                    }
                }
                else
                {
                    //ecliente= listaCliente.stream().filter(f->f.getCli_cnumerodoc()==numeroDocumento).findFirst().orElse(null);
                }
                
            }else
            {
                 ecliente= listaCliente.stream().filter(f->f.getCli_cnumerodoc().equals(numeroDocumento)).findFirst().orElse(null);
                 CargarCliente(OptionalBoolean.FALSE);
                 CargarPlacaCliente();
            }
        }
    }//GEN-LAST:event_txtBuscarClientexRucKeyPressed

    private void txtBuscarPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPlacaKeyReleased
        
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String nombrePlaca=txtBuscarPlaca.getText();
            if(listaDisplay.stream().filter(c-> c.toString().equals(nombrePlaca)).count()==0)
            {
                int dialogButton=JOptionPane.showConfirmDialog (null, "No se encontro ningun resultado. Desea Crear una nueva Placa.","Agregar Placa",JOptionPane.YES_NO_OPTION);

                if(dialogButton == JOptionPane.YES_OPTION)
                { 
                    eplaca = new EPlaca();
                    eplaca.setM_instancia(InstanciaEntidad.NEW);
                    eplaca.setPla_cnombre(txtBuscarPlaca.getText());
                    eplaca.setCli_ncodigo(ecliente.getCli_ncodigo());
                }
                else
                {
                }
                
            }else
            {
                 DisplayValue _elemento= listaDisplay.stream().filter(f->f.toString().equals(nombrePlaca)).findFirst().orElse(null);
                 if(_elemento!=null)
                 {
                     _bplaca = new BPlaca();
                     eplaca= _bplaca.AcctionObtenerUnaPlacaxId(Integer.parseInt((_elemento.getValueMenber())));
                 }
                 
            }
        }
    }//GEN-LAST:event_txtBuscarPlacaKeyReleased

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       try
        {
//                _bcliente = new BCliente();
//                _bfactura = new BFactura();
//                _fmd= new Formato();
//                _bparametro = new BParametro();
//                _bempresa = new BEmpresa();
//                listaDetalleFactura =new ArrayList<>();
//                _daootrasTablas = new DAOTablasSolas();
//                _lsdoc=_daootrasTablas.ObtenerDocumento();
//                cmbdocumento.removeAllItems();
//                _items = new Vector();
//                for (int i=0;i<=_lsdoc.size()-1;i++)
//                {
//                    if(!_lsdoc.get(i).getDoc_ccodigo().equals("07")&&!_lsdoc.get(i).getDoc_ccodigo().equals("08"))
//                    _items.addElement(new DisplayValue(_lsdoc.get(i).getDoc_cdescripcion(), _lsdoc.get(i).getDoc_ccodigo()));
//                }
//                modelocmb = new DefaultComboBoxModel(_items);
//                cmbdocumento.setModel(modelocmb);
//                _items = new Vector();
//                _otrosTipos = new OtrasEntidad();
//                for (int i=0;i<=_otrosTipos.TipoPago.length-1;i++)
//                    _items.addElement(new DisplayValue(_otrosTipos.TipoPago[i][1], _otrosTipos.TipoPago[i][0]));
//                modelocmb = new DefaultComboBoxModel(_items);
//                cmbclase.setModel(modelocmb);
//                CargarformDetalle();
//                m_igv=_daootrasTablas.Obtenerigv();
//                txtigv.setText(String.valueOf(m_igv));
//                EstablecerInstancia();
//                txtcantidadaert.setDocument(new JTextFielCharLimit(MaximoCharacter.IntNumeroMaximoSimple));
//                txtdireccioncli.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDireccion)));
//                txtdescripcionfactura.setDocument(new JTextFielCharLimit((MaximoCharacter.StrdireccionSimple)));
//                txtBuscarClientexNombre.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreCompletoSimple)));
//                listaCliente =_bcliente.ObtenerTodos();
//                txtBuscarPlaca.setDocument(new JTextFielCharLimit(MaximoCharacter.StrPlacaSimple));
//                
//                txtdescripcionfactura.addFocusListener(new FocusListener(){
//                    @Override
//                    public void focusGained(FocusEvent e) {
//                       // JOptionPane.showMessageDialog(rootPane, "Recibio el foco.");
//                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//
//                    @Override
//                    public void focusLost(FocusEvent e) {
//                        
//                         JOptionPane.showMessageDialog(rootPane, "Recibio el foco.");
//                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//                    
//                });
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se producjo un error inesperado :"+  e.getMessage());
        }
    }//GEN-LAST:event_formInternalFrameActivated
    TextAutoCompleter textAutoAcompleter;
    public void CargarPlacaCliente()
    {
        _bplaca = new BPlaca();
        listaDisplay=_bplaca.AccionObtenerListaPlacasxIdCliente(ecliente.getCli_ncodigo());
        if(listaDisplay.size()>0)
        {
            textAutoAcompleter = new TextAutoCompleter( txtBuscarPlaca );
            textAutoAcompleter.addItems(listaDisplay.toArray());
            
        }
        
    }
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
                        txtBuscarClientexNombre.setEnabled(true);
                        txtBuscarPlaca.setEnabled(true);
                        txtBuscarClientexRuc.setEnabled(true);
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnNuevo.setEnabled(false);
                        btnBuscar.setEnabled(false);
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
                        txtdireccioncli.setEnabled(false);
                        txtBuscarClientexNombre.setEnabled(false);
                        txtBuscarPlaca.setEnabled(false);
                        txtBuscarClientexRuc.setEnabled(false);
                        break;
                        
                }
    }
    public void CargarCliente( OptionalBoolean flag)
    {        
//        try
//        {
//            if(m_Tipoinstancia==InstanciaForm.NEW)
//              _efactura= new EFactura();
//            if(!"".equals(m_Codigo))
//            {
//                _daocliente = new DAOCliente();
//                ecliente=_daocliente.ObtenerUno(Integer.parseInt(m_Codigo));
//                if(ecliente!=null)
//                {
//                   if(flag.equals(false))
//                   {
//                       String _codigoCliente=(String.valueOf(ecliente.getCli_ncodigo()));//DisplayValue _valor=(DisplayValue)_modeloruc.getElementAt(i);
//                        for(int i=0;i<=_modeloruc.getSize()-1;i++)
//                        {
//                            DisplayValue _valor=(DisplayValue)_modeloruc.getElementAt(i);
//                            if(_codigoCliente.equals(_valor.getValueMenber()))
//                            {
//                                _modeloruc.setSelectedItem(_valor);
//                                break;
//                            }
//                        }
//                        cmbbuscarruc.setModel(_modeloruc);
//                   }
                    txtBuscarClientexNombre.setText(ecliente.getCli_crazon());
                    txtdireccioncli.setText(ecliente.getCli_cdireccionfiscal());
                   // ObtenerplacaCliente();
                  //  ObtenerDireccionCliente();
//                }  
//            }
//        }
//        catch(Exception e)
//        {         JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);  }
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
            txtBuscarClientexNombre.setText("");
            txtdescripcionfactura.setText("");
            txtdescripcionart.setText("");
            txtdireccioncli.setText("");
            txtcantidadaert.setText("");
            txtBuscarPlaca.setText("");
            txtBuscarDireccionSecundaria.setText("");
            cmbdocumento.setSelectedIndex(0);
            cmbclase.setSelectedIndex(0);
            DefaultTableModel dtm = (DefaultTableModel) tdetallefactura.getModel();
            dtm.setNumRows(0);
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
        if(listaDetalleFactura.isEmpty())
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
                        eFactura = new EFactura();
                        eFactura.setCli_ncodigo(ecliente.getCli_ncodigo());
                        eFactura.setFac_cdescripcion(txtdescripcionfactura.getText());
                        eFactura.setLey_ncodigo(1);
                        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                        eFactura.setFac_dfechaemision(date);
                         DisplayValue _valor = ((DisplayValue)cmbdocumento.getSelectedItem());            
                        eFactura.setDoc_ccodigo(_valor.getValueMenber());
                        _valor = ((DisplayValue)cmbclase.getSelectedItem());            
                        eFactura.setFac_cclasepago(_valor.getValueMenber());
                        double _totaligv=0;
                        double _subtotal=0;
                        double _netototal=0;
                        double _totalexonerada=0;
                        double _totalinafecta=0;
                        for (int i=0;i<=listaDetalleFactura.size()-1;i++)
                        {
                             if(listaDetalleFactura.get(i).getDfa_fdescuento()>0)
                                 _totaligv+=(listaDetalleFactura.get(i).getDfa_fvalorsubtotal()*(m_igv/100));
                             else
                             _totaligv+=(listaDetalleFactura.get(i).getDfa_fvaloritemigv()*listaDetalleFactura.get(i).getDfa_ccantidad());
                             
                             switch (listaDetalleFactura.get(i).getArt_cafectacion()) {
                                 case "01":
                                     _subtotal+=listaDetalleFactura.get(i).getDfa_fvalorsubtotal();
                                     break;
                                 case "02":
                                     _totalexonerada+=listaDetalleFactura.get(i).getDfa_fvalortotal();
                                     break;
                                 case "03":
                                     _totalinafecta+=listaDetalleFactura.get(i).getDfa_fvalortotal();
                                     break;
                                 default:
                                     break;
                             }
                             _netototal+=listaDetalleFactura.get(i).getDfa_fvalortotal();
                        }
                        eFactura.setFac_igv(_fmd.Farmat2DosDecimales(_totaligv));
                        eFactura.setFac_fimportesubtotal(_fmd.Farmat2DosDecimales(_subtotal));
                        eFactura.setFac_ftotal(_fmd.Farmat2DosDecimales(_netototal));
                        eFactura.setFac_ftotalexonerado(_totalexonerada);
                        eFactura.setFac_ftotalinafecto(_totalinafecta);
                        eFactura.setFac_ftotalisc(_fmd.Farmat2DosDecimales(Double.parseDouble(txtisc.getText()))); //--------------------------CARGANTO OTROS y ISC
                        eFactura.setFac_ftotalotrostributos(_fmd.Farmat2DosDecimales(Double.parseDouble(txttributos.getText())));
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
    private static FrmFactura m_frmfactura;
    public static FrmFactura getinstancia()
    {
        if(m_frmfactura==null)
            m_frmfactura = new FrmFactura();
        return m_frmfactura;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnquitar;
    private javax.swing.JComboBox<String> cmbclase;
    private javax.swing.JComboBox<String> cmbdocumento;
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
    private javax.swing.JTable tdetallefactura;
    private javax.swing.JTextField txtBuscarClientexNombre;
    private javax.swing.JTextField txtBuscarClientexRuc;
    private javax.swing.JTextField txtBuscarDireccionSecundaria;
    private javax.swing.JTextField txtBuscarPlaca;
    private javax.swing.JTextField txtanticipios;
    private javax.swing.JTextField txtcantidadaert;
    private javax.swing.JTextField txtcargos;
    private javax.swing.JTextField txtdescripcionart;
    private javax.swing.JTextField txtdescripcionfactura;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtdireccioncli;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtimportetotal;
    private javax.swing.JTextField txtisc;
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
           
        } catch (Exception e) {
        }
    }
    private void GetPlaca() {
        try {
            
            if(eplaca==null)
            {
                
            }
            else
            {
                if(eplaca.getM_instancia()==InstanciaEntidad.UNCHANGUE)
                    eFactura.setPla_ncodigo(eplaca.getPla_ncodigo());
                else if(eplaca.getM_instancia()==InstanciaEntidad.NEW)
                    eplaca.setCli_ncodigo(ecliente.getCli_ncodigo());
            }
        } catch (Exception e) {     }
    }
    private void GetCliente()
    {
        try {
            if(ecliente==null)
            {
                ecliente= new ECliente();
                ecliente.setCli_cdireccionfiscal(txtdireccioncli.getText());
                ecliente.setCli_crazon(txtBuscarClientexNombre.getText());
            }
        } catch (Exception e) {
        }
    }

}

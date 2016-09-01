
package Principal;

import AccessoDato.EArticulo;
import AccessoDato.ECliente;
import AccessoDato.EDescuentoCabecera;
import AccessoDato.EDescuentoFactura;
import AccessoDato.EFactura;
import AccessoDato.EParametro;
import AccessoDato.EPlaca;
import AccessoDato.EPrecioVenta;
import AccessoDato.ESucursal;
import AccessoDato.EVendedor;
import Negocio.BArticulo;
import Negocio.BCliente;
import Negocio.BDescuentoCabecera;
import Negocio.BDescuentoFactura;
import Negocio.BFactura;
import Negocio.BParametro;
import Negocio.BPlaca;
import Negocio.BPrecioVenta;
import Negocio.BSucursal;
import Negocio.BVendedor;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import com.sun.javafx.scene.control.behavior.OptionalBoolean;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;


public class FrmBuscar extends javax.swing.JInternalFrame {

    
    int m_tipo=0;
    public String  m_nroCodigo="";
    private JInternalFrame m_FrmCli=null;
    private FrmCliente m_Cliente=null;
    private FrmArticulo m_Articulo=null;
    private FrmFactura m_Factura=null;
    private FrmVendedor m_Frmvendedor=null;
    private FrmParametro m_Frmparametro=null;
    private FrmNotaCredito m_frmnotacredito=null;
    private FrmNotaDebito m_frmnotadebito=null;
    private List<ECliente> _lscliente=null;
    private BCliente _bcliente=null;
    private BArticulo _barticulo=null;
    private List<EArticulo> _lsearticulo=null;
    private BPrecioVenta _bprecioventa=null;
    private List<EPrecioVenta> _lseprecioventa=null;
    private BFactura _bfactura=null;
    private List<EFactura> _lsfactura=null;
    private BDescuentoFactura _bdescuentofac;
    private List<EDescuentoFactura> _lsdescuentofactura;
    private FrmDescuentosGlobales m_FrmAdd;
    private FrmSucursal m_frmsucursal;
    private BDescuentoCabecera _bdescuentocabecera;
    private List<EDescuentoCabecera> _lsdescuentocabecera;
    private List<EVendedor> _lsvendedor;
    private BVendedor _bvendedor;
    private BSucursal _bsucursal;
    private List<ESucursal> _lssucursal;
    private BParametro _bparametro;
    private List<EParametro> _lsparametro;
    private EFactura _efacturaitem;
    private boolean  m_estado;
    public FrmBuscar() {
        initComponents();
    }
    public FrmBuscar(int x_tipo,FrmArticulo x_Frm)
    {
        initComponents();
        this.m_tipo=x_tipo;
        this.m_Articulo=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmCliente x_Frm)
    {
        initComponents();
        this.m_tipo=x_tipo;
        this.m_Cliente=x_Frm;
    }
    public FrmBuscar(int x_tipo,JInternalFrame x_Frm)
    {
        initComponents();
        this.m_tipo=x_tipo;
        this.m_FrmCli=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmFactura x_Frm)
    {
        initComponents();
        this.m_tipo=x_tipo;
        this.m_Factura=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmFactura x_Frm,boolean  x_estado)
    {
        initComponents();
        this.m_tipo=x_tipo;
        this.m_Factura=x_Frm;
        this.m_estado=x_estado;
    }
    public FrmBuscar(int x_tipo,FrmDescuentosGlobales x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_FrmAdd=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmVendedor x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_Frmvendedor=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmSucursal x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_frmsucursal=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmParametro x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_Frmparametro=x_Frm;
    }
    public FrmBuscar(int x_tipo,FrmNotaCredito x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_frmnotacredito=x_Frm;
    }
    private String fac_serie;
    private String fac_numero;
    private boolean x_estadobusquedadebitocredito=false;
    public FrmBuscar(boolean x_estado ,int x_tipo,FrmNotaDebito x_Frm)
    {
        initComponents();
        m_tipo=x_tipo;
        m_frmnotadebito=x_Frm;
        x_estadobusquedadebitocredito=x_estado;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoboton = new javax.swing.ButtonGroup();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBuscador = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        rdocodigo = new javax.swing.JRadioButton();
        rdonombre = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Buscador");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        btnAceptar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\note_accept.png")); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        TBuscador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBuscador);

        jLabel1.setText("Buscar");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        rdocodigo.setText("Codigo");

        rdonombre.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdocodigo)
                                .addGap(18, 18, 18)
                                .addComponent(rdonombre)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdocodigo)
                            .addComponent(rdonombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnAceptar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try
        {
            if(TBuscador.getSelectedRow()!= -1){
                int _indice=TBuscador.getSelectedRow();                
                m_nroCodigo=(String) TBuscador.getValueAt( _indice,0).toString(); 
               this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               this.dispose();                
            }
            else
            { JOptionPane.showMessageDialog(null, "Selecione una Fila.", "Mensaje",JOptionPane.WARNING_MESSAGE);  }
        }
        catch(Exception e)
        {      JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);    }
        finally{
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        try
        {
            grupoboton.add(rdocodigo);
            grupoboton.add(rdonombre);
            rdonombre.setSelected(true);
            rdonombre.setVisible(false);
            rdocodigo.setVisible(false);
            txtbuscar.setDocument(new JTextFielCharLimit(MaximoCharacter.DocMaxCharNombre));
            DefinirEstructuraTabla();
            CargarContendoTabla();
//            Object[] columname;
//            DefaultTableModel modelo;
//            switch  (m_tipo)
//                {
//                    case 1://------------------------------------------- buscar cliente se invoca desde el
//                        _bcliente = new BCliente();                        
//                        _lscliente =_bcliente.ObtenerTodos();
//                        final Class[] tiposColumnas = new Class[]{
//                            java.lang.String.class,
//                            java.lang.String.class,
//                            java.lang.String.class,
//                            java.lang.String.class,
//                            java.lang.String.class,
//                            java.lang.String.class,
//                            JButton.class // <- noten que aquí se especifica que la última columna es un botón
//                        };
//                        modelo = new DefaultTableModel(){
//                        Class[] tipos = tiposColumnas;
//                         boolean[] canEdit = new boolean[]{false,false,false,false,false,false,true};
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  
//                            return !(this.getColumnClass(columnIndex).equals(JButton.class));
//                            return canEdit[columnIndex];
//                        }
//                        
//                        @Override
//                        public Class getColumnClass(int columnIndex) {
//                             Este método es invocado por el CellRenderer para saber que dibujar en la celda,
//                             observen que estamos retornando la clase que definimos de antemano.
//                            return tipos[columnIndex];
//                        }
//                        
//                        };
//                        columname = new Object[7];
//                        columname[0]="Codigo";
//                        columname[1]="Razon Social /Nombres";
//                        columname[2]="Documento";
//                        columname[3]="Numero ";
//                        columname[4]="Direccion";                        
//                        columname[5]="TipoDocumento";
//                        columname[6]="Placas";
//                        modelo.setColumnIdentifiers(columname);
//                        Object[] rowData = new Object[7];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo().toString();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();
//                            JButton _verboton=new JButton("ver");
//                            rowData[6]=_verboton;
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
//                        TBuscador.setDefaultRenderer(JButton.class, new TableCellRenderer() {
//                            @Override
//                            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                                return (Component) value;
//                            }
//                        });
//                        TBuscador.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                int fila = TBuscador.rowAtPoint(e.getPoint());
//                int columna = TBuscador.columnAtPoint(e.getPoint());
//                /**
//                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
//                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
//                 */
//                if (TBuscador.getModel().getColumnClass(columna).equals(JButton.class)) {
//                    /**
//                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
//                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
//                     */
//                    StringBuilder sb = new StringBuilder();
//                    for (int i = 0; i < TBuscador.getModel().getColumnCount(); i++) {
//                        if (!TBuscador.getModel().getColumnClass(i).equals(JButton.class)) {
//                            {
//                                  //sb.append("\n").append(TBuscador.getModel().getColumnName(i)).append(": ").append(TBuscador.getModel().getValueAt(fila, i));
////                                
//                                
//                            }
//                         }
//                    }
//                                    String _codigo=TBuscador.getModel().getValueAt(fila, 0).toString();
//                                    Object [] vector=null;
//                                    if(!_codigo.equals(""))
//                                    {
//                                        BPlaca _bplaca =new BPlaca();
//                                        List<EPlaca> _lsplaca=_bplaca.AccionObtenerTodoxCodigoCliente_ClienteMantenimeinto(Integer.parseInt(_codigo));
//
//                                        if(_lsplaca.size()>0)
//                                        {
//                                             vector=_lsplaca.stream().map(x->x.getPla_cnombre()).collect(Collectors.toList()).toArray();
//                                        }
//                                        else
//                                        {    vector =new Object[1];
//                                             vector[0]="No hay Placas";
//                                        }
//                                    }else
//                                    {
//                                        vector =new Object[1];
//                                        vector[0]="No hay Placas";
//                                    }
//                                    JOptionPane.showMessageDialog(null, new JList(vector) );
//                                }
//                            }
//                    });
//                        
//                    break;                        
//                    case 2://---------------------------------------------------------------Articulo
//                        _barticulo = new BArticulo();
//                        _lsearticulo =_barticulo.ObtenerTodos();
//                        modelo = new DefaultTableModel(){ boolean[] canEdit = new boolean[]{false,false,false,false,false,false };
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Articulo";
//                        columname[2]="Codunidad";
//                        columname[3]="Codigo";
//                        columname[4]="Cod.Barra";                        
//                        columname[5]="Unidad";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lsearticulo.size()-1;i++)
//                        {
//                            rowData[0]=_lsearticulo.get(i).getArt_ncodigo();
//                            rowData[1]=_lsearticulo.get(i).getArt_cdescripcion();
//                            rowData[2]=_lsearticulo.get(i).getUni_ncodigo();
//                            rowData[3]=_lsearticulo.get(i).getArt_ccodigo();
//                            rowData[4]=_lsearticulo.get(i).getArt_ccodbarra();
//                            rowData[5]=_lsearticulo.get(i).getUni_cdescripcion();
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("Codunidad").setPreferredWidth(0);
//                        TBuscador.getColumn("Codunidad").setMinWidth(0);
//                        TBuscador.getColumn("Codunidad").setWidth(0);
//                        TBuscador.getColumn("Codunidad").setMaxWidth(0);
//                    break;
//                    case 3://------------------------------------------------------Cliente
//                        _bcliente = new BCliente();                        
//                        _lscliente =_bcliente.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Razon Social /Nombres";
//                        columname[2]="Documento";
//                        columname[3]="Numero ";
//                        columname[4]="Direccion";                        
//                        columname[5]="TipoDocumento";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
//                        
//                        break;
//                    case 4://--------------------------------------------------------------lista de precios detalle para la factura
//                        _bprecioventa = new BPrecioVenta();                        
//                        _lseprecioventa =_bprecioventa.AcctionDetalle();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[10];
//                        columname[0]="codigo";
//                        columname[1]="Producto";
//                        columname[2]="Unidad";
//                        columname[3]="Moneda";
//                        columname[4]="Tipo Precio";                        
//                        columname[5]="V. Unitario";
//                        columname[6]="V. Venta";
//                        columname[7]="Afectacón";                        
//                        columname[8]="unicodigo";
//                        columname[9]="artcodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[10];
//                        for (int i=0;i<=_lseprecioventa.size()-1;i++)
//                        {
//                            rowData[0]=_lseprecioventa.get(i).getPve_ncodigo();
//                            rowData[1]=_lseprecioventa.get(i).getArt_cdescripcion();
//                            rowData[2]=_lseprecioventa.get(i).getUni_cdescripcion();
//                            rowData[3]=_lseprecioventa.get(i).getPve_cmoneda();
//                            rowData[4]=_lseprecioventa.get(i).getPve_ctipoprecio();
//                            rowData[5]=_lseprecioventa.get(i).getPve_fpreciounitario();
//                            rowData[6]=_lseprecioventa.get(i).getPve_fprecioventa();
//                            rowData[7]=_lseprecioventa.get(i).getArt_cafecdescripcion();
//                            rowData[8]=_lseprecioventa.get(i).getUni_ccodigo();
//                            rowData[9]=_lseprecioventa.get(i).getArt_ncodigo();
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("codigo").setMinWidth(0);
//                        TBuscador.getColumn("codigo").setWidth(0);
//                        TBuscador.getColumn("codigo").setMaxWidth(0);
//                        TBuscador.getColumn("unicodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("unicodigo").setMinWidth(0);
//                        TBuscador.getColumn("unicodigo").setWidth(0);
//                        TBuscador.getColumn("unicodigo").setMaxWidth(0);
//                        TBuscador.getColumn("artcodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("artcodigo").setMinWidth(0);
//                        TBuscador.getColumn("artcodigo").setWidth(0);
//                        TBuscador.getColumn("artcodigo").setMaxWidth(0);
//                        rdocodigo.setVisible(true);
//                        rdocodigo.setVisible(true);
//                        
//                        break;
//                    case 5://------------------------------------------------------------FACTURA
//                        _bfactura = new BFactura();                        
//                        _lsfactura =_bfactura.ObtenerTodo();
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                         columname = new Object[19];
//                        columname[0]="Interno";
//                        columname[1]="Fec. Emision";
//                        columname[2]="Serie-numero";
//                        columname[3]="Documento";
//                        columname[4]="Estado";                        
//                        columname[5]="Pago";
//                        columname[6]="Moneda";
//                        columname[7]="Cliente";
//                        columname[8]="Subtoal";
//                        columname[9]="Total";
//                        columname[10]="Exonerado";
//                        columname[11]="inafecto";
//                        columname[12]="Vendedor";
//                        columname[13]="cli_ncodigo";
//                        columname[14]="ley_ncodigo";
//                        columname[15]="fac_cclasepago";
//                        columname[16]="doc_ccodigo";
//                        columname[17]="mon_ncodigo";
//                        columname[18]="ven_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[20];
//                        for (int i=0;i<=_lsfactura.size()-1;i++)
//                        {
//                            rowData[0]=_lsfactura.get(i).getFac_ncodigo();
//                            rowData[1]=_lsfactura.get(i).getFac_dfechaemision().toString();
//                            rowData[2]=_lsfactura.get(i).getFac_numerodocumento();
//                            rowData[3]=_lsfactura.get(i).getFac_ctipodocumento();
//                            rowData[4]=_lsfactura.get(i).getFac_estadodocumento();
//                            rowData[5]=_lsfactura.get(i).getFac_cclasedepagodocumento();
//                            rowData[6]=_lsfactura.get(i).getFac_cmondocumento();
//                            rowData[7]=_lsfactura.get(i).getFac_cnombrecliente();
//                            rowData[8]=_lsfactura.get(i).getFac_fimportesubtotal();
//                            rowData[9]=_lsfactura.get(i).getFac_ftotal();
//                            rowData[10]=_lsfactura.get(i).getFac_ftotalexonerado();
//                            rowData[11]=_lsfactura.get(i).getFac_ftotalinafecto();
//                            rowData[12]=_lsfactura.get(i).getFac_nombrevendedor();
//                            rowData[13]=_lsfactura.get(i).getCli_ncodigo();
//                            rowData[14]=_lsfactura.get(i).getLey_ncodigo();
//                            rowData[15]=_lsfactura.get(i).getFac_cclasepago();
//                            rowData[16]=_lsfactura.get(i).getDoc_ccodigo();
//                            rowData[17]=_lsfactura.get(i).getMon_ccodigo();
//                            rowData[18]=_lsfactura.get(i).getVe_ncodigo();
//                            
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
//                        
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//                         this.setSize(900, 450);
//                        break;
//                    case 6://-----------------------------------------------------------------Todos los descuentos configurados
//                        _bdescuentocabecera = new BDescuentoCabecera();                        
//                        _lsdescuentocabecera =_bdescuentocabecera.ObtenerTodo();
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                         columname = new Object[5];
//                        columname[0]="cds_ncodigo";
//                        columname[1]="Nombre";
//                        columname[2]="Alias";
//                        columname[3]="Direccion";
//                        columname[4]="suc_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[7];
//                        for (int i=0;i<=_lsdescuentocabecera.size()-1;i++)
//                        {
//                            rowData[0]=_lsdescuentocabecera.get(i).getCds_ncodigo();
//                            rowData[1]=_lsdescuentocabecera.get(i).getCds_cnombre();
//                            rowData[2]=_lsdescuentocabecera.get(i).getSuc_calias();
//                            rowData[3]=_lsdescuentocabecera.get(i).getSuc_cdireccion();
//                            rowData[4]=_lsdescuentocabecera.get(i).getSuc_ncodigo();
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cds_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setMaxWidth(350);
//                        TBuscador.getColumn("Direccion").setMinWidth(350);
//                        TBuscador.getColumn("Direccion").setWidth(350);
//                        TBuscador.getColumn("Direccion").setMaxWidth(350);
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//                        break;
//                    case 7://---------------------------------------------------------------Vendedor
//                        _bvendedor = new BVendedor();                        
//                        _lsvendedor =_bvendedor.AccionObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[5];
//                        columname[0]="ven_ncodigo";
//                        columname[1]="Apellidos y Nombres";
//                        columname[2]="Documento";                        
//                        columname[3]="Numero";
//                        columname[4]="doi_ccodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[5];
//                        for (int i=0;i<=_lsvendedor.size()-1;i++)
//                        {
//                            rowData[0]=_lsvendedor.get(i).getVen_ncodigo();
//                            rowData[1]=_lsvendedor.get(i).getVen_cpaterno()+" "+_lsvendedor.get(i).getVen_materno()+" "+_lsvendedor.get(i).getVen_nombres();
//                            rowData[2]=_lsvendedor.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lsvendedor.get(i).getVen_cnumero();
//                            rowData[4]=_lsvendedor.get(i).getDoi_ccodigo();
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Apellidos y Nombres").setPreferredWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setMinWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setMaxWidth(200);
//                        break;
//                    case 8://-----------------------------------------------------------Sucursal
//                        _bsucursal = new BSucursal();                        
//                        _lssucursal =_bsucursal.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[11];
//                        columname[0]="suc_ncodigo";
//                        columname[1]="Direccion";
//                        columname[2]="Alias";                        
//                        columname[3]="Departamento";
//                        columname[4]="Provincia";
//                        columname[5]="Distrito";
//                        columname[6]="Pais";
//                        columname[7]="ubi_ccoddepa";
//                        columname[8]="ubi_codpro";
//                        columname[9]="ubi_coddistri";
//                        columname[10]="pai_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[11];
//                        for (int i=0;i<=_lssucursal.size()-1;i++)
//                        {
//                            rowData[0]=_lssucursal.get(i).getSuc_ncodigo();
//                            rowData[1]=_lssucursal.get(i).getSuc_cdireccion();
//                            rowData[2]=_lssucursal.get(i).getSuc_sucdescripcion();
//                            rowData[3]=_lssucursal.get(i).getSuc_cdepartamento();
//                            rowData[4]=_lssucursal.get(i).getSuc_cprovincia();
//                            rowData[5]=_lssucursal.get(i).getSuc_cdistrito();
//                            rowData[6]=_lssucursal.get(i).getSuc_cpais();
//                            rowData[7]=_lssucursal.get(i).getSuc_coddepa();
//                            rowData[8]=_lssucursal.get(i).getSuc_codprov();
//                            rowData[9]=_lssucursal.get(i).getSuc_coddistri();
//                            rowData[10]=_lssucursal.get(i).getPai_ncodigo();
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setMinWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setMinWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setMinWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setMaxWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
//                        TBuscador.getColumn("Direccion").setMinWidth(200);
//                        TBuscador.getColumn("Direccion").setWidth(200);
//                        TBuscador.getColumn("Direccion").setMaxWidth(200);
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//                        break;
//                    case 9://----------------------------------------------------------------Parametro
//                        _bparametro = new BParametro();                        
//                        _lsparametro =_bparametro.AccionObtenerTodosParametro();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="par_ncodigo";
//                        columname[1]="Simbolo";
//                        columname[2]="Usuario";                        
//                        columname[3]="Alias";
//                        columname[4]="Direccion";
//                        columname[5]="par_nsucursal";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lsparametro.size()-1;i++)
//                        {
//                            rowData[0]=_lsparametro.get(i).getPar_ncodigo();
//                            rowData[1]=_lsparametro.get(i).getMon_cdescripcion();
//                            rowData[2]=_lsparametro.get(i).getVen_cnombre();
//                            rowData[3]=_lsparametro.get(i).getSuc_calias();
//                            rowData[4]=_lsparametro.get(i).getSuc_cdireccion();
//                            rowData[5]=_lsparametro.get(i).getPar_nsucursal();
//                            
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("par_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setPreferredWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setMinWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
//                        TBuscador.getColumn("Direccion").setMinWidth(200);
//                        TBuscador.getColumn("Direccion").setWidth(200);
//                        TBuscador.getColumn("Direccion").setMaxWidth(200);
//                        TBuscador.getColumn("Usuario").setPreferredWidth(200);
//                        TBuscador.getColumn("Usuario").setMinWidth(200);
//                        TBuscador.getColumn("Usuario").setWidth(200);
//                        TBuscador.getColumn("Usuario").setMaxWidth(200);
//                        TBuscador.getColumn("Alias").setPreferredWidth(120);
//                        TBuscador.getColumn("Alias").setMinWidth(120);
//                        TBuscador.getColumn("Alias").setWidth(120);
//                        TBuscador.getColumn("Alias").setMaxWidth(120);
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//                        break;
//                    case 10://------------------------------------------------------------Lista Factura para emitir notas de credito
//                        _bfactura = new BFactura();                        
//                        _efacturaitem =_bfactura.ObtenerTodoxSerieandNumero(getFac_serie(),getFac_numero());
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[19];
//                        columname[0]="Interno";
//                        columname[1]="Fec. Emision";
//                        columname[2]="Serie-numero";
//                        columname[3]="Documento";
//                        columname[4]="Estado";                        
//                        columname[5]="Pago";
//                        columname[6]="Moneda";
//                        columname[7]="Cliente";
//                        columname[8]="Subtoal";
//                        columname[9]="Total";
//                        columname[10]="Exonerado";
//                        columname[11]="inafecto";
//                        columname[12]="Vendedor";
//                        columname[13]="cli_ncodigo";
//                        columname[14]="ley_ncodigo";
//                        columname[15]="fac_cclasepago";
//                        columname[16]="doc_ccodigo";
//                        columname[17]="mon_ncodigo";
//                        columname[18]="ven_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[20];
//                        for (int i=0;i<=_efacturaitem.size()-1;i++)
//                        {
//                            rowData[0]=_efacturaitem.getFac_ncodigo();
//                            rowData[1]=_efacturaitem.getFac_dfechaemision().toString();
//                            rowData[2]=_efacturaitem.getFac_cserie()+"-"+_efacturaitem.getFac_cnumero();
//                            rowData[3]=_efacturaitem.getFac_ctipodocumento();
//                            rowData[4]=_efacturaitem.getFac_estadodocumento();
//                            rowData[5]=_efacturaitem.getFac_cclasedepagodocumento();
//                            rowData[6]=_efacturaitem.getFac_cmondocumento();
//                            rowData[7]=_efacturaitem.getFac_cnombrecliente();
//                            rowData[8]=_efacturaitem.getFac_fimportesubtotal();
//                            rowData[9]=_efacturaitem.getFac_ftotal();
//                            rowData[10]=_efacturaitem.getFac_ftotalexonerado();
//                            rowData[11]=_efacturaitem.getFac_ftotalinafecto();
//                            rowData[12]=_efacturaitem.getFac_nombrevendedor();
//                            rowData[13]=_efacturaitem.getCli_ncodigo();
//                            rowData[14]=_efacturaitem.getLey_ncodigo();
//                            rowData[15]=_efacturaitem.getFac_cclasepago();
//                            rowData[16]=_efacturaitem.getDoc_ccodigo();
//                            rowData[17]=_efacturaitem.getMon_ccodigo();
//                            rowData[18]=_efacturaitem.getVe_ncodigo();
//                            
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//                        break;
//                    case 11://----------------------------------BuscarCliente desde la factura por numero de documento
//                        _bcliente = new BCliente();
//                        if(m_estado)
//                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "01");
//                        else
//                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "03");
//                        _lscliente =_bcliente.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Razon Social /Nombres";
//                        columname[2]="Documento";
//                        columname[3]="Numero ";
//                        columname[4]="Direccion";                        
//                        columname[5]="TipoDocumento";
//                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
//                            modelo.addRow(rowData);
//                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
//                        
//                        break;
//                }
//            TBuscador.setShowHorizontalLines(true);
//            TBuscador.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       switch  (m_tipo)
                {
                    case 1:////////////////////clientes
                        if(m_nroCodigo!="")
                        {
                            m_Cliente.m_Codigo=m_nroCodigo;
                            m_Cliente.CargarFrm();
                        }
                        break;
                    case 2:///////////////////////////Articulo
                        if(m_nroCodigo!="")
                        {
                            m_Articulo.m_codigo=m_nroCodigo;
                            m_Articulo.CargarFrm();
                        }                        
                        break;
                    case 3:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_Factura.m_Codigo=m_nroCodigo;
                            m_Factura.CargarCliente(OptionalBoolean.FALSE);
                        } 
                        break;//"20527446369""20600822404"  --copiaste pero no eliminaste ...!
                    case 4:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_Factura.m_Codigo=m_nroCodigo;
                            m_Factura.CargarArticulo();
                        }
                        break;
//                    case 5:
//                        if(!"".equals(m_nroCodigo))
//                        {
//                            m_Factura.m_Codigo=m_nroCodigo;
//                            m_Factura.CargarFactura();
//                        }
//                        break;
                    case 6:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_FrmAdd.m_Codigo=m_nroCodigo;
                            m_FrmAdd.CargarDescuento();
                        }
                        break;
                    case 7:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_Frmvendedor.m_Codigo=m_nroCodigo;
                            m_Frmvendedor.CargarVendedor();
                        }
                        break;
                    case 8:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_frmsucursal.m_Codigo=m_nroCodigo;
                            m_frmsucursal.CargarSucursal();
                        }
                        break;
                    case 9:
                        if(!"".equals(m_nroCodigo))
                        {
                            m_Frmparametro.m_Codigo=m_nroCodigo;
                            m_Frmparametro.CargarParametro();
                        break;
                        }
                    case 10://-------------------------------------------Busqueda de facturas desde NotaCredito y Nota Debito
                        if(!"".equals(m_nroCodigo))
                        {
                            if(x_estadobusquedadebitocredito)
                            {
                                m_frmnotadebito.m_Codigo=m_nroCodigo;
                                m_frmnotadebito.CargarFrm();
                            }
                            else
                            {
                                m_frmnotacredito.m_Codigo=m_nroCodigo;
                                m_frmnotacredito.CargarFrm();
                            }
                            
                        
                        }
                        break;
                    case 11://-----------------------------------------------------Cargando busqueda de cliente desde formulario factura
                        if(!"".equals(m_nroCodigo))
                        {
                           m_Factura.m_Codigo=m_nroCodigo;
                           m_Factura.CargarCliente(OptionalBoolean.FALSE);
                        
                        }
                        break;
    }//GEN-LAST:event_formInternalFrameClosed
    }
    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
               // JOptionPane.showMessageDialog(null, " Buscando:"+txtbuscar.getText(),"Mensaje",JOptionPane.WARNING_MESSAGE);
     try {
            modelo =(DefaultTableModel) TBuscador.getModel();
            modelo.setNumRows(0);
           switch  (m_tipo)
                {
                    case 1:////////////////////clientes
                        
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                               _bprecioventa = new BPrecioVenta();                        
                               _lseprecioventa =_bprecioventa.AcctionBuscarDetallexCaracter(txtbuscar.getText());                        
                               rowData = new Object[11];
                               for (int i=0;i<=_lseprecioventa.size()-1;i++)
                               {
                                   rowData[0]=_lseprecioventa.get(i).getPve_ncodigo();
                                   rowData[1]=_lseprecioventa.get(i).getArt_cdescripcion();
                                   rowData[2]=_lseprecioventa.get(i).getArt_ccodigoArticulo();                            
                                   rowData[3]=_lseprecioventa.get(i).getUni_cdescripcion();
                                   rowData[4]=_lseprecioventa.get(i).getPve_cmoneda();
                                   rowData[5]=_lseprecioventa.get(i).getPve_ctipoprecio();
                                   rowData[6]=_lseprecioventa.get(i).getPve_fpreciounitario();
                                   rowData[7]=_lseprecioventa.get(i).getPve_fprecioventa();
                                   rowData[8]=_lseprecioventa.get(i).getArt_cafecdescripcion();
                                   rowData[9]=_lseprecioventa.get(i).getUni_ccodigo();
                                   rowData[10]=_lseprecioventa.get(i).getArt_ncodigo();
                                   modelo.addRow(rowData);
                                }
                        break;
                    case 5:
                        break;
                    case 11:
                        _bcliente = new BCliente();
                        if(m_estado)
                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente(txtbuscar.getText(), "01");
                        else
                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente(txtbuscar.getText(), "03");
			rowData = new Object[6];
                        for (int i=0;i<=_lscliente.size()-1;i++)
                        {
                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
                            rowData[1]=_lscliente.get(i).getCli_crazon();
                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
                        break;
                       
           }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error Buscando:"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtbuscarKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBuscador;
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup grupoboton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdocodigo;
    private javax.swing.JRadioButton rdonombre;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    public String getFac_serie() {
        return fac_serie;
    }

    public void setFac_serie(String fac_serie) {
        this.fac_serie = fac_serie;
    }

    public String getFac_numero() {
        return fac_numero;
    }

    public void setFac_numero(String fac_numero) {
        this.fac_numero = fac_numero;
    }
    Object[] columname;
    DefaultTableModel modelo;
    Object[] rowData;
    private void DefinirEstructuraTabla()
    {
        try{
            switch  (m_tipo)
                {
                    case 1://------------------------------------------- buscar cliente se invoca desde el
                        _bcliente = new BCliente();                        
                        _lscliente =_bcliente.ObtenerTodos();
                        final Class[] tiposColumnas = new Class[]{
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            JButton.class // <- noten que aquí se especifica que la última columna es un botón
                        };
                        modelo = new DefaultTableModel(){
                        Class[] tipos = tiposColumnas;
                        // boolean[] canEdit = new boolean[]{false,false,false,false,false,false,true};
                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  
                            return !(this.getColumnClass(columnIndex).equals(JButton.class));
                            //return canEdit[columnIndex];
                        }
                        
                        @Override
                        public Class getColumnClass(int columnIndex) {
                            // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                            // observen que estamos retornando la clase que definimos de antemano.
                            return tipos[columnIndex];
                        }
                        
                        };
                        columname = new Object[7];
                        columname[0]="Codigo";
                        columname[1]="Razon Social /Nombres";
                        columname[2]="Documento";
                        columname[3]="Numero ";
                        columname[4]="Direccion";                        
                        columname[5]="TipoDocumento";
                        columname[6]="Placas";
                        modelo.setColumnIdentifiers(columname);
//                        Object[] rowData = new Object[7];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo().toString();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();
//                            JButton _verboton=new JButton("ver");
//                            rowData[6]=_verboton;
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
                        TBuscador.getColumn("Codigo").setMinWidth(0);
                        TBuscador.getColumn("Codigo").setWidth(0);
                        TBuscador.getColumn("Codigo").setMaxWidth(0);
                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
                        TBuscador.getColumn("TipoDocumento").setWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
                        TBuscador.setDefaultRenderer(JButton.class, new TableCellRenderer() {
                            @Override
                            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                                return (Component) value;
                            }
                        });
                        TBuscador.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                int fila = TBuscador.rowAtPoint(e.getPoint());
                int columna = TBuscador.columnAtPoint(e.getPoint());
                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (TBuscador.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
//                    for (int i = 0; i < TBuscador.getModel().getColumnCount(); i++) {
//                        if (!TBuscador.getModel().getColumnClass(i).equals(JButton.class)) {
//                            {
//                                  //sb.append("\n").append(TBuscador.getModel().getColumnName(i)).append(": ").append(TBuscador.getModel().getValueAt(fila, i));
////                                
//                                
//                            }
//                         }
//                    }
                                    String _codigo=TBuscador.getModel().getValueAt(fila, 0).toString();
                                    Object [] vector=null;
                                    if(!_codigo.equals(""))
                                    {
                                        BPlaca _bplaca =new BPlaca();
                                        List<EPlaca> _lsplaca=_bplaca.AccionObtenerTodoxCodigoCliente_ClienteMantenimeinto(Integer.parseInt(_codigo));

                                        if(_lsplaca.size()>0)
                                        {
                                             vector=_lsplaca.stream().map(x->x.getPla_cnombre()).collect(Collectors.toList()).toArray();
                                        }
                                        else
                                        {    vector =new Object[1];
                                             vector[0]="No hay Placas";
                                        }
                                    }else
                                    {
                                        vector =new Object[1];
                                        vector[0]="No hay Placas";
                                    }
                                    JOptionPane.showMessageDialog(null, new JList(vector) );
                                }
                            }
                    });
                        
                    break;                        
                    case 2://---------------------------------------------------------------Articulo
//                        _barticulo = new BArticulo();
//                        _lsearticulo =_barticulo.ObtenerTodos();
                        modelo = new DefaultTableModel(){ boolean[] canEdit = new boolean[]{false,false,false,false,false,false };
                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                        columname = new Object[6];
                        columname[0]="Codigo";
                        columname[1]="Articulo";
                        columname[2]="Codunidad";
                        columname[3]="Codigo";
                        columname[4]="Cod.Barra";                        
                        columname[5]="Unidad";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lsearticulo.size()-1;i++)
//                        {
//                            rowData[0]=_lsearticulo.get(i).getArt_ncodigo();
//                            rowData[1]=_lsearticulo.get(i).getArt_cdescripcion();
//                            rowData[2]=_lsearticulo.get(i).getUni_ncodigo();
//                            rowData[3]=_lsearticulo.get(i).getArt_ccodigo();
//                            rowData[4]=_lsearticulo.get(i).getArt_ccodbarra();
//                            rowData[5]=_lsearticulo.get(i).getUni_cdescripcion();
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
                        TBuscador.getColumn("Codigo").setMinWidth(0);
                        TBuscador.getColumn("Codigo").setWidth(0);
                        TBuscador.getColumn("Codigo").setMaxWidth(0);
                        TBuscador.getColumn("Codunidad").setPreferredWidth(0);
                        TBuscador.getColumn("Codunidad").setMinWidth(0);
                        TBuscador.getColumn("Codunidad").setWidth(0);
                        TBuscador.getColumn("Codunidad").setMaxWidth(0);
                    break;
                    case 3://------------------------------------------------------Cliente
//                        _bcliente = new BCliente();                        
//                        _lscliente =_bcliente.ObtenerTodos();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                        columname = new Object[6];
                        columname[0]="Codigo";
                        columname[1]="Razon Social /Nombres";
                        columname[2]="Documento";
                        columname[3]="Numero ";
                        columname[4]="Direccion";                        
                        columname[5]="TipoDocumento";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
                        TBuscador.getColumn("Codigo").setMinWidth(0);
                        TBuscador.getColumn("Codigo").setWidth(0);
                        TBuscador.getColumn("Codigo").setMaxWidth(0);
                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
                        TBuscador.getColumn("TipoDocumento").setWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
                        
                        break;
                    case 4://--------------------------------------------------------------lista de precios detalle para la factura
//                        _bprecioventa = new BPrecioVenta();                        
//                        _lseprecioventa =_bprecioventa.AcctionDetalle();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false};
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                            {  return canEdit[columnIndex];}
                        };
                        columname = new Object[11];
                        columname[0]="codigo";
                        columname[1]="Producto";
                        columname[2]="Codigo";                        
                        columname[3]="Unidad";
                        columname[4]="Moneda";
                        columname[5]="Tipo Precio";                        
                        columname[6]="V. Unitario";
                        columname[7]="V. Venta";
                        columname[8]="Afectacón";                        
                        columname[9]="unicodigo";
                        columname[10]="artcodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[10];
//                        for (int i=0;i<=_lseprecioventa.size()-1;i++)
//                        {
//                            rowData[0]=_lseprecioventa.get(i).getPve_ncodigo();
//                            rowData[1]=_lseprecioventa.get(i).getArt_cdescripcion();
//                            rowData[2]=_lseprecioventa.get(i).getUni_cdescripcion();
//                            rowData[3]=_lseprecioventa.get(i).getPve_cmoneda();
//                            rowData[4]=_lseprecioventa.get(i).getPve_ctipoprecio();
//                            rowData[5]=_lseprecioventa.get(i).getPve_fpreciounitario();
//                            rowData[6]=_lseprecioventa.get(i).getPve_fprecioventa();
//                            rowData[7]=_lseprecioventa.get(i).getArt_cafecdescripcion();
//                            rowData[8]=_lseprecioventa.get(i).getUni_ccodigo();
//                            rowData[9]=_lseprecioventa.get(i).getArt_ncodigo();
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("codigo").setPreferredWidth(0);
                        TBuscador.getColumn("codigo").setMinWidth(0);
                        TBuscador.getColumn("codigo").setWidth(0);
                        TBuscador.getColumn("codigo").setMaxWidth(0);
                        TBuscador.getColumn("unicodigo").setPreferredWidth(0);
                        TBuscador.getColumn("unicodigo").setMinWidth(0);
                        TBuscador.getColumn("unicodigo").setWidth(0);
                        TBuscador.getColumn("unicodigo").setMaxWidth(0);
                        TBuscador.getColumn("artcodigo").setPreferredWidth(0);
                        TBuscador.getColumn("artcodigo").setMinWidth(0);
                        TBuscador.getColumn("artcodigo").setWidth(0);
                        TBuscador.getColumn("artcodigo").setMaxWidth(0);
                        rdocodigo.setVisible(true);
                        rdonombre.setVisible(true);
                        rdonombre.setSelected(true);
                        break;
                    case 5://------------------------------------------------------------FACTURA
//                        _bfactura = new BFactura();                        
//                        _lsfactura =_bfactura.ObtenerTodo();
                        modelo = new DefaultTableModel(){
                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                         columname = new Object[19];
                        columname[0]="Interno";
                        columname[1]="Fec. Emision";
                        columname[2]="Serie-numero";
                        columname[3]="Documento";
                        columname[4]="Estado";                        
                        columname[5]="Pago";
                        columname[6]="Moneda";
                        columname[7]="Cliente";
                        columname[8]="Subtoal";
                        columname[9]="Total";
                        columname[10]="Exonerado";
                        columname[11]="inafecto";
                        columname[12]="Vendedor";
                        columname[13]="cli_ncodigo";
                        columname[14]="ley_ncodigo";
                        columname[15]="fac_cclasepago";
                        columname[16]="doc_ccodigo";
                        columname[17]="mon_ncodigo";
                        columname[18]="ven_ncodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[20];
//                        for (int i=0;i<=_lsfactura.size()-1;i++)
//                        {
//                            rowData[0]=_lsfactura.get(i).getFac_ncodigo();
//                            rowData[1]=_lsfactura.get(i).getFac_dfechaemision().toString();
//                            rowData[2]=_lsfactura.get(i).getFac_numerodocumento();
//                            rowData[3]=_lsfactura.get(i).getFac_ctipodocumento();
//                            rowData[4]=_lsfactura.get(i).getFac_estadodocumento();
//                            rowData[5]=_lsfactura.get(i).getFac_cclasedepagodocumento();
//                            rowData[6]=_lsfactura.get(i).getFac_cmondocumento();
//                            rowData[7]=_lsfactura.get(i).getFac_cnombrecliente();
//                            rowData[8]=_lsfactura.get(i).getFac_fimportesubtotal();
//                            rowData[9]=_lsfactura.get(i).getFac_ftotal();
//                            rowData[10]=_lsfactura.get(i).getFac_ftotalexonerado();
//                            rowData[11]=_lsfactura.get(i).getFac_ftotalinafecto();
//                            rowData[12]=_lsfactura.get(i).getFac_nombrevendedor();
//                            rowData[13]=_lsfactura.get(i).getCli_ncodigo();
//                            rowData[14]=_lsfactura.get(i).getLey_ncodigo();
//                            rowData[15]=_lsfactura.get(i).getFac_cclasepago();
//                            rowData[16]=_lsfactura.get(i).getDoc_ccodigo();
//                            rowData[17]=_lsfactura.get(i).getMon_ccodigo();
//                            rowData[18]=_lsfactura.get(i).getVe_ncodigo();
//                            
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
                        
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // this.setSize(900, 450);
                        break;
                    case 6://-----------------------------------------------------------------Todos los descuentos configurados
//                        _bdescuentocabecera = new BDescuentoCabecera();                        
//                        _lsdescuentocabecera =_bdescuentocabecera.ObtenerTodo();
                        modelo = new DefaultTableModel(){
                             boolean[] canEdit = new boolean[]{false,false,false,false,false };
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                         columname = new Object[5];
                        columname[0]="cds_ncodigo";
                        columname[1]="Nombre";
                        columname[2]="Alias";
                        columname[3]="Direccion";
                        columname[4]="suc_ncodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[7];
//                        for (int i=0;i<=_lsdescuentocabecera.size()-1;i++)
//                        {
//                            rowData[0]=_lsdescuentocabecera.get(i).getCds_ncodigo();
//                            rowData[1]=_lsdescuentocabecera.get(i).getCds_cnombre();
//                            rowData[2]=_lsdescuentocabecera.get(i).getSuc_calias();
//                            rowData[3]=_lsdescuentocabecera.get(i).getSuc_cdireccion();
//                            rowData[4]=_lsdescuentocabecera.get(i).getSuc_ncodigo();
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("cds_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("cds_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("cds_ncodigo").setWidth(0);
                        TBuscador.getColumn("cds_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("Direccion").setMaxWidth(350);
                        TBuscador.getColumn("Direccion").setMinWidth(350);
                        TBuscador.getColumn("Direccion").setWidth(350);
                        TBuscador.getColumn("Direccion").setMaxWidth(350);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 7://---------------------------------------------------------------Vendedor
//                        _bvendedor = new BVendedor();                        
//                        _lsvendedor =_bvendedor.AccionObtenerTodos();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false};
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                            {  return canEdit[columnIndex];}
                        };
                        columname = new Object[5];
                        columname[0]="ven_ncodigo";
                        columname[1]="Apellidos y Nombres";
                        columname[2]="Documento";                        
                        columname[3]="Numero";
                        columname[4]="doi_ccodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[5];
//                        for (int i=0;i<=_lsvendedor.size()-1;i++)
//                        {
//                            rowData[0]=_lsvendedor.get(i).getVen_ncodigo();
//                            rowData[1]=_lsvendedor.get(i).getVen_cpaterno()+" "+_lsvendedor.get(i).getVen_materno()+" "+_lsvendedor.get(i).getVen_nombres();
//                            rowData[2]=_lsvendedor.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lsvendedor.get(i).getVen_cnumero();
//                            rowData[4]=_lsvendedor.get(i).getDoi_ccodigo();
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("doi_ccodigo").setPreferredWidth(0);
                        TBuscador.getColumn("doi_ccodigo").setMinWidth(0);
                        TBuscador.getColumn("doi_ccodigo").setWidth(0);
                        TBuscador.getColumn("doi_ccodigo").setMaxWidth(0);
                        TBuscador.getColumn("Apellidos y Nombres").setPreferredWidth(200);
                        TBuscador.getColumn("Apellidos y Nombres").setMinWidth(200);
                        TBuscador.getColumn("Apellidos y Nombres").setWidth(200);
                        TBuscador.getColumn("Apellidos y Nombres").setMaxWidth(200);
                        break;
                    case 8://-----------------------------------------------------------Sucursal
//                        _bsucursal = new BSucursal();                        
//                        _lssucursal =_bsucursal.ObtenerTodos();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false,false};
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                            {  return canEdit[columnIndex];}
                        };
                        columname = new Object[11];
                        columname[0]="suc_ncodigo";
                        columname[1]="Direccion";
                        columname[2]="Alias";                        
                        columname[3]="Departamento";
                        columname[4]="Provincia";
                        columname[5]="Distrito";
                        columname[6]="Pais";
                        columname[7]="ubi_ccoddepa";
                        columname[8]="ubi_codpro";
                        columname[9]="ubi_coddistri";
                        columname[10]="pai_ncodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[11];
//                        for (int i=0;i<=_lssucursal.size()-1;i++)
//                        {
//                            rowData[0]=_lssucursal.get(i).getSuc_ncodigo();
//                            rowData[1]=_lssucursal.get(i).getSuc_cdireccion();
//                            rowData[2]=_lssucursal.get(i).getSuc_sucdescripcion();
//                            rowData[3]=_lssucursal.get(i).getSuc_cdepartamento();
//                            rowData[4]=_lssucursal.get(i).getSuc_cprovincia();
//                            rowData[5]=_lssucursal.get(i).getSuc_cdistrito();
//                            rowData[6]=_lssucursal.get(i).getSuc_cpais();
//                            rowData[7]=_lssucursal.get(i).getSuc_coddepa();
//                            rowData[8]=_lssucursal.get(i).getSuc_codprov();
//                            rowData[9]=_lssucursal.get(i).getSuc_coddistri();
//                            rowData[10]=_lssucursal.get(i).getPai_ncodigo();
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("ubi_ccoddepa").setPreferredWidth(0);
                        TBuscador.getColumn("ubi_ccoddepa").setMinWidth(0);
                        TBuscador.getColumn("ubi_ccoddepa").setWidth(0);
                        TBuscador.getColumn("ubi_ccoddepa").setMaxWidth(0);
                        TBuscador.getColumn("ubi_codpro").setPreferredWidth(0);
                        TBuscador.getColumn("ubi_codpro").setMinWidth(0);
                        TBuscador.getColumn("ubi_codpro").setWidth(0);
                        TBuscador.getColumn("ubi_codpro").setMaxWidth(0);
                        TBuscador.getColumn("ubi_coddistri").setPreferredWidth(0);
                        TBuscador.getColumn("ubi_coddistri").setMinWidth(0);
                        TBuscador.getColumn("ubi_coddistri").setWidth(0);
                        TBuscador.getColumn("ubi_coddistri").setMaxWidth(0);
                        TBuscador.getColumn("pai_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("pai_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("pai_ncodigo").setWidth(0);
                        TBuscador.getColumn("pai_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
                        TBuscador.getColumn("Direccion").setMinWidth(200);
                        TBuscador.getColumn("Direccion").setWidth(200);
                        TBuscador.getColumn("Direccion").setMaxWidth(200);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 9://----------------------------------------------------------------Parametro
//                        _bparametro = new BParametro();                        
//                        _lsparametro =_bparametro.AccionObtenerTodosParametro();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                            {  return canEdit[columnIndex];}
                        };
                        columname = new Object[6];
                        columname[0]="par_ncodigo";
                        columname[1]="Simbolo";
                        columname[2]="Usuario";                        
                        columname[3]="Alias";
                        columname[4]="Direccion";
                        columname[5]="par_nsucursal";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lsparametro.size()-1;i++)
//                        {
//                            rowData[0]=_lsparametro.get(i).getPar_ncodigo();
//                            rowData[1]=_lsparametro.get(i).getMon_cdescripcion();
//                            rowData[2]=_lsparametro.get(i).getVen_cnombre();
//                            rowData[3]=_lsparametro.get(i).getSuc_calias();
//                            rowData[4]=_lsparametro.get(i).getSuc_cdireccion();
//                            rowData[5]=_lsparametro.get(i).getPar_nsucursal();
//                            
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("par_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("par_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("par_ncodigo").setWidth(0);
                        TBuscador.getColumn("par_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("par_nsucursal").setPreferredWidth(0);
                        TBuscador.getColumn("par_nsucursal").setMinWidth(0);
                        TBuscador.getColumn("par_nsucursal").setWidth(0);
                        TBuscador.getColumn("par_nsucursal").setMaxWidth(0);
                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
                        TBuscador.getColumn("Direccion").setMinWidth(200);
                        TBuscador.getColumn("Direccion").setWidth(200);
                        TBuscador.getColumn("Direccion").setMaxWidth(200);
                        TBuscador.getColumn("Usuario").setPreferredWidth(200);
                        TBuscador.getColumn("Usuario").setMinWidth(200);
                        TBuscador.getColumn("Usuario").setWidth(200);
                        TBuscador.getColumn("Usuario").setMaxWidth(200);
                        TBuscador.getColumn("Alias").setPreferredWidth(120);
                        TBuscador.getColumn("Alias").setMinWidth(120);
                        TBuscador.getColumn("Alias").setWidth(120);
                        TBuscador.getColumn("Alias").setMaxWidth(120);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 10://------------------------------------------------------------Lista Factura para emitir notas de credito
//                        _bfactura = new BFactura();                        
//                        _efacturaitem =_bfactura.ObtenerTodoxSerieandNumero(getFac_serie(),getFac_numero());
                        modelo = new DefaultTableModel(){
                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                        columname = new Object[19];
                        columname[0]="Interno";
                        columname[1]="Fec. Emision";
                        columname[2]="Serie-numero";
                        columname[3]="Documento";
                        columname[4]="Estado";                        
                        columname[5]="Pago";
                        columname[6]="Moneda";
                        columname[7]="Cliente";
                        columname[8]="Subtoal";
                        columname[9]="Total";
                        columname[10]="Exonerado";
                        columname[11]="inafecto";
                        columname[12]="Vendedor";
                        columname[13]="cli_ncodigo";
                        columname[14]="ley_ncodigo";
                        columname[15]="fac_cclasepago";
                        columname[16]="doc_ccodigo";
                        columname[17]="mon_ncodigo";
                        columname[18]="ven_ncodigo";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[20];
////                        for (int i=0;i<=_efacturaitem.size()-1;i++)
////                        {
//                            rowData[0]=_efacturaitem.getFac_ncodigo();
//                            rowData[1]=_efacturaitem.getFac_dfechaemision().toString();
//                            rowData[2]=_efacturaitem.getFac_cserie()+"-"+_efacturaitem.getFac_cnumero();
//                            rowData[3]=_efacturaitem.getFac_ctipodocumento();
//                            rowData[4]=_efacturaitem.getFac_estadodocumento();
//                            rowData[5]=_efacturaitem.getFac_cclasedepagodocumento();
//                            rowData[6]=_efacturaitem.getFac_cmondocumento();
//                            rowData[7]=_efacturaitem.getFac_cnombrecliente();
//                            rowData[8]=_efacturaitem.getFac_fimportesubtotal();
//                            rowData[9]=_efacturaitem.getFac_ftotal();
//                            rowData[10]=_efacturaitem.getFac_ftotalexonerado();
//                            rowData[11]=_efacturaitem.getFac_ftotalinafecto();
//                            rowData[12]=_efacturaitem.getFac_nombrevendedor();
//                            rowData[13]=_efacturaitem.getCli_ncodigo();
//                            rowData[14]=_efacturaitem.getLey_ncodigo();
//                            rowData[15]=_efacturaitem.getFac_cclasepago();
//                            rowData[16]=_efacturaitem.getDoc_ccodigo();
//                            rowData[17]=_efacturaitem.getMon_ccodigo();
//                            rowData[18]=_efacturaitem.getVe_ncodigo();
//                            
//                            modelo.addRow(rowData);
////                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 11://----------------------------------BuscarCliente desde la factura por numero de documento
//                        _bcliente = new BCliente();
//                        if(m_estado)
//                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "01");
//                        else
//                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "03");
                        //_lscliente =_bcliente.ObtenerTodos();
                        modelo = new DefaultTableModel()
                        {
                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  return canEdit[columnIndex];}
                        };
                        columname = new Object[6];
                        columname[0]="Codigo";
                        columname[1]="Razon Social /Nombres";
                        columname[2]="Documento";
                        columname[3]="Numero ";
                        columname[4]="Direccion";                        
                        columname[5]="TipoDocumento";
                        modelo.setColumnIdentifiers(columname);
//                        rowData = new Object[6];
//                        for (int i=0;i<=_lscliente.size()-1;i++)
//                        {
//                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
//                            rowData[1]=_lscliente.get(i).getCli_crazon();
//                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
//                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
//                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
//                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
//                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
                        TBuscador.getColumn("Codigo").setMinWidth(0);
                        TBuscador.getColumn("Codigo").setWidth(0);
                        TBuscador.getColumn("Codigo").setMaxWidth(0);
                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
                        TBuscador.getColumn("TipoDocumento").setWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
                        rdocodigo.setVisible(true);
                        rdonombre.setVisible(true);
                        rdonombre.setSelected(true);
                        break;
                }
            TBuscador.setShowHorizontalLines(true);
            TBuscador.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}

    }
    private void CargarContendoTabla()
    {
        try{
//            Object[] columname;
//            DefaultTableModel modelo;
            switch  (m_tipo)
                {
                    case 1://------------------------------------------- buscar cliente se invoca desde el
                        _bcliente = new BCliente();                        
                        _lscliente =_bcliente.ObtenerTodos();
                        Object[] rowData = new Object[7];
                        for (int i=0;i<=_lscliente.size()-1;i++)
                        {
                            rowData[0]=_lscliente.get(i).getCli_ncodigo().toString();
                            rowData[1]=_lscliente.get(i).getCli_crazon();
                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();
                            JButton _verboton=new JButton("ver");
                            rowData[6]=_verboton;
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
                        TBuscador.getColumn("Codigo").setMinWidth(0);
                        TBuscador.getColumn("Codigo").setWidth(0);
                        TBuscador.getColumn("Codigo").setMaxWidth(0);
                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
                        TBuscador.getColumn("TipoDocumento").setWidth(0);
                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
//                        TBuscador.setDefaultRenderer(JButton.class, new TableCellRenderer() {
//                            @Override
//                            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                                return (Component) value;
//                            }
//                        });
//                        TBuscador.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                int fila = TBuscador.rowAtPoint(e.getPoint());
//                int columna = TBuscador.columnAtPoint(e.getPoint());
//                /**
//                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
//                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
//                 */
//                if (TBuscador.getModel().getColumnClass(columna).equals(JButton.class)) {
//                    /**
//                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
//                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
//                     */
//                    StringBuilder sb = new StringBuilder();
////                    for (int i = 0; i < TBuscador.getModel().getColumnCount(); i++) {
////                        if (!TBuscador.getModel().getColumnClass(i).equals(JButton.class)) {
////                            {
////                                  //sb.append("\n").append(TBuscador.getModel().getColumnName(i)).append(": ").append(TBuscador.getModel().getValueAt(fila, i));
//////                                
////                                
////                            }
////                         }
////                    }
//                                    String _codigo=TBuscador.getModel().getValueAt(fila, 0).toString();
//                                    Object [] vector=null;
//                                    if(!_codigo.equals(""))
//                                    {
//                                        BPlaca _bplaca =new BPlaca();
//                                        List<EPlaca> _lsplaca=_bplaca.AccionObtenerTodoxCodigoCliente_ClienteMantenimeinto(Integer.parseInt(_codigo));
//
//                                        if(_lsplaca.size()>0)
//                                        {
//                                             vector=_lsplaca.stream().map(x->x.getPla_cnombre()).collect(Collectors.toList()).toArray();
//                                        }
//                                        else
//                                        {    vector =new Object[1];
//                                             vector[0]="No hay Placas";
//                                        }
//                                    }else
//                                    {
//                                        vector =new Object[1];
//                                        vector[0]="No hay Placas";
//                                    }
//                                    JOptionPane.showMessageDialog(null, new JList(vector) );
//                                }
//                            }
//                    });
                        
                    break;                        
                    case 2://---------------------------------------------------------------Articulo
                        _barticulo = new BArticulo();
                        _lsearticulo =_barticulo.ObtenerTodos();
//                        modelo = new DefaultTableModel(){ boolean[] canEdit = new boolean[]{false,false,false,false,false,false };
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Articulo";
//                        columname[2]="Codunidad";
//                        columname[3]="Codigo";
//                        columname[4]="Cod.Barra";                        
//                        columname[5]="Unidad";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[6];
                        for (int i=0;i<=_lsearticulo.size()-1;i++)
                        {
                            rowData[0]=_lsearticulo.get(i).getArt_ncodigo();
                            rowData[1]=_lsearticulo.get(i).getArt_cdescripcion();
                            rowData[2]=_lsearticulo.get(i).getUni_ncodigo();
                            rowData[3]=_lsearticulo.get(i).getArt_ccodigo();
                            rowData[4]=_lsearticulo.get(i).getArt_ccodbarra();
                            rowData[5]=_lsearticulo.get(i).getUni_cdescripcion();
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("Codunidad").setPreferredWidth(0);
//                        TBuscador.getColumn("Codunidad").setMinWidth(0);
//                        TBuscador.getColumn("Codunidad").setWidth(0);
//                        TBuscador.getColumn("Codunidad").setMaxWidth(0);
                    break;
                    case 3://------------------------------------------------------Cliente
                        _bcliente = new BCliente();                        
                        _lscliente =_bcliente.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Razon Social /Nombres";
//                        columname[2]="Documento";
//                        columname[3]="Numero ";
//                        columname[4]="Direccion";                        
//                        columname[5]="TipoDocumento";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[6];
                        for (int i=0;i<=_lscliente.size()-1;i++)
                        {
                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
                            rowData[1]=_lscliente.get(i).getCli_crazon();
                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
                            modelo.addRow(rowData);
                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
                        
                        break;
                    case 4://--------------------------------------------------------------lista de precios detalle para la factura
                        _bprecioventa = new BPrecioVenta();                        
                        _lseprecioventa =_bprecioventa.AcctionDetalle();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[10];
//                        columname[0]="codigo";
//                        columname[1]="Producto";
//                        columname[2]="Unidad";
//                        columname[3]="Moneda";
//                        columname[4]="Tipo Precio";                        
//                        columname[5]="V. Unitario";
//                        columname[6]="V. Venta";
//                        columname[7]="Afectacón";                        
//                        columname[8]="unicodigo";
//                        columname[9]="artcodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[11];
                        for (int i=0;i<=_lseprecioventa.size()-1;i++)
                        {
                            rowData[0]=_lseprecioventa.get(i).getPve_ncodigo();
                            rowData[1]=_lseprecioventa.get(i).getArt_cdescripcion();
                            rowData[2]=_lseprecioventa.get(i).getArt_ccodigoArticulo();                            
                            rowData[3]=_lseprecioventa.get(i).getUni_cdescripcion();
                            rowData[4]=_lseprecioventa.get(i).getPve_cmoneda();
                            rowData[5]=_lseprecioventa.get(i).getPve_ctipoprecio();
                            rowData[6]=_lseprecioventa.get(i).getPve_fpreciounitario();
                            rowData[7]=_lseprecioventa.get(i).getPve_fprecioventa();
                            rowData[8]=_lseprecioventa.get(i).getArt_cafecdescripcion();
                            rowData[9]=_lseprecioventa.get(i).getUni_ccodigo();
                            rowData[10]=_lseprecioventa.get(i).getArt_ncodigo();
                            modelo.addRow(rowData);
                         }
//                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("codigo").setMinWidth(0);
//                        TBuscador.getColumn("codigo").setWidth(0);
//                        TBuscador.getColumn("codigo").setMaxWidth(0);
//                        TBuscador.getColumn("unicodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("unicodigo").setMinWidth(0);
//                        TBuscador.getColumn("unicodigo").setWidth(0);
//                        TBuscador.getColumn("unicodigo").setMaxWidth(0);
//                        TBuscador.getColumn("artcodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("artcodigo").setMinWidth(0);
//                        TBuscador.getColumn("artcodigo").setWidth(0);
//                        TBuscador.getColumn("artcodigo").setMaxWidth(0);
                        rdocodigo.setVisible(true);
                        rdocodigo.setVisible(true);
                        
                        break;
                    case 5://------------------------------------------------------------FACTURA
                        _bfactura = new BFactura();                        
                        _lsfactura =_bfactura.ObtenerTodo();
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                         columname = new Object[19];
//                        columname[0]="Interno";
//                        columname[1]="Fec. Emision";
//                        columname[2]="Serie-numero";
//                        columname[3]="Documento";
//                        columname[4]="Estado";                        
//                        columname[5]="Pago";
//                        columname[6]="Moneda";
//                        columname[7]="Cliente";
//                        columname[8]="Subtoal";
//                        columname[9]="Total";
//                        columname[10]="Exonerado";
//                        columname[11]="inafecto";
//                        columname[12]="Vendedor";
//                        columname[13]="cli_ncodigo";
//                        columname[14]="ley_ncodigo";
//                        columname[15]="fac_cclasepago";
//                        columname[16]="doc_ccodigo";
//                        columname[17]="mon_ncodigo";
//                        columname[18]="ven_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[20];
                        for (int i=0;i<=_lsfactura.size()-1;i++)
                        {
                            rowData[0]=_lsfactura.get(i).getFac_ncodigo();
                            rowData[1]=_lsfactura.get(i).getFac_dfechaemision().toString();
                            rowData[2]=_lsfactura.get(i).getFac_numerodocumento();
                            rowData[3]=_lsfactura.get(i).getFac_ctipodocumento();
                            rowData[4]=_lsfactura.get(i).getFac_estadodocumento();
                            rowData[5]=_lsfactura.get(i).getFac_cclasedepagodocumento();
                            rowData[6]=_lsfactura.get(i).getFac_cmondocumento();
                            rowData[7]=_lsfactura.get(i).getFac_cnombrecliente();
                            rowData[8]=_lsfactura.get(i).getFac_fimportesubtotal();
                            rowData[9]=_lsfactura.get(i).getFac_ftotal();
                            rowData[10]=_lsfactura.get(i).getFac_ftotalexonerado();
                            rowData[11]=_lsfactura.get(i).getFac_ftotalinafecto();
                            rowData[12]=_lsfactura.get(i).getFac_nombrevendedor();
                            rowData[13]=_lsfactura.get(i).getCli_ncodigo();
                            rowData[14]=_lsfactura.get(i).getLey_ncodigo();
                            rowData[15]=_lsfactura.get(i).getFac_cclasepago();
                            rowData[16]=_lsfactura.get(i).getDoc_ccodigo();
                            rowData[17]=_lsfactura.get(i).getMon_ccodigo();
                            rowData[18]=_lsfactura.get(i).getVe_ncodigo();
                            
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
                        
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // this.setSize(900, 450);
                        break;
                    case 6://-----------------------------------------------------------------Todos los descuentos configurados
                        _bdescuentocabecera = new BDescuentoCabecera();                        
                        _lsdescuentocabecera =_bdescuentocabecera.ObtenerTodo();
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                         columname = new Object[5];
//                        columname[0]="cds_ncodigo";
//                        columname[1]="Nombre";
//                        columname[2]="Alias";
//                        columname[3]="Direccion";
//                        columname[4]="suc_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[7];
                        for (int i=0;i<=_lsdescuentocabecera.size()-1;i++)
                        {
                            rowData[0]=_lsdescuentocabecera.get(i).getCds_ncodigo();
                            rowData[1]=_lsdescuentocabecera.get(i).getCds_cnombre();
                            rowData[2]=_lsdescuentocabecera.get(i).getSuc_calias();
                            rowData[3]=_lsdescuentocabecera.get(i).getSuc_cdireccion();
                            rowData[4]=_lsdescuentocabecera.get(i).getSuc_ncodigo();
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cds_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cds_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setMaxWidth(350);
//                        TBuscador.getColumn("Direccion").setMinWidth(350);
//                        TBuscador.getColumn("Direccion").setWidth(350);
//                        TBuscador.getColumn("Direccion").setMaxWidth(350);
//                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 7://---------------------------------------------------------------Vendedor
                        _bvendedor = new BVendedor();                        
                        _lsvendedor =_bvendedor.AccionObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[5];
//                        columname[0]="ven_ncodigo";
//                        columname[1]="Apellidos y Nombres";
//                        columname[2]="Documento";                        
//                        columname[3]="Numero";
//                        columname[4]="doi_ccodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[5];
                        for (int i=0;i<=_lsvendedor.size()-1;i++)
                        {
                            rowData[0]=_lsvendedor.get(i).getVen_ncodigo();
                            rowData[1]=_lsvendedor.get(i).getVen_cpaterno()+" "+_lsvendedor.get(i).getVen_materno()+" "+_lsvendedor.get(i).getVen_nombres();
                            rowData[2]=_lsvendedor.get(i).getDoi_cdescripcion();
                            rowData[3]=_lsvendedor.get(i).getVen_cnumero();
                            rowData[4]=_lsvendedor.get(i).getDoi_ccodigo();
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doi_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Apellidos y Nombres").setPreferredWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setMinWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setWidth(200);
//                        TBuscador.getColumn("Apellidos y Nombres").setMaxWidth(200);
                        break;
                    case 8://-----------------------------------------------------------Sucursal
                        _bsucursal = new BSucursal();                        
                        _lssucursal =_bsucursal.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[11];
//                        columname[0]="suc_ncodigo";
//                        columname[1]="Direccion";
//                        columname[2]="Alias";                        
//                        columname[3]="Departamento";
//                        columname[4]="Provincia";
//                        columname[5]="Distrito";
//                        columname[6]="Pais";
//                        columname[7]="ubi_ccoddepa";
//                        columname[8]="ubi_codpro";
//                        columname[9]="ubi_coddistri";
//                        columname[10]="pai_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[11];
                        for (int i=0;i<=_lssucursal.size()-1;i++)
                        {
                            rowData[0]=_lssucursal.get(i).getSuc_ncodigo();
                            rowData[1]=_lssucursal.get(i).getSuc_cdireccion();
                            rowData[2]=_lssucursal.get(i).getSuc_sucdescripcion();
                            rowData[3]=_lssucursal.get(i).getSuc_cdepartamento();
                            rowData[4]=_lssucursal.get(i).getSuc_cprovincia();
                            rowData[5]=_lssucursal.get(i).getSuc_cdistrito();
                            rowData[6]=_lssucursal.get(i).getSuc_cpais();
                            rowData[7]=_lssucursal.get(i).getSuc_coddepa();
                            rowData[8]=_lssucursal.get(i).getSuc_codprov();
                            rowData[9]=_lssucursal.get(i).getSuc_coddistri();
                            rowData[10]=_lssucursal.get(i).getPai_ncodigo();
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("suc_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setWidth(0);
//                        TBuscador.getColumn("suc_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setMinWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setWidth(0);
//                        TBuscador.getColumn("ubi_ccoddepa").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setMinWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setWidth(0);
//                        TBuscador.getColumn("ubi_codpro").setMaxWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setPreferredWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setMinWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setWidth(0);
//                        TBuscador.getColumn("ubi_coddistri").setMaxWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setWidth(0);
//                        TBuscador.getColumn("pai_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
//                        TBuscador.getColumn("Direccion").setMinWidth(200);
//                        TBuscador.getColumn("Direccion").setWidth(200);
//                        TBuscador.getColumn("Direccion").setMaxWidth(200);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 9://----------------------------------------------------------------Parametro
                        _bparametro = new BParametro();                        
                        _lsparametro =_bparametro.AccionObtenerTodosParametro();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                            {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="par_ncodigo";
//                        columname[1]="Simbolo";
//                        columname[2]="Usuario";                        
//                        columname[3]="Alias";
//                        columname[4]="Direccion";
//                        columname[5]="par_nsucursal";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[6];
                        for (int i=0;i<=_lsparametro.size()-1;i++)
                        {
                            rowData[0]=_lsparametro.get(i).getPar_ncodigo();
                            rowData[1]=_lsparametro.get(i).getMon_cdescripcion();
                            rowData[2]=_lsparametro.get(i).getVen_cnombre();
                            rowData[3]=_lsparametro.get(i).getSuc_calias();
                            rowData[4]=_lsparametro.get(i).getSuc_cdireccion();
                            rowData[5]=_lsparametro.get(i).getPar_nsucursal();
                            
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("par_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setWidth(0);
//                        TBuscador.getColumn("par_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setPreferredWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setMinWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setWidth(0);
//                        TBuscador.getColumn("par_nsucursal").setMaxWidth(0);
//                        TBuscador.getColumn("Direccion").setPreferredWidth(200);
//                        TBuscador.getColumn("Direccion").setMinWidth(200);
//                        TBuscador.getColumn("Direccion").setWidth(200);
//                        TBuscador.getColumn("Direccion").setMaxWidth(200);
//                        TBuscador.getColumn("Usuario").setPreferredWidth(200);
//                        TBuscador.getColumn("Usuario").setMinWidth(200);
//                        TBuscador.getColumn("Usuario").setWidth(200);
//                        TBuscador.getColumn("Usuario").setMaxWidth(200);
//                        TBuscador.getColumn("Alias").setPreferredWidth(120);
//                        TBuscador.getColumn("Alias").setMinWidth(120);
//                        TBuscador.getColumn("Alias").setWidth(120);
//                        TBuscador.getColumn("Alias").setMaxWidth(120);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 10://------------------------------------------------------------Lista Factura para emitir notas de credito
                        _bfactura = new BFactura();                        
                        _efacturaitem =_bfactura.ObtenerTodoxSerieandNumero(getFac_serie(),getFac_numero());
//                        modelo = new DefaultTableModel(){
//                             boolean[] canEdit = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };
//                            @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[19];
//                        columname[0]="Interno";
//                        columname[1]="Fec. Emision";
//                        columname[2]="Serie-numero";
//                        columname[3]="Documento";
//                        columname[4]="Estado";                        
//                        columname[5]="Pago";
//                        columname[6]="Moneda";
//                        columname[7]="Cliente";
//                        columname[8]="Subtoal";
//                        columname[9]="Total";
//                        columname[10]="Exonerado";
//                        columname[11]="inafecto";
//                        columname[12]="Vendedor";
//                        columname[13]="cli_ncodigo";
//                        columname[14]="ley_ncodigo";
//                        columname[15]="fac_cclasepago";
//                        columname[16]="doc_ccodigo";
//                        columname[17]="mon_ncodigo";
//                        columname[18]="ven_ncodigo";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[20];
//                        for (int i=0;i<=_efacturaitem.size()-1;i++)
//                        {
                            rowData[0]=_efacturaitem.getFac_ncodigo();
                            rowData[1]=_efacturaitem.getFac_dfechaemision().toString();
                            rowData[2]=_efacturaitem.getFac_cserie()+"-"+_efacturaitem.getFac_cnumero();
                            rowData[3]=_efacturaitem.getFac_ctipodocumento();
                            rowData[4]=_efacturaitem.getFac_estadodocumento();
                            rowData[5]=_efacturaitem.getFac_cclasedepagodocumento();
                            rowData[6]=_efacturaitem.getFac_cmondocumento();
                            rowData[7]=_efacturaitem.getFac_cnombrecliente();
                            rowData[8]=_efacturaitem.getFac_fimportesubtotal();
                            rowData[9]=_efacturaitem.getFac_ftotal();
                            rowData[10]=_efacturaitem.getFac_ftotalexonerado();
                            rowData[11]=_efacturaitem.getFac_ftotalinafecto();
                            rowData[12]=_efacturaitem.getFac_nombrevendedor();
                            rowData[13]=_efacturaitem.getCli_ncodigo();
                            rowData[14]=_efacturaitem.getLey_ncodigo();
                            rowData[15]=_efacturaitem.getFac_cclasepago();
                            rowData[16]=_efacturaitem.getDoc_ccodigo();
                            rowData[17]=_efacturaitem.getMon_ccodigo();
                            rowData[18]=_efacturaitem.getVe_ncodigo();
                            
                            modelo.addRow(rowData);
//                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("cli_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setWidth(0);
//                        TBuscador.getColumn("cli_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ley_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setPreferredWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMinWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setWidth(0);
//                        TBuscador.getColumn("fac_cclasepago").setMaxWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMinWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setWidth(0);
//                        TBuscador.getColumn("doc_ccodigo").setMaxWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setWidth(0);
//                        TBuscador.getColumn("mon_ncodigo").setMaxWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setPreferredWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMinWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setWidth(0);
//                        TBuscador.getColumn("ven_ncodigo").setMaxWidth(0);
                        TBuscador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        break;
                    case 11://----------------------------------BuscarCliente desde la factura por numero de documento
                        _bcliente = new BCliente();
                        if(m_estado)
                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "01");
                        else
                            _lscliente =_bcliente.ListarAcctionFiltrarClientexNombreCliente("", "03");
                        //_lscliente =_bcliente.ObtenerTodos();
//                        modelo = new DefaultTableModel()
//                        {
//                             boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
//                        @Override public boolean isCellEditable(int rowIndex,int columnIndex)
//                        {  return canEdit[columnIndex];}
//                        };
//                        columname = new Object[6];
//                        columname[0]="Codigo";
//                        columname[1]="Razon Social /Nombres";
//                        columname[2]="Documento";
//                        columname[3]="Numero ";
//                        columname[4]="Direccion";                        
//                        columname[5]="TipoDocumento";
//                        modelo.setColumnIdentifiers(columname);
                        rowData = new Object[6];
                        for (int i=0;i<=_lscliente.size()-1;i++)
                        {
                            rowData[0]=_lscliente.get(i).getCli_ncodigo();
                            rowData[1]=_lscliente.get(i).getCli_crazon();
                            rowData[2]=_lscliente.get(i).getDoi_cdescripcion();
                            rowData[3]=_lscliente.get(i).getCli_cnumerodoc();
                            rowData[4]=_lscliente.get(i).getCli_cdireccionfiscal();
                            rowData[5]=_lscliente.get(i).getCoi_ccodigo();                            
                            modelo.addRow(rowData);
                         }
                        TBuscador.setModel(modelo);
//                        TBuscador.getColumn("Codigo").setPreferredWidth(0);
//                        TBuscador.getColumn("Codigo").setMinWidth(0);
//                        TBuscador.getColumn("Codigo").setWidth(0);
//                        TBuscador.getColumn("Codigo").setMaxWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setPreferredWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMinWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setWidth(0);
//                        TBuscador.getColumn("TipoDocumento").setMaxWidth(0);
                        
                        break;
                }
            TBuscador.setShowHorizontalLines(true);
            TBuscador.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
        
    }
}

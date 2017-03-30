package Principal;

import AccessoDato.EMoneda;
import AccessoDato.ENumero;
import AccessoDato.EParametro;
import AccessoDato.ESucursal;
import AccessoDato.EVendedor;
import Negocio.BMoneda;
import Negocio.BNumero;
import Negocio.BParametro;
import Negocio.BSucursal;
import Negocio.BVendedor;
import Utilidad.DisplayValue;
import Utilidad.InstanciaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmParametro extends javax.swing.JInternalFrame {
    private static FrmParametro m_frmparametro;
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public String m_Codigo;
    private BSucursal _bsucursal;
    private  ESucursal _esucursal;
    private List<ESucursal> _lssucursal;
    private Vector _items;
    private DefaultComboBoxModel _modelo=null;
    private EParametro _eparametro;
    private BParametro _bparametro;
    private List<EMoneda> _lsemoneda;
    private EMoneda _emoneda;
    private BMoneda _bmoneda;
    private DefaultComboBoxModel modelotipomoneda;
    private DefaultComboBoxModel modelovendedor;
    private List<ENumero> _lsnumero=new ArrayList<>();
    private BNumero _bnumero;
    private BVendedor _bvendedor;
    private List<EVendedor> _lsvendedor;
    private int posicion=-1;
    
    Dimension desktopSize; 
    Dimension Internal;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ENumero _enumero;
    private String _nombreSucursal;
    private FrmParametro() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnnuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbmoneda = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbsucursal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttipocambio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbvendedor = new javax.swing.JComboBox<>();
        txtemision = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleNumero = new javax.swing.JTable();
        btnagregaritem = new javax.swing.JButton();
        btneliminaritem = new javax.swing.JButton();
        btnmodificaritem = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Parametros");
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

        btnnuevo.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\folder_new.png")); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setFocusable(false);
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnnuevo);

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

        btnDeshacer.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\limpiar.png")); // NOI18N
        btnDeshacer.setText("Deshacer");
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\pencil.png")); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\search.png")); // NOI18N
        btnBuscar.setText("Buscar");
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

        jLabel1.setText("Fecha:");

        jLabel2.setText("Moneda");

        cmbmoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Sucursal");

        cmbsucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbsucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsucursalActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo Cambio");

        txttipocambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttipocambioKeyTyped(evt);
            }
        });

        jLabel6.setText("Vendedor");

        cmbvendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Emision");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbmoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtemision)
                            .addComponent(cmbvendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttipocambio, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbmoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttipocambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        detalleNumero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detalleNumero);

        btnagregaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\additem.png")); // NOI18N
        btnagregaritem.setHideActionText(true);
        btnagregaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregaritemActionPerformed(evt);
            }
        });

        btneliminaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\removeitem.png")); // NOI18N
        btneliminaritem.setHideActionText(true);
        btneliminaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminaritemActionPerformed(evt);
            }
        });

        btnmodificaritem.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\modifyitem.png")); // NOI18N
        btnmodificaritem.setHideActionText(true);
        btnmodificaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificaritemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregaritem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificaritem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminaritem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnagregaritem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnmodificaritem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminaritem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(Validar())
            {
             _bparametro = new BParametro();
             GetItem();
             if(_bparametro.Guardar(_eparametro, _lsnumero))
             {
                 JOptionPane.showMessageDialog(null, "Cambios guardados", "Parametro",JOptionPane.INFORMATION_MESSAGE);
                  _lsnumero.clear();
             }
             else
                JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Parametro",JOptionPane.INFORMATION_MESSAGE);
             m_Tipoinstancia=InstanciaForm.UNCHANGUE;
             ClearForm();
             EstablecerInstancia();
             
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);  }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
            ClearForm();
            m_Tipoinstancia=InstanciaForm.UNCHANGUE;
            EstablecerInstancia();
    }//GEN-LAST:event_btnDeshacerActionPerformed
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try
        {
           m_Tipoinstancia=InstanciaForm.MODIFY;
           _eparametro.setM_instancia(InstanciaEntidad.MODIFY);
           EstablecerInstancia();
        }catch(Exception e){}
    }//GEN-LAST:event_btnEditarActionPerformed
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {
            FrmBuscar _buscar = new FrmBuscar(9,this);
            m_escritorio.add(_buscar);
            _buscar.show();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        try {
                _bvendedor= new BVendedor();
                _lsvendedor=_bvendedor.ObtenerTodos();
                CargarSucursal(false);
//                _bsucursal = new BSucursal();
//                _lssucursal=_bsucursal.ObtenerTodosNoAsignados();
                _bmoneda= new BMoneda();
                _lsemoneda=_bmoneda.ObtenerTodos(); 
//                cmbsucursal.removeAllItems();
                _items = new Vector();
//                _items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
//                for (int i=0;i<=_lssucursal.size()-1;i++)//---------------------------------------------Cargando Sucursal
//                    _items.addElement(new DisplayValue(_lssucursal.get(i).getSuc_sucdescripcion(), _lssucursal.get(i).getSuc_ncodigo()));
//                _modelo = new DefaultComboBoxModel(_items);
//                cmbsucursal.setModel(_modelo);
                cmbmoneda.removeAllItems();        
                _items = new Vector();
                _items.addElement(new DisplayValue("Seleccione Moneda", "-1"));
                for (int i=0;i<=_lsemoneda.size()-1;i++)//----------------------------------------------Cargando Moneda
                  _items.addElement(new DisplayValue(_lsemoneda.get(i).getMon_csimbolo(), _lsemoneda.get(i).getMon_ncodigo()));
                modelotipomoneda = new DefaultComboBoxModel(_items);                              
                cmbmoneda.setModel(modelotipomoneda);
                cmbvendedor.removeAllItems();
                _items = new Vector();
                _items.addElement(new DisplayValue("Seleccione Vendedor", "-1"));
                for (int i=0;i<=_lsvendedor.size()-1;i++)//---------------------------------------------Cargando Vendedor
                   _items.addElement(new DisplayValue(_lsvendedor.get(i).getVen_cpaterno()+"-"+_lsvendedor.get(i).getVen_nombres(), _lsvendedor.get(i).getVen_ncodigo()));
                modelovendedor = new DefaultComboBoxModel(_items);                              
                cmbvendedor.setModel(modelovendedor);
               EstablecerInstancia();//-----------------------------------------------------------------Cargando Instancia
               DefinirTabla();//------------------------------------------------------------------------Definiendo cabecera Tabla
               txtemision.setDocument(new JTextFielCharLimit(MaximoCharacter.StrEmisionSimple));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened
    private void cmbsucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsucursalActionPerformed
        try
        {
//            if(cmbsucursal.getSelectedIndex()>0)
//            {
//                DisplayValue _valor = ((DisplayValue)cmbsucursal.getSelectedItem());
//                _nombreSucursal=(_valor.displayMeneber.toString());
//                _esucursal = _lssucursal.stream().filter(s -> s.getSuc_ncodigo() ==Integer.parseInt(_valor.getValueMenber())).findFirst().orElse(null);
//                if(_esucursal!=null){
//                    _bparametro= new BParametro();
//                    float _tipocambio=_eparametro.getPar_ntipocambio();//==0?0.0:_eparametro.getPar_ntipocambio();
//                    txttipocambio.setText(String.valueOf(_tipocambio));
//                }
//            }
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, "Error cargando:"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE); }
    }//GEN-LAST:event_cmbsucursalActionPerformed
    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
            m_Tipoinstancia= InstanciaForm.NEW;
            ClearForm();
            EstablecerInstancia();
    }//GEN-LAST:event_btnnuevoActionPerformed
    FrmNumero frmnumero;
    private void btnagregaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregaritemActionPerformed
       try
        {
            if(ValidarAgregarItem())
            { OpenFrm();  }
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE); }
    }//GEN-LAST:event_btnagregaritemActionPerformed
    private boolean ValidarAgregarItem()
    {
        try {
            if(cmbsucursal.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null,"Seleccione sucursal.","Mensaje",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    private void OpenFrm()
    {
            try {
                    frmnumero = FrmNumero.getinstancia(this);
                    frmnumero.m_Tipoinstancia=InstanciaForm.NEW;
                    frmnumero.m_escritorio=m_escritorio;
                    desktopSize = m_escritorio.getSize();
                    Internal = frmnumero.getSize();
                    frmnumero.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
  
//                    _enumero= new ENumero();
//                    _enumero.setM_instancia(InstancaEntidad.NEW);
//                    _enumero.setSuc_calias(_nombreSucursal);
                    if(!m_escritorio.isAncestorOf(frmnumero))
                    {
                        m_escritorio.add(frmnumero);
//                        frmnumero.setEnumero(_enumero);
//                        frmnumero.setFrmparametro(m_frmparametro);
                    }
                    else
                    {   
                         m_escritorio.setSelectedFrame(frmnumero);
                         frmnumero.show();
//                        desktopSize = m_escritorio.getSize();
//                        Internal = frmnumero.getSize();
//                        frmnumero.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
//                        frmnumero.setEnumero(_enumero);
                    }
                    frmnumero.setVisible(true);
                    frmnumero.setSelected(true); 
        } catch (Exception e) {
        }
    }
    private void btneliminaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminaritemActionPerformed
        try {
            int _filaseleccionada=detalleNumero.getSelectedRow();
            if(_filaseleccionada>=0)
            {
                 String _codigo=(String) detalleNumero.getValueAt(_filaseleccionada, 0);
                 String _descripcion=(String) detalleNumero.getValueAt(_filaseleccionada, 1);
                  if(!"".equals(_codigo))
                   {  
                       if(!_bnumero.VerificarAsignacionNumero(Integer.parseInt(_codigo)))
                       {
                           for(int i=0;i<=_lsnumero.size()-1;i++)
                           {
                               _enumero=_lsnumero.get(i);
                               if(_enumero.getNum_cnumero().equals(_descripcion))
                                   _lsnumero.remove(i);
                           }
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Esta direccion esta asignada no se puede eliminar", "Mensaje",JOptionPane.WARNING_MESSAGE);
                       }
                       
                   }
                   else
                   {
                       for(int i=0;i<=_lsnumero.size()-1;i++)
                       {
                           _enumero=_lsnumero.get(i);
                           if(_enumero.getNum_ncodigo()==Integer.parseInt(_codigo))
                           {
                               _enumero.setM_instancia(InstanciaEntidad.DELETE);
                               _lsnumero.set(i, _enumero);
                           }
                       }
                   }
                   ((DefaultTableModel)detalleNumero.getModel()).removeRow(_filaseleccionada);       

            }
            else
            {
               JOptionPane.showMessageDialog(null, "Seleccione una Fila", "Mensaje",JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btneliminaritemActionPerformed
    private void btnmodificaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificaritemActionPerformed
        try {
            int _filaseleccionada=detalleNumero.getSelectedRow();
            if(_filaseleccionada>=0)
            {
                posicion=-1;
                frmnumero =FrmNumero.getinstancia(this);
                int _codigo=0;
                String instancia=detalleNumero.getValueAt(_filaseleccionada, 4).toString();
                if(instancia.equals(""+InstanciaEntidad.UNCHANGUE)|| instancia.equals(""+InstanciaEntidad.MODIFY))
                {
                    _codigo=Integer.parseInt(detalleNumero.getValueAt(_filaseleccionada, 0).toString());
                    _enumero=_bnumero.AccionObtenerUnNumero(_codigo);
                }
                else
                {
                    _enumero=new ENumero();
                    _enumero.setNum_cnumero("");
                    _enumero.setNum_cserie("2");
                    _enumero.setM_instancia(InstanciaEntidad.NEW);
                    posicion=_filaseleccionada;
                }
                frmnumero.m_Tipoinstancia=instancia.equals(""+InstanciaEntidad.NEW)?InstanciaForm.NEW:InstanciaForm.MODIFY;
                frmnumero.m_escritorio=m_escritorio;
                desktopSize = m_escritorio.getSize();
                Internal = frmnumero.getSize();
                frmnumero.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                if(!m_escritorio.isAncestorOf(frmnumero))  
                {
                    m_escritorio.add(frmnumero);
                    
                }else
                {
                    m_escritorio.setSelectedFrame(frmnumero);
                }
                frmnumero.setVisible(isIcon);
                frmnumero.setSelected(true);
                frmnumero.show();
                frmnumero.setEnumero(_enumero);
                frmnumero.CargarDato();
            }
            else
            {
            
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnmodificaritemActionPerformed

    private void txttipocambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttipocambioKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txttipocambioKeyTyped
    private void ClearForm()
    {
        txtfecha.setText("");
        txttipocambio.setText("");
        cmbmoneda.setSelectedIndex(0);
//        cmbsucursal.setSelectedIndex(0);
        cmbvendedor.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) detalleNumero.getModel();
        dtm.setNumRows(0);
        txtemision.setText("");
    }
    public void EstablecerInstancia()
    {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
                        cmbsucursal.setEnabled(true);
                        cmbmoneda.setEnabled(true);
                        cmbvendedor.setEnabled(true);
//                        txtfecha.setEnabled(true);
                        txttipocambio.setEnabled(true);
                        btnEditar.setEnabled(true);
                        btnGuardar.setEnabled(true);
                        btnDeshacer.setEnabled(true);
                        btneliminaritem.setEnabled(true);
                        btnmodificaritem.setEnabled(true);
                        btnagregaritem.setEnabled(true);
                        txtfecha.setText(dateFormat.format(sqlDate));
                        txtemision.setEnabled(true);
//                        CargarSucursal(true);
                        break;
                    case MODIFY :
                        cmbsucursal.setEnabled(false);
                        cmbmoneda.setEnabled(true);
                        cmbvendedor.setEnabled(true);
                        txtfecha.setEnabled(false);
                        txttipocambio.setEnabled(true);
                        btnEditar.setEnabled(true);
                        btnGuardar.setEnabled(true);
                        btnDeshacer.setEnabled(true);
                        btneliminaritem.setEnabled(true);
                        btnmodificaritem.setEnabled(true);
                        btnagregaritem.setEnabled(true);
                        txtfecha.setText(dateFormat.format(sqlDate));
                        btnnuevo.setEnabled(false);
                        txtemision.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        cmbsucursal.setEnabled(false);
                        cmbmoneda.setEnabled(false);
                        cmbvendedor.setEnabled(false);
                        txtfecha.setEnabled(false);
                        txttipocambio.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnGuardar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        txtfecha.setText(dateFormat.format(sqlDate));
                        btneliminaritem.setEnabled(false);
                        btnmodificaritem.setEnabled(false);
                        btnagregaritem.setEnabled(false);
                        txtemision.setEnabled(false);
                        btnnuevo.setEnabled(true);
                        break;
                }
    }
    private void DefinirTabla()
    {
        try
        {
            DefaultTableModel mdo = new DefaultTableModel()
            {//-----------------------------------------------------------------------DESABILITANDO COLUMNAS 
                boolean[] canEdit = new boolean[]{ false,false,false,false,false,false};
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                {  return canEdit[columnIndex];}
            };
            Object[] columname = new Object[8];
            columname[0]="Codigo";
            columname[1]="Serie";
            columname[2]="Numero";
            columname[3]="Sucursal";
            columname[4]="Documento"; 
            columname[5]="instancia";
            columname[6]="par_ncodigo";
            columname[7]="doc_ccodigo";
            mdo.setColumnIdentifiers(columname);   
            detalleNumero.setModel(mdo);
            HidenColumn();
            detalleNumero.setAutoResizeMode(detalleNumero.AUTO_RESIZE_OFF);
            detalleNumero.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {        }
    }
    private void HidenColumn()
    {
        try {
            detalleNumero.getColumn("Codigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("Codigo").setMinWidth(0);
            detalleNumero.getColumn("Codigo").setWidth(0);
            detalleNumero.getColumn("Codigo").setMaxWidth(0);
            detalleNumero.getColumn("par_ncodigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("par_ncodigo").setMinWidth(0);
            detalleNumero.getColumn("par_ncodigo").setWidth(0);
            detalleNumero.getColumn("par_ncodigo").setMaxWidth(0);
            detalleNumero.getColumn("doc_ccodigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("doc_ccodigo").setMinWidth(0);
            detalleNumero.getColumn("doc_ccodigo").setWidth(0);
            detalleNumero.getColumn("doc_ccodigo").setMaxWidth(0);
            detalleNumero.getColumn("instancia").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("instancia").setMinWidth(0);
            detalleNumero.getColumn("instancia").setWidth(0);
            detalleNumero.getColumn("instancia").setMaxWidth(0);
            detalleNumero.getColumn("Documento").setPreferredWidth(200);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("Documento").setMinWidth(200);
            detalleNumero.getColumn("Documento").setWidth(200);
            detalleNumero.getColumn("Documento").setMaxWidth(200);
            detalleNumero.getColumn("Sucursal").setPreferredWidth(200);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalleNumero.getColumn("Sucursal").setMinWidth(200);
            detalleNumero.getColumn("Sucursal").setWidth(200);
            detalleNumero.getColumn("Sucursal").setMaxWidth(200);
        } catch (Exception e) {
        }
    }
    public void CargarNumero()
    {
        try {
//            if(_enumero!=null)
//            {
                if(_enumero.getM_instancia()==InstanciaEntidad.NEW)
                {
                    _enumero.setSuc_calias(cmbsucursal.getItemAt(cmbsucursal.getSelectedIndex()));
                    if(posicion!=-1)
                    {
                        _lsnumero.set(posicion, _enumero);
                        posicion=-1;
                    }
                    else
                        _lsnumero.add(_enumero);
                
                }   
                else
                {
                    for(int i=0;i<=_lsnumero.size();i++)
                    {
                        if(_lsnumero.get(i).getNum_ncodigo()==_enumero.getNum_ncodigo())
                        {_lsnumero.set(i, _enumero);break;}
                    }
                }
                Load();
//            }
        } catch (Exception e) {
        }
    }
    private void Load()
    {
       try {
            DefaultTableModel dtm = (DefaultTableModel) detalleNumero.getModel();
            dtm.setNumRows(0);
            Object [] rowData = new Object[8];
            DefaultTableModel _mod = (DefaultTableModel) detalleNumero.getModel();
            for(int i=0;i<=_lsnumero.size()-1;i++){
                rowData[0]=_lsnumero.get(i).getNum_ncodigo();
                rowData[1]=_lsnumero.get(i).getNum_cserie();
                rowData[2]=_lsnumero.get(i).getNum_cnumero();
                rowData[3]=_lsnumero.get(i).getSuc_calias();
                rowData[4]=_lsnumero.get(i).getDoc_cdescripcion();
                rowData[5]=_lsnumero.get(i).getM_instancia();
                rowData[6]=_lsnumero.get(i).getPar_ncodigo();
                rowData[7]=_lsnumero.get(i).getDoc_ccodigo();
                _mod.addRow(rowData);
            } detalleNumero.setModel(_mod);
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error al agregar item :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }
    public static FrmParametro getinstance()
    {
        if(m_frmparametro==null)
            m_frmparametro= new FrmParametro();
        return m_frmparametro;
    }
    private boolean Validar()
    {
        try {
            
            if(txtemision.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un estado para las emisiones.","Registro Parametro",JOptionPane.WARNING_MESSAGE);
                txtemision.setFocusable(true);
                return false;
            }
            if(txttipocambio.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese tipo cambio.","Registro Parametro",JOptionPane.WARNING_MESSAGE);
                txttipocambio.setFocusable(true);
                return false;
            }
            if(cmbmoneda.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione moneda.","Registro Parametro",JOptionPane.WARNING_MESSAGE);
                cmbmoneda.setFocusable(true);
                return false;
            }
            if(cmbvendedor.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione vendedor.","Registro Parametro",JOptionPane.WARNING_MESSAGE);
                cmbvendedor.setFocusable(true);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    private void GetItem()
    {
        try {
            if(m_Tipoinstancia==InstanciaForm.NEW)
            {
                _eparametro= new EParametro();
                _eparametro.setM_instancia(InstanciaEntidad.NEW);
                _eparametro.setPar_ntipocambio(Float.parseFloat(txttipocambio.getText()));
                 _eparametro.setPar_dfecha(Date.valueOf(txtfecha.getText()));
                DisplayValue _valor=(DisplayValue)cmbsucursal.getSelectedItem();//----------------Obteniendo Sucursal
                _eparametro.setPar_nsucursal(Integer.parseInt(_valor.getValueMenber()));
                _valor=(DisplayValue)cmbvendedor.getSelectedItem();//------------------------------Obteniendo Vendedor
                _eparametro.setPar_nvendedor(Integer.parseInt(_valor.getValueMenber()));
                _valor=(DisplayValue)cmbmoneda.getSelectedItem();//---------------------------------Obteniendo Moneda
                _eparametro.setPar_cmoneda(_valor.getValueMenber());
                _eparametro.setPar_cestado(txtemision.getText());

            }else if(m_Tipoinstancia==InstanciaForm.MODIFY)
            {
                _eparametro.setPar_ntipocambio(Float.parseFloat(txttipocambio.getText()));
                 _eparametro.setPar_dfecha(Date.valueOf(txtfecha.getText()));
//                DisplayValue _valor=(DisplayValue)cmbsucursal.getSelectedItem();//----------------Obteniendo Sucursal
//                _eparametro.setPar_nsucursal(Integer.parseInt(_valor.getValueMenber()));
                DisplayValue _valor=(DisplayValue)cmbvendedor.getSelectedItem();//------------------------------Obteniendo Vendedor
                _eparametro.setPar_nvendedor(Integer.parseInt(_valor.getValueMenber()));
                _valor=(DisplayValue)cmbmoneda.getSelectedItem();//---------------------------------Obteniendo Moneda
                _eparametro.setPar_cmoneda(_valor.getValueMenber());
                _eparametro.setPar_cestado(txtemision.getText());
            }
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnagregaritem;
    private javax.swing.JButton btneliminaritem;
    private javax.swing.JButton btnmodificaritem;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbmoneda;
    private javax.swing.JComboBox<String> cmbsucursal;
    private javax.swing.JComboBox<String> cmbvendedor;
    private javax.swing.JTable detalleNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtemision;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txttipocambio;
    // End of variables declaration//GEN-END:variables

    void CargarParametro() {
        try {
            if(!m_Codigo.equals(""))
            {
                _bparametro = new BParametro();
                _eparametro=_bparametro.AccionObtenerxIdParametro(Integer.parseInt(m_Codigo));
                
                    
                    if(_eparametro!=null)
                    {
                        //CargandoSucursales()
                        CargarSucursal(true);
                        _bnumero = new BNumero();
                        _lsnumero=_bnumero.AccionObtenerxParametro(_eparametro.getPar_ncodigo());
                        txtfecha.setText(""+_eparametro.getPar_dfecha());
                        txttipocambio.setText(""+_eparametro.getPar_ntipocambio());
                        txtemision.setText(""+_eparametro.getPar_cestado());
                        for(int i=0;i<=_modelo.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)_modelo.getElementAt(i);
                            if(_valor.getValueMenber().equals(String.valueOf(_eparametro.getPar_nsucursal())))
                            {
                                _modelo.setSelectedItem(_valor);
                            }
                        }
                        cmbsucursal.setModel(_modelo);
                        for(int i=0;i<=modelotipomoneda.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)modelotipomoneda.getElementAt(i);
                            if(_valor.getValueMenber().equals(String.valueOf(_eparametro.getPar_cmoneda())))
                            {
                                modelotipomoneda.setSelectedItem(_valor);
                            }
                        }
                        cmbmoneda.setModel(modelotipomoneda);
                        for(int i=0;i<=modelovendedor.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue)modelovendedor.getElementAt(i);
                            if(_valor.getValueMenber().equals(String.valueOf(_eparametro.getPar_nvendedor())))
                            {
                                modelovendedor.setSelectedItem(_valor);
                            }
                        }
                        cmbvendedor.setModel(modelovendedor);
                        DefaultTableModel dtm = (DefaultTableModel) detalleNumero.getModel();
                        dtm.setNumRows(0);
                        Object [] rowData = new Object[8];
                        DefaultTableModel _mod = (DefaultTableModel) detalleNumero.getModel();
                        for(int i=0;i<=_lsnumero.size()-1;i++){
                            rowData[0]=_lsnumero.get(i).getNum_ncodigo();
                            rowData[1]=_lsnumero.get(i).getNum_cserie();
                            rowData[2]=_lsnumero.get(i).getNum_cnumero();
                            rowData[3]=_lsnumero.get(i).getSuc_calias();
                            rowData[4]=_lsnumero.get(i).getDoc_cdescripcion();
                            rowData[5]=_lsnumero.get(i).getM_instancia();
                            rowData[6]=_lsnumero.get(i).getPar_ncodigo();
                            rowData[7]=_lsnumero.get(i).getDoc_ccodigo();
                            _mod.addRow(rowData);
                        } detalleNumero.setModel(_mod);
                    }
                
            }
            btnEditar.setEnabled(true);
            
        } catch (Exception e) {
        }
    }
    
    private void CargarSucursal(boolean  x_estado)
    {
        try
        {
            _bsucursal = new BSucursal();
            if(!x_estado)
                _lssucursal=_bsucursal.ObtenerTodosNoAsignados();
            else
                _lssucursal=_bsucursal.ObtenerTodos();
            cmbsucursal.removeAllItems();
            _items = new Vector();
            _items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
            for (int i=0;i<=_lssucursal.size()-1;i++)//---------------------------------------------Cargando Sucursal
                _items.addElement(new DisplayValue(_lssucursal.get(i).getSuc_sucdescripcion(), _lssucursal.get(i).getSuc_ncodigo()));
            _modelo = new DefaultComboBoxModel(_items);
            cmbsucursal.setModel(_modelo);
        }catch(Exception e)
        {}
    }

    public ENumero getEnumero() {
        return _enumero;
    }

    public void setEnumero(ENumero _enumero) {
        this._enumero = _enumero;
    }
}


package Principal;

import AccessoDato.EDescuentoCabecera;
import AccessoDato.EDescuentoFactura;
import AccessoDato.EDocumento;
import AccessoDato.ESucursal;
import Negocio.BDescuentoCabecera;
import Negocio.BDescuentoFactura;
import Negocio.BSucursal;
import Negocio.BTablasSolas;
import Utilidad.DisplayValue;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmDescuentosGlobales extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane panelPrincila;
    private BSucursal _bsucursal;
    private List<ESucursal> _lssucursal;
    private Vector _item;
    private DefaultComboBoxModel _modelosucursal;
    private DefaultComboBoxModel _modelodocumento;
    public String m_Codigo;
    private BDescuentoFactura _bdecuentofactura;
    private List<EDescuentoFactura> _lsdescuentofactura = new ArrayList<>();
    private EDescuentoFactura _edescuentofactura;
    private BTablasSolas _bdocumento;
    private List<EDocumento> _lsdocumento;
    private BDescuentoCabecera _bcabedes;
    private EDescuentoCabecera _edescuentocabecera;
    private FrmDescuentosGlobales() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuup = new javax.swing.JPopupMenu();
        menuitem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtporcentaje = new javax.swing.JTextField();
        cmbsucursal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbtipodocumento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalledescuento = new javax.swing.JTable();
        btnanadir = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();

        menuitem.setText("Editar");
        menuitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuitemMousePressed(evt);
            }
        });
        mnuup.add(menuitem);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Descuentos ");
        setToolTipText("");
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

        jLabel1.setText("Cantidad");

        jLabel2.setText("Porcentaje");

        jLabel3.setText("Sucursal");

        cmbsucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Documento");

        cmbtipodocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbtipodocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtporcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addComponent(txtcantidad)
                        .addComponent(cmbsucursal, 0, 166, Short.MAX_VALUE))
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbtipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
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

        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\delete.png")); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEliminar);

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

        detalledescuento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        detalledescuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detalledescuentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(detalledescuento);

        btnanadir.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\additem.png")); // NOI18N
        btnanadir.setText("Agregar");
        btnanadir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnanadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanadirActionPerformed(evt);
            }
        });

        btnquitar.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\removeitem.png")); // NOI18N
        btnquitar.setText("Quitar");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\modifyitem.png")); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnanadir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnanadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnquitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            m_Tipoinstancia= InstanciaForm.NEW;
            _lsdescuentofactura.clear();
            ClearForm();
            EstablecerInstancia();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try
        {
            if(ValidarIngresoCabecera())
            {
                if(InstanciaForm.NEW==m_Tipoinstancia)
                {
                    _edescuentocabecera= new EDescuentoCabecera();
                    _edescuentocabecera.setM_instancia(InstancaEntidad.NEW);
                    _edescuentocabecera.setCds_cnombre(txtdescuento.getText());
                    DisplayValue _valor=(DisplayValue)cmbsucursal.getSelectedItem();
                    _edescuentocabecera.setSuc_ncodigo(Integer.parseInt(_valor.getValueMenber()));
                }
                else if(InstanciaForm.MODIFY==m_Tipoinstancia)
                {
                    _edescuentocabecera.setM_instancia(InstancaEntidad.MODIFY);
                }
                if(_lsdescuentofactura.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Tiene que agregar un item.", "Descuentos",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //_bdecuentofactura = new BDescuentoFactura();//
                    if(_bcabedes.Guardar(_edescuentocabecera,_lsdescuentofactura))
                        JOptionPane.showMessageDialog(null, "Se guardaron los datos correctamente.", "Descuentos",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Descuentos",JOptionPane.INFORMATION_MESSAGE);
                    _lsdescuentofactura.clear();
                    _edescuentofactura=null;
                    _edescuentocabecera=null;
                    m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                    ClearForm();
                    EstablecerInstancia();
                }
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try
        {
            ClearForm();
            m_Tipoinstancia=InstanciaForm.UNCHANGUE;
            EstablecerInstancia();
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try
        {
            m_Tipoinstancia=InstanciaForm.MODIFY;
            EstablecerInstancia();
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try
        {
            FrmBuscar _buscar = new FrmBuscar(6,this);
            panelPrincila.add(_buscar);
            _buscar.show();
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try
        {
            _bcabedes = new BDescuentoCabecera();
            _bdocumento= new BTablasSolas();
            _lsdocumento=_bdocumento.ObtenerTodoDocumentos();
            cmbtipodocumento.removeAllItems();
             _item = new Vector();
             _item.addElement(new DisplayValue("Seleccione Documento", "-1"));
             for (int i=0;i<=_lsdocumento.size()-1;i++)
                _item.addElement(new DisplayValue(_lsdocumento.get(i).getDoc_cdescripcion(), _lsdocumento.get(i).getDoc_ccodigo()));
            _modelodocumento = new DefaultComboBoxModel(_item);
            cmbtipodocumento.setModel(_modelodocumento);
            _bsucursal= new BSucursal();
            _lssucursal=_bsucursal.ObtenerTodos();
            _item = new Vector();
            _item.addElement(new DisplayValue("Seleccione Sucursal", "-1"));
            for (int i=0;i<=_lssucursal.size()-1;i++)
                _item.addElement(new DisplayValue(_lssucursal.get(i).getSuc_sucdescripcion(), _lssucursal.get(i).getSuc_ncodigo()));
            _modelosucursal = new DefaultComboBoxModel(_item);
            cmbsucursal.setModel(_modelosucursal);
            DefinirTabla();
            EstablecerInstancia();
        }catch(Exception e)
        {}
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnanadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanadirActionPerformed
        try
        {
            DefaultTableModel _modeTable =(DefaultTableModel) detalledescuento.getModel();
            if(ValidarIngresoDetalle(_modeTable.getRowCount()))
            {
                if(_edescuentofactura!=null)
                {
                    if(_edescuentofactura.getM_instancia().equals(InstancaEntidad.MODIFY))
                    {
                        GetItem();
                        for (int i=0;i<=_lsdescuentofactura.size()-1;i++)
                        {
                            if(_lsdescuentofactura.get(i).getDsa_ncodigo()==_edescuentofactura.getDsa_ncodigo())
                                _lsdescuentofactura.set(i, _edescuentofactura);
                        }
                        BindinJtable();
                    }
                }
                else
                {
                    _edescuentofactura= new EDescuentoFactura();
                    _edescuentofactura.setM_instancia(InstancaEntidad.NEW);
                    GetItem();
                    _lsdescuentofactura.add(_edescuentofactura);
                    BindinJtable();
                }
                _edescuentofactura=null;
                btnGuardar.setEnabled(true);
                txtcantidad.setText("");
                txtporcentaje.setText("");
//                cmbsucursal.setSelectedIndex(0);
                cmbtipodocumento.setSelectedIndex(0);
            }
        }catch(Exception e)
        {}
    }//GEN-LAST:event_btnanadirActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
       try
       {
           int _filaselec=detalledescuento.getSelectedRow();
           if(_filaselec>=0)
           {
           
               String tipoInstnacia=detalledescuento.getValueAt(_filaselec, 5).toString();
               if(tipoInstnacia.equals("NEW"))
                   ((DefaultTableModel)detalledescuento.getModel()).removeRow(_filaselec);
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Seleccione fila a eliminar", "Mensaje",JOptionPane.WARNING_MESSAGE);
           }
       }catch(Exception e)
       {}
    }//GEN-LAST:event_btnquitarActionPerformed

    private void menuitemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuitemMousePressed
        try
        {
        }catch(Exception e)
        {}
    }//GEN-LAST:event_menuitemMousePressed

    private void detalledescuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detalledescuentoMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3)
        {
        }
    }//GEN-LAST:event_detalledescuentoMouseClicked

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
       try
       {
           if(detalledescuento.getSelectedRow()>=0)
           {
                int indice=detalledescuento.getSelectedRow();
                for(int i=0;i<=_lsdescuentofactura.size()-1;i++)
                {
                    if(Integer.parseInt(detalledescuento.getValueAt(indice, 0).toString())==_lsdescuentofactura.get(i).getDsa_ncodigo())
                    {
                        _edescuentofactura=_lsdescuentofactura.get(i);
                        _edescuentofactura.setM_instancia(InstancaEntidad.MODIFY);
                    }
                }
                SetItem();
                btnGuardar.setEnabled(false);
           }
           else
           {
           JOptionPane.showMessageDialog(null, "Seleccion una fila primero.", "Mensaje",JOptionPane.WARNING_MESSAGE);
           }
       }catch(Exception e)
       {}
    }//GEN-LAST:event_btnmodificarActionPerformed
    private void ClearForm()
    {
        try
        {   txtdescuento.setText("");
            txtcantidad.setText("");
            txtporcentaje.setText("");
            cmbsucursal.setSelectedIndex(0);
            DefaultTableModel dtm = (DefaultTableModel) detalledescuento.getModel();
            dtm.setNumRows(0);
        }catch(Exception e)
        {}
    }
    private boolean  ValidarIngresoCabecera()
    {
        try
        {
            if(txtdescuento.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    txtcantidad.setFocusable(true);
                    return false;
                }
            if(cmbsucursal.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(null, "Seleccione una sucursal", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    cmbsucursal.setFocusable(true);
                    return false;
                }
        }catch(Exception e)
        {}
        return true;
    }
    private boolean ValidarIngresoDetalle(int x_indice)
    {
        try
        {
            x_indice=x_indice-1;
            if(x_indice>=0)
            {
                
                if(cmbtipodocumento.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(null, "Seleccione un documento", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    cmbtipodocumento.setFocusable(true);
                    return false;
                }
                if(txtcantidad.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    txtcantidad.setFocusable(true);
                    return false;
                }
                if(txtporcentaje.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un porcentaje.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    txtporcentaje.setFocusable(true);
                    return false;
                }
            }
            }catch(Exception e)
            {      }
        return true;
    }
    public void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(false); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        txtcantidad.setEnabled(true);
                        txtporcentaje.setEnabled(true);
                        cmbsucursal.setEnabled(true);
                        btnanadir.setEnabled(true);
                        btnquitar.setEnabled(true);
                        btnmodificar.setEnabled(true);
                        cmbtipodocumento.setEnabled(true);
                        txtdescuento.setEnabled(true);
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        btnBuscar.setEnabled(false);
                        cmbsucursal.setEnabled(true);
                        txtcantidad.setEnabled(true);
                        txtporcentaje.setEnabled(true);
                        btnanadir.setEnabled(true);
                        btnquitar.setEnabled(true);
                        btnmodificar.setEnabled(true);
                        detalledescuento.setEnabled(true);
                        cmbtipodocumento.setEnabled(true);
                        txtdescuento.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        txtcantidad.setEnabled(false);
                        txtporcentaje.setEnabled(false);
                        cmbsucursal.setEnabled(false);
                        btnanadir.setEnabled(false);
                        btnquitar.setEnabled(false);
                        btnmodificar.setEnabled(false);
                        cmbtipodocumento.setEnabled(false);
                        txtdescuento.setEnabled(false);
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
            columname[1]="Cantidad";
            columname[2]="porcentaje";
            columname[3]="Documento";
            columname[4]="Sucursal"; 
            columname[5]="instancia";
            columname[6]="suc_ncodigo";
            columname[7]="doc_ncodigo";
            mdo.setColumnIdentifiers(columname);   
            detalledescuento.setModel(mdo);
            detalledescuento.getColumn("Codigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalledescuento.getColumn("Codigo").setMinWidth(0);
            detalledescuento.getColumn("Codigo").setWidth(0);
            detalledescuento.getColumn("Codigo").setMaxWidth(0);
            detalledescuento.getColumn("suc_ncodigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalledescuento.getColumn("suc_ncodigo").setMinWidth(0);
            detalledescuento.getColumn("suc_ncodigo").setWidth(0);
            detalledescuento.getColumn("suc_ncodigo").setMaxWidth(0);
            detalledescuento.getColumn("doc_ncodigo").setPreferredWidth(0);//------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            detalledescuento.getColumn("doc_ncodigo").setMinWidth(0);
            detalledescuento.getColumn("doc_ncodigo").setWidth(0);
            detalledescuento.getColumn("doc_ncodigo").setMaxWidth(0);
            detalledescuento.setAutoResizeMode(detalledescuento.AUTO_RESIZE_OFF);
            detalledescuento.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {        }
    }

    public void CargarDescuento()
    {
        try
        {
            if(!"".equals(m_Codigo))
            {
                  ClearForm();
                  _edescuentocabecera=_bcabedes.ObtenerUno(Integer.parseInt(m_Codigo));
                  if(_edescuentocabecera!=null)
                  {
                      _edescuentocabecera.setM_instancia(InstancaEntidad.MODIFY);
                      txtdescuento.setText(_edescuentocabecera.getCds_cnombre());
                      for(int i=0;i<=_modelosucursal.getSize()-1;i++)
                        {
                            DisplayValue _valor=(DisplayValue) _modelosucursal.getElementAt(i);
                            if(_valor.getValueMenber().equals(String.valueOf(_edescuentocabecera.getSuc_ncodigo())))
                                _modelosucursal.setSelectedItem(_valor);
                        }
                        cmbsucursal.setModel(_modelosucursal);
                      cmbsucursal.setModel(_modelosucursal);
                      _bdecuentofactura = new BDescuentoFactura();
                      _lsdescuentofactura=_bdecuentofactura.ObtenerDescuentoxSucursal(Integer.parseInt(m_Codigo));
                      BindinJtable();            
                      btnEditar.setEnabled(true);
                      detalledescuento.setEnabled(false);
                  }
                  
            }
        }catch(Exception e)
        {}
    }
    private void BindinJtable()
    {
        try
        {
            DefaultTableModel dtm = (DefaultTableModel) detalledescuento.getModel();
            dtm.setNumRows(0);
            Object [] rowData = new Object[8];
            DefaultTableModel _mod = (DefaultTableModel) detalledescuento.getModel();
            for(int i=0;i<=_lsdescuentofactura.size()-1;i++)
            {
                rowData[0]=_lsdescuentofactura.get(i).getDsa_ncodigo();
                rowData[1]=_lsdescuentofactura.get(i).getDsa_flimite();
                rowData[2]=_lsdescuentofactura.get(i).getDsa_fporcentaje();
                rowData[3]=_lsdescuentofactura.get(i).getDoc_cdescripcion();
                rowData[4]=_lsdescuentofactura.get(i).getSuc_cdescripcion();
                rowData[5]=_lsdescuentofactura.get(i).getM_instancia();//.toString();
                rowData[6]=_lsdescuentofactura.get(i).getSuc_ncodigo();
                rowData[7]=_lsdescuentofactura.get(i).getDoc_ncodigo();
                _mod.addRow(rowData);
            }
            detalledescuento.setModel(_mod);
        }catch(Exception e)
        {}
    }
    private void GetItem()
    {
        try
        {
            _edescuentofactura.setDsa_flimite(Double.parseDouble(txtcantidad.getText()));
            _edescuentofactura.setDsa_fporcentaje(Double.parseDouble(txtporcentaje.getText()));
            DisplayValue _dato=(DisplayValue)cmbsucursal.getSelectedItem();
            _edescuentofactura.setSuc_ncodigo(Integer.parseInt(_dato.getValueMenber()));
            _edescuentofactura.setSuc_cdescripcion(_dato.displayMeneber.toString());
            _dato=(DisplayValue)cmbtipodocumento.getSelectedItem();
            _edescuentofactura.setDoc_ncodigo(_dato.getValueMenber());
            _edescuentofactura.setDoc_cdescripcion(_dato.displayMeneber.toString());
            
        }catch(Exception e)
        {}
    }
    private void SetItem()
    {
        try
        {
            txtcantidad.setText(""+_edescuentofactura.getDsa_flimite());
            txtporcentaje.setText(""+_edescuentofactura.getDsa_fporcentaje());
//            for(int i=0;i<=_modelosucursal.getSize()-1;i++)
//            {
//                DisplayValue _valor=(DisplayValue) _modelosucursal.getElementAt(i);
//                if(_valor.getValueMenber().equals(String.valueOf(_edescuentofactura.getSuc_ncodigo())))
//                    _modelosucursal.setSelectedItem(_valor);
//            }
//            cmbsucursal.setModel(_modelosucursal);
            for(int i=0;i<=_modelodocumento.getSize()-1;i++)
            {
                DisplayValue _valor=(DisplayValue) _modelodocumento.getElementAt(i);
                if(_valor.getValueMenber().equals(_edescuentofactura.getDoc_ncodigo()))
                    _modelodocumento.setSelectedItem(_valor);
            }
            cmbtipodocumento.setModel(_modelodocumento);
        }catch(Exception e)
        {
        }
    }
    private static FrmDescuentosGlobales m_frmadicional;
    public static FrmDescuentosGlobales getinstance()
    {
        if(m_frmadicional==null)
            m_frmadicional= new FrmDescuentosGlobales();
        return m_frmadicional;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnanadir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnquitar;
    private javax.swing.JComboBox<String> cmbsucursal;
    private javax.swing.JComboBox<String> cmbtipodocumento;
    private javax.swing.JTable detalledescuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuitem;
    private javax.swing.JPopupMenu mnuup;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtporcentaje;
    // End of variables declaration//GEN-END:variables
}

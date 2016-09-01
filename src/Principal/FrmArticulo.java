
package Principal;
import AccessoDato.EAfectacion;
import AccessoDato.EArticulo;
import AccessoDato.EMoneda;
import AccessoDato.EPrecioVenta;
import AccessoDato.EUnidad;
import Negocio.BAfectacion;
import Negocio.BArticulo;
import Negocio.BMoneda;
import Negocio.BPrecioVenta;
import Negocio.BTablasSolas;
import Negocio.BUnidad;
import Utilidad.ComboPersonalizado;
import Utilidad.DisplayValue;
import Utilidad.EditorCelda;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.OtrasEntidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class FrmArticulo extends javax.swing.JInternalFrame {

    private EArticulo _earticulo=null;
    private BArticulo _bearticulo=null;
    private BUnidad _beunidad=null;
    private EPrecioVenta _eprecio=null;
    private List<EPrecioVenta> _lseprecio= new ArrayList<>();    
    private List<EUnidad> _lseunidad=null;
    Vector _items=null;
    private BPrecioVenta _beprecio=null;
    private DefaultComboBoxModel modelo=null;
    private DefaultComboBoxModel modelotipomoneda=null;
    private DefaultComboBoxModel modeloafectacion=null;
    private DefaultComboBoxModel modelodetalleunidad=null;
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane panelPrincila;
    public String m_codigo;
    private float m_igv;
    private float m_noigv;
    private BTablasSolas _btablas;
    private boolean  m_estadocheck;
    private String m_tipoAfec;
    private OtrasEntidad _otros;
    ButtonGroup gruporadio=null;
    private JComboBox _cmbdetalleu=null;
    private ComboPersonalizado _cmbdetalletipoa=null;
    private List<EMoneda> _lsemoneda;
    private BMoneda _bmoneda;
    private BAfectacion _bafectacion;
    private List<EAfectacion> _lsafectacion;
    private FrmArticulo() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbUnidad = new javax.swing.JComboBox<>();
        txtcodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtbarra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tdetalle = new javax.swing.JTable();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rdoafecto = new javax.swing.JRadioButton();
        rdoexonerado = new javax.swing.JRadioButton();
        rdoinafecto = new javax.swing.JRadioButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Articulo");
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

        jLabel1.setText("Nombre");

        jLabel2.setText("Unidad");

        cmbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("ID");
        jLabel5.setEnabled(false);

        lbCodigo.setText("0");
        lbCodigo.setEnabled(false);
        lbCodigo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel8.setText("Codigo");

        jLabel9.setText("Codigo Barras");

        Tdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tdetalle);

        BtnAgregar.setText("Agregar Fila");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Quitar Fila");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Afectación"));
        jPanel1.setToolTipText("hola");

        rdoafecto.setText("Gravado");
        rdoafecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoafectoActionPerformed(evt);
            }
        });

        rdoexonerado.setText("Exonerado");
        rdoexonerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoexoneradoActionPerformed(evt);
            }
        });

        rdoinafecto.setText("Inafecto");
        rdoinafecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoinafectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(rdoafecto)
                .addGap(160, 160, 160)
                .addComponent(rdoexonerado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoinafecto)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoafecto)
                    .addComponent(rdoexonerado)
                    .addComponent(rdoinafecto))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbarra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtArticulo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbUnidad, javax.swing.GroupLayout.Alignment.LEADING, 0, 182, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtcodigo)
                                            .addGap(77, 77, 77)))))
                            .addComponent(jLabel8))
                        .addContainerGap(659, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbCodigo))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtbarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            m_Tipoinstancia= InstanciaForm.NEW;
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
            if(m_Tipoinstancia==InstanciaForm.MODIFY)
             {
                 GetItem();                 
                 RecuperarDetalle();
                 _bearticulo = new BArticulo();
                 if(_bearticulo.AccionModificar(_earticulo,_lseprecio))
                 { 
                     JOptionPane.showMessageDialog(null, "Cambios guardados", "Articulo",JOptionPane.INFORMATION_MESSAGE);
                     _lseprecio.clear();
                 }
                 else
                         JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Articulo",JOptionPane.INFORMATION_MESSAGE);
                 m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                 ClearForm();
                 EstablecerInstancia();
             }
             else
             {
                 if(validar())
                 {
                     GetItem();                     
                     RecuperarDetalle();
                     _bearticulo = new BArticulo();
                     if(_bearticulo.AccionGuardar(_earticulo,_lseprecio))
                     {                  
                        JOptionPane.showMessageDialog(null, "Se guardaron los datos correctamente.", "Articulo",JOptionPane.INFORMATION_MESSAGE);
                        _lseprecio.clear();
                     }
                     else
                         JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Articulo",JOptionPane.INFORMATION_MESSAGE);
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
            FrmBuscar _buscar = new FrmBuscar(2,this);
            panelPrincila.add(_buscar); 
            _buscar.show(); 
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        gruporadio = new ButtonGroup();        
        gruporadio.add(rdoafecto);
        gruporadio.add(rdoinafecto);
        gruporadio.add(rdoexonerado);
        _bmoneda= new BMoneda();
        _bafectacion= new BAfectacion();
        _lsemoneda=_bmoneda.ObtenerTodos();        
        cmbUnidad.removeAllItems();
        _beunidad = new BUnidad();
        _lseunidad=_beunidad.AccionObtenerTodo();
        _items = new Vector();
        _items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
        for (int i=0;i<=_lseunidad.size()-1;i++)
             _items.addElement(new DisplayValue(_lseunidad.get(i).getUni_cdescripcion(), _lseunidad.get(i).getUni_ncodigo()));
        modelo = new DefaultComboBoxModel(_items);
        cmbUnidad.setModel(modelo);        
        InicializarTabla();
        EstablecerInstancia();
        _btablas= new BTablasSolas();
        m_igv=_btablas.Obtenerigv();
        m_estadocheck=false;
        _otros = new OtrasEntidad();
        rdoafecto.setSelected(true);
         m_tipoAfec=_otros.Afectacion[0][0]; 
        CargarTipoAfectacion(rdoafecto.getText(),true);
    }//GEN-LAST:event_formInternalFrameOpened

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed

        try
        {
    
            DefaultTableModel _modeTable =(DefaultTableModel) Tdetalle.getModel();
            if(ValidarIngresodetalle(_modeTable.getRowCount()))
            {
                
               _modeTable.addRow(new Object[] {"",null,null,"","",""+(rdoexonerado.isSelected()?""+m_noigv:""+m_igv),"","","","","","","NEW"});   
//                TableColumn tpomoneda = Tdetalle.getColumnModel().getColumn(2);
//               modelotipomoneda.setSelectedItem(modelotipomoneda.getElementAt(1));
//               JComboBox _item =new JComboBox(modelotipomoneda);
//               tpomoneda.setCellEditor(new DefaultCellEditor(_item));
////               _modeTable.setValueAt(_item, Tdetalle.getRowCount()-1, 2);
               
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        try
        {
            int _filaselecionada = Tdetalle.getSelectedRow();
            if(_filaselecionada!=-1)
            {
                String _codigo= Tdetalle.getValueAt(_filaselecionada, 0).toString();
                String _descripcion= Tdetalle.getValueAt(_filaselecionada, 1).toString();
                String _instancia= Tdetalle.getValueAt(_filaselecionada, 9).toString();
                if(_instancia.equals("MODIFY")||_instancia.equals("UNCHANGUE"))
                {
                    for(int i=0;i<=_lseprecio.size()-1;i++)
                    {
                        _eprecio=_lseprecio.get(i);
                        if(_eprecio.getPve_ncodigo() ==Integer.parseInt(_codigo))
                        {
                            _eprecio.setM_instancia(InstancaEntidad.DELETE);
                            _lseprecio.set(i, _eprecio);
                        }
                    }
                }
                
                
//                if(_codigo!="")
//                {
//                    for(int i=0;i<=_lseprecio.size()-1;i++)
//                    {
//                        _eprecio=_lseprecio.get(i);
//                        if(_eprecio.getPve_ncodigo() ==Integer.parseInt(_codigo))
//                        _lseprecio.remove(i);
//                    }
//
//                }
//                else
//                {
//                    for(int i=0;i<=_lseprecio.size()-1;i++)
//                    {
//                        _eprecio=_lseprecio.get(i);
//                        if(_eprecio.getPve_ncodigo() ==Integer.parseInt(_codigo))
//                        {
//                            _eprecio.setM_instancia(InstancaEntidad.DELETE);
//                            _lseprecio.set(i, _eprecio);
//                        }
//                    }
//                }
                //Tdetalle.remove(_filaselecionada);
                ((DefaultTableModel)Tdetalle.getModel()).removeRow(_filaselecionada);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Fila", "Mensaje",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void rdoafectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoafectoActionPerformed
        if(rdoafecto.isSelected())
        {   m_estadocheck=true;
            m_tipoAfec=_otros.Afectacion[0][0];            
            CargarTipoAfectacion(rdoafecto.getText(),true);
            Cambiarigv();
        }
    }//GEN-LAST:event_rdoafectoActionPerformed

    private void rdoexoneradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoexoneradoActionPerformed
        if(rdoexonerado.isSelected())
        {   m_estadocheck=true;
            m_tipoAfec=_otros.Afectacion[1][0];
            m_noigv=0;
            CargarTipoAfectacion(rdoexonerado.getText(),true);
            Cambiarigv();
            
        }
    }//GEN-LAST:event_rdoexoneradoActionPerformed

    private void rdoinafectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoinafectoActionPerformed
        if(rdoinafecto.isSelected())
        {   m_estadocheck=true;
            m_tipoAfec=_otros.Afectacion[2][0];
            m_noigv=0;
            CargarTipoAfectacion(rdoinafecto.getText(),true);
            Cambiarigv();
            
        }
    }//GEN-LAST:event_rdoinafectoActionPerformed
public void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_codigo="";
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(false); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        txtArticulo.setEnabled(true);
                        txtArticulo.setEnabled(true);
                        txtcodigo.setEnabled(true);
                        cmbUnidad.setEnabled(true);
                        rdoafecto.setEnabled(true);
                        rdoexonerado.setEnabled(true);
                        rdoinafecto.setEnabled(true);
                        txtcodigo.setEditable(true);
                        txtbarra.setEditable(true);
                        Tdetalle.setEnabled(true);
                        BtnAgregar.setEnabled(true);
                        BtnEliminar.setEnabled(true);
                                               
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        btnBuscar.setEnabled(false);
                        txtArticulo.setEnabled(true);
                        txtcodigo.setEnabled(true);
                        cmbUnidad.setEnabled(true);
                        rdoafecto.setEnabled(true);
                        rdoexonerado.setEnabled(true);
                        rdoinafecto.setEnabled(true);
                        txtcodigo.setEditable(true);
                        txtbarra.setEditable(true);
                        Tdetalle.setEnabled(true);
                        BtnAgregar.setEnabled(true);
                        BtnEliminar.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        txtArticulo.setEnabled(false);
                        txtcodigo.setEnabled(false);
                        cmbUnidad.setEnabled(false);
                        rdoafecto.setEnabled(false);
                        rdoexonerado.setEnabled(false);
                        rdoinafecto.setEnabled(false);
                        txtcodigo.setEditable(false);
                        txtbarra.setEditable(false);                        
                        Tdetalle.setEnabled(false);
                        BtnAgregar.setEnabled(false);
                        BtnEliminar.setEnabled(false);
                        rdoafecto.setSelected(false);
                        rdoexonerado.setSelected(false);
                        rdoinafecto.setSelected(false);                        
                        break;
                        
                }
    }
    
    private void ClearForm()
    {
        txtArticulo.setText("");
        txtcodigo.setText("");
        cmbUnidad.setSelectedIndex(0);
        txtbarra.setText(""); 
        DefaultTableModel dtm = (DefaultTableModel) Tdetalle.getModel();
        dtm.setNumRows(0);
        gruporadio.clearSelection();
        lbCodigo.setText("0");
        rdoafecto.setSelected(true);
    }
    private void GetItem()
    {
        try
        {
            if(_earticulo==null)
            {             
                _earticulo = new EArticulo();
            }
            _earticulo.setArt_cdescripcion(txtArticulo.getText());
            DisplayValue _valor = ((DisplayValue)cmbUnidad.getSelectedItem()); 
            _earticulo.setUni_ncodigo(Integer.parseInt(_valor.getValueMenber()));
            _earticulo.setArt_cafectacion(m_tipoAfec);
            _earticulo.setArt_ccodigo(txtcodigo.getText());
            _earticulo.setArt_ccodbarra(txtbarra.getText());
           
        }
        catch(Exception e)
        {}
    }
    private void InicializarTabla()
    {
        try
        {
            DefaultTableModel mdo = new DefaultTableModel()
            {//-----------------------------------------------------------------------DESABILITANDO COLUMNAS 
                boolean[] canEdit = new boolean[]{
                false,true,true,true,true,false,false,true,true,true,true,true,true,true
                };
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                {  return canEdit[columnIndex];}
            };
            Object[] columname = new Object[13];
            columname[0]="Codigo";
            columname[1]="Lista Precio";            
            columname[2]="Moneda";
            columname[3]="Unidad";
            columname[4]="Valor Vta.";
            columname[5]="IGV";
            columname[6]="Prec. Vta.";
            //tipo de afectacion 20-07-2016
            columname[7]="Afectacion";
            //fin
            //agregado 18-07-2016
            columname[8]="Cantidad x Descuento";
            columname[9]="%Descuento";            
            columname[10]="Codigo Barras";
            columname[11]="codunidad";
            columname[12]="Instancia";
            mdo.setColumnIdentifiers(columname);   
            Tdetalle.setModel(mdo);
            TableColumn tpcolumn = Tdetalle.getColumnModel().getColumn(1);
            JComboBox cmblista = new JComboBox();
            cmblista.addItem("CONTADO");
            cmblista.addItem("CREDITO");
            cmblista.addItem("OTROS");           
            tpcolumn.setCellEditor(new DefaultCellEditor(cmblista));
            cmblista.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //JOptionPane.showMessageDialog(null, "CAMBIO fila :"+Tdetalle.getSelectedRow(), "Mensaje",JOptionPane.WARNING_MESSAGE);
                    int indicetabla=Tdetalle.getSelectedRow();
                    if(indicetabla>=0)
                    {
                        if(Tdetalle.getValueAt(indicetabla, 12).toString().equals("UNCHANGUE"))
                            Tdetalle.setValueAt(String.valueOf("MODIFY"), indicetabla, 12);
                    }
                }
            });
            TableColumn tpomoneda = Tdetalle.getColumnModel().getColumn(2);//----------------------------REFERENCIA A LA COLUMNA MONEDA
            _items = new Vector();
            for (int i=0;i<=_lsemoneda.size()-1;i++)
             _items.addElement(new DisplayValue(_lsemoneda.get(i).getMon_csimbolo(), _lsemoneda.get(i).getMon_ncodigo()));
            modelotipomoneda = new DefaultComboBoxModel(_items);   
            JComboBox cmbmoneda = new JComboBox();//------------------------------------------------------CARGANDO MONEDA
            cmbmoneda.setModel(modelotipomoneda);
            tpomoneda.setCellEditor(new DefaultCellEditor(cmbmoneda));
            cmbmoneda.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indicetabla=Tdetalle.getSelectedRow();
                    if(indicetabla>=0)
                    {
                        if(Tdetalle.getValueAt(indicetabla, 12).toString().equals("UNCHANGUE"))
                            Tdetalle.setValueAt(String.valueOf("MODIFY"), indicetabla, 12);
                    }
                }
            
            });
            
            TableColumn tpounidad = Tdetalle.getColumnModel().getColumn(3);   //--------------------------REFERENCIA A LA COLUMNA UNIDAD         
            _items = new Vector();
            for (int i=0;i<=_lseunidad.size()-1;i++)
             _items.addElement(new DisplayValue(_lseunidad.get(i).getUni_cdescripcion(), _lseunidad.get(i).getUni_ncodigo()));
            modelodetalleunidad = new DefaultComboBoxModel(_items);
            JComboBox cmbunidaddetalle = new JComboBox();//------------------------------------------------------CARGANDO UNIDAD
            cmbunidaddetalle.setModel(modelodetalleunidad);
            tpounidad.setCellEditor(new DefaultCellEditor(cmbunidaddetalle));   
            cmbunidaddetalle.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indicetabla=Tdetalle.getSelectedRow();
                    if(indicetabla>=0)
                    {
                        if(Tdetalle.getValueAt(indicetabla, 12).toString().equals("UNCHANGUE"))
                            Tdetalle.setValueAt(String.valueOf("MODIFY"), indicetabla, 12);
                    }
                }
            
            });
            TableColumn tpoafecto = Tdetalle.getColumnModel().getColumn(7);//-------------------------------REFEENCIA A LA COLUMNA TIPO AFECTACION
            cmbadetafectacion = new ComboPersonalizado();//-------------------------------------------------CARGANDO AFECTACION
            _items = new Vector();
            _items.addElement(new DisplayValue("Elegir", "0"));
            modeloafectacion = new DefaultComboBoxModel(_items);
            tpoafecto.setCellEditor(new DefaultCellEditor(cmbadetafectacion));
            
            
            Tdetalle.getColumn("Codigo").setPreferredWidth(0);//--------------------------------------------DEFINIENDO TAMAÑO DE COLUMNAS VISIBLES
            Tdetalle.getColumn("Codigo").setMinWidth(0);
            Tdetalle.getColumn("Codigo").setWidth(0);
            Tdetalle.getColumn("Codigo").setMaxWidth(0);
            Tdetalle.getColumn("Codigo Barras").setPreferredWidth(100);
            Tdetalle.getColumn("Codigo Barras").setMinWidth(100);
            Tdetalle.getColumn("Codigo Barras").setWidth(100);
            Tdetalle.getColumn("Codigo Barras").setMaxWidth(100);
            Tdetalle.getColumn("codunidad").setPreferredWidth(0);
            Tdetalle.getColumn("codunidad").setMinWidth(0);
            Tdetalle.getColumn("codunidad").setWidth(0);
            Tdetalle.getColumn("codunidad").setMaxWidth(0);
//            Tdetalle.getColumn("Instancia").setPreferredWidth(0);
//            Tdetalle.getColumn("Instancia").setMinWidth(0);
//            Tdetalle.getColumn("Instancia").setWidth(0);
//            Tdetalle.getColumn("Instancia").setMaxWidth(0);
            Tdetalle.getColumn("Valor Vta.").setCellEditor(new EditorCelda());     
            Tdetalle.getColumn("Afectacion").setPreferredWidth(150);
            Tdetalle.getColumn("Afectacion").setMinWidth(150);
            Tdetalle.getColumn("Afectacion").setWidth(150);
            Tdetalle.getColumn("Afectacion").setMaxWidth(150);
            Tdetalle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            Tdetalle.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void CargarLista(String codigo,String listaprecio,String moneda,int codigounidad,float venta,float igv,float precio,String barra,String instancia,int cantdescu,int porcedescu,String tpoAfec)
    {
        try
        {
            
             if(instancia.equals("NEW"))
             {
                _eprecio = new EPrecioVenta();
                _eprecio.setM_instancia(InstancaEntidad.NEW);
                _eprecio.setPve_ctipoprecio(listaprecio);
                _eprecio.setPve_cmoneda(moneda);
                _eprecio.setUni_ccodigo(codigounidad);
                _eprecio.setPve_fpreciounitario(venta);
                _eprecio.setPve_figv(rdoinafecto.isEnabled()||rdoexonerado.isEnabled()==true ? m_noigv : m_igv);
                _eprecio.setPve_fprecioventa(precio);     
                _eprecio.setPve_ccodbarra(barra);                
                _eprecio.setPve_ncantidad(cantdescu);//se agrego para descuento con porcentaje
                _eprecio.setPve_nporcentajedescuento(porcedescu);
                _eprecio.setPve_ctipoafectacion(tpoAfec);
                _lseprecio.add(_eprecio);
             
             }
             else if (instancia.equals("MODIFY")){
             
               for(int i=0;i<=_lseprecio.size()-1;i++)
               {
                   if(_lseprecio.get(i).getPve_ncodigo() ==Integer.parseInt(codigo))
                   {
                        _eprecio = _lseprecio.get(i);
                        _eprecio.setM_instancia(InstancaEntidad.MODIFY);
                        _eprecio.setPve_ctipoprecio(listaprecio);
                        _eprecio.setPve_cmoneda(moneda);
                        _eprecio.setUni_ccodigo(codigounidad);
                        _eprecio.setPve_fpreciounitario(venta);
                        _eprecio.setPve_figv(rdoinafecto.isEnabled()||rdoexonerado.isEnabled()==true ? m_noigv : m_igv);
                        _eprecio.setPve_fprecioventa(precio);     
                        _eprecio.setPve_ccodbarra(barra);                        
                        _eprecio.setPve_ncantidad(cantdescu);//se agrego para descuento con porcentaje
                        _eprecio.setPve_nporcentajedescuento(porcedescu);
                        _eprecio.setPve_ctipoafectacion(tpoAfec);
                        _lseprecio.set(i, _eprecio);
                       break;
                   }
               }
               
             }
                
  
        }
        catch(Exception e)
        {
        }
    }
    private void RecuperarDetalle()
    {
        try
        {
            for(int i=0;i<=Tdetalle.getRowCount()-1;i++)
            {
                String _codigo= Tdetalle.getValueAt(i, 0).toString();
                String _listaprecio= Tdetalle.getValueAt(i, 1).toString();
                String _listamoneda=Tdetalle.getValueAt(i, 2).toString();
                int _codunidad=  Integer.parseInt(((DisplayValue)Tdetalle.getValueAt(i, 3)).getValueMenber());
                float _pvalorventa =Float.parseFloat( Tdetalle.getValueAt(i, 4).toString());
                float _pvigv =Float.parseFloat(Tdetalle.getValueAt(i, 5).toString());
                float _pprecioventa =Float.parseFloat( Tdetalle.getValueAt(i, 6).toString());   
                String _valorafecto=((DisplayValue)Tdetalle.getValueAt(i, 7)).getValueMenber();//Tipo de afectacion
                int  _cantidadDescuento =Integer.parseInt(Tdetalle.getValueAt(i, 8).toString().equals("")?"0":Tdetalle.getValueAt(i, 8).toString());//agrego para cantidad y % descuento
                int  _porcentajeDescuento =Integer.parseInt(Tdetalle.getValueAt(i, 9).toString().equals("")?"0":Tdetalle.getValueAt(i,9).toString());//fin
                
                String _barra= Tdetalle.getValueAt(i, 10).equals("")?"":(String)Tdetalle.getValueAt(i, 10);
                String TipoInstancia=Tdetalle.getValueAt(i, 12).toString();
                CargarLista(_codigo,_listaprecio,_listamoneda,_codunidad,_pvalorventa,_pvigv,_pprecioventa,_barra,TipoInstancia,_cantidadDescuento,_porcentajeDescuento,_valorafecto);
            }
            
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }
    private boolean validar()
    {
        boolean _flag=true;
        try
        {
            if(txtcodigo.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un Codigo.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                txtcodigo.setFocusable(true);
                return false;
             }
            if(txtArticulo.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre de Articulo.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                txtArticulo.setFocusable(true);
                return false;
             }
            if(cmbUnidad.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una unidad.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                cmbUnidad.setFocusable(true);
                return false;
            }
        }
        catch(Exception e)
        {
        
        }        
        return _flag;
    }
    public void CargarFrm()
    {        
        try
        {
            if(m_codigo!="")
            {
                  ClearForm();
                  _bearticulo = new BArticulo();
                  _earticulo=_bearticulo.ObtenerUno(Integer.parseInt(m_codigo));
                  SetItem();                  
                  _bafectacion= new BAfectacion(); 
                  if(rdoafecto.isSelected())
                      CargarTipoAfectacion(rdoafecto.getText(),false);
                  if(rdoexonerado.isSelected())
                      CargarTipoAfectacion(rdoexonerado.getText(),false);
                  if(rdoinafecto.isSelected())
                      CargarTipoAfectacion(rdoexonerado.getText(),false);
                  //_lsafectacion=_bafectacion.ObtenerxTipo(nombreAfec);
                  //SetDetalle(_earticulo.getArt_ncodigo());
                  _beprecio = new BPrecioVenta();
                      _lseprecio=_beprecio.AccionObtenerTodo(_earticulo.getArt_ncodigo());
                  if(_lseprecio.size()>0)                                       
                      CargarDetalle();                
                  btnEditar.setEnabled(true);
            }
        }
        catch(Exception e)
        {         JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);  }
    }
    private void SetItem()
    {
        try
        {
            if(_earticulo!=null)
            {
                lbCodigo.setText(String.valueOf(_earticulo.getArt_ncodigo()));
                txtcodigo.setText(_earticulo.getArt_ccodigo());
                txtbarra.setText(_earticulo.getArt_ccodbarra());
                txtArticulo.setText(_earticulo.getArt_cdescripcion());
                if(_earticulo.getArt_cafectacion().equals("01"))
                {  
                    rdoafecto.setSelected(true);
                }
                else if(_earticulo.getArt_cafectacion().equals("02"))
                {
                    rdoexonerado.setSelected(true);
                }
                else if(_earticulo.getArt_cafectacion().equals("03"))
                {
                    rdoinafecto.setSelected(true);
                }
                cmbUnidad.removeAllItems();
                _beunidad = new BUnidad();
                _lseunidad=_beunidad.AccionObtenerTodo();
                _items = new Vector();
                _items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
                for (int i=0;i<=_lseunidad.size()-1;i++)
                    _items.addElement(new DisplayValue(_lseunidad.get(i).getUni_cdescripcion(), _lseunidad.get(i).getUni_ncodigo()));
                modelo = new DefaultComboBoxModel(_items);
                cmbUnidad.setModel(modelo);
                for(int i=0;i<=modelo.getSize()-1;i++)
                {
                        DisplayValue _valor=(DisplayValue) modelo.getElementAt(i);
                        if(_valor.valueMenber.equals(_earticulo.getUni_ncodigo()))
                        {
                            modelo.setSelectedItem(_valor);
                            break;
                        }                    
                }
                cmbUnidad.setModel(modelo);
                m_tipoAfec=_earticulo.getArt_cafectacion();
            }
        }
        catch(Exception e)
        {}
    }
       
    private void CargarDetalle()
    {
        //InicializarTabla();
        try
        {
            Object [] rowData = new Object[13];
            DefaultTableModel _mod = (DefaultTableModel) Tdetalle.getModel();
    //        _cmbdetalleu = new JComboBox();
    //        _cmbdetalleu.setModel(modelo);  
            for(int i=0;i<=_lseprecio.size()-1;i++)
            {
                rowData[0]=_lseprecio.get(i).getPve_ncodigo();
                rowData[1]=_lseprecio.get(i).getPve_ctipoprecio();
                rowData[2]=_lseprecio.get(i).getPve_cmoneda();
                _cmbdetalleu = new JComboBox();//------------------------Cargando combo unidad detalle
                _cmbdetalleu.setModel(modelo);
                for(int n=0;i<=modelo.getSize()-1;n++)
                {
                            DisplayValue _valor=(DisplayValue) modelo.getElementAt(n);
                            if(_valor.valueMenber.equals(_lseprecio.get(i).getUni_ccodigo()))
                            {
                                modelo.setSelectedItem(_valor);
                                break;
                            } 

                 }
                _cmbdetalleu.setModel(modelo);
                rowData[3]=_cmbdetalleu.getSelectedItem();
                rowData[4]=String.valueOf(_lseprecio.get(i).getPve_fpreciounitario());
                rowData[5]=String.valueOf(_lseprecio.get(i).getPve_figv());
                rowData[6]=String.valueOf(_lseprecio.get(i).getPve_fprecioventa());
//                ComboPersonalizado cmbafec= new ComboPersonalizado(modeloafectacion);
                _cmbdetalletipoa= new ComboPersonalizado(modeloafectacion);
                for(int j=0;j<=modeloafectacion.getSize()-1;j++)
                {
                            DisplayValue _DisplayAfe=(DisplayValue) modeloafectacion.getElementAt(j);
                            if(_DisplayAfe.getValueMenber().equals(_lseprecio.get(i).getPve_ctipoafectacion()))
                            {
                                modeloafectacion.setSelectedItem(_DisplayAfe);
                                break;
                            }
                }
                _cmbdetalletipoa.setModel(modeloafectacion);
                rowData[7]=_cmbdetalletipoa.getSelectedItem();//-------------------------------------Cargando combo AFEC
                rowData[8]=_lseprecio.get(i).getPve_ncantidad();//---------------------------Cantidad descuento por unidad
                rowData[9]=_lseprecio.get(i).getPve_nporcentajedescuento();//----------------Porcentaje de descuento aplicar
                rowData[10]=String.valueOf(_lseprecio.get(i).getPve_ccodbarra());//----------Codigo de barras del detalle
                rowData[11]=_lseprecio.get(i).getUni_ccodigo();//----------------------------Codigo de la unidad
                rowData[12]=_lseprecio.get(i).getM_instancia();//----------------------------Tipo de instancia del item detalle
                _mod.addRow(rowData);
            }
            Tdetalle.setModel(_mod);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Cargando Detalle",JOptionPane.WARNING_MESSAGE); 
        }
        
    }
    
    private void Cambiarigv()
    {
        for (int i=0;i<=Tdetalle.getRowCount()-1;i++)
        {
            if(m_tipoAfec.equals("01"))
            {    
                Tdetalle.setValueAt(String.valueOf(m_igv), i,5);
                Double _valorVenta= Double.parseDouble( Tdetalle.getValueAt(i, 4).toString());
                Double _Onlyigv=m_igv*_valorVenta/100;
                double _total=_valorVenta+_Onlyigv;
                Tdetalle.setValueAt(String.valueOf(_total), i,6);
            }
            else
            {
                Tdetalle.setValueAt("0.0", i,5);
                Tdetalle.setValueAt(Tdetalle.getValueAt(i, 4).toString(), i,6);
            }
            Tdetalle.setValueAt("", i,7);           
        }        
    }
    ComboPersonalizado cmbadetafectacion;
    private void CargarTipoAfectacion(String  nombreAfec,boolean _estado)
    {
        try
        {
            _lsafectacion=_bafectacion.ObtenerxTipo(nombreAfec);
            TableColumn tpoafectacion = Tdetalle.getColumnModel().getColumn(7);
            cmbadetafectacion.removeAllItems();
            _items = new Vector();
            _items.addElement(new DisplayValue("Elegir", "0"));
            for (int i=0;i<=_lsafectacion.size()-1;i++)
             _items.addElement(new DisplayValue(_lsafectacion.get(i).getAfe_cdescripcion(), _lsafectacion.get(i).getAfe_ncodigo()));
            modeloafectacion = new DefaultComboBoxModel(_items);
//            if(_estado){
            cmbadetafectacion = new ComboPersonalizado(modeloafectacion);
            tpoafectacion.setCellEditor(new DefaultCellEditor(cmbadetafectacion));
            cmbadetafectacion.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indicetabla=Tdetalle.getSelectedRow();
                    if(indicetabla>=0)
                    {
                        if(Tdetalle.getValueAt(indicetabla, 12).toString().equals("UNCHANGUE"))
                            Tdetalle.setValueAt(String.valueOf("MODIFY"), indicetabla, 12);
                    }
                }
            });
//            }
        }
        catch(Exception e)
        {
        }
    }
    
    private boolean ValidarIngresodetalle(int indice)
    {
        indice=indice-1;
        if(indice>0)
        {
    
            if(Tdetalle.getValueAt(Tdetalle.getSelectedRow(),4).toString().equals(""))
            {
            JOptionPane.showMessageDialog(null, "Antes de agregar otra lista de precio.\nIngrese un valor de venta unitario.", "Mensaje",JOptionPane.WARNING_MESSAGE);
            return false;
            }
        }
        return true;
    }
    private static FrmArticulo m_frmarticulo;
    public static FrmArticulo getinstancia()
    {
        if(m_frmarticulo==null)
            m_frmarticulo= new FrmArticulo();
        return m_frmarticulo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JTable Tdetalle;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JRadioButton rdoafecto;
    private javax.swing.JRadioButton rdoexonerado;
    private javax.swing.JRadioButton rdoinafecto;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtbarra;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}

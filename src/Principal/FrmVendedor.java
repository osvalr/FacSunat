package Principal;


import AccessoDato.EDocumento;
import AccessoDato.EDocumentoIdentidad;
import AccessoDato.EVendedor;
import Negocio.BDocumentoIdentidad;
import Negocio.BTablasSolas;
import Negocio.BVendedor;
import Principal.FrmBuscar;
import Utilidad.DisplayValue;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


public class FrmVendedor extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public String m_Codigo;
    private BVendedor _bvendedor;
    private EVendedor _evendedor;
    public JDesktopPane panelPrincila;
    private static FrmVendedor frmvendedor;
    private List<EDocumentoIdentidad> _lsdocumento;
    private BDocumentoIdentidad _bdocumento;
    private Vector item;
    private DefaultComboBoxModel modelodocumento;
    
    public FrmVendedor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbcodigovendedor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmaterno = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Registro Vendedor");
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

        jLabel1.setText("codigo");
        jLabel1.setEnabled(false);

        lbcodigovendedor.setText("0");
        lbcodigovendedor.setEnabled(false);

        jLabel3.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Numero");

        jLabel5.setText("Nombres");

        jLabel6.setText("A. Paterno");

        jLabel7.setText("A. Materno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumero)
                            .addComponent(txtnombres)
                            .addComponent(txtpaterno)
                            .addComponent(txtmaterno)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbcodigovendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbcodigovendedor))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            m_Tipoinstancia= InstanciaForm.NEW;
            _evendedor=new EVendedor();
            _evendedor.setM_instanciaentidad(InstancaEntidad.NEW);
            ClearForm();
            EstablecerInstancia();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se producjo un error inesperado :"+  e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void ClearForm()
    {
        try {
            cmbdocumento.setSelectedIndex(0);
            txtnumero.setText("");
            txtnombres.setText("");
            txtpaterno.setText("");
            txtmaterno.setText("");
        } catch (Exception e) {
        }
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
                        cmbdocumento.setEnabled(true);
                        txtnumero.setEnabled(true);
                        txtnombres.setEnabled(true);
                        txtpaterno.setEnabled(true);
                        txtmaterno.setEnabled(true);
                        lbcodigovendedor.setText("0");
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        btnBuscar.setEnabled(false);
                        cmbdocumento.setEnabled(true);
                        txtnumero.setEnabled(true);
                        txtnombres.setEnabled(true);
                        txtpaterno.setEnabled(true);
                        txtmaterno.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        cmbdocumento.setEnabled(false);
                        txtnumero.setEnabled(false);
                        txtnombres.setEnabled(false);
                        txtpaterno.setEnabled(false);
                        txtmaterno.setEnabled(false);
                        lbcodigovendedor.setText("0");
                        break;
                        
                }
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try
        {
            if(Validar())
            {
                GetItem();
                if(m_Tipoinstancia==InstanciaForm.MODIFY)
                {
                    _bvendedor= new BVendedor();
                    if(_bvendedor.AccionModificar(_evendedor))
                    {  JOptionPane.showMessageDialog(null, "Cambios guardados", "Vendedor",JOptionPane.INFORMATION_MESSAGE); }
                }
                else if (m_Tipoinstancia==InstanciaForm.NEW)
                {
                    _bvendedor= new BVendedor();
                    if(_bvendedor.AccionGuardar(_evendedor))
                    { JOptionPane.showMessageDialog(null, "Se guardados.", "Vendedor",JOptionPane.INFORMATION_MESSAGE); }
                }
                m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                ClearForm();
                EstablecerInstancia();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Se encontro algunos Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private boolean  Validar()
    {
        try {
            if(cmbdocumento.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione un documento.", "Vendedor",JOptionPane.INFORMATION_MESSAGE);
                cmbdocumento.setFocusable(true);
                return false;
            }
            if(txtnumero.getText().length()==0)
            {
               JOptionPane.showMessageDialog(null, "Ingrese un numero.", "Vendedor",JOptionPane.INFORMATION_MESSAGE);
                txtnumero.setFocusable(true);
                return false;   
            }
            if(txtnombres.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese nombre.", "Vendedor",JOptionPane.INFORMATION_MESSAGE);
                txtnombres.setFocusable(true);
                return false;
            }
            if(txtpaterno.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese Ape. paterno", "Vendedor",JOptionPane.INFORMATION_MESSAGE);
                txtpaterno.setFocusable(true);
                return false;
            }
            if(txtmaterno.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese Ape. materno", "Vendedor",JOptionPane.INFORMATION_MESSAGE);
                txtmaterno.setFocusable(true);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    private void GetItem()
    {
        try {
            if(_evendedor!=null)
            {
                DisplayValue _valor=((DisplayValue)cmbdocumento.getSelectedItem());
                _evendedor.setDoi_ccodigo(_valor.getValueMenber());
                _evendedor.setVen_nombres(txtnombres.getText());
                _evendedor.setVen_cpaterno(txtpaterno.getText());
                _evendedor.setVen_materno(txtmaterno.getText());
                _evendedor.setVen_cnumero(txtnumero.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
            _bvendedor = new BVendedor();
            if(_bvendedor.AccionEliminar(_evendedor))
            {   JOptionPane.showMessageDialog(null, "Cliente fue eliminado","Mensaje",JOptionPane.WARNING_MESSAGE); }
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try
        {
            m_Tipoinstancia=InstanciaForm.MODIFY;
            EstablecerInstancia();
            _evendedor.setM_instanciaentidad(InstancaEntidad.MODIFY);
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try
        {
            FrmBuscar _buscar = new FrmBuscar(7,this);
            panelPrincila.add(_buscar);
            _buscar.show();
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            _bdocumento = new BDocumentoIdentidad();
            _lsdocumento=_bdocumento.AccionTraerTodo();
            cmbdocumento.removeAllItems();
            item= new Vector();
            item.addElement(new DisplayValue("Seleccione", "-1"));
            for (int i=0;i<=_lsdocumento.size()-1;i++)//---------------------------------------------Cargando Documento
            {  
                if(!_lsdocumento.get(i).getDoi_ccodigo().equals("6"))
                    item.addElement(new DisplayValue(_lsdocumento.get(i).getDoi_cdescripcion(), _lsdocumento.get(i).getDoi_ccodigo()));
            }
            modelodocumento = new DefaultComboBoxModel(item);
            cmbdocumento.setModel(modelodocumento);
            EstablecerInstancia();
            txtnumero.setDocument(new JTextFielCharLimit(MaximoCharacter.DocMaxCharDni));
            txtnombres.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreMaxSimple)));
            txtpaterno.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreMaxSimple)));
            txtmaterno.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNombreMaxSimple)));
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    public static FrmVendedor getInstance()
    {
        if(frmvendedor==null)
            frmvendedor= new  FrmVendedor();
        return frmvendedor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbcodigovendedor;
    private javax.swing.JTextField txtmaterno;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtpaterno;
    // End of variables declaration//GEN-END:variables
    void CargarVendedor() {
        try {
            if(!m_Codigo.equals(""))
            {
                _bvendedor= new BVendedor();
                _evendedor=_bvendedor.AccionObtenerUno(Integer.parseInt(m_Codigo));
                SetItem();
                btnEditar.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

    private void SetItem() {
        try {
            if(_evendedor!=null)
            {
                for(int i=0;i<=modelodocumento.getSize()-1;i++)
                {
                    DisplayValue _valor=(DisplayValue)modelodocumento.getElementAt(i);
                    if(_valor.getValueMenber().equals(_evendedor.getDoi_ccodigo()))
                    {
                        modelodocumento.setSelectedItem(_valor);
                        break;
                    }
                }
                cmbdocumento.setModel(modelodocumento);
                txtnumero.setText(_evendedor.getVen_cnumero());
                txtnombres.setText(_evendedor.getVen_nombres());
                txtpaterno.setText(_evendedor.getVen_cpaterno());
                txtmaterno.setText(_evendedor.getVen_materno());
                lbcodigovendedor.setText(""+_evendedor.getVen_ncodigo());
            }
        } catch (Exception e) {
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

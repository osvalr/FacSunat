
package Principal;

import AccessoDato.EPais;
import AccessoDato.ESucursal;
import AccessoDato.EUbigeo;
import Negocio.BSucursal;
import Negocio.BTablasSolas;
import Negocio.BUbigeo;
import Utilidad.DisplayValue;
import Utilidad.InstanciaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class FrmSucursal extends javax.swing.JInternalFrame {

    private BTablasSolas _bpaises;
    private List<EPais> _lspaises;
    private List<EUbigeo> _lsdepartamento;
    private List<EUbigeo> _lsprovincia;
    private List<EUbigeo> _lsdistrito;
    private BUbigeo _bubigeo;
    private EUbigeo _eubigeo;
    private static FrmSucursal frmsucursal;
    public JDesktopPane panelPrincila;
    public InstanciaForm m_Tipoinstancia;
    private DefaultComboBoxModel _modelopais;
    private DefaultComboBoxModel _modelodepartamento;
    private DefaultComboBoxModel _modeloprovincia;
    private DefaultComboBoxModel _modelodistrito;
    private BSucursal _bsucursal;
    private ESucursal _esucursal;
    public String m_Codigo;
    public static FrmSucursal getinstancia()
    {
        if(frmsucursal==null)
            frmsucursal= new FrmSucursal();
        return frmsucursal;
    }
    private FrmSucursal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtalias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbdepartamento = new javax.swing.JComboBox<>();
        cmbprovincia = new javax.swing.JComboBox<>();
        cmbdistrito = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbpais = new javax.swing.JComboBox<>();
        lbid = new javax.swing.JLabel();
        lbcodigosucursal = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Registro Sucursales");
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

        jLabel1.setText("Alias");

        jLabel2.setText("Departamento");

        jLabel3.setText("Provincia");

        jLabel4.setText("Distrito");

        cmbdepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbdepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdepartamentoActionPerformed(evt);
            }
        });

        cmbprovincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbprovincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprovinciaActionPerformed(evt);
            }
        });

        cmbdistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Direccion");

        jLabel6.setText("Pais");

        cmbpais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbid.setText("ID");
        lbid.setEnabled(false);

        lbcodigosucursal.setText("0");
        lbcodigosucursal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbdepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbpais, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtalias, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbdistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbprovincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdireccion))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcodigosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbid)
                    .addComponent(lbcodigosucursal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtalias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setBorderPainted(false);

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
        jToolBar2.add(btnNuevo);

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
        jToolBar2.add(btnGuardar);

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
        jToolBar2.add(btnDeshacer);

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
        jToolBar2.add(btnEliminar);

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
        jToolBar2.add(btnEditar);

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
        jToolBar2.add(btnBuscar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            m_Tipoinstancia=InstanciaForm.NEW;
            _esucursal = new ESucursal();
            _esucursal.setM_instancia(InstanciaEntidad.NEW);
            EstablecerInstancia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(Validar())
            {
                GetItem();
                _bsucursal = new BSucursal();
                if(_bsucursal.AccionGuardar(_esucursal))
                    JOptionPane.showMessageDialog(null, "Se guardo correctamente.","Sucursal",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "No se pudo guardar.","Sucursal",JOptionPane.WARNING_MESSAGE);
                ClearFrm();
                m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                EstablecerInstancia();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void GetItem()
    {
        try {
            if(_esucursal!=null)
            {
                _esucursal.setSuc_sucdescripcion(txtalias.getText());
                _esucursal.setSuc_cdireccion(txtdireccion.getText());
                DisplayValue _valor=(DisplayValue)cmbpais.getSelectedItem();
                _esucursal.setPai_ncodigo(Integer.parseInt(_valor.getValueMenber()));
                _valor=(DisplayValue)cmbdistrito.getSelectedItem();
                _bubigeo = new BUbigeo();
                int idncodigo=_bubigeo.ObtenerUno(_valor.getValueMenber());
                _esucursal.setUbi_ncodigo(idncodigo);
                _esucursal.setEmp_ncodigo(6);
            }
        } catch (Exception e) {
        }
    }
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try {
            ClearFrm();
            m_Tipoinstancia=InstanciaForm.UNCHANGUE;
            EstablecerInstancia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
             m_Tipoinstancia=InstanciaForm.MODIFY;
             EstablecerInstancia();
             _esucursal.setM_instancia(InstanciaEntidad.MODIFY);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      try
        {
            FrmBuscar _buscar = new FrmBuscar(8,this);
            panelPrincila.add(_buscar);
            _buscar.show();
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            _bpaises = new BTablasSolas();
            _lspaises=_bpaises.ObtenerTodosPaises();
            _bubigeo= new BUbigeo();
            _lsdepartamento=_bubigeo.ObtenerTodos(1,"");
            cmbpais.removeAllItems();
            Vector _item = new Vector();
            _item.addElement(new DisplayValue("Seleccione Pais","-1"));//-------------------------------------------------Cargando pais
            for (int i=0;i<=_lspaises.size()-1;i++)
                _item.addElement(new DisplayValue(_lspaises.get(i).getPai_cnombre(),_lspaises.get(i).getPai_ncodigo()));
            _modelopais = new DefaultComboBoxModel(_item);
            cmbpais.setModel(_modelopais);
            _item = new Vector();
            _item.addElement(new DisplayValue("Seleccione Departamento","-1"));//-------------------------------------------------Cargando Departamento
            for (int i=0;i<=_lsdepartamento.size()-1;i++)
            {
                _item.addElement(new DisplayValue(_lsdepartamento.get(i).getUbi_cdepartamento(), _lsdepartamento.get(i).getUbi_ccoddepa()));
            }
            _modelodepartamento = new DefaultComboBoxModel(_item); 
            cmbdepartamento.setModel(_modelodepartamento);
            cmbprovincia.removeAllItems();
            cmbdistrito.removeAllItems();
            EstablecerInstancia();
            txtalias.setDocument(new JTextFielCharLimit(MaximoCharacter.StrAliasSimple));
            txtdireccion.setDocument(new JTextFielCharLimit((MaximoCharacter.StrdireccionSimple)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbdepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdepartamentoActionPerformed
        try {
                if(cmbdepartamento.getSelectedIndex()>0)
               {
                    DisplayValue _valor = ((DisplayValue)cmbdepartamento.getSelectedItem());  
                    String codigo=_valor.getValueMenber();
                    CargarProvincia(codigo);
               }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbdepartamentoActionPerformed

    private void cmbprovinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprovinciaActionPerformed
        try {
                 if(cmbprovincia.getSelectedIndex()>0)
                   {
                        DisplayValue _valor = ((DisplayValue)cmbprovincia.getSelectedItem());  
                        String codigo=_valor.getValueMenber();
                        CargarDistrito(codigo);
                   }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbprovinciaActionPerformed
    private boolean  Validar()
    {
        try {
            if(txtalias.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un alias","Sucursal",JOptionPane.WARNING_MESSAGE);
                txtalias.setFocusable(true);
                return false;
            }
            if(txtdireccion.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un alias","Sucursal",JOptionPane.WARNING_MESSAGE);
                txtalias.setFocusable(true);
                return false;
            }
            if(cmbpais.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione pais","Sucursal",JOptionPane.WARNING_MESSAGE);
                cmbpais.setFocusable(true);
                return false;
            }
            if(cmbdepartamento.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Departamento","Sucursal",JOptionPane.WARNING_MESSAGE);
                cmbdepartamento.setFocusable(true);
                return false;
            }
            if(cmbprovincia.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Provincia","Sucursal",JOptionPane.WARNING_MESSAGE);
                cmbprovincia.setFocusable(true);
                return false;
            }
            if(cmbdistrito.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Distrito","Sucursal",JOptionPane.WARNING_MESSAGE);
                cmbdistrito.setFocusable(true);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    private void ClearFrm()
    {
        try {
            txtalias.setText("");
            txtdireccion.setText("");
            cmbpais.setSelectedIndex(0);
            cmbdepartamento.setSelectedIndex(0);
            cmbprovincia.setSelectedIndex(0);
            cmbdistrito.setSelectedIndex(0);
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
                        cmbpais.setEnabled(true);
                        cmbdepartamento.setEnabled(true);
                        cmbprovincia.setEnabled(true);
                        cmbdistrito.setEnabled(true);
                        txtalias.setEnabled(true);
                        txtdireccion.setEnabled(true);
                        lbcodigosucursal.setText("0");
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        btnBuscar.setEnabled(false);
                        cmbpais.setEnabled(true);
                        cmbdepartamento.setEnabled(true);
                        cmbprovincia.setEnabled(true);
                        cmbdistrito.setEnabled(true);
                        txtalias.setEnabled(true);
                        txtdireccion.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        cmbpais.setEnabled(false);
                        cmbdepartamento.setEnabled(false);
                        cmbprovincia.setEnabled(false);
                        cmbdistrito.setEnabled(false);
                        txtalias.setEnabled(false);
                        txtdireccion.setEnabled(false);
                        lbcodigosucursal.setText("0");
                        break;
                }
    }
    private void CargarProvincia(String x_codigo)
    {
        try {
                   _lsprovincia=_bubigeo.ObtenerTodos(2,x_codigo);
                    Vector _items = new Vector();        
                    _items.addElement(new DisplayValue("Seleccione Provincia", "-1"));//--------------------------------------Provincia
                    for (int i=0;i<=_lsprovincia.size()-1;i++)
                        _items.addElement(new DisplayValue(_lsprovincia.get(i).getUbi_cprovincia(), _lsprovincia.get(i).getUbi_codpro()));
                    _modeloprovincia = new DefaultComboBoxModel(_items); 
                    cmbprovincia.setModel(_modeloprovincia);
        } catch (Exception e) {
        }
    }
    private void CargarDistrito(String x_codigo)
    {
        try {
                        _lsdistrito=_bubigeo.ObtenerTodos(3,x_codigo);
                        Vector _items = new Vector();        
                        _items.addElement(new DisplayValue("Seleccione Distrito", "-1"));//-------------------------------------------Distrito
                        for (int i=0;i<=_lsdistrito.size()-1;i++)
                            _items.addElement(new DisplayValue(_lsdistrito.get(i).getUbi_cdistrito(), _lsdistrito.get(i).getUbi_ccoddistri()));
                        _modelodistrito = new DefaultComboBoxModel(_items); 
                        cmbdistrito.setModel(_modelodistrito);
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbdepartamento;
    private javax.swing.JComboBox<String> cmbdistrito;
    private javax.swing.JComboBox<String> cmbpais;
    private javax.swing.JComboBox<String> cmbprovincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbcodigosucursal;
    private javax.swing.JLabel lbid;
    private javax.swing.JTextField txtalias;
    private javax.swing.JTextField txtdireccion;
    // End of variables declaration//GEN-END:variables
    void CargarSucursal() {
        try {
            if(!m_Codigo.equals(""))
            {
                _bsucursal = new BSucursal();
                _esucursal=_bsucursal.AccionObtenerUno(Integer.parseInt(m_Codigo));
                if(_esucursal!=null)
                {
                    SetItem();
                    btnEditar.setEnabled(true);
                }
            }
        } catch (Exception e) {
        }
    }
    void SetItem()
    {
        try {
            txtalias.setText(_esucursal.getSuc_sucdescripcion());
            txtdireccion.setText(_esucursal.getSuc_cdireccion());
            lbcodigosucursal.setText(""+_esucursal.getSuc_ncodigo());
            for(int i=0;i<=_modelopais.getSize()-1;i++)
            {
                DisplayValue _value=(DisplayValue)_modelopais.getElementAt(i);
                if(_value.getValueMenber().equals(""+_esucursal.getPai_ncodigo()))
                {
                    _modelopais.setSelectedItem(_value);
                    break;
                }
            }
            cmbpais.setModel(_modelopais);
            for(int i=0;i<=_modelodepartamento.getSize()-1;i++)
            {
                DisplayValue _value=(DisplayValue)_modelodepartamento.getElementAt(i);
                if(_value.getValueMenber().equals(_esucursal.getSuc_coddepa()))
                {
                    _modelodepartamento.setSelectedItem(_value);
                    break;
                }
            }
            cmbdepartamento.setModel(_modelodepartamento);
            DisplayValue _codigoDepartamento = ((DisplayValue)cmbdepartamento.getSelectedItem());  
            String codigo=_codigoDepartamento.getValueMenber();
            CargarProvincia(codigo);//----------------------------------------------------------------------Cargando Provincia
            for(int i=0;i<=_modeloprovincia.getSize()-1;i++)
            {
                DisplayValue _value=(DisplayValue)_modeloprovincia.getElementAt(i);
                if(_value.getValueMenber().equals(_esucursal.getSuc_codprov()))
                {
                    _modeloprovincia.setSelectedItem(_value);
                    break;
                }
            }
            cmbprovincia.setModel(_modeloprovincia);
            DisplayValue _codigoDistrito = ((DisplayValue)cmbprovincia.getSelectedItem());  
            codigo=_codigoDistrito.getValueMenber();
            CargarDistrito(codigo);//-----------------------------------------------------------------------Cargando Distrito
            for(int i=0;i<=_modelodistrito.getSize()-1;i++)
            {
                DisplayValue _value=(DisplayValue)_modelodistrito.getElementAt(i);
                if(_value.getValueMenber().equals(_esucursal.getSuc_coddistri()))
                {
                    _modelodistrito.setSelectedItem(_value);
                    break;
                }
            }
            cmbdistrito.setModel(_modelodistrito);
        } catch (Exception e) {
        }
    }
}

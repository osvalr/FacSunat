
package Principal;

import AccessoDato.ECliente;
import AccessoDato.EDireccion;
import AccessoDato.EDocumentoIdentidad;
import AccessoDato.EPlaca;
import AccessoDato.EUbigeo;
import Negocio.BCliente;
import Negocio.BDireccion;
import Negocio.BDocumentoIdentidad;
import Negocio.BUbigeo;
import Utilidad.DisplayValue;
import Utilidad.EditorCelda;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class  FrmCliente extends javax.swing.JInternalFrame{
    
    public JDesktopPane panelPrincila;
    public String m_Codigo=""; 
    public InstanciaForm m_Tipoinstancia;
    private BDocumentoIdentidad _bidentidad=null;
    private BCliente _bcliente=null;
    private ECliente _ecliente=null; 
    private BDireccion _bedireccion=null;
    private EDireccion _edireccion=null;
    private DefaultComboBoxModel modelo=null;
//    public List<EDireccion> _lsdireccion=new ArrayList<>();
    
//    private DefaultComboBoxModel modelodepartamento=null;
//    private DefaultComboBoxModel modeloprovincia=null;
//    private DefaultComboBoxModel modelodistrito=null;
    private List<EDocumentoIdentidad> _lseidentidad=null;
    public List<EDireccion> _lsedireccion=new ArrayList<>();
//    private List<EUbigeo> _lsdepartamento=new ArrayList<>();
//    private List<EUbigeo> _lsprovincia=new ArrayList<>();
//    private List<EUbigeo> _lsdistrito=new ArrayList<>();
    public List<EPlaca> _lsplaca=new ArrayList<>();
    private BUbigeo _bubigeo;
    private FrmCliente() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnplaca = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CmbDocumento = new javax.swing.JComboBox<>();
        txtNumeroDocumento = new javax.swing.JTextField();
        txtDireFiscal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCliRazonSocial = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnAgregarDireccion = new javax.swing.JButton();
        BtnEliminarDireccion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tdireccion = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Cliente");
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

        btnplaca.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\Numeroplaca.png")); // NOI18N
        btnplaca.setText("Placa");
        btnplaca.setFocusable(false);
        btnplaca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnplaca.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnplaca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplacaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnplaca);

        btnBuscar1.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\sunat24.png")); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setEnabled(false);
        btnBuscar1.setFocusable(false);
        btnBuscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnBuscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar1);

        jLabel3.setText("Tipo Documento");

        jLabel2.setText("Nro. Documento");

        jLabel4.setText("Direccion Fiscal");

        CmbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbDocumentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Razón Social/ Apellidos");

        lbCodigo.setText("0");
        lbCodigo.setEnabled(false);
        lbCodigo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel5.setText("ID");
        jLabel5.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmbDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliRazonSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireFiscal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnAgregarDireccion.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\additem.png")); // NOI18N
        BtnAgregarDireccion.setMaximumSize(new java.awt.Dimension(95, 25));
        BtnAgregarDireccion.setMinimumSize(new java.awt.Dimension(95, 25));
        BtnAgregarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarDireccionActionPerformed(evt);
            }
        });

        BtnEliminarDireccion.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\removeitem.png")); // NOI18N
        BtnEliminarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarDireccionActionPerformed(evt);
            }
        });

        Tdireccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tdireccion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tdireccion.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TdireccionInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(Tdireccion);
        Tdireccion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnmodificar.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\editaritems.png")); // NOI18N
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAgregarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnAgregarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Vector _items=null;
    FrmAdddireccion frmadd;
    Dimension desktopSize; 
    Dimension Internal;
    private void BtnAgregarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarDireccionActionPerformed
       
        try {
             frmadd = FrmAdddireccion.getInstancia(this);
             frmadd.m_Tipoinstancia=InstanciaForm.NEW;
             frmadd.m_escritorio=panelPrincila;
             desktopSize = panelPrincila.getSize();
             Internal = frmadd.getSize();
             frmadd.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
            if(!panelPrincila.isAncestorOf(frmadd))//if(frmadd==null)
            {

                panelPrincila.add(frmadd);
                frmadd.setVisible(true);  
                frmadd.setSelected(true);
            }
            else
            {   
                panelPrincila.setSelectedFrame(frmadd);
                frmadd.show();
            }
//            frmadd.CargarDato();
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE); }

    }//GEN-LAST:event_BtnAgregarDireccionActionPerformed

    private void BtnEliminarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarDireccionActionPerformed
        
        try
        {
               int _filaselecionada = Tdireccion.getSelectedRow();
               if(_filaselecionada>=0)
               {
                   
                   
                   String _codigo=(String) Tdireccion.getValueAt(_filaselecionada, 0);
                   String _descripcion=(String) Tdireccion.getValueAt(_filaselecionada, 1);
                   if(!"".equals(_codigo))
                   {  
                       if(!_bedireccion.VerificarAsignacionDireccion(Integer.parseInt(_codigo)))
                       {
                           for(int i=0;i<=_lsedireccion.size()-1;i++)
                           {
                               _edireccion=_lsedireccion.get(i);
                               if(_edireccion.getDir_cdescripcion().equals(_descripcion))
                                   _lsedireccion.remove(i);
                           }
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Esta direccion esta asignada no se puede eliminar", "Mensaje",JOptionPane.WARNING_MESSAGE);

                       }
                       
                   }
                   else
                   {
                       for(int i=0;i<=_lsedireccion.size()-1;i++)
                       {
                           _edireccion=_lsedireccion.get(i);
                           if(_edireccion.getDir_ncodigo()==Integer.parseInt(_codigo))
                           {
                               _edireccion.setM_Instancia(InstancaEntidad.DELETE);
                               _lsedireccion.set(i, _edireccion);
                           }
                       }
                   }
                   ((DefaultTableModel)Tdireccion.getModel()).removeRow(_filaselecionada);       
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Seleccione una Fila", "Mensaje",JOptionPane.WARNING_MESSAGE);
               }
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_BtnEliminarDireccionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            m_Tipoinstancia= InstanciaForm.NEW;
            ClearForm();
            EstablecerInstancia();
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Se produjo un error inesperado :"+  e.getMessage());
        } 
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try
        {
             if(Validar())
             {
                 if(m_Tipoinstancia==InstanciaForm.MODIFY)
                 {
                     GetItem();
                     _bcliente= new BCliente();
                     if(_bcliente.AcccionModificar(_ecliente,_lsedireccion,_lsplaca))
                        JOptionPane.showMessageDialog(null, "Cambios guardados", "Cliente",JOptionPane.INFORMATION_MESSAGE);
                     else
                         JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Cliente",JOptionPane.INFORMATION_MESSAGE);
                 }
                 else if(m_Tipoinstancia==InstanciaForm.NEW)
                 {
                     GetItem();
                     _bcliente= new BCliente();
                     if(_bcliente.AcccionGuardar(_ecliente,_lsedireccion,_lsplaca))
                     {
                        JOptionPane.showMessageDialog(null, "Se guardo correctamente.", "Cliente",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else
                         JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Cliente",JOptionPane.INFORMATION_MESSAGE);
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try
        {
            FrmBuscar _buscar = new FrmBuscar(1,this);
            panelPrincila.add(_buscar); 
            _buscar.show();            
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarActionPerformed

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
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            _bidentidad = new BDocumentoIdentidad();
            _lseidentidad=_bidentidad.AccionTraerTodo();
            _bubigeo= new BUbigeo();
//            _lsdepartamento=_bubigeo.ObtenerTodos(1,"");
//            cmbdepartamento.removeAllItems();//---------------------Limbiando controles combo
//            cmbprovincia.removeAllItems();
//            cmbdistrito.removeAllItems();
//            CmbDocumento.removeAllItems();
//            _items = new Vector();
//            _items.addElement(new DisplayValue("Seleccione Departamento", "-1"));//-------------------------------------Departamento
//            for (int i=0;i<=_lsdepartamento.size()-1;i++)
//                _items.addElement(new DisplayValue(_lsdepartamento.get(i).getUbi_cdepartamento(), _lsdepartamento.get(i).getUbi_ccoddepa()));
//            modelodepartamento = new DefaultComboBoxModel(_items); 
//            cmbdepartamento.setModel(modelodepartamento);
             _items = new Vector();
            _items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
            for (int i=0;i<=_lseidentidad.size()-1;i++)
            {
                _items.addElement(new DisplayValue(_lseidentidad.get(i).getDoi_cdescripcion(), _lseidentidad.get(i).getDoi_ccodigo()));
            }
            modelo = new DefaultComboBoxModel(_items);                       
            CmbDocumento.setModel(modelo);
            DefinirTabla();
            EstablecerInstancia();
            txtDireFiscal.setDocument(new JTextFielCharLimit(MaximoCharacter.DocMaxCharDireccion));
            txtCliRazonSocial.setDocument(new JTextFielCharLimit(MaximoCharacter.DocMaxCharNombre));
            
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);      }
    }//GEN-LAST:event_formInternalFrameOpened

    private void TdireccionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TdireccionInputMethodTextChanged
        JOptionPane.showMessageDialog(null, "Error :"+evt.toString(),"Mensaje",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_TdireccionInputMethodTextChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
            _bcliente = new BCliente();
            _bedireccion = new BDireccion();
            _bedireccion.AcccionEliminarxcliente(_ecliente.getCli_ncodigo());
            if(_bcliente.Acccioneliminar(_ecliente.getCli_ncodigo()))
            {
                JOptionPane.showMessageDialog(null, "Cliente fue eliminado","Mensaje",JOptionPane.WARNING_MESSAGE);
                m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                ClearForm();
                EstablecerInstancia();
            }
        }
        catch(Exception e)
        {        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    JEditorPane website;
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        try
        {
        }
        catch(Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed
    int posicion=-1;
    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        try {
            
               int _filaselecionada = Tdireccion.getSelectedRow();
               if(_filaselecionada>=0)
               {
                    posicion=-1;
                    frmadd = FrmAdddireccion.getInstancia(this);
                    int _codigo=0;
                    String instancia= Tdireccion.getValueAt(_filaselecionada, 2).toString();
                    if(instancia.equals(""+InstancaEntidad.UNCHANGUE)||instancia.equals(""+InstancaEntidad.MODIFY) )
                    {
                        _codigo= Integer.parseInt(Tdireccion.getValueAt(_filaselecionada, 0).toString());
                        _edireccion=_bedireccion.AcctionObtenerUnaDireccion(_codigo);
                    }
                    else
                    {
                        _edireccion=new EDireccion();
                        _edireccion.setDir_cdescripcion(Tdireccion.getValueAt(_filaselecionada, 1).toString());
                        _edireccion.setM_Instancia(InstancaEntidad.NEW);
                        posicion=_filaselecionada;
                    }
                    frmadd.m_Tipoinstancia=instancia.equals(""+InstancaEntidad.NEW)?InstanciaForm.NEW:InstanciaForm.MODIFY;
                    frmadd.m_escritorio=panelPrincila;
                    desktopSize = panelPrincila.getSize();
                    Internal = frmadd.getSize();
                    frmadd.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                    if(!panelPrincila.isAncestorOf(frmadd))//if(frmadd==null)
                    {
                        
//                        frmadd.m_Tipoinstancia=instancia.equals(""+InstancaEntidad.UNCHANGUE)?InstanciaForm.MODIFY:InstanciaForm.MODIFY;
                        
                        frmadd.setVisible(true);  
                        panelPrincila.add(frmadd);
                        frmadd.setSelected(true);
                    }
                    else
                    {   
//                        desktopSize = frmadd.getSize();
//                        Internal = frmadd.getSize();
////                        frmadd.m_Tipoinstancia=instancia.equals(""+InstancaEntidad.UNCHANGUE)?InstanciaForm.MODIFY:InstanciaForm.MODIFY;
//                        frmadd.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
//                        frmadd.setVisible(true);
//                        frmadd.setSelected(true); 
                        panelPrincila.setSelectedFrame(frmadd);
                        frmadd.show();
                    }
                    frmadd.setEdireccion(_edireccion);
                    frmadd.CargarDato();
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Seleccione un fila.", "Mensaje",JOptionPane.WARNING_MESSAGE);
               }
            
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Errores. :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE); }
        
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void CmbDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbDocumentoActionPerformed
        try {
            if(CmbDocumento.getSelectedIndex()>=0)
            {
                txtNumeroDocumento.setText("");
                DisplayValue _valor=(DisplayValue)CmbDocumento.getSelectedItem();
                if(_valor.getValueMenber().equals("6"))
                    txtNumeroDocumento.setDocument(new JTextFielCharLimit(MaximoCharacter.DocuMaxCharRuc));
                else
                    txtNumeroDocumento.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDni)));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CmbDocumentoActionPerformed

    FrmPlaca frmplaca;
    
    private void btnplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplacaActionPerformed
        try {
            frmplaca = FrmPlaca.getinstancia(this);
            frmplaca.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
            
            if(!panelPrincila.isAncestorOf(frmplaca))//if(frmplaca==null)
            {
                frmplaca.setM_Codigo(lbCodigo.getText());
                frmplaca._lsplaca=_lsplaca;
                frmplaca.panelPrincila=panelPrincila;
                desktopSize = panelPrincila.getSize();
                Internal = frmplaca.getSize();
                frmplaca.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                frmplaca.setVisible(true);  
                panelPrincila.add(frmplaca);
                frmplaca.setSelected(true);
                //frmplaca.CargarDatos();
            }
            else
            {
                frmplaca._lsplaca=_lsplaca;
                panelPrincila.setSelectedFrame(frmplaca);
                frmplaca.setM_Codigo(lbCodigo.getText());
                frmplaca.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                frmplaca.setVisible(true);
                frmplaca.setSelected(true); 
                //frmplaca.CargarDatos();
            }
            frmplaca.CargarDatos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnplacaActionPerformed

    private void ClearForm()
    {
        txtCliRazonSocial.setText("");
        txtNumeroDocumento.setText("");
        txtDireFiscal.setText("");
        CmbDocumento.setSelectedIndex(0);
//        cmbdepartamento.setSelectedIndex(0);
//        if(cmbprovincia.getItemCount()>0)
//            cmbprovincia.setSelectedIndex(0);
//        if(cmbdistrito.getItemCount()>0)
//            cmbdistrito.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) Tdireccion.getModel();
        dtm.setNumRows(0);
        Tdireccion.setModel(dtm);
        _lsedireccion.clear();
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
                        txtCliRazonSocial.setEnabled(true);
                        txtNumeroDocumento.setEnabled(true);
                        txtDireFiscal.setEnabled(true);
                        CmbDocumento.setEnabled(true);
                        BtnAgregarDireccion.setEnabled(true);
                        BtnEliminarDireccion.setEnabled(true);
                        btnmodificar.setEnabled(true);
                        lbCodigo.setText("0");
                        btnplaca.setEnabled(true);
//                        cmbdepartamento.setEnabled(true);
//                        cmbprovincia.setEnabled(true);
//                        cmbdistrito.setEnabled(true);
                        break;
                    case MODIFY :
                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        btnBuscar.setEnabled(false);
                        txtCliRazonSocial.setEnabled(true);
                        txtNumeroDocumento.setEnabled(true);
                        txtDireFiscal.setEnabled(true);
                        CmbDocumento.setEnabled(true);
                        BtnAgregarDireccion.setEnabled(true);
                        BtnEliminarDireccion.setEnabled(true);
//                        cmbdepartamento.setEnabled(true);
//                        cmbprovincia.setEnabled(true);
//                        cmbdistrito.setEnabled(true);
                        Tdireccion.setEnabled(true);
                        btnmodificar.setEnabled(true);
                        btnplaca.setEnabled(true);
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
                        btnBuscar.setEnabled(true);
                        txtCliRazonSocial.setEnabled(false);
                        txtNumeroDocumento.setEnabled(false);
                        txtDireFiscal.setEnabled(false);
                        CmbDocumento.setEnabled(false);
                        BtnAgregarDireccion.setEnabled(false);
                        BtnEliminarDireccion.setEnabled(false);
                        btnmodificar.setEnabled(false);
                        lbCodigo.setText("0");
                        btnplaca.setEnabled(false);
//                        cmbdepartamento.setEnabled(false);
//                        cmbprovincia.setEnabled(false);
//                        cmbdistrito.setEnabled(false);
                        break;
                }
    }
    public void CargarFrm()
    {        
        try
        {
            if(!"".equals(m_Codigo))
            {
                _bcliente = new BCliente();
                _ecliente =  _bcliente.ObtenerUno(Integer.parseInt(m_Codigo));
                SetItem();
                _bedireccion = new BDireccion();
                _lsedireccion = _bedireccion.AcccionObtenerLista(Integer.parseInt(m_Codigo));  
                if(_lsedireccion.size()>0)
                    SetItemDetalle();
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
            if(_ecliente!=null)
            {
                
                for(int i=0;i<=modelo.getSize()-1;i++)
                {
                        DisplayValue _valor=(DisplayValue) modelo.getElementAt(i);
                        if(_valor.valueMenber.equals(_ecliente.getCoi_ccodigo()))
                        {
                            modelo.setSelectedItem(_valor);
                            break;
                        }                    
                }
                CmbDocumento.setModel(modelo);
                lbCodigo.setText(_ecliente.getCli_ncodigo().toString());
                txtCliRazonSocial.setText(_ecliente.getCli_crazon());
                txtNumeroDocumento.setText(_ecliente.getCli_cnumerodoc());
                txtDireFiscal.setText(_ecliente.getCli_cdireccionfiscal());
//                _bubigeo = new BUbigeo();
//                EUbigeo _eubugeo = _bubigeo.ObtenerUnoxCodigo(_ecliente.getCli_ncodubigeo());
//                
//                for(int i=0;i<=modelodepartamento.getSize()-1;i++)
//                {
//                        DisplayValue _valor=(DisplayValue) modelodepartamento.getElementAt(i);
//                        if(_valor.valueMenber.equals(_eubugeo.getUbi_ccoddepa()))
//                        {
//                            modelodepartamento.setSelectedItem(_valor);
//                            break;
//                        } 
//                }
//                cmbdepartamento.setModel(modelodepartamento);
//                for(int i=0;i<=modeloprovincia.getSize()-1;i++)
//                {
//                        DisplayValue _valor=(DisplayValue) modeloprovincia.getElementAt(i);
//                        if(_valor.valueMenber.equals(""+_eubugeo.getUbi_codpro()))
//                        {
//                            modeloprovincia.setSelectedItem(_valor);
//                            break;
//                        } 
//                }
//                cmbprovincia.setModel(modeloprovincia);
//                for(int i=0;i<=modelodistrito.getSize()-1;i++)
//                {
//                        DisplayValue _valor=(DisplayValue) modelodistrito.getElementAt(i);
//                        if(_valor.valueMenber.equals(""+_eubugeo.getUbi_ccoddistri()))
//                        {
//                            modelodistrito.setSelectedItem(_valor);
//                            break;
//                        } 
//                }
//                cmbdistrito.setModel(modelodistrito);
            }
        }
        catch(Exception e)
        {}
    }
    
    private void SetItemDetalle()
    {
        try
        {
                        DefaultTableModel _mod = (DefaultTableModel) Tdireccion.getModel();
                        _mod.setNumRows(0);
                        Object[] rowData = new Object[3];
                        for (int i=0;i<=_lsedireccion.size()-1;i++)
                        {
                            rowData[0]=_lsedireccion.get(i).getDir_ncodigo();
                            rowData[1]=_lsedireccion.get(i).getDir_cdescripcion();
                            rowData[2]=_lsedireccion.get(i).getM_Instancia();
                            _mod.addRow(rowData);
                         }
                        Tdireccion.setModel(_mod);
//                        Tdireccion.setEnabled(false);
        }
        catch(Exception e)
        {}
    }
    private void GetItem()
    {
        try
        {
            if(_ecliente==null)
            {             
                _ecliente = new ECliente();
            }
            _ecliente.setCli_crazon(txtCliRazonSocial.getText());
            _ecliente.setCli_cnumerodoc(txtNumeroDocumento.getText());
            _ecliente.setCli_cdireccionfiscal(txtDireFiscal.getText());
            DisplayValue _valor = ((DisplayValue)CmbDocumento.getSelectedItem());            
            _ecliente.setCoi_ccodigo(_valor.getValueMenber());
            //obteniendo id del ubigeo
//            DisplayValue _vdistrito = ((DisplayValue)cmbdistrito.getSelectedItem());            
//            _ecliente.setCli_ncodubigeo(_bubigeo.ObtenerUno(_vdistrito.getValueMenber()));
//            if(Tdireccion.getRowCount()>0)
//              {
//                  for (int i=0;i<=Tdireccion.getRowCount()-1;i++)
//                  {
//                      
//                      if(Tdireccion.getValueAt(i, 2).toString().equals("NEW"))
//                      {
//                          _edireccion = new EDireccion();
//                          _edireccion.setM_Instancia(InstancaEntidad.NEW);
//                          _edireccion.setDir_cdescripcion(Tdireccion.getValueAt(i, 1).toString());
//                          _lsedireccion.add(_edireccion);
//                      }
//                      if(Tdireccion.getValueAt(i, 2).toString().equals("MODIFY") || Tdireccion.getValueAt(i, 1).toString().equals("DELETE"))
//                      {
//                                String _codigo=Tdireccion.getValueAt(i, 0).toString();
////                              _edireccion=_lsedireccion.stream().filter(a-> a.getDir_ncodigo()==Integer.parseInt(_codigo)).findFirst().orElse(null);
//                                for (int k=0;k<=_lsedireccion.size()-1;k++)
//                                {
//                                    if(_lsedireccion.get(k).getDir_ncodigo()==Integer.parseInt(_codigo))
//                                    {
//                                        _edireccion=_lsedireccion.get(k);
//                                        _edireccion.setM_Instancia(InstancaEntidad.MODIFY);
//                                        _edireccion.setDir_cdescripcion(Tdireccion.getValueAt(Tdireccion.getSelectedRow()-1, 1).toString());
//                                        _lsedireccion.set(k, _edireccion);
//                                        break;
//                                    }
//                                }
//                      }
//                  }
//              }  
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error ."+e.getMessage(), "Cliente",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarDireccion;
    private javax.swing.JButton BtnEliminarDireccion;
    private javax.swing.JComboBox<String> CmbDocumento;
    private javax.swing.JTable Tdireccion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnplaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JTextField txtCliRazonSocial;
    private javax.swing.JTextField txtDireFiscal;
    private javax.swing.JTextField txtNumeroDocumento;
    // End of variables declaration//GEN-END:variables

   private static FrmCliente m_frminstancia;
   public static FrmCliente getInstancia()
   {
       if(m_frminstancia==null)
           m_frminstancia=new FrmCliente();
       
        return m_frminstancia;
   }

   private void DefinirTabla()
   {
       try {
            DefaultTableModel mdo = new DefaultTableModel()
            {//-----------------------------------------------------------------------DESABILITANDO COLUMNAS 
                boolean[] canEdit = new boolean[]{ false,true,false};
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                {  return canEdit[columnIndex];}
            };
            Object[] columname = new Object[3];
            columname[0]="codigo";
            columname[1]="Direccion";
            columname[2]="Instancia";                     
            mdo.setColumnIdentifiers(columname);
            Tdireccion.setModel(mdo);
            Tdireccion.getColumn("Direccion").setPreferredWidth(250);
            Tdireccion.getColumn("Direccion").setMinWidth(250);
            Tdireccion.getColumn("Direccion").setWidth(250);
            Tdireccion.getColumn("Direccion").setMaxWidth(250);
            Tdireccion.getColumn("Instancia").setPreferredWidth(0);
            Tdireccion.getColumn("Instancia").setMinWidth(0);
            Tdireccion.getColumn("Instancia").setWidth(0);
            Tdireccion.getColumn("Instancia").setMaxWidth(0);
            Tdireccion.getColumn("codigo").setPreferredWidth(0);
            Tdireccion.getColumn("codigo").setMinWidth(0);
            Tdireccion.getColumn("codigo").setWidth(0);
            Tdireccion.getColumn("codigo").setMaxWidth(0);
            Tdireccion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            Tdireccion.getTableHeader().setReorderingAllowed(false);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error definiendo tabla :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
       }
   }
   private boolean Validar()
   {
       try {
        if(txtNumeroDocumento.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese un numero documento.","Cliente",JOptionPane.WARNING_MESSAGE);
            txtNumeroDocumento.setFocusable(true);
            return false;
        }
        if(txtCliRazonSocial.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre/razon social.","Cliente",JOptionPane.WARNING_MESSAGE);
            txtCliRazonSocial.setFocusable(true);
            return false;
        }
        if(txtDireFiscal.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese una direccion.","Cliente",JOptionPane.WARNING_MESSAGE);
            txtDireFiscal.setFocusable(true);
            return false;
        }
        
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error validando:"+e.getMessage(),"Cliente",JOptionPane.WARNING_MESSAGE);
       }
       return true;
   }
   
   public void CargarDireccionAdicional()
   {
       try {
           if(_edireccion.getM_Instancia()==InstancaEntidad.NEW)
           {   
               if(posicion!=-1)
               {   
                   _lsedireccion.set(posicion, _edireccion);
                   posicion=-1;
               }else
               _lsedireccion.add(_edireccion);
               
           }
           else if(_edireccion.getM_Instancia()==InstancaEntidad.MODIFY)
           {
              for(int i=0;i<=_lsedireccion.size()-1;i++)
              {
                  if(Objects.equals(_lsedireccion.get(i).getDir_ncodigo(), _edireccion.getDir_ncodigo()))
                  {
                      _lsedireccion.set(i, _edireccion);
                      break;
                  }
              }
           }
           SetItemDetalle();
       } catch (Exception e) {
       }
   }

    public EDireccion getEdireccion() {
        return _edireccion;
    }

    public void setEdireccion(EDireccion _edireccion) {
        this._edireccion = _edireccion;
    }

  
}


package Principal;

import AccessoDato.EPlaca;
import Negocio.BPlaca;
import Utilidad.InstanciaEntidad;
import Utilidad.InstanciaForm;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmPlaca extends javax.swing.JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane panelPrincila;
    private String m_Codigo;
    private static FrmPlaca frmplaca;
    private EPlaca _eplaca;
    public List<EPlaca> _lsplaca=new ArrayList<>();
    private BPlaca _bplaca;
    private FrmCliente frmcliente;
    public int _CodigoCliente;
    public static FrmPlaca getinstancia(FrmCliente x_cliente)
    {
        if(frmplaca==null)
            frmplaca=new FrmPlaca(x_cliente);
        return frmplaca;
    }
    public FrmPlaca() {
        initComponents();
    }

    public FrmPlaca(FrmCliente x_cliente)
    {
         initComponents();
         frmcliente=x_cliente;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleplaca = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Placas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        btnNuevo.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\addplaca.png")); // NOI18N
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

        btnEditar.setIcon(new javax.swing.ImageIcon("D:\\FacturaElectronica-Modificado\\FacturaElectronica-24-06-2016\\img\\editplaca.png")); // NOI18N
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

        btnDeshacer.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\FacturaElectronica\\img\\limpiar.png")); // NOI18N
        btnDeshacer.setText("Deshacer");
        btnDeshacer.setEnabled(false);
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        detalleplaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detalleplaca);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    FrmAddPlaca frmaddplaca;
    Dimension desktopSize; 
    Dimension Internal;
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try
        {
            try {
                
                    frmaddplaca = FrmAddPlaca.getinstancia(this);
                    frmaddplaca.m_Tipoinstancia=InstanciaForm.NEW;
                    if(!panelPrincila.isAncestorOf(frmaddplaca))
                    {
                        frmaddplaca.panelPrincila=panelPrincila;
                        desktopSize = panelPrincila.getSize();
                        Internal = frmaddplaca.getSize();
                        frmaddplaca.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                        panelPrincila.add(frmaddplaca);
                        frmaddplaca.setVisible(true);
                        frmaddplaca.setSelected(true);
                        frmaddplaca.CargarDato();
                    }
                    else
                    {
                        this.panelPrincila.setSelectedFrame(frmaddplaca);
                        frmaddplaca.show();
//                        frmaddplaca.setSelected(true); 
                    }
        } catch (Exception e) {
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se producjo un error inesperado :"+  e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

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
            try {
            int _filaselecionada = detalleplaca.getSelectedRow();
            if(_filaselecionada>=0)
            {
                String _codigo=detalleplaca.getValueAt(_filaselecionada, 0).toString();
                if(!_codigo.equals(""))
                {
                    //Verificamos primero si se puede eliminar.
                    _bplaca = new BPlaca();
                    if(!_bplaca.AccionValidarPlacaExistente(Integer.parseInt(_codigo)))
                    {
                        String _codigoplaca=(String) detalleplaca.getValueAt(_filaselecionada, 0);
                        String _descripcion=(String) detalleplaca.getValueAt(_filaselecionada, 1);
                        if(!"".equals(_codigo))
                        {                       
                            for(int i=0;i<=_lsplaca.size()-1;i++)
                            {
                                _eplaca=_lsplaca.get(i);
                                if(_eplaca.getPla_cnombre().equals(_descripcion))
                                    _lsplaca.remove(i);
                            }
                        }
                        else
                        {
                            for(int i=0;i<=_lsplaca.size()-1;i++)
                            {
                                _eplaca=_lsplaca.get(i);
                                if(_eplaca.getPla_ncodigo()==Integer.parseInt(_codigo))
                                {
                                    _eplaca.setM_instancia(InstanciaEntidad.DELETE);
                                    _lsplaca.set(i, _eplaca);
                                }
                            }
                        }
                        ((DefaultTableModel)detalleplaca.getModel()).removeRow(_filaselecionada);  
                    }
                    else
                       JOptionPane.showMessageDialog(null, "Esta placa esta asignada no se puede eliminar", "Mensaje",JOptionPane.WARNING_MESSAGE);

                }
            }
            else
                JOptionPane.showMessageDialog(null, "Seleccione una Fila", "Mensaje",JOptionPane.WARNING_MESSAGE);

            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error al eliminar.", "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    private int posicion=-1;
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
                int _filaselecionada = detalleplaca.getSelectedRow();
               if(_filaselecionada>=0)
               {
                    posicion=-1;
                    frmaddplaca = FrmAddPlaca.getinstancia(this);
                    int _codigo=0;
                    String instancia= detalleplaca.getValueAt(_filaselecionada, 2).toString();
                    if(instancia.equals(""+InstanciaEntidad.UNCHANGUE)||instancia.equals(""+InstanciaEntidad.MODIFY) )
                    {
                        _codigo= Integer.parseInt(detalleplaca.getValueAt(_filaselecionada, 0).toString());
                        _eplaca=_bplaca.AcctionObtenerUnaPlacaxId(_codigo);
                    }
                    else
                    {
                        _eplaca=new EPlaca();
                        _eplaca.setPla_cnombre(detalleplaca.getValueAt(_filaselecionada, 1).toString());
                        _eplaca.setM_instancia(InstanciaEntidad.NEW);
                        posicion=_filaselecionada;
                    }
                    frmaddplaca.m_Tipoinstancia=instancia.equals(""+InstanciaEntidad.NEW)?InstanciaForm.NEW:InstanciaForm.MODIFY;
                    frmaddplaca.panelPrincila =panelPrincila;
                    desktopSize = panelPrincila.getSize();
                    Internal = frmaddplaca.getSize();
                    frmaddplaca.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                    if(!panelPrincila.isAncestorOf(frmaddplaca))//if(frmadd==null)
                    {
                        frmaddplaca.setVisible(true);  
                        panelPrincila.add(frmaddplaca);
                        frmaddplaca.setSelected(true);
                    }
                    else
                    {   
                        panelPrincila.setSelectedFrame(frmaddplaca);
                        frmaddplaca.show();
                    }
                    frmaddplaca.setEplaca(_eplaca);
                    frmaddplaca.CargarDato();
               }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       
        try {
            DefinirTabla();
            SetPlacas();
        } catch (Exception e) {
        }
           
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

//        frmcliente._lsplaca=_lsplaca;
//        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        frmcliente._lsplaca=_lsplaca;
    }//GEN-LAST:event_formInternalFrameClosing
    
    private void ClearForm()
    {
        try {
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error cargando Formulario:"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void EstablecerInstancia()
    {
        switch (m_Tipoinstancia)
                {
                    case NEW:
                        m_Codigo="";
//                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(false); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
                        
                        break;
                    case MODIFY :
//                        btnGuardar.setEnabled(true);
                        btnEliminar.setEnabled(true); 
                        btnNuevo.setEnabled(false);
                        btnDeshacer.setEnabled(true);
//                        btnBuscar.setEnabled(false);
                        
                        break;
                    case UNCHANGUE:
                        m_Codigo="";
                        btnNuevo.setEnabled(true);
//                        btnGuardar.setEnabled(false);
                        btnEliminar.setEnabled(false); 
                        btnEditar.setEnabled(false);
                        btnDeshacer.setEnabled(false);
//                        btnBuscar.setEnabled(true);
                        
                        break;
                }
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
            columname[1]="placa";
            columname[2]="Instancia";                     
            mdo.setColumnIdentifiers(columname);
            detalleplaca.setModel(mdo);
            detalleplaca.getColumn("placa").setPreferredWidth(100);
            detalleplaca.getColumn("placa").setMinWidth(100);
            detalleplaca.getColumn("placa").setWidth(100);
            detalleplaca.getColumn("placa").setMaxWidth(100);
            detalleplaca.getColumn("Instancia").setPreferredWidth(0);
            detalleplaca.getColumn("Instancia").setMinWidth(0);
            detalleplaca.getColumn("Instancia").setWidth(0);
            detalleplaca.getColumn("Instancia").setMaxWidth(0);
            detalleplaca.getColumn("codigo").setPreferredWidth(0);
            detalleplaca.getColumn("codigo").setMinWidth(0);
            detalleplaca.getColumn("codigo").setWidth(0);
            detalleplaca.getColumn("codigo").setMaxWidth(0);
            detalleplaca.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            detalleplaca.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error cargando Tabla:"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE); }
    }
    public void CargarPlaca()
    {
        try {
            
             if(_eplaca.getM_instancia()==InstanciaEntidad.NEW)
             {
                 if(posicion!=-1)
                 {
                     _lsplaca.set(posicion, _eplaca);
                     posicion=-1;
                 }
                 else
                     _lsplaca.add(_eplaca);
             }else if(_eplaca.getM_instancia()==InstanciaEntidad.MODIFY)
             {
                 for(int i=0;i<=_lsplaca.size()-1;i++)
                 {
                     if(Objects.equals(_lsplaca.get(i).getPla_ncodigo(), _eplaca.getPla_ncodigo()))
                     {
                         _lsplaca.set(i, _eplaca);
                         break;
                     }
                 }
             }
             SetPlacas();

        } catch (Exception e) {
        }
    }
    
    private void SetPlacas()
    {
        try {
                        DefaultTableModel _mod = (DefaultTableModel) detalleplaca.getModel();
                        _mod.setNumRows(0);
                        Object[] rowData = new Object[3];
                        for (int i=0;i<=_lsplaca.size()-1;i++)
                        {
                            rowData[0]=_lsplaca.get(i).getPla_ncodigo();
                            rowData[1]=_lsplaca.get(i).getPla_cnombre();
                            rowData[2]=_lsplaca.get(i).getM_instancia();
                            _mod.addRow(rowData);
                         }
                        detalleplaca.setModel(_mod);
                        _eplaca=null;
        } catch (Exception e) {
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTable detalleplaca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public String getM_Codigo() {
        return m_Codigo;
    }

    public void setM_Codigo(String m_Codigo) {
        this.m_Codigo = m_Codigo;
    }

    public EPlaca getEplaca() {
        return _eplaca;
    }

    public void setEplaca(EPlaca _eplaca) {
        this._eplaca = _eplaca;
    }
    public void CargarDatos()
    {
        _bplaca = new BPlaca();
        _lsplaca=_bplaca.AccionObtenerListaPlacaxIdCliente(Integer.parseInt(m_Codigo));            
        SetPlacas();
    }



}

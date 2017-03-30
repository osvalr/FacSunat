/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import AccessoDato.DAOTablasSolas;
import AccessoDato.EDocumento;
import AccessoDato.EEmpresa;
import AccessoDato.EFactura;
import Negocio.BEmpresa;
import Negocio.BFactura;
import Utilidad.DisplayValue;
import Utilidad.DocumentoBaja;
import Utilidad.InstanciaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrmComunicacionBaja extends javax.swing.JInternalFrame  {

    private FrmComunicacionBaja() {
        initComponents();
    }
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    private static FrmComunicacionBaja frmComunicacionBaja;
    private DAOTablasSolas tbldocumento;
    private List<EDocumento> listaDocumento = new ArrayList<>();
    private EFactura efactura;
    private BFactura bfactura;
    private List<EFactura> listaFactura = new ArrayList<>();
    private BEmpresa bempresa;
    private EEmpresa eempresa;
    public static FrmComunicacionBaja getinstancia()
    {
        if(frmComunicacionBaja==null)
                frmComunicacionBaja = new FrmComunicacionBaja();
        return frmComunicacionBaja;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtserie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocumentoBaja = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comunicacion Baja");
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

        jLabel1.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Serie");

        jLabel3.setText("Numero");

        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeroKeyPressed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon("D:\\FE\\FacturaElectronica-24-06-2016\\img\\buscadorRegistro.png")); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addContainerGap(23, Short.MAX_VALUE))
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

        btnlimpiar.setIcon(new javax.swing.ImageIcon("D:\\FE\\FacturaElectronica-24-06-2016\\img\\limpiar.png")); // NOI18N
        btnlimpiar.setText("Limpiar");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Items a dar de Baja", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblDocumentoBaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDocumentoBaja);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       try
       {
           tbldocumento = new DAOTablasSolas();
           listaDocumento=tbldocumento.ObtenerDocumento();
           cmbdocumento.removeAllItems();
           Vector _item = new Vector();
           for(int i=0;i<=listaDocumento.size()-1;i++)
               _item.addElement(new DisplayValue(listaDocumento.get(i).getDoc_cdescripcion(),listaDocumento.get(i).getDoc_ccodigo()));
           DefaultComboBoxModel _modelo = new DefaultComboBoxModel(_item);
           cmbdocumento.setModel(_modelo);
           txtserie.setDocument(new JTextFielCharLimit(MaximoCharacter.StrSerieDoc));
           txtnumero.setDocument(new JTextFielCharLimit(MaximoCharacter.StrNumeroDoc));
           DefinirColumnaTabla();
           bempresa=new BEmpresa();
           eempresa=bempresa.AccionObtenerDatosEmpresaDocumentoBaja();
       }catch(Exception e)
       {
       
       }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try
        {
                DocumentoBaja _obj= new DocumentoBaja();
                _obj.setEempresa(eempresa);
                _obj.listaFactura=listaFactura;
                if(_obj.FillXml())
                {
                   _obj.Envio();
                }
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtserie.setText("");
        txtnumero.setText("");
        mdo = (DefaultTableModel) tblDocumentoBaja.getModel();
        mdo.setNumRows(0);
        listaFactura.clear();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       try
       {
           buscarDocumento();
       }
       catch(Exception e)
       {
           System.out.println("Error al buscar :"+e.getMessage());
       }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtnumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
       {
           buscarDocumento();
       }
    }//GEN-LAST:event_txtnumeroKeyPressed
    private void buscarDocumento()
    {
           DisplayValue _valor = ((DisplayValue)cmbdocumento.getSelectedItem());
           String strSerie=txtserie.getText();
           String strNumero=txtnumero.getText();
           bfactura = new BFactura();
           efactura=bfactura.AccionBuscarxSerieNumeroTipo(_valor.getValueMenber(), strSerie, strNumero);
           if(efactura!=null)
           {
                int dialogButton=JOptionPane.showConfirmDialog (null, "Se encontro el Documento.","Desea Agregar",JOptionPane.YES_NO_OPTION);
                if(dialogButton == JOptionPane.YES_OPTION)
                { 
                    if(listaFactura.stream().filter(f->f.getFac_ncodigo()==efactura.getFac_ncodigo()).count()>0)
                        JOptionPane.showMessageDialog(null, "El documento ya fue agregado.");
                    else
                    {
                        listaFactura.add(efactura);
                        ActualizarinformacionTable();
                        txtserie.setText("");
                        txtnumero.setText("");
                    }
                }
           }
    }
     
    private void ActualizarinformacionTable()
    {
        mdo = (DefaultTableModel) tblDocumentoBaja.getModel();
        mdo.setNumRows(0);
        
        Object [] rowdata = new Object[9];
        for(int i=0;i<=listaFactura.size()-1;i++)
        {
            rowdata[0]=""+(i+1);
            rowdata[1]=listaFactura.get(i).getFac_ncodigo();
            rowdata[2]=listaFactura.get(i).getFac_cnombrecliente();            
            rowdata[3]=listaFactura.get(i).getFac_ctipodocumento();
            rowdata[4]=listaFactura.get(i).getFac_cserie();
            rowdata[5]=listaFactura.get(i).getFac_cnumero();
            rowdata[6]=InstanciaEntidad.NEW;
            rowdata[7]=listaFactura.get(i).getDesAlternativo();
            
            JButton _boton = new JButton("Eliminar");
            rowdata[8]=_boton;
            mdo.addRow(rowdata);
        }
        tblDocumentoBaja.setModel(mdo);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmComunicacionBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmComunicacionBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmComunicacionBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmComunicacionBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmComunicacionBaja().setVisible(true);
            }
        });
    }
    DefaultTableModel mdo;
    private void DefinirColumnaTabla()
    {
        try
        {
            final Class[] tiposColumnas = new Class[]{
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            JButton.class // <- noten que aquí se especifica que la última columna es un botón
                        };
            mdo = new DefaultTableModel()
            {//-----------------------------------------------------------------------DESABILITANDO COLUMNAS 
                Class[] tipos = tiposColumnas;
                
                boolean[] canEdit = new boolean[]{
                true,false,false,false,false,false,true};
                @Override public boolean isCellEditable(int rowIndex,int columnIndex)
                        {  
                            if(columnIndex<7)
                                return false;
                            else
                            return !(this.getColumnClass(columnIndex).equals(JButton.class));
                        }

                @Override
                        public Class getColumnClass(int columnIndex) {
                            return tipos[columnIndex];
                        }
            };
            Object[] columname = new Object[9];
            columname[0]="Item";
            columname[1]="codigo";
            columname[2]="Cliente";
            columname[3]="documento";
            columname[4]="Serie";
            columname[5]="Numero";
            columname[6]="Instancia";
            columname[7]="Descripcion";
            columname[8]="Acción";
            mdo.setColumnIdentifiers(columname);
            tblDocumentoBaja.setModel(mdo);
            tblDocumentoBaja.getTableHeader().setReorderingAllowed(false);
            tblDocumentoBaja.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
            });

            tblDocumentoBaja.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                int fila = tblDocumentoBaja.rowAtPoint(e.getPoint());
                int columna = tblDocumentoBaja.columnAtPoint(e.getPoint());
                if (tblDocumentoBaja.getModel().getColumnClass(columna).equals(JButton.class)) {
         
                                //JOptionPane.showMessageDialog(rootPane, "fila es"+fila + " codigo :"+tblDocumentoBaja.getValueAt(fila, 1));
                                int valorCodigo= Integer.parseInt(tblDocumentoBaja.getValueAt(fila, 1).toString());
                                if(valorCodigo>0)
                                {  boolean estado= listaFactura.removeIf(f->f.getFac_ncodigo()==valorCodigo);
                                    if(estado)
                                            ActualizarinformacionTable();
                                }
                            }
                        }
                });
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblDocumentoBaja;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtserie;
    // End of variables declaration//GEN-END:variables
}

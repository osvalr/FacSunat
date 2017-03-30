/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import AccessoDato.ECliente;
import AccessoDato.EDocumentoIdentidad;
import Negocio.BCliente;
import Negocio.BDocumentoIdentidad;
import Utilidad.BuscarRucOnline;
import Utilidad.DisplayValue;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class FrmAgregarClienteRapido extends javax.swing.JDialog {

     private List<EDocumentoIdentidad> _lseidentidad=null;
     private BDocumentoIdentidad _bidentidad=null;
     private BuscarRucOnline buscador;
     public int idCliente;
     private BCliente bcliente;
     private boolean estadoRegistro;
    public FrmAgregarClienteRapido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmAgregarClienteRapido(boolean x_estado) {
       // super(parent, modal);
        estadoRegistro=x_estado;
        initComponents();
        jpbuscadorOnline.setVisible(estadoRegistro);
        BoundsPopupMenuListener listener =  new BoundsPopupMenuListener(true, false);
        cmbdocumento.addPopupMenuListener(listener);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpbuscadorOnline = new javax.swing.JPanel();
        lbimagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarRuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtnumerodoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombreRuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdireccionfiscal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Nuevo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpbuscadorOnline.setBorder(javax.swing.BorderFactory.createTitledBorder("Usar solo para busqueda por Ruc"));

        lbimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("RUC");

        jLabel3.setText("Codigo");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBuscar1.setText("Limpiar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpbuscadorOnlineLayout = new javax.swing.GroupLayout(jpbuscadorOnline);
        jpbuscadorOnline.setLayout(jpbuscadorOnlineLayout);
        jpbuscadorOnlineLayout.setHorizontalGroup(
            jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpbuscadorOnlineLayout.createSequentialGroup()
                .addGroup(jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txtBuscarRuc))
                .addGap(18, 18, 18)
                .addComponent(lbimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        jpbuscadorOnlineLayout.setVerticalGroup(
            jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbuscadorOnlineLayout.createSequentialGroup()
                .addGroup(jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpbuscadorOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lbimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpbuscadorOnlineLayout.createSequentialGroup()
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar1))
        );

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Numero");

        jLabel4.setText("Ruc");

        jLabel5.setText("Direccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdireccionfiscal)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombreRuc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnumerodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtnumerodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombreRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdireccionfiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbuscadorOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpbuscadorOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        try
        {
            
            txtBuscarRuc.setDocument(new JTextFielCharLimit(MaximoCharacter.DocuMaxCharRuc));
            txtCodigo.setDocument(new JTextFielCharLimit(MaximoCharacter.intCodigoBusquedaSunat));
            txtnombreRuc.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharNombre)));
            txtdireccionfiscal.setDocument(new JTextFielCharLimit((MaximoCharacter.DocMaxCharDireccion)));
            _bidentidad = new BDocumentoIdentidad();
            String tipodecliente=estadoRegistro==true?"6":"1";
            _lseidentidad=_bidentidad.AccionTraerTodo(tipodecliente);
            Vector _items = new Vector();
            //_items.addElement(new DisplayValue("Seleccione un Tipo", "-1"));
            for (int i=0;i<=_lseidentidad.size()-1;i++)
            {
                _items.addElement(new DisplayValue(_lseidentidad.get(i).getDoi_cdescripcion(), _lseidentidad.get(i).getDoi_ccodigo()));
            }
            DefaultComboBoxModel modelo = new DefaultComboBoxModel(_items);                       
            cmbdocumento.setModel(modelo);
            buscador = new BuscarRucOnline();
            estableceImg();
            
            
        }catch(Exception e)
        {
        
        }
    }//GEN-LAST:event_formWindowOpened

    private void estableceImg()
    {
        lbimagen.setIcon(buscador.refrescar());
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargaOtro();
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void cargaOtro()
    {
         try
      {
          //buscador.realizarBusqueda(txtBuscarRuc.getText(), txtCodigo.getText());
          if(buscador.realizarBusqueda(txtBuscarRuc.getText(), txtCodigo.getText()))//if(buscador.ecliente.getCli_crazon()!=null)
          {
              txtdireccionfiscal.setText(buscador.ecliente.getCli_cdireccionfiscal());
              txtnombreRuc.setText(buscador.ecliente.getCli_crazon());
              txtnumerodoc.setText(buscador.ecliente.getCli_cnumerodoc());
              DisplayValue  _valor=null;
              for(int i=0;i<=cmbdocumento.getModel().getSize();i++)
              {
                  DefaultComboBoxModel modelo=(DefaultComboBoxModel) cmbdocumento.getModel();
                  _valor=(DisplayValue) modelo.getElementAt(i);
                  if(_valor.getValueMenber().equals("6"))
                  {    cmbdocumento.getModel().setSelectedItem(_valor);
                        break;
                  }   
              }
                      
          }
          else
          {
              limpiControl();
              estableceImg();
          }
      }catch(Exception e)
      {
          
      }
    }
    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       try
       {
           DisplayValue _valor=(DisplayValue)(cmbdocumento.getSelectedItem());
           bcliente = new BCliente();
           if(buscador.ecliente!=null)
           {     if(bcliente.AcccionGuardarSolo(buscador.ecliente))
                {
                    idCliente=buscador.ecliente.getCli_ncodigo();
                    JOptionPane.showMessageDialog(rootPane, "Se Guardo Correctamente.");
                    this.setVisible(false);
                }
           }else if (_valor.getValueMenber().equals("1"))
           {
               ECliente ecliente = new ECliente();
               ecliente.setCli_cdireccionfiscal(txtdireccionfiscal.getText());
               ecliente.setCli_cnumerodoc(txtnumerodoc.getText());
               ecliente.setCoi_ccodigo(_valor.getValueMenber());
               ecliente.setCli_crazon(txtnombreRuc.getText());
                if(bcliente.AcccionGuardarSolo(ecliente))
                {
                    idCliente=ecliente.getCli_ncodigo();
                    JOptionPane.showMessageDialog(rootPane, "Se Guardo Correctamente.");
                    this.setVisible(false);
                }
           }
       }
       catch(Exception e)
       {
       
       }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
       limpiControl();
        
    }//GEN-LAST:event_btnBuscar1ActionPerformed
    private void limpiControl()
    {
        txtnumerodoc.setText("");
        txtdireccionfiscal.setText("");
        txtnombreRuc.setText("");
        txtCodigo.setText("");
        txtBuscarRuc.setText("");
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmAgregarClienteRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarClienteRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarClienteRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarClienteRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAgregarClienteRapido dialog = new FrmAgregarClienteRapido(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpbuscadorOnline;
    private javax.swing.JLabel lbimagen;
    private javax.swing.JTextField txtBuscarRuc;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtdireccionfiscal;
    private javax.swing.JTextField txtnombreRuc;
    private javax.swing.JTextField txtnumerodoc;
    // End of variables declaration//GEN-END:variables
}


package Principal;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class FrmDescripcionRetificacionCreditoDebito extends javax.swing.JInternalFrame {

    private FrmNotaDebito frmdebito;
    private static FrmDescripcionRetificacionCreditoDebito frmAgregarNotaDebito;
    private static FrmDescripcionRetificacionCreditoDebito frmAgregarNotaCredito;
    
    private boolean  _estadofrm;
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public String StrtexoDescripcion;
    public  FrmNotaCredito frmcredito;
    public String _StringDescripcion;
    public float  _FloatPrecio;
    public float  _FloatValor;
    
    public static FrmDescripcionRetificacionCreditoDebito getinstance(FrmNotaDebito x_nota)
    {
        if(frmAgregarNotaDebito==null)
            frmAgregarNotaDebito=new FrmDescripcionRetificacionCreditoDebito(x_nota);
        return frmAgregarNotaDebito;
    }
    public static FrmDescripcionRetificacionCreditoDebito getinstance(FrmNotaCredito x_nota)
    {
        if(frmAgregarNotaCredito==null)
            frmAgregarNotaCredito=new FrmDescripcionRetificacionCreditoDebito(x_nota);
        return frmAgregarNotaCredito;
    }
    public FrmDescripcionRetificacionCreditoDebito() {
        initComponents();
    }
    public FrmDescripcionRetificacionCreditoDebito(FrmNotaDebito x_debito) {
        initComponents();
        frmdebito=x_debito;
        frmcredito=null;
    }
    public FrmDescripcionRetificacionCreditoDebito(FrmNotaCredito x_credito ) {
        initComponents();
        frmcredito=x_credito;
        frmdebito=null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        btnaceptar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();

        setTitle("Agregar Descripcion");
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

        jLabel1.setText("Descripcion:");

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btcancelar.setText("Cancelar");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantidad");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
        });

        jLabel3.setText("Precio");

        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtprecio, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnaceptar)
                        .addGap(92, 92, 92)
                        .addComponent(btcancelar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(btcancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try {
            if(validar())
            {
                if(m_Tipoinstancia==InstanciaForm.NEW)
                {
                    if(_estadofrm)
                    {
                        frmcredito._DescripcionNota=txtdescripcion.getText();
                        frmcredito._Cantidad=Integer.parseInt(txtcantidad.getText());
                        frmcredito._ValorVentaNota=Double.parseDouble(txtprecio.getText());

                    }
                    else if(!_estadofrm)
                    {
                        frmdebito._DescripcionNota=txtdescripcion.getText();
                        frmdebito._Cantidad=Integer.parseInt(txtcantidad.getText());
                        frmdebito._ValorVentaNota=Double.parseDouble(txtprecio.getText());
                    }
                }
            }
                this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ."+e.getMessage(), "Agregar Nota ",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        try {
            this.setVisible(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btcancelarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       try {
           txtdescripcion.setText("");
           txtcantidad.setText("");
           txtprecio.setText("");
           if(!_estadofrm)
           {     frmdebito.ActualizarDatoItem();
//                 frmdebito=null;
           }
           else if(_estadofrm)
           {    frmcredito.ActualizarDatoItem();
//                frmcredito=null;
           }  
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       
        txtdescripcion.setDocument(new JTextFielCharLimit(MaximoCharacter.StrDescripcionitemxNotaDebito));
        CargarDato();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
       char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyPressed
         if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!='.'){
       evt.consume();
   } 
   if(evt.getKeyChar()=='.'&&txtprecio.getText().contains(".")){
      evt.consume();
       } 

    }//GEN-LAST:event_txtprecioKeyPressed

    private void txtprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables

    void CargarDato() {
       
            txtcantidad.setDocument(new JTextFielCharLimit((MaximoCharacter.IntCantidadSimple)));
            txtprecio.setDocument(new JTextFielCharLimit((MaximoCharacter.IntPrecioSimple)));
            txtdescripcion.setDocument(new JTextFielCharLimit(MaximoCharacter.StrDescripcionitemxNotaDebito));
            txtdescripcion.setText("");
            txtdescripcion.setText(StrtexoDescripcion);
    }
    private boolean validar()
    {
        if(txtdescripcion.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese descripcion.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
            txtdescripcion.setFocusable(true);
            return false;
        }
        else if(txtcantidad.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
            txtcantidad.setFocusable(true);
            return false;
        }
        else if(txtprecio.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese un precio.", "Nota Debito",JOptionPane.WARNING_MESSAGE);
            txtprecio.setFocusable(true);
            return false;
        }
        
        return true;
    }

    public void setEstadofrm(boolean _estadofrm) {
        this._estadofrm = _estadofrm;
    }

    
    
   
}

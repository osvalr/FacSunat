
package Principal;

import AccessoDato.EDireccion;
import Utilidad.InstanciaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class FrmAdddireccion extends javax.swing.JInternalFrame {

    private static FrmAdddireccion frmadddireccion;
    private EDireccion _edireccion;
    public JDesktopPane m_escritorio;
    public InstanciaForm m_Tipoinstancia;
    private FrmCliente frmcliente;
    public static FrmAdddireccion getInstancia(FrmCliente x_cliente)
    {
        if(frmadddireccion==null)
                frmadddireccion= new FrmAdddireccion(x_cliente);
        return  frmadddireccion;
    }
    public FrmAdddireccion() {
        initComponents();
    }
    public FrmAdddireccion(FrmCliente x_cliente)
    {
        initComponents();
        frmcliente=x_cliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        btndireccion = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Agregar Direccion");
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

        jLabel1.setText("Direccion");

        btndireccion.setText("Aceptar");
        btndireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndireccionActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btndireccion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncancelar))
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndireccion)
                    .addComponent(btncancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btndireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndireccionActionPerformed
        try {
            if(validar())
            {
                if(m_Tipoinstancia==InstanciaForm.NEW)
                {
                    _edireccion = new EDireccion();
                    _edireccion.setM_Instancia(InstanciaEntidad.NEW);
                    _edireccion.setDir_cdescripcion(txtdireccion.getText());
                    
                }
                else if(m_Tipoinstancia==InstanciaForm.MODIFY)
                {
                    _edireccion.setM_Instancia(InstanciaEntidad.MODIFY);
                    _edireccion.setDir_cdescripcion(txtdireccion.getText());
                }
            }
            dispose();
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error agregando."+e.getMessage(), "Agregar Direccion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btndireccionActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            CargarDato();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       
        frmcliente.setEdireccion(_edireccion);
        frmcliente.CargarDireccionAdicional();
        txtdireccion.setText("");
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void ClearFrm()
    {
        txtdireccion.setText("");
    }
    
    private boolean validar()
    {
        boolean _f=true;
        if(txtdireccion.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese una direccion.", "Agregar Direccion",JOptionPane.WARNING_MESSAGE); 
            txtdireccion.setFocusable(true);
            _f= false;
        }
        else
        {
            for(int i=0;i<=frmcliente._lsedireccion.size()-1;i++)
            {
                if(frmcliente._lsedireccion.get(i).getDir_cdescripcion().equals(txtdireccion.getText()))
                {
                    JOptionPane.showMessageDialog(null, "La placa ya existe.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                    txtdireccion.setFocusable(true);
                    txtdireccion.setText("");
                    _f=false;
                    break;
                }
            }
        }
        return _f;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtdireccion;
    // End of variables declaration//GEN-END:variables

    public EDireccion getEdireccion() {
        return _edireccion;
    }

    public void setEdireccion(EDireccion _edireccion) {
        this._edireccion = _edireccion;
    }
    
    public void CargarDato()
    {
        txtdireccion.setDocument(new JTextFielCharLimit(MaximoCharacter.DocMaxCharDireccion));
        txtdireccion.setText("");
        
        if(m_Tipoinstancia==InstanciaForm.MODIFY)
        {
            txtdireccion.setText(_edireccion.getDir_cdescripcion());
        }
        else if(m_Tipoinstancia==InstanciaForm.NEW)
        {txtdireccion.setText(_edireccion.getDir_cdescripcion());}
    }
}

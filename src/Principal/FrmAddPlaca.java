
package Principal;

import AccessoDato.EPlaca;
import Negocio.BPlaca;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


public class FrmAddPlaca extends javax.swing.JInternalFrame {
    private static FrmAddPlaca frmaddplaca;
     public static FrmAddPlaca getinstancia(FrmPlaca x_placa){
        if(frmaddplaca==null)
            frmaddplaca=new FrmAddPlaca(x_placa);
        return frmaddplaca;
    }
    public JDesktopPane panelPrincila;
    public InstanciaForm m_Tipoinstancia;
    public FrmPlaca frmplacaprincipal;
    private EPlaca _eplaca;
    private String m_codigo;
    private int cli_ncodigo;
    private BPlaca _bplaca;
    public FrmAddPlaca() {
        initComponents();
    }
    public FrmAddPlaca(FrmPlaca x_placa)
    {
        initComponents();
        frmplacaprincipal=x_placa;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaceptar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        txtdescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Registro de Placa");
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

        jLabel1.setText("Ingreso de Placa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtdescripcion)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnaceptar)
                            .addGap(40, 40, 40)
                            .addComponent(btcancelar))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(btcancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btcancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            CargarDato();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try {
            if(validar())
            {
                if(m_Tipoinstancia==InstanciaForm.NEW)
                {
                    _eplaca = new EPlaca();
                    _eplaca.setM_instancia(InstancaEntidad.NEW);
                    _eplaca.setPla_cnombre(txtdescripcion.getText());
                }
                else if(m_Tipoinstancia==InstanciaForm.MODIFY)
                {
                    _eplaca.setM_instancia(InstancaEntidad.MODIFY);
                    _eplaca.setPla_cnombre(txtdescripcion.getText());
                }
                this.dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        try {
            frmplacaprincipal.setEplaca(_eplaca);
            frmplacaprincipal.CargarPlaca();
            txtdescripcion.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameClosed
    private boolean validar()
    {
        boolean _rpta=true;
        if(txtdescripcion.getText().length()==0)
        {
           JOptionPane.showMessageDialog(null, "Ingrese un nombre de placa", "Mensaje",JOptionPane.WARNING_MESSAGE);
           txtdescripcion.setFocusable(true);
           _rpta= false;
        }
        //Verificando existencia de la placa;
        for(int i=0;i<=frmplacaprincipal._lsplaca.size()-1;i++)
        {
            if(frmplacaprincipal._lsplaca.get(i).getPla_cnombre().equals(txtdescripcion.getText()))
            {
                JOptionPane.showMessageDialog(null, "La placa ya existe.", "Mensaje",JOptionPane.WARNING_MESSAGE);
                txtdescripcion.setFocusable(true);
                txtdescripcion.setText("");
                _rpta=false;
                break;
            }
        }
        return _rpta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables

    public EPlaca getEplaca() {
        return _eplaca;
    }

    public void setEplaca(EPlaca _eplaca) {
        this._eplaca = _eplaca;
    }

    public String getM_codigo() {
        return m_codigo;
    }

    public void setM_codigo(String m_codigo) {
        this.m_codigo = m_codigo;
    }

    public int getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(int cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }
    
    public void CargarDato()
    {
            txtdescripcion.setDocument(new JTextFielCharLimit(MaximoCharacter.StrPlacaSimple));
            txtdescripcion.setText("");
            _bplaca= new BPlaca();
            if(m_Tipoinstancia==InstanciaForm.MODIFY)
            {
                    txtdescripcion.setText(_eplaca.getPla_cnombre());
            }
            else if(m_Tipoinstancia==InstanciaForm.NEW)
            {
                txtdescripcion.setText(_eplaca.getPla_cnombre());
            }
    }
}

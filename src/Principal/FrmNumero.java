/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import AccessoDato.EDocumento;
import AccessoDato.ENumero;
import Negocio.BTablasSolas;
import Utilidad.DisplayValue;
import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;
import Utilidad.JTextFielCharLimit;
import Utilidad.MaximoCharacter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class FrmNumero extends JInternalFrame {

    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    private BTablasSolas _bdocumento;
    private List<EDocumento> _lsdocumento;
    private Vector _item;
    private ENumero _enumero;
    private int suc_ncodigo;
    DefaultComboBoxModel _modelodocumento;
    private FrmParametro frmparametro;
    private FrmParametro _frmparametro;
    private FrmNumero() {
        initComponents();
    }
    private FrmNumero(FrmParametro x_parametro) {
        initComponents();
        frmparametro=x_parametro;
    }
    private static FrmNumero m_frmnumero;
    public static FrmNumero getinstancia(FrmParametro x_parametro)
    {
        if(m_frmnumero==null)
            m_frmnumero=new FrmNumero(x_parametro);
        return m_frmnumero;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtserie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();
        btnaceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Serie y Numero");
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

        jLabel1.setText("Serie");

        jLabel2.setText("Numero");

        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroKeyTyped(evt);
            }
        });

        jLabel3.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtserie)
                    .addComponent(txtnumero)
                    .addComponent(cmbdocumento, 0, 112, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnaceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(jButton2))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        try {
            CargarDato();
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.setVisible(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try {
            if(Validar())
            {
                if(m_Tipoinstancia==InstanciaForm.NEW)
                {
                    _enumero = new ENumero();
                    _enumero.setM_instancia(InstancaEntidad.NEW);
                    GetItem();
                }
                else if(m_Tipoinstancia==InstanciaForm.MODIFY)
                {
                
                    _enumero.setM_instancia(InstancaEntidad.MODIFY);
                    GetItem();
                }
//                GetItem();
//                this.setDefaultCloseOperation(HIDE_ON_CLOSE);
//               this.dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        try {
            _frmparametro.setEnumero(_enumero);
            _frmparametro.CargarNumero();
            txtnumero.setText("");
            txtserie.setText("");
            cmbdocumento.setSelectedIndex(0);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameClosed

    private void txtnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnumeroKeyTyped
    DisplayValue _valor;
    private void GetItem()
    {
        try {
            
            if(_enumero!=null)
            {
                _enumero.setNum_cserie(txtserie.getText());
                _enumero.setNum_cnumero(txtnumero.getText());
                _valor=(DisplayValue)cmbdocumento.getSelectedItem();
                _enumero.setDoc_ccodigo(_valor.getValueMenber());
                _enumero.setSuc_ncodigo(getSuc_ncodigo());
                _enumero.setDoc_cdescripcion(_valor.displayMeneber.toString());
            }
        } catch (Exception e) {
        }
    }
    private void SetItem()
    {
        try {
            
            if(_enumero!=null)
            {
                txtserie.setText(_enumero.getNum_cserie());
                txtnumero.setText(_enumero.getNum_cnumero());
//                _valor=(DisplayValue)cmbdocumento.getSelectedItem();
//                _enumero.setDoc_ccodigo(_valor.getValueMenber());
//                _enumero.setSuc_ncodigo(getSuc_ncodigo());
//                _enumero.setDoc_cdescripcion(_valor.displayMeneber.toString());
            }
        } catch (Exception e) {
        }
    }
    private boolean  Validar()
    {
        try {
            if(txtserie.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese numero serie.","Registro Numero",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if(txtnumero.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese numero.","Registro Numero",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if(cmbdocumento.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Documento.","Registro Numero",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtserie;
    // End of variables declaration//GEN-END:variables

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public ENumero getEnumero() {
        return _enumero;
    }

    public void setEnumero(ENumero _enumero) {
        this._enumero = _enumero;
    }

    public FrmParametro getFrmparametro() {
        return _frmparametro;
    }

    public void setFrmparametro(FrmParametro _frmparametro) {
        this._frmparametro = _frmparametro;
    }
    
    public void CargarDato()
    {
        try {
            _bdocumento = new BTablasSolas();
            _lsdocumento=_bdocumento.ObtenerTodoDocumentos();
            _item= new Vector();
            _item.addElement(new DisplayValue("Seleccione", "-1"));
             for (int i=0;i<=_lsdocumento.size()-1;i++)
                _item.addElement(new DisplayValue(_lsdocumento.get(i).getDoc_cdescripcion(), _lsdocumento.get(i).getDoc_ccodigo()));
            _modelodocumento = new DefaultComboBoxModel(_item);
            cmbdocumento.setModel(_modelodocumento);
            txtserie.setDocument(new JTextFielCharLimit(MaximoCharacter.StrSerieDoc));
            txtnumero.setDocument(new JTextFielCharLimit((MaximoCharacter.StrNumeroDoc)));
            
        } catch (Exception e) {
        }
    }
    
}

package Principal;
import AccessoDato.EDocumentoIdentidad;
import Negocio.BDocumentoIdentidad;
import Principal.FrmFactura;
import Utilidad.DisplayValue;
import Utilidad.InstanciaForm;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
public class FrmTipoDocumento extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel _modelocmd; 
    private BDocumentoIdentidad _bdocumento;
    private EDocumentoIdentidad _edocumento;
    private Vector _item;
    private List<EDocumentoIdentidad> _lsdocumento;
    public InstanciaForm m_Tipoinstancia;
    public JDesktopPane m_escritorio;
    public static FrmTipoDocumento frmdocumento;
    private FrmFactura _frmfactura;
    public static FrmTipoDocumento getinstacia()
    {
        if(frmdocumento==null)
            frmdocumento=new FrmTipoDocumento();
        return frmdocumento;
    }
    public FrmTipoDocumento() {
        initComponents();
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbdocumento = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Documento");

        cmbdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            cmbdocumento.removeAllItems();
            _bdocumento=new BDocumentoIdentidad();
            _lsdocumento=_bdocumento.AccionTraerTodo();
            _item = new Vector();
            _item.addElement(new DisplayValue("Elegir", "-1"));
            for(int i=0;i<=_lsdocumento.size()-1;i++)
            {
                if(!_lsdocumento.get(i).getDoi_ccodigo().equals("6"))
                    _item.addElement(new DisplayValue((_lsdocumento.get(i).getDoi_cdescripcion()), _lsdocumento.get(i).getDoi_ccodigo()));
            }
            _modelocmd = new DefaultComboBoxModel(_item);
            cmbdocumento.setModel(_modelocmd);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdocumentoActionPerformed
       if(cmbdocumento.getSelectedIndex()>=0)
       {
           DisplayValue _valor =(DisplayValue)cmbdocumento.getSelectedItem();
           _frmfactura.setM_CodigoDocumento(_valor.getValueMenber());
           dispose();
           //this.setVisible(false);
       }
    }//GEN-LAST:event_cmbdocumentoActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbdocumento;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public FrmFactura getFrmfactura() {
        return _frmfactura;
    }

    public void setFrmfactura(FrmFactura _frmfactura) {
        this._frmfactura = _frmfactura;
    }

}

package Principal;
import AccessoDato.EEmpresa;
import AccessoDato.EResumenDiario;
import Negocio.BEmpresa;
import Negocio.BResumenDiario;
import Utilidad.InstanciaForm;
import Utilidad.ResumenDiario;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmPadre extends javax.swing.JFrame {

   
    public FrmPadre()  {
        initComponents();
        try
        {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e)
        {
            System.out.println("Error:"+e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jmCliente = new javax.swing.JMenuItem();
        jmArticulo = new javax.swing.JMenuItem();
        btnvendedor = new javax.swing.JMenuItem();
        btnsucursal = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnsalir = new javax.swing.JMenuItem();
        btnsalida = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnparametros = new javax.swing.JMenuItem();
        btndescuentos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnnotacredito = new javax.swing.JMenuItem();
        btnnotadebito = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mitemResumenDiario = new javax.swing.JMenuItem();
        mitemDocBaja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Maestros");
        fileMenu.setDelay(50);

        jmCliente.setMnemonic('o');
        jmCliente.setText("Cliente");
        jmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClienteActionPerformed(evt);
            }
        });
        fileMenu.add(jmCliente);

        jmArticulo.setMnemonic('s');
        jmArticulo.setText("Articulo");
        jmArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmArticuloActionPerformed(evt);
            }
        });
        fileMenu.add(jmArticulo);

        btnvendedor.setText("Vendedor");
        btnvendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvendedorActionPerformed(evt);
            }
        });
        fileMenu.add(btnvendedor);

        btnsucursal.setText("Sucursal");
        btnsucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsucursalActionPerformed(evt);
            }
        });
        fileMenu.add(btnsucursal);
        fileMenu.add(jSeparator1);

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        fileMenu.add(btnsalir);

        menuBar.add(fileMenu);

        btnsalida.setText("Ventas");
        btnsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidaActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Facturas  / Boletas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btnsalida.add(jMenuItem1);

        menuBar.add(btnsalida);

        jMenu1.setText("Configuración");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        btnparametros.setText("Parametros");
        btnparametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparametrosActionPerformed(evt);
            }
        });
        jMenu1.add(btnparametros);

        btndescuentos.setText("Conf. Descuentos");
        btndescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescuentosActionPerformed(evt);
            }
        });
        jMenu1.add(btndescuentos);

        menuBar.add(jMenu1);

        jMenu2.setText("Retificacion");

        btnnotacredito.setText("Nota Credito");
        btnnotacredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnotacreditoActionPerformed(evt);
            }
        });
        jMenu2.add(btnnotacredito);

        btnnotadebito.setText("Nota Debito");
        btnnotadebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnotadebitoActionPerformed(evt);
            }
        });
        jMenu2.add(btnnotadebito);

        menuBar.add(jMenu2);

        jMenu3.setText("Otros");

        mitemResumenDiario.setText("Resumen Diario");
        mitemResumenDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemResumenDiarioActionPerformed(evt);
            }
        });
        jMenu3.add(mitemResumenDiario);

        mitemDocBaja.setText("Documento de Baja");
        mitemDocBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemDocBajaActionPerformed(evt);
            }
        });
        jMenu3.add(mitemDocBaja);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    FrmCliente objCli;
    private void jmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClienteActionPerformed
        try {
            
            if(objCli==null){
                objCli =FrmCliente.getInstancia();
                desktopSize = desktopPane.getSize();
                Internal = objCli.getSize();
                objCli.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                objCli.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                objCli.panelPrincila=desktopPane;
                objCli.setVisible(true);
                desktopPane.add(objCli);
                objCli.setSelected(true);}
            else
            {   desktopSize = desktopPane.getSize();
                Internal = objCli.getSize();
                objCli.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                objCli.setVisible(true);
                objCli.setSelected(true);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmPadre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmClienteActionPerformed
    private void jmArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmArticuloActionPerformed
        
            try {
                if(objArt==null){
                        objArt = FrmArticulo.getinstancia();
                        desktopSize = desktopPane.getSize();
                        Internal = objArt.getSize();
                        objArt.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);       
                        objArt.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                        objArt.panelPrincila=desktopPane;
                        objArt.setVisible(true);
                        desktopPane.add(objArt);
                        objArt.setSelected(true);
                }
                else
                {   desktopSize = desktopPane.getSize();
                    Internal = objArt.getSize();
                    objArt.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2); 
                    objArt.setVisible(true);
                    objArt.setSelected(true);
                }
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FrmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jmArticuloActionPerformed
    FrmArticulo objArt;
    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidaActionPerformed
        
    }//GEN-LAST:event_btnsalidaActionPerformed
    FrmFactura frmFactura;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try
        {
            if(frmFactura==null)
            {
                frmFactura  =FrmFactura.getinstancia();
                frmFactura.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                frmFactura.m_escritorio=desktopPane;
                frmFactura.setVisible(true);            
                desktopPane.add(frmFactura);
                frmFactura.setMaximum(true);
                frmFactura.setSelected(true);
            }
            else{
                frmFactura.setVisible(true);
                frmFactura.setSelected(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed
    FrmParametro objparametro;
    private void btnparametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparametrosActionPerformed
        try
        {
            if(objparametro==null)
            {
                objparametro = FrmParametro.getinstance();
                objparametro.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                objparametro.m_escritorio=desktopPane;
                desktopSize = desktopPane.getSize();
                Internal = objparametro.getSize();
                objparametro.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                objparametro.setVisible(true);  
                desktopPane.add(objparametro);
                objparametro.setSelected(true);
            }
            else
            {   desktopSize = desktopPane.getSize();
                Internal = objparametro.getSize();
                objparametro.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                objparametro.setVisible(true);
                objparametro.setSelected(true); 
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnparametrosActionPerformed
    FrmDescuentosGlobales objAdicional;
    Dimension desktopSize; 
    Dimension Internal;
    private void btndescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescuentosActionPerformed
        try
        {
        if(objAdicional==null)
        {
                objAdicional  =FrmDescuentosGlobales.getinstance();
                objAdicional.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                objAdicional.panelPrincila=desktopPane;
                desktopSize = desktopPane.getSize();
                Internal = objAdicional.getSize();
                objAdicional.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                objAdicional.setVisible(true);            
                desktopPane.add(objAdicional);
                objAdicional.setSelected(true);
        }
        else
        {   desktopSize = desktopPane.getSize();
            Internal = objAdicional.getSize();
            objAdicional.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
            objAdicional.setVisible(true);objAdicional.setSelected(true);
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btndescuentosActionPerformed

    private void btnvendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvendedorActionPerformed
       try
        {
        if(frmvendedor==null)
        {
                frmvendedor  =FrmVendedor.getInstance();
                frmvendedor.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                frmvendedor.panelPrincila=desktopPane;
                desktopSize = desktopPane.getSize();
                Internal = frmvendedor.getSize();
                frmvendedor.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                frmvendedor.setVisible(true);            
                desktopPane.add(frmvendedor);
                frmvendedor.setSelected(true);
        }
        else
            {   desktopSize = desktopPane.getSize();
                Internal = frmvendedor.getSize();
                frmvendedor.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                frmvendedor.setVisible(true);
                frmvendedor.setSelected(true);
        }
        }catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnvendedorActionPerformed
    FrmSucursal frmsucursal;
    private void btnsucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsucursalActionPerformed
        try {
            
                if(frmsucursal==null)
                {
                        frmsucursal  =FrmSucursal.getinstancia();
                        frmsucursal.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                        frmsucursal.panelPrincila=desktopPane;
                        desktopSize = desktopPane.getSize();
                        Internal = frmsucursal.getSize();
                        frmsucursal.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                        frmsucursal.setVisible(true);            
                        desktopPane.add(frmsucursal);
                        frmsucursal.setSelected(true);
                }
                else
                {   
                        desktopSize = desktopPane.getSize();
                        Internal = frmsucursal.getSize();
                        frmsucursal.setLocation((desktopSize.width - Internal.width)/2,(desktopSize.height- Internal.height)/2);
                        frmsucursal.setVisible(true);
                        frmsucursal.setSelected(true);
                }
        }catch(Exception e)
        {    JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE); }
        
    }//GEN-LAST:event_btnsucursalActionPerformed
    FrmNotaCredito frmnotacredito;
    private void btnnotacreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnotacreditoActionPerformed
        try {
            if(frmnotacredito==null)
            {
                frmnotacredito  =FrmNotaCredito.getistancia();
                frmnotacredito.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                frmnotacredito.m_escritorio=desktopPane;
                frmnotacredito.setVisible(true);            
                desktopPane.add(frmnotacredito);
                frmnotacredito.setMaximum(true);
                frmnotacredito.setSelected(true);
            }
            else{
                frmnotacredito.setVisible(true);
                frmnotacredito.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
           
    }//GEN-LAST:event_btnnotacreditoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errores. :"+e.getMessage(), "Principal",JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_formWindowOpened
    FrmNotaDebito frmdebito;
    private void btnnotadebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnotadebitoActionPerformed
        try {
             if(frmdebito==null)
            {
                frmdebito  =FrmNotaDebito.getinstancia();
                frmdebito.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                frmdebito.m_escritorio=desktopPane;
                frmdebito.setVisible(true);            
                desktopPane.add(frmdebito);
                frmdebito.setMaximum(true);
                frmdebito.setSelected(true);
            }
            else{
                frmdebito.setVisible(true);
                frmdebito.setSelected(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnnotadebitoActionPerformed
    BResumenDiario bresumendiario;
    BEmpresa bempresa;
    private void mitemResumenDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemResumenDiarioActionPerformed
       
        try
        {
           bempresa = new BEmpresa();
           bresumendiario= new BResumenDiario();
            EEmpresa eempresa = bempresa.AccionObtenerDatosEmpresaDocumentoBaja();
            List<EResumenDiario> _listaResument= bresumendiario.AccionObtenerResumenDiario();
            if(_listaResument.size()>0)
            {
                ResumenDiario _xml = new ResumenDiario(eempresa, _listaResument);
                _xml.FillXml();       
                _xml.Envio();
            }
        }catch(Exception e)
        {
        
        }
    }//GEN-LAST:event_mitemResumenDiarioActionPerformed
    FrmComunicacionBaja frmComunicacionBaja;
    private void mitemDocBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemDocBajaActionPerformed
       try {
            if(frmComunicacionBaja==null)
            {
                frmComunicacionBaja  =FrmComunicacionBaja.getinstancia();
                frmComunicacionBaja.m_Tipoinstancia=InstanciaForm.UNCHANGUE;
                frmComunicacionBaja.m_escritorio=desktopPane;
                frmComunicacionBaja.setVisible(true);            
                desktopPane.add(frmComunicacionBaja);
                frmComunicacionBaja.setMaximum(true);
                frmComunicacionBaja.setSelected(true);
            }
            else{
                frmComunicacionBaja.setVisible(true);
                frmComunicacionBaja.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mitemDocBajaActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed
    FrmVendedor frmvendedor;
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
            java.util.logging.Logger.getLogger(FrmPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPadre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btndescuentos;
    private javax.swing.JMenuItem btnnotacredito;
    private javax.swing.JMenuItem btnnotadebito;
    private javax.swing.JMenuItem btnparametros;
    private javax.swing.JMenu btnsalida;
    private javax.swing.JMenuItem btnsalir;
    private javax.swing.JMenuItem btnsucursal;
    private javax.swing.JMenuItem btnvendedor;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmArticulo;
    private javax.swing.JMenuItem jmCliente;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mitemDocBaja;
    private javax.swing.JMenuItem mitemResumenDiario;
    // End of variables declaration//GEN-END:variables



    
    

   

    

}

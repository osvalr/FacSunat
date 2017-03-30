
package Utilidad;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.*;


public class ImprimirDocumento {
    valorResumenFirma objetoDigital;
    public String rutaReporte;
    String strDigester;
    String strAsignature;
    String strigv;
    String stridfactura;
    String strNombreReport;
    private Conector conector;
    private Connection conpg;
    Map<String, String> params = new HashMap<String, String>();
    public ImprimirDocumento( valorResumenFirma x_firma,int x_tipoReporte,String x_nombre,int x_idfactura)
    {
        this.objetoDigital=x_firma;
        conector= new Conector();
        conector.Abrir();
        strNombreReport=x_nombre;
        strDigester=x_firma.getDigestValue();
        strAsignature=x_firma.getSignatureValue();
        stridfactura=String.valueOf(x_idfactura);
        iniciarRuta(x_tipoReporte);
    }
    private  void iniciarRuta(int opc)
    {
        try
        {
            switch(opc)
            {
                case 1://Factura
                    rutaReporte=Ruta.rutaReporteFactura;
                    break;
                case 2://Boleta
                    rutaReporte=Ruta.rutaReporteBoleta;
                    break;
                case 3:
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error definiendo rutaReporte :"+e.getMessage());
        }
        agregaParametros(opc);
    }
    
    private void agregaParametros(int opc)
    {
        try
        {
            //fecha:20161223
            //autor:yasmani
            //descripcion: agrega los parametros segun el tipo de documento a imprimir
            switch(opc)
            {
                case 1://Factura:
                    params.put("idfactura", stridfactura);
                    params.put("igv", "1.8");
                    params.put("valorresumen",strDigester);
                    params.put("firma",strAsignature);                    
                    break;
                case 2://Boleta
                    rutaReporte=Ruta.rutaReporteBoleta;
                    break;
                case 3:
                    break;
            }
        }
        catch(Exception e)
        {System.out.println("Error Agregando Parametros :"+e.getMessage());}
        finally{
            generarReporte();
        }
    }
    
    private void generarReporte()
    {
        //File miDir = new File(".");
//        try
//        {
            JasperReport jasperReport;
            try
            {
            jasperReport = JasperCompileManager.compileReport(rutaReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conector.con);
            jasperPrint.setName(strNombreReport);
            JasperPrintManager.printReport(jasperPrint, false);
            conector.Cerrar();
            
//            } catch (IOException ex) {
//                //Logger.getLogger(null.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, ex.getMessage());
//            }
        }catch  ( JRException e)
        {
             System.out.println("Error imprimiendo :"+e.getMessage());
              JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  
}

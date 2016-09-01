
package sunat;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import pe.gob.sunat.servicio.registro.comppago.factura.gem.service.BillService;
import pe.gob.sunat.servicio.registro.comppago.factura.gem.service.BillService_Service;

public class Envio {
    
    private String strUsuario;
    private String strClave;
    private String strRutaArchivozip;
    private File    fleOnlyNombre;
    private Boolean _estado;
    public String strRutaResultado;
    public Envio(String strUsuario, String strClave, File fleArchivo) {
        this.strUsuario = strUsuario;
        this.strClave = strClave;
        this.fleOnlyNombre = fleArchivo;
    }
    private String strError;
           
    public boolean Enviardocumento()
    {
       
        try
        {
            strError="";
            BillService_Service _servicio = new BillService_Service();
            BillService _serviceport = _servicio.getBillServicePort();
            BindingProvider bindingProvider = (BindingProvider) _serviceport;
            @SuppressWarnings("rawtypes")
            List<Handler> handlerChain = new ArrayList<>();
            handlerChain.add(new WSSecurityHeaderSOAPHandler(strUsuario,strClave));
            bindingProvider.getBinding().setHandlerChain(handlerChain);
            System.out.println("Arrancando envio");//-------------------------------------------------2
            //DataSource file = new FileDataSource("D:\\20456047212-01-F001-01.zip");
            DataSource file = new FileDataSource(fleOnlyNombre.getPath());
            DataHandler handler = new DataHandler(file);
            byte [] respuesta = _serviceport.sendBill(fleOnlyNombre.getName(),handler);
            String _subpath=fleOnlyNombre.getPath().substring(0,fleOnlyNombre.getPath().length()-fleOnlyNombre.getName().length() );            
            FileOutputStream fout = new FileOutputStream(_subpath+"R-"+fleOnlyNombre.getName());
            fout.write(respuesta);
            fout.close();
            System.out.println("fin envio.");
            strRutaResultado=_subpath+"R-"+fleOnlyNombre.getName();
            _estado=true;
        }
        catch(Exception e)
        {
            strError="Fallo:"+e.getMessage();
            System.out.println("error servidor sunat :"+e.getMessage());
            _estado=false;
        }
        return _estado;
    }

        
}

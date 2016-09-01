
package Negocio;

import AccessoDato.DAOENumero;
import AccessoDato.ENumero;
import java.util.ArrayList;
import java.util.List;

public class BNumero{

    private DAOENumero _daonumero;
    public BNumero() {
        _daonumero= new DAOENumero();
    }
    public List<ENumero> AccionObtenerxParametro(int x_codigo)
    {
        List<ENumero> _lsnumero = new ArrayList<>();
        try {
            
            _lsnumero=(List<ENumero>) _daonumero.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
        
        return _lsnumero;
 
   }

    public ENumero AccionObtenerUnNumero(int _codigo) {
        return _daonumero.ObtenerObtenerUnoxNumero(_codigo);
    }

    public boolean VerificarAsignacionNumero(int _codigo) {
        return _daonumero.VerificarSerieNumero(_codigo);    

    }
    
    
}

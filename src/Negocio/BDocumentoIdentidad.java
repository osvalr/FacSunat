
package Negocio;

import AccessoDato.DAODocumentoIdentidad;
import AccessoDato.EDocumentoIdentidad;
import java.util.List;

public class BDocumentoIdentidad {
    
    private DAODocumentoIdentidad _daoidentidad=null;
    List<EDocumentoIdentidad> _lsidentidad=null;
    public List<EDocumentoIdentidad> AccionTraerTodo()
    {
        try
        {
            _daoidentidad = new DAODocumentoIdentidad();
            _lsidentidad = _daoidentidad.ObtenerTodo();
            
        }
        catch(Exception e)
        {
        }
        return _lsidentidad;
    }
}

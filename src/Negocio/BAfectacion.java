
package Negocio;

import AccessoDato.DAOAfectacion;
import AccessoDato.EAfectacion;
import java.util.ArrayList;
import java.util.List;

public class BAfectacion {
    
    private DAOAfectacion _daoafectado;
    public BAfectacion() {
        _daoafectado= new DAOAfectacion();
    }
    
    public List<EAfectacion> ObtenerxTipo(String x_nombre)
    {
        List<EAfectacion> _lsafectacion = new ArrayList<>();
        try
        {
            _daoafectado.setCodigo(x_nombre);
            _lsafectacion=(List<EAfectacion>) _daoafectado.ObtenerTodos();
        }
        catch(Exception e)
        {
        
        }        
        return _lsafectacion;
    }
    
}

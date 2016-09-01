
package Negocio;

import AccessoDato.DAOMoneda;
import AccessoDato.EMoneda;
import java.util.ArrayList;
import java.util.List;

public class BMoneda {
    
    private DAOMoneda _daomoneda;

    public BMoneda() {
        _daomoneda= new DAOMoneda();
    }
    public List<EMoneda> ObtenerTodos()
    {
        List<EMoneda> _lsemoneda=new ArrayList<>();
        try
        {
                _lsemoneda=(List<EMoneda>) _daomoneda.ObtenerTodos();
        }
        catch(Exception e)
        {
        
        }
        return _lsemoneda;
    }
}


package Negocio;

import AccessoDato.DAOUnidad;
import AccessoDato.EArticulo;
import AccessoDato.EUbigeo;
import AccessoDato.EUnidad;
import java.util.ArrayList;
import java.util.List;


public class BUnidad {

    private DAOUnidad _daounidad=null;
    public BUnidad() {
        _daounidad= new DAOUnidad();
    }
    
    public List<EUnidad> AccionObtenerTodo()
    {
        List<EUnidad> _lseunidad= new ArrayList<>();
        try
        {
            _lseunidad=(List<EUnidad>) _daounidad.ObtenerTodos();
        }
        catch(Exception e)
        {   }
        return _lseunidad;
    }
    
}

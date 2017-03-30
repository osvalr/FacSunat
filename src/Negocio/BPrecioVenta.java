
package Negocio;

import AccessoDato.DAOPrecioVenta;
import AccessoDato.EPrecioVenta;
import Utilidad.InstanciaEntidad;
import java.util.ArrayList;
import java.util.List;

public class BPrecioVenta {
    
    private DAOPrecioVenta _daoprecioventa=null;
    
    public BPrecioVenta() {
        _daoprecioventa = new DAOPrecioVenta();
        
    }
    public boolean AccionGuardar(List<EPrecioVenta> x_lista,int x_artcodigo )
    {
        boolean _flag=false;
        EPrecioVenta _eprecio=null;
        try
        {
            for(int i=0;i<=x_lista.size()-1;i++ )
            {
                _eprecio=x_lista.get(i);
                _eprecio.setArt_ncodigo(x_artcodigo);
                if(_eprecio.getM_instancia()==InstanciaEntidad.NEW)
                {
                    _daoprecioventa.Guardar(_eprecio);
                }
                if(_eprecio.getM_instancia()==InstanciaEntidad.MODIFY)
                {
                    _daoprecioventa.Modificar(_eprecio);
                }
                if(_eprecio.getM_instancia()==InstanciaEntidad.DELETE)
                {
                    _daoprecioventa.Eliminar(_eprecio.getPve_ncodigo());
                }                
            }
        }
        catch(Exception e)
        {}
        return _flag;
    }
    
    public List<EPrecioVenta> AccionObtenerTodo(int x_codigo)
    {
        List<EPrecioVenta> _lseprecioventa =new ArrayList<>();
        try
        {
            _lseprecioventa=_daoprecioventa.ObtenerTodos(x_codigo);
        }
        catch(Exception e)
        {}
        
        return _lseprecioventa;
    }
    public EPrecioVenta AccionObtenerxPrecio(int x_codigo)
    {
        EPrecioVenta _eprecioventa=null;
        try
        {
            _eprecioventa=_daoprecioventa.ObtenerUno(x_codigo);
        }
        catch(Exception e)
        {}
        
        return _eprecioventa;
    }
    public List<EPrecioVenta> AcctionDetalle()
    {
         List<EPrecioVenta> _lseprecioventa =new ArrayList<>();
        try
        {
            _lseprecioventa=_daoprecioventa.ObtenerDetalle();
        }
        catch(Exception e)
        {}
        return _lseprecioventa;
    }

    public List<EPrecioVenta> AcctionBuscarDetallexCaracter(String x_caracter) {
        List<EPrecioVenta> _lseprecioventa =new ArrayList<>();
        try
        {
            _lseprecioventa=_daoprecioventa.ObtenerDetallexCaracter(x_caracter);
        }
        catch(Exception e)
        {}
        return _lseprecioventa;
    }
   
}


package Negocio;

import AccessoDato.DAOSucursal;
import AccessoDato.ESucursal;
import Utilidad.InstancaEntidad;
import java.util.ArrayList;
import java.util.List;

public class BSucursal {
    
    private DAOSucursal _daosucursal=null;

    public BSucursal() {
        _daosucursal= new DAOSucursal();
    }
    
    public List<ESucursal> ObtenerTodos()
    {
        List<ESucursal> _lssucursal= new ArrayList<>();
        try
        {
            _lssucursal=_daosucursal.ObtenerTodos();
        }
        catch(Exception e)
        {
        
        }
        return _lssucursal;
    }
    public List<ESucursal> ObtenerTodosNoAsignados()
    {
        List<ESucursal> _lssucursal= new ArrayList<>();
        try
        {
            _lssucursal=_daosucursal.ObtenerTodosNoAsignado();
        }
        catch(Exception e)
        {
        
        }
        return _lssucursal;
    }
    public boolean  AccionGuardar(ESucursal x_sucursal)
    {
        boolean _rpta=false;
        try {
            
            if(x_sucursal.getM_instancia()==InstancaEntidad.NEW)
                _rpta=_daosucursal.Guardar(x_sucursal);
            if(x_sucursal.getM_instancia()==InstancaEntidad.MODIFY)
                _rpta=_daosucursal.Modificar(x_sucursal);
        } catch (Exception e) {
        }
        return _rpta;
    }
    
    public ESucursal AccionObtenerUno(int x_codigo)
    {
        ESucursal _esucursal=null;
        try {
            _esucursal=(ESucursal) _daosucursal.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
        return _esucursal;
    }
}

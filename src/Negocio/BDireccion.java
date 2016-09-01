
package Negocio;

import AccessoDato.DAODireccion;
import AccessoDato.EDireccion;
import Utilidad.InstancaEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class BDireccion {
    private DAODireccion _daodireccion=null;
    public BDireccion()
    {
        _daodireccion = new DAODireccion();
    }    
    public boolean AcccionGuardarLista(List<EDireccion> x_lsedireccion,int x_codigo)
    {
        boolean _estado=false;
        try
        {
            EDireccion _edireccion=null;           
            for(int i =0;i<=x_lsedireccion.size()-1;i++)
            {
                _edireccion=x_lsedireccion.get(i);
                _edireccion.setCli_ncodigo(x_codigo);
                if(_edireccion.getM_Instancia()==InstancaEntidad.NEW)
                {
                    _estado=_daodireccion.Guardar(_edireccion);
                    //x_lsedireccion.set(i, _edireccion);
                }
                else if(_edireccion.getM_Instancia()==InstancaEntidad.MODIFY)
                {
                    _estado=_daodireccion.Modificar(_edireccion);
                }
                else if(_edireccion.getM_Instancia()==InstancaEntidad.DELETE)
                {
                    _estado=_daodireccion.Eliminar(_edireccion);
                }
            }        
        }
        catch(Exception e)
        {
        }        
        return _estado;
    }
    
    public List<EDireccion> AcccionObtenerLista(Integer x_codigo)
    {
        List<EDireccion> _lsedireccion=new ArrayList<>();
        try
        {
             _lsedireccion= _daodireccion.ObtenerxCliente(x_codigo);
        }
        catch(Exception e)
        {
            
        }       
        return _lsedireccion;
        
    }
    
    public void AcccionEliminarxcliente(int x_codigo)
    {
        try
        {
            _daodireccion.EliminarxCliente(x_codigo);
        }
        catch(Exception e)
        {}
    }
    public DefaultComboBoxModel AccionObtenerDireccionxClienteFacturacion(int x_codigo)
    {
        return _daodireccion.ObtenerDireccionxCliente(x_codigo);
    }

    public EDireccion AcctionObtenerUnaDireccion(int _codigo) {
        
        return _daodireccion.ObtenerDireccionxcodigo(_codigo);
    }
    public boolean  VerificarAsignacionDireccion(int x_cliente)
    {
        return _daodireccion.VerificarAsignacionDireccion(x_cliente);
    }

}

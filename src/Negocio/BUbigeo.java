
package Negocio;

import AccessoDato.DAOUbigeo;
import AccessoDato.EUbigeo;
import java.util.ArrayList;
import java.util.List;


public class BUbigeo {
    
    private DAOUbigeo _daoubigeo;

    public BUbigeo() {
    _daoubigeo=new DAOUbigeo();
    }
    
    public List<EUbigeo> ObtenerTodos(int x_tipo,String cod)
    {
        List<EUbigeo> _lsubigeo=new ArrayList<>();
        
        try
        {
            _daoubigeo.setTiposelec(x_tipo);
            _daoubigeo.setCodigo(cod);
            _lsubigeo=(List<EUbigeo>) _daoubigeo.ObtenerTodos();
        }
        catch(Exception e)
        {
        
        }
        
        return _lsubigeo;
    }
    
    public int ObtenerUno(String _codigo)
    {
        int _rpta=0;
        try
        {
            EUbigeo _ebigeo=new EUbigeo();
            _daoubigeo.setCodigo(_codigo);
            _ebigeo=(EUbigeo) _daoubigeo.ObtenerUno(0);
            _rpta= _ebigeo.getUbi_ncodigo();
        }
        catch(Exception e)
        {
        }
        return _rpta;
    }
    public EUbigeo ObtenerUnoxCodigo(int x_codigo)
    {
        EUbigeo _eubuigeo=null;
        try
        {
            
            _eubuigeo=(EUbigeo) _daoubigeo.ObtenerUnoxCodigo(x_codigo);
           
        }
        catch(Exception e)
        {
        }
        return _eubuigeo;
    }
}

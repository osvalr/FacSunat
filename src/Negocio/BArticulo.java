
package Negocio;

import AccessoDato.DAOArticulo;
import AccessoDato.DAOPrecioVenta;
import AccessoDato.EArticulo;
import AccessoDato.EPrecioVenta;
import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BArticulo {
    
    private DAOArticulo _daoarticulo=null;
    private DAOPrecioVenta _daoprecioventa=null;
    private Conector _con;
    public BArticulo() {
        _daoarticulo = new DAOArticulo();
    }
    public boolean AccionGuardar(EArticulo x_ar,List<EPrecioVenta> x_lista) throws SQLException
    {
        boolean _flag=false;
        _con= new Conector(true);  
        try
        {                  
            _con.con.setAutoCommit(false);   
            _daoarticulo.setCon(_con);
            if(_daoarticulo.Guardar(x_ar))
            {
                _daoprecioventa = new DAOPrecioVenta();
                _daoprecioventa.setCon(_con);
                EPrecioVenta _eprecio;
                for(int i=0;i<=x_lista.size()-1;i++ )
                {
                    _eprecio=x_lista.get(i);
                    _eprecio.setArt_ncodigo(x_ar.getArt_ncodigo());
                    if(_eprecio.getM_instancia()==InstanciaEntidad.NEW)
                    {
                        _flag=_daoprecioventa.Guardar(_eprecio);
                    }
                    if(_eprecio.getM_instancia()==InstanciaEntidad.MODIFY)
                    {
                        _flag=_daoprecioventa.Modificar(_eprecio);
                    }
                    if(_eprecio.getM_instancia()==InstanciaEntidad.DELETE)
                    {
                        _flag=_daoprecioventa.Eliminar(_eprecio.getPve_ncodigo());
                    }               
                    if(!_flag)
                        break;
                    } 
            }
            
            if(_flag)
                _con.con.commit();
            else
                _con.con.rollback();
        }
        catch(Exception e)
        {
             _con.con.rollback();
        }
        _con.Cerrar();
        return _flag;
        
        
    }
    
    public boolean  AccionModificar(EArticulo x_ar,List<EPrecioVenta> x_lista) throws SQLException
    {
         boolean _flag=false;
        _con= new Conector(true);  
        try
        {
            _con.con.setAutoCommit(false);   
            EPrecioVenta _eprecio;
            _daoarticulo.setCon(_con);
            if(_daoarticulo.Modificar(x_ar))
            {
                _daoprecioventa = new DAOPrecioVenta();
                _daoprecioventa.setCon(_con);
                for(int i=0;i<=x_lista.size()-1;i++ )
                {
                    _eprecio=x_lista.get(i);
                    _eprecio.setArt_ncodigo(x_ar.getArt_ncodigo());
                    if(_eprecio.getM_instancia()==InstanciaEntidad.NEW)
                    {
                        _flag=_daoprecioventa.Guardar(_eprecio);
                    }
                    if(_eprecio.getM_instancia()==InstanciaEntidad.MODIFY)
                    {
                        _flag=_daoprecioventa.Modificar(_eprecio);
                    }
                    if(_eprecio.getM_instancia()==InstanciaEntidad.DELETE)
                    {
                        _flag=_daoprecioventa.Eliminar(_eprecio.getPve_ncodigo());
                    }               
                    if(!_flag)
                        break;
                    } 
            }
            
            if(_flag)
                _con.con.commit();
            else
                _con.con.rollback();
        }
        catch(Exception e)
        {
             _con.con.rollback();
        }
        _con.Cerrar();
        return _flag;
    }
    
    public List<EArticulo> ObtenerTodos()
    {
        List<EArticulo> _lsarticulo= new ArrayList<>();
        try
        {
            _lsarticulo= _daoarticulo.ObtenerTodos();
        }
        catch(Exception e)
        {}
        return _lsarticulo;
    }
    
    public EArticulo ObtenerUno(int x_codigo)
    {
        EArticulo _earticulo=null;
        try
        {
            _earticulo=_daoarticulo.ObtenerUno(x_codigo);
        }
        catch(Exception e)
        {
        
        }
        return _earticulo;
    }
    
}


package Negocio;

import AccessoDato.DAOENumero;
import AccessoDato.DAOParametro;
import AccessoDato.ENumero;
import AccessoDato.EParametro;
import Utilidad.Conector;
import Utilidad.InstancaEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BParametro {
    private DAOParametro _daoparametro;
    private Conector _con;
    private DAOENumero _daonumero;

    public BParametro() {
        _daoparametro=new DAOParametro();
    }
    public EParametro AccionObtenerConfiguracion(int x_codigo,String x_tipodocumento)
    {
        EParametro _epara=null;
        try
        {
            _daoparametro.setTipoDocumento(x_tipodocumento);
           _epara= (EParametro) _daoparametro.ObtenerUno(x_codigo);
        }
        catch(Exception e)
        { }
        return _epara;
    }
    
    public boolean Guardar(EParametro x_parametro,List<ENumero> x_lsnumero) throws SQLException
    {
        boolean _rpta=true;
        try {
            _con= new Conector(true);  
            _con.con.setAutoCommit(false);  
            _daoparametro.setCon(_con);
            if(x_parametro.getM_instancia()==InstancaEntidad.NEW)
            {
                if(_daoparametro.Guardar(x_parametro))
                {
                    _daonumero= new DAOENumero();
                    _daonumero.setCon(_con);
                    ENumero _enumero;
                    for(int i=0;i<=x_lsnumero.size()-1;i++)
                    {
                        _enumero=x_lsnumero.get(i);
                        _enumero.setPar_ncodigo(x_parametro.getPar_ncodigo());
                        _enumero.setSuc_ncodigo(x_parametro.getPar_nsucursal());
                        if(_enumero.getM_instancia()==InstancaEntidad.NEW)
                            _rpta=_daonumero.Guardar(_enumero);
                        if(_enumero.getM_instancia()==InstancaEntidad.MODIFY)
                            _rpta=_daonumero.Modificar(_enumero);
                        if(!_rpta)
                            break;
                    }
                 }
            }
            else if(x_parametro.getM_instancia()==InstancaEntidad.MODIFY)
            {
                    if(_daoparametro.Modificar(x_parametro))
                    {
                        _daonumero= new DAOENumero();
                        _daonumero.setCon(_con);
                        ENumero _enumero;
                        for(int i=0;i<=x_lsnumero.size()-1;i++)
                        {
                            _enumero=x_lsnumero.get(i);
                            _enumero.setPar_ncodigo(x_parametro.getPar_ncodigo());
                            _enumero.setSuc_ncodigo(x_parametro.getPar_nsucursal());
                            if(_enumero.getM_instancia()==InstancaEntidad.NEW)
                                _rpta=_daonumero.Guardar(_enumero);
                            if(_enumero.getM_instancia()==InstancaEntidad.MODIFY)
                                _rpta=_daonumero.Modificar(_enumero);
                            if(!_rpta)
                                break;
                        }
                    } 
            }
            if(_rpta)
                _con.con.commit();
            else
                _con.con.rollback();
        } catch (Exception e) {_con.con.rollback();
        }
        _con.Cerrar();
        return _rpta;
    }
    
    public List<EParametro> AccionObtenerTodosParametro()
    {
        List<EParametro> _lsparametro=new ArrayList<>();
        try {
            _lsparametro=_daoparametro.ObtenerTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return _lsparametro;
    }
    
    public EParametro AccionObtenerUno(int x_codigo)
    {
        EParametro _eparametro=null;
        try {
            _eparametro=(EParametro) _daoparametro.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
        return _eparametro;
    }
    public EParametro AccionObtenerxIdParametro(int x_codigo)
    {
        EParametro _eparametro=null;
        try {
            _eparametro=(EParametro) _daoparametro.ObtenerUnoxIdParametro(x_codigo);
        } catch (Exception e) {
        }
        return _eparametro;
    }
    
    
}

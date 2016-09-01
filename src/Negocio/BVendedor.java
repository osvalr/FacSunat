
package Negocio;

import AccessoDato.DAOVendedor;
import AccessoDato.EVendedor;
import java.util.ArrayList;
import java.util.List;


public class BVendedor {
    
    private DAOVendedor _daovendedor;

    public BVendedor() {
        _daovendedor= new DAOVendedor();
    }
    
    public List<EVendedor> ObtenerTodos()
    {
        List<EVendedor> _lsvendedor= new ArrayList<>();
        try
        {
            _lsvendedor=(List<EVendedor>) _daovendedor.ObtenerTodos();
        }catch(Exception e)
        {}
        
        return _lsvendedor;
    }
    
    public boolean AccionGuardar(EVendedor x_vendedor)
    {
        boolean _rpta=false;
        try {
            _rpta=_daovendedor.Guardar(x_vendedor);
        } catch (Exception e) {
        }
        return _rpta;
    }
    public boolean AccionModificar(EVendedor x_vendedor)
    {
        boolean _rpta=false;
        try {
            _rpta=_daovendedor.Modificar(x_vendedor);
        } catch (Exception e) {
        }
        return _rpta;
    }
    public boolean AccionEliminar(EVendedor _xvendedor)
    {
        boolean _rpta=false;
        try {
            
        } catch (Exception e) {
        }
        return _rpta;
    }
    public List<EVendedor> AccionObtenerTodos()
    {
        List<EVendedor> _lsvendedor = new ArrayList<>();
        try {
            
            _lsvendedor=_daovendedor.ObtenerTodos();
        } catch (Exception e) {
        }
        return _lsvendedor;
    }
    public EVendedor AccionObtenerUno(int x_codigo)
    {
        EVendedor _evendedor=null;
        try {
            _evendedor=(EVendedor) _daovendedor.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
        return _evendedor;
    }
}

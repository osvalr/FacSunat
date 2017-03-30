
package Negocio;

import AccessoDato.DAODescuentoFactura;
import AccessoDato.EDescuentoFactura;
import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.util.ArrayList;
import java.util.List;

public class BDescuentoFactura {
    
    private DAODescuentoFactura _daodescuentofactura;
    private Conector _con;
    public BDescuentoFactura() {
        _daodescuentofactura = new DAODescuentoFactura();
    }
    public boolean Guardar(List<EDescuentoFactura> _lsdescuento)
    {
        boolean _rpta=true;
        _con= new Conector(true);  
        try
        {
            _con.Abrir();
            _con.con.setAutoCommit(false);
            _daodescuentofactura.setCon(_con);
            for (int i=0;i<=_lsdescuento.size()-1;i++)
            {
                EDescuentoFactura _edescuento=_lsdescuento.get(i);
                if(_edescuento.getM_instancia()==InstanciaEntidad.NEW)
                {
                    _rpta=_daodescuentofactura.Guardar(_edescuento);
                }
                if(_edescuento.getM_instancia()==InstanciaEntidad.MODIFY)
                {
                     _rpta=_daodescuentofactura.Modificar(_edescuento);
                }
                if(!_rpta)
                    break;
            }
            if(_rpta)
                 _con.con.commit();
            else
                 _con.con.rollback();
        }catch(Exception e)
        {
            _con.Cerrar();
        }
        finally{ _con.Cerrar();}
        return _rpta;
    }
    
    public List<EDescuentoFactura> ObtenerTodos()
    {
        List<EDescuentoFactura> _lsdescuento =new ArrayList<>();
        try
        {
            _lsdescuento=(List<EDescuentoFactura>) _daodescuentofactura.ObtenerTodos();
        }catch(Exception e)
        {}
        return _lsdescuento;
    }
    
    public List<EDescuentoFactura> ObtenerDescuentoxSucursal(int x_codsucursal)
    {   List<EDescuentoFactura> _lsdescuento =new ArrayList<>();
        try
        {
            _lsdescuento=_daodescuentofactura.ObtenerDescuentoxSucursal(x_codsucursal);
        }catch(Exception e)
        {}
        return _lsdescuento;
    }
}

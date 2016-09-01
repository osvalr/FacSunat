
package Negocio;

import AccessoDato.DAODescuentoCabecera;
import AccessoDato.DAODescuentoFactura;
import AccessoDato.EDescuentoCabecera;
import AccessoDato.EDescuentoFactura;
import Utilidad.Conector;
import Utilidad.InstancaEntidad;
import java.util.ArrayList;
import java.util.List;

public class BDescuentoCabecera {
    private Conector _con;
    private DAODescuentoCabecera _daocabecerades;
    private DAODescuentoFactura _daodescuentofactura;
    public BDescuentoCabecera() {
        _daocabecerades= new DAODescuentoCabecera();
    }
    
    public boolean Guardar(EDescuentoCabecera _ecabedes,List<EDescuentoFactura> _lsdescuento)
    {
        boolean _rpta=true;
        _con= new Conector(true); 
        try
        {
            _con.Abrir();
            _con.con.setAutoCommit(false);
            _daocabecerades.setCon(_con);
            if(_ecabedes.getM_instancia()==InstancaEntidad.NEW)
            {
                if(_daocabecerades.Guardar(_ecabedes))
                {
                    _daodescuentofactura=new DAODescuentoFactura();
                    _daodescuentofactura.setCon(_con);
                    for (int i=0;i<=_lsdescuento.size()-1;i++)
                    {
                        EDescuentoFactura _edescuento=_lsdescuento.get(i);
                        _edescuento.setCds_ncodigo(_ecabedes.getCds_ncodigo());
                        if(_edescuento.getM_instancia()==InstancaEntidad.NEW)
                        {
                            _rpta=_daodescuentofactura.Guardar(_edescuento);
                        }
                        if(_edescuento.getM_instancia()==InstancaEntidad.MODIFY)
                        {
                             _rpta=_daodescuentofactura.Modificar(_edescuento);
                        }
                    if(!_rpta)
                        break;
                    }
                }
            }
            else if(_ecabedes.getM_instancia()==InstancaEntidad.MODIFY)
            {
                if(_daocabecerades.Modificar(_ecabedes))
                {
                    _daodescuentofactura=new DAODescuentoFactura();
                    _daodescuentofactura.setCon(_con);
                    for (int i=0;i<=_lsdescuento.size()-1;i++)
                    {
                        EDescuentoFactura _edescuento=_lsdescuento.get(i);
                        _edescuento.setCds_ncodigo(_ecabedes.getCds_ncodigo());
                        if(_edescuento.getM_instancia()==InstancaEntidad.NEW)
                        {
                            _rpta=_daodescuentofactura.Guardar(_edescuento);
                        }
                        if(_edescuento.getM_instancia()==InstancaEntidad.MODIFY)
                        {
                             _rpta=_daodescuentofactura.Modificar(_edescuento);
                        }
                        if(!_rpta)
                            break;
                    }
                }
            }
             if(_rpta)
                 _con.con.commit();
                else
                 _con.con.rollback();
        }catch(Exception e)
        { _con.Cerrar();}
        finally{ _con.Cerrar();}
        return _rpta;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    public List<EDescuentoCabecera> ObtenerTodo()
    {
        List<EDescuentoCabecera> _lsdescuento = new ArrayList<>();
        try
        {
           _lsdescuento=(List<EDescuentoCabecera>) _daocabecerades.ObtenerTodos();
        }catch(Exception e)
        {}
        
        return _lsdescuento;
    }
    
    public EDescuentoCabecera ObtenerUno(int x_codigo)
    {
        EDescuentoCabecera _edescuento=null;
        try
        {
            _edescuento=(EDescuentoCabecera) _daocabecerades.ObtenerUno(x_codigo);
        }catch(Exception e)
        {}
        
        return _edescuento;
    }
    
    
}

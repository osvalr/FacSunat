
package Negocio;

import AccessoDato.DAODetFactura;
import AccessoDato.DAOENumero;
import AccessoDato.DAOFactura;
import AccessoDato.DAOParametro;
import AccessoDato.ECliente;
import AccessoDato.EDireccion;
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import AccessoDato.EPlaca;
import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BFactura {
    
    private DAOFactura _daofac;
    private DAODetFactura _daodetalle;    
    private DAOParametro _daoparametro;
    private DAOENumero _daonumero;
    private Conector _con;
    private BCliente _bcliente;
    private BPlaca _bplaca;
    public BFactura() {
        _daofac = new DAOFactura();
    }
    
    public boolean AccionGuardar(EFactura entidad,List<EFacturaDetalle> x_detalle,int x_num_ncodigo,EDireccion x_direccion,EPlaca x_placa,ECliente x_cliente) throws SQLException
    {

        boolean _flag=false;
        _con=new Conector(true);               
        try
        {
            
            _daofac.setCon(_con);
            _con.con.setAutoCommit(false);
            if(_daofac.Guardar(entidad))
            {
                //_daoparametro = new DAOParametro();
                _daonumero= new DAOENumero();
                if(_daonumero.IncrementarNumero(Integer.parseInt(entidad.getFac_cnumero()),x_num_ncodigo))
                {
                     _daodetalle = new DAODetFactura();  
                _daodetalle.setCon(_con);
                EFacturaDetalle _efacturadet;
                for (int i=0;i<=x_detalle.size()-1;i++)
                {
                    _efacturadet=x_detalle.get(i);
                    _efacturadet.setFac_ncodigo(entidad.getFac_ncodigo());

                    if(_efacturadet.getM_instancia()==InstanciaEntidad.NEW)
                    {
                        _flag=_daodetalle.Guardar(_efacturadet);
                    }
                    if(_efacturadet.getM_instancia()==InstanciaEntidad.MODIFY)
                    {
                        _flag=_daodetalle.Modificar(_efacturadet);
                    }
                    if(_efacturadet.getM_instancia()==InstanciaEntidad.DELETE)
                    {
                         _flag=_daodetalle.Modificar(_efacturadet);
                    }                                
                    if(!_flag)
                        break;
                }
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
    public List<EFactura> ObtenerTodo()
    {
        List<EFactura> _lsfactura = new ArrayList<>();
        try
        {
            _lsfactura=_daofac.ObtenerTodos();
        }
        catch(Exception e)
        {}
        
        return _lsfactura;
    }
    public EFactura AccionObtenerObtenerUno(int x_codigo)
    {
        EFactura _efactura=null;
        try {
            _efactura=(EFactura) _daofac.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
        return _efactura;
    }
    
    public boolean AccionGuardarCompleto(EFactura entidad,List<EFacturaDetalle> x_detalle,int x_num_ncodigo,EDireccion x_direccion,EPlaca x_placa,ECliente x_cliente) throws SQLException
    {
        boolean _flag=true;
        _con=new Conector(true);               
        try
        {
            _con.con.setAutoCommit(false);
            _bcliente = new BCliente();
            _bcliente.setCrearinstaciadao(false);
            _bcliente.setCon(_con);

            if(x_cliente.getCli_ncodigo()!=0)
            {

                if(x_placa!=null)
                {       if(x_placa.getM_instancia()==(InstanciaEntidad.NEW))
                        {
                                _bplaca = new BPlaca();
                                _bplaca.setCon(_con);
                                if(_bplaca.AccionGuardarDesdeFactura(x_placa))
                                {
                                    entidad.setPla_ncodigo(x_placa.getPla_ncodigo());
                                }
                                _daofac.setCon(_con);
                                if(_daofac.Guardar(entidad))
                                {
                                        _daonumero= new DAOENumero();
                                        if(_daonumero.IncrementarNumero(Integer.parseInt(entidad.getFac_cnumero()),x_num_ncodigo))
                                        {
                                                _daodetalle = new DAODetFactura();  
                                                _daodetalle.setCon(_con);
                                                EFacturaDetalle _efacturadet;
                                                for (int i=0;i<=x_detalle.size()-1;i++)
                                                {
                                                    _efacturadet=x_detalle.get(i);
                                                    _efacturadet.setFac_ncodigo(entidad.getFac_ncodigo());

                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.NEW)
                                                    {
                                                        _flag=_daodetalle.Guardar(_efacturadet);
                                                    }
                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.MODIFY)
                                                    {
                                                        _flag=_daodetalle.Modificar(_efacturadet);
                                                    }
                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.DELETE)
                                                    {
                                                         _flag=_daodetalle.Modificar(_efacturadet);
                                                    }                                
                                                    if(!_flag)
                                                        break;
                                                }
                                        }
                                }
                                else
                                {
                                    _con.con.rollback();
                                    return false;
                                }        
                            }
                            else
                            {
                                _con.con.rollback();
                                return false;
                            }
                        
                        
                }else {
                                _daofac.setCon(_con);
                                if(_daofac.Guardar(entidad))
                                {
                                        _daonumero= new DAOENumero();
                                        if(_daonumero.IncrementarNumero(Integer.parseInt(entidad.getFac_cnumero()),x_num_ncodigo))
                                        {
                                                _daodetalle = new DAODetFactura();  
                                                _daodetalle.setCon(_con);
                                                EFacturaDetalle _efacturadet;
                                                for (int i=0;i<=x_detalle.size()-1;i++)
                                                {
                                                    _efacturadet=x_detalle.get(i);
                                                    _efacturadet.setFac_ncodigo(entidad.getFac_ncodigo());

                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.NEW)
                                                    {
                                                        _flag=_daodetalle.Guardar(_efacturadet);
                                                    }
                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.MODIFY)
                                                    {
                                                        _flag=_daodetalle.Modificar(_efacturadet);
                                                    }
                                                    if(_efacturadet.getM_instancia()==InstanciaEntidad.DELETE)
                                                    {
                                                         _flag=_daodetalle.Modificar(_efacturadet);
                                                    }                                
                                                    if(!_flag)
                                                        break;
                                                }
                                        }
                            }
                            else
                            {
                                _con.con.rollback();
                                return false;
                            }
                }
                        }
            
            //------------------------------------------------------------------------RolBack or comit 
            if(_flag)
                _con.con.commit();
            else
                _con.con.rollback();
            
        }
        catch(Exception e)
        {
             _con.con.rollback();
             System.out.println("Error grave:"+e.getMessage());
        }
        finally{_con.Cerrar();}
        
        return _flag;
    }

    public EFactura ObtenerTodoxSerieandNumero(String x_serie,String x_numero) {
        
         EFactura _efactura=null;
        try {
            _efactura=(EFactura) _daofac.ObtenerUnoxSerieNumero(x_serie,x_numero);
        } catch (Exception e) {
        }
        return _efactura;
    }
    
    public boolean  VerificarExisteFactura(String x_serie,String x_numero)
    {
          return _daofac.VerificarFacturaxSerieNumero(x_serie, x_numero);
        
    }

    boolean ActualizaFactura_SerieNumeroNotacredito(String x_serie_numero_iddoc,int x_codigo) {//----------------Solo actualiza la factua con la serie,numero y iddocumento de la nota de credito.
        _daofac.setCon(_con);
        return _daofac.ActualizaFactura_SerieNumeroNotacredito(x_serie_numero_iddoc,x_codigo);
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    public EFactura AccionBuscarxSerieNumeroTipo(String x_tipo,String x_serie,String x_numero)
    {
        return _daofac.buscarxSerieNumeroTipo(x_tipo, x_serie, x_numero);
    }
    
    
}

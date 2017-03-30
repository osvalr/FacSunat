
package Negocio;

import AccessoDato.DAOCliente;
import AccessoDato.DAODireccion;
import AccessoDato.DAOPlaca;
import AccessoDato.ECliente;
import AccessoDato.EDireccion;
import AccessoDato.EPlaca;
import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class BCliente {
    
    private DAOCliente _daocliente=null;
    private Conector _con;
    private DAODireccion _daodireccion;
    private DAOPlaca _daoplaca;
    private boolean  _crearinstaciadao;
    public BCliente()
    {
        _daocliente = new DAOCliente();
    }
    
    public Boolean AcccionGuardar(ECliente x_cli,List<EDireccion> _lsdireccion,List<EPlaca> _lsplaca) throws SQLException
    {
        boolean _rpta=true;
        if(_crearinstaciadao)
            _con = new Conector(false);        
        try
        {
            _con.con.setAutoCommit(false);
            _daocliente.setCon(_con);
            if(_daocliente.Guardar(x_cli))
            {
                _daodireccion= new DAODireccion();
                _daodireccion.setCon(_con);
                EDireccion _edireccion;
                for(int i=0;i<=_lsdireccion.size()-1;i++)
                {
                    _edireccion=_lsdireccion.get(i);
                    _edireccion.setCli_ncodigo(x_cli.getCli_ncodigo());
                    if(null!=_edireccion.getM_Instancia())
                        switch (_edireccion.getM_Instancia()) {
                        case NEW:
                            _rpta=_daodireccion.Guardar(_edireccion);
                            break;
                        case MODIFY:
                            _rpta=_daodireccion.Modificar(_edireccion);
                            break;
                        case DELETE:
                            _rpta=_daodireccion.Guardar(_edireccion);
                            break;
                        default:
                            break;
                    }
                    if(!_rpta)
                        break;
                }
                //para guardar placa
                _daoplaca= new DAOPlaca();
                _daoplaca.setCon(_con);
                EPlaca _eplaca;
                for(int i=0;i<=_lsdireccion.size()-1;i++)
                {
                    _eplaca=_lsplaca.get(i);
                    _eplaca.setCli_ncodigo(x_cli.getCli_ncodigo());
                    if(null!=_eplaca.getM_instancia())
                        switch (_eplaca.getM_instancia()) {
                        case NEW:
                            _rpta=_daoplaca.Guardar(_eplaca);
                            break;
                        case MODIFY:
                            _rpta=_daoplaca.Modificar(_eplaca);
                            break;
                        case DELETE:
                            _rpta=_daoplaca.Guardar(_eplaca);
                            break;
                        default:
                            break;
                    }
                    if(!_rpta)
                        break;
                }
                if(_rpta)
                    _con.con.commit();
                else
                    _con.con.rollback();;
            }
        }
        catch(Exception e)
        {
            _con.con.rollback();
        }
        finally{_con.Cerrar();}
        return _rpta;
    }
    
    public Boolean AcccionModificar(ECliente x_cli,List<EDireccion> _lsdireccion,List<EPlaca> _lsplaca) throws SQLException
    {
        boolean _rpta=true;
        _con = new Conector(false);        
        try
        {
            _con.con.setAutoCommit(false);
            _daocliente.setCon(_con);
            if(_daocliente.Modificar(x_cli))
            {
                _daodireccion= new DAODireccion();
                _daodireccion.setCon(_con);
                EDireccion _edireccion;
                for(int i=0;i<=_lsdireccion.size()-1;i++)
                {
                    _edireccion=_lsdireccion.get(i);
                    _edireccion.setCli_ncodigo(x_cli.getCli_ncodigo());
                    if(null!=_edireccion.getM_Instancia())
                        switch (_edireccion.getM_Instancia()) {
                        case NEW:
                            _rpta=_daodireccion.Guardar(_edireccion);
                            break;
                        case MODIFY:
                            _rpta=_daodireccion.Modificar(_edireccion);
                            break;
                        case DELETE:
                            _rpta=_daodireccion.Guardar(_edireccion);
                            break;
                        default:
                            break;
                    }
                    if(!_rpta)
                        break;
                }
                //para guardar placa
                _daoplaca=new DAOPlaca();
                _daoplaca.setCon(_con);
                EPlaca _eplaca;
                for(int i=0;i<=_lsplaca.size()-1;i++)
                {
                    _eplaca=_lsplaca.get(i);
                    _eplaca.setCli_ncodigo(x_cli.getCli_ncodigo());
                    if(null!=_eplaca.getM_instancia())
                        switch (_eplaca.getM_instancia()) {
                        case NEW:
                            _rpta=_daoplaca.Guardar(_eplaca);
                            break;
                        case MODIFY:
                            _rpta=_daoplaca.Modificar(_eplaca);
                            break;
                        case DELETE:
                            _rpta=_daoplaca.Guardar(_eplaca);
                            break;
                        default:
                            break;
                    }
                    if(!_rpta)
                        break;
                }
                if(_rpta)
                    _con.con.commit();
                else
                    _con.con.rollback();;
            }
        }
        catch(Exception e)
        {
            _con.con.rollback();
        }
        finally{_con.Cerrar();}
        return _rpta;
    }
    public Boolean Acccioneliminar(int x_codigo)
    {
        boolean _rpta=false;
        try
        {
            _rpta= _daocliente.Eliminar(x_codigo);            
        }
        catch(Exception e)
        {
        
        }
        return _rpta;
    }
    
    public List<ECliente> ObtenerTodos()
    {
        List<ECliente> _lscliente = new ArrayList<>();
        try
        {
            _lscliente = _daocliente.ObtenerTodos();
        }
        catch(Exception e)
        {
        }
        
        return _lscliente;
    }
    
    public ECliente ObtenerUno(int x_idCli)
    {
        ECliente _ecliente =null;
        try
        {
            _daocliente = new DAOCliente();
            _ecliente = _daocliente.ObtenerUno(x_idCli);
        }
        catch(Exception e)
        {}
        return _ecliente;
    }
    public Boolean AcccionGuardar_Factura(ECliente x_cli,EDireccion x_edireccion) throws SQLException
    {
        boolean _rpta=true;
        if(_crearinstaciadao)
            _con = new Conector(false);        
        try
        {
            _con.con.setAutoCommit(false);
            _daocliente.setCon(_con);
            if(_daocliente.Guardar(x_cli))
            {
                    _daodireccion= new DAODireccion();
                    _daodireccion.setCon(_con);
                    EDireccion _edireccion;
                    _edireccion=x_edireccion;
                    if(_edireccion!=null)
                    {
                        _edireccion.setCli_ncodigo(x_cli.getCli_ncodigo());
                        if(null!=_edireccion.getM_Instancia())
                            switch (_edireccion.getM_Instancia()) 
                            {
                            case NEW:
                                _rpta=_daodireccion.Guardar(_edireccion);
                                break;
                            case MODIFY:
                                _rpta=_daodireccion.Modificar(_edireccion);
                                break;
                            case DELETE:
                                _rpta=_daodireccion.Guardar(_edireccion);
                                break;
                            default:
                                break;
                            }
                    }
            }
        }
        catch(Exception e)
        {
            _con.con.rollback();
        }
        
        return _rpta;
    }

    public DefaultComboBoxModel AcctionFiltrarClientexTipoDocumento(String cadena, String valueMenber) {
        
        return _daocliente.AcctionFiltrarClientexTipoDocumento(cadena, valueMenber);
    }
//    public DefaultComboBoxModel AcctionFiltrarClientexNombreCliente(String cadena, String valueMenber) {
//        
//        return _daocliente.AcctionFiltrarClientexNombrecliente(cadena, valueMenber);
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public List<ECliente> ListarAcctionFiltrarClientexNombreCliente(String cadena, String valueMenber) {
        
        return _daocliente.listarAcctionFiltrarClientexNombrecliente(cadena, valueMenber);
    }

    public boolean isCrearinstaciadao() {
        return _crearinstaciadao;
    }

    public void setCrearinstaciadao(boolean _crearinstaciadao) {
        this._crearinstaciadao = _crearinstaciadao;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    public Boolean AcccionGuardarSolo(ECliente x_cli)
    {
        boolean _rpta=true;
            _con = new Conector(false);        
        try
        {
            _daocliente.setCon(_con);
            _rpta= (_daocliente.Guardar(x_cli));
  
        }
        catch(Exception e)
        {
           // _con.con.rollback();
        }
        finally{_con.Cerrar();}
        return _rpta;
    }
}

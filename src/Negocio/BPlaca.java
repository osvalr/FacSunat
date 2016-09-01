
package Negocio;

import AccessoDato.DAOPlaca;
import AccessoDato.EPlaca;
import Utilidad.Conector;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class BPlaca {
    DAOPlaca _daoplaca;
    private Conector _con;
    public BPlaca() {
        _daoplaca= new DAOPlaca();
    }
    public List<EPlaca> AccionObtenerTodo()
    {
        List<EPlaca> _eplaca =new ArrayList<>();
        try {
            _eplaca=_daoplaca.ObtenerTodos();
        } catch (Exception e) {
        }
          return _eplaca;
            
    }
    public boolean AccionGuardar(EPlaca x_placa)
    {
         boolean r=true;
        try {
             r=_daoplaca.Guardar(x_placa);
        } catch (Exception e) {
        }
        return r;
    }

    public Conector getCon() {
        return _con;
    }
    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    public DefaultComboBoxModel AccionFiltrarplacaxCliente(String x_nombre,int x_codigo) {//invocado para cargar combobox en factura
        return _daoplaca.FiltrarPlaca(x_nombre,x_codigo);
    }
    public DefaultComboBoxModel AccionObtenerPlacaxCliente(Integer cli_ncodigo) {//invocado para cargar combobox en factura
        return _daoplaca.FiltrarPlacaxCliente("",cli_ncodigo);
    }
    
    public boolean AccionGuardarxFactura(EPlaca x_placa)//invocado desde el guardar factura
    {
         boolean r=true;
        try {
            _daoplaca.setCon(_con);
             r=_daoplaca.Guardar(x_placa);
        } catch (Exception e) {
        }
        return r;
    }
    
    public EPlaca AccionObtenerUno(int x_codigo,int x_clincodigo)//obtiene al editar una direccion de un cliente
    {
        EPlaca _eplaca =null;
        try {
            _daoplaca.setCli_ncodigo(x_clincodigo);
            _eplaca=(EPlaca) _daoplaca.ObtenerUno(x_codigo);
        } catch (Exception e) {
        }
          return _eplaca;
            
    }
    
    public List<EPlaca> AccionObtenerTodoxCodigoCliente_ClienteMantenimeinto(int x_codigo)
    {
        List<EPlaca> _eplaca =new ArrayList<>();
        try {
            _eplaca=_daoplaca.ObtenerTodosPlacasdeClienteMantenimiento(x_codigo);
        } catch (Exception e) {
        }
          return _eplaca;
    }
    //esta funciona obtiene una placa realizar el mantenimento de una placa ya gravada
    public EPlaca AcctionObtenerUnaPlacaMantenimiento(int x_codigo)
    {
        return _daoplaca.ObtenerUnaPlacaxMantenimiento(x_codigo);
    }

    public boolean AccionValidarPlacaExistente(int x_codigo) {
        
        return _daoplaca.ValidarPlacaExistente(x_codigo);
    }
//    public boolean  AccionValidarPlacaDuplicadaExistente(int x_codigo,String x_placa)  {
//        return _daoplaca.ValidarPlacaDuplicadaExistente(x_codigo, x_placa);
//    }
    
}


package AccessoDato;

import Utilidad.Conector;
import Utilidad.DisplayValue;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

public class DAOPlaca implements IOperacion{

    private final String  _insertOne="insert into placa (pla_cnombre,cli_ncodigo)values(?,?) returning pla_ncodigo";
    private final String  _updateOne="";
    private final String  _selectAll="select  * from placa where cli_ncodigo=?";  
    private final String _selectOnexCliente="select  * from placa where pla_ncodigo=? and cli_ncodigo=?";
    private final String _selectOnePlacaxIdCliente="select  * from placa where cli_ncodigo=?";
    private final String _selectOnePlacaxIdPlaca="select  * from placa where pla_ncodigo=?";

    private Conector _con;
    private PreparedStatement pst =null;
    private int cli_ncodigo;
    @Override
    public boolean Guardar(Object o) {
        EPlaca _eplaca=(EPlaca) o;
         try
         {
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _eplaca.getPla_cnombre());
            pst.setInt(2, _eplaca.getCli_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {   
                _eplaca.setPla_ncodigo(_rs.getInt("pla_ncodigo"));
                return true;
            }
         }catch(Exception e)
         {}
        return false;
    }

    @Override
    public boolean Modificar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
//         EPlaca _eplaca=null;
//         try {
//            _con= new Conector();
//            _con.Abrir();
//            pst=_con.RecibirQuer(_selectOnexCliente);
//            pst.setInt(1, o);
//            pst.setInt(2, cli_ncodigo);
//            ResultSet _rs = _con.EjecutarQuery(pst);  
//            if(_rs.next())
//              _eplaca=(new EPlaca(_rs.getInt("pla_ncodigo"), _rs.getString("pla_cnombre"),InstanciaEntidad.UNCHANGUE));
//        } catch (Exception e) { _con.Cerrar();  }
//         finally{_con.Cerrar();}
//         
//         return _eplaca;
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<EPlaca> ObtenerTodos() {
        List<EPlaca> _eplaca=null;
         try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _eplaca.add(new EPlaca(_rs.getInt("pla_ncodigo"), _rs.getString("pla_cnombre")));
        } catch (Exception e) { _con.Cerrar();  }
         finally{_con.Cerrar();}
         
         return _eplaca;
    }
    public DefaultComboBoxModel FiltrarPlaca(String x_nombre,int x_codigo)
    {
        DefaultComboBoxModel _modelo=null;
        _con= new Conector();
        try {
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            pst.setString(1, x_nombre);
            pst.setInt(2, x_codigo);
            Vector _item = new Vector();
            _item.addElement(new DisplayValue("Default","-2"));
            _item.addElement(new DisplayValue("Nuevo","-1"));
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _item.addElement(new DisplayValue(_rs.getString("pla_cnombre"),_rs.getInt("pla_ncodigo")));
            new DefaultComboBoxModel(_item);
        } catch (Exception e) {_con.Cerrar();}finally{_con.Cerrar();}
        
        return _modelo;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    public DefaultComboBoxModel FiltrarPlacaxCliente(String x_nombre,int x_codigo)
    {
        DefaultComboBoxModel _modelo=null;
        _con= new Conector();
        try {
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            pst.setInt(1, x_codigo);
            Vector _item = new Vector();
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _item.addElement(new DisplayValue(_rs.getString("pla_cnombre"),_rs.getInt("pla_ncodigo")));
            _modelo= new DefaultComboBoxModel(_item);
        } catch (Exception e) {_con.Cerrar();}finally{_con.Cerrar();}
        
        return _modelo;
    }
    public List<DisplayValue> FiltrarxCliente(int x_codigo)
    {
        List<DisplayValue> listaDisplay = new ArrayList<>();
        _con= new Conector();
        try {
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            pst.setInt(1, x_codigo);
            
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              listaDisplay.add(new DisplayValue(_rs.getString("pla_cnombre"),_rs.getInt("pla_ncodigo")));
            
        } catch (Exception e) {_con.Cerrar();}finally{_con.Cerrar();}
        
       return listaDisplay;
    }
    public int getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(int cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }
    
    public List<EPlaca> ObtenerListaPlacaxIdCliente(int x_codigo) {
        List<EPlaca> _eplaca=new ArrayList<>();
         try {
         
             _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnePlacaxIdCliente);
            pst.setInt(1, x_codigo);
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _eplaca.add(new EPlaca(_rs.getInt("pla_ncodigo"), _rs.getString("pla_cnombre"),InstanciaEntidad.UNCHANGUE));
        } catch (Exception e) { _con.Cerrar();  }
         finally{_con.Cerrar();}
         
         return _eplaca;
    }
    
    public EPlaca ObtenerUnaPlacaxMantenimiento(int x_codigo)
    {
        EPlaca _eplaca=null;
         try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnePlacaxIdPlaca);
            pst.setInt(1, x_codigo);
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _eplaca=(new EPlaca(_rs.getInt("pla_ncodigo"), _rs.getString("pla_cnombre"),InstanciaEntidad.UNCHANGUE));
        } catch (Exception e) { _con.Cerrar();  }
         finally{_con.Cerrar();}
         
         return _eplaca;
    }

    public boolean ValidarPlacaExistente(int x_codigo) {
        boolean _f=false;
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer("select verificarasignacionplaca_ssf(?)");
            pst.setInt(1, x_codigo);
            ResultSet _rs=_con.EjecutarQuery(pst);
            if(_rs.next())
                _f=_rs.getBoolean(1);
            
        } catch (Exception e) {
            System.out.println("Error en :"+e.getMessage());
            _con.Cerrar();
        }finally{_con.Cerrar();}
        return _f;
    }
    
//     public boolean ValidarPlacaDuplicadaExistente(int x_codigo,String x_placa) {
//        boolean _f=false;
//        try {
//            _con= new Conector();
//            _con.Abrir();
//            pst=_con.RecibirQuer("select verificarduplicadoplaca_ssf(?,?)");
//            pst.setInt(1, x_codigo);
//            pst.setString(2, x_placa);
//            ResultSet _rs=_con.EjecutarQuery(pst);
//            if(_rs.next())
//                _f=_rs.getBoolean(1);
//            
//        } catch (Exception e) {
//            System.out.println("Error en :"+e.getMessage());
//            _con.Cerrar();
//        }finally{_con.Cerrar();}
//        return _f;
//    }
}

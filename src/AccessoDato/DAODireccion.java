
package AccessoDato;

import Utilidad.Conector;
import Utilidad.DisplayValue;
import Utilidad.InstancaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class DAODireccion {
    private final String  _insertOne="insert into direccion(dir_descripcion,cli_ncodigo) values (?,?) returning dir_ncodigo;";
    private final String  _updateOne="update direccion set dir_descripcion=? where dir_ncodigo=?";
    private final String  _deleteOne="delete * from where dir_ncodigo=?";
    private final String  _deleteOnexCliente="delete * from where cli_ncodigo=?";
    private final String  _selectOnexCodigoDireccion="select * from direccion where dir_ncodigo=?";
    private final String  _selectxcliente="select * from direccion where cli_ncodigo=? order by dir_ncodigo";
    private final String  _selectAll="";    
    private Conector _con;
    private PreparedStatement pst =null;
    
    public boolean Guardar(EDireccion x_direccion)
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, x_direccion.getDir_cdescripcion());
            pst.setInt(2, x_direccion.getCli_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {   
                x_direccion.setCli_ncodigo(_rs.getInt("dir_ncodigo"));
                return true;
            }
        }
        catch(Exception e)
        {
           // _con.Cerrar();
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
        // _con.Cerrar();
        }
            return  false;
    }
    public Boolean Modificar(EDireccion x_direccion)
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, x_direccion.getDir_cdescripcion());
            pst.setInt(2, x_direccion.getDir_ncodigo());
            int  _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        }
        catch(Exception e)
        {//     _con.Cerrar();
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
        finally
        {//         _con.Cerrar();
        }
        return false;
    }
    public Boolean Eliminar(EDireccion x_direccion)
    {
    
        try{
//           _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, x_direccion.getDir_cdescripcion());
            pst.setInt(2, x_direccion.getCli_ncodigo());
            pst.setInt(3, x_direccion.getDir_ncodigo());
            int  _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        }
        catch(Exception e)
        {//      _con.Cerrar();
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Mensaje",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public List<EDireccion> ObtenerxCliente(Integer x_id)
    {
        List<EDireccion> _lsdireccion = new ArrayList<>();        
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectxcliente);
            pst.setInt(1, x_id);            
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _lsdireccion.add(new EDireccion(_rs.getInt("dir_ncodigo"), _rs.getString("dir_descripcion"),_rs.getInt("cli_ncodigo"),InstancaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {
             _con.Cerrar();
        }
        finally
        {
            _con.Cerrar();
        }
        return _lsdireccion;
    }
    public boolean EliminarxCliente(int x_codigo)
    {
        boolean _f=false;
        try
        {
             _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_deleteOnexCliente);
            pst.setInt(1, x_codigo);
            int  _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                _f= true;
        }
        catch(Exception e)
        {
        }
        return _f;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    public DefaultComboBoxModel ObtenerDireccionxCliente(int x_codigo)
    {
        DefaultComboBoxModel _modelo=null;
        _con= new Conector();
        try {
            _con.Abrir();
            pst=_con.RecibirQuer(_selectxcliente);
            pst.setInt(1, x_codigo);
            Vector _item = new Vector();
            ResultSet _rs = _con.EjecutarQuery(pst);            
            while(_rs.next())
              _item.addElement(new DisplayValue(_rs.getString("dir_descripcion"),_rs.getInt("dir_ncodigo")));
            _modelo= new DefaultComboBoxModel(_item);
        } catch (Exception e) {_con.Cerrar();}finally{_con.Cerrar();}
        
        return _modelo;
    }
    public EDireccion ObtenerDireccionxcodigo(int _codigo) {
        
        EDireccion _edireccion=null;
        try {
             _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnexCodigoDireccion);
            pst.setInt(1, _codigo);
            ResultSet _rs=pst.executeQuery();
            if(_rs.next())
            {
                _edireccion=new EDireccion(_rs.getInt("dir_ncodigo"), _rs.getString("dir_descripcion"), _rs.getInt("cli_ncodigo"), InstancaEntidad.UNCHANGUE);
            }
            
        } catch (Exception e) {
        }
        return _edireccion;
    }
     public boolean VerificarAsignacionDireccion(int x_codigo) {
        boolean _f=false;
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer("select verificarasignaciondireccion_ssf(?)");
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
}

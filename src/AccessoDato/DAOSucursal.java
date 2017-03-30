
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOSucursal implements IOperacion{

    private final String  _insertOne="insert into sucursal(suc_cdireccion,pai_ncodigo,emp_ncodigo,ubi_ncodigo,suc_calias)values(?,?,?,?,?)returning suc_ncodigo;";
    private final String  _updateOne="update sucursal set suc_cdireccion=?,pai_ncodigo=?,emp_ncodigo=?,ubi_ncodigo=?,suc_calias=? where suc_ncodigo=?";
    private final String  _deleteOne="";
    private final String  _selectOne="select * from vdetallesucursal where suc_ncodigo=?";
    private final String  _selectAll="select * from vdetallesucursal";   
    private final String _sellectAllnoasignadas="select* from vdetallesucursalnoasignado";
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        try {
            ESucursal _esucursal=(ESucursal) o;
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _esucursal.getSuc_cdireccion());
            pst.setInt(2, _esucursal.getPai_ncodigo());
            pst.setInt(3, _esucursal.getEmp_ncodigo());
            pst.setInt(4, _esucursal.getUbi_ncodigo());
            pst.setString(5, _esucursal.getSuc_sucdescripcion());
            ResultSet _rs = _con.EjecutarQuery(pst);
                  if(_rs.next())
                        _esucursal.setSuc_ncodigo(_rs.getInt("suc_ncodigo"));
                  return true;
        } catch (Exception e) {
            _con.Cerrar();
        }finally{_con.Cerrar();}
        return false;
    }
    @Override
    public boolean Modificar(Object o) {
        try {
            ESucursal _esucursal=(ESucursal) o;
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, _esucursal.getSuc_cdireccion());
            pst.setInt(2, _esucursal.getPai_ncodigo());
            pst.setInt(3, _esucursal.getEmp_ncodigo());
            pst.setInt(4, _esucursal.getUbi_ncodigo());
            pst.setString(5, _esucursal.getSuc_sucdescripcion());
            pst.setInt(6, _esucursal.getSuc_ncodigo());
            int  _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        } catch (Exception e) {
            _con.Cerrar();
        }
        finally{_con.Cerrar();}
        return false;
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        ESucursal _esucursal=null;
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOne);
            pst.setInt(1, o);
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _esucursal=(new ESucursal(_rs.getInt("suc_ncodigo"), _rs.getString("suc_cdireccion") , _rs.getInt("pai_ncodigo"),_rs.getInt("emp_ncodigo"), _rs.getInt("ubi_ncodigo"),_rs.getString("suc_calias"),_rs.getString("ubi_cdepartamento"),_rs.getString("ubi_cprovincia"),_rs.getString("ubi_cdistrito"),_rs.getString("ubi_ccoddistri"),_rs.getString("ubi_ccoddepa"),_rs.getString("ubi_codpro"),_rs.getString("pai_cnombre"),InstanciaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _esucursal;
    }

    @Override
    public List<ESucursal> ObtenerTodos() {
        
        List<ESucursal> _lssucursal= new ArrayList<>();
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lssucursal.add(new ESucursal(_rs.getInt("suc_ncodigo"), _rs.getString("suc_cdireccion") , _rs.getInt("pai_ncodigo"),_rs.getInt("emp_ncodigo"), _rs.getInt("ubi_ncodigo"),_rs.getString("suc_calias"),_rs.getString("ubi_cdepartamento"),_rs.getString("ubi_cprovincia"),_rs.getString("ubi_cdistrito"),_rs.getString("ubi_ccoddistri"),_rs.getString("ubi_ccoddepa"),_rs.getString("ubi_codpro"),_rs.getString("pai_cnombre"),InstanciaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lssucursal;
    }
    
    public List<ESucursal> ObtenerTodosNoAsignado() {
        
        List<ESucursal> _lssucursal= new ArrayList<>();
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_sellectAllnoasignadas);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lssucursal.add(new ESucursal(_rs.getInt("suc_ncodigo"), _rs.getString("suc_cdireccion") , _rs.getInt("pai_ncodigo"),_rs.getInt("emp_ncodigo"), _rs.getInt("ubi_ncodigo"),_rs.getString("suc_calias"),_rs.getString("ubi_cdepartamento"),_rs.getString("ubi_cprovincia"),_rs.getString("ubi_cdistrito"),_rs.getString("ubi_ccoddistri"),_rs.getString("ubi_ccoddepa"),_rs.getString("ubi_codpro"),_rs.getString("pai_cnombre"),InstanciaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lssucursal;
    }
    
}

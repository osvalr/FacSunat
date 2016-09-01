
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstancaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOVendedor implements IOperacion{

    private final String  _insertOne="insert into vendedor(ven_nombres,ven_cpaterno,ven_materno,doi_ccodigo,ven_cnumero) values(?,?,?,?,?) returning ven_ncodigo;";
    private final String  _updateOne="update vendedor set ven_nombres=?,ven_cpaterno=?,ven_materno=?,doi_ccodigo=?,ven_cnumero=? where ven_ncodigo=?";
    private final String  _deleteOne="";
    private final String  _selectOne="select * from vvendedor where ven_ncodigo=?";//"select  * from parametro where par_ncodigo=?";
    private final String  _selectAll="select * from vvendedor"; 
    ////////////////////////////////////////////////////////
    private final String  _selectAllVendedores="select  * from vendedor";
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        try {
            _con= new Conector();
            _con.Abrir();
            EVendedor _evendedor=(EVendedor) o;
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _evendedor.getVen_nombres());
            pst.setString(2, _evendedor.getVen_cpaterno());
            pst.setString(3, _evendedor.getVen_materno());
            pst.setString(4, _evendedor.getDoi_ccodigo());
            pst.setString(5, _evendedor.getVen_cnumero());
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _evendedor.setVen_ncodigo(_rs.getInt("ven_ncodigo"));
             return true;
        } catch (Exception e) {
            e.printStackTrace();
             _con.Cerrar();
        }finally{ _con.Cerrar();}
       
        return false;
    }

    @Override
    public boolean Modificar(Object o) {
        try {
            _con= new Conector();
            _con.Abrir();
            EVendedor _evendedor=(EVendedor) o;
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, _evendedor.getVen_nombres());
            pst.setString(2, _evendedor.getVen_cpaterno());
            pst.setString(3, _evendedor.getVen_materno());
            pst.setString(4, _evendedor.getDoi_ccodigo());
            pst.setString(5, _evendedor.getVen_cnumero());
            pst.setInt(6, _evendedor.getVen_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                return true;
        } catch (Exception e) {
             _con.Cerrar();
        }
        finally{
        _con.Cerrar();}
        return false;
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        
        EVendedor _evendedor =null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOne);
            pst.setInt(1, o);
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 _evendedor=(new EVendedor(_rs.getInt("ven_ncodigo"),_rs.getString("ven_nombres"),_rs.getString("ven_cpaterno"),_rs.getString("ven_materno"),_rs.getString("doi_ccodigo"),_rs.getString("ven_cnumero"),_rs.getString("doc_cdescripcion"),InstancaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        
        return _evendedor;
    }

    @Override
    public List<EVendedor> ObtenerTodos() {
        List<EVendedor> _lsvendedor = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                 _lsvendedor.add(new EVendedor(_rs.getInt("ven_ncodigo"),_rs.getString("ven_nombres"),_rs.getString("ven_cpaterno"),_rs.getString("ven_materno"),_rs.getString("doi_ccodigo"),_rs.getString("ven_cnumero"),_rs.getString("doc_cdescripcion"),InstancaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lsvendedor;
    }
    public List<EVendedor> ObtenerTodosxSucursal() {
        
        List<EVendedor> _lsvendedor = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllVendedores);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                 _lsvendedor.add(new EVendedor(_rs.getInt("ven_ncodigo"),_rs.getString("ven_nombres"),_rs.getString("ven_cpaterno"),_rs.getString("ven_materno"),_rs.getString("doi_ccodigo"),_rs.getString("ven_cnumero"),_rs.getString("doc_cdescripcion"),InstancaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lsvendedor;
    }
    
}

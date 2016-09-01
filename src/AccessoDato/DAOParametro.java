
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOParametro implements IOperacion{
    private final String  _insertOne="insert into parametro(par_cmoneda,par_nsucursal,par_cestado,par_ntipocambio,par_nvendedor,par_dfecha)\n" +
                                     "values(?,?,?,?,?,?) returning par_ncodigo";
    private final String  _updateOne="update parametro set par_cmoneda=?,par_nsucursal=?,par_cestado=?,par_ntipocambio=?,par_nvendedor=?,par_dfecha=?\n" +
                                     "where par_ncodigo=? ";
    private final String  _deleteOne="";
    private final String  _selectOne="select  * from parametro where par_nsucursal=?";
    private final String  _selectAllxTipoDocumennto="select p.par_ncodigo,p.par_cmoneda,p.par_nsucursal,p.par_cestado,n.num_cserie as par_cserie,p.par_ntipocambio,p.par_nvendedor,n.num_cnumero as par_cnumero,n.num_ncodigo,p.par_dfecha from parametro p\n" +
                                                    "inner join numero n on n.par_ncodigo=p.par_ncodigo where n.doc_ccodigo=? and p.par_nsucursal=?"; 
    private final String _selectAll="select * from vparametrocabecera";
    private final String _selectAllxId="select * from vparametrocabecera where par_ncodigo=?";
    private Conector _con;
    private String tipoDocumento; 
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        try {
            EParametro _parametro=(EParametro) o;
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _parametro.getPar_cmoneda());
            pst.setInt(2, _parametro.getPar_nsucursal());
            pst.setString(3, _parametro.getPar_cestado());
            pst.setFloat(4, _parametro.getPar_ntipocambio());
            pst.setInt(5, _parametro.getPar_nvendedor());
            pst.setDate(6, _parametro.getPar_dfecha());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                _parametro.setPar_ncodigo(_rs.getInt("par_ncodigo"));
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    @Override
    public boolean Modificar(Object o) {
        try {
            EParametro _parametro=(EParametro) o;
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, _parametro.getPar_cmoneda());
            pst.setInt(2, _parametro.getPar_nsucursal());
            pst.setString(3, _parametro.getPar_cestado());
            pst.setFloat(4, _parametro.getPar_ntipocambio());
            pst.setInt(5, _parametro.getPar_nvendedor());
            pst.setDate(6, _parametro.getPar_dfecha());
            pst.setInt(7, _parametro.getPar_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        } catch (Exception e) {
        }
        return false;
    }
    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        EParametro _para=null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllxTipoDocumennto);
            pst.setString(1, tipoDocumento);
            pst.setInt(2, o);
            ResultSet _rs = pst.executeQuery();            
            if(_rs.next())
                _para=new EParametro( _rs.getInt("par_ncodigo"),_rs.getString("par_cmoneda"),_rs.getInt("par_nsucursal"),_rs.getString("par_cestado"),_rs.getString("par_cserie"),_rs.getFloat("par_ntipocambio"),_rs.getInt("par_nvendedor"),_rs.getString("par_cnumero"),_rs.getInt("num_ncodigo"),_rs.getDate("par_dfecha"));
        }
        catch(Exception e)
        {     _con.Cerrar();     }
        finally
        {    _con.Cerrar();      }
        return _para;
    }

    @Override
    public List<EParametro> ObtenerTodos() {
        List<EParametro> _lsparametro = new ArrayList<>();
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();            
            while(_rs.next())
                _lsparametro.add(new EParametro( _rs.getInt("par_ncodigo"),_rs.getString("par_cmoneda"),_rs.getInt("par_nsucursal"),_rs.getString("par_cestado"),_rs.getFloat("par_ntipocambio"),_rs.getInt("par_nvendedor"),_rs.getString("suc_calias"),_rs.getString("nombres"),_rs.getString("suc_cdireccion"),_rs.getString("mon_csimbolo")));
        } catch (Exception e) {
            _con.Cerrar();
        }
        finally{_con.Cerrar();}
        return _lsparametro;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    public EParametro ObtenerUnoxIdParametro(int o) {
        EParametro _para=null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllxId);
            pst.setInt(1, o);
            ResultSet _rs = pst.executeQuery();            
            if(_rs.next())
                _para=new EParametro( _rs.getInt("par_ncodigo"),_rs.getString("par_cmoneda"),_rs.getInt("par_nsucursal"),_rs.getString("par_cestado"),"",_rs.getFloat("par_ntipocambio"),_rs.getInt("par_nvendedor"),"",0,_rs.getDate("par_dfecha"));
        }
        catch(Exception e)
        { _con.Cerrar();    }
        finally
        {  _con.Cerrar();   }
        return _para;
    }
    
    
}
